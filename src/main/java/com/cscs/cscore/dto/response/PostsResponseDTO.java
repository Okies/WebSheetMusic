package com.cscs.cscore.dto.response;

import com.cscs.cscore.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostsResponseDTO {

    private Long pid;
    private String title;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public PostsResponseDTO(Post entity) {
        this.pid = entity.getPid();;
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();
    }
}
