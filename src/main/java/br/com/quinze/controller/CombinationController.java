package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;
import br.com.quinze.repository.CombinationNumberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/combinations")
public class CombinationController {

    private final CombinationService combinationService;
    private final CombinationNumberRepository numberRepository;

    @Autowired
    public CombinationController(CombinationService combinationService, CombinationNumberRepository numberRepository) {
        this.combinationService = combinationService;
        this.numberRepository = numberRepository;
    }

    @GetMapping("/generate")
    public ResponseEntity<CombinationNumber> generateCombination() {
        CombinationNumber combination = combinationService.generateCombination();
        return new ResponseEntity<>(combination, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CombinationNumber>> getAllCombinations() {
        List<CombinationNumber> combinations = numberRepository.findAll();
        return new ResponseEntity<>(combinations, HttpStatus.OK);
    }
}