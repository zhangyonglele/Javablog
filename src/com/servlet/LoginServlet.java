package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置返还字符中文化
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf8");
        //获得用户密码和用户名
        String name  = req.getParameter("name");
        String password = req.getParameter("password");
        //实体化JSON数据
        JSONObject data = new JSONObject();
        data.put("id","1");
        data.put("username",name);
        JSONObject login = new JSONObject();
        login.put("code",1);
        login.put("msg","登陆成功");
        login.put("data",data);
        //实体化接口方法
        UserDao ud = new UserDaoImpl();
        //判断用户登陆是否成功
        if(ud.login(name,password)){
            //实体化session变量
            HttpSession session = req.getSession();
            session.setAttribute("username",name);
            session.setAttribute("msg","登陆成功");
            session.setAttribute("data",data);
            session.setAttribute("code",1);
            //判断session是否存在，即判断用户的登陆状态
            if (session.isNew()){
                System.out.println("session创建成功");
                JSONObject obj = new JSONObject();
                obj.put("state","true");
                obj.put("session","new");
                //创建Cookie返回浏览器
                javax.servlet.http.Cookie cookie = new Cookie("username",name);
                //设置最大cookie存在时间为1小时
                cookie.setMaxAge(60*60);
                //返回浏览器
                resp.addCookie(cookie);
                //返回登陆信息
                resp.getWriter().write(obj.toString());
            }else {
                JSONObject obj = new JSONObject();
                obj.put("state","true");
                obj.put("session","old");
                resp.getWriter().write(obj.toString());
            }
        }else {
            JSONObject obj = new JSONObject();
            obj.put("state","false");
            obj.put("session","false");
            resp.getWriter().write(obj.toString());
        }
    }

    @Override
    public void destroy() {
        System.out.println("本次Servlet结束");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("登陆Servlet被加载");
    }
}
