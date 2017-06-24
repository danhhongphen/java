<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create product</title>
<style>
.error-message {
   color: red;
   font-size:90%;
   font-style: italic;
}
</style>
</head>
<body>
 
   <h3>Create product</h3>
 
   <form:form action="saveProducts" method="POST"
       modelAttribute="productsForm">
       <table>
       		<tr>
               <td>Id:</td>
               <td><form:input path="id" /></td>
               <td><form:errors path="id"
                       class="error-message" /></td>      
           </tr>
           <tr>
               <td>Id product:</td>
               <td><form:input path="product_id" /></td>
               <td><form:errors path="product_id"
                       class="error-message" /></td>      
           </tr>
           
           <tr>
               <td>Name:</td>
               <td><form:input path="name" /></td>
               <td><form:errors path="name"
                       class="error-message" /></td>      
           </tr>
           
           
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/productsList">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
   </form:form>
 
</body>
</html>