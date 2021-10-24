package com.cscs.cscore.controller;

import com.cscs.cscore.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@RequiredArgsConstructor
@Controller
public class PageController {

    private final ScoreService scoreService;

    @GetMapping({"scores", "scores/"})
    public String getPageScores(Model model) {

        model.addAttribute("scores", scoreService.findAll());

        return "scores/list";
    }

    @GetMapping("scores/{sid}")
    public String getPageScore(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        model.addAttribute("score", scoreService.findById(sid));

        return "scores/detail";
    }

    @GetMapping("scores/new")
    public void newPageScore() {

    }

    @GetMapping("scores/{sid}/modify")
    public String getPageModify(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        model.addAttribute("score", scoreService.findById(sid));

        return "scores/modify";

    }
}
