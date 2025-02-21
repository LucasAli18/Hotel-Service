package com.hotel.services.infrastructure.controllers.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.services.application.services.HotelService;
import com.hotel.services.domain.request.HotelCreateRequest;
import com.hotel.services.infrastructure.controllers.HotelApi;
import com.hotel.services.infrastructure.entities.HotelEntity;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelApi{

	private final HotelService hotelService;
	
	
	@Override
	public Mono<ResponseEntity<Long>> createHotel(@Valid HotelCreateRequest request) {
		return hotelService.createHotel(request)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}

	@Override
	public Mono<ResponseEntity<List<HotelEntity>>> getHotels() {
		return hotelService.getHoteles()
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

}
