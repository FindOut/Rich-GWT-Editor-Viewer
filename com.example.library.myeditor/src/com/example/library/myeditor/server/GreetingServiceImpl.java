package com.example.library.myeditor.server;

import java.io.IOException;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.example.library.Book;
import org.eclipse.example.library.Library;
import org.eclipse.example.library.LibraryFactory;
import org.eclipse.example.library.LibraryPackage;
import org.eclipse.example.library.Writer;

import com.example.library.myeditor.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public byte[] greetServer(String input) throws IllegalArgumentException {

    // Initialize the Library package
    @SuppressWarnings("unused")
    LibraryPackage packageInstance = LibraryPackage.eINSTANCE;

		byte[] modelData = getModelBinaryData("/kth.library");

		return modelData;
	}

	private static byte[] getModelBinaryData(String modelName) {
		Resource resource = new BinaryResourceImpl(URI.createURI(modelName));

		Library library = createLibraryModel();

		resource.getContents().add(library);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			resource.save(byteArrayOutputStream, null);
		} catch (IOException e) {
			// Writing to a stream backed by a byte[] should never fail
		}
		return byteArrayOutputStream.toByteArray();
	}

	private static Library createLibraryModel() {
		Library library = LibraryFactory.eINSTANCE.createLibrary();
		library.setName("KTHB");
		Book book = LibraryFactory.eINSTANCE.createBook();
		book.setTitle("Pippi långstrump");
		Writer writer = LibraryFactory.eINSTANCE.createWriter();
		writer.setName("Astrid Lindgren");
		book.setAuthor(writer);
		library.getBooks().add(book);
		library.getWriters().add(writer);
		return library;
	}
}
