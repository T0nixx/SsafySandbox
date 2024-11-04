package com.ssafy.sandbox.exception.dto;

public class ModelNotFoundException extends RuntimeException {
	public ModelNotFoundException(String modelName, Long id) {
		super("Model " + modelName + " not found with given id " + id);
	}
}