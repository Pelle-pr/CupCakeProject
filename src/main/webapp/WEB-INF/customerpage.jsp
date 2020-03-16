<%@ page import="UtilHelpers.Quantity" %>
<%@ page import="UtilHelpers.ToppingBottom" %>
<%@ page import="FunctionLayer.Bottom" %>
<%@ page import="FunctionLayer.Topping" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${sessionScope.user}</title>
</head>
<body>


<h1>Hello ${sessionScope.email} </h1>



<form action="FrontController" method="get">
    <input type="hidden" name="target" value="basket">
    <div class="form-group">


        <label for="bottom">Bund</label>
        <select class="form-control" id="bottom" name="bottom">
            <c:forEach var="bottom" items="${sessionScope.bottomlist}">
                <option>${bottom}</option>
            </c:forEach>
        </select>

        <br>

        <label for="topping">Top</label>
        <select class="form-control" id="topping" name="topping">
            <c:forEach var="topping" items="${sessionScope.toppinglist}">
                <option>${topping}</option>
            </c:forEach>
        </select>
        <br>
        <label for="quantity">Antal</label>
        <select class="form-control" id="quantity" name="quantity">
            <c:forEach var="quantity" items="${sessionScope.quantitylist}">
                <option>${quantity}</option>
            </c:forEach>


        </select>
        <br>

        <input type="submit" value="søg"/>
    </div>
</form>
<a href="FrontController?target=redirect&destination=basket" ><h5>Kurv</h5></a>


You are now logged in as a customer of our wonderful site.
</body>
</html>
