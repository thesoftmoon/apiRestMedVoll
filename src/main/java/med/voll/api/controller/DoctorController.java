package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.adress.AdressDTO;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    /*No es recomendable Autowired en producccion, por que los testers tiran error*/
    @Autowired
    private DoctorRepository doctorRepository;
    /*@Valid habilita la validacion en los DTO anotados, con UriComponentBuilder puedes crear la url dinamica*/
    @PostMapping
    public ResponseEntity<DoctorResponseDTO> doctorRegister(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriComponentBuilder){
        System.out.println("El request llega correctamente");
        System.out.println(doctorDTO);
        Doctor doctor = doctorRepository.save(new Doctor(doctorDTO));
        //debe ser codigo 201
        //Debes retornar la url donde puedes pillar este doctor
        DoctorResponseDTO doctorResponseDto = new DoctorResponseDTO(doctor.getId(), doctor.getNombre(), doctor.getEmail(), doctor.getTelefono(), doctor.getDocumento(), new AdressDTO(doctor.getDireccion().getCalle(), doctor.getDireccion().getDistrito(), doctor.getDireccion().getCiudad(), doctor.getDireccion().getNumero(), doctor.getDireccion().getComplemento()));

        /*Crea la url dinamica*/
        URI url = uriComponentBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        /*Retorna la url del doctor creado*/
        return ResponseEntity.created(url).body(doctorResponseDto);
    }

    /*Con Page y invocand Pageable, puedes agrupar la llamada en paginas, usando queries de url como /doctors?size=2mlo que acorta los datos a dos entradas en este caso*/

    /*Con pageabledefault y size podemos modificar las entradas que se muestran por default*/
    @GetMapping
    public ResponseEntity<Page<DoctorDataListDTO>>  doctorList(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(doctorRepository.findByActiveTrue(paginacion).map(DoctorDataListDTO::new));
    }

    /*Sin el Transactional los datos no se actualizan, esto abre una transaccion en la base de datos y deja actualizar, esto es JPA puro, no se usa el repository.dave() para guardar la data*/
    @PutMapping
    @Transactional
    public ResponseEntity doctorUpdate(@RequestBody @Valid DoctorDataUpdateDTO doctorDataUpdateDTO){
        Doctor doctor = doctorRepository.getReferenceById(doctorDataUpdateDTO.id());
        doctor.updateData(doctorDataUpdateDTO);
        return ResponseEntity.ok(new DoctorResponseDTO(doctor.getId(), doctor.getNombre(), doctor.getEmail(), doctor.getTelefono(), doctor.getDocumento(), new AdressDTO(doctor.getDireccion().getCalle(), doctor.getDireccion().getDistrito(), doctor.getDireccion().getCiudad(), doctor.getDireccion().getNumero(), doctor.getDireccion().getComplemento())));
    }

    //Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.deactivateDoctor();
        return ResponseEntity.noContent().build();
    }

    //Este es el delete en base de datos
   /* public void deleteDoctor(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctorRepository.delete(doctor);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorData(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);

        var doctorData = new DoctorResponseDTO(doctor.getId(), doctor.getNombre(), doctor.getEmail(), doctor.getTelefono(), doctor.getDocumento(), new AdressDTO(doctor.getDireccion().getCalle(), doctor.getDireccion().getDistrito(), doctor.getDireccion().getCiudad(), doctor.getDireccion().getNumero(), doctor.getDireccion().getComplemento()));
        return ResponseEntity.ok(doctorData);
    }

}
