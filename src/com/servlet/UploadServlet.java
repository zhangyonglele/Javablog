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

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符中文化
        request.setCharacterEncoding("utf8");
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
        String data = request.getParameter("data");
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String tags = request.getParameter("tags");
        //拼装博客类
        BlogBlock bg = new BlogBlock();
        bg.setTags(tags);
        bg.setData(data);
        bg.setTitle(title);
        bg.setDate(date);
        //实例化接口方法
        BlogDao blog = new BlogDaoImpl();
        //判断更新是否成狗
        if(blog.uploadArticle(bg)){
            //创建“成功情况”返还的JSON对象
            JSONObject obj = new JSONObject();
            obj.put("state","true");
            response.getWriter().write(obj.toString());
        }else {
            //创建“失败情况”返还的JSON对象
            JSONObject obj = new JSONObject();
            obj.put("state","false");
            response.getWriter().write(obj.toString());
        }
        
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Uploading function has been run");
    }

    @Override
    public void destroy() {
        System.out.println("Uploading function has ended");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
