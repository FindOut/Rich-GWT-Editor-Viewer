package com.example.library.myeditor.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.hydro4ge.raphaelgwt.client.Raphael;

/**
 */
public final class CanvasWidget extends Raphael implements RequiresResize, ProvidesResize {

	// Parent container for all SVG/VML:
//	private DrawingArea drawingArea;

	public CanvasWidget() {
		super(100, 100);

		// Attach a DrawingArea inside the clipping area (used for vector
		// rendering):
//		drawingArea = new DrawingArea(100, 100);
//		add(drawingArea, 0, 0);

		// // Firefox and Chrome allow for DnD of images. This default behavior
		// is not wanted.
		// addMouseDownHandler(new MouseDownHandler() {
		//
		// public void onMouseDown(MouseDownEvent event) {
		// event.preventDefault();
		// }
		// });
		// addMouseMoveHandler(new MouseMoveHandler() {
		//
		// public void onMouseMove(MouseMoveEvent event) {
		// event.preventDefault();
		// }
		// });

		// // We don't want scrolling on the page and zooming at the same time.
		// // TODO: make this optional. When no zoom on scroll is used,
		// scrolling the page should be possible.
		// addMouseWheelHandler(new MouseWheelHandler() {
		//
		// public void onMouseWheel(MouseWheelEvent event) {
		// event.preventDefault();
		// }
		// });
	}

	public void resizeToParent() {

		// let GWT do a bunch of other resizing before
		// doing this widget
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				int w = getParent().getOffsetWidth();
				int h = getParent().getOffsetHeight();
				GWT.log("resizeToParent: w-" + w + " h-" + h);
        setSize(w, h);
			}
		});
	}

	public void onResize() {
//		for (Widget child : getChildren()) {
//			if (child instanceof RequiresResize) {
//				((RequiresResize) child).onResize();
//			}
//		}
		if (getParent() != null) {
			int pw = getParent().getOffsetWidth();
			int ph = getParent().getOffsetHeight();
			GWT.log("onResize: w-" + pw + " h-" + ph);

			resizeToParent();
		}
	}

	/**
	 * @return the drawingArea
	 */
//	public DrawingArea getDrawingArea() {
//		return drawingArea;
//	}

	// ------------------------------------------------------------------------
	// Overriding resize methods:
	// ------------------------------------------------------------------------

//	public void setPixelSize(int width, int height) {
//		drawingArea.setWidth(width);
//		drawingArea.setHeight(height);
//		super.setPixelSize(width, height);
//	}
//
//	public void setSize(String width, String height) {
//		drawingArea.setWidth(width);
//		drawingArea.setHeight(height);
//		super.setSize(width, height);
//	}
//
//	public void setWidth(String width) {
//		drawingArea.setWidth(width);
//		super.setWidth(width);
//	}
//
//	public void setHeight(String height) {
//		drawingArea.setHeight(height);
//		super.setHeight(height);
//	}

	// ------------------------------------------------------------------------
	// Add mouse event catch methods:
	// ------------------------------------------------------------------------


}