/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.example.library.impl;

import com.google.gwt.user.client.rpc.IsSerializable;

import org.eclipse.emf.common.util.Reflect;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.example.library.Book;
import org.eclipse.example.library.BookCategory;
import org.eclipse.example.library.Library;
import org.eclipse.example.library.LibraryFactory;
import org.eclipse.example.library.LibraryPackage;
import org.eclipse.example.library.Writer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryPackageImpl extends EPackageImpl implements LibraryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bookEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bookCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bookCategoryObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.example.library.LibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LibraryPackageImpl() {
		super(eNS_URI, LibraryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LibraryPackage init() {
		if (isInited) return (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);

		initializeRegistryHelpers();

		// Obtain or create and register package
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LibraryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, theLibraryPackage);
		return theLibraryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void initializeRegistryHelpers() {
		Reflect.register
			(Book.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof Book;
				 }

				 public Object newArrayInstance(int size) {
					 return new Book[size];
				 }
			 });
		Reflect.register
			(Library.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof Library;
				 }

				 public Object newArrayInstance(int size) {
					 return new Library[size];
				 }
			 });
		Reflect.register
			(Writer.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof Writer;
				 }

				 public Object newArrayInstance(int size) {
					 return new Writer[size];
				 }
			 });
		Reflect.register
			(BookCategory.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof BookCategory;
				 }

				 public Object newArrayInstance(int size) {
					 return new BookCategory[size];
				 }
		});
		Reflect.register
			(BookCategory.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof BookCategory;
				 }

				 public Object newArrayInstance(int size) {
					 return new BookCategory[size];
				 }
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class WhiteList implements IsSerializable, EBasicWhiteList {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Book book;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Library library;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Writer writer;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected BookCategory bookCategory;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected BookCategory bookCategoryObject;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBook() {
		return bookEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBook_Title() {
		return (EAttribute)bookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBook_Pages() {
		return (EAttribute)bookEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBook_Category() {
		return (EAttribute)bookEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBook_Author() {
		return (EReference)bookEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibrary_Name() {
		return (EAttribute)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Writers() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Books() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriter() {
		return writerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriter_Name() {
		return (EAttribute)writerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriter_Books() {
		return (EReference)writerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBookCategory() {
		return bookCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBookCategoryObject() {
		return bookCategoryObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryFactory getLibraryFactory() {
		return (LibraryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bookEClass = createEClass(BOOK);
		createEAttribute(bookEClass, BOOK__TITLE);
		createEAttribute(bookEClass, BOOK__PAGES);
		createEAttribute(bookEClass, BOOK__CATEGORY);
		createEReference(bookEClass, BOOK__AUTHOR);

		libraryEClass = createEClass(LIBRARY);
		createEAttribute(libraryEClass, LIBRARY__NAME);
		createEReference(libraryEClass, LIBRARY__WRITERS);
		createEReference(libraryEClass, LIBRARY__BOOKS);

		writerEClass = createEClass(WRITER);
		createEAttribute(writerEClass, WRITER__NAME);
		createEReference(writerEClass, WRITER__BOOKS);

		// Create enums
		bookCategoryEEnum = createEEnum(BOOK_CATEGORY);

		// Create data types
		bookCategoryObjectEDataType = createEDataType(BOOK_CATEGORY_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(bookEClass, Book.class, "Book", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBook_Title(), theXMLTypePackage.getString(), "title", null, 1, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBook_Pages(), theXMLTypePackage.getInt(), "pages", null, 1, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBook_Category(), this.getBookCategory(), "category", null, 1, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBook_Author(), this.getWriter(), this.getWriter_Books(), "author", null, 1, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibrary_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Writers(), this.getWriter(), null, "writers", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Books(), this.getBook(), null, "books", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writerEClass, Writer.class, "Writer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWriter_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Writer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWriter_Books(), this.getBook(), this.getBook_Author(), "books", null, 0, -1, Writer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(bookCategoryEEnum, BookCategory.class, "BookCategory");
		addEEnumLiteral(bookCategoryEEnum, BookCategory.MYSTERY);
		addEEnumLiteral(bookCategoryEEnum, BookCategory.SCIENCE_FICTION);
		addEEnumLiteral(bookCategoryEEnum, BookCategory.BIOGRAPHY);

		// Initialize data types
		initEDataType(bookCategoryObjectEDataType, BookCategory.class, "BookCategoryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (bookEClass, 
		   source, 
		   new String[] {
			 "name", "Book",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBook_Title(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "title"
		   });		
		addAnnotation
		  (getBook_Pages(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pages"
		   });		
		addAnnotation
		  (getBook_Category(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "category"
		   });		
		addAnnotation
		  (getBook_Author(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "author"
		   });		
		addAnnotation
		  (bookCategoryEEnum, 
		   source, 
		   new String[] {
			 "name", "BookCategory"
		   });		
		addAnnotation
		  (bookCategoryObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "BookCategory:Object",
			 "baseType", "BookCategory"
		   });		
		addAnnotation
		  (libraryEClass, 
		   source, 
		   new String[] {
			 "name", "Library",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLibrary_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (getLibrary_Writers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "writers"
		   });		
		addAnnotation
		  (getLibrary_Books(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "books"
		   });		
		addAnnotation
		  (writerEClass, 
		   source, 
		   new String[] {
			 "name", "Writer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getWriter_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (getWriter_Books(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "books"
		   });
	}

} //LibraryPackageImpl
