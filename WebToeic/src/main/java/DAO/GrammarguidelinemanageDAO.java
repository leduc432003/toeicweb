package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.Grammarguideline;

public class GrammarguidelinemanageDAO {
	public static List<Grammarguideline> Displaysgrammarguidelinemanage(HttpServletRequest request, Connection conn) {
		List<Grammarguideline> list = new ArrayList<Grammarguideline>();
				
		String sql = "select * from grammarguideline";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Grammarguideline gmgl = new Grammarguideline();
					
					int grammarguidelineid = rs.getInt("grammarguidelineid");
					String grammarname = rs.getString("grammarname");
					String grammarimage = rs.getString("grammarimage");
					String content = rs.getString("content");
					
					gmgl.setGrammarguidelineid(grammarguidelineid);
					gmgl.setGrammarname(grammarname);
					gmgl.setGrammarimage(grammarimage);
					gmgl.setContent(content);
					
					list.add(gmgl);
				}
			}
			else {
				request.setAttribute("msglistgrammarguidelinemanage", "Không có bài hướng dẫn nào trong danh sách");
			}
			ptmt.close();
			rs.close();
		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		return list;
	}
	// Thêm tên bài hướng dẫn ngữ pháp
	public static boolean Insertgrammarguidelinename(HttpServletRequest request, Connection conn, Grammarguideline grammarguideline) {
		PreparedStatement ptmt = null;
		
		String sql = "insert into grammarguideline(grammarname) values(?)";
		try {
			ptmt = conn.prepareStatement(sql);
			
			String grammarname = grammarguideline.getGrammarname();
			
			ptmt.setString(1, grammarname);
			int kt = ptmt.executeUpdate();
			if(kt != 0) {
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		return false;
	}
	// Hàm thêm file ảnh của các đề thi trong phần hướng dẫn ngữ pháp
	public static String Uploadimagegrammarguideline(Connection conn, HttpServletRequest request, HttpServletResponse response, int grammarguidelineid) throws ServletException, IOException {
		String test = "";
		ServletContext context = request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");
		
		final String address = context.getRealPath("Imageupload/");
		final int maxMemorySize = 1024 * 1024 * 3; //3MB
		final int maxRequestSize = 1024 * 1024 * 50; //50MB
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(!isMultipart) {
			test = "Thiếu enctype: multipart/form-data trong form";
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemorySize);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(maxRequestSize);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()) {
				FileItem item = iter.next();
				if(!item.isFormField()) {
					String fileName = item.getName();
					//pathFile: Vị trí mà chúng ta muốn upload file vào;
					String pathFile = address + File.separator + fileName;
					
					File uploadedFile = new File(pathFile);
					boolean kt = uploadedFile.exists();
					try {
						if(kt == true) {
							test = "File tồn tại! Yêu cầu truyền file khác";
						}
						else {
							item.write(uploadedFile);
							
							GrammarguidelinemanageDAO.Insertgrammarguidelineimage(request, conn, fileName, grammarguidelineid);
							test = "Thành công";
						}
					} catch (Exception e) {
						test = e.getMessage();
					}
				}
				else {
					test = "Thêm File thất bại";
				}
			}
		} catch (FileUploadException e) {
			test = e.getMessage();
		}
		return test;
	}
	// Xuất id của bài hướng dẫn ngữ pháp
	public static int Retrieveidgrammarguideline(HttpServletRequest request, Connection conn, Grammarguideline grammarguideline) {
		int grammarguidelineid = 0;
		PreparedStatement ptmt = null;
		
		
		String sql = "select grammarguidelineid from grammarguideline where grammarname='"+grammarguideline.getGrammarname()+"'";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next())
			{
				grammarguidelineid = rs.getInt("grammarguidelineid");		
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msggrammarguidelineimage",e.getMessage());
		}
		
		
		return grammarguidelineid;
	}
	//update tên hình cho phần hướng dẫn ngữ pháp
	public static void Insertgrammarguidelineimage(HttpServletRequest request, Connection conn, String image, int grammarguidelineid) {
		PreparedStatement ptmt = null;
		
		String sql = "update grammarguideline set grammarimage=? where grammarguidelineid="+grammarguidelineid;
		try {
			ptmt = conn.prepareStatement(sql);
						
			ptmt.setString(1, image);
			ptmt.executeUpdate();
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
	}
	// Thêm nội dung vào bài hướng dẫn
	public static boolean Insertgrammarguidelinecontent(HttpServletRequest request, Connection conn, Grammarguideline grammarguideline, int id) {
		PreparedStatement ptmt = null;
		
		String sql = "update grammarguideline set content=? where grammarguidelineid="+id;
		try {
			ptmt = conn.prepareStatement(sql);
			
			String content = grammarguideline.getContent();
			
			ptmt.setString(1, content);
			int kt = ptmt.executeUpdate();
			if(kt != 0) {
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msggrammarguidelinecontent", e.getMessage());
		}
		return false;
	}
}
