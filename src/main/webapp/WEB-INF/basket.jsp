<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MariHaugen
  Date: 16/03/2020
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<ul>
    <li><a href="FrontController?target=index">Home</a></li>
    <li><a class="active" href="FrontController?target=basket">Basket</a></li>
    <li><a href="FrontController?target=checkOut">Check out</a></li>
</ul>


<div class="text-center">
    <table class="table table-striped">
        <tr><td>Bottom</td><td>Topping</td><td>Quantity</td><td>Sum</td></tr>

    <c:forEach var="cupcake" items="${sessionScope.basket}">
        <tr><td>${cupcake.cupCake.bottom.name}</td><td>${cupcake.cupCake.topping.name}</td><td>${cupcake.cupCake.quantity}</td><td>${cupcake.cupCake.sum}</td></tr>

        <br>


    </c:forEach>



</div>




<%@include file="../includes/footer.inc"%>