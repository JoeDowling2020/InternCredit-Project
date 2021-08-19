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

<%--    <!-- ======= Contact Section ======= -->--%>
<%--    <section id="contact" class="contact">--%>
<%--        <div class="container">--%>

<%--            <div class="section-title" data-aos="zoom-out">--%>
<%--                <h2>Contact</h2>--%>
<%--                <p>Contact Us</p>--%>
<%--            </div>--%>

<%--            <div class="row mt-5">--%>

<%--                <div class="col-lg-4" data-aos="fade-right">--%>
<%--                    <div class="info">--%>
<%--                        <div class="address">--%>
<%--                            <i class="bi bi-geo-alt"></i>--%>
<%--                            <h4>Location:</h4>--%>
<%--                            <p>A108 Adam Street, New York, NY 535022</p>--%>
<%--                        </div>--%>

<%--                        <div class="email">--%>
<%--                            <i class="bi bi-envelope"></i>--%>
<%--                            <h4>Email:</h4>--%>
<%--                            <p>info@example.com</p>--%>
<%--                        </div>--%>

<%--                        <div class="phone">--%>
<%--                            <i class="bi bi-phone"></i>--%>
<%--                            <h4>Call:</h4>--%>
<%--                            <p>+1 5589 55488 55s</p>--%>
<%--                        </div>--%>

<%--                    </div>--%>

<%--                </div>--%>

<%--                <div class="col-lg-8 mt-5 mt-lg-0" data-aos="fade-left">--%>

<%--                    <form action="forms/contact.php" method="post" role="form" class="php-email-form">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-md-6 form-group">--%>
<%--                                <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>--%>
<%--                            </div>--%>
<%--                            <div class="col-md-6 form-group mt-3 mt-md-0">--%>
<%--                                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group mt-3">--%>
<%--                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group mt-3">--%>
<%--                            <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>--%>
<%--                        </div>--%>
<%--                        <div class="my-3">--%>
<%--                            <div class="loading">Loading</div>--%>
<%--                            <div class="error-message"></div>--%>
<%--                            <div class="sent-message">Your message has been sent. Thank you!</div>--%>
<%--                        </div>--%>
<%--                        <div class="text-center"><button type="submit">Send Message</button></div>--%>
<%--                    </form>--%>

<%--                </div>--%>

<%--            </div>--%>

        </div>
    </section><!-- End Contact Section -->

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
