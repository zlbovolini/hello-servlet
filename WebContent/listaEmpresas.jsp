<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.github.zlbovolini.gerenciador.servlet.Company, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

    <label>Lista de empresas:</label>
    <br/>
    <ul>
        <c:forEach items="${companies}" var="company">
            <li>${company.name}</li>
        </c:forEach>
    </ul>

</body>
</html>