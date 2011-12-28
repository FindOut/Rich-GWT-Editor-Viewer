/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.example.library.provider;

import com.google.gwt.core.client.GWT;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Library edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class LibraryEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LibraryEditPlugin INSTANCE = new LibraryEditPlugin();

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEditPlugin() {
		super
		  (new ResourceLocator [] {
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final LibraryEditPluginProperties PROPERTIES = GWT.create(LibraryEditPluginProperties.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, boolean translate) {
		if ("_UI_Book_type".equals(key)) return PROPERTIES.bookType();
		else if ("_UI_Library_type".equals(key)) return PROPERTIES.libraryType();
		else if ("_UI_Writer_type".equals(key)) return PROPERTIES.writerType();
		else  if ("_UI_Unknown_type".equals(key)) return PROPERTIES.unknownType();
		else if ("_UI_Unknown_datatype".equals(key)) return PROPERTIES.unknownDatatype();
		else if ("_UI_Book_title_feature".equals(key)) return PROPERTIES.book_TitleFeature();
		else if ("_UI_Book_pages_feature".equals(key)) return PROPERTIES.book_PagesFeature();
		else if ("_UI_Book_category_feature".equals(key)) return PROPERTIES.book_CategoryFeature();
		else if ("_UI_Book_author_feature".equals(key)) return PROPERTIES.book_AuthorFeature();
		else if ("_UI_Library_name_feature".equals(key)) return PROPERTIES.library_NameFeature();
		else if ("_UI_Library_writers_feature".equals(key)) return PROPERTIES.library_WritersFeature();
		else if ("_UI_Library_books_feature".equals(key)) return PROPERTIES.library_BooksFeature();
		else if ("_UI_Writer_name_feature".equals(key)) return PROPERTIES.writer_NameFeature();
		else if ("_UI_Writer_books_feature".equals(key)) return PROPERTIES.writer_BooksFeature();
		else if ("_UI_Unknown_feature".equals(key)) return PROPERTIES.unknownFeature();
		else if ("_UI_BookCategory_Mystery_literal".equals(key)) return PROPERTIES.bookCategory_MysteryLiteral();
		else if ("_UI_BookCategory_ScienceFiction_literal".equals(key)) return PROPERTIES.bookCategory_ScienceFictionLiteral();
		else if ("_UI_BookCategory_Biography_literal".equals(key)) return PROPERTIES.bookCategory_BiographyLiteral();
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, Object [] substitutions, boolean translate) {
		if ("_UI_CreateChild_text".equals(key)) return PROPERTIES.createChildText(substitutions[0]);
		else if ("_UI_CreateChild_text2".equals(key)) return PROPERTIES.createChildText2(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_text3".equals(key)) return PROPERTIES.createChildText3(substitutions[1]);
		else if ("_UI_CreateChild_tooltip".equals(key)) return PROPERTIES.createChildTooltip(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_description".equals(key)) return PROPERTIES.createChildDescripition(substitutions[0], substitutions[1], substitutions[2]);
		else if ("_UI_CreateSibling_description".equals(key)) return PROPERTIES.createSiblingDescription(substitutions[0], substitutions[1], substitutions[2]);
		if ("_UI_PropertyDescriptor_description".equals(key)) return PROPERTIES.propertyDescriptorDescription(substitutions[0], substitutions[1]);
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final LibraryEditPluginImages IMAGES = GWT.create(LibraryEditPluginImages.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(String key) {
		if ("full/obj16/Book".equals(key)) return IMAGES.book();
		else if ("full/obj16/Library".equals(key)) return IMAGES.library();
		else if ("full/obj16/Writer".equals(key)) return IMAGES.writer();
		else return key;
	}

}
