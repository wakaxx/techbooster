package org.jpn.techbooster.sample.lawlevelgetsample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.FetchOptions.Builder;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class LawLevelGetSampleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Velocity.init();
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		VelocityContext vContext = new VelocityContext();
		
		Template template = Velocity.getTemplate("WEB-INF/top.vm","Shift-JIS");		
		
		String name = getData();
		vContext.put("name", name);

		template.merge(vContext, resp.getWriter());
	}
	
	public String getData(){
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		//DatastoreServiceのget()メソッドを用いてエンティティーを取得する
		String name = "";
		Key key = KeyFactory.createKey("TechKind", 1);
		try {
			Entity entity = ds.get(key);
			Object obj = entity.getProperty("name");
			name = obj.toString();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
}
