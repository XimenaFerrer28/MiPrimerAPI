package humbe.canciones.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import humbe.canciones.model.entity.Usuario;
import humbe.canciones.server.IUsuario;
import humbe.canciones.server.impl.EmailService;

@RestController
@RequestMapping("/api/v1")
public class usuarioController {
	@Autowired
	private IUsuario usuarioService;
	
	@Autowired
	private EmailService emailServi; 
	private static final Logger logger = LoggerFactory.getLogger(usuarioController.class);

	@PostMapping("usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		Usuario saveUsuario = usuarioService.save(usuario);
		emailServi.enviarCorreoAutenticacion(saveUsuario.getEmail(), saveUsuario.getToken());
		return saveUsuario;
	}
	
	@DeleteMapping("usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Usuario usuarioDelete = usuarioService.findById(id);
		if (usuarioDelete != null) {
			usuarioService.delete(usuarioDelete);
			
			String destinatario = usuarioDelete.getEmail();
			String cancionEliminada = usuarioDelete.getNombre(); // O cualquier otro campo que identifique la canción
			emailServi.enviarCorreoCacnionEliminado(destinatario,cancionEliminada);
		}else {
			logger.warn("Intento de eliminar un producto con ID no válido: " + id);
		}
	}
	
	@PostMapping("usuario/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario loginRequest) {
        Usuario usuario = usuarioService.finByEmailPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (usuario != null && usuario.getConfirmado() != null && usuario.getConfirmado() == 1) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            
        }
    }
	
	 @GetMapping("usuario/verificar/{token}")
	    public ResponseEntity<String> verificar(@PathVariable String token) {
	        Usuario usuario = usuarioService.findByToken(token);
	        if (usuario != null) {
	            usuario.setConfirmado(1);
	            usuarioService.save(usuario);
	            return ResponseEntity.ok("La cuenta ha sido verificada exitosamente");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo verificar la cuenta");
	        }
	    }
}
