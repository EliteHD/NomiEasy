package mx.ulsa.josiaslpsw.model;


import jakarta.persistence.*;

@Entity
@Table(name="rol")
public class Rol {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="rol_id")
        private Integer idRol;

        @Column(name="nombre")
        private String nombre;

        @Column(name="descripcion")
        private String descripcion;
        public Rol() {
            super();
        }

    public Rol(Integer idRol, String nombre, String descripcion) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
