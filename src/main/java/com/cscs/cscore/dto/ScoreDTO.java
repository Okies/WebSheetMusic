package com.cscs.cscore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScoreDTO {

    private Long sid;
    private String title;
    private String notation;
    private String writer;
    private LocalDateTime regDate, modDate;


}
