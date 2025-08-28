package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.User;

/**
 * Servlet implementation class WaitingController
 */
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			User user = (User) session.getAttribute("account");
			// Tùy thuộc vào roleid, chuyển hướng đến trang tương ứng
			if (user.getRoleid() == 1) { // Giả định roleid=1 là admin
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (user.getRoleid() == 2) { // Giả định roleid=2 là manager
				resp.sendRedirect(req.getContextPath() + "/manager/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
