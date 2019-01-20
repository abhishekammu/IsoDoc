
package Iso_DocController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoginService1.LoginService1;

@WebServlet("/TimesheetController")
public class TimesheetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Directorate = request.getParameter("Directorate");
		String Division=request.getParameter("Division");
		System.out.println(request.getParameter("TypofDoc"));
		String TypeofDocument=request.getParameter("TypofDoc");
		String DocumentNomenclature=request.getParameter("DocumentNomenclature");
		String DocumentNo=request.getParameter("DocumentNo");
		String RevisionNumber=request.getParameter("RevisionNumber");
		String RevisionDate=request.getParameter("RevisionDate");
		String IssueNumber=request.getParameter("IssueNumber");
		String IssueDate=request.getParameter("IssueDate");
		String Remarks=request.getParameter("Remarks");


		LoginService1 s= new LoginService1();
		try {
			s.saveIso_DocController(Directorate , Division, TypeofDocument,DocumentNomenclature,DocumentNo,RevisionNumber,RevisionDate,IssueNumber,IssueDate,Remarks);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		List isodetails;
		try {
			isodetails = s.guardlogin1();
			request.setAttribute("isodetails", isodetails);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		RequestDispatcher rd = request.getRequestDispatcher("Frontpage.jsp");
		rd.forward(request, response);

		
             
	}
}