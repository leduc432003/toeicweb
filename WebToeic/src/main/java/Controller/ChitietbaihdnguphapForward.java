package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BaihdnguphapDAO;
import DB.DBConnection;

@WebServlet("/ChitietbaihdnguphapForward")
public class ChitietbaihdnguphapForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChitietbaihdnguphapForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mabaihdnguphapsrt = request.getParameter("mabaihdnguphap");
		int mabaihdnguphap = Integer.parseInt(mabaihdnguphapsrt);
		Connection conn = DBConnection.CreateConnection();
		String content = BaihdnguphapDAO.Displaygrammarcontent(conn, mabaihdnguphap);
		request.setAttribute("mabaihdnguphap", mabaihdnguphap);
		request.setAttribute("grammarguidelinecontent", content);
		request.setAttribute("kitutrongdatabase1", "\n");
		request.setAttribute("kitutronghtml1", "<br>");
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Chitietbaihdnguphap.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
