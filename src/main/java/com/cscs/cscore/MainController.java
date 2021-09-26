package com.cscs.cscore;

import com.cscs.cscore.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final ScoreService scoreService;

    @GetMapping({"", "/"})
    public String getScores(Model model) {

        model.addAttribute("scores", scoreService.findAll());

        return "scores/list";
    }
}
