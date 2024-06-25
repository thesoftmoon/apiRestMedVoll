package med.voll.api.doctor;

import med.voll.api.AdressData;

public record DoctorRegisterData(String nombre, String email, String documento, Especialidad especialidad, AdressData direccion) {
}
