package com.hotel.services.application.services;

import java.util.List;

import com.hotel.services.domain.request.HotelCreateRequest;
import com.hotel.services.infrastructure.entities.HotelEntity;

import reactor.core.publisher.Mono;

public interface HotelService {

	Mono<Long> createHotel(HotelCreateRequest request);
	
	Mono<List<HotelEntity>> getHoteles();	
}
