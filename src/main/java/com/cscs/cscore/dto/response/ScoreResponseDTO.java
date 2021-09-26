package com.cscs.cscore.dto.response;

import com.cscs.cscore.entity.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScoreResponseDTO {

    private Long sid;
    private String title;
    private String notation;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public ScoreResponseDTO(Score entity) {
        this.sid = entity.getSid();;
        this.title = entity.getTitle();
        this.notation = entity.getNotation();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();
    }
}