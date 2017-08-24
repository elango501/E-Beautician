package com.aeq.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aeq.shop.daoimp.UserDaoImp;
import com.aeq.shop.model.User;

public class UserController extends HttpServlet {
	UserDaoImp userdaoimp;
	public static final String LIST_USER="listUser.jsp";
	public static final String ADD="addUser.jsp";
	public static final String EDIT="updateProfile.jsp";
	public UserController(){
		userdaoimp=new UserDaoImp();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		String  view = "";
		System.out.println("now=------------>"+action);
		if(action.equals("delete")){
			view=LIST_USER;
			int id=Integer.parseInt(req.getParameter("userId"));
			userdaoimp.deleteUser(id);
			req.setAttribute("userlist", userdaoimp.listUser());
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("listUser.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("add")){
			view = ADD;
			RequestDispatcher dispatcher = req.getRequestDispatcher("addUser.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("listuser")){
			view = LIST_USER;
			
			req.setAttribute("userlist", userdaoimp.listUser());
			RequestDispatcher dispatcher=req.getRequestDispatcher("listUser.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("edit")){
			view=EDIT;
			int id=Integer.parseInt(req.getParameter("userid"));
			req.setAttribute("user", userdaoimp.getbyId(id));
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			User user=new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setGender(req.getParameter("gender"));
			int age=Integer.parseInt(req.getParameter("age"));
			user.setAge(age);
			
			user.setRole(req.getParameter("role"));
			String id=req.getParameter("userid");
			List<User> list=new ArrayList<User>(userdaoimp.listUser());
			
			String validate="";
			for (User user2 : list) {
				if(user2.getEmail().equals(user.getEmail())&&user2.getPassword().equals(user.getPassword())){
					validate="alredy";
						
				}
			}
			
			if(id==null || id.equals("")){
				if(!validate.equals("alredy")){
					userdaoimp.addUser(user);
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);		
				}
				else{
					req.setAttribute("msg", "This user alredy exits");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);		
				}
				
				
			}
			else if(id!=null|| !id.equals("")){
				int uid=Integer.parseInt(id);
	
				user.setId(uid);
				userdaoimp.update(user);
				req.setAttribute("msg", "Your profile updated sucessfully");
				RequestDispatcher dispatcher=req.getRequestDispatcher("dashboard.jsp");
				dispatcher.forward(req, resp);		
			}
			

			
			
	}
}
