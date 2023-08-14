package br.com.quinze.service;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.repository.CombinationNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CombinationServiceTest {

    @Mock
    private CombinationNumberRepository numberRepository;

    @InjectMocks
    private CombinationService combinationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateCombination() {
        when(numberRepository.save(any())).thenReturn(new CombinationNumber());

        CombinationNumber generatedCombination = combinationService.generateCombination();

        verify(numberRepository, times(1)).save(any());
    }

    @Test
    public void testGenerateShuffledNumbers() {
        List<Integer> shuffledNumbers = combinationService.generateShuffledNumbers();

        assertNotNull(shuffledNumbers);
        assertEquals(15, shuffledNumbers.size());

        for (Integer number : shuffledNumbers) {
            assertTrue(number >= 1 && number <= 25, "Number out of range: " + number);
        }
    }
}