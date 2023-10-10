package DAO;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;


public class RegisterDAO {
	public static boolean insertAccount(HttpServletRequest request, Connection conn, Member member) {
		PreparedStatement ptmt = null;
		
		String sql = "insert into member(name, membername, memberpass, categorymemberid) values(?, ?, ?, ?)";
		try {
			ptmt = conn.prepareStatement(sql);
			
			String name = member.getName();
			String membername = member.getMembername();
			String memberpass = member.getMemberpass();
			int categorymemberid = 1;
			
			ptmt.setString(1, name);
			ptmt.setString(2, membername);
			ptmt.setString(3, memberpass);
			ptmt.setInt(4, categorymemberid);
			
			int kt = ptmt.executeUpdate();
			if(kt != 0) {
				return true;
			}
			ptmt.close();
		} catch (Exception e) {
			//e.printStackTrace();
			request.setAttribute("msgregister", e.getMessage());
		}
		return false;
	}
}
