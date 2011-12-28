package com.example.library.myeditor.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {

	void greetServer(String name, AsyncCallback<byte[]> callback);

}
