package controlador;

import ejb.InventarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Inventario;

@ManagedBean
@SessionScoped
public class inventariocontroller {

    @EJB
    private InventarioFacadeLocal inventarioEJB;
    private Inventario inventario;
    private List<Inventario> listinventario;
    private String msn;

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getListinventario() {
        return listinventario;
    }

    public void setListinventario(List<Inventario> listinventario) {
        this.listinventario = listinventario;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void init() {
        listinventario = inventarioEJB.findAll();
        inventario = new Inventario();
    }
    
    public void registrar() {
        try {
            this.inventarioEJB.create(inventario);
            this.inventario = new Inventario();
            this.msn = "Item Agregado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.inventarioEJB.edit(inventario);
            this.inventario = new Inventario();
            this.msn = "Modificado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Inventario eliminaItem) {
        try {
            this.inventarioEJB.remove(inventario);
            this.msn = "Item eliminado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiarDatos() {
        this.inventario = new Inventario();
    }

    public void cargarDatos(Inventario mostrarDatos) {
        this.inventario = mostrarDatos;
    }
}