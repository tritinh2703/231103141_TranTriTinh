package vn.iot.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns= {"/hello","/xin-chao"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name = "";
		// Nhận cookie
		Cookie[] cookie = req.getCookies();
		for (Cookie c : cookie) {
			if (c.getName().equals("username")) {
				name = c.getValue();
			}
		}
		if (name.equals("")) {
			// chuyển sang trang LoginServlet
			resp.sendRedirect("/helloworld/login");
		}
		// hiển thị lên trang bằng đối tượng PrintWriter()
		printWriter.println("Xin chao " + name);

	}

}
