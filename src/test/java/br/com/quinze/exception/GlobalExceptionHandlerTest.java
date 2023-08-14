package br.com.quinze.exception;

import org.junit.jupiter.api.Test;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleException() {
        Exception exception = new Exception("Erro de teste");
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<String> response = exceptionHandler.handleException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Ocorreu um erro interno no servidor.", response.getBody());
    }

    @Test
    public void testHandleNotFoundException() {
        ChangeSetPersister.NotFoundException notFoundException = new ChangeSetPersister.NotFoundException();
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<String> response = exceptionHandler.handleNotFoundException(notFoundException);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

}
