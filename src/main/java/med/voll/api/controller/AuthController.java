package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.users.AuthUserDTO;
import med.voll.api.domain.users.User;
import med.voll.api.infra.security.JWTtokenDataDTO;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    /*Importas como si fuera un servicio*/
    @Autowired
    private AuthenticationManager authenticationManager;

    /*LLamamos el token de tokenService de la libreria auth0*/
    @Autowired
    private TokenService tokenService;

    /*En esta entidad necesitas del DTO de authUser el login y clase que seria usuario y clave*/
    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid AuthUserDTO authUserDTO){
        /*Traes el objeto Authentication y le pasas los datos del DTO*/
        Authentication authToken = new UsernamePasswordAuthenticationToken(authUserDTO.login(), authUserDTO.pass());
        /*Le pasas el token generado arriba*/
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.tokenGenerator((User) authenticatedUser.getPrincipal());
        /*Retornas el ResponseEntity solo para fines didacticos*/
        return ResponseEntity.ok(new JWTtokenDataDTO(JWTtoken));
    }
}
