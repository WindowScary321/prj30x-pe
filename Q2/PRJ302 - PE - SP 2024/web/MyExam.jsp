<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: auto">
            <form style="margin: auto" action="playerservlet" method="post">
                <table>
                    <tr>
                        <td colspan="2" style="text-align: center">PLAYER INFORMATION</td>
                    </tr>
                    <tr>
                        <td>Code:</td>
                        <td><input type="text" name="code"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Position:</td>
                        <td>
                            <select name="position">
                                <option>Striker</option>
                                <option>GoalKeeper</option>
                                <option>Defender</option>
                                <option>Midfielder</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Salary:</td>
                        <td><input type="text" name="salary"></td>
                    </tr>
                    <tr> 
                        <td style="text-align: center" colspan="2"><input type="submit" value="CREATE" name="create"></td>
                    </tr>
                    <tr>
                        <c:if test="${not empty error}">
                            <td colspan="2" style="color: red"><i></i></td>
                                </c:if>
                    </tr>
                    <tr>
                    </tr>
                </table>
                List of Players:
                <table border="1">
                    <tr>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Position</td>
                        <td>Salary</td>
                    </tr>
                    <c:forEach items="${sessionScope.records}" var="record">
                        <tr>
                            <!-- hãy viết thường, tránh lỗi. -->
                            <td>${record.code}</td> <!-- record là var đặt ở trên (var="record") -->
                            <td>${record.name}</td>      <!-- Chỉ cần sửa đói tượng đã đặt từ trc-->
                            <td>${record.position}</td>
                            <td>${record.salary}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>
