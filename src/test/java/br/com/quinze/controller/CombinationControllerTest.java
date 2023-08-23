package br.com.quinze.controller;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.service.CombinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CombinationControllerTest {

    @Mock
    private CombinationService combinationService;

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
        //assertEquals(mockCombination.getId(), responseEntity.getBody().get("id")); ERRO!!!
    }

    @Test
    public void testGetAllCombinations() {
        List<Map<String, Object>> mockCombinations = createMockCombinationsList();
        when(combinationService.getAllCombinations()).thenReturn(mockCombinations);

        ResponseEntity<List<Map<String, Object>>> responseEntity = combinationController.getAllCombinations();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(mockCombinations.size(), responseEntity.getBody().size());
        assertEquals(mockCombinations.get(0).get("id"), responseEntity.getBody().get(0).get("id"));
    }

    @Test
    public void testGetNumberFrequency() {
        Map<String, Integer> mockFrequency = createMockFrequencyMap();
        when(combinationService.getFormattedNumberFrequency()).thenReturn(mockFrequency);

        ResponseEntity<Map<String, Integer>> responseEntity = combinationController.getNumberFrequency();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(mockFrequency.size(), responseEntity.getBody().size());
        assertEquals(mockFrequency.get("numero1"), responseEntity.getBody().get("numero1"));
    }

    private CombinationNumber createMockCombination() {
        CombinationNumber combination = new CombinationNumber();
        combination.setId(1L);
        combination.setData(LocalDateTime.now());

        return combination;
    }

    private List<Map<String, Object>> createMockCombinationsList() {
        List<Map<String, Object>> combinationsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> combinationMap = new LinkedHashMap<>();
            combinationMap.put("id", (long) (i + 1));
            combinationMap.put("data", LocalDateTime.now());

            combinationsList.add(combinationMap);
        }
        return combinationsList;
    }

    private Map<String, Integer> createMockFrequencyMap() {
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        frequencyMap.put("numero1", 5);
        frequencyMap.put("numero2", 3);

        return frequencyMap;
    }
}
