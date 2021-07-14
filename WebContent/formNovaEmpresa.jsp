<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${linkServletNovaEmpresa}" method="POST">
        <div>
            <label>Nome:</label>
            <input type="text" name="name"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>