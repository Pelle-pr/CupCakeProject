<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<ul>
    <li><a href="FrontController?target=redirect&destination=customerpage">Cupcakes</a></li>
    <li><a href="FrontController?target=basket">Basket</a></li>
    <li><a class="active" href="FrontController?target=redirect&destination=myorders">My Orders</a></li>
</ul>


<div class="text-center">
    <table class="table table-striped">
        <tr><td>Order number</td><td>Bottom</td><td>Topping</td><td>Quantity</td><td>Sum</td></tr>


        <c:forEach var="cupcake" items="${sessionScope.basket}">
        <tr><td>${cupcake.cupCake.bottom.name}</td><td>${cupcake.cupCake.topping.name}</td><td>${cupcake.cupCake.quantity}</td><td>${cupcake.cupCake.sum}</td></tr>

        <br>


        </c:forEach>


        <form name="newOrder" action="FrontController" method="post">
            <input type="hidden" name="target" value="newOrder">
            <input type="submit" value="Køb">
        </form>
        <br>
        ${sessionScope.totalSum}
</div>




<%@include file="../includes/footer.inc"%>