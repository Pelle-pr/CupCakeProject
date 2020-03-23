<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<ul>
    <li><a href="FrontController?target=userpage">Users</a></li>
    <li><a class="active" href="FrontController?target=orderpage">Orders</a></li>


</ul>


<div class="text-center">
    <table class="table table-striped">
        <tr>
            <td>User ID</td>
            <td>Order ID</td>
            <td>Date</td>
            <td>Quantity</td>
            <td>Sum</td>
            <td>Bottom</td>
            <td>Topping</td>
            <td></td>
        </tr>
        <c:forEach var="adminorder" items="${sessionScope.allOrdersList}">
            <tr>
                <td>${adminorder.customer_id}</td>
                <td>${adminorder.order_id}</td>
                <td>${adminorder.date}</td>
                <td>${adminorder.quantity}</td>
                <td>${adminorder.sum}</td>
                <td>${adminorder.bottom_name}</td>
                <td>${adminorder.topping_name}</td>

                <td>
                    <button type="submit" class="button" name="remove" value="${user.id}">Remove
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="../includes/footer.inc" %>