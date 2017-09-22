<%@ page import="java.sql.*" %>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.*"%>
<%@ page import="com.yauhenav.logic.mysql.MySqlStudentDao" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.yauhenav.logic.service.SessionUtilProd" %>
<%@ page import="com.yauhenav.logic.dto.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.yauhenav.logic.exception.DaoException" %>
<%
    PrintWriter pw = response.getWriter();
    String combination=request.getParameter("val");
    if(combination==null||combination.trim().equals("")){
        pw.print("<p>Please enter name!</p>");
    }else {
        try {
            SessionFactory factory = SessionUtilProd.getSessionFactory();
            MySqlStudentDao mssd = new MySqlStudentDao(factory);
            List<Student> lst = mssd.getAllStudentsCombinationCharacters(combination);
            pw.print(lst);
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }
%>