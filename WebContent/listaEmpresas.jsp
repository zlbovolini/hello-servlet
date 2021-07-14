<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.github.zlbovolini.gerenciador.servlet.Company, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkServletMostraEmpresa"/>

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
            <li>
                ${company.name} - <fmt:formatDate value="${company.foundedAt}" pattern="dd/MM/yyyy"/>
                <a href="${linkServletMostraEmpresa}?id=${company.id}">edita</a>
                <a href="${linkServletRemoveEmpresa}?id=${company.id}">remove</a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>