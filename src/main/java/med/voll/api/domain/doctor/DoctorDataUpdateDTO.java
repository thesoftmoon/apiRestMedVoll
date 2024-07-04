package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.adress.AdressDTO;

public record DoctorDataUpdateDTO(
        @NotNull
        Long id,
        String nombre,
        String documento,
        AdressDTO adress) {
}
