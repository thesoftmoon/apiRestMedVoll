package med.voll.api.controller;


import med.voll.api.doctor.DoctorRegisterData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void doctorRegister(@RequestBody DoctorRegisterData doctorRegisterData){
        System.out.println("El request llega correctamente");
        System.out.println(doctorRegisterData);
    }

}
