package org.jpn.techbooster.sample.lawlevelgetsample;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class PostServletSample extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		Key key1 = KeyFactory.createKey("TechKind", 1);
		Entity entity1 = new Entity(key1);
		
		entity1.setProperty("name0", "seit");
		entity1.setProperty("age", "25");
		entity1.setProperty("gender", "man");
		entity1.setProperty("url","http://techbooster.jpn.org");
		
		Key key2 = KeyFactory.createKey("TechKind", 2);
		Entity entity2 = new Entity(key2);
		
		entity2.setProperty("name1", "kobashing");
		entity2.setProperty("age", "26");
		entity2.setProperty("gender", "man");
		entity2.setProperty("url","http://techbooster.jpn.org");
				
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		ds.put(entity1);
		ds.put(entity2);
		
		resp.sendRedirect("/lawlevelgetsample");
	}
}
