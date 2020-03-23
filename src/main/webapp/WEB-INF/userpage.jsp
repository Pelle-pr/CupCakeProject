<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<ul>
    <li><a class="active" href="FrontController?target=redirect&destination=customerpage">Users</a></li>
    <li><a href="FrontController?target=redirect&destination=basket">Orders</a></li>


</ul>


<div class="text-center">
    <table class="table table-striped">
        <tr>
            <td>User ID</td>
            <td>Email</td>
            <td>Password</td>
            <td>Saldo</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach var="user" items="${sessionScope.allUsersList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.saldo}</td>

                <td>
                    <button type="submit" class="button" name="remove" value="${user.id}">Remove
                    </button>
                </td>
                <td>
                    <button type="submit" class="button" name="saldo" value="${user.id}">Add Money
                    </button>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="../includes/footer.inc" %>