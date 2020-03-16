<%--
  Created by IntelliJ IDEA.
  User: MariHaugen
  Date: 16/03/2020
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>

<ol>
    <c:forEach var="cupcake" items="${requestScope.basket}">
        <li>${cupcake.bottom}, ${cupcake.topping}, ${cupcake.quantity}</li>
        <br>

    </c:forEach>
</ol>

</body>
</html>
