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
  <li>#definitions: ${oval_definitions.definitions.size}</li>
</ul>

<!--
<table border="1">
    <thead><tr>
        <th>ID</th>
        <th>Version</th>
        <th>Class</th>
	</tr></thead>
	<c:forEach var="definition" items="${oval_definitions.definitions}">
	<tr>
		<td>${definition.ovalID}</td>
		<td>${definition.ovalVersion}</td>
		<td>${definition.definitionClass}</td>
	</tr>
	</c:forEach>
</table>
-->
</body>
</html>