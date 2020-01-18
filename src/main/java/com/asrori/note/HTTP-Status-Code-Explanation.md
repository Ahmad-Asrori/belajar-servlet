##HTTP Status Code

The format of the HTTP request and HTTP response messages are similar and will have following structure −

* An initial status line + CRLF ( Carriage Return + Line Feed i.e. New Line )

* Zero or more header lines + CRLF

* A blank line, i.e., a CRLF

* An optional message body like file, query data or query output.

For example, a server response header looks as follows −

![](https://www.ntu.edu.sg/home/ehchua/programming/webprogramming/images/HTTP_ResponseMessageExample.png)


The status line consists of the HTTP version (HTTP/1.1 in the example), a status code (200 in the example), and a very short message corresponding to the status code (OK in the example).

Following is a list of HTTP status codes and associated messages that might be returned from the Web Server −

![](https://www.steveschoger.com/status-code-poster/img/status-code.png)

####Methods to Set HTTP Status Code

The following methods can be used to set HTTP Status Code in your servlet program. These methods are available with HttpServletResponse object.

| No. | Method & Description                                                                                                                                                                                                                                                                                                  |
|-----|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | **public void setStatus (int statusCode)**  This method sets an arbitrary status code. The setStatus method takes an int (the status code) as an argument. If your response includes a special status code and a document, be sure to call setStatus before actually returning any of the content with the PrintWriter. |
| 2   | **public void sendRedirect (String url)**  This method generates a 302 response along with a Location header giving the URL of the new document                                                                                                                                                                            |
| 3   | **public void sendError (int code, String message)**  This method sends a status code (usually 404) along with a short message that is automatically formatted inside an HTML document and sent to the client.                                                                                                             |
