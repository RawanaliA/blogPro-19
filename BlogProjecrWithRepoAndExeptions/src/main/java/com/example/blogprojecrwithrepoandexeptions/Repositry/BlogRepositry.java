package com.example.blogprojecrwithrepoandexeptions.Repositry;
import com.example.blogprojecrwithrepoandexeptions.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepositry extends JpaRepository<Blog,Integer> {
    Blog getBlogById(Integer id);
    List<Blog> getBlogByCategory(String category);
    Blog getBlogByTitle(String title);
    Blog getBlogByPublished(boolean p);

}
