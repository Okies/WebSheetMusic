package com.cscs.cscore.dto.response;

import com.cscs.cscore.entity.Score;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class ScorePageResponseDTO {

    private List<ScoresResponseDTO> scoresList;
    private final int totalPage;
    private int page;
    private int size;
    private int start, end;
    private boolean prev, next;
    private List<Integer> pageList;

    @Builder
    public ScorePageResponseDTO(Page<Score> scorePage) {
        scoresList = scorePage.stream().map(ScoresResponseDTO::new).collect(Collectors.toList());
        totalPage = scorePage.getTotalPages();
        makePageList(scorePage.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1; //0부터 시작해서 1 추가
        this.size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0)) * 10;

        start = tempEnd - 9;

        prev = start > 1;

        end = Math.min(totalPage, tempEnd);

        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
