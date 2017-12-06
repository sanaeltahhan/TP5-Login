<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title> <spring:message code="sendmailform.title" /> </title>
</head>
<body>
    <a href="/sendEmail?lang=en">EN</a>
    <a href="/sendEmail?lang=fr_FR">FR</a>

    <form action="/sendEmail" method="post">
        <div>
            <label><spring:message code="sendmailform.name" />
                <input type="text" name="nom"/>
            </label>
        </div>
        <div>
            <label><spring:message code="sendmailform.email" />
                <input type="email" name="email"/>
            </label>
        </div>
        <div>
            <label><spring:message code="sendmailform.subject" />
                <textarea type="text" name="subject"></textarea>
            </label>
        </div>
        <div>
            <label><spring:message code="sendmailform.content" />
                <textarea type="text" name="content"></textarea>
            </label>
        </div>

        <div class="button">
            <button type="submit"><spring:message code="sendmailform.sendbutton" /></button>
        </div>
    </form>


</body>