package com.example.hotel.Controller;

import com.example.hotel.Been.HotelBeen;
import com.example.hotel.Model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    @Autowired
    HotelBeen hotelBeen;

    @PostMapping("/insert")
    public String insert(@RequestBody Hotel hotel){
        if(!hotelBeen.existsByNomi(hotel.getNomi())){
            hotelBeen.save(hotel);
            return "Saqlanadi";
        }
        return "Bunday mehmonxona mavjud";
    }

    @GetMapping
    public List<Hotel> select(){
        List<Hotel> hotels=hotelBeen.findAll();
        return hotels;
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody Hotel hotel){
        Optional<Hotel> optional=hotelBeen.findById(id);
        if(optional.isPresent())
        {
            Hotel hotel1=optional.get();
            hotel1.setNomi(hotel.getNomi());
            hotelBeen.save(hotel1);
            return "O'zgartirildi";
        }
        return "Bunday mexmonxona yo'q";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Hotel> optional=hotelBeen.findById(id);
        if(optional.isPresent())
        {
            hotelBeen.deleteById(id);
            return "O'chirildi";
        }
        return "Bunday mexmonxona yo'q";
    }



}
