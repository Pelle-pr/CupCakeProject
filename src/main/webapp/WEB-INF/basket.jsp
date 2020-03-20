<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc" %>

<ul>
    <li><a href="FrontController?target=redirect&destination=customerpage">Cupcakes</a></li>
    <li><a class="active" href="FrontController?target=basket">Basket</a></li>
    <li><a href="FrontController?target=redirect&destination=myorders">My Orders</a></li>
    <li id="saldo"><a href="#" class="not-active">Saldo: ${sessionScope.saldo}</a></li>
    <li id="email"><a href="#" class="not-active">${sessionScope.email}</a></li>
</ul>

<div class="text-center">
    <form action="FrontController" method="post">
        <input type="hidden" name="target" value="deleteOrderLine">
        <table class="table table-striped">
            <tr>
                <td>Bottom</td>
                <td>Topping</td>
                <td>Quantity</td>
                <td>Sum</td>
                <td></td>
            </tr>
            <c:forEach var="cupcake" items="${sessionScope.basket.cupCakeList}">
            <tr>
                <td>${cupcake.bottom.name}</td>
                <td>${cupcake.topping.name}</td>
                <td>${cupcake.quantity}</td>
                <td>${cupcake.sum}</td>
                <td>
                    <button type="submit" class="button" name="remove" value="${cupcake.orderline_id}">Remove
                    </button>
                </td>

            </tr>
            </c:forEach>
            </table>

    </form>

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>Total sum</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>${sessionScope.totalSum}</td>
            </tr>

            <br>
            <form name="newOrder" action="FrontController" method="post">
                <input type="hidden" name="target" value="newOrder">
                <input type="submit" value="Køb">
            </form>
            <br><br>

</div>


<%@include file="../includes/footer.inc" %>