package com.example.hotelapp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "RoomAvailability")
@Data
public class RoomAvailability {
	
	@Id
	Long id;
	
	String RoomNames;
	BigDecimal roomCount;

	
}
