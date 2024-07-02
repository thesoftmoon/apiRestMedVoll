package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.adress.AdressDTO;

public record DoctorDataUpdateDTO(
        @NotNull
        Long id,
        String nombre,
        String documento,
        AdressDTO adress) {
}
