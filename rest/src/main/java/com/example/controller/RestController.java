package com.example.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.RestDto;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/outbound")
public class RestController {

	@GetMapping("/")
	public RestDto get(@RequestBody RestDto dto) {
		dto.setName("GET");
		return getDto(dto);
	}

	@GetMapping("/{address}")
	public RestDto getWithPath(@RequestBody RestDto dto, @PathVariable("address") String address,
	        @RequestParam HashMap<String, String> paramMap) {
		dto.setName("GET_PATH");
		doDto(dto, address, paramMap.get("phone"), paramMap.get("gender"));
		return getDto(dto);
	}

	@PostMapping("/")
	public RestDto post(@RequestBody RestDto dto) {
		dto.setName("POST");
		return getDto(dto);
	}

	@PostMapping("/{address}")
	public RestDto postWithPath(@RequestBody RestDto dto, @PathVariable("address") String address,
	        @RequestParam HashMap<String, String> paramMap) {
		dto.setName("POST_PATH");
		doDto(dto, address, paramMap.get("phone"), paramMap.get("gender"));
		return getDto(dto);
	}

	@PutMapping("/")
	public RestDto put(@RequestBody RestDto dto) {
		dto.setName("PUT");
		return getDto(dto);
	}

	@PutMapping("/{address}")
	public RestDto putWithPath(@RequestBody RestDto dto, @PathVariable("address") String address,
	        @RequestParam("phone") String phone, @RequestParam("gender") String gender) {
		dto.setName("PUT_PATH");
		doDto(dto, address, phone, gender);
		return getDto(dto);
	}

	@DeleteMapping("/")
	public RestDto delete(RestDto dto) {
		dto.setName("DELETE");
		return getDto(dto);
	}

	@DeleteMapping("/{address}")
	public RestDto deleteWithPath(RestDto dto, @PathVariable("address") String address,
	        @RequestParam("phone") String phone, @RequestParam("gender") String gender) {
		dto.setName("DELETE_PATH");
		doDto(dto, address, phone, gender);
		return getDto(dto);
	}

	private RestDto getDto(RestDto dto) {
		dto.setAddress(dto.getAddress() + "@");
		dto.setPhone(dto.getPhone() + "@");
		dto.setGender(dto.getGender() + "@");
		return dto;
	}

	private void doDto(RestDto dto, String address, String phone, String gender) {
		dto.setAddress(address);
		dto.setPhone(phone == null ? dto.getPhone() : phone);
		dto.setGender(gender == null ? dto.getGender() : gender);
	}
}
