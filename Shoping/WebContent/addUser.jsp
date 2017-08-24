<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
  <meta charset="UTF-8">
  <title>Sign Up</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="design/css/style.css">

  
</head>

<body>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
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
    </head>
    <body>

     <form action="UserController?action=add&userid=<c:out value="${user.id}"/>" method="post" name="registration"onSubmit="return formValidation();"  >
      
        <h1>Sign Up</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Your basic info</legend>
          <input type="hidden" name="id"  value="<c:out value="${user.id}" />">
          <label for="name">Name:</label>
          <input type="text" id="name" name="name"  value="<c:out value="${user.name}" />">
          
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="email"  value="<c:out value="${user.email}" />">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="password"  value="<c:out value="${user.password}" />">
          <fieldset>
            <label for="job">Gender:</label>
            <select name="gender"  value="<c:out value="${user.gender}" />">
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="other">Others</option>

            </select>
          </fieldset>
          <label>Age:</label>
          <input type="text" name="age"  value="<c:out value="${user.age}" />">
        </fieldset>
        
        <fieldset>
          <legend><span class="number">2</span>Other Info</legend>
         
         
        </fieldset>
        <fieldset>
        <label for="job">Role:</label>
        <select name="role"  value="<c:out value="${user.role}" />">

            <option value="Admin">Admin</option>
            
            <option value="Customer">Customer</option>

        </select>
        
      
        
        </fieldset>
        <button type="submit">Sign Up</button>
      </form>
      
    </body>
</html>
  
  
</body>
</html>
