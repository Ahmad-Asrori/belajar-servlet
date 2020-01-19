## Servlet Cookie

Cookies are text files stored on the client computer and they are kept for various information tracking purpose. Java Servlets transparently supports HTTP cookies.

There are three steps involved in identifying returning users −

* Server script sends a set of cookies to the browser. For example name, age, or identification number etc.
* Browser stores this information on local machine for future use.
* When next time browser sends any request to web server then it sends those cookies information to the server and server uses that information to identify the user.

![](https://networkencyclopedia.com/wp-content/uploads/2019/10/http-cookies.png)

#### Anatomy of Cookie

Cookies are usually set in an HTTP header (although JavaScript can also set a cookie directly on a browser). A servlet that sets a cookie might send headers that look something like this −

![](https://i.stack.imgur.com/QetIO.png)

As you can see, the Set-Cookie header contains a name value pair, a GMT date, a path and a domain. The name and value will be URL encoded. The expires field is an instruction to the browser to "forget" the cookie after the given time and date.

If the browser is configured to store cookies, it will then keep this information until the expiry date. If the user points the browser at any page that matches the path and domain of the cookie, it will resend the cookie to the server. The browser's headers might look something like this −

A servlet will then have access to the cookie through the request method request.getCookies() which returns an array of Cookie objects.

#### Servlet Cookie Method

| No | Method & Description                                                                                                                                                                                                               |
|----|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | **public void setDomain(String pattern)**  This method sets the domain to which cookie applies, for example tutorialspoint.com.                                                                                                        |
| 2  | **public String getDomain()**  This method gets the domain to which cookie applies, for example tutorialspoint.com.                                                                                                                    |
| 3  | **public void setMaxAge(int expiry)**  This method sets how much time (in seconds) should elapse before the cookie expires. If you don't set this, the cookie will last only for the current session.                                  |
| 4  | **public int getMaxAge()**  This method returns the maximum age of the cookie, specified in seconds, By default, -1 indicating the cookie will persist until browser shutdown.                                                         |
| 5  | **public String getName()**  This method returns the name of the cookie. The name cannot be changed after creation.                                                                                                                    |
| 6  | **public void setValue(String newValue)**  This method sets the value associated with the cookie                                                                                                                                       |
| 7  | **public String getValue()**  This method gets the value associated with the cookie.                                                                                                                                                   |
| 8  | **public void setPath(String uri)**  This method sets the path to which this cookie applies. If you don't specify a path, the cookie is returned for all URLs in the same directory as the current page as well as all subdirectories. |
| 9  | **public String getPath()**  This method gets the path to which this cookie applies.                                                                                                                                                   |
| 10 | **public void setSecure(boolean flag)**  This method sets the boolean value indicating whether the cookie should only be sent over encrypted (i.e. SSL) connections.                                                                   |
| 11 | **public void setComment(String purpose)**  This method specifies a comment that describes a cookie's purpose. The comment is useful if the browser presents the cookie to the user.                                                   |
| 12 | **public String getComment()**  This method returns the comment describing the purpose of this cookie, or null if the cookie has no comment.                                                                                           |

#### Setting Cookies with Servlet
Setting cookies with servlet involves three steps −

(1) **Creating a Cookie object** − You call the Cookie constructor with a cookie name and a cookie value, both of which are strings.

```java
Cookie cookie = new Cookie("key","value");
```

Keep in mind, neither the name nor the value should contain white space or any of the following characters −

```text
[ ] ( ) = , " / ? @ : ;
```

(2) **Setting the maximum age** − You use setMaxAge to specify how long (in seconds) the cookie should be valid. Following would set up a cookie for 24 hours.

```java
cookie.setMaxAge(60 * 60 * 24); 
```

(3) **Sending the Cookie into the HTTP response headers** − You use response.addCookie to add cookies in the HTTP response header as follows −

```java
response.addCookie(cookie);
```