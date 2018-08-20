<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="savedbean" class="com.RASS.model.domain.StaffBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"
            content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8" />
    <meta name="viewport"
            content="width=device-width, initial=scale=1" />
    <meta http-equiv="X-UA-Compatible"
            content="IE=edge" />
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
    <title>Assign Scorekeeper</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" }).val();
        } );
    </script>
<title></title>
</head>
<body>
    <center>
        <form method="post" action="AddEvent">
            <h1>Assign a Scorekeeper to a Field</h1>
        <table border="0">
            <thead>
                <tr>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Date</td>
                    <td>
                        <input type="text" id="datepicker" name="scheduledDate"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>Scorekeeper</td>
                    <td>
                        <select name="listStaff">
                            <c:forEach items="${listStaff}" var="savedbean">
                                <option value="${savedbean.scorekeeperid}">${savedbean.firstname} ${savedbean.lastname}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>League</td>
                    <td><select name="gameType">
                            <option>Mens</option>
                            <option>Mens Advanced</option>
                            <option>Coed</option>
                            <option>Coed Advanced</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Field</td>
                    <td><select name="fieldName">
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
                        <input class="btn btn-primary btn-md  mb-3"
                               type="submit" 
                               value="Create"/>
                    </td>
                    </form>
                    <form method="get" action="login">
                    <td>
                        <input class="btn btn-primary btn-md  mb-3"
                               type="submit" 
                               value="Cancel"/>
                    </td>
                    </form>
                </tr>
            </tbody>
        </table>
    </center>
</body>
</html>
