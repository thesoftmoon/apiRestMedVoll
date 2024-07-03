package med.voll.api.doctor;

import med.voll.api.adress.Adress;
import med.voll.api.adress.AdressDTO;

public record DoctorResponseDTO(Long id,
                                String nombre,
                                String email,
                                String telefono,
                                String documento,
                                AdressDTO direccion) {
}
