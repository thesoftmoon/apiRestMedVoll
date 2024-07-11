package med.voll.api.domain.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByActivoTrue(Pageable paginacion);

    @Query("""
            select p.activo
            from Patient p
            where p.id=:idPatient 
            """)
    Boolean findActivoById(Long idPatient);
}
