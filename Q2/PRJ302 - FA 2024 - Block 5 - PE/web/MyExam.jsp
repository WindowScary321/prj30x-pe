<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Phải import nhé !!! -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="post" action="gcdservlet">
                <table>
                    <tr>
                        <td>
                            Enter integer number 1: 
                        </td>
                        <td>
                            <input type="text" id="num1" name="num1">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Enter integer number 2: 
                        </td>
                        <td>
                            <input type="text" id="num2" name="num2">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Enter integer number 3: 
                        </td>
                        <td>
                            <input type="text" id="num3" name="num3">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" value="EXECUTE GCD" id="submit"/>
                    <c:if test="${not empty error}">
                        <span id="txtError">${error}</span>
                    </c:if>
                    </td>
                    </tr>

                    <tr>
                        <td>
                            Result: 
                        </td>
                        <td>
                            <input type="text" id="result" name="result" value="${error}" readonly>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            <table border="1">
                <tr>
                    <th>Number 1</th>
                    <th>Number 2</th>
                    <th>Number 3</th>
                    <th>Result</th>
                </tr>
                <!-- ko bọc trong <tr> -->
                <c:forEach items="${sessionScope.records}" var="record">
                    <tr>
                        <!-- hãy viết thường, tránh lỗi. -->
                        <td>${record.number1}</td> <!-- record là var đặt ở trên (var="record") -->
                        <td>${record.number2}</td>      <!-- Chỉ cần sửa đói tượng đã đặt từ trc-->
                        <td>${record.number3}</td>
                        <td>${record.result}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
