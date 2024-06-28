package med.voll.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

/*para implementar el repo necesitamos el tipo de objeto seguido del tipo de Id, en este caso Long*/
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
