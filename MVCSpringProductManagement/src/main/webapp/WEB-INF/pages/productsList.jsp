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
 
 
 
<a href="${pageContext.request.contextPath}/createProducts">Create product</a>
 
<br/>
 
 
<table border="1">
 <tr>
   <th>ID</th>
   <th>Product ID</th>
   <th>Name</th>
   <th>Edit</th>
   <th>Delete</th>
 </tr>

 <c:forEach items="${productsInfos}" var="info">
 
 <tr>
 	<td>${info.id } </td>
   <td> ${info.product_id}  </td>
   <td> ${info.name}  </td>
   <td> <a href="deleteProducts?id=${info.id}">Delete</a> </td>
   <td> <a href="editProducts?id=${info.id}">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
<form name="listProductDelete" action="listProductDelete" method="POST" >
    <ul>
        <label>Input Product ID to muilty delete(ID1,ID2):</label> <input type='text' name='list' />
        <label>&nbsp;</label> <input type="submit" value="Delete" class="btn">
    </ul>
</form>
 
</body>
</html>