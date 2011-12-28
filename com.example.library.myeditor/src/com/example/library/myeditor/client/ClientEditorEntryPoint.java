package com.example.library.myeditor.client;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.example.library.LibraryPackage;
import org.eclipse.example.library.provider.LibraryItemProviderAdapterFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class ClientEditorEntryPoint implements EntryPoint {
	
	// The EMF editing domain
	private AdapterFactoryEditingDomain editingDomain;

	@Override
	public void onModuleLoad() {
		initializeEditingDomain();
		
		// Add the panel to the DOM
		RootLayoutPanel.get().add(new ClientEditor(editingDomain));

	}

	private void initializeEditingDomain() {
	    ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory();
	    composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
	    composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	    configureItemProviderAdapterFactories(composedAdapterFactory);

	    final BasicCommandStack commandStack = new BasicCommandStack();
	    editingDomain = new AdapterFactoryEditingDomain(composedAdapterFactory, commandStack);

	    final ResourceSet resourceSet = editingDomain.getResourceSet();
	    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
	      (Resource.Factory.Registry.DEFAULT_EXTENSION,
	       new ResourceFactoryImpl()
	       {
	         @Override
	         public Resource createResource(URI uri)
	         {
	           return new BinaryResourceImpl(uri);
	         }
	       });
	    
	    registerPackages(resourceSet.getPackageRegistry());

	}

	/**
	 * Configure the generated EMF model's item provider adapter factory
	 * @param adapterFactory the EMF adapter factory
	 */
	protected void configureItemProviderAdapterFactories(ComposedAdapterFactory adapterFactory) {
		adapterFactory.addAdapterFactory(new LibraryItemProviderAdapterFactory());
	}
	
	/**
	 * Register the generated EMF model's package
	 * @param packageRegistry the EMF package registry
	 */
	private void registerPackages(Registry packageRegistry) {
		packageRegistry.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
	}
}
