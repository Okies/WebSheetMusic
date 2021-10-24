package com.cscs.cscore.controller;

import com.cscs.cscore.dto.request.ScoreRequestDTO;
import com.cscs.cscore.dto.response.ScoreResponseDTO;
import com.cscs.cscore.dto.response.ScoresResponseDTO;
import com.cscs.cscore.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/scores")
@RestController
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping({"", "/"})
    public List<ScoresResponseDTO> getScores() {

        return scoreService.findAll();

    }

    @GetMapping("/{sid}")
    public ScoreResponseDTO getScore(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        return scoreService.findById(sid);
    }

    @PostMapping()
    @ResponseBody
    public ScoreResponseDTO save(@RequestBody ScoreRequestDTO requestDTO) {

        log.info("save...", requestDTO.toString());

        return scoreService.save(requestDTO);
    }

    @PutMapping("/{sid}")
    @ResponseBody
    public ScoreResponseDTO update(@PathVariable Long sid, @RequestBody ScoreRequestDTO requestDTO) {

        log.info("update..." + requestDTO.toString());

        return scoreService.update(sid, requestDTO);
    }
}
