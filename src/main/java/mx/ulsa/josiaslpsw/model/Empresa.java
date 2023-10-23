package mx.ulsa.josiaslpsw.model;

import jakarta.persistence.*;

@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "areaGeografica")
    private String areaGeografica;
    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "rfc")
    private String rfc;
    @Column(name = "salarioMinimo")
    private Integer salarioMinimo;

    public Empresa() {
    }

    public Empresa(Integer id, String nombre, String areaGeografica, Integer telefono, String rfc, Integer salarioMinimo) {
        this.id = id;
        this.nombre = nombre;
        this.areaGeografica = areaGeografica;
        this.telefono = telefono;
        this.rfc = rfc;
        this.salarioMinimo = salarioMinimo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaGeografica() {
        return areaGeografica;
    }

    public void setAreaGeografica(String areaGeografica) {
        this.areaGeografica = areaGeografica;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Integer salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }
}