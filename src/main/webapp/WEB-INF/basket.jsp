<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach var="cupcake" items="${sessionScope.basket}">
        <li>${cupcake.cupCake.bottom.name}, ${cupcake.cupCake.topping.name}, ${cupcake.cupCake.quantity},${cupcake.cupCake.sum}</li>
        <br>

    </c:forEach>
</ol>

</body>
</html>
