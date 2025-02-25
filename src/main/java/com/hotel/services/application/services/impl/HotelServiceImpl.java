package com.hotel.services.application.services.impl;

import java.util.List;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.hotel.services.application.services.HotelService;
import com.hotel.services.domain.request.HotelCreateRequest;
import com.hotel.services.infrastructure.entities.HotelEntity;
import com.hotel.services.infrastructure.repositories.HotelRedisRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{
	
    private final StreamBridge streamBridge;
    private final HotelRedisRepository hotelRedisRepository;
    
	@Override
	public Mono<Long> createHotel(HotelCreateRequest request) {
		return Mono.just(request)
				.map(this::mapToEntity)
				.flatMap(this::publishHotel);
	}

	@Override
	public Mono<List<HotelEntity>> getHoteles() {
		return hotelRedisRepository.findAll()
				.collectList();
	}

	private HotelEntity mapToEntity(HotelCreateRequest request) {
		return HotelEntity.builder()
				.hotelName(request.getHotelName())
				.build();
	}
	
	public Mono<Long> publishHotel(HotelEntity hotelEntity){
		return Mono.just(hotelEntity)
				.doOnNext(hotel -> streamBridge.send("writeCache-out-0", hotel))
				.flatMap(hotel -> Mono.just(1L))
				.switchIfEmpty(Mono.just(0L));
	}
	
}
