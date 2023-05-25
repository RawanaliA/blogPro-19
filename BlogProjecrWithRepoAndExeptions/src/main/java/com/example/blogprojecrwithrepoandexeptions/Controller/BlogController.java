package com.example.blogprojecrwithrepoandexeptions.Controller;

import com.example.blogprojecrwithrepoandexeptions.Model.Blog;
import com.example.blogprojecrwithrepoandexeptions.Services.BlogServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogServices blogServices;

    @GetMapping("/get")
    public ResponseEntity getBlog(){
       List<Blog>gblogs= blogServices.getAllblogs();
        return ResponseEntity.status(200).body(gblogs);

    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid Blog blog){
        return ResponseEntity.status(200).body("added Succssufoly");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid@PathVariable Integer id,@RequestBody Blog blog){
        blogServices.updateBlogs(id,blog);
        return ResponseEntity.status(200).body("The Blog Update it Sucssfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteBlog(Integer id){
        blogServices.deleteBlogs(id);
        return ResponseEntity.status(200).body("The Blog delete it Sucssfully");
    }
    @GetMapping("/getBy/{id}")
    public ResponseEntity<String> getUserByid(@PathVariable Integer id) {

        return ResponseEntity.status(200).body("");
    }
    @GetMapping("/get-catogry/{catogry}")
    public ResponseEntity getCoffeesByCatogry(@PathVariable String catogry){
        List<Blog> blogs=blogServices.getUserByCatogry(catogry);
        return ResponseEntity.status(200).body(blogs);
    }
    @GetMapping("/get-title/{title}")

    public ResponseEntity getByName(@PathVariable String title){
        Blog blog=blogServices.getBlogByTitle(title);

        return ResponseEntity.status(200).body(blog);
    }
    @GetMapping("/get-publshed/{pub}")

    public ResponseEntity getBlogByPublished(@PathVariable boolean pub){
        Blog blog=blogServices.getBlogByPublished(pub);

        return ResponseEntity.status(200).body(blog);
    }

}
