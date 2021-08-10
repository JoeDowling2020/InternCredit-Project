<%--
  Created by IntelliJ IDEA.
  User: jdowl
  Date: 8/10/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


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

</body>
</html>
