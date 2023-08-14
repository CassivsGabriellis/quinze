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

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testGetAllCombinations() {
        List<CombinationNumber> mockCombinations = new ArrayList<>();
        mockCombinations.add(createMockCombination());
        when(numberRepository.findAll()).thenReturn(mockCombinations);

        ResponseEntity<List<Map<String, Object>>> responseEntity = combinationController.getAllCombinations();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(mockCombinations.size(), responseEntity.getBody().size());
    }

    private CombinationNumber createMockCombination() {
        CombinationNumber combination = new CombinationNumber();
        combination.setId(1L);
        combination.setData(LocalDateTime.now());
        return combination;
    }
}
