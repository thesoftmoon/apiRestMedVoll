package med.voll.api.domain.Patient;


import med.voll.api.domain.adress.Adress;

public record DatosDetallesPaciente(Long id, String nombre, String email, String documento, String telefono, Adress direccion) {

    public DatosDetallesPaciente(Patient patient) {
        this(patient.getId(), patient.getNombre(), patient.getEmail(), patient.getDocumento(), patient.getTelefono(), patient.getDireccion());
    }
}
