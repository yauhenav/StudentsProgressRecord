<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show add new student form</title>
</head>
<body>

<form name="Form16"
      method="get"
      action="http://localhost:8080/StudentsProgressRecord/modify">
    <table>
        <tr>
            <td><B>To delete existing mark, enter mark's ID</B></td>
            <td><input type=number name="delete_mark_ID" size="25" value=""></td>
        </tr>
    </table>
    <input type=submit name="action" value="Delete mark">
</form>

<a href="index.jsp">Go to Home Page</a>

</body>
</html>