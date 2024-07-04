package med.voll.api.domain.doctor;

import med.voll.api.domain.adress.AdressDTO;

public record DoctorResponseDTO(Long id,
                                String nombre,
                                String email,
                                String telefono,
                                String documento,
                                AdressDTO direccion) {
}
