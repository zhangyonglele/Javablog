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

@WebServlet(name = "DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符中文化
        request.setCharacterEncoding("utf8");
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

        //从前端获得删除文章的id
        String id = request.getParameter("id");
        //实例化接口方法
        BlogDao bd = new BlogDaoImpl();
        //实现删除文章
        if(bd.deleteArticle(id)){
            //向前端返回是否成功
            JSONObject obj = new JSONObject();
            obj.put("state","true");
            response.getWriter().write(obj.toString());
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
