<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>

<ul>
    <li><a class="active" href="FrontController?target=redirect&destination=customerpage">Cupcakes</a></li>
    <li><a href="FrontController?target=redirect&destination=basket">Basket</a></li>
    <li><a href="FrontController?target=myorders">My Orders</a></li>
    <li id="saldo"><a href="#" class="not-active">Saldo: ${sessionScope.saldo}</a></li>
    <li id="email"><a href="#" class="not-active">${sessionScope.email}</a>
    <li><a href="FrontController?target=logout">Logout</a> </li> </a>

</ul>


<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

<form action="FrontController" method="get">
    <input type="hidden" name="target" value="basket">
    <div class="form-group">

        <div class="col-md-4 mt-3">
        <label for="bottom"></label>
        <select class="form-control" id="bottom" name="bottom">
            <option selected disabled value="">Choose bottom</option>
            <c:forEach var="bottom" items="${applicationScope.bottomlist}">
                <option value="${bottom.id}">${bottom.name} - ${bottom.price} kr</option>
            </c:forEach>
        </select>
        </div>

        <div class="col-md-4 mt-3">
        <label for="topping"></label>
        <select class="form-control" id="topping" name="topping">
            <option selected disabled value="">Choose topping</option>
            <c:forEach var="topping" items="${applicationScope.toppinglist}">
                <option value="${topping.id}">${topping.name} - ${topping.price} kr</option>
            </c:forEach>
        </select>
        </div>

        <div class="col-md-4 mt-3">
        <label for="quantity"></label>
        <select class="form-control" id="quantity" name="quantity">
            <option selected disabled value="">Choose quantity</option>
            <c:forEach var="quantity" items="${applicationScope.quantity}">
                <option>${quantity}</option>
            </c:forEach>


        </select>
        </div>
        <br>

        <input type="submit" value="Add to basket"/>
    </div>
</form>



You are now logged in as a customer of our wonderful site.




<%@include file="../includes/footer.inc"%>