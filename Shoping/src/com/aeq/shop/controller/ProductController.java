package com.aeq.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aeq.shop.daoimp.ProductDaoImp;
import com.aeq.shop.model.Product;

public class ProductController extends HttpServlet {
	ProductDaoImp productdaoimp;
	public  static final String LIST_PRODUCT="listProduct.jsp";
	public static final String ADD_EDIT="addProduct.jsp";
	public ProductController(){
		productdaoimp=new ProductDaoImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action=req.getParameter("action");
		String view="";
	
		if(action.equals("delete")){
			view=LIST_PRODUCT;
			int id=Integer.parseInt(req.getParameter("productId"));
			productdaoimp.delete_product(id);
			req.setAttribute("listproduct", productdaoimp.listproduct());
			RequestDispatcher dispatcher=req.getRequestDispatcher("listProduct.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("add")){
			view = ADD_EDIT;
			RequestDispatcher dispatcher = req.getRequestDispatcher("addProduct.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("listproduct")){
			view=LIST_PRODUCT;
			req.setAttribute("listproduct", productdaoimp.listproduct());
			RequestDispatcher dispatcher=req.getRequestDispatcher("listProduct.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("edit")){
			view=ADD_EDIT;
			int id=Integer.parseInt(req.getParameter("productid"));
			req.setAttribute("product", productdaoimp.product_getbyid(id));
			RequestDispatcher dispatcher=req.getRequestDispatcher("addProduct.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Product product=new Product();
		product.setProductname(req.getParameter("productname"));
		product.setPrice(Double.parseDouble(req.getParameter("price")));
		product.setBatchno(req.getParameter("batchno"));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setAccesories(req.getParameter("accesories"));
		String productid=req.getParameter("id");
		if(productid==null ||productid.equals("")){
			productdaoimp.addProduct(product);
		}
		else{
			product.setId(Integer.parseInt(productid));
			productdaoimp.update_product(product);
		}
		HttpSession session=req.getSession();
		
		
		req.setAttribute("listproduct", productdaoimp.listproduct());
		RequestDispatcher dispatcher=req.getRequestDispatcher("listProduct.jsp");
		dispatcher.forward(req, resp);
	}
}
