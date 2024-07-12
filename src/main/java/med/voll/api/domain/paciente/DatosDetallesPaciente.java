package med.voll.api.domain.paciente;


import med.voll.api.domain.adress.Adress;

public record DatosDetallesPaciente(Long id, String nombre, String email, String documento, String telefono, Adress direccion) {

    public DatosDetallesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefono(), paciente.getDireccion());
    }
}
