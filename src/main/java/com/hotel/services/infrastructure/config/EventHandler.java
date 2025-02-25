package com.hotel.services.infrastructure.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.services.application.processors.WriteCacheProcessor;
import com.hotel.services.infrastructure.entities.HotelEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class EventHandler {

	@Bean
	public Function<Flux<HotelEntity>, Mono<Void>> redisCacheBinding(final WriteCacheProcessor writeCacheProcessor){
		return writeCacheProcessor;
	}
}
