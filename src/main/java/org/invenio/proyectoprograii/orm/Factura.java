package org.invenio.proyectoprograii.orm;
// Generated Feb 17, 2018 4:33:56 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Factura generated by hbm2java
 */
@Entity
@Table(name = "factura",
         catalog = "proyecto"
)
public class Factura implements java.io.Serializable {

    private int idFactura;
    private Cliente cliente;
    private Usuario usuario;
    private String tipoFactura;
    private String codigoProducto;
    private String descripcion;
    private int cantidad;
    private double subtotal;
    private double total;
    private Date fecha;
    private Set<Inventario> inventarios = new HashSet<Inventario>(0);

    public Factura() {
    }

    @Id

    @Column(name = "idFactura", unique = true, nullable = false)
    public int getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tblCliente_id", nullable = false)
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "tipoFactura", nullable = false, length = 45)
    public String getTipoFactura() {
        return this.tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    @Column(name = "codigoProducto", nullable = false, length = 45)
    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Column(name = "descripcion", nullable = false, length = 45)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "cantidad", nullable = false)
    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "subtotal", nullable = false, precision = 22, scale = 0)
    public double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Column(name = "total", nullable = false, precision = 22, scale = 0)
    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false, length = 10)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tblfactura_tblinventario", catalog = "proyecto", joinColumns = {
        @JoinColumn(name = "tblFactura_idFactura", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tblInventario_codigo", nullable = false, updatable = false)})
    public Set<Inventario> getInventarios() {
        return this.inventarios;
    }

    public void setInventarios(Set<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

}
