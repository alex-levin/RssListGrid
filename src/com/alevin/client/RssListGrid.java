package com.alevin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.grid.ListGrid;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RssListGrid implements EntryPoint {	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
        DataSource dataSource = new DataSource();  
        // We cannot access an rss feed on a remote host from JavaScript. We will access it using local RssServlet.
        // dataSource.setDataURL("http://rss.slashdot.org/Slashdot/slashdot");  
        dataSource.setDataURL("/rssServlet");
        dataSource.setRecordXPath("//item | //default:item");  
  
        DataSourceTextField titleField = new DataSourceTextField("title", "Title");  
        DataSourceLinkField linkField = new DataSourceLinkField("link", "Link");  
  
        dataSource.setFields(titleField, linkField);  
  
        ListGrid grid = new ListGrid();  
        grid.setAutoFetchData(true);  
        grid.setHeight(200);  
        grid.setWidth100();  
        grid.setDataSource(dataSource);  
  
        grid.draw();  
	}
}
