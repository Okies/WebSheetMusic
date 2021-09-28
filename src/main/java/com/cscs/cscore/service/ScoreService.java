package com.cscs.cscore.service;

import com.cscs.cscore.dto.ScoreDTO;
import com.cscs.cscore.dto.request.ScoreRequestDTO;
import com.cscs.cscore.dto.response.ScoreResponseDTO;
import com.cscs.cscore.dto.response.ScoresResponseDTO;

import java.util.List;

public interface ScoreService {

    List<ScoresResponseDTO> findAll();

    ScoreResponseDTO save(ScoreRequestDTO dto);

    ScoreResponseDTO findById(Long sid);

    ScoreResponseDTO update(Long sid, ScoreRequestDTO dto);
}
