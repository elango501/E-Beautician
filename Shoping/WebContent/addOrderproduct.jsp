<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<html lang="en">

<head>

<script>
function setquantity()
				{
					var id = document.getElementById("productid");
					var selectproduct = id.options[id.selectedIndex].value;				
					var xhtp = new XMLHttpRequest();
				    xhtp.onreadystatechange = function() {
				      if (xhtp.readyState == 4 && xhtp.status == 200) {
				       var parsedUP = JSON.parse(xhtp.responseText);
				       document.getElementById("quantity").value =parsedUP.qun;
				       document.getElementById("price").value =parsedUP.rate;
				      };
				    }
				      xhtp.open("GET", "OrderProductController?action=listproductquantitybyid&productid="+selectproduct, true);
				      xhtp.send(); 
				}
			
function avilable(){
	var avilableproduct=document.getElementById("quantity").value;
	var enter_quantity=document.getElementById("enter_quantity").value;
	

	
	if(enter_quantity>avilableproduct){
		alert("Sorry Available quantity is:"+avilableproduct);
	}
	
}	
function calculatetotal(){
	var product_price=document.getElementById("price").value;
	var enter_quantity=document.getElementById("enter_quantity").value;
	var totalamt=product_price*enter_quantity;
	//document.getElementById("totalamount").value =totalamount;
	$('#totalamount').val(totalamt);
	
}			
</script> 

<link rel="stylesheet" type="text/css"
	href="datepicker/jquery.datetimepicker.css" />
<style type="text/css">
.custom-date-style {
	background-color: red !important;
}

.input {
	
}

.input-wide {
	width: 500px;
}
</style>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script type="text/javascript" src="popup.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Order product</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
var qtyTotal = 0;
var priceTotal = 0;
var name="";
function updateForm(){
	var product=document.getElementById("productid").value;
	 var qty = document.getElementById("enter_quantity").value;
	 var price=document.getElementById("price").value;
	 var tota=document.getElementById("totalamount").value;
	 var user=document.getElementById("userid").value;
	 var orderno=document.getElementById("orderno").value;
	 var xhtp = new XMLHttpRequest();
	    xhtp.onreadystatechange = function() {
	      if (xhtp.readyState == 4 && xhtp.status == 200) {
	    	  var parsedUP = JSON.parse(xhtp.responseText);
	    	  name=parsedUP.productname;
		     
		      price=price*qty;
		  	
		      qtyTotal = qtyTotal + parseInt(qty);
		      document.getElementById("qtyTotals").innerHTML=qtyTotal;
		      priceTotal = priceTotal + parseInt(price);
		     
		      document.getElementById("priceTotals").innerHTML=priceTotal;
		      
		 	    
		      var table=document.getElementById("results");
		      var row=table.insertRow(-1);
		      var cell1=row.insertCell(0);
		      var cell2=row.insertCell(1);
		      var cell3=row.insertCell(2);
		      cell1.innerHTML=name;
		      cell2.innerHTML=qty;        
		      cell3.innerHTML=price;

	      };
	    }
	   
	      xhtp.open("GET", "OrderProductController?action=addcart&product="+product+"&total="+tota+"&userid="+user+"&qty="+qty+"&orderno="+orderno, true);
	      xhtp.send(); 
		alert("Added in Cart");
    
     
	  	
	   
}



</script>
</head>

