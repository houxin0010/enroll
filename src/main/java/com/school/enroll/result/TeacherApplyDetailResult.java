package com.school.enroll.result;

import com.school.enroll.entity.EducationExperience;
import com.school.enroll.entity.JobExperience;
import com.school.enroll.entity.TrainingExperience;
import com.school.enroll.entity.WorkExperience;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TeacherApplyDetailResult implements Serializable{
    private static final long serialVersionUID = 1852304919774224553L;
    private Long id;
    private String name;
    private String pictureUrl;
    private Long sex;
    private Long idNo;
    private Date birthdate;
    private String nation;
    private Long politicsStatus;
    private String domicilePlace;
    private Long accountProperties;
    private String maritalStatus;
    private String email;
    private Long phoneNo;
    private Long education;
    private String profession;
    private Long englishLevel;
    private String teacherCertification;
    private String professionalTitle;
    private String applyPhaseStudying;
    private String applySubject;
    private String status;
    private String note;
    private Date createTime;
    private Date updateTime;
    private List<WorkExperience> workExperienceList;
    private List<JobExperience> jobExperienceList;
    private List<TrainingExperience> trainingExperienceList;
    private List<EducationExperience> educationExperienceList;


}
