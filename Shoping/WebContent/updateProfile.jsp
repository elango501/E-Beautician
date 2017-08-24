<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<html lang="en">

<head>
 <script type="text/javascript">
        function formValidation()  
        {  
       
        var passid = document.registration.password;  
        var uname = document.registration.name;  
          
        var uzip = document.registration.age;  
        var uemail = document.registration.email;  
       
        
        
          
        if(allLetter(uname))  
        {  
        if  (passid_validation(passid,7,12))
        {  
           
         
        if(allnumeric(uzip))  
        {  
        if(ValidateEmail(uemail))  
        {  
         
        }  
        }   
        }  
        }   
          
        
         
         
        return false;  
          
        } 
         
        function passid_validation(passid,mx,my)  
        {  
        var passid_len = passid.value.length;  
        if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
        {  
        alert("Password should not be empty / length be between "+mx+" to "+my);  
        passid.focus();  
        return false;  
        }  
        return true;  
        }  
        function allLetter(uname)  
        {   
        var letters = /^[A-Za-z]+$/;  
        if(uname.value.match(letters))  
        {  
        return true;  
        }  
        else  
        {  
        alert('Username must have alphabet characters only');  
        uname.focus();  
        return false;  
        }  
        }  
          
         
        function allnumeric(uzip)  
        {   
        var numbers = /^[0-9]+$/;  
        if(uzip.value.match(numbers))  
        {  
        return true;  
        }  
        else  
        {  
        alert('AGE code must have numeric characters only');  
        uzip.focus();  
        return false;  
        }  
        }  
        function ValidateEmail(uemail)  
        {  
        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
        if(uemail.value.match(mailformat))  
        {  
        return true;  
        }  
        else  
        {  
        alert("You have entered an invalid email address!");  
        uemail.focus();  
        return false;  
        }  
        }
        
        </script>
<script type="text/javascript" src="popup.js"></script>
<script type="text/javascript">
	function check() {
		var qun = document.elementById('demo').value;
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
					<h1 class="page-header">Address</h1>
					<ol class="breadcrumb">
						<li><i></i> <a href="dashboard.jsp">Dashboard</a></li>
						<li class="active"><i></i> Address</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-6">

					<form name="registration"onSubmit="return formValidation();"
						action="UserController?action=add&userid=<c:out value="${user.id}"/>"
						method="post">
						<div class="form-group">
							<input type="hidden" name="id"
								value="<c:out value="${user.id}" />">
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-control"
								id="name" name="name" value="<c:out value="${user.name}" />">
						</div>

						<div class="form-group">
							<label>Email</label> <input type="email" id="email" required="required"
								name="email" value="<c:out value="${user.email}" />">
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" id="password"
								name="password" value="<c:out value="${user.password}" />">
						</div>
						<div class="form-group">
							<label>Gender</label> <select name="gender"
								value="<c:out value="${user.gender}" />">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="other">Others</option>

							</select>
						</div>
						<div class="form-group">
							<label>Age</label> <input type="text" name="age"
								value="<c:out value="${user.age}" />">
						</div>

						<div class="form-group">
							<label>Role</label> <select name="role" 
								value="<c:out value="${user.role}" />">

								<option value="Admin">Admin</option>
								
								<option value="Customer">Customer</option>

							</select>
						</div>

						<button type="submit" class="btn btn-default">Update</button>
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
<%@include file="popup.jsp"%>
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
