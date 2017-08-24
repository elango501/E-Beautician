
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Address-Deatils</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                        <h1 class="page-header">
                            Address_Details
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i ></i>  <a href="dashboard.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i ></i> Address
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                        <div class="row">
                    <div class="col-lg-8">
                        <h3> <a href="AddressController?action=add"> ADD-Address-Details</a></h3>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                    <th>Username</th>
                                        <th>Street</th>
                                        <th>Place</th>
                                        <th>City</th>
                                        <th>Zipcode</th>
                                         <%if(role.equals("Admin")){ %> 
                                        <th>Action</th>
                                        <%} %>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="address" items="${addresslist}">
                                    <tr class="active">
                                     <td><c:out value="${address.username}"></c:out></td>
                                        <td><c:out value="${address.street}"></c:out></td>
										<td><c:out value="${address.place}"></c:out></td>
										<td><c:out value="${address.city}"></c:out></td>
											<td><c:out value="${address.zipcode}"></c:out></td>
											<%if(role.equals("Admin")){ %> 
											<td><a href="AddressController?action=delete&id=<c:out value="${address.id}" />">Delete</a>|
				 <%} %>
                                    </tr>
                                    </c:forEach>
                                  
                                 
                                
                                    
                                </tbody>
                                <%if(role.equals("Customer")||role.equals("Admin")){ %>
                                  <tbody>
                                <c:forEach var="address" items="${myaddresslist}">
                                    <tr class="active">
                                     <td><c:out value="${address.username}"></c:out></td>
                                        <td><c:out value="${address.street}"></c:out></td>
										<td><c:out value="${address.place}"></c:out></td>
										<td><c:out value="${address.city}"></c:out></td>
											<td><c:out value="${address.zipcode}"></c:out></td>
											
											<td><a href="AddressController?action=delete&id=<c:out value="${address.id}" />">Delete</a>|
				<td><a href="AddressController?action=edit&addressid=<c:out value="${address.id}"/>">Update</a></td> 
                                    </tr>
                                    </c:forEach>
                                  
                                 
                                
                                    
                                </tbody>
                                <%} %>
                            </table>
                        </div>
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

</html>
