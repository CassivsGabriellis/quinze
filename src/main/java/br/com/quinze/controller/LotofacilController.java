package br.com.quinze.controller;

import br.com.quinze.service.CaixaLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lotofacil")
public class LotofacilController {

    private final CaixaLotteryService caixaLotteryService;

    @Autowired
    public LotofacilController(CaixaLotteryService caixaLotteryService) {
        this.caixaLotteryService = caixaLotteryService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getLastLotofacilConcurso() {
        return caixaLotteryService.getLastLotofacilInfo();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<String> getLotofacilConcurso(@PathVariable int numero) {
        return caixaLotteryService.getLotofacilInfoByNumber(numero);
    }
}
