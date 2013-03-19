package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseLine extends HttpServlet {

	private static String FileDir = null;
	private static final long serialVersionUID = -3522462295690035558L;
	private static StandardOutput stdOut = StandardOutput.getInstance();
	int i=100;
	int b=200;

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
		FileDir = request.getParameter("descriptor");
		RealPath.getInstance().set(
				request.getSession().getServletContext().getRealPath("") + "/");

		if (FileDir != null) {
			try {
				new SimpleRunCPE((RealPath.getInstance().get() + FileDir));
			} catch (Exception e) {
				e.printStackTrace();
				stdOut.setString("Error!!"+b++);
			}
		}
		String Input = stdOut.getString();
		request.setAttribute("REPORT", Input+i++);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		stdOut.setNull();
	}
}
