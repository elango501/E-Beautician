package com.aeq.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.parser.JSONParser;

import org.json.JSONException;
import org.json.JSONObject;

import com.aeq.shop.daoimp.DeliveryDaoImp;
import com.aeq.shop.daoimp.OrderproductDaoImp;
import com.aeq.shop.daoimp.ProductDaoImp;
import com.aeq.shop.model.Order_Product;
import com.aeq.shop.model.Product;

public class OrderproductController extends HttpServlet {
	public static final String LIST_ORDERPRODUCT="listOrderproduct.jsp";
	public static final String ADD_EDIT="addOrderproduct.jsp";
	public static final String LIST_MYORDERPRODUCT="listMyorderproduct.jsp";
	ProductDaoImp productdaoimp;
	OrderproductDaoImp orderproductdaoimp;
	DeliveryDaoImp deliverydaoimp;
	public OrderproductController()
	{
		productdaoimp=new ProductDaoImp();
		orderproductdaoimp=new OrderproductDaoImp();
		deliverydaoimp=new DeliveryDaoImp();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String view="";
		String action=req.getParameter("action");
		System.out.println(action);
		if(action.equals("delete")){
			
			String orderno=req.getParameter("orderno");
			orderproductdaoimp.deleteorderproduct(orderno);
			req.setAttribute("msg", "Your order deleted sucessfully");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		}else if(action.equals("add")){
			view=ADD_EDIT;
			Random rnum = new Random();
			HttpSession session=req.getSession(true);
			 session.setAttribute("orderno", rnum.nextInt(1000));
			req.setAttribute("loadproduct", productdaoimp.listproduct());
			RequestDispatcher rd =req.getRequestDispatcher("addOrderproduct.jsp");
			rd.forward(req, resp);
		}else if(action.equals("myorder")){
			view=LIST_MYORDERPRODUCT;
		
			int userid=Integer.parseInt(req.getParameter("loginid"));
			req.setAttribute("myorderlist", orderproductdaoimp.myorderno(userid));
			RequestDispatcher rd=req.getRequestDispatcher("listMyorderproduct.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("addcart")){
			
			int userid=Integer.parseInt(req.getParameter("userid"));
			String orderno=req.getParameter("orderno");
			System.out.println(orderno);
			int quantity=Integer.parseInt(req.getParameter("qty"));
			int productid=Integer.parseInt(req.getParameter("product"));
			double price=Double.parseDouble(req.getParameter("total"));
			orderproductdaoimp.addorder_bulkproduct(userid, orderno, productid, quantity, price);
			productdaoimp.afterorderupdate(quantity, productid);
			String productname=productdaoimp.product_getbyid(productid).getProductname();
			JSONObject jsonObject = new JSONObject();
			try {
				
				jsonObject.put("productname", productname);
				
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
			resp.getWriter().write(jsonObject.toString());
			
		}else if(action.equals("orderlist")){
			
			req.setAttribute("orderlist", orderproductdaoimp.lisrorder());
			RequestDispatcher rd=req.getRequestDispatcher("listOrder.jsp");
			rd.forward(req, resp);
		}else if(action.equals("orderview"))
		{
			
			String orderno=req.getParameter("orderno");
			req.setAttribute("vieworderlist", orderproductdaoimp.viewmybyorderno(orderno));
			req.setAttribute("grandcalculation", orderproductdaoimp.grandtotal(orderno));
			int orderid=Integer.parseInt(orderno);
			req.setAttribute("deliverybyuser", deliverydaoimp.listdeliverybyorderno(orderid));
			RequestDispatcher rd=req.getRequestDispatcher("listOrderbyno.jsp");
			rd.forward(req, resp);
		}
		
		
		else if(action.equals("listproductquantitybyid")){
			int id=Integer.parseInt(req.getParameter("productid"));
			
			int qun=productdaoimp.quantitygetbyid(id);
			double rate=productdaoimp.priceqetbyid(id);
			JSONObject jsonObject = new JSONObject();
			try {
				
				jsonObject.put("qun", qun);
				jsonObject.put("rate", rate);
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
			resp.getWriter().write(jsonObject.toString());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	
	}
}
