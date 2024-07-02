package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    /*No es recomendable Autowired en producccion, por que los testers tiran error*/
    @Autowired
    private DoctorRepository doctorRepository;
    /*@Valid habilita la validacion en los DTO anotados*/
    @PostMapping
    public void doctorRegister(@RequestBody @Valid DoctorDTO doctorDTO){
        System.out.println("El request llega correctamente");
        System.out.println(doctorDTO);
        doctorRepository.save(new Doctor(doctorDTO));
    }

    /*Con Page y invocand Pageable, puedes agrupar la llamada en paginas, usando queries de url como /doctors?size=2mlo que acorta los datos a dos entradas en este caso*/

    /*Con pageabledefault y size podemos modificar las entradas que se muestran por default*/
    @GetMapping
    public Page<DoctorDataListDTO> doctorList(@PageableDefault(size = 5) Pageable paginacion){
        return doctorRepository.findByActiveTrue(paginacion).map(DoctorDataListDTO::new);
    }

    /*Sin el Transactional los datos no se actualizan, esto abre una transaccion en la base de datos y deja actualizar, esto es JPA puro, no se usa el repository.dave() para guardar la data*/
    @PutMapping
    @Transactional
    public void doctorUpdate(@RequestBody @Valid DoctorDataUpdateDTO doctorDataUpdateDTO){
        Doctor doctor = doctorRepository.getReferenceById(doctorDataUpdateDTO.id());
        doctor.updateData(doctorDataUpdateDTO);
    }

    //Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.deactivateDoctor();
    }

    //Este es el delete en base de datos
   /* public void deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctorRepository.delete(doctor);
    }*/

}
