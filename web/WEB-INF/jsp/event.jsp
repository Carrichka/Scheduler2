<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="savedbean" class="com.RASS.model.domain.StaffBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<title>Assign Scorekeeper</title>
</head>
<body>
    <center>
        <form method="post" action="AddEvent">
        <table border="0">
            <thead>
                <tr>
                    <th>Assign a scorekeeper to a field</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Date</td>
                    <td><input type="text" id="datepicker"></td>
                </tr>
                <tr>
                    <td>Scorekeeper</td>
                    <td><select name="listStaff">
                            <c:forEach items="${listStaff}" var="staffbean">
                                <option value="${staffbean.firstname}"</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>League</td>
                    <td><select name="game_type">
                            <option>Mens</option>
                            <option>Mens Advanced</option>
                            <option>Coed</option>
                            <option>Coed Advanced</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Field</td>
                    <td><select name="field_number">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select></td>
                </tr>
            </tbody>
        </table>
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <input type="submit" value="Create"/>
                    </td>
                    </form>
                    <form method="get" action="login">
                    <td>
                        <input type="submit" value="Cancel"/>
                    </td>
                    </form>
                </tr>
            </tbody>
        </table>
    </center>
</body>
</html>
