package com.hotel.services.domain.request;

import com.hotel.services.infrastructure.entities.HotelEntity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HotelCreateRequest {
	@NotNull
	private String hotelName;
}
