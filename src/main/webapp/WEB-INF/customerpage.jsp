<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>

<ul>
    <li><a class="active" href="FrontController?target=redirect&destination=customerpage">Cupcakes</a></li>
    <li><a href="FrontController?target=redirect&destination=basket">Basket</a></li>
    <li><a href="FrontController?target=myorders">My Orders</a></li>
    <li>     Hello ${sessionScope.email}</li>
    <li> Din saldo er: ${sessionScope.saldo}</li>

</ul>


<%--<h1>Hello ${sessionScope.email} </h1>--%>
<%--<h2>${sessionScope.saldo}</h2>--%>
<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

<form action="FrontController" method="get">
    <input type="hidden" name="target" value="basket">
    <div class="form-group">


        <label for="bottom">Bund</label>
        <select class="form-control" id="bottom" name="bottom">
            <c:forEach var="bottom" items="${applicationScope.bottomlist}">
                <option value="${bottom.id}">${bottom.name}</option>
            </c:forEach>
        </select>

        <br>

        <label for="topping">Top</label>
        <select class="form-control" id="topping" name="topping">
            <c:forEach var="topping" items="${applicationScope.toppinglist}">
                <option value="${topping.id}">${topping.name}</option>
            </c:forEach>
        </select>
        <br>
        <label for="quantity">Antal</label>
        <select class="form-control" id="quantity" name="quantity">
            <c:forEach var="quantity" items="${applicationScope.quantity}">
                <option>${quantity}</option>
            </c:forEach>


        </select>
        <br>

        <input type="submit" value="Add to basket"/>
    </div>
</form>
<%--<a href="FrontController?target=redirect&destination=basket" ><h5>Kurv</h5></a>--%>


You are now logged in as a customer of our wonderful site.




<%@include file="../includes/footer.inc"%>