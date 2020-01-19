## Servlet Filter

Servlet Filters are Java classes that can be used in Servlet Programming for the following purposes −

* To intercept requests from a client before they access a resource at back end.

* To manipulate responses from server before they are sent back to the client.

There are various types of filters suggested by the specifications −

* Authentication Filters.
* Data compression Filters.
* Encryption Filters.
* Filters that trigger resource access events.
* Image Conversion Filters.
* Logging and Auditing Filters.
* MIME-TYPE Chain Filters.
* Tokenizing Filters .
* XSL/T Filters That Transform XML Content.
* Filters are deployed in the deployment descriptor file web.xml and then map to either servlet names or URL patterns in your application's deployment descriptor.

When the web container starts up your web application, it creates an instance of each filter that you have declared in the deployment descriptor. The filters execute in the order that they are declared in the deployment descriptor.

#### Servlet FIlter Method

A filter is simply a Java class that implements the javax.servlet.Filter interface. The javax.servlet.Filter interface defines three methods −

| No | Method & Description                                                                                                                                                                                                                      |
|----|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | **public void doFilter (ServletRequest, ServletResponse, FilterChain)**  This method is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain. |
| 2  | **public void init(FilterConfig filterConfig)**  This method is called by the web container to indicate to a filter that it is being placed into service.                                                                                     |
| 3  | **public void destroy()**  This method is called by the web container to indicate to a filter that it is being taken out of service.                                                                                                          |