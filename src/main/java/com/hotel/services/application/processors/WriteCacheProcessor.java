package com.hotel.services.application.processors;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.hotel.services.infrastructure.entities.HotelEntity;
import com.hotel.services.infrastructure.repositories.HotelRedisRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
@Slf4j
@RequiredArgsConstructor
public class WriteCacheProcessor implements Function<Flux<HotelEntity>, Mono<Void>>{

	private final HotelRedisRepository hotelRedisRepository;
	
	@Override
	public Mono<Void> apply(Flux<HotelEntity> hotelEntityFlux) {
		return hotelEntityFlux
				.doOnNext(hotelEntity -> log.info("Received hotel: {}",hotelEntity))
				.flatMap(hotelRedisRepository::save)
				.onErrorContinue(this::handleError)
				.then();
	}

	private void handleError(Throwable throwable, Object object) {
		log.error("Error ocurred white processing: {}", object, throwable);
	}
	
}
