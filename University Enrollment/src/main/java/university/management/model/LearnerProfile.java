package university.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "LearnerProfiles")
public class LearnerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "number_of_credits")
    private int numberOfCredits;

    @Column(name = "gpa")
    private float gpa;// grade point average

    @Column(name = "is_graduated")
    private boolean isGraduated;

    @Column(name = "start_year")
    private short startYear;

    @OneToOne(mappedBy = "learnerProfile")
    private Student student;


    public LearnerProfile() {
    }

    public LearnerProfile(short startYear) {
        this.startYear = startYear;
    }


    public Long getProfileId() {
        return profileId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public float getGpa() {
        return gpa;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public short getStartYear() {
        return startYear;
    }

    public Student getStudent() {
        return student;
    }
}
