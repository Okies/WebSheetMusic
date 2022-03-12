package com.cscs.cscore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class ScorePageRequestDTO {

    private int page;
    private int size;

    public ScorePageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageble(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
