package com.example.test.controller.cityController;

import com.example.test.model.City;
import com.example.test.model.Nation;
import com.example.test.service.cityService.ICityService;
import com.example.test.service.nationService.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    ICityService cityService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> list() {
        List<City> cityList = (List<City>) cityService.findAll();
        if (cityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> addNewCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<City> UpdateCity(@RequestBody City city) {
        Optional<City> cityOptional = cityService.findByID(city.getId());
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findByID(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);
    }
    @GetMapping("/findOne/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findByID(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);
    }
}
