package br.com.quinze.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Erro interno no servidor:", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor.");
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(ChangeSetPersister.NotFoundException e) {
        logger.error("Recurso não encontrado:", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}