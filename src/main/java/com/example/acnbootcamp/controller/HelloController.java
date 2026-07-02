package com.example.acnbootcamp.controller;

import com.example.acnbootcamp.model.DeploymentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${app.deployment.branch:unknown}")
    private String deploymentBranch;

    @Value("${app.deployment.commit:unknown}")
    private String deploymentCommit;

    @Value("${app.deployment.timestamp:unknown}")
    private String deploymentTimestamp;

    @Value("${server.port:3100}")
    private String serverPort;

    @GetMapping("/")
    public String index(Model model) {
        DeploymentInfo deploymentInfo = new DeploymentInfo(
            deploymentBranch,
            deploymentCommit,
            deploymentTimestamp
        );
        model.addAttribute("deploymentInfo", deploymentInfo);
        model.addAttribute("serverPort", serverPort);
        return "index";
    }

    @PostMapping("/message")
    public String submitMessage(@RequestParam("message") String message) {
        logger.info("User submitted message: {}", message);
        return "redirect:/";
    }

}
