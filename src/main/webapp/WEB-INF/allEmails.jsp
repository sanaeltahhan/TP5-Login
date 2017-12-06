<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title> <spring:message code="allmail.title"/> </title>
</head>
<body>
    <a href="/allMail?lang=en">EN</a>
    <a href="/allMail?lang=fr_FR">FR</a>

    <form action="/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form>

   <!-- <a href="/logout">Logout</a>-->


    <div>
        <div>
            <a href="/sendEmail"><spring:message code="allmail.sendMail"/></a>
        </div>
    </div>

    <table class="table" style="text-align:center">
        <tr>
            <th width="200"><spring:message code="allmail.sender"/></th>
            <th width="200"><spring:message code="allmail.subject"/></th>
            <th width="300"><spring:message code="allmail.content"/></th>
        </tr>

        <c:forEach items="${mails}" var="mail">
            <tr>
                <td>${mail.sender}</td>
                <td>${mail.subject}</td>
                <td>${mail.content}</td>
            </tr>
        </c:forEach>
    </table>


</body>

</html>