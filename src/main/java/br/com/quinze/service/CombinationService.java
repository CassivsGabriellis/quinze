package br.com.quinze.service;

import br.com.quinze.repository.CombinationNumberRepository;
import br.com.quinze.model.CombinationNumber;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CombinationService {

    private final CombinationNumberRepository numberRepository;

    public CombinationService(CombinationNumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public CombinationNumber generateCombination() {
        List<Integer> shuffledNumbers = generateShuffledNumbers();

        CombinationNumber newCombination = new CombinationNumber();
        newCombination.setNumero1(shuffledNumbers.get(0));
        newCombination.setNumero2(shuffledNumbers.get(1));
        newCombination.setNumero3(shuffledNumbers.get(2));
        newCombination.setNumero4(shuffledNumbers.get(3));
        newCombination.setNumero5(shuffledNumbers.get(4));
        newCombination.setNumero6(shuffledNumbers.get(5));
        newCombination.setNumero7(shuffledNumbers.get(6));
        newCombination.setNumero8(shuffledNumbers.get(7));
        newCombination.setNumero9(shuffledNumbers.get(8));
        newCombination.setNumero10(shuffledNumbers.get(9));
        newCombination.setNumero11(shuffledNumbers.get(10));
        newCombination.setNumero12(shuffledNumbers.get(11));
        newCombination.setNumero13(shuffledNumbers.get(12));
        newCombination.setNumero14(shuffledNumbers.get(13));
        newCombination.setNumero15(shuffledNumbers.get(14));
        newCombination.setData(LocalDateTime.now());

        return numberRepository.save(newCombination);
    }

    List<Integer> generateShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 15);
    }

    // Informa a frequência de saída de cada um dos números
    // gerados pelo usuário
    public Map<Integer, Long> getNumberFrequency() {
        List<CombinationNumber> combinations = numberRepository.findAll();
        Map<Integer, Long> numberFrequency = new HashMap<>();

        for (CombinationNumber combination : combinations) {
            for (int i = 1; i <= 15; i++) {
                int number = getNumberFromCombination(combination, i);
                numberFrequency.put(number, numberFrequency.getOrDefault(number, 0L) + 1);
            }
        }

        return numberFrequency;
    }

    public Map<String, Integer> getFormattedNumberFrequency() {
        Map<Integer, Long> numberFrequency = getNumberFrequency();

        Map<String, Integer> formattedNumberFrequency = new LinkedHashMap<>();
        for (int i = 1; i <= 25; i++) {
            formattedNumberFrequency.put("numero" + i, numberFrequency.getOrDefault(i, 0L).intValue());
        }

        return formattedNumberFrequency;
    }

    private int getNumberFromCombination(CombinationNumber combination, int index) {
        switch (index) {
            case 1:
                return combination.getNumero1();
            case 2:
                return combination.getNumero2();
            case 3:
                return combination.getNumero3();
            case 4:
                return combination.getNumero4();
            case 5:
                return combination.getNumero5();
            case 6:
                return combination.getNumero6();
            case 7:
                return combination.getNumero7();
            case 8:
                return combination.getNumero8();
            case 9:
                return combination.getNumero9();
            case 10:
                return combination.getNumero10();
            case 11:
                return combination.getNumero11();
            case 12:
                return combination.getNumero12();
            case 13:
                return combination.getNumero13();
            case 14:
                return combination.getNumero14();
            case 15:
                return combination.getNumero15();
            default:
                throw new IllegalArgumentException("Índice inválido: " + index);
        }
    }

    public Map<String, Object> createCombinationResponse(CombinationNumber combination) {
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

    public List<Map<String, Object>> getAllCombinations() {
        List<CombinationNumber> combinations = numberRepository.findAll();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (CombinationNumber combination : combinations) {
            Map<String, Object> response = createCombinationResponse(combination);
            responseList.add(response);
        }

        return responseList;
    }
}