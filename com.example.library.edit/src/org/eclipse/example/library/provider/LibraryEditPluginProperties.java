/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.example.library.provider;

import com.google.gwt.i18n.client.Messages;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public interface LibraryEditPluginProperties extends Messages {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text")
	@DefaultMessage("{0}")
	String createChildText(Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text2")
	@DefaultMessage("{1} {0}")
	String createChildText2(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text3")
	@DefaultMessage("{0}")
	String createChildText3(Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_tooltip")
	@DefaultMessage("Create New {0} Under {1} Feature")
	String createChildTooltip(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_description")
	@DefaultMessage("Create a new child of type {0} for the {1} feature of the selected {2}.")
	String createChildDescripition(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateSibling_description")
	@DefaultMessage("Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent.")
	String createSiblingDescription(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_PropertyDescriptor_description")
	@DefaultMessage("The {0} of the {1}")
	String propertyDescriptorDescription(Object feature, Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Book_type")
	@DefaultMessage("Book")
	String bookType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Library_type")
	@DefaultMessage("Library")
	String libraryType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Writer_type")
	@DefaultMessage("Writer")
	String writerType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_type")
	@DefaultMessage("Object")
	String unknownType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_datatype")
	@DefaultMessage("Value")
	String unknownDatatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Book_title_feature")
	@DefaultMessage("Title")
	String book_TitleFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Book_pages_feature")
	@DefaultMessage("Pages")
	String book_PagesFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Book_category_feature")
	@DefaultMessage("Category")
	String book_CategoryFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Book_author_feature")
	@DefaultMessage("Author")
	String book_AuthorFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Library_name_feature")
	@DefaultMessage("Name")
	String library_NameFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Library_writers_feature")
	@DefaultMessage("Writers")
	String library_WritersFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Library_books_feature")
	@DefaultMessage("Books")
	String library_BooksFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Writer_name_feature")
	@DefaultMessage("Name")
	String writer_NameFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Writer_books_feature")
	@DefaultMessage("Books")
	String writer_BooksFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_feature")
	@DefaultMessage("Unspecified")
	String unknownFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_BookCategory_Mystery_literal")
	@DefaultMessage("Mystery")
	String bookCategory_MysteryLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_BookCategory_ScienceFiction_literal")
	@DefaultMessage("ScienceFiction")
	String bookCategory_ScienceFictionLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_BookCategory_Biography_literal")
	@DefaultMessage("Biography")
	String bookCategory_BiographyLiteral();

}
