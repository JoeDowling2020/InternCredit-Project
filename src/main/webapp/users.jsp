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



<table id="resultTable" class="display" width="90%">
    <thead>
    <tr>
        <th>IGN</th>
        <th>Level</th>
        <th>Win Rate</th>
        <th>Play Time</th>
        <th>Primary Hero</th>
        <th>Quick Play Win Rate</th>
        <th>Quick Play Play Time</th>
        <th>Quick Play Primary Hero</th>
    </tr>
    </thead>
    <body>
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="allProfiles" items="${allProfiles}">
        <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>
        <td>${allProfiles.ign}</td>
        <td>${allProfiles.level}</td>
        <td>${allProfiles.winRate}</td>
        <td>${allProfiles.playTime}</td>
        <td>${allProfiles.primaryHero}</td>
        <td>${allProfiles.qpWinRate}</td>
        <td>${allProfiles.qpPlayTime}</td>
        <td>${allProfiles.qpPrimaryHero}</td>
    </tr>
    </c:forEach>
    </body>
</table>

<c:out value="${footer}" escapeXml="false"/>
<c:out value="${scripts}" escapeXml="false"/>
</body>
</html>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#resultTable').DataTable();
    });
</script>