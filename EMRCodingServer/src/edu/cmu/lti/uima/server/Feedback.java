package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Feedback extends HttpServlet {


	/**
	 * Feedback Servlet
	 */
	private static final long serialVersionUID = -3169334394700417871L;

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

		request.setAttribute("REPORT", "!!!!!!!!!!!!!!");
		String[] checklist = request.getParameterValues("SNOWMEDS");
		String input = "";
		if (checklist != null) {
			for (String c : checklist) {
				input += c + " ";
			}
		}
		System.out.println(input);
		request.setAttribute("SET", "Finish");
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/newBox.jsp");
		dispatcher.forward(request, response);
	}
}
