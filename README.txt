//本项目是一个博客项目，实现的功能有：
//1、博客用户的登陆与注册
//2、用户登陆状态的追踪和本地浏览器cookie信息的保存
//3、用户博客的上传，更新，删除


/***
使用servlet与前端对接，使用JDBC与数据库连接，数据库的增删改查。
RESTful设计风格的了解，项目开发规范。
***/

#Servlet接口
1、/DeleteArticleServlet
实现删除文章的功能，返回值为JSON
{"state":"true"}为成功
{"state":"false"}为失败

2、GetAllServlet
实现获得全部文章的方法，返回值为JSON
{
  "id":"",
  "title":"",
  "tags":"",
  "date":"",
  "data":""
}

3、/GetArticleServlet
实现获得单个文章的方法
{
  "data":"",
  "title":"",
  "date_":"",
  "tags":"",
  "state":""
}
其中state为true时，返回成功；false时，返回失败。

4、/LoginServlet
实现登陆的方法
此方法会返回一个内含为"username"的值，值为用户名
{
  "state":"",
  "session":""
}
state状态有true和false；
session有new，old，false；
session代表登陆追踪，new为新登陆，old为已登陆，false为登陆失败

5、/RegisterServlet
实现注册的方法
{
  "state":""
}
state状态有true和false

6、/UpdateServlet
实现更新文章的方法
JSON同上

7、/UploadServlet
实现上传文章的方法
JSON同上
