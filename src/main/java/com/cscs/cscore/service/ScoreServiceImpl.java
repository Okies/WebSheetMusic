package com.cscs.cscore.service;

import com.cscs.cscore.dto.request.ScorePageRequestDTO;
import com.cscs.cscore.dto.request.ScoreRequestDTO;
import com.cscs.cscore.dto.response.ScorePageResponseDTO;
import com.cscs.cscore.dto.response.ScoreResponseDTO;
import com.cscs.cscore.dto.response.ScoresResponseDTO;
import com.cscs.cscore.entity.QScore;
import com.cscs.cscore.entity.Score;
import com.cscs.cscore.exception.CommonErrorCode;
import com.cscs.cscore.exception.ScoreNotFoundException;
import com.cscs.cscore.repository.ScoreRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class ScoreServiceImpl implements ScoreService{

    private final ScoreRepository scoreRepository;

    @Override
    public List<ScoresResponseDTO> findAll() {
        return scoreRepository.findAll(Sort.by(Sort.Direction.DESC, "sid")).stream()
                .map(ScoresResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ScorePageResponseDTO getList(ScorePageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageble(Sort.by(Sort.Direction.DESC, "sid"));

        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Score> scorePage = scoreRepository.findAll(booleanBuilder, pageable);

        return ScorePageResponseDTO.builder()
                .scorePage(scorePage)
                .build();
    }

    @Override
    public ScoreResponseDTO findById(Long sid) {

        Score score = scoreRepository.findById(sid).orElseThrow(() -> new ScoreNotFoundException(CommonErrorCode.SCORES_NOT_FOUND));

        return ScoreResponseDTO.builder()
                .entity(score)
                .build();
    }

    @Override
    public ScoreResponseDTO save(ScoreRequestDTO dto) {
        return ScoreResponseDTO.builder()
                .entity(scoreRepository.save(dto.toEntity()))
                .build();
    }

    @Override
    public ScoreResponseDTO update(Long sid, ScoreRequestDTO dto) {

        Score score = scoreRepository.findById(sid).orElseThrow(() -> new ScoreNotFoundException(CommonErrorCode.SCORES_NOT_FOUND));

        score.update(dto.getTitle(), dto.getNotation(), dto.getWriter());

        return ScoreResponseDTO.builder()
                .entity(scoreRepository.save(score))
                .build();
    }

    private BooleanBuilder getSearch(ScorePageRequestDTO requestDTO) {

        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QScore qScore = QScore.score;

        BooleanExpression expression = qScore.sid.gt(0L);
        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")) {
            conditionBuilder.or(qScore.title.contains(keyword));
        }
        if(type.contains("w")) {
            conditionBuilder.or(qScore.writer.contains(keyword));
        }

        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
