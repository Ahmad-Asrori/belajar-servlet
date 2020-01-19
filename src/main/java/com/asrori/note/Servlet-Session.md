## Servlet Session

HTTP is a "stateless" protocol which means each time a client retrieves a Web page, the client opens a separate connection to the Web server and the server automatically does not keep any record of previous client request.

Still there are following three ways to maintain session between web client and web server −

#### Cookies
A webserver can assign a unique session ID as a cookie to each web client and for subsequent requests from the client they can be recognized using the recieved cookie.

This may not be an effective way because many time browser does not support a cookie, so I would not recommend to use this procedure to maintain the sessions.

#### Hidden Form Fields
A web server can send a hidden HTML form field along with a unique session ID as follows −

```html
<input type = "hidden" name = "sessionid" value = "12345">
```

This entry means that, when the form is submitted, the specified name and value are automatically included in the GET or POST data. Each time when web browser sends request back, then session_id value can be used to keep the track of different web browsers.

This could be an effective way of keeping track of the session but clicking on a regular (<A HREF...>) hypertext link does not result in a form submission, so hidden form fields also cannot support general session tracking.

#### URL Rewriting
You can append some extra data on the end of each URL that identifies the session, and the server can associate that session identifier with data it has stored about that session.

For example, with http://tutorialspoint.com/file.htm;sessionid = 12345, the session identifier is attached as sessionid = 12345 which can be accessed at the web server to identify the client.

URL rewriting is a better way to maintain sessions and it works even when browsers don't support cookies. The drawback of URL re-writing is that you would have to generate every URL dynamically to assign a session ID, even in case of a simple static HTML page.

#### The HttpSession Object
Apart from the above mentioned three ways, servlet provides HttpSession Interface which provides a way to identify a user across more than one page request or visit to a Web site and to store information about that user.

The servlet container uses this interface to create a session between an HTTP client and an HTTP server. The session persists for a specified time period, across more than one connection or page request from the user.

You would get HttpSession object by calling the public method getSession() of HttpServletRequest, as below −

```java
HttpSession session = request.getSession();
```
You need to call request.getSession() before you send any document content to the client. Here is a summary of the important methods available through HttpSession object −

| No | Method & Description                                                                                                                                                             |
|----|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | **public Object getAttribute(String name)**  This method returns the object bound with the specified name in this session, or null if no object is bound under the name.             |
| 2  | **public Enumeration getAttributeNames()**  This method returns an Enumeration of String objects containing the names of all the objects bound to this session.                      |
| 3  | **public long getCreationTime()**  This method returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.                          |
| 4  | **public String getId()**  This method returns a string containing the unique identifier assigned to this session.                                                                   |
| 5  | **public long getLastAccessedTime()**  This method returns the last accessed time of the session, in the format of milliseconds since midnight January 1, 1970 GMT                   |
| 6  | **public int getMaxInactiveInterval()**  This method returns the maximum time interval (seconds), that the servlet container will keep the session open between client accesses.     |
| 7  | **public void invalidate()**  This method invalidates this session and unbinds any objects bound to it.                                                                              |
| 8  | **public boolean isNew()**  This method returns true if the client does not yet know about the session or if the client chooses not to join the session                               |
| 9  | **public void removeAttribute(String name)**  This method removes the object bound with the specified name from this session.                                                        |
| 10 | **public void setAttribute(String name, Object value)**  This method binds an object to this session, using the name specified.                                                      |
| 11 | **public void setMaxInactiveInterval(int interval)**  This method specifies the time, in seconds, between client requests before the servlet container will invalidate this session. |