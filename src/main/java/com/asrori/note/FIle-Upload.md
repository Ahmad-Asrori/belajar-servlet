## Servlet File Upload

A Servlet can be used with an HTML form tag to allow users to upload files to the server. An uploaded file could be a text file or image file or any document.

Creating a File Upload Form
The following HTM code below creates an uploader form. Following are the important points to be noted down −

* The form method attribute should be set to POST method and GET method can not be used
* The form enctype attribute should be set to multipart/form-data.
* The form action attribute should be set to a servlet file which would handle file uploading at backend server. Following example is using UploadServlet servlet to upload file.
* To upload a single file you should use a single <input .../> tag with attribute type="file". To allow multiple files uploading, include more than one input tags with different values for the name attribute. The browser associates a Browse button with each of them.