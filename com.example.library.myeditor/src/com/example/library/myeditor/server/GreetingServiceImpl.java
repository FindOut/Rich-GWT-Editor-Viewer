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

		LibraryPackage packageInstance = LibraryPackage.eINSTANCE;

		byte[] modelData = getModelBinaryData("/kth.library");

		return modelData;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

//	private static Library loadLibrary(String pathName) throws IOException {
//		ResourceSet rs = new ResourceSetImpl();
//		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("library", new XMIResourceFactoryImpl());
//		Resource resource = rs.getResource(URI.createFileURI(pathName), true);
//		Library library = (Library) resource.getContents().get(0);
//		return library;
//	}

	private static byte[] getModelBinaryData(String modelName) {
//		ResourceSet rs = new ResourceSetImpl();
//		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("library", new XMIResourceFactoryImpl());
//		Resource resource = rs.createResource(URI.createURI(modelName));
		
		Resource resource = new BinaryResourceImpl(URI.createURI(modelName));

		Library library = createLibraryModel();

		resource.getContents().add(library);
//		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
//		saveOptions.put(XMIResource.OPTION_BINARY, Boolean.TRUE);
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
