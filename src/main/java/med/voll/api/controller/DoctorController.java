package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDTO;
import med.voll.api.doctor.DoctorDataListDTO;
import med.voll.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<DoctorDataListDTO> doctorList(){
        return doctorRepository.findAll().stream().map(DoctorDataListDTO::new).toList();
    }

}
