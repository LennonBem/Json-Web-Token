package com.example.springsecurity.controller;

import com.example.springsecurity.model.request.CoachRequest;
import com.example.springsecurity.model.request.PeopleRequest;
import com.example.springsecurity.model.response.CoachResponse;
import com.example.springsecurity.model.response.PeopleResponse;
import com.example.springsecurity.service.CoachService;
import com.example.springsecurity.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;


    @GetMapping()
    public ResponseEntity<List<PeopleResponse>> findAll(){
        return ResponseEntity.ok(peopleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByID(@PathVariable(name = "id") UUID id){
        Optional response = peopleService.findByID(id);

        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe Pessoa para o ID informado");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(response.get());
        }

    }

    @PostMapping
    public ResponseEntity<Object> createPeople(@RequestBody PeopleRequest peopleRequest){
        try{
            return ResponseEntity.ok(peopleService.createPeople(peopleRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
