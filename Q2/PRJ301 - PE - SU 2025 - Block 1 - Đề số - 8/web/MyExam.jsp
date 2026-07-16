<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="POST" action="bmi">
                <table>
                    <tr>
                        <td>Enter height: </td>
                        <td><input type="text" name="height" id="height"></td>
                    </tr>
                    <tr>
                        <td>Enter weight: </td>
                        <td><input type="text" name="weight" id="weight"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="BMI" id="btnBMI"/>
                            <c:if test="${not empty error}">
                                <span id="txtError">${error}</span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            Body Mass Index (BMI):
            <table border="1">
                <tr>
                    <th>Height</th>
                    <th>Weight</th>
                    <th>BMI</th>
                    <th>Conclude</th>
                </tr>
                <tr>
                    <c:forEach items="${sessionScope.bmiRecords}" var="record">
                    <tr>
                        <!-- in ra các thuộc tính của đối tượng -->
                        <td>${record.height}</td>
                        <td>${record.weight}</td>
                        <td>${record.BMI}</td>
                        <td>${record.conclude}</td>
                    </tr>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
