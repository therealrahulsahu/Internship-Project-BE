<%--
  Created On IntelliJ IDEA.
  By: Rahul Sahu
  Date: 07-06-2020
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HighRadius</title>
  </head>
  <body>
  <h2>Rahul is was here</h2>
  <form method="post" action="/HighRadiusProject/DisplayDatabase">
    <label for="number_of_item">Enter No. of Documents</label>
    <input type="number" name="number_of_item" id="number_of_item" required min="1" max="50000"/>
    <button type="submit">Fetch</button>
  </form>
  </body>
</html>
