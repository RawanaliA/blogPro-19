package com.example.blogprojecrwithrepoandexeptions.Services;

import com.example.blogprojecrwithrepoandexeptions.ApiExeption.ApiExeption;
import com.example.blogprojecrwithrepoandexeptions.Model.Blog;
import com.example.blogprojecrwithrepoandexeptions.Repositry.BlogRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServices {
    private final BlogRepositry blogRepositry;

    public List<Blog> getAllblogs(){
      return   blogRepositry.findAll();
    }
    public void addBlogs(Blog blog){
   blogRepositry.save(blog);
    }
    public void updateBlogs(Integer id ,Blog blog){
        Blog oldBlog=blogRepositry.getById(id);
        if(oldBlog==null)
        {
            throw new ApiExeption("enter vailid data");
        }
        oldBlog.setId(blog.getId());
        oldBlog.setBody(blog.getBody());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setPublished(blog.isPublished());
        blogRepositry.save(oldBlog);
    }
    public void deleteBlogs(Integer id){
        Blog dblog=blogRepositry.getById(id);
        if(dblog==null){
        throw new ApiExeption("Wrong Id");
        }
        blogRepositry.delete(dblog);
    }
    //4New
    public Blog getUserByid(Integer id){
        Blog fblog=blogRepositry.getBlogById(id);
        if(fblog==null){
            throw new ApiExeption("Make sure from your ID");
        }return fblog;
    }
    public Blog getBlogByTitle(String title){
       Blog tblog=blogRepositry.getBlogByTitle(title);
        if(tblog==null)
            throw new ApiExeption("Make sure from your Title");
        return tblog;
    }
    public List<Blog> getUserByCatogry(String catogry){
        List<Blog> cblog=blogRepositry.getBlogByCategory(catogry);
        if(cblog==null)
            throw new ApiExeption("Make sure from your ID");
        return cblog;
    }
public Blog getBlogByPublished(boolean p){

        Blog bblog=blogRepositry.getBlogByPublished(p);
        if (bblog==null)
            throw new ApiExeption("");
        bblog.setPublished(true);
        blogRepositry.save(bblog);
return bblog;}


}
