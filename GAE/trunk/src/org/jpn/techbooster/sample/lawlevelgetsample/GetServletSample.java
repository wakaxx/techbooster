package org.jpn.techbooster.sample.lawlevelgetsample;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class GetServletSample extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("TechKind");
		PreparedQuery pQuery = ds.prepare(query);
		Entity entity = pQuery.asSingleEntity();
		Object object = entity.getProperty("name");
		String name = object.toString();
			

	}
}
