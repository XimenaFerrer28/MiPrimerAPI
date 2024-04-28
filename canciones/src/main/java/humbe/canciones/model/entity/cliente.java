package humbe.canciones.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonPropertyOrder
@Table(name = "canciones")


public class cliente implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_cancion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_cancion;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Album")
	private String Album;
	@Column(name = "Año_lanzamiento", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Año_lanzamiento;
	@Column(name = "Duracion")
	private Integer Duracion;
	@Column(name = "Compositor")
	private String Compositor;
	@Column(name = "Productor")
	private String Productor;
	@Column(name="Email")
	private String Email;
	
	public Integer getID_cancion() {
		return ID_cancion;
	}
	public void setID_cancion(Integer iD_cancion) {
		ID_cancion = iD_cancion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getAlbum() {
		return Album;
	}
	public void setAlbum(String album) {
		Album = album;
	}
	public Date getAño_lanzamiento() {
		return Año_lanzamiento;
	}
	public void setAño_lanzamiento(Date año_lanzamiento) {
		Año_lanzamiento = año_lanzamiento;
	}
	public Integer getDuracion() {
		return Duracion;
	}
	public void setDuracion(Integer duracion) {
		Duracion = duracion;
	}
	public String getCompositor() {
		return Compositor;
	}
	public void setCompositor(String compositor) {
		Compositor = compositor;
	}
	public String getProductor() {
		return Productor;
	}
	public void setProductor(String productor) {
		Productor = productor;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public cliente(Integer iD_cancion, String nombre, String album, Date año_lanzamiento, Integer duracion,
			String compositor, String productor, String email) {
		super();
		ID_cancion = iD_cancion;
		Nombre = nombre;
		Album = album;
		Año_lanzamiento = año_lanzamiento;
		Duracion = duracion;
		Compositor = compositor;
		Productor = productor;
		Email = email;
	}
	
	
	public cliente() {
		
	}
	

}

