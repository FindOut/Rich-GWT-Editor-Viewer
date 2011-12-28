/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.example.library.presentation;

import org.eclipse.emf.edit.ui.EditorEntryPoint;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import org.eclipse.example.library.LibraryPackage;

import org.eclipse.example.library.provider.LibraryItemProviderAdapterFactory;

/**
 * This is the entry point.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryEditorEntryPoint extends EditorEntryPoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void registerPackages(EPackage.Registry packageRegistry) {
		packageRegistry.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void configureItemProviderAdapterFactories(ComposedAdapterFactory adapterFactory) {
		adapterFactory.addAdapterFactory(new LibraryItemProviderAdapterFactory());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected String getApplicationTitle() {
		return "Library Application";
	}
}
