<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OVAL Definitions</title>
</head>
<body>

<ul>
  <li>OVAL schema version: ${oval_definitions.generator.schemaVersion}</li>
  <li>timestamp: ${oval_definitions.generator.timestamp}</li>
  <c:forEach var="definition" items="${oval_definitions.definitions.definition}">
    <li>${definition.ovalID}</li>
  </c:forEach>
</ul>

</body>
</html>