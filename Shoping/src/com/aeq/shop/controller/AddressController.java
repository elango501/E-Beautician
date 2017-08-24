package com.aeq.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aeq.shop.daoimp.AddressDaoImp;
import com.aeq.shop.daoimp.UserDaoImp;
import com.aeq.shop.model.Address;

public class AddressController extends HttpServlet {
public static final String Add_Edit="addAddress.jsp";
public static final String List="listAddress.jsp";
UserDaoImp userdaoimp;
AddressDaoImp addressdaoimp;
public AddressController(){
	userdaoimp=new UserDaoImp();
	addressdaoimp=new AddressDaoImp();
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action=req.getParameter("action");
		String view="";
		if(action.equals("delete")){
			view=List;
			int id=Integer.parseInt(req.getParameter("id"));
			addressdaoimp.delete_addresss(id);
			req.setAttribute("addresslist", addressdaoimp.list_useraddress());
			//RequestDispatcher rd=req.getRequestDispatcher("listAddress.jsp");
			rd=req.getRequestDispatcher("listAddress.jsp");
			//rd.forward(req, resp);
			
		}else if(action.equals("list")){
			view=List;
			req.setAttribute("addresslist", addressdaoimp.list_useraddress());
			//RequestDispatcher rd=req.getRequestDispatcher("listAddress.jsp");
			req.getRequestDispatcher("listAddress.jsp");
			//rd.forward(req, resp);
		}else if(action.equals("add")){
			view=Add_Edit;
			req.setAttribute("loaduser", addressdaoimp.list_useraddress());
			//RequestDispatcher rd=req.getRequestDispatcher("addAddress.jsp");
			req.getRequestDispatcher("listAddress.jsp");
			//rd.forward(req, resp);
			
		}else if(action.equals("edit")){
			view=Add_Edit;
			int id=Integer.parseInt(req.getParameter("addressid"));
			req.setAttribute("address", addressdaoimp.address_getbyid(id));
			req.setAttribute("loaduser", addressdaoimp.list_useraddress());
			//RequestDispatcher rd=req.getRequestDispatcher("addAddress.jsp");
			req.getRequestDispatcher("addAddress.jsp");
			//rd.forward(req, resp);
		}else if(action.equals("myaddress")){
			view=List;
			int userid=Integer.parseInt(req.getParameter("loginid"));
			req.setAttribute("myaddresslist", addressdaoimp.myaddress(userid));
			//RequestDispatcher rd=req.getRequestDispatcher("listAddress.jsp");
			req.getRequestDispatcher("listAddress.jsp");
			
		}
		rd.forward(req, resp);
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				Address address=new Address();
				address.setStreet(req.getParameter("street"));
				address.setPlace(req.getParameter("place"));
				address.setCity(req.getParameter("city"));
				address.setZipcode(req.getParameter("zipcode"));
				address.setUserid(Integer.parseInt(req.getParameter("userid")));
				String id=req.getParameter("addressid");
				if(id.equals(null)||id==""){
					addressdaoimp.insert_address(address);
					
				}else{
					address.setId(Integer.parseInt(id));
					addressdaoimp.update_address(address);
				}
				
				req.setAttribute("addresslist", addressdaoimp.list_useraddress());
				req.setAttribute("msg", "Sucessfully added your Address Details");
				RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
				rd.forward(req, resp);
	}
}
