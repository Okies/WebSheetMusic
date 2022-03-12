package com.cscs.cscore.service;

import com.cscs.cscore.dto.request.PostRequestDTO;
import com.cscs.cscore.dto.response.PostResponseDTO;
import com.cscs.cscore.dto.response.PostsResponseDTO;
import com.cscs.cscore.entity.Post;
import com.cscs.cscore.exception.CommonErrorCode;
import com.cscs.cscore.exception.PostNotFoundException;
import com.cscs.cscore.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostsResponseDTO> findAll() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "pid")).stream()
                .map(PostsResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDTO save(PostRequestDTO dto) {

        return PostResponseDTO.builder()
                .entity(postRepository.save(dto.toEntity()))
                .build();
    }

    @Override
    public PostResponseDTO findById(Long pid) {

        Post post = postRepository.findById(pid).orElseThrow(() -> new PostNotFoundException(CommonErrorCode.POSTS_NOT_FOUND));

        return PostResponseDTO.builder()
                .entity(post)
                .build();
    }

    @Override
    public PostResponseDTO update(Long pid, PostRequestDTO dto) {

        Post post = postRepository.findById(pid).orElseThrow(() -> new PostNotFoundException(CommonErrorCode.POSTS_NOT_FOUND));

        post.update(dto.getTitle(), dto.getContent(), dto.getWriter());

        return PostResponseDTO.builder()
                .entity(postRepository.save(post))
                .build();
    }
}
