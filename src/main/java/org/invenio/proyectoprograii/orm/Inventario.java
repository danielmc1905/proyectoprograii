package org.invenio.proyectoprograii.orm;
// Generated Feb 17, 2018 4:33:56 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Inventario generated by hbm2java
 */
@Entity
@Table(name = "inventario",
        catalog = "proyecto"
)
public class Inventario implements java.io.Serializable {

    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private double total;
    private Set<Factura> facturas = new HashSet<Factura>(0);

    public Inventario() {
    }

    @Id

    @Column(name = "codigo", unique = true, nullable = false, length = 45)
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Column(name = "precioUnitario", nullable = false, precision = 22, scale = 0)
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Column(name = "total", nullable = false, precision = 22, scale = 0)
    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tblfactura_tblinventario", catalog = "proyecto", joinColumns = {
        @JoinColumn(name = "tblInventario_codigo", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tblFactura_idFactura", nullable = false, updatable = false)})
    public Set<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
