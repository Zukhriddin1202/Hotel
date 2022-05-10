package com.example.hotel.Dto;

import com.example.hotel.Model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
public class HotelRoom
{
        private String xonaRaqami;
        private int qavat;
        private int xonalarSoni;
        private Integer hotelId;

}
