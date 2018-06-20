<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Staff</title>
</head>
<body>
    <center>
    <form method="post" action="AddStaff">
    <table style='border:1px solid black;'>
        <thead>
            <tr>
                <th>Add a new scorekeeper<br/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="first_name"/><br/></td>
            </tr>
            <tr>
                <td>Last Name </td>
                <td><input type="text" name="last_name"/><br/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"/></td>
                </form>
                <form method="get" action="login">
                <td><input type="submit" value="Cancel"/></td></td>
                </form>
            </tr>
        </tbody>
    </table>
</center>
<p></p>
<center>
    <form method="post" action="DeleteStaff">
    <table style='border:1px solid black;'>
        <thead>
            <tr>
                <th>Remove a scorekeeper<br/></th>
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
                <td><input type="submit" value="Remove"/></td>
                </form>
                <form method="get" action="AddStaff">
                <td><input type="submit" value="Refresh List"/></td></td>
                </form>
            </tr>
        </tbody>
    </table>
</center>
</body>
</html>