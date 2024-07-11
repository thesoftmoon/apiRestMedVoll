package med.voll.api.domain.Patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.adress.AdressDTO;

public record DatosActualizacionPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        AdressDTO direccion) {
}
