package med.voll.api.domain.doctor;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.adress.AdressDTO;

/*Las anotaciones @NotBlank valida si es un campo vacio o nulo, @NotNull valida solo si es nulo, esto va activado en el controller, con la anotacion @Valid*/

public record DoctorDTO(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotNull
        Especialidad especialidad,
        /*Como es un objeto, debe ir not null y not blank por que si no esta siempre llegara null*/
        @NotNull
        /*Esta anotacion habilita la validacion*/
        @Valid
        AdressDTO direccion) {
}
