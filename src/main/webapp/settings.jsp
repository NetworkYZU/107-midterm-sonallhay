<%-- 
    Document   : settings
    Created on : Oct 26, 2018, 9:13:22 PM
    Author     : lendle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="setImages">
            <ul>
                <%
                    String image1=(String)session.getAttribute("1");
                    String image2=(String)session.getAttribute("2");
                    String image3=(String)session.getAttribute("3");
                    image1=(image1==null)?"https://upload.wikimedia.org/wikipedia/commons/9/9a/PNG_transparency_demonstration_2.png":image1;
                    image2=(image2==null)?"https://upload.wikimedia.org/wikipedia/commons/9/9a/PNG_transparency_demonstration_2.png":image2;
                    image3=(image3==null)?"https://upload.wikimedia.org/wikipedia/commons/9/9a/PNG_transparency_demonstration_2.png":image3;
                %>
                <li>1: <input type="text" name="image1" value="<%=image1%>" style="width: 800px"/></li>
                <li>2: <input type="text" name="image2" value="<%=image2%>" style="width: 800px"/></li>
                <li>3: <input type="text" name="image3" value="<%=image3%>" style="width: 800px"/></li>
            </ul>
            <input type="submit"/>
        </form>
    </body>
</html>
