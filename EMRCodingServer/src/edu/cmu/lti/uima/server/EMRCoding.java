package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EMRCoding extends HttpServlet {

	private static String FileDir = null;
	private static final long serialVersionUID = -3522462295690035558L;
	private static StandardOutput std = StandardOutput.getInstance();

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
		FileDir = request.getParameter("input");
		
		if (FileDir != null && FileDir != "") {
			std.setNull();
			String path = request.getSession().getServletContext()
					.getRealPath("");
			try {
				new SimpleRunCPE(path + FileDir);
			} catch (Exception e) {
				e.printStackTrace();
				std.setString("Error!!");
			}
		}
		String Input = std.getString();
		request.setAttribute("REPORT", Input);
		ServletContext context = getServletContext();
		// System.out.print("Redirecting to" + target);
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
