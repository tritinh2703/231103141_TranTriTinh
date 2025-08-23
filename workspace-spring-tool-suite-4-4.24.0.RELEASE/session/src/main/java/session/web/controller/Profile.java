package session.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if (session != null) {
//			String name = (String) session.getAttribute("name");
//			out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
//		} else {
//			out.print("Xin vui lòng đăng nhập");
//			resp.sendRedirect("/session/Login.html");
//		}

	}

}
