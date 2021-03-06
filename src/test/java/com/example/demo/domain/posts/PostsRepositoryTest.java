package com.example.demo.domain.posts;


import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    
    @Autowired
    PostsRepository postsRepository;
    
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }
    
    @Test
    public void save_And_read(){
        String title= "title";
        String content = "content";
        
        postsRepository.save(Posts.builder().title(title).content(content)
                .author("siosio@nvaer.com").build());

        List<Posts> postsList = postsRepository.findAll();
        
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeCheck(){
        LocalDateTime localDateTime = LocalDateTime.of(2021,10,21,0,0,0);
        postsRepository.save(Posts.builder().title("title")
                .content("content").
                author("aa@naver.com").build());

        List<Posts> postsList = postsRepository.findAll();

        assertThat(postsList.get(0).getCreatedDate()).isAfter(localDateTime);
        assertThat(postsList.get(0).getModifiedDate()).isAfter(localDateTime);


    }

}