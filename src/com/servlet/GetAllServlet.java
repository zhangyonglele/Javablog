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
import java.util.List;

@WebServlet(name = "GetAllServlet")
public class GetAllServlet extends HttpServlet {
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

        //实例化接口方法并获取所有的博客数据
        BlogDao bd = new BlogDaoImpl();
        List<BlogBlock> allArticle = bd.getAllArticle();
        for (BlogBlock blog : allArticle){
            JSONObject json = new JSONObject();
            json.put("id",blog.getId());
            json.put("title",blog.getTitle());
            json.put("tags",blog.getTags());
            json.put("date",blog.getDate());
            json.put("data",blog.getData());
            response.getWriter().write(json.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
