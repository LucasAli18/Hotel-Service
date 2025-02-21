package com.hotel.services.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.services.domain.request.HotelCreateRequest;
import com.hotel.services.infrastructure.entities.HotelEntity;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RequestMapping("/api/hotel")
public interface HotelApi {

	@PostMapping
	Mono<ResponseEntity<Long>> createHotel(@RequestBody @Valid HotelCreateRequest request);//respondemos con 1 y 0 como respuesta de Si y No
	
	@GetMapping
	Mono<ResponseEntity<List<HotelEntity>>> getHotels();
}
