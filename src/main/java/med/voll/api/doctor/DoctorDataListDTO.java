package med.voll.api.doctor;

public record DoctorDataListDTO(String nombre, String especialidad, String  documento, String email) {
    public DoctorDataListDTO(Doctor doctor){
        this(doctor.getNombre(), doctor.getEspecialidad().toString(), doctor.getDocumento(),doctor.getEmail());
    }
}
