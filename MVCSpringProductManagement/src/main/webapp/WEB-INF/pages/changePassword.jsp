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

<h2>Change password</h2>
<form name="confirmChangePassword" action="confirmChangePassword" method="POST" >
    <table>
    		<tr>
               <td>Current:</td>
               <td><input type="password" name="current" /></td>   
           </tr>
           <tr>
               <td>New:</td>
               <td><input type="password" name="new" /></td>   
           </tr>
           <tr>
               <td>Re-type new:</td>
               <td><input type="password" name="retypenew" /></td>   
           </tr>
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Save changes" />
                  <a href="${pageContext.request.contextPath}/infoStaff">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
    </table>
</form>
   <c:if test="${not empty message}">
  
   <div class="error-message">${message}</div>
	</c:if>
</body>
</html>