package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;
import br.com.quinze.repository.CombinationNumberRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CombinationControllerTest {

    private CombinationController combinationController;
    private CombinationService combinationService;
    private CombinationNumberRepository numberRepository;

    @BeforeEach
    public void setUp() {
        combinationService = mock(CombinationService.class);
        numberRepository = mock(CombinationNumberRepository.class);
        combinationController = new CombinationController(combinationService, numberRepository);
    }

    @Test
    public void testGenerateCombination() {
        CombinationNumber combination = new CombinationNumber();
        when(combinationService.generateCombination()).thenReturn(combination);

        ResponseEntity<CombinationNumber> response = combinationController.generateCombination();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(combination, response.getBody());
    }

    @Test
    public void testGetAllCombinations() {
        List<CombinationNumber> combinations = List.of(new CombinationNumber(), new CombinationNumber());
        when(numberRepository.findAll()).thenReturn(combinations);

        ResponseEntity<List<CombinationNumber>> response = combinationController.getAllCombinations();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(combinations, response.getBody());
    }
}
