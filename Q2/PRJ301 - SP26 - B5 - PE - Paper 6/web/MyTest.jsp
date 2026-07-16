<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="POST" action="check">
                <table>
                    <tr>
                        <td>Enter day: </td>
                        <td>  <input type="text" id="txtDay" name="txtDay"></td>
                    </tr>
                    <tr>
                        <td>Enter month: </td>
                        <td><input type="text" id="txtMonth" name="txtMonth"></td>
                    </tr>
                    <tr>
                        <td>Enter year: </td>
                        <td><input type="text" id="txtYear" name="txtYear"></td>
                    </tr>
                    <tr>
                         <!--trả kế quả bằng "${ketQua}" từ servlet-->
                        <td>Result: </td>
                        <td><input type="text" id="txtOutput" name="txtOutput" value="${ketQua}"></td> 
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" id="btnFulldate" name="btnFulldate" value="FULLDATE"/>
                            <input type="submit" id="btnDaymonth" name="btnDaymonth" value="DAYMONTH"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
