package com.dao;

import com.entity.BlogBlock;
import com.util.DBconn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoImpl implements BlogDao{
    @Override
    public BlogBlock getArticle(String id) {
        try {
            DBconn.init();
            //编写sql语句
            String sql = "SELECT * FROM blog WHERE id='"+ id +"'";
            //得到选择后的数据
            ResultSet rs = DBconn.selectData(sql);
            //实例化博客类，并具象属性
            BlogBlock blog = new BlogBlock();
            blog.setTitle(rs.getString("title"));
            blog.setData(rs.getString("data"));
            blog.setTags("tags");

            DBconn.closeConn();

            return blog;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateArticle(String id, String data,String title,String date,String tags) {
        boolean flag = false;
        try {
            DBconn.init();
            //拼装sql语句
            String sql = "UPDATE blog SET data='" + data + "',title='" + title+ "',date_='" + date + "',tags='" + tags +"' WHERE id=" + id;
            //获得受影响的数据条数
            int i = DBconn.addUpDel(sql);
            //当有数据收到影响，判断为真
            if(i > 0){
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean uploadArticle(BlogBlock blog) {
        boolean flag = false;
        try {
            DBconn.init();
            //拼装sql语句
            String sql = "INSERT INTO blog(title,data,date_,tags) "+
                    "VALUES('" + blog.getTitle() +"','" + blog.getData() +"','" + blog.getDate() + "','" + blog.getTags() +
                    "')";
            //获得受影响条数
            int i = DBconn.addUpDel(sql);
            if(i > 0){
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<BlogBlock> getAllArticle() {
        List<BlogBlock> list = new ArrayList<BlogBlock>();
        try {
            DBconn.init();
            //获得所有文章
            ResultSet rs = DBconn.selectData("SELECT * FROM blog");
            while (rs.next()){
                //实例化博客类
                BlogBlock blog = new BlogBlock();
                //具象化博客实例
                blog.setId(rs.getString("id"));
                blog.setTitle(rs.getString("title"));
                blog.setDate(rs.getString("date_"));
                blog.setData(rs.getString("data"));
                blog.setTags(rs.getString("tags"));
                //添加本实例进入list
                list.add(blog);
            }
            DBconn.closeConn();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteArticle(String id) {
        boolean flag = false;
        try {
            DBconn.init();
            //拼装sql语句
            String sql= "DELETE * FROM blog WHERE id='" + id + "'";
            //同上方法
            int i = DBconn.addUpDel(sql);
            if(i > 0){
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
