package com.aeq.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aeq.shop.daoimp.AddressDaoImp;
import com.aeq.shop.daoimp.DeliveryDaoImp;
import com.aeq.shop.daoimp.OrderproductDaoImp;
import com.aeq.shop.daoimp.UserDaoImp;
import com.aeq.shop.model.Delivery;

public class DeliveryController extends HttpServlet {
		public static final String ADD_EDIT="addDelivery.jsp";
		public static final String LIST="listDelivery.jsp";
		UserDaoImp userdaoimp;
		OrderproductDaoImp orderproductdaoimp;
		AddressDaoImp addressdaoimp;
		DeliveryDaoImp deliverdaoimp;
public DeliveryController(){
			userdaoimp=new UserDaoImp();
			addressdaoimp=new  AddressDaoImp();
			orderproductdaoimp=new OrderproductDaoImp();
			deliverdaoimp=new DeliveryDaoImp();
		}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String view="";
		String action=req.getParameter("action");
		System.out.println("new---"+action);
		if(action.equals("delete")){
			view=LIST;
			int id=Integer.parseInt(req.getParameter("deliveryId"));
			deliverdaoimp.deletedelivery(id);
			req.setAttribute("deliverylist", deliverdaoimp.listdelivery());
			RequestDispatcher rd=req.getRequestDispatcher("listDelivery.jsp");
			rd.forward(req, resp);
		}else if(action.equals("add")){
			view=ADD_EDIT;
			req.setAttribute("loadorder", orderproductdaoimp.lisrorder());
			req.setAttribute("loaduser", userdaoimp.listUser());
			req.setAttribute("loadaddress", addressdaoimp.list_useraddress());
			RequestDispatcher rd=req.getRequestDispatcher("addDelivery.jsp");
			rd.forward(req, resp);
		}else if(action.equals("listuserdelivery")){
			view =LIST;
			req.setAttribute("deliverylist", deliverdaoimp.listdelivery());
			RequestDispatcher rd=req.getRequestDispatcher("listDelivery.jsp");
			rd.forward(req, resp);
		}else if(action.equals("loadorderidbyuser")){
			int userid=Integer.parseInt(req.getParameter("userid"));
	
		
			
			JSONArray jsonArray= orderproductdaoimp.ordergetbyuser(userid);
					
			
				
				
				
			resp.getWriter().write(jsonArray.toString());
			
		}else if(action.equals("loadaddressbyuser")){
			int userid=Integer.parseInt(req.getParameter("userid"));
				JSONObject obj=new JSONObject();
			try {
				obj.put("place", addressdaoimp.getaddresbyuser(userid))	;
				obj.put("placeid", addressdaoimp.getaddresidbyuser(userid));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	HttpSession session=req.getSession(true);
			req.setAttribute("address_id", addressdaoimp.getaddresidbyuser(userid));
			RequestDispatcher rd=req.getRequestDispatcher("addDelivery.jsp");
			System.out.println("--------"+req.getAttribute("address_id"));
			resp.getWriter().write(obj.toString());
			
		}
		
		
		
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			Delivery delivery=new Delivery();
			delivery.setUserid(Integer.parseInt(req.getParameter("userid")));
			delivery.setOrderid(Integer.parseInt(req.getParameter("orderid")));
			System.out.println("asdsaf"+req.getParameter("street"));
			
			delivery.setAddressid(Integer.parseInt(req.getParameter("street")));
			delivery.setDdate(req.getParameter("ddate"));
			deliverdaoimp.adddelivery(delivery);
			
			orderproductdaoimp.afterdeliverdupdate(Integer.parseInt(req.getParameter("orderid")));
			req.setAttribute("msg", "Sucessfully updated.delivery..details..check in delivery_details");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		
	}
		
}
