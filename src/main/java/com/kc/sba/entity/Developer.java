package com.kc.sba.entity;


import com.kc.sba.type.DeveloperLevel;
import com.kc.sba.type.DeveloperSkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    private Integer experienceYears;
    private  String memberId;
    private String name;
    private Integer age;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    public static DeveloperBuilder builder() {
        return new DeveloperBuilder();
    }

    public static class DeveloperBuilder {
        private Long id;
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private String memberId;
        private String name;
        private Integer age;
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;

        DeveloperBuilder() {
        }

        public DeveloperBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DeveloperBuilder developerLevel(DeveloperLevel developerLevel) {
            this.developerLevel = developerLevel;
            return this;
        }

        public DeveloperBuilder developerSkillType(DeveloperSkillType developerSkillType) {
            this.developerSkillType = developerSkillType;
            return this;
        }

        public DeveloperBuilder experienceYears(Integer experienceYears) {
            this.experienceYears = experienceYears;
            return this;
        }

        public DeveloperBuilder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public DeveloperBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DeveloperBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public DeveloperBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DeveloperBuilder updateAt(LocalDateTime updateAt) {
            this.updateAt = updateAt;
            return this;
        }

        public Developer build() {
            return new Developer(id, developerLevel, developerSkillType, experienceYears, memberId, name, age, createdAt, updateAt);
        }

        public String toString() {
            return "Developer.DeveloperBuilder(id=" + this.id + ", developerLevel=" + this.developerLevel + ", developerSkillType=" + this.developerSkillType + ", experienceYears=" + this.experienceYears + ", memberId=" + this.memberId + ", name=" + this.name + ", age=" + this.age + ", createdAt=" + this.createdAt + ", updateAt=" + this.updateAt + ")";
        }
    }
}
