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
      <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
      <title>Scheduling Home</title>
    </head>

    <body>
      </div>
      <div class="container">
        <h1 class="display-4">Manage Field/Scorekeeper Scheduling</h1>
      </div>
          <center class="lead">Field/Scorekeeper Scheduling List</center>
      <center>
          <div class="container">
        <table class="table table-striped">
          <thead>
            <tr bgcolor="green">
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
              </div>
      </center>
        <p></p>
      <center>
        <table>
          <thead>
            <tr>
              <td>
                <form method="post" action="DateRange">
                <input class="btn btn-info btn-md  mb-3" 
                       type="submit" 
                       value="Previous Date Range"/>
                </form>
              </td>
              <td>
                <form method="get" action="login">
                <input class="btn btn-info btn-sm  mb-3"
                       type="submit" 
                       value="Current"/>   
                </form>
              </td>
              <td>
                <form method="get" action="DateRange">
                <input class="btn btn-info btn-md  mb-3" 
                       type="submit" 
                       value="Next Date Range"/>
                </form>
              </td>
      </center>
        <br><br>
      <center>
        <table>
          <thead>
            <tr>
              <td>
                <form method="get"
                      action="AddEvent">
                  <input class="btn btn-success btn-md  mb-3"
                         type="submit"
                         value="Schedule Scorekeepers" /></form>
              </td>
              <td>
                <form method="get"
                      action="AddStaff">
                  <input class="btn btn-success btn-md  mb-3"
                         type="submit"
                         value="Create/Update Scorekeepers" /></form>
              </td>
            </tr>
          </thead>
        </table>
      </center>
      </div>
    </body>

    </html>