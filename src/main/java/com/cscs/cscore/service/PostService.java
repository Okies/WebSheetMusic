package com.cscs.cscore.service;

import com.cscs.cscore.dto.request.PostRequestDTO;
import com.cscs.cscore.dto.response.PostResponseDTO;
import com.cscs.cscore.dto.response.PostsResponseDTO;

import java.util.List;

public interface PostService {

    List<PostsResponseDTO> findAll();

    PostResponseDTO save(PostRequestDTO dto);

    PostResponseDTO findById(Long sid);

    PostResponseDTO update(Long sid, PostRequestDTO dto);
}
