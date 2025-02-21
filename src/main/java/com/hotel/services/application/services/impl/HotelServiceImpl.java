package com.hotel.services.application.services.impl;

import java.util.List;

import com.hotel.services.application.services.HotelService;
import com.hotel.services.domain.request.HotelCreateRequest;
import com.hotel.services.infrastructure.entities.HotelEntity;

import reactor.core.publisher.Mono;

public class HotelServiceImpl implements HotelService{

	@Override
	public Mono<Long> createHotel(HotelCreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<List<HotelEntity>> getHoteles() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
