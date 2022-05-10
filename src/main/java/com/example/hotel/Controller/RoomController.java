package com.example.hotel.Controller;

import com.example.hotel.Been.HotelBeen;
import com.example.hotel.Been.RoomBeen;
import com.example.hotel.Dto.HotelRoom;
import com.example.hotel.Model.Hotel;
import com.example.hotel.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    HotelBeen hotelBeen;

    @Autowired
    RoomBeen roomBeen;

    @PostMapping("/insert")
    public String insert(@RequestBody HotelRoom dto){
        if(!roomBeen.existsByXonaRaqamiAndQavatAndAndHotelId(dto.getXonaRaqami(), dto.getQavat(), dto.getHotelId())){
            Optional<Hotel> optional=hotelBeen.findById(dto.getHotelId());
            if(!optional.isPresent())
                return "Bunday mexmonxona mavjud emas";
            Room room=new Room();
            room.setQavat(dto.getQavat());
            room.setXonalarSoni(dto.getXonalarSoni());
            room.setXonaRaqami(dto.getXonaRaqami());
            room.setHotel(optional.get());
            roomBeen.save(room);
            return "Saqlanadi";
        }
        return "Bunday xona mavjud";
    }

    @GetMapping(value = "/{id}")
    public List<Room> select(@PathVariable Integer id){
        Optional<Hotel> optional=hotelBeen.findById(id);
        if(optional.isPresent()){
            List<Room> rooms=roomBeen.findAllByHotelId(id);
            return rooms;
        }
        return null;
    }


    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody HotelRoom dto){
        Optional<Room> optional1=roomBeen.findById(id);
        if (!optional1.isPresent())
            return "Bunday xona yo'q";
        if(!roomBeen.existsByXonaRaqamiAndQavatAndAndHotelId(dto.getXonaRaqami(), dto.getQavat(), dto.getHotelId())){
            Optional<Hotel> optional=hotelBeen.findById(dto.getHotelId());
            if(!optional.isPresent())
                return "Bunday mexmonxona mavjud emas";
            Room room=optional1.get();
            room.setQavat(dto.getQavat());
            room.setXonalarSoni(dto.getXonalarSoni());
            room.setXonaRaqami(dto.getXonaRaqami());
            room.setHotel(optional.get());
            roomBeen.save(room);
            return "Yangilandi";
        }
        return "Bunday xona mavjud";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Room> optional=roomBeen.findById(id);
        if(optional.isPresent())
        {
            roomBeen.deleteById(id);
            return "O'chirildi";
        }
        return "Bunday xona yo'q";
    }



}
