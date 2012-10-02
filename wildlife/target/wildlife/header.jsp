<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.InputStream" %>
<%@page import="java.util.Properties" %>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
            <%
                InputStream stream = application.getResourceAsStream("message.properties");
                Properties props = new Properties();
                props.load(stream);
            %>
        </head>
        <body>
            <div>
                <img src="images/images.jpg" alt="Smiley face" height="200px" width="975"/>
            </div>
            <div id="navigation">
                <ul>
                    <div class="navigation_bar"></div>
                        <li><a href=index.jsp><fmt:message key="home.navigation"/></a></li>
                        <li><a href=index.jsp><fmt:message key="catergory.navigattion"/></a></li>
                        <li><a href=index.jsp><fmt:message key="contact.us.navigation"/></a></li>
                        <li><a href=index.jsp><fmt:message key="side.map.navigation"/></a></li>
                    <div class="home"></div>
                </ul>
            </div>
        </body>
    </html>