package humbe.canciones.controller;

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


import humbe.canciones.model.entity.cliente;
import humbe.canciones.server.ICliente;
import humbe.canciones.server.impl.EmailService;

@RestController
@RequestMapping("/api/v1")
public class clienteController {

	@Autowired
	private ICliente clienteservice;
	
	@Autowired
	private EmailService emailservi;
	private static final Logger logger = LoggerFactory.getLogger(clienteController.class);
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public cliente create(@RequestBody cliente cliente) {
		logger.info("Cancion a agregar: "+ cliente);
		cliente saveCliente = clienteservice.save(cliente);
		emailservi.enviarCorreoProductoGuardado(saveCliente.getEmail());
		return saveCliente;
	}
	
	@PutMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public cliente update(@PathVariable Integer id,  @RequestBody cliente cliente) {
		cliente existingClien = clienteservice.findById(id);
		if(existingClien == null) {
			logger.warn("Cancion no encontrada ");
		}
		cliente.setID_cancion(id);
		cliente updatedCleinte = clienteservice.save(cliente);
		emailservi.enviarCorreoProductoModificado(updatedCleinte.getEmail());
		return updatedCleinte;
	}
	
	@DeleteMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		cliente clienteDelete = clienteservice.findById(id);
	    if (clienteDelete != null) {
	        clienteservice.delete(clienteDelete);
	    } else {
	        // Si el producto no existe, puedes manejar la situación de alguna manera, como lanzar una excepción o simplemente registrar un mensaje de error.
	        logger.warn("Intento de eliminar un producto con ID no válido: " + id);
	        // Aquí puedes lanzar una excepción, registrar un mensaje de error, etc.
	    }
	}
	
	@GetMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public cliente showById(@PathVariable Integer id) {
		return clienteservice.findById(id);
	}
	
	
	@GetMapping("cliente")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<cliente> show() {
		return clienteservice.findAll();
	}
}
