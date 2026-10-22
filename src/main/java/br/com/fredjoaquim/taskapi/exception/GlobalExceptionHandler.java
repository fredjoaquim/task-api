package br.com.fredjoaquim.taskapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarErroDeValidacao(
            MethodArgumentNotValidException exception) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("erro", "Erro de validação");
        List<String> mensagens = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .toList();
        resposta.put("mensagens", mensagens);
        return ResponseEntity.badRequest().body(resposta);
    }


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> tratarErroDeRecurso(
            ResponseStatusException exception) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", exception.getStatusCode().value());
        resposta.put("erro", "Recurso não encontrado");
        resposta.put("mensagem", exception.getReason());
        return ResponseEntity
                .status(exception.getStatusCode())
                .body(resposta);
    }


}
