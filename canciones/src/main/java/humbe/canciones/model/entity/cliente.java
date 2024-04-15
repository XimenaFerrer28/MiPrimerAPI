package humbe.canciones.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "canciones")


public class cliente implements Serializable{	
	@Id
	@Column(name = "ID_cancion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_cancion;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Album")
	private String Album;
	@Column(name = "Año_lanzamiento")
	private Date Año_lanzamiento;
	@Column(name = "Duracion")
	private Integer Duracion;
	@Column(name = "Compositor")
	private String Compositor;
	@Column(name = "Productor")
	private String Productor;
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
}

