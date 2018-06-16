<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <h:outputStylesheet library="css"
                          name="../../resources/css/bootstrap.css" />
      <title>Scheduling Home</title>
    </head>

    <body>
      <div class="container">
        <div class="navbar navbar-dark"
             <div
             class="navbar-branding">
        </div>
      </div>
      <div class="jumbotron">
        <h1 class="display-3">Manage Field/Scorekeeper Scheduling</h1>
        <center class="lead">Field Scorekeeper Scheduling List</center>
      </div>
      <center>
        <table border="1">
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
            <c:forEach items="${listEvent}"
                       var="savedbean">
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
        <p>Previous Date Range Next Date Range</p>
      </center>
      <center>
        <table>
          <thead>
            <tr>
              <td>
                <form method="get"
                      action="AddEvent">
                  <input type="submit"
                         value="Schedule Scorekeeper" /></form>
              </td>
              <td>
                <form method="get"
                      action="AddStaff">
                  <input type="submit"
                         value="Create Scorekeeper" /></form>
              </td>
              <td>
                <button type="button"
                        onclick="javascript:window.location=/WEB-INF/jsp/staff.jsp">Remove Event</button>
              </td>
              <td>
                <button type="button"
                        onclick="javascript:window.location=/WEB-INF/jsp/staff.jsp">Remove Scorekeeper</button>                </td>
            </tr>
          </thead>
        </table>
      </center>
      </div>
    </body>

    </html>