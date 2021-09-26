package com.cscs.cscore.dto.request;

import com.cscs.cscore.entity.Score;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreRequestDTO {

    private String title;
    private String notation;
    private String writer;

    public Score toEntity() {
        return Score.builder()
                .title(title)
                .notation(notation)
                .writer(writer)
                .build();
    }
}
