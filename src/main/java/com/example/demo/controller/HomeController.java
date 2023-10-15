package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class HomeController {

    @GetMapping("/home")
    String home(Model model, @RequestParam(value = "Name", required = false, defaultValue = "123") String name){
        model.addAttribute("Name",name);
        return "home";
    }
@PostMapping("/home")
    String toPrintText(Model model,@RequestParam(value = "Name", required = false, defaultValue = "") String name){
        model.addAttribute("name", name);
        return "redirect:/home?Name=" + name;
    }

    @GetMapping("/calc")
    String calc(){
        return "calc";
    }

    @PostMapping("/calc1")
    String Plus(Model model,@RequestParam(value = "Int1") int int1, @RequestParam(value = "Int2") int int2){
        int result = int1+int2;
        model.addAttribute("result", result);
        return "calcResult";
    }
    @PostMapping("/calc2")
    String Minus(Model model,@RequestParam(value = "Int11") int int1, @RequestParam(value = "Int22") int int2){
        int result = int1-int2;
        model.addAttribute("result", result);
        return "calcResult";
    }
    @PostMapping("/calc3")
    String Umn(Model model,@RequestParam(value = "Int111") int int1, @RequestParam(value = "Int222") int int2){
        int result = int1*int2;
        model.addAttribute("result", result);
        return "calcResult";
    }
    @PostMapping("/calc4")
    String Del(Model model,@RequestParam(value = "Int1111") int int1, @RequestParam(value = "Int2222") int int2){
        int result = int1/int2;
        model.addAttribute("result", result);
        return "calcResult";
    }



    @GetMapping("/converter")
    String converter(){
        return "converter";
    }

    @PostMapping("/converter")
    String Conv1(Model model, @RequestParam(value = "Select1") String select1, @RequestParam(value = "Select2") String select2, @RequestParam(value = "convInt1") int convint1){
        double convint2 = 0;
        if(select1.equals("Рубль") && select2.equals("Доллар")){
           convint2 = convint1/ 100;
        }
        if(select1.equals("Рубль") && select2.equals("Рубль")){
            convint2 = convint1;
        }
        if(select1.equals("Рубль") && select2.equals("Евро")){
            convint2 = convint1/120;
        }

        if(select1.equals("Доллар") && select2.equals("Доллар")){
            convint2 = convint1;
        }
        if(select1.equals("Доллар") && select2.equals("Рубль")){
            convint2 = convint1*100;
        }
        if(select1.equals("Доллар") && select2.equals("Евро")){
            convint2 = convint1*100/120;
        }

        if(select1.equals("Евро") && select2.equals("Доллар")){
            convint2 = convint1*120/100;
        }
        if(select1.equals("Евро") && select2.equals("Рубль")){
            convint2 = convint1*120;
        }
        if(select1.equals("Евро") && select2.equals("Евро")){
            convint2 = convint1;
        }

        model.addAttribute("resultConverter", convint2);
        return "converter";
    }
}
