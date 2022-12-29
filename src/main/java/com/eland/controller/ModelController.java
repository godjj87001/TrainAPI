package com.eland.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public class modelController {
    @GetMapping(value = "/modelMap")
// 將ModelMap 作為Controller 的引數，由Spring 框架自動創建並作為參數傳入
    public String modelMap(ModelMap modelMap) {
        // 設定傳遞資料
        modelMap.addAttribute("message", "Hello thymeleaf. (using ModelMap)");

        // 返回值指定頁面路徑
        return "model";
    }
    @GetMapping(value = "/model")
// 將Model 作為Controller 的引數，由Spring 框架自動創建並作為參數傳入
    public String model(Model model) {
        // 設定傳遞資料
        model.addAttribute("message", "Hello thymeleaf. (using Model)");

        // 返回值指定頁面路徑
        return "model";
    }
}
