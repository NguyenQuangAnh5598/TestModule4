package com.example.test.controller.nationController;

import com.example.test.model.City;
import com.example.test.model.Nation;
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
@RequestMapping("/nation")
public class NationController {
    @Autowired
    INationService nationService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Nation>> list() {
        List<Nation> nationList = (List<Nation>) nationService.findAll();
        if (nationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nationList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Nation> addNewNation(@RequestBody Nation nation) {
        return new ResponseEntity<>(nationService.save(nation), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Nation> UpdateNation(@RequestBody Nation nation) {
        Optional<Nation> nationOptional = nationService.findByID(nation.getId());
        if (!nationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nationService.save(nation), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nation> deleteNation(@PathVariable Long id) {
        Optional<Nation> nationOptional = nationService.findByID(id);
        if (!nationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nationService.remove(id);
        return new ResponseEntity<>(nationOptional.get(),HttpStatus.OK);
    }
}
