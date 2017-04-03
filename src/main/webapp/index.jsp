<%-- 
    Document   : index
    Created on : Mar 14, 2011, 9:04:54 PM
    Author     : Instlogin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Choose a JPA Database Operation</h2>
        <p><a href="FrontController?action=getAllMfgs">Get All Manufacturers</a></p>
        <br>
        <p><a href="FrontController?action=getAllProducts">Get All Products</a></p>
        <br>
        <form id="deleteByIdForm" name="deleteByIdForm" method="POST" action="FrontController?action=deleteById">
            <label for="productId">
                Delete by Product ID
            </label> 
            <input type="number" id="productId" name="productId" value="">
            <br>
            <br>
            <input type="submit" name="submit" value="submit">
        </form>
        <br>
        <form id="findAllByManufacturerIdForm" name="findAllByManufacturerIdForm" method="POST" action="FrontController?action=findAllByManufacturerId">
            <label for="manufacturerId">
                Find all by Manufacturer ID
            </label>    
            <input type="number" id="manufacturerId" name="manufacturerId" value="">
            <br>
            <br>
            <input type="submit" name="submit" value="submit">
        </form>
        <br>
    </body>
</html>