<body>
	<%String role=session.getAttribute("role").toString(); %>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <h2> <a>Snap Sale</a></h2>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${email} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        
                       <li>
                          <a href="OrderProductController?action=myorder&loginid=<c:out value="${loginid}"/>"></i> MyOrders</a>
                        </li>
                        <li>
                          <a href="AddressController?action=myaddress&loginid=<c:out value="${loginid}"/>"></i> address</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                           <a href="LoginController?action=logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="dashboard.jsp"><i ></i> Dashboard</a>
                    </li>
                   
                   <%if(role.equals("Admin")){ %>
                    <li>
                       <a href="UserController?action=listuser"><i ></i> Users</a>
                    </li>
                   
                      <li>
                        <a href="AddressController?action=list"><i ></i> Address-Details-List</a>
                    </li>
                    <li>
                        <a href="DeliveryController?action=add"><i ></i> AddDelivery-Details-List</a>
                    </li>
                    <li>
                        <a href="DeliveryController?action=listuserdelivery"><i ></i> Delivery-Details-List</a>
                    </li>
                   <%} %> 
                    
                     
                    <li>
                        <a href="OrderProductController?action=add"><i ></i> Order</a>
                    </li>
                    
                     <%if(role.equals("Admin")){ %>
                    
                    <li>
                       <a href="OrderProductController?action=orderlist"><i ></i> Order_list</a>
                    </li>
                    <%} %>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i ></i> Product <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                         <%if(role.equals("Admin")){ %>
                            <li>
                                 <a href="ProductController?action=add"></i>Add Product</a>
                            </li>
                             <%} %>
                            <li>
                                <a href="ProductController?action=listproduct">List Product</a>
                            </li>
                        </ul>
                    </li>
                    
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>


		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
					<div class="row">
					<div class="col-sm-8"><h1 class="page-header">Product</h1></div>
					<div class="col-sm-4 text-right"><img src="imge2.jpg" id="add_cart" style="width:80px;position:relative;top:50px"></div>
					</div>
					
						
						
						<ol class="breadcrumb">
							<li><i></i> <a href="dashboard.jsp">Dashboard</a></li>
							<li class="active"><i></i> Order</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-6">

						<form role="form" action="OrderProductController?action=add"
							method="post" name="form1">
							<div class="form-group">
								<input class="form-control" placeholder="Enter text"
									type="hidden" name="id">
							</div>
							<div class="form-group">

								<input class="form-control" placeholder="Enter text"
									type="hidden" name="userid" value="${loginid}" id="userid">
							</div>
							
							<div class="form-group">
								<label>Order-no</label> 
								<input disabled="disabled" class="form-control"type="text" name="orderno" placeholder="orderno" value="${orderno}" id="orderno">
							</div>
							<div class="form-group" >
							
								<label>Accesories----Product-----Model</label><br> <select
									name="productid" size="1" onchange="setquantity()" id="productid">
									<option>select product</option>
									<c:forEach items="${loadproduct}" var="product">
									
										<option value="${product.id }"> ${product.accesories }------------${product.productname }--------${product.batchno }</option>
									</c:forEach>
								</select>
								
							</div>
							<div class="form-group" >
							<label>Availble</label><br>
							<input type="text" class="form-control" name="qun"  disabled="disabled" id="quantity">
							</div>
							<div class="form-group" >
							<label>Rate</label><br>
							<input type="text" class="form-control"  name="price"  disabled="disabled" id="price"><br>
							</div>
							<div class="form-group">
								<label>Quantity</label> 
								<input class="form-control" type="number" name="quantity" placeholder="quantity"  id="enter_quantity" oninput="calculatetotal()"  min="1" max="20">
							</div>
	
					<div class="form-group">
								<label>TotalAmount</label> 
								<input class="form-control" type="text" name="totalamt"  id="totalamount" disabled="disabled" value="">
							</div>
								<input type="hidden" name="status" value="not_deliverd">
			
							<button type="button" class="btn btn-lg btn-danger" onmouseover="avilable()" >Check</button>
							<button type="reset"  class="btn btn-lg btn-success">Again-order</button>
							 <button type="button"  class="btn btn-primary btn-lg" onClick="updateForm()">Add To cart</button>
							<a href="OrderProductController?action=myorder&loginid=<c:out value="${loginid}"/>"> <button type="button"  class="btn btn-primary btn-lg">Finish</button></a>
						</form>
							
					</div>

				<div class="col-lg-6" style="display:none" id="table">
                       
                        <div class="table-responsive">
				<table id="results" width="360" class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th scope="col" width="120">Products-Id</th>
         
        <th scope="col" width="120">Quantity</th>
        <th scope="col" width="120">Price</th>
    </tr>
    </thead> 
</table>
</div>
 <div class="table-responsive">
<table id="resultTotals" width="360" border="1"  class="table table-bordered table-hover table-striped">
<tr class="warning">
    <td scope="col" width="120"></td>
    
    <td scope="col" width="120"><div id="qtyTotals"></div></td>
    <td scope="col" width="120"><div id="priceTotals"></div></td>
</tr>
</table>

	</div></div>
	
				
				</div>
				
				
						<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>
<script src="datepicker/jquery.js"></script>
<script src="datepicker/build/jquery.datetimepicker.full.js"></script>
<script type="text/javascript">
	$.datetimepicker.setLocale('en');

	$('#datetimepicker_mask').datetimepicker({
		mask : '9999/19/39 29:59'
	});

	$('#datetimepicker_dark').datetimepicker({
		theme : 'dark'
	})
</script>
<script>
$(document).ready(function(){
	$("#add_cart").click(function(){
		$("#table").toggle();
	});
	
});
</script>
</html>
