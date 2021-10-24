package com.cscs.cscore.dto.response;

import com.cscs.cscore.entity.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScoresResponseDTO {

    private Long sid;
    private String title;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public ScoresResponseDTO(Score entity) {
        this.sid = entity.getSid();;
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();
    }
}
