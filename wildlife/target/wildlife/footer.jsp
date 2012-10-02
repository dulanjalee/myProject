<%@page import="java.io.InputStream" %>
<%@page import="java.util.Properties" %>

<html>
    <head>
        <%
            InputStream stream = application.getResourceAsStream("message.properties");
            Properties props = new Properties();
            props.load(stream);
        %>
    </head>
    <body>
        <div>
            <div class="footer_heading"><fmt:message key="footer.heading.copyright.statement"/></div>
        </div>
    </body>
</html>