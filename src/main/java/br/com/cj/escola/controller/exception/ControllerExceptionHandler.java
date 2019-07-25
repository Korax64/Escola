package br.com.cj.escola.controller.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cj.escola.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorPadrao> handleObjectNotFoundException(ObjectNotFoundException obj, HttpServletRequest request){
		HttpStatus status=HttpStatus.NOT_FOUND;
		ErrorPadrao error=new ErrorPadrao(LocalDateTime.now(), status.value(), "Não encontrado", obj.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorPadrao> handleMethodArgumentNotValidException(MethodArgumentNotValidException obj, HttpServletRequest request){
		HttpStatus status=HttpStatus.BAD_REQUEST;
		ErrorPadrao error=new ErrorPadrao(LocalDateTime.now(), status.value(), "Erro na validação dos dados", obj.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorPadrao> handleDataIntegrityViolationException(DataIntegrityViolationException obj, HttpServletRequest request){
		HttpStatus status=HttpStatus.BAD_REQUEST;
		ErrorPadrao error=new ErrorPadrao(LocalDateTime.now(), status.value(), "Erro na validação dos dados, verifique os dados passados!", obj.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
