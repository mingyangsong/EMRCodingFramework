package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.lti.uima.rules.hieratical.test;

public class EMRCoding extends HttpServlet {

	private static final long serialVersionUID = -3522462295690035558L;
	private static StandardOutput stdOut = StandardOutput.getInstance();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RealPath.getInstance().set(
				request.getSession().getServletContext().getRealPath("") + "/");
		stdOut.setNull();
		String descriptor=request.getParameter("DESCRIPTOR");
		String snowmed = request.getParameter("SNOWMEDIN");
		String emr = request.getParameter("EMRIN");
		String ratio=request.getParameter("RATIOIN");
		
		stdOut.setString("Descriptor "+descriptor+"\nEMR "+emr+"\nSnowmed "+snowmed+"\nRatio "+ratio);
//		if (!input.equals(""))
//			new test(input);
//		else
//			stdOut.setString("No SNOWMED Input!!");

		String Input = stdOut.getString();
//		HttpSession session=request.getSession(); 
		request.setAttribute("SNOWMED",emr); 
		request.setAttribute("REPORT", Input);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
