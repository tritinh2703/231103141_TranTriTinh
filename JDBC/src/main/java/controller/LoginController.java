package controller;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User user = null;
        try {
            // Đặt lệnh gọi trong khối try
            user = userService.login(username, password);
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây, ví dụ in ra log
            e.printStackTrace();
            req.setAttribute("alert", "Hệ thống gặp lỗi. Vui lòng thử lại sau.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return; // Dừng lại nếu có lỗi
        }
        
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", user);
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            req.setAttribute("alert", "Tên tài khoản hoặc mật khẩu không đúng.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

}
