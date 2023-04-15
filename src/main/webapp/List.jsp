<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table border="1px solid black">
            <tr>
                <th>uID</th>
                <th>User</th>
                <th>Pass</th>
                <th>isSell</th>
                <th>isAdmin</th>
            </tr>
            <c:forEach items="${listA}" var="o">
                <tr>
                    <td>${o.id }</td>
                    <td>${o.user }</td>
                    <td>${o.pass }</td>
                    <td>${o.isSell }</td>
                    <td>${o.isAdmin }</td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach begin="1" end="${endP}" var="i">
            <a class="${tag == i?"active":""}" href="ListAccount?index=${i}">${i}</a>
        </c:forEach>
    </body>
</html>
