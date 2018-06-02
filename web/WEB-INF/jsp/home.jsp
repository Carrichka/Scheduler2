<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scheduling Home</title>
</head>
<body>
    <p>Manage Field/Scorekeeper Scheduling</p>
    <center>Field Scorekeeper Scheduling List</center>
    <center>
        <table border ="1">
        <thead>
             <tr bgcolor="grey">
                <th> Date </th>
                <th> Day of the Week </th>
                <th> Field </th>
                <th> Game Type </th>
                <th> First Name </th>
                <th> Last Name </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%=new java.text.SimpleDateFormat("mm/dd/yyyy").format(new java.util.Date()) %></td>    
                <td>day</td>
                <td>field</td>
                <td>league</td>
                <td>
                    <jsp:useBean id="user" scope="session" class="com.RASS.model.domain.LoginBean" />
                    <jsp:setProperty name="user" property="username" value="Carri" />
                    <jsp:getProperty name="user" property="username" />
                </td>
                <td>
                    <jsp:setProperty name="user" property="username" value="Carri" />
                    <jsp:getProperty name="user" property="username" />
                </td>
            </tr>
        </tbody>
    </table>
    </center>
    <center>
        <p>Previous Date Range      Next Date Range</p>
    </center>
    <center>
        <table>
            <thead>
                <tr>
                    <td>
                        <form method="get" action="AddEvent">
                        <input type="submit" value="Schedule Scorekeeper"/></form>
                    </td>
                    <td>
            <button type="button" onclick="location.href='/AddEvent'">Remove Item</button>
                    </td>
                    <td>
            <button type="button" onclick="javascript:window.location=/WEB-INF/jsp/staff.jsp">Create Scorekeeper</button>
                    </td>
                    <td>
            <input type="button" name="Remove Scorekeeper" onclick="document.location.href='staff.jsp'">                    </td>
               </tr>
               </thead>
        </table>
    </center>

</body>
</html>
