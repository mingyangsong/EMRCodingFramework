package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String[] checklist = request.getParameterValues("SNOWMEDS");
		String userin = request.getParameter("USERIN");
		String input = "";
		if (checklist != null) {
			for (String c : checklist) {
				input += c + " ";
			}
		}
		if (input != null)
			input += userin;

		System.out.println(input);

		if (!input.equals(""))
			new test(input);
		else
			stdOut.setString("No SNOWMED Input!!");

		String Input = stdOut.getString();
		request.setAttribute("REPORT", Input);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
