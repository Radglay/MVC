<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>


<div class="container">
    <div class="starter-template" style="background: cadetblue; text-align: center">
        <h1>Spring Boot Web JSP Example</h1>
        <h2>Message: ${message}</h2>
    </div>

    <div class="list" style = "background-color:aquamarine; position: center; height: 500px">
        <img src="<c:url value="/resources/images/logo.png" />">
        <table id = "userTable">
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>
            <c:forEach var = "userList" items = "${userList}" varStatus="status">
                <tr style = "font-family: verdana; text-align: center">
                    <td><c:out value = "${userList.id}"/> </td>
                    <td><c:out value = "${userList.name}"/> </td>
                    <td><c:out value = "${userList.surname}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>