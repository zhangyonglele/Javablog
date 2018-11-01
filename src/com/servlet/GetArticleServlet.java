package com.servlet;

import com.dao.BlogDao;
import com.dao.BlogDaoImpl;
import com.entity.BlogBlock;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetArticleServlet")
public class GetArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置防止中文乱码
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf8");

        //数据跨域申请
        response.setHeader("Access-Control-Allow-Origin","*");
        //
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //获得前端数据
        String id = request.getParameter("id");
        //创建接口方法对象
        BlogDao bd = new BlogDaoImpl();
        //创建对象实体
        BlogBlock blog =  bd.getArticle(id);
        //对象实体属性具象化
        String data = blog.getData();
        String title = blog.getTitle();
        String time = blog.getDate();
        String tag = blog.getTags();
        //申请JSON对象空间
        JSONObject reBlog = new JSONObject();
        reBlog.put("data",data);
        reBlog.put("title",title);
        reBlog.put("date_",time);
        reBlog.put("tags",tag);

        //判断JSON是否存在
        if (!data.equals("")){
            reBlog.put("state","true");
            response.getWriter().write(reBlog.toString());
        }else {
            reBlog.put("state","false");
            response.getWriter().write(reBlog.toString());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
