package com.cscs.cscore.controller;

import com.cscs.cscore.service.PostService;
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
    private final PostService postService;

    @GetMapping({"scores", "scores/"})
    public String getPageScoreList(Model model) {

        model.addAttribute("scores", scoreService.findAll());

        return "scores/scoreList";
    }

    @GetMapping("scores/{sid}")
    public String getPageScoreDetail(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        model.addAttribute("score", scoreService.findById(sid));

        return "scores/scoreDetail";
    }

    @GetMapping("scores/new")
    public String getPageScoreNew() {

        return "scores/scoreNew";
    }

    @GetMapping("scores/{sid}/modify")
    public String getPageScoreModify(@PathVariable Long sid, Model model) {

        log.info("getScore... sid : " + sid);

        model.addAttribute("score", scoreService.findById(sid));

        return "scores/scoreModify";

    }

    @GetMapping({"posts", "posts/"})
    public String getPagePostList(Model model) {

        model.addAttribute("posts", postService.findAll());

        return "posts/postList";
    }

    @GetMapping("posts/{pid}")
    public String getPagePostDetail(@PathVariable Long pid, Model model) {

        log.info("getPost... pid : " + pid);

        model.addAttribute("post", postService.findById(pid));

        return "posts/postDetail";
    }

    @GetMapping("posts/new")
    public String getPagePostNew() {

        return "posts/postNew";
    }

    @GetMapping("posts/{pid}/modify")
    public String getPagePostModify(@PathVariable Long pid, Model model) {

        log.info("getPost... pid : " + pid);

        model.addAttribute("post", postService.findById(pid));

        return "posts/postModify";

    }
}
