<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicant List</title>
<style>
   table  {
       margin-top: 10px;
       border: solid black 1px;
   }
   table  td {
        padding: 5px;
   }
   .message  {
        font-size:90%;
        color:blue;
        font-style:italic;
        margin-top:30px;
   }
</style>
</head>
<body>
 
 
 
<a href="${pageContext.request.contextPath}/infoStaff">Information Staff</a>
 
<br/>
 
 
<table border="1">
 <tr>
   <th>Product ID</th>
   <th>Name</th>
 </tr>
 <c:forEach items="${productsInfos}" var="info">
 
 <tr>
   <td> ${info.product_id}  </td>
   <td> ${info.name}  </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 
 
 
</body>
</html>