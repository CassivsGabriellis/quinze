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

    private List<Integer> generateShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 15);
    }
}