package com.cscs.cscore.dto.response;

import com.cscs.cscore.entity.Post;
import com.cscs.cscore.entity.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostResponseDTO {

    private Long pid;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public PostResponseDTO(Post entity) {
        this.pid = entity.getPid();;
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();
    }
}
