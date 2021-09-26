package com.cscs.cscore.controller;

import com.cscs.cscore.dto.ScoreDTO;
import com.cscs.cscore.dto.request.ScoreRequestDTO;
import com.cscs.cscore.dto.response.ScoreResponseDTO;
import com.cscs.cscore.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/scores")
@Controller
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping({"", "/"})
    public String getScores(Model model) {

        model.addAttribute("scores", scoreService.findAll());

        return "/scores/list";
    }

    @GetMapping("/{sid}")
    public String getScore(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        model.addAttribute("score", scoreService.findById(sid));

        return "/scores/detail";
    }

    @GetMapping("/new")
    public void newScore() {

    }

    @PostMapping()
    @ResponseBody
    public ScoreResponseDTO save(@RequestBody ScoreRequestDTO requestDTO) {

        log.info("save...", requestDTO.toString());



        return scoreService.save(requestDTO);
    }
}
