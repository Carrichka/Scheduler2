<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.RASS.model.domain.EventBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                    <td>First Name</td>
                    <td><input type="text" name="firstname"/><br/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname"/><br/></td>
                </tr>
                <tr>
                    <td>Field</td>
                    <td><select name="field_number">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td><input type="text" name="scheduled_date"/><br/></td>
                </tr>
                <tr>
                    <td>Day of the Week</td>
                    <td><select name="week_day">
                            <option>Sunday</option>
                            <option>Monday</option>
                            <option>Tuesday</option>
                            <option>Wednesday</option>
                            <option>Thursday</option>
                            <option>Friday</option>
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
                    <td>
                        <input type="submit" value="Cancel"/>
                    </td>
                </tr>
            </tbody>
        </table>
</form>
    </center>
</body>
</html>
