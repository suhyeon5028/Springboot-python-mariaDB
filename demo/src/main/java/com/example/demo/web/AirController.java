package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Air;
import com.example.demo.domain.AirRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AirController {

    @Autowired
    private AirRepository airRepository;

    @GetMapping("/weather")
    public String main(Model model) {
        List<Air> airs = airRepository.findAll();
        // System.out.println(airs);

        model.addAttribute("airs", airs);

        return "/main";
    }
}