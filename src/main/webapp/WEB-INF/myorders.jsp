<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<ul>
    <li><a href="FrontController?target=redirect&destination=customerpage">Cupcakes</a></li>
    <li><a href="FrontController?target=redirect&destination=basket">Basket</a></li>
    <li><a class="active" href="FrontController?target=redirect&destination=myorders">My Orders</a></li>
    <li id="saldo"><a href="#" class="not-active">Saldo: ${sessionScope.saldo}</a></li>
    <li id="email"><a href="FrontController?target=logout">${sessionScope.email} (logout)</a>
</ul>


<div class="text-center">
    <table class="table table-striped">
        <tr><td>Order number</td><td>Date</td><td>Quantity</td><td>Bottom</td><td>Topping</td><td>Sum</td><td>Status</td></tr>
        <c:forEach var="orders" items="${sessionScope.myorderlist}">
        <tr><td>${orders.order_id}</td><td>${orders.date}</td><td>${orders.quantity}</td><td>${orders.bottom_name}</td><td>${orders.topping_name}</td><td>${orders.sum}</td><td>${orders.status}</td></tr>
        </c:forEach>
    </table>
</div>




<%@include file="../includes/footer.inc"%>