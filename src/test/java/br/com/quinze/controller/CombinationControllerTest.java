package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;
import br.com.quinze.repository.CombinationNumberRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

public class CombinationControllerTest {

    @Mock
    private CombinationService combinationService;

    @Mock
    private CombinationNumberRepository numberRepository;

    @InjectMocks
    private CombinationController combinationController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateCombination() {
        CombinationNumber mockCombination = createMockCombination();
        when(combinationService.generateCombination()).thenReturn(mockCombination);

        ResponseEntity<Map<String, Object>> responseEntity = combinationController.generateCombination();

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(mockCombination.getId(), responseEntity.getBody().get("id"));
    }

    @Test
    public void testGetNumberFrequency() {
        Map<Integer, Long> numberFrequency = new HashMap<>();
        numberFrequency.put(1, 2L);
        numberFrequency.put(2, 3L);

        when(combinationService.getNumberFrequency()).thenReturn(numberFrequency);

        ResponseEntity<Map<String, Integer>> responseEntity = combinationController.getNumberFrequency();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        Map<String, Integer> expectedFormattedFrequency = new LinkedHashMap<>();
        for (int i = 1; i <= 25; i++) {
            expectedFormattedFrequency.put("numero" + i, numberFrequency.getOrDefault(i, 0L).intValue());
        }

        assertEquals(expectedFormattedFrequency, responseEntity.getBody());
    }


    private CombinationNumber createMockCombination() {
        CombinationNumber combination = new CombinationNumber();
        combination.setId(1L);
        combination.setData(LocalDateTime.now());
        return combination;
    }
}
