package humbe.canciones.server.impl;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

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
  
  
  // Metodo para verificar la identidad del usuario 
  public void enviarCorreoAutenticacion(String destinatario, String usuario) {
	    String asunto = "Bienvenido " + usuario + " Al sistema de administrador de Canciones";
	    String mensaje = "<html><body><h1>Usuario Almacenado</h1> "+ usuario +" <p>Comprueba tu cuenta</p><p>Tu cuenta ya esta lista, solo debes comprobarla en el siguiente enlace: </p></body></html>";
	    enviarCorreo(destinatario, asunto, mensaje);
	  }
  // Método para enviar correo de confirmación al guardar un cancion
  public void enviarCorreoCacnionGuardado(String destinatario) {
    String asunto = "Cancion Almacenado";
    String mensaje = "<html><body><h1>Cancion Almacenado</h1><p>La cancion se ha almacenado correctamente.</p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método para enviar correo de confirmación al modificar un cancion
  public void enviarCorreoCancionModificado(String destinatario) {
    String asunto = "Cancion Modificado";
    String mensaje = "<html><body><h1>Cancion Modificado</h1><p>La Cancion se ha modificado correctamente.</p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método para enviar correo de notificación al eliminar una cacnion
  public void enviarCorreoCacnionEliminado(String destinatario, String
  productoEliminado) {
    String asunto = "Cancion Eliminado";
    String mensaje = "<html><body><h1>Cancion Eliminado</h1><p>La siguiente cacnion ha sido eliminado: <strong>" + productoEliminado + "</strong></p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método genérico para enviar correo electrónico
  // Método genérico para enviar correo electrónico
  private void enviarCorreo(String destinatario, String asunto, String  mensaje) {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
    StandardCharsets.UTF_8.name());
    try {
      helper.setTo(destinatario);
      helper.setSubject(asunto);
      helper.setText(mensaje, true); // Indicar que el mensaje esHTML 
      helper.setFrom(remitente);
      javaMailSender.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
      // Manejar la excepción adecuadamente
    }
  }
}
