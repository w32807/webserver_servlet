package servlet;


import db.DataBase;
import dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/user/edit")
public class EditUserServlet extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(EditUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info("EditUserServlet doGet run");
    	String userId = (String) req.getParameter("userId");
        req.setAttribute("user", DataBase.findUserById(userId));
        RequestDispatcher rd = req.getRequestDispatcher("/user/editForm.jsp"); // jsp 파일 연결
        rd.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info("EditUserServlet doPost run");
    	String userId = (String) req.getParameter("userId");
    	String password = (String) req.getParameter("password");
    	String name = (String) req.getParameter("name");
    	String email = (String) req.getParameter("email");
    	
    	User user = DataBase.findUserById(userId);
    	user.setPassword(password);
    	user.setName(name);
    	user.setEmail(email);
    	DataBase.update(user);
    	resp.sendRedirect("/user/list");
    }
}
