<html>
<head>
<%@ include file="./base.jsp"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>



<!--  STEP 18 : Display the details send from display all (Home Controller ) using table
using the jstl (c:out loops ) and expression language(${p.name}) for the loop to display table rows
Also two button are also given (delete , update ) which takes to suitable handler  method through href to perfrom the given task

Next step is to make the handler for delete and update (step 19)

--> 



<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Welcome to Product App</h1>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S_NO</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
<c:forEach items="${products}" var="p">
       
    <tr>
      <th scope="row">Learn Id ${p.id}</th>
      <td>${p.name}</td> 
      <td>${p.description}</td>
      <td>&#8377 ${p.price}</td>
      <td>
      <a href="delete/${p.id}"><i class="fas fa-trash text-danger" style="font-size:30px;" aria-hidden="true"></i></a>
       
       <a href="update/${p.id}"><i class="fas fa-pen-nib text-primary" style="font-size:30px;" aria-hidden="true"></i></a>
      
      </td>
      
      
      
    </tr>
   
   </c:forEach>
   
   
   
   
  </tbody>
</table>

<div class="container text-center">
<a href="add-product" 
class="btn btn-outline-success">Add Product</a>
</div>

</div>

</div>
</div>

</body>
</html>
