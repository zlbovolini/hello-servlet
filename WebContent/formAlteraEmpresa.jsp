<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.github.zlbovolini.gerenciador.servlet.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${linkServletAlteraEmpresa}" method="POST">
        <input type="hidden" name="id" value="${company.id}"/>
        <div>
            <label>Nome:</label>
            <input type="text" name="name" value="${company.name}"/>
        </div>
        <div>
            <label>Data de abertura:</label>
            <input type="text" name="foundedAt" value="<fmt:formatDate value="${company.foundedAt}" pattern="dd/MM/yyyy"/>"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>