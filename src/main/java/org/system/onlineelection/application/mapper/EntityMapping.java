package org.system.onlineelection.application.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.system.onlineelection.domain.model.*;
import org.system.onlineelection.infrastructure.adapter.entity.*;

public class EntityMapping {

    private ModelMapper modelMapper;

    @Autowired
    public Candidate candidateMapping(CandidateEntity candidateEntity)
    {
        return modelMapper.map(candidateEntity, Candidate.class);
    }

    public Admin adminMapping (AdminEntity adminEntity){
        return modelMapper.map(adminEntity, Admin.class);
    }

    public Elector electorMapping (ElectorEntity electorEntity){
        return modelMapper.map(electorEntity, Elector.class);
    }
    public Person personMapping (PersonEntity personEntity){
        return modelMapper.map(personEntity, Person.class);

    }
    public PoliticalParty politicalPartyMapping  (PoliticalPartyEntityDto politicalPartyEntity) {
        return modelMapper.map(politicalPartyEntity, PoliticalParty.class);
    }

    public Vote voteMapping (VoteEntity voteEntity){
        return modelMapper.map(voteEntity, Vote.class);
    }
}
