package humbe.canciones.model.entity;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "canciones")


public class Cancion{	
	

	
	@Id
	@Column(name = "id_cancion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cancion;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "album")
	private String album;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "año_lanzamiento")
	@NotNull
	private Date año_lanzamiento;
	
	@Column(name = "duracion")
	private Integer duracion;
	@Column(name = "compositor")
	private String compositor;
	@Column(name = "productor")
	private String productor;
	@Column(name="email")
	private String email;
	@Column(name="url")
	private String url;
	@Column(name="descripcion")
	private String descripcion;
	

	@ManyToOne
	private Usuario usuario;
	
	public Integer getId_cancion() {
		return id_cancion;
	}
	public void setId_cancion(Integer id_cancion) {
		this.id_cancion = id_cancion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Date getAño_lanzamiento() {
		return año_lanzamiento;
	}
	public void setAño_lanzamiento(Date año_lanzamiento) {
		this.año_lanzamiento = año_lanzamiento;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public String getCompositor() {
		return compositor;
	}
	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	
	
	
	
	
	
	

}

