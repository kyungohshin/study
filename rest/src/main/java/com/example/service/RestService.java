package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.RestDto;

@Service
public class RestService {
	public RestDto getService(RestDto dto) {
		dto.setName("GET");
		return dto;
	}

	public RestDto getWithPathService(RestDto dto, String path, String phone, String gender) {
		dto.setName("GET_PATH");
		dto.setAddress(path + "@");
		dto.setPhone(phone + "@");
		dto.setGender(gender + "@");
		return dto;
	}

	public RestDto postService(RestDto dto) {
		dto.setName("POST");
		return dto;
	}

	public RestDto postWithPathService(RestDto dto, String path, String phone, String gender) {
		dto.setName("POST_PATH");
		dto.setAddress(path + "@");
		dto.setPhone(phone + "@");
		dto.setGender(gender + "@");
		return dto;
	}

	public RestDto putService(RestDto dto) {
		dto.setName("PUT");
		return dto;
	}

	public RestDto putWithPathService(RestDto dto, String path, String phone, String gender) {
		dto.setName("PUT_PATH");
		dto.setAddress(path + "@");
		dto.setPhone(phone + "@");
		dto.setGender(gender + "@");
		return dto;
	}

	public RestDto deleteService(RestDto dto) {
		dto.setName("DELETE");
		return dto;
	}

	public RestDto deleteWithPathService(RestDto dto, String path, String phone, String gender) {
		dto.setName("DELETE_PATH");
		dto.setAddress(path + "@");
		dto.setPhone(phone + "@");
		dto.setGender(gender + "@");
		return dto;
	}
}
