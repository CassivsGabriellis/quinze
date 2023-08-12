package br.com.quinze.service;

import br.com.quinze.repository.CombinationNumberRepository;
import br.com.quinze.model.CombinationNumber;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        newCombination.setData(LocalDateTime.now());

        return numberRepository.save(newCombination);
    }

    private List<Integer> generateShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

}