package br.com.quinze.service;

import br.com.quinze.repository.CombinationNumberRepository;
import br.com.quinze.model.CombinationNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CombinationServiceTest {

    @Mock
    private CombinationNumberRepository numberRepository;

    @InjectMocks
    private CombinationService combinationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateCombination() {
        CombinationNumber mockCombination = new CombinationNumber();
        mockCombination.setId(1L);
        mockCombination.setCreationTime(LocalDateTime.now());

        when(numberRepository.save(any(CombinationNumber.class))).thenReturn(mockCombination);

        CombinationNumber generatedCombination = combinationService.generateCombination();

        assertEquals(mockCombination.getId(), generatedCombination.getId());
        assertEquals(mockCombination.getCreationTime(), generatedCombination.getCreationTime());

        verify(numberRepository, times(1)).save(any(CombinationNumber.class));
    }
}
