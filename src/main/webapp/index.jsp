<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="settings.jsp">Set Images</a>
        <table style="width: 80%; height: 80%" border="1">
            <tr>
                <td style="width: 33%"><img src="image?id=1" style="width:100%"/></td>
                <td style="width: 33%"><img src="image?id=2" style="width:100%"/></td>
                <td><img src="image?id=3" style="width:100%"/></td>
            </tr>
        </table>
    </body>
</html>
