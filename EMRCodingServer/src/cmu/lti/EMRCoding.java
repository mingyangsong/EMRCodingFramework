package cmu.lti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class emrcoding
 */
@WebServlet(description = "it's for emrcoding team", urlPatterns = { "/EMRCoding" })
public class EMRCoding extends HttpServlet {

	private String target = "/login.jsp";
	private static final long serialVersionUID = -3522462295690035558L;

	public EMRCoding() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("Hello, world!");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("USER", username);
		request.setAttribute("PASSWORD", password);

		ServletContext context = getServletContext();

		System.out.print("Redirecting to" + target);
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
