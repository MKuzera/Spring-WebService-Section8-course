package com.javacourse.section8.Posts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PostController {
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;

        Post post = new Post(0,"Pierwszy","XD", LocalDate.now(),1);
        Post post1 = new Post(1,"Pierwszy2","XD2", LocalDate.now(),0);
        Post post2 = new Post(2,"Pierwszy3","XD3", LocalDate.now(),1);

        postRepository.save(post);
        postRepository.save(post1);
        postRepository.save(post2);


    }

    private PostRepository postRepository;
    @GetMapping(value = "webusers/{iduser}/posts")
    public List<Post> getListOfPostsOfSpecificUser(@PathVariable int iduser){
        return postRepository.findAllByAddedByUser(iduser);
    }

    @GetMapping(value = "webusers/{iduser}/posts/{postid}")
    public Post getPostByIdOfSpecificUser(@PathVariable int iduser, @PathVariable int postid){
        List<Post> allByAddedByUser = postRepository.findAllByAddedByUser(iduser);
        for (Post post:allByAddedByUser) {
            if(post.getId() == postid){
                return post;
            }
        }
        return null;
    }
}
