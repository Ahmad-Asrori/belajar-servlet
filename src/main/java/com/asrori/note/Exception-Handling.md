## Servlet Exception Handling

When a servlet throws an exception, the web container searches the configurations in web.xml that use the exception-type element for a match with the thrown exception type.

You would have to use the error-page element in web.xml to specify the invocation of servlets in response to certain exceptions or HTTP status codes.

#### web.xml Configuration
Consider, you have an ErrorHandler servlet which would be called whenever there is any defined exception or error. Following would be the entry created in web.xml.

```xml
<!-- servlet definition -->
<servlet>
   <servlet-name>ErrorHandler</servlet-name>
   <servlet-class>ErrorHandler</servlet-class>
</servlet>

<!-- servlet mappings -->
<servlet-mapping>
   <servlet-name>ErrorHandler</servlet-name>
   <url-pattern>/ErrorHandler</url-pattern>
</servlet-mapping>

<!-- error-code related error pages -->
<error-page>
   <error-code>404</error-code>
   <location>/ErrorHandler</location>
</error-page>

<error-page>
   <error-code>403</error-code>
   <location>/ErrorHandler</location>
</error-page>

<!-- exception-type related error pages -->
<error-page>
   <exception-type>javax.servlet.ServletException</exception-type >
   <location>/ErrorHandler</location>
</error-page>

<error-page>
   <exception-type>java.io.IOException</exception-type >
   <location>/ErrorHandler</location>
</error-page>
```
If you want to have a generic Error Handler for all the exceptions then you should define following error-page instead of defining separate error-page elements for every exception −

```xml
<error-page>
   <exception-type>java.lang.Throwable</exception-type >
   <location>/ErrorHandler</location>
</error-page>
```

Following are the points to be noted about above web.xml for Exception Handling −

* The servlet ErrorHandler is defined in usual way as any other servlet and configured in web.xml.
* If there is any error with status code either 404 (Not Found) or 403 (Forbidden ), then ErrorHandler servlet would be called.
* If the web application throws either ServletException or IOException, then the web container invokes the /ErrorHandler servlet.
* You can define different Error Handlers to handle different type of errors or exceptions. Above example is very much generic and hope it serve the purpose to explain you the basic concept.

#### Request Attributes − Errors/Exceptions
Following is the list of request attributes that an error-handling servlet can access to analyze the nature of error/exception.

| No | Attribute & Description                                                                                                                                                          |
|----|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | **javax.servlet.error.status_code**  This attribute give status code which can be stored and analyzed after storing in a java.lang.Integer data type.                                |
| 2  | **javax.servlet.error.exception_type**  This attribute gives information about exception type which can be stored and analysed after storing in a java.lang.Class data type.         |
| 3  | **javax.servlet.error.message**  This attribute gives information exact error message which can be stored and analyzed after storing in a java.lang.String data type.                |
| 4  | **javax.servlet.error.request_uri**  This attribute gives information about URL calling the servlet and it can be stored and analysed after storing in a java.lang.String data type. |
| 5  | **javax.servlet.error.exception**  This attribute gives information about the exception raised, which can be stored and analysed.                                                    |
| 6  | **javax.servlet.error.servlet_name**  This attribute gives servlet name which can be stored and analyzed after storing in a java.lang.String data type.                              |