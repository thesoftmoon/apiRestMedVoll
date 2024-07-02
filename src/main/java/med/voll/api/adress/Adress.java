package med.voll.api.adress;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    private String calle;
    private String distrito;
    private String ciudad;
    private int numero;
    private String complemento;

    public Adress(AdressDTO direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }

    public Adress updateData(AdressDTO adress) {
        this.calle = adress.calle();
        this.distrito = adress.distrito();
        this.ciudad = adress.ciudad();
        this.numero = adress.numero();
        this.complemento = adress.complemento();
        return this;
    }
}
