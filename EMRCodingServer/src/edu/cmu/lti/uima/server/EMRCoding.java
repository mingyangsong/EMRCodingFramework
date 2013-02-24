package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EMRCoding extends HttpServlet {

	private String target = "/index.jsp";
	private static final long serialVersionUID = -3522462295690035558L;

	public EMRCoding() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().write("Hello, world!");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Input = new String();
		Input = request.getParameter("input");

		request.setAttribute("INPUT", Input);

		ServletContext context = getServletContext();

		System.out.print("Redirecting to" + target);
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
}
