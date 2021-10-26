package com.example.demo.Controller;

import com.example.demo.service.posts.PostsService;
import com.example.demo.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "/test/index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "/test/posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto post = postsService.findById(id);
        model.addAttribute("post", post);
        return "/test/posts-update";
    }

}
