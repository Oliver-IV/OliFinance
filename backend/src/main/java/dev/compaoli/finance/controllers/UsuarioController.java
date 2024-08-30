package dev.compaoli.finance.controllers;

import dev.compaoli.finance.dto.GastoDTO;
import dev.compaoli.finance.entitys.Usuario;
import dev.compaoli.finance.exceptions.ServiceException;
import dev.compaoli.finance.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service ;

    @GetMapping("/email")
    ResponseEntity<Usuario> obtenerUsuarioEmail(@RequestParam String email) {
        try{
            return new ResponseEntity<>(service.obtenerUsuarioPorEmail(email), HttpStatus.OK) ;
        } catch(ServiceException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PostMapping("/agregar")
    ResponseEntity<String> agregarUsuario(@RequestBody Usuario usuario) {
        try{
            service.agregarUsuario(usuario) ;
            return new ResponseEntity("El usuario ha sido agregado con exito!", HttpStatus.OK) ;
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @PostMapping("/gasto")
    ResponseEntity<String> agregarGasto(@RequestBody GastoDTO gasto) {
        try{
            service.agregarGastoUsuario("olipotro@gmail.com", gasto);
            return new ResponseEntity<>("Se ha agregado el gasto con exito", HttpStatus.OK) ;
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

}
