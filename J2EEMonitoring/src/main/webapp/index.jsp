<%-- 
    Document   : index
    Created on : Oct 14, 2014, 9:53:10 AM
    Author     : Jim
--%>

<%@page import="com.algorithms.search.MyRecursiveBinarySearch"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Algos.xml" });
    MyRecursiveBinarySearch bsearch = (MyRecursiveBinarySearch) appContext.getBean("binarySearchProxy");
    
    bsearch.recursiveBinarySearch();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
