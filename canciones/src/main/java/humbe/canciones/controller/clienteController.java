package humbe.canciones.controller;

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

@RestController
@RequestMapping("/api/v1")
public class clienteController {

	@Autowired
	private ICliente clienteservice;
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public cliente create(@RequestBody cliente cliente) {
		return clienteservice.save(cliente);
	}
	
	@PutMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public cliente update(@RequestBody cliente cliente) {
		return clienteservice.save(cliente);
	}
	
	@DeleteMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		 cliente clientedelete = clienteservice.findById(id);
		 clienteservice.delete(clientedelete);
	}
	
	@GetMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public cliente showById(@PathVariable Integer id) {
		return clienteservice.findById(id);
	}
}
