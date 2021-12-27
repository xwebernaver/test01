package com.kc.sba.dto;

import com.kc.sba.entity.Developer;
import com.kc.sba.type.DeveloperLevel;
import com.kc.sba.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditDeveloper {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request{
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        //@Max(200)
        private Integer experienceYears;


    }

}
