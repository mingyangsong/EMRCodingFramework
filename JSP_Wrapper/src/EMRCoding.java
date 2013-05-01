

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RealPath.getInstance().set(
				request.getSession().getServletContext().getRealPath("") + "/");

		String emrText = request.getParameter("EMRIN");

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
		
		
		request.setAttribute("REPORT", emr);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/JD.jsp");
		dispatcher.forward(request, response);
	}
	}
}
