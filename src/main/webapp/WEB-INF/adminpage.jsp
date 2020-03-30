<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<ul>
    <li><a href="FrontController?target=userpage">Users</a></li>
    <li><a href="FrontController?target=orderpage">Orders</a></li>
    <li id="email"><a href="FrontController?target=logout">${sessionScope.email} (logout)</a>
</ul>

<h3>Her kan du håndtere kunder og ordre</h3>

<%@include file="../includes/footer.inc" %>