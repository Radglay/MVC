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

    <div class="list" style = "background-color:aquamarine; position: fixed;  right: 250px; height:500px;overflow:auto">
        <img src="<c:url value="/resources/images/logo.png" />">
        <table id = "bookTable">
            <tr>
                <th>Book name</th>
                <th>Author</th>
                <th>Type</th>
            </tr>
                <c:forEach var = "bookList" items = "${bookList}" varStatus="status">
                    <tr style = "font-family: verdana; text-align: center">
                        <td><a href="/api/books/${bookList.id}"><c:out value = "${bookList.name}"/> </td></a>
                        <td><c:out value = "${bookList.author}"/> </td>
                        <td><c:out value = "${bookList.type}"/></td>
                    </tr>
                 </c:forEach>
        </table>
    </div>
</div>

</body>

</html>