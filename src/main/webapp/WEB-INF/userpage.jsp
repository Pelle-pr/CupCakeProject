<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<ul>
    <li><a class="active" href="FrontController?target=userpage">Users</a></li>
    <li><a href="FrontController?target=orderpage">Orders</a></li>
    <li id="email"><a href="FrontController?target=logout">${sessionScope.email} (logout)</a>


</ul>


<div class="text-center">
    <table class="table table-striped mt-2">
        <tr>
            <td>User ID</td>
            <td>Email</td>
            <td>Password</td>
            <td>Saldo</td>
            <td></td>
        </tr>
        <c:forEach var="user" items="${sessionScope.allUsersList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.saldo}</td>
                <td>
                    <form name="money" action="FrontController" method="POST">
                        <input type="hidden" name="target" value="insertmoney">
                        <input type="text" name="money">
                        <button type="submit" class="button" name="user_saldo" value="${user.id}">Add Money
                        </button>
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="../includes/footer.inc" %>