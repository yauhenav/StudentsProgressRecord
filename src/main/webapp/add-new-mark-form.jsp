<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show add new student form</title>
</head>
<body>

<form name="Form14"
      method="get"
      action="http://localhost:8080/StudentsProgressRecord/modify">
    <table>
        <tr>
            <td><B>Enter mark attributes to add new mark into DB</B></td>
        </tr>
        <tr>
            <td><B>Enter mark ID</B></td>
            <td><input type=number name="new_mark_ID" size="25" value=""></td>
        </tr>
        <tr>
            <td><B>Enter mark value</B></td>
            <td><input type=number name="new_mark_value" size="25" value=""></td>
        </tr>
        <tr>
            <td><B>Enter student ID</B></td>
            <td><input type=number name="new_mark_studentId" size="25" value=""></td>
        <tr>
            <td><B>Enter subject ID</B></td>
            <td><input type=number name="new_mark_subjectId" size="25" value=""></td>
        </tr>
    </table>
    <input type=submit name="action" value="Add new mark">
</form>

<a href="index.jsp">Go to Home Page</a>

</body>
</html>