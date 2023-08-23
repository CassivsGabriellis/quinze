package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/combinations")
public class CombinationController {

    private final CombinationService combinationService;

    @Autowired
    public CombinationController(CombinationService combinationService) {
        this.combinationService = combinationService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateCombination() {
        CombinationNumber combination = combinationService.generateCombination();
        Map<String, Object> response = combinationService.createCombinationResponse(combination);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllCombinations() {
        List<Map<String, Object>> combinations = combinationService.getAllCombinations();
        return new ResponseEntity<>(combinations, HttpStatus.OK);
    }

    @GetMapping("/statistics/number-frequency")
    public ResponseEntity<Map<String, Integer>> getNumberFrequency() {
        Map<String, Integer> formattedNumberFrequency = combinationService.getFormattedNumberFrequency();
        return new ResponseEntity<>(formattedNumberFrequency, HttpStatus.OK);
    }

}