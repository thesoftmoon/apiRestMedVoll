package med.voll.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/*para implementar el repo necesitamos el tipo de objeto seguido del tipo de Id, en este caso Long*/
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    /*Aca buscamos por activo = true en la query de sql de JPA*/
    Page<Doctor> findByActiveTrue(Pageable paginacion);
}
