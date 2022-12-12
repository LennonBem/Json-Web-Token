package com.example.springsecurity.service;

import com.example.springsecurity.model.entity.CoachEntity;
import com.example.springsecurity.model.entity.PeopleEntity;
import com.example.springsecurity.model.request.CoachRequest;
import com.example.springsecurity.model.request.PeopleRequest;
import com.example.springsecurity.model.response.CoachResponse;
import com.example.springsecurity.model.response.PeopleResponse;
import com.example.springsecurity.repository.CoachRepository;
import com.example.springsecurity.repository.PeopleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;



    public List<PeopleResponse> findAll(){
        List<PeopleEntity>  peopleEntityList = peopleRepository.findAll();
        List<PeopleResponse> peopleResponseList = new ArrayList<>();



        for(PeopleEntity people : peopleEntityList )
        {
            ModelMapper modelMapper = new ModelMapper();
            PeopleResponse peopleResponse = modelMapper.map(people, PeopleResponse.class);
            peopleResponseList.add(peopleResponse);
        };

        return peopleResponseList;

    }

    public Optional findByID(UUID id) {
        Optional<PeopleEntity> peopleEntity = peopleRepository.findById(id);
        if(peopleEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            PeopleResponse peopleResponse = modelMapper.map(peopleEntity.get(), PeopleResponse.class);
            return Optional.of(peopleResponse);
        }else{
            return Optional.empty();
        }

    }
    public PeopleResponse createPeople(PeopleRequest peopleRequest) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        PeopleEntity peopleEntity = modelMapper.map(peopleRequest, PeopleEntity.class);
        PeopleEntity response = peopleRepository.save(peopleEntity);
        return modelMapper.map(response, PeopleResponse.class);

    }
}
