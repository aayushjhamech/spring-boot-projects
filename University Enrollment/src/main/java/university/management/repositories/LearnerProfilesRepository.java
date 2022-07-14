package university.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import university.management.model.LearnerProfile;

@Repository
public interface LearnerProfilesRepository extends JpaRepository<LearnerProfile, Long>{
    List<LearnerProfile> findAllByIsGraduatedIsFalseOrderByGpaDesc();
}
