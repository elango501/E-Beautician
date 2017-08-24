<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<html lang="en">

<head>
<%List list = new ArrayList(); %>
<script type="text/javascript">

function setorder()
				{
					var id = document.getElementById("userid");
					var selectuser = id.options[id.selectedIndex].value;				
					var xhtp = new XMLHttpRequest();
				    xhtp.onreadystatechange = function() {
				      if (xhtp.readyState == 4 && xhtp.status == 200) {
				     var   data = JSON.parse(xhtp.responseText)
				   
				
				     var orderidoption = document.getElementById("orderid");
				     document.getElementById("orderid").value = parseFloat(data[0].orderno);
					 for(var j=0; j<data.length; j++){
					     	   var orderoption = document.createElement("option"); // Create the new element
					     	  orderoption.value = data[j].orderno;
					     	 orderoption.text =  data[j].orderno; 
					     	  orderidoption.appendChild(orderoption); 
					        }
				       }
				      };
				   
				      xhtp.open("GET", "DeliveryController?action=loadorderidbyuser&userid="+selectuser, true);
				      xhtp.send(); 
				

				      }
				      function setaddress(){
				    	  var id = document.getElementById("userid");
				    	  var selectuser = id.options[id.selectedIndex].value;	
				    	  var xhtp = new XMLHttpRequest();
				    	  xhtp.onreadystatechange = function() {
						      if (xhtp.readyState == 4 && xhtp.status == 200) {
						       var placedata = JSON.parse(xhtp.responseText);
						       //document.getElementById("place").text =placedata.place;
						       document.getElementById("place").value =placedata.placeid;
						   	alert(placedata.place);
						      };
						    }
				    	  xhtp.open("GET", "DeliveryController?action=loadaddressbyuser&userid="+selectuser, true);
					      xhtp.send();
				      }

</script>
<link rel="stylesheet" type="text/css"
	href="datepicker/jquery.datetimepicker.css" />
<style type="text/css">
.custom-date-style{
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
						<h1 class="page-header">Delivery</h1>
						<ol class="breadcrumb">
							<li><i></i> <a href="dashboard.jsp">Dashboard</a></li>
							<li class="active"><i></i> Delivery</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-6">

						<form role="form" action="DeliveryController?action=add"
							method="post" name="form1">
							<div class="form-group">
								<input class="form-control" placeholder="Enter text"
									type="hidden" name="id">
							</div>
							 
							<div>
								<label>User</label><br> <select
									name="userid" size="1" onchange="setorder()" id="userid">
									<option>select user</option>
									<c:forEach items="${loaduser}" var="user">
									
										<option value="${user.id }"> ${user.email}</option>
									</c:forEach>
								</select>
								
							</div>
							<div class="form-group" >
							
								<label>Order-No</label><br> <select name="orderid" size="1"  id="orderid" onchange="setaddress()"  >
									<option>select Orderno</option>
									<%-- <c:forEach items="${loadorder}" var="order">
									
										<option value="${order.id }"> ${order.id}</option>
									</c:forEach> --%>
								</select>
								
							</div>
							 
							<div class="form-group">
								<label></label> <input class="form-control"
									type="hidden" name="street"  value="" id="place">
							</div>
							
							<div class="form-group">
								<label>Delivery-Date</label> <input class="form-control"
									type="text" name="ddate" placeholder="deliverydate"
									id="datetimepicker_mask">
							</div>
						
							
								
								
						
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default">Reset</button>

						</form>
							
					</div>

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
</html>
