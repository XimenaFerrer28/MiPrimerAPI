package humbe.canciones.server.impl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;


@Service
public class EmailService {

	 @Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String remitente;

	    // Método para enviar correo de confirmación al guardar un producto
	    public void enviarCorreoProductoGuardado(String destinatario) {
	        enviarCorreo(destinatario, "Producto Almacenado", "El producto se ha almacenado correctamente.");
	    }

	    // Método para enviar correo de confirmación al modificar un producto
	    public void enviarCorreoProductoModificado(String destinatario) {
	        enviarCorreo(destinatario, "Producto Modificado", "El producto se ha modificado correctamente.");
	    }

	    // Método para enviar correo de notificación al eliminar un producto
	    public void enviarCorreoProductoEliminado(String destinatario, String productoEliminado) {
	        String mensaje = "El siguiente producto ha sido eliminado: \n" + productoEliminado;
	        enviarCorreo(destinatario, "Producto Eliminado", mensaje);
	    }

	    // Método genérico para enviar correo electrónico
	    private void enviarCorreo(String destinatario, String asunto, String mensaje) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        try {
	            helper.setTo(destinatario);
	            helper.setSubject(asunto);
	            helper.setText(mensaje);
	            helper.setFrom(remitente);
	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            // Manejar la excepción adecuadamente
	        }
	    }
    
}
