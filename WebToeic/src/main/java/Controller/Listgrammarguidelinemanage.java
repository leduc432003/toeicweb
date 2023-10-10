package Controller;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Grammarguideline;
import DAO.GrammarguidelinemanageDAO;
import DB.DBConnection;

@WebServlet("/Listgrammarguidelinemanage")
public class Listgrammarguidelinemanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Listgrammarguidelinemanage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DBConnection.CreateConnection();
			List<Grammarguideline> list = GrammarguidelinemanageDAO.Displaysgrammarguidelinemanage(request, conn);
			request.setAttribute("listgrammarguidelinemanage", list);
			conn.close();
		} catch (Exception e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/hdnguphap.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
