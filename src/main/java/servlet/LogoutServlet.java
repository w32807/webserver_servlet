package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DataBase;
import dto.User;

@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(LogoutServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session != null) {
			session.invalidate();
		}
		
        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("LoginServlet doPost run");
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		User user = DataBase.findUserById(userId);
		
		if(password.equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("/user/list");
		}else {
	        RequestDispatcher rd = req.getRequestDispatcher("/user/login_failed.jsp");
	        rd.forward(req, resp);
		}
	}
}
