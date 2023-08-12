package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;
import br.com.quinze.repository.CombinationNumberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/combinations")
public class CombinationController {

    private final CombinationService combinationService;
    private final CombinationNumberRepository numberRepository;

    @Autowired
    public CombinationController(CombinationService combinationService, CombinationNumberRepository numberRepository) {
        this.combinationService = combinationService;
        this.numberRepository = numberRepository;
    }

    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateCombination() {
        CombinationNumber combination = combinationService.generateCombination();
        Map<String, Object> response = createCombinationResponse(combination);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllCombinations() {
        List<CombinationNumber> combinations = numberRepository.findAll();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (CombinationNumber combination : combinations) {
            Map<String, Object> response = createCombinationResponse(combination);
            responseList.add(response);
        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }


    private Map<String, Object> createCombinationResponse(CombinationNumber combination) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", combination.getId());
        response.put("data", combination.getData());
        response.put("numeros", createNumerosMap(combination));

        return response;
    }

    private Map<String, Integer> createNumerosMap(CombinationNumber combination) {
        Map<String, Integer> numerosMap = new LinkedHashMap<>();
        numerosMap.put("numero1", combination.getNumero1());
        numerosMap.put("numero2", combination.getNumero2());
        numerosMap.put("numero3", combination.getNumero3());
        numerosMap.put("numero4", combination.getNumero4());
        numerosMap.put("numero5", combination.getNumero5());
        numerosMap.put("numero6", combination.getNumero6());
        numerosMap.put("numero7", combination.getNumero7());
        numerosMap.put("numero8", combination.getNumero8());
        numerosMap.put("numero9", combination.getNumero9());
        numerosMap.put("numero10", combination.getNumero10());
        numerosMap.put("numero11", combination.getNumero11());
        numerosMap.put("numero12", combination.getNumero12());
        numerosMap.put("numero13", combination.getNumero13());
        numerosMap.put("numero14", combination.getNumero14());
        numerosMap.put("numero15", combination.getNumero15());

        return numerosMap;
    }
}