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
		String FileDir = request.getParameter("input");
		System.out.println(FileDir);
		try {
			new SimpleRunCPE(
					"C:\\Users\\s\\Desktop\\EMRCoding\\EMRCoding_Server\\EMRCodingServer\\descriptors\\descriptors\\MappingCPE.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String Input = StandardOutput.getInstance().getString();

		request.setAttribute("REPORT", Input);

		ServletContext context = getServletContext();

		System.out.print("Redirecting to" + target);
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
}
