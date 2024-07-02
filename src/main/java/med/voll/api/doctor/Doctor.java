package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.adress.Adress;
import med.voll.api.adress.AdressDTO;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
/*Usa id para comparar entre doctors*/
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Adress direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Adress getDireccion() {
        return direccion;
    }

    public void setDireccion(Adress direccion) {
        this.direccion = direccion;
    }

    public Doctor(DoctorDTO doctorDTO) {
        this.nombre = doctorDTO.nombre();
        this.email = doctorDTO.email();
        this.telefono = doctorDTO.telefono();
        this.documento = doctorDTO.documento();
        this.active = true;
        this.especialidad = doctorDTO.especialidad();
        this.direccion = new Adress(doctorDTO.direccion());
    }

    public void updateData(DoctorDataUpdateDTO doctorDataUpdateDTO) {

        if (doctorDataUpdateDTO.nombre() != null) {
            this.nombre = doctorDataUpdateDTO.nombre();
        }
        if (doctorDataUpdateDTO.documento() != null) {
            this.documento = doctorDataUpdateDTO.documento();
        }
        if (doctorDataUpdateDTO.adress() != null) {
            this.direccion = direccion.updateData(doctorDataUpdateDTO.adress());
        }
    }

    public void deactivateDoctor() {
        this.active = false;
    }
}
