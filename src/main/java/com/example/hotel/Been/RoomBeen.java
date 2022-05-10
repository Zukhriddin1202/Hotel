package com.example.hotel.Been;

import com.example.hotel.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomBeen extends JpaRepository<Room, Integer> {
    boolean existsByXonaRaqamiAndQavatAndAndHotelId(String s, int s1,Integer id);
    List<Room> findAllByHotelId(Integer id);
}
