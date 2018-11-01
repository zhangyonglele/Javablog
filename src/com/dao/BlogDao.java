package com.dao;

import com.entity.BlogBlock;

import java.util.List;

public interface BlogDao {
    public BlogBlock getArticle(String id);
    public boolean updateArticle(String id,String data,String title,String date,String tags);
    public boolean uploadArticle(BlogBlock blog);
    public boolean deleteArticle(String id);

    public List<BlogBlock> getAllArticle();


}
