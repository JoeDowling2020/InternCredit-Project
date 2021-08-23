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
            <p>Sign Up</p>
        </div>

        <div class="row mt-5">
<div class="center">
    <form action="<%=request.getContextPath()%>/signUp" method="post">
        <div class="form-group mt-3">
            <label for="firstName">First Name</label>
            <input id="firstName" name="firstName" type="text" placeholder="First Name" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="lastName">Last Name</label>
            <input id="lastName" name="lastName" type="text" placeholder="Last Name" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="username">User Name</label>
            <input id="username" name="username" type="text" placeholder="Username" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" required class="form-control">
        </div>

        <div class="form-group mt-3">
            <label for="ign">IGN</label>
            <input id="ign" name="ign" type="text" placeholder="IGN" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="level">Level</label>
            <input id="level" name="level" type="text" placeholder="Level" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="winrate">Win Rate</label>
            <input id="winrate" name="winrate" type="text" placeholder="Win Rate" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="playtime">Play Time</label>
            <input id="playtime" name="playtime" type="text" placeholder="Play Time" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="primaryhero">Primary Hero</label>
            <input id="primaryhero" name="primaryhero" type="text" placeholder="Primary Hero" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="qpwinrate">Quick Play Win Rate</label>
            <input id="qpwinrate" name="qpwinrate" type="text" placeholder="Quick Play WR" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="qpplaytime">Quick Play Play Time</label>
            <input id="qpplaytime" name="qpplaytime" type="text" placeholder="Quick Play Play Time" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="qpprimaryhero">Quick Play Primary Hero</label>
            <input id="qpprimaryhero" name="qpprimaryhero" type="text" placeholder="Quick Play Primary Hero" required class="form-control">
        </div>
        <div class="form-group mt-3">
            <div class="text-center"><button type="submit" class="btn btn-default">Submit</button></div>
            <div class="text-center"><button type="reset" class="btn btn-default">Clear Form</button></div>
        </div>
    </form>
 </div>
   </div>
    </div>
</section>

<a href="login">All ready signed up? Log in here!</a>

<c:out value="${footer}" escapeXml="false"/>
<c:out value="${scripts}" escapeXml="false"/>
</body>
</html>
