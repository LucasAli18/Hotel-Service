package com.hotel.services.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import com.hotel.services.infrastructure.entities.HotelEntity;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class HotelRedisRepository{

	private final ReactiveRedisOperations<String, HotelEntity> reactiveRedisOperations;
	
	public Flux<HotelEntity> findAll(){
		return reactiveRedisOperations.opsForList()
				.range("hotel", 0, -1);
	}
	
	public Mono<Long> save(HotelEntity hotelEntity){
		hotelEntity.setId(UUID.randomUUID().toString());
		return reactiveRedisOperations.opsForList()
				.rightPush("hotel", hotelEntity);
	}
	
}
