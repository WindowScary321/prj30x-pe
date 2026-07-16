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
            <form method="POST" action="calculate">
                <table>
                    <tr>
                        <td>Enter coefficient:</td>
                        <td><input type="text" name="coefficient" id="coefficient"> kcal/kg/day</td>
                    </tr>
                    <tr>
                        <td>Enter weight:</td>
                        <td><input type="text" name="weight" id="weight"> kg</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="TDEE" id="TDEE"/>
                            <c:if test="${not empty error}">
                                <span id="txtError">${error}</span>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            Total Daily Energy Expenditure (TDEE):
            <table border="1">
                <tr>
                    <th>Coefficient</th>
                    <th>Weight</th>
                    <th>TDEE</th>
                    <th>Conclude</th>
                </tr>
                <tr>
                    <c:forEach items="${sessionScope.records}" var="record">
                    <tr>
                        <!-- hãy viết thường, tránh lỗi. -->
                        <td>${record.coefficient}</td> <!-- record là var đặt ở trên (var="record") -->
                        <td>${record.weight}</td>      <!-- Chỉ cần sửa đói tượng đã đặt từ trc-->
                        <td>${record.tde}</td>
                        <td>${record.conclude}</td>
                    </tr>
                </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
