package org.invenio.proyectoprograii.orm;
// Generated Feb 17, 2018 4:33:56 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuario",
        catalog = "proyecto"
)
public class Usuario implements java.io.Serializable {

    private int idUsuario;
    private Organizacion organizacion;
    private String tipo;
    private String descripcion;
    private String contrasena;
    private Set<Factura> facturas = new HashSet<Factura>(0);

    public Usuario() {
    }

    @Id
    @Column(name = "idUsuario", unique = true, nullable = false)
    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tblOrganizacion_idCliente", nullable = false)
    public Organizacion getOrganizacion() {
        return this.organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    @Column(name = "tipo", nullable = false, length = 45)
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "descripcion", nullable = false, length = 45)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "contrasena", nullable = false, length = 45)
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
