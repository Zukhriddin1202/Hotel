package com.example.hotel.Been;

import com.example.hotel.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelBeen extends JpaRepository<Hotel,Integer> {
    boolean existsByNomi(String s);

}
