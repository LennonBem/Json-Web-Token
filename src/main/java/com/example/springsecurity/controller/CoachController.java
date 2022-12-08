package com.example.springsecurity.controller;

import com.example.springsecurity.model.request.CoachRequest;
import com.example.springsecurity.model.response.CoachResponse;
import com.example.springsecurity.service.CoachService;

import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;


    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping()
    public ResponseEntity<List<CoachResponse>> findAll(){
        return ResponseEntity.ok(coachService.findAll());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findByID(@PathVariable(name = "id") UUID id){
      Optional response = coachService.findByID(id);

      if(response.isEmpty()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe Coach para o ID informado");
      }else {
          return ResponseEntity.status(HttpStatus.OK).body(response.get());
      }

    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<Object> createCoach(@RequestBody  CoachRequest coachRequest){
        try{
           return ResponseEntity.ok(coachService.createCoach(coachRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public Object deleteCoach(@PathVariable(name = "id")UUID  id){
        try{
            Optional isDeleted =  coachService.deleteCoach(id);

            if(isDeleted.isPresent()){
               return ResponseEntity.ok(isDeleted.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coach não existe!");
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PatchMapping
    public ResponseEntity<Object> updateCoach(@RequestBody  CoachRequest coachRequest){
        try{
            return ResponseEntity.ok(coachService.updateCoach(coachRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
 }
