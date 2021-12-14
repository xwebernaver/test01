package com.kc.sba.service;

import com.kc.sba.dto.CreateDeveloper;
import com.kc.sba.entity.Developer;
import com.kc.sba.respository.DeveloperRepository;
import com.kc.sba.type.DeveloperLevel;
import com.kc.sba.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SbaService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

    @Transactional
    public void createDeveloper(CreateDeveloper.Request request){
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);

        /* ~
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();

            developerRepository.save(developer);

            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            throw e;
        }
        */
    }

}
