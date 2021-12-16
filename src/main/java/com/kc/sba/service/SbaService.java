package com.kc.sba.service;

import com.kc.sba.dto.CreateDeveloper;
import com.kc.sba.dto.DeveloperDetailDto;
import com.kc.sba.dto.DeveloperDto;
import com.kc.sba.entity.Developer;
import com.kc.sba.exception.SbaErrorCode;
import com.kc.sba.exception.SbaException;
import com.kc.sba.respository.DeveloperRepository;
import com.kc.sba.type.DeveloperLevel;
import com.kc.sba.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kc.sba.exception.SbaErrorCode.*;

@Service
@RequiredArgsConstructor
public class SbaService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request){

        validateCreateDeveloperRequest(request);

        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();

        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);


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

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validation

        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();

        if(developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            //throw new RuntimeException("SENIOR need 10 years experience.");
            throw new SbaException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNGNIOR
            && (experienceYears < 4 || experienceYears > 10)) {
            throw new SbaException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new SbaException(LEVEL_EXPERIENCE_YEAR_NOT_MATCHED);
        }

        //developerRepository.findByMemberId(request.getMemberId());

        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer ->{
                    throw new SbaException(DUPLICATED_MEMBER_ID);
                }));

        /**
        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
        if(developer.isPresent()) throw new SbaException(DUPLICATED_MEMBER_ID);
         */

    }


    public List<DeveloperDto> getAllDeveloper() {
        return developerRepository.findAll()
                .stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());
    }

    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .map(DeveloperDetailDto::fromEntity)
                .orElseThrow(() -> new SbaException(NO_DEVELOPER));
    }
}
