<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/9/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form method="post" action="/discount">
    <label>Product Description: </label><br>
    <input type="text" name="description" placeholder="Description" value="Shoes"/><br/>
    <label>List Price: </label><br>
    <input type="text" name="price" placeholder="Price" value="200000"/><br/>
    <label>Discount Percent: </label><br>
    <input type="text" name="discount" placeholder="Discount Percent" value="20"/><br/>
    <input type = "submit" id = "submit" value = "Calculate"/>
  </form>
  </body>
</html>
