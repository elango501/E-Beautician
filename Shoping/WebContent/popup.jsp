<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="popup" data-popup="popup-1">
    <div class="popup-inner">
        <h1>Profile Details</h1>
        <div class="table-responsive">
            <table border="0" class="table table-bordered table-hover">
                <thead>

                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Age</th>
                
                <th>Role</th>



                </thead>

                <c:forEach var="user" items="${profile}">
                    <tr>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td><c:out value="${user.email}"></c:out></td>
                        <td><c:out value="${user.gender}"></c:out></td>
                        <td><c:out value="${user.age}"></c:out></td>
                        
                        <td><c:out value="${user.role}"></c:out></td>
						<td><a href="UserController?action=edit&userid=<c:out value="${user.id}"/>">Edit-Profile</a></td>
                    </tr>

                </c:forEach>
            </table>
        </div></p>

        <a class="popup-close" data-popup-close="popup-1" href="#">x</a>
    </div>
</div>
</body>
</html>