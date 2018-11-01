package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.Manager;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Registering function has been run");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文字符编码
        resp.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf-8");
        //获得前端数据
        String name  = req.getParameter("name");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");

        //数据跨域申请
        resp.setHeader("Access-Control-Allow-Origin","*");
        //
        resp.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        resp.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        resp.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        //实例化对象并具象化
        Manager manager = new Manager();
        manager.setUserName(name);
        manager.setPassword(password);
        manager.setAge(age);
        manager.setSex(sex);
        //实例化接口方法，并判断注册状态
        UserDao ud = new UserDaoImpl();
        if(ud.register(manager)){
            //成功情况下返还的JSON
            JSONObject obj = new JSONObject();
            obj.put("state","true");
            resp.getWriter().write(obj.toString());
        }else {
            //失败情况下返还的JSON
            JSONObject obj = new JSONObject();
            obj.put("state","false");
            resp.getWriter().write(obj.toString());
        }
    }

    @Override
    public void destroy() {
        System.out.println("Registering function has been destroyed");
    }
}
