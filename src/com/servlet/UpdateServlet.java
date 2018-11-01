package com.servlet;

import com.dao.BlogDao;
import com.dao.BlogDaoImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实现字符中文化
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
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
        String title = request.getParameter("title");
        String tags = request.getParameter("tags");
        String date = request.getParameter("date");
        String data = request.getParameter("data");
        //实例化接口方法
        BlogDao bd = new BlogDaoImpl();
        //实现更新文章方法
        if (bd.updateArticle(id,data,title,date,tags)){
            JSONObject obj = new JSONObject();
            obj.put("state","true");
            response.getWriter().write(obj.toString());
            //实现页面转跳
        }else {
            JSONObject obj = new JSONObject();
            obj.put("state","false");
            response.getWriter().write(obj.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
