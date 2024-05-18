package humbe.canciones.server.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import humbe.canciones.exception.NotFoundException;
import humbe.canciones.model.dao.UsuarioDao;
import humbe.canciones.model.entity.Usuario;
import humbe.canciones.server.IUsuario;
import jakarta.transaction.Transactional;

@Service
public class Usuarioimpl implements IUsuario{
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	@Override
	public Usuario save(Usuario usuario) {
		if(usuario.getId_usuario() == null) {
			return usuarioDao.save(usuario);
		}
		else {
			Usuario exxiteCliente =	usuarioDao.findById(usuario.getId_usuario()).orElse(null);
			if (exxiteCliente != null) {
				exxiteCliente.setNombre(usuario.getNombre());
				exxiteCliente.setApellido(usuario.getApellido());
				exxiteCliente.setEmail(usuario.getEmail());
				exxiteCliente.setPassword(usuario.getPassword());
				return usuarioDao.save(exxiteCliente);
			}else {
				throw new NotFoundException("Producto no encontrado con el ID: " + usuario.getId_usuario());
			}
		}
	}
	@Transactional
	@Override
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);
		
	}

	@Override
	public Usuario findById(Integer id) {
		return usuarioDao.findById(id).orElse(null);
	}
	
	
	
	
}
