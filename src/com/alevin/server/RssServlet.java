package com.alevin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Retrieves remote rss feed
 */
public class RssServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
	    public void doGet(HttpServletRequest req,
	         HttpServletResponse resp) throws IOException {
	      PrintWriter out = resp.getWriter();
	      try { 
	          URL oracle = new URL("http://rss.slashdot.org/Slashdot/slashdot");
	          URLConnection yc = oracle.openConnection();
	          BufferedReader in = new BufferedReader(new InputStreamReader(
	                                      yc.getInputStream()));
	          StringBuilder buff = new StringBuilder();
	          String inputLine;
	          while ((inputLine = in.readLine()) != null) {
	              buff.append(inputLine);
	          }
	          in.close();
	          
	          out.write(buff.toString());
	      } catch (Exception ex) {
	        ex.printStackTrace(System.err);
	        out.println("[]");
	      }
	    }
}
