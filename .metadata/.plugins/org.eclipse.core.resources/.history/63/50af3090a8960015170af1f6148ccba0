package uk.co.luciditysoftware.campervibe.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet(name = "bookingServlet", urlPatterns = { "/booking" }, loadOnStartup = 1)
@MultipartConfig(fileSizeThreshold = 5_242_880, // 5MB
maxFileSize = 20_971_520L, // 20MB
maxRequestSize = 41_943_040L // 40MB
)
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action == null)
			action = "list";

		switch (action) {
		case "make":
			this.showMakeBookingForm(request, response);
			break;
		case "view":
			// this.viewTicket(request, response);
			break;
		case "download":
			// this.downloadAttachment(request, response);
			break;
		case "list":
		default:
			// this.listTickets(response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
        if(action == null)
            action = "list";
        
        switch(action)
        {
            case "create":
                this.makeBooking(request, response);
                break;
            case "list":
            default:
                response.sendRedirect("tickets");
                break;
        }
	}

	private void showMakeBookingForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/jsp/view/makeBookingForm.jsp").forward(request, response);
	}
	
	private void makeBooking(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("ok");
	}
}
