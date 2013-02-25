package edu.cmu.lti.uima.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EMRCoding extends HttpServlet {

	private static final long serialVersionUID = -3522462295690035558L;

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
		
		String strDirPath = getServletContext().getRealPath("/");
//		String strPathFile = application.getRealPath(request.getRequestURI());
		System.out.println("文件的绝对路径:" + strDirPath+ "<br/>");
		
		String FileDir = request.getParameter("input");
		System.out.println(FileDir);

		StandardOutput std = StandardOutput.getInstance();
		std.setNull();

		try {
			new SimpleRunCPE(
					"C:/Users/s/Desktop/EMRCoding/EMRCoding_Server/EMRCodingServer/WebContent/descriptors/MappingCPE.xml");
		} catch (Exception e) {
			e.printStackTrace();
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
