package com.sak2km.springboot.domain.posts;
import com.sak2km.springboot.web.HelloController;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;
import java.util.List;
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
    public void loadPosts(){
        String title = "Test Title";
        String content = "Test Content";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("sak2km@gmail.com")
                .build());
        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void post_BaseTimeEntity(){
        LocalDateTime now = LocalDateTime.of(2020,6,4,0,0,0);
        String title = "Title";
        String content = "Content";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("sak2km@gmail.com")
                .build());
        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        System.out.println(">>>>>>>>> createDate = "+posts.getCreatedDate()+"modifiedDate = " + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
