package med.voll.api.controller;


import med.voll.api.domain.users.AuthUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    /*Importas como si fuera un servicio*/
    @Autowired
    private AuthenticationManager authenticationManager;

    /*En esta entidad necesitas del DTO de authUser el login y clase que seria usuario y clave*/
    @PostMapping
    public ResponseEntity authUser(AuthUserDTO authUserDTO){
        /*Traes el objeto Authentication y le pasas los datos del DTO*/
        Authentication token = new UsernamePasswordAuthenticationToken(authUserDTO.login(), authUserDTO.pass());
        /*Le pasas el token generado arriba*/
        authenticationManager.authenticate(token);
        /*Retornas el ResponseEntity solo para fines didacticos*/
        return ResponseEntity.ok().build();
    }
}
