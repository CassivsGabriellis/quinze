package br.com.quinze.service;

import br.com.quinze.model.CombinationNumber;
import br.com.quinze.repository.CombinationNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    public void testGetNumberFrequency() {
        List<CombinationNumber> combinations = createMockCombinations();
        when(numberRepository.findAll()).thenReturn(combinations);

        Map<Integer, Long> numberFrequency = combinationService.getNumberFrequency();

        Map<Integer, Long> expectedFrequency = IntStream.rangeClosed(1, 15)
                .boxed()
                .collect(Collectors.toMap(
                        number -> number,
                        number -> (long) combinations.size(),
                        (existingValue, newValue) -> newValue
                ));

        assertEquals(expectedFrequency, numberFrequency);
    }

    private List<CombinationNumber> createMockCombinations() {
        List<CombinationNumber> combinations = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CombinationNumber combination = new CombinationNumber();
            combination.setId((long) (i + 1));

            // Set numbers from 1 to 15 in the combination
            for (int j = 1; j <= 15; j++) {
                setNumberInCombination(combination, j, j);
            }

            combinations.add(combination);
        }
        return combinations;
    }

    private void setNumberInCombination(CombinationNumber combination, int index, int value) {
        try {
            Field field = CombinationNumber.class.getDeclaredField("numero" + index);
            field.setAccessible(true);
            field.set(combination, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException("Índice inválido: " + index, e);
        }
    }
}