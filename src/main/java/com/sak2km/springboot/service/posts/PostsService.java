package com.sak2km.springboot.service.posts;

import com.sak2km.springboot.domain.posts.Posts;
import com.sak2km.springboot.domain.posts.PostsRepository;
import com.sak2km.springboot.web.dto.PostsResponseDto;
import com.sak2km.springboot.web.dto.PostsSaveRequestDto;
import com.sak2km.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No post exists. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No post exists. id=" + id));
        return new PostsResponseDto(entity);
    }
}
