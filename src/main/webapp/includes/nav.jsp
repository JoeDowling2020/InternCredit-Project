<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="navbar" class="navbar">
    <ul>
        <li><a class="nav-link scrollto active" href="index.jsp">Home</a></li>
        <li><a class="nav-link scrollto" href="admin.jsp">Admin</a></li>
        <li><a class="nav-link scrollto" href="allHeroes">Heroes</a></li>
        <li><a class="nav-link scrollto " href="displayProfile">Leaderboard</a></li>
        <%
            if (request.getRemoteUser() == null) {
        %>
        <li><a class="nav-link scrollto" href="login">Sign In</a></li>
        <li><a class="nav-link scrollto" href="signUp">Sign Up</a></li>
        <%
        } else {
        %>
        <li><a class="nav-link scrollto" href="editProfile">Edit Profile</a></li>
        <li><a class="nav-link scrollto" href="logoutAction">Log Out</a></li>
        <%
            }
        %>
    </ul>
    <i class="bi bi-list mobile-nav-toggle"></i>
</nav><!-- .navbar -->