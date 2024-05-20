package humbe.canciones.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import humbe.canciones.model.entity.Cancion;
import humbe.canciones.server.ICancion;
import humbe.canciones.server.impl.EmailService;
@RestController

@RequestMapping("/api/v1")

public class cancionController {
	@Autowired
	private ICancion clienteservice;
	@Autowired
	private EmailService emailservi;
	private static final Logger logger = LoggerFactory.getLogger(cancionController.class);
	@PostMapping("cancion")
	@ResponseStatus(HttpStatus.CREATED)
	public Cancion create(@RequestBody Cancion cliente) {
		logger.info("Cancion a agregar: "+ cliente);
		Cancion saveCliente = clienteservice.save(cliente);
		
		 // Acceder a la fecha de lanzamiento y convertirla a una cadena formateada
	    Date añoLanzamiento = cliente.getAño_lanzamiento();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaFormateada = sdf.format(añoLanzamiento);
	    
	    // Imprimir la fecha formateada en el registro de información
	    logger.info("Fecha de lanzamiento: " + fechaFormateada);
		
		emailservi.enviarCorreoCacnionGuardado(saveCliente.getEmail());
		return saveCliente;
	}
	@PutMapping("cancion/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cancion update(@PathVariable Integer id, @RequestBody Cancion
	cliente) {
		Cancion existingClien = clienteservice.findById(id);
		if(existingClien == null) {
		logger.warn("Cancion no encontrada ");
	}
	cliente.setId_cancion(id);
	Cancion updatedCleinte = clienteservice.save(cliente);
	emailservi.enviarCorreoCancionModificado(updatedCleinte.getEmail());
	return updatedCleinte;
	}
	@DeleteMapping("cancion/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Cancion clienteDelete = clienteservice.findById(id);
		if (clienteDelete != null) {
			clienteservice.delete(clienteDelete);
			// Envía el correo de notificación al eliminar la canción
			String destinatario = clienteDelete.getEmail();
			String cancionEliminada = clienteDelete.getNombre(); // O cualquier otro campo que identifique la canción
			emailservi.enviarCorreoCacnionEliminado(destinatario,cancionEliminada);
		} else {
			// Si el producto no existe, puedes manejar la situación de alguna manera, como lanzar una excepción o simplemente registrar un mensaje de error.
			logger.warn("Intento de eliminar un producto con ID no válido: " + id);
			// Aquí puedes lanzar una excepción, registrar un mensaje de error, etc.
		}
	}
	@GetMapping("cancion/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cancion showById(@PathVariable Integer id) {
		return clienteservice.findById(id);
	}
	@GetMapping("cancion")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Cancion> show() {
		return clienteservice.findAll();
	}
}