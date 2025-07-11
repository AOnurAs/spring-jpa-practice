package com.AOA.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		System.out.println(ex.toString());
		Map<String, List<String>> errorsMap = new HashMap<>();
		
		for (ObjectError err : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) err).getField();
			if(errorsMap.containsKey(fieldName)) {
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), err.getDefaultMessage()));
			}else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), err.getDefaultMessage()));
			}
		}
		
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
	}
	
	private <T> ApiError <T> createApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		
		return apiError;
	}
}
