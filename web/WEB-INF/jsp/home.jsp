<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <th> Field </th>
                <th> Game Type </th>
                <th> First Name </th>
                <th> Last Name </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listEvent}" var="savedbean">
                <tr>
                    <td>${savedbean.scheduledDate}</td>    
                    <td>${savedbean.fieldName} </td>
                    <td>${savedbean.gametype} </td>
                    <td>${savedbean.scorekeeperFirstName} </td>
                    <td>${savedbean.scorekeeperLastName} </td>
                </tr>   
            </c:forEach>
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
                        <form method="get" action="AddStaff">
                        <input type="submit" value="Create Scorekeeper"/></form>
                    </td>
                    <td>
            <button type="button" onclick="javascript:window.location=/WEB-INF/jsp/staff.jsp">Remove Event</button>
                    </td>
                    <td>
            <button type="button" onclick="javascript:window.location=/WEB-INF/jsp/staff.jsp">Remove Scorekeeper</button>                   </td>
               </tr>
               </thead>
        </table>
    </center>

</body>
</html>
