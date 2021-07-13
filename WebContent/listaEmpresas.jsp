<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.github.zlbovolini.gerenciador.servlet.Company, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

    <label>Lista de empresas:</label>
    <br/>
    <ul>
    <%
        List<Company> companies = (List<Company>)request.getAttribute("companies");
        for (Company company : companies) {
    %>
        <li><%= company.getName() %></li>
    <%
        }
    %>
    </ul>

</body>
</html>