package servlet;


import db.DataBase;
import dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.SessionConst;

import java.io.IOException;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ListUserServlet.class);
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info("ListUserServlet doGet run");
    	if(isLogin(req)) {
    		req.setAttribute("users", DataBase.findAll());
    		RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp"); // jsp 파일 연결
    		rd.forward(req, resp);
    	}else {
			resp.sendRedirect("/user/login");
		}
    }
    
    private boolean isLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionConst.LOGIN_USER);
		return (user == null) ? false : true;
	}
}
