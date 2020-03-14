<%@ page import="UtilHelpers.Quantity" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% request.setAttribute("quantitylist", Quantity.getQuantity());%>
<%@ page import="DB.BottomMapper" %>
<%@ page import="DB.ToppingMapper" %>
<% request.setAttribute("bottomlist", BottomMapper.getAllBottoms()); %>
<% request.setAttribute("toppinglist", ToppingMapper.getAllToppings()); %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${sessionScope.user}</title>
</head>
<body>


<h1>Hello ${sessionScope.email} </h1>

<form action="FrontController" method="get">
    <input type="hidden" name="target" value="søg">
    <div class="form-group">


        <label for="bottom">Bund</label>
        <select class="form-control" id="bottom" name="bottom">
            <c:forEach var="bottom" items="${requestScope.bottomlist}">
                <option>${bottom}</option>
            </c:forEach>
        </select>

        <label for="topping">Top</label>
        <select class="form-control" id="topping" name="topping">
            <c:forEach var="topping" items="${requestScope.toppinglist}">
                <option>${topping}</option>
            </c:forEach>
        </select>

        <label for="quantity">Antal</label>
        <select class="form-control" id="quantity" name="quantity">
            <c:forEach var="quantity" items="${requestScope.quantitylist}">
                <option>${quantity}</option>
            </c:forEach>


        </select>
        <br>

        <input type="submit" value="Søg"/>
    </div>
</form>


You are now logged in as a customer of our wonderful site.
</body>
</html>
