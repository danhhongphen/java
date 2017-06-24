<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
   <title>Spring MVC Form Handling</title>
   <style>
.error-message {
   color: red;
   font-size:90%;
   font-style: italic;
}
</style>
</head>
<body>

<h2>Login</h2>
<form:form method="POST" action="/MVCProductManagement/processUser">
   <table>
      <tr>
         <td><form:label path="username">User ID:</form:label></td>
         <td><form:input path="username" /></td>
      </tr>
      <tr>
         <td><form:label path="password">Password:</form:label></td>
         <td><form:password path="password" /></td>
      </tr>  
      <tr>
         <td colspan="2">
            <input type="submit" value="Login"/>
         </td>
      </tr>
   </table>  
</form:form>
   <c:if test="${not empty message}">
  
   <div class="error-message">${message}</div>
	</c:if>
</body>
</html>