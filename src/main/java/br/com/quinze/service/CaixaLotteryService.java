package br.com.quinze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaixaLotteryService {
    private final String API_URL = "https://servicebus2.caixa.gov.br/portaldeloterias/api/lotofacil/";

    private final RestTemplate restTemplate;

    @Autowired
    public CaixaLotteryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getLastLotofacilInfo() {
        return restTemplate.getForEntity(API_URL, String.class);
    }

    public ResponseEntity<String> getLotofacilInfoByNumber(int concursoNumero) {
        String apiUrl = API_URL + concursoNumero;
        return restTemplate.getForEntity(apiUrl, String.class);
    }
}
