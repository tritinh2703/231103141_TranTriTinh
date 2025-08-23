package vn.iot.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    req.getRequestDispatcher("/Login.html").forward(req, resp); // Chuyển tiếp đến file login.html
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if (user.equals("trung") && pass.equals("123")) {
			Cookie cookie = new Cookie("username", user); // khởi tạo cookie
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang HelloServlet
			resp.sendRedirect("/helloworld/hello");
		} else {
			// chuyển sang trang LoginServlet
			resp.sendRedirect("/helloworld/login");
		}
	}

}
