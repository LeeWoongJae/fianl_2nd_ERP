package com.yedam.erp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.erp.service.TestService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

private final TestService testService;

  @GetMapping("/")
  public String main(Model model){
    model.addAttribute("boardList", testService.selectAll());
    return "index";
  }



}
