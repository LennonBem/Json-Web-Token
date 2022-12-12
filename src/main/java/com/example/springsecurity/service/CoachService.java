package com.example.springsecurity.service;

import com.example.springsecurity.config.ModelMapper.Mapper;
import com.example.springsecurity.model.entity.CoachEntity;
import com.example.springsecurity.model.entity.PeopleEntity;
import com.example.springsecurity.model.request.CoachRequest;
import com.example.springsecurity.model.response.CoachResponse;
import com.example.springsecurity.repository.CoachRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.schema.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachService {
    @Autowired
  private  CoachRepository coachRepository;

    @Autowired
    Mapper mapper;



    public List<CoachResponse> findAll(){
       List<CoachEntity>  coachEntityList = coachRepository.findAll();
        List<CoachResponse> coachResponseList = new ArrayList<>();



        for(CoachEntity coach : coachEntityList )
        {
            ModelMapper modelMapper = new ModelMapper();
           CoachResponse coachResponse = modelMapper.map(coach, CoachResponse.class);
           coachResponseList.add(coachResponse);
        };

        return coachResponseList;

    }

    public Optional findByID(UUID id) {
        Optional<CoachEntity> coachEntity = coachRepository.findById(id);
       if(coachEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            CoachResponse coachResponse = modelMapper.map(coachEntity.get(), CoachResponse.class);
            return Optional.of(coachResponse);
        }else{
           return Optional.empty();
       }


    }

    public CoachResponse createCoach(CoachRequest coachRequest) throws Exception {

            ModelMapper modelMapper = new ModelMapper();
            CoachEntity coachEntity = modelMapper.map(coachRequest, CoachEntity.class);
            CoachEntity response = coachRepository.save(coachEntity);
           return modelMapper.map(response, CoachResponse.class);

    }

    public Optional<Object> deleteCoach(UUID id) throws Exception{
        if(findByID(id).isEmpty()){
            return Optional.empty();
        }else{
            coachRepository.deleteById(id);
            return Optional.of("Coach Removido com sucesso");
        }
    }

    public Object updateCoach(CoachRequest coachRequest) throws Exception {

        CoachEntity res = verifExistCoachWithPeopleID(coachRequest.getPeopleID()).orElseThrow(
                () -> new Exception("PeopleId informado nâo é válido!"));


          CoachEntity coachEntity = mapper.modelMapper().map(coachRequest, CoachEntity.class);

          coachEntity.setId(res.getId());
           CoachEntity response = coachRepository.save(coachEntity);
           return mapper.modelMapper().map(response, CoachResponse.class);


    }

    public Optional<CoachEntity> verifExistCoachWithPeopleID(UUID id){
        Optional<CoachEntity> findCoachByPeopleID = coachRepository.findByPeopleId(id);
        return findCoachByPeopleID;
    }

}
