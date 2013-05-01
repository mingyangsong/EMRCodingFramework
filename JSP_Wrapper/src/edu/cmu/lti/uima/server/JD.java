package edu.cmu.lti.uima.server;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JD extends HttpServlet {

	// Figure this out
	// private RunRemoteAsyncAE runner;
	public RunRemoteAsyncAE runner = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String emrText = request.getParameter("emrData");

		// Testing for UIMA AS service
		try {

			System.out.println("Initialize a RunRemoteAsyncAE()");

			// initialize RunRemoteAsyncAE and passing emrText and the callback
			// response

			response.setContentType("text/xml");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");

			String xml = "<emrCases>" + "<emr>" 
                    + "<content>sakdaksdashdaskjd"
                    + "</content>"
                    + "<icd>"
          		   		+ "1234567890" 
          		   + "</icd>"    	                                   
          +  "</emr>"
+"</emrCases>";
			response.getWriter().write(xml);
			//request.
			System.out.print(xml);
			 //runner = new RunRemoteAsyncAE(emrText, response);
			 //runner.run();
			int times = 0;
			while (true) {
				Thread.sleep(1000);
				times++;
				if (times > 2)
					break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
