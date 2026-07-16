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
            <form method="post" action="check">
                <table>
                    <tr>
                        <td>Enter a string(str): </td>
                        <td><input type="text" name="str" id="str"></td>
                    </tr>
                    <tr>
                        <td>Result: </td>
                        <td><input type="text" name="result" id="result" value="${result}" readonly></td>
                    </tr>
                    <tr>
                        <td><button type="submit" name="action" value="maxword" id="maxword">MAX WORD</button></td>
                        <td><button type="submit" name="action" value="sort" id="sort">SORT</button></td>
                        <td><p>${message}</p></td>
                    </tr>

                </table>
            </form>
        </div>
        <div>
            <table border="1">
                <tr>
                    <th>String str</th>
                    <th>Result</th>
                </tr>
                <tr>
                    <c:forEach items="${sessionScope.stringRecords}" var="record">
                    <tr>
                        <td>${record.str}</td>
                        <td>${record.result}</td>
                    </tr>
                </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
