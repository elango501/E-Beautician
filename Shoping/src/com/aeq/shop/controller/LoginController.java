package com.aeq.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.aeq.shop.daoimp.OrderproductDaoImp;
import com.aeq.shop.daoimp.ProductDaoImp;
import com.aeq.shop.daoimp.UserDaoImp;

public class LoginController extends HttpServlet {
	private static String DASH_BOARD = "/dashboard.jsp";
	private static String LOGIN_PAGE = "/login.jsp";
	private static String ERROR_PAGE = "/error.jsp";
	UserDaoImp userdaoimp;
	ProductDaoImp productdaoimp;
	OrderproductDaoImp orderproductdaoimp;
	public LoginController(){
		userdaoimp=new UserDaoImp();
		productdaoimp=new ProductDaoImp();
		orderproductdaoimp=new OrderproductDaoImp();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String action=req.getParameter("action");
		String view = null;
		if(action.equals("login")){
			view=LOGIN_PAGE;
		}else if(action.equals("logout")){
		req.getSession().invalidate();
			view=LOGIN_PAGE;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);


	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String forward="";
	String email=req.getParameter("email");
	String password=req.getParameter("password");
		int result=userdaoimp.login(email, password);
		HttpSession session=req.getSession(true);
		  PrintWriter out = resp.getWriter();
		if(result==1){
			  Date createTime = new Date(session.getCreationTime());
			  Date lastAccessTime = 
                      new Date(session.getLastAccessedTime());
			session.setAttribute("email", email);
			session.setAttribute("role", userdaoimp.getbyrole(email, password));
			session.setAttribute("customer_count", userdaoimp.count_customer());
			session.setAttribute("count_product", productdaoimp.count_product());
			session.setAttribute("profile", userdaoimp.profile(email, password));
			session.setAttribute("loginid", userdaoimp.loginid(email, password));
			session.setAttribute("transaction", orderproductdaoimp.lisrorder());
			session.setAttribute("lastaccese", lastAccessTime);
			session.setAttribute("nooforder", orderproductdaoimp.countnooforder());
			session.setAttribute("countnooforderproduct", orderproductdaoimp.countnooforderproduct());
			 forward=DASH_BOARD;
			 req.setAttribute("msg", "welcome!");
		}
		else{
			
			req.setAttribute("msg", "sorry username or password invalid");
			req.getRequestDispatcher("index.jsp").include(req, resp);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
		dispatcher.forward(req, resp);


	}
	
	
}
