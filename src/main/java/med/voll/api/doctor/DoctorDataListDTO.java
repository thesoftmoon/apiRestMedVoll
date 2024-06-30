package med.voll.api.doctor;

public record DoctorDataListDTO(String nombre, String especialidad, String  documento, String email) {

    //Constructor paar enviar data restringida y no enviar toda la data de la entidad doctor
    public DoctorDataListDTO(Doctor doctor){
        this(doctor.getNombre(), doctor.getEspecialidad().toString(), doctor.getDocumento(),doctor.getEmail());
    }
}
