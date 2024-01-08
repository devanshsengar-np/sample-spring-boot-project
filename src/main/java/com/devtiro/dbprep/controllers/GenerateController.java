//
//package com.devtiro.dbprep.controllers;
//
//import com.devtiro.dbprep.domain.Book;
//import com.devtiro.dbprep.services.GenerateService;
//import com.devtiro.dbprep.services.PostService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class GenerateController {
//    private final GenerateService generateService;
//
//    public GenerateController(GenerateService generateService) {
//        this.generateService = generateService;
//    }
//
//
//    @GetMapping("/generate")
//    public String generateData() {
//        generateService.generate(); // Call the service method to generate data
//        return "generation successful"; // simple return msg
//    }
//}
//
