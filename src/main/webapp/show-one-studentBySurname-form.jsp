<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show one student by surname form</title>
</head>
<body>

<form name="Form21"
      method="get"
      action="http://localhost:8080/StudentsProgressRecord/modify">
    <table>
        <tr>
            <td><B>Enter student surname</B></td>
            <td><input type=text name="show_student_by_surname" size="25" value=""></td>
        </tr>
    </table>
    <input type=submit name="action" value="Show student by surname">
</form>

<a href="index.jsp">Go to Home Page</a>

</body>
</html>