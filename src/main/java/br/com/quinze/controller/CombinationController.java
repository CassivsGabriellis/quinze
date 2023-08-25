package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CaixaLotteryService;
import br.com.quinze.service.CombinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/combinacao")
public class CombinationController {

    private final CombinationService combinationService;
    private final CaixaLotteryService caixaLotteryService;

    @Autowired
    public CombinationController(CombinationService combinationService, CaixaLotteryService caixaLotteryService) {
        this.combinationService = combinationService;
        this.caixaLotteryService = caixaLotteryService;
    }

    @PostMapping("/gerar-combinacao")
    public ResponseEntity<Map<String, Object>> generateCombination() {
        CombinationNumber combination = combinationService.generateCombination();
        Map<String, Object> response = combinationService.createCombinationResponse(combination);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/todas-combinacoes")
    public ResponseEntity<List<Map<String, Object>>> getAllCombinations() {
        List<Map<String, Object>> combinations = combinationService.getAllCombinations();
        return new ResponseEntity<>(combinations, HttpStatus.OK);
    }

    @GetMapping("/estatisticas/frequencia")
    public ResponseEntity<Map<String, Integer>> getNumberFrequency() {
        Map<String, Integer> formattedNumberFrequency = combinationService.getFormattedNumberFrequency();
        return new ResponseEntity<>(formattedNumberFrequency, HttpStatus.OK);
    }

    // Endpoints for consuming the Caixa Lotofácil API
    @GetMapping("/caixa-api/lotofacil")
    public ResponseEntity<String> getLastLotofacilConcurso() {
        return caixaLotteryService.getLastLotofacilInfo();
    }

    @GetMapping("/caixa-api/lotofacil/{numero}")
    public ResponseEntity<String> getLotofacilConcurso(@PathVariable int numero) {
        return caixaLotteryService.getLotofacilInfoByNumber(numero);
    }
}