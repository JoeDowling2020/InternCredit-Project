<%--
  Created by IntelliJ IDEA.
  User: jdowl
  Date: 7/12/2021
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:import var="footer" url="includes/footer.jsp"/>
<c:import var="head" url="includes/head.jsp"/>
<c:import var="nav" url="includes/nav.jsp"/>
<c:import var="scripts" url="includes/scripts.jsp"/>
<c:import var="hero" url="includes/hero.jsp"/>
<c:out value="${head}" escapeXml="false"/>
<body>
<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center  header-transparent ">
    <div class="container d-flex align-items-center justify-content-between">

        <div class="logo">
            <h1><a href="index.html">Overwatch Companion</a></h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <c:out value="${nav}" escapeXml="false"/>

    </div>
</header><!-- End Header -->
<c:out value="${hero}" escapeXml="false"/>

<section id="contact" class="contact">
    <div class="container">
        <div class="section-title" data-aos="zoom-out">
            <h2>OW Companion</h2>
            <p>Sign In</p>
        </div>
<FORM ACTION="j_security_check" METHOD="POST" class="toCenter">
    <TABLE>
        <div class="form-group">
            <TR class="center"><TD>User name: <INPUT TYPE="TEXT" NAME="j_username" class="form-control"></TD></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control"></TD></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TH><INPUT TYPE="SUBMIT" VALUE="Log In" class="btn btn-default"></TH></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TH><input type="reset" value="Clear" class="btn btn-default"></TH></TR>
        </div>
    </TABLE>
</FORM>
    </div>
</section>
<c:out value="${footer}" escapeXml="false"/>
<c:out value="${scripts}" escapeXml="false"/>
</body>
</html>
