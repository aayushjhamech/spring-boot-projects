package university.management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import university.management.model.Student;


@Repository
public interface StudentsRepository extends JpaRepository<Student, Long>{

    Optional<Student> findByEmail(String email);
}
