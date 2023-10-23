package mx.ulsa.josiaslpsw.model;

import jakarta.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @Column(name = "cargo")
    private String cargo;
    @Column(name = "salario")
    private Integer salario;
    @Column(name = "nss")
    private Integer nss;
    @Column(name = "curp")
    private String curp;
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "isr")
    private Integer isr;
    @Column(name = "horasTrabajadas")
    private Integer horasTrabajadas;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Empleado() {
    }

    public Empleado(Integer id, String cargo, Integer salario, Integer nss, String curp, String rfc, Integer isr, Integer horasTrabajadas, Usuario usuario, Empresa empresa) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
        this.nss = nss;
        this.curp = curp;
        this.rfc = rfc;
        this.isr = isr;
        this.horasTrabajadas = horasTrabajadas;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getIsr() {
        return isr;
    }

    public void setIsr(Integer isr) {
        this.isr = isr;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", nss=" + nss +
                ", curp='" + curp + '\'' +
                ", rfc='" + rfc + '\'' +
                ", isr=" + isr +
                ", horasTrabajadas=" + horasTrabajadas +
                ", usuario=" + usuario +
                ", empresa=" + empresa +
                '}';
    }
}