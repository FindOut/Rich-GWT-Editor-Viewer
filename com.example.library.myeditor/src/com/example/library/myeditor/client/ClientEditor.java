package com.example.library.myeditor.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.EditorEntryPoint.ImageData;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.hydro4ge.raphaelgwt.client.PathBuilder;
import com.hydro4ge.raphaelgwt.client.Raphael.Path;

public class ClientEditor extends Composite implements HasText {

  private static final String GRIDLINE_COLOR = "#e0e0ff";
  @UiField
  DockLayoutPanel mainPanel;
  @UiField
  FlowPanel headerPanel;
  @UiField
  Label header;
  @UiField
  DockLayoutPanel bodyPanel;
  @UiField
  FlowPanel toolBar;
  @UiField
  SplitLayoutPanel contentPanel;
  @UiField
  ScrollPanel treeScrollPanel;
  @UiField
  DockLayoutPanel canvasPanel;
  @UiField
  Button createButton;
  @UiField
  CanvasWidget canvas;
  @UiField(provided = true)
  CellTree modelTree;
  @UiField FlowPanel propertiesPanel;

  /**
   * The message displayed to the user when the server cannot be reached or returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


  interface ClientEditorUiBinder extends UiBinder<Widget, ClientEditor> {
  }
  private static ClientEditorUiBinder uiBinder = GWT.create(ClientEditorUiBinder.class);

  private final SingleSelectionModel<Object> treeSelection;
  private final Collection<Runnable> propertyUpdater;
 
  // The EMF editing domain
  private AdapterFactoryEditingDomain editingDomain;

  /**
   * The constructor for the client editor
   * 
   * @param editingDomain the EMF editing domain
   */
  public ClientEditor(final AdapterFactoryEditingDomain editingDomain) {
    treeSelection = new SingleSelectionModel<Object>();
    propertyUpdater = new HashSet<Runnable>();
    
    this.editingDomain = editingDomain;
    
    final ResourceSet resourceSet = editingDomain.getResourceSet();
    final Resource resource = resourceSet.createResource(URI.createURI("/modelA"));
    AdapterFactoryItemDelegator itemDelegator = new AdapterFactoryItemDelegator(editingDomain.getAdapterFactory());
    TreeViewModel treeViewModel = createTreeViewModel(resourceSet, itemDelegator);
    modelTree =
        new NavigatorCellTree(treeViewModel, new ItemProvider(Collections.singleton(resource)));

    greetingService.greetServer("test", new AsyncCallback<byte[]>() {
      @Override
      public void onSuccess(byte[] result) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result);
        try {
          resource.load(byteArrayInputStream, null);
        } catch (IOException e) {
          // Never happens with a stream backed by a byte[]
        }
      }

      @Override
      public void onFailure(Throwable caught) {
        // TODO Auto-generated method stub
      }
    });

    initWidget(uiBinder.createAndBindUi(this));

    final RichTextArea textArea = new RichTextArea();
    textArea.setSize("100%", "100%");
    final RichTextToolbar toolBar = new RichTextToolbar(textArea);
    propertiesPanel.add(toolBar);
    propertiesPanel.add(textArea);

    Window.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {
        canvas.resizeToParent();
      }
    });
  }

  public void setText(String text) {
    // button.setText(text);
  }

  public String getText() {
    return "";
    // return button.getText();
  }

  @UiHandler("createButton")
  void onCreateButtonClick(ClickEvent event) {
    for (int i = 0; i < canvas.getOffsetWidth(); i += 10) {
      PathBuilder pathBuilder = new PathBuilder();
      pathBuilder.M(i, 0).l(0, canvas.getOffsetHeight());
      if (i % 50 == 0) {
        canvas.new Path(pathBuilder).attr("stroke", GRIDLINE_COLOR).attr("stroke-width", "1");
      } else {
        canvas.new Path(pathBuilder).attr("stroke", GRIDLINE_COLOR).attr("stroke-width", "0.5");
      }
    }
    for (int i = 0; i < canvas.getOffsetHeight(); i += 10) {
      PathBuilder pathBuilder = new PathBuilder();
      pathBuilder.M(0, i).l(canvas.getOffsetWidth(), 0);
      if (i % 50 == 0) {
        canvas.new Path(pathBuilder).attr("stroke", GRIDLINE_COLOR).attr("stroke-width", "1");
      } else {
        canvas.new Path(pathBuilder).attr("stroke", GRIDLINE_COLOR).attr("stroke-width", "0.5");
      }
    }

    PathBuilder pathBuilder = new PathBuilder();
    pathBuilder.M(100, 100).l(85, 0).l(15, -25).l(-15, -25).l(-85, 0).l(15, 25).z();
    Path path = canvas.new Path(pathBuilder);
    path.attr("stroke", "#FF8000").attr("fill", "90-#ffffff-#c9e6fc");
    path.drag(new PathDragCallback(path));
  }

  @UiHandler("canvas")
  void onCanvasAttachOrDetach(AttachEvent event) {
    if (event.isAttached()) {
      GWT.log("Canvas attached");
      canvas.resizeToParent();
    }
  }

  private TreeViewModel createTreeViewModel(final ResourceSet resourceSet,
      final AdapterFactoryItemDelegator itemDelegator) {
    return new TreeViewModel() {
      public <T> NodeInfo<?> getNodeInfo(final T value) {
        final ListDataProvider<Object> abstractListViewAdapter = new ListDataProvider<Object>() {
          int size;

          class NodeAdapter extends AdapterImpl implements INotifyChangedListener {
            Set<Object> children = new HashSet<Object>();

            @Override
            public void notifyChanged(Notification msg) {
              if (msg.getEventType() != Notification.REMOVING_ADAPTER) {
                update();
                if (!(msg.getNotifier() instanceof EObject)) {
                  for (Runnable runnable : propertyUpdater) {
                    runnable.run();
                  }
                }
              }
            }

            public void listenTo(Object target) {
              if (target instanceof Notifier) {
                ((Notifier) target).eAdapters().add(this);
              } else if (target instanceof IChangeNotifier) {
                ((IChangeNotifier) target).addListener(this);
              }
            }

            public void stopListeningTo(Object target) {
              if (target instanceof Notifier) {
                ((Notifier) target).eAdapters().remove(this);
              } else if (target instanceof IChangeNotifier) {
                ((IChangeNotifier) target).removeListener(this);
              }
            }

            public void listenTo(List<Object> children) {
              // TODO
              // I don't know how to update just one child. :-(

              boolean isListeningToValue = !this.children.isEmpty();
              Set<Object> oldChildren = new HashSet<Object>(this.children);
              for (Object child : children) {
                if (this.children.contains(child)) {
                  oldChildren.remove(child);
                } else {
                  this.children.add(child);
                  listenTo(child);
                }
              }
              for (Object child : oldChildren) {
                stopListeningTo(child);
                this.children.remove(child);
              }
              if (isListeningToValue) {
                if (children.isEmpty()) {
                  stopListeningTo(value);
                }
              } else if (!children.isEmpty()) {
                listenTo(value);
              }
            }
          }

          protected NodeAdapter nodeAdapter = new NodeAdapter();

          @Override
          protected void onRangeChanged(HasData<Object> display) {
            if (value instanceof Resource) {
              Resource resource = (Resource) value;
              if (!resource.isLoaded()) {
                try {
                  resource.load(resourceSet.getLoadOptions());
                } catch (IOException e) {
                  // Ignore.
                }
              }
            }
            update();
          }

          protected void update() {
            Collection<?> children = itemDelegator.getChildren(value);
            ArrayList<Object> childrenList = new ArrayList<Object>(children);
            nodeAdapter.listenTo(childrenList);
            int size = children.size();
            if (this.size < size) {
              updateRowCount(size, true);
              this.size = size;
            } else {
              // Pad with dummy objects.
              for (int i = size; i < this.size; ++i) {
                childrenList.add(new Object());
              }
            }
            updateRowData(0, childrenList);
            if (this.size > size) {
              updateRowCount(size, true);
              this.size = size;
            }
          }
        };

        Cell<Object> cell = new AbstractCell<Object>() {
          @Override
          public void render(Context context, Object value, SafeHtmlBuilder safeHtmlBuilder) {
            StringBuilder sb = new StringBuilder();
            Object image = itemDelegator.getImage(value);
            if (image instanceof ImageResource) {
              ImageResource imageResource = (ImageResource) image;
              sb.append("<div style='position:relative;padding-left:");
              sb.append(imageResource.getWidth());
              sb.append("px;'>");
              sb.append("<div style=\"position:absolute;left:0px;top:0px;height:100%;");
              sb.append("width:").append(imageResource.getWidth()).append("px;");
              sb.append("background:url('").append(imageResource.getURL()).append("') ");
              sb.append("no-repeat scroll center center transparent;");
              sb.append("\"></div>");
              sb.append(itemDelegator.getText(value));
              sb.append("</div>");
            } else if (image instanceof ComposedImage) {
              ComposedImage composedImage = (ComposedImage) image;
              List<ComposedImage.Size> sizes = new ArrayList<ComposedImage.Size>();
              List<Object> images = new ArrayList<Object>(composedImage.getImages());
              List<ImageData> nestedImagesData = new ArrayList<ImageData>();
              for (Object nestedImage : images) {
                ImageData nestedImageData = getImageData(nestedImage);
                ComposedImage.Size size = new ComposedImage.Size();
                size.height = nestedImageData.height;
                size.width = nestedImageData.width;
                sizes.add(size);
                nestedImagesData.add(nestedImageData);
              }
              ComposedImage.Size size = composedImage.getSize(sizes);
              sb.append("<div style='position:relative;padding-left:");
              sb.append(size.width);
              sb.append("px;'>");
              List<ComposedImage.Point> drawPoints = composedImage.getDrawPoints(size);
              int i = 0;
              for (ComposedImage.Point drawPoint : drawPoints) {
                ImageResource nestedImage = (ImageResource) images.get(i++);
                sb.append("<div style=\"position:absolute;left:").append(drawPoint.x).append(
                    "px;top:").append(drawPoint.y).append("px;height:100%;");
                sb.append("width:").append(nestedImage.getWidth()).append("px;");
                sb.append("background:url('").append(nestedImage.getURL()).append("') ");
                sb.append("no-repeat scroll center center transparent;");
                sb.append("\"></div>");
              }
              sb.append(itemDelegator.getText(value));
              sb.append("</div>");
            } else {
              sb.append(itemDelegator.getText(value));
            }
            safeHtmlBuilder.appendHtmlConstant(sb.toString());
          }
        };
        return new DefaultNodeInfo<Object>(abstractListViewAdapter, cell, treeSelection, null);
      }

      public boolean isLeaf(Object value) {
        return !itemDelegator.hasChildren(value);
      }
    };
  }

  protected ImageData getImageData(Object image) {
    ImageData imageData = new ImageData();
    if (image instanceof ImageResource) {
      ImageResource imageResource = (ImageResource) image;
      imageData.height = imageResource.getHeight();
      imageData.width = imageResource.getWidth();
    } else if (image instanceof ComposedImage) {
      ComposedImage composedImage = (ComposedImage) image;
      List<ComposedImage.Size> sizes = new ArrayList<ComposedImage.Size>();
      List<Object> images = new ArrayList<Object>(composedImage.getImages());
      List<ImageData> nestedImagesData = new ArrayList<ImageData>();
      for (Object nestedImage : images) {
        ImageData nestedImageData = getImageData(nestedImage);
        ComposedImage.Size size = new ComposedImage.Size();
        size.height = nestedImageData.height;
        size.width = nestedImageData.width;
        sizes.add(size);
        nestedImagesData.add(nestedImageData);
      }
    }
    return imageData;
  }
}
