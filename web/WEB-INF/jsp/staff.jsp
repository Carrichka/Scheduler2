<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
    <title>Update Staff</title>
</head>
<body>
    <center>
    <br>
    <h1>Add a New Scorekeeper</h1>
    <form method="post" action="AddStaff">
    <table>
        <thead>
            <tr>
                <th><br/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="first_name"/><br/></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="last_name"/><br/></td>
            </tr>
            <tr>
                <td><input class="btn btn-primary btn-md  mb-3"
                           type="submit" 
                           value="Update"/>
                </td>
                </form>
                <form method="get" action="login">
                    <td><input class="btn btn-primary btn-md  mb-3"
                               accept=""type="submit" 
                               accesskey=""value="Cancel"/></td>
                    </td>
                </form>
            </tr>
        </tbody>
    </table>
</center>
<br><br>
<center>
    <form method="post" action="DeleteStaff">
        <h1>Remove a Scorekeeper</h1>
    <table>
        <thead>
            <tr>
                <th><br/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Active Scorekeepers</td>
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
                <td><input class="btn btn-primary btn-md  mb-3"
                           type="submit" 
                           value="Remove"/></td>
                </form>
                <form method="get" action="AddStaff">
                <td><input class="btn btn-primary btn-md  mb-3"
                           type="submit" 
                           value="Refresh List"/></td></td>
                </form>
            </tr>
        </tbody>
    </table>
</center>
</body>
</html>