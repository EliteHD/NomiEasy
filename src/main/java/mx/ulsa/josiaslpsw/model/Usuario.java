package mx.ulsa.josiaslpsw.model;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apePat")
	private String apePaterno;
	
	@Column(name="apeMat")
	private String apeMaterno;
	
	@Column(name="celular")
	private Integer celular;
	
	@Column(name="genero")
	private String genero;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario(Integer idUsuario, String nombre, String apePaterno, String apeMaterno, Integer celular, String genero, String email, String password, Rol rol) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.celular = celular;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Usuario() { }



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApePaterno() {
		return apePaterno;
	}



	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}



	public String getApeMaterno() {
		return apeMaterno;
	}



	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}



	public Integer getCelular() {
		return celular;
	}



	public void setCelular(Integer celular) {
		this.celular = celular;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario{" +
				"idUsuario=" + idUsuario +
				", nombre='" + nombre + '\'' +
				", apePaterno='" + apePaterno + '\'' +
				", apeMaterno='" + apeMaterno + '\'' +
				", celular=" + celular +
				", genero=" + genero +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", rol=" + rol +
				'}';
	}
}
