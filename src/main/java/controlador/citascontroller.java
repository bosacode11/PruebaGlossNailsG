package controlador;

import ejb.CitasFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Citas;

@Named
@SessionScoped
public class citascontroller {
    
    @EJB
    private CitasFacadeLocal citasEJB;
    private Citas citas;
    private List<Citas> listcitas;
    private String msn;

    public CitasFacadeLocal getCitasEJB() {
        return citasEJB;
    }

    public void setCitasEJB(CitasFacadeLocal citasEJB) {
        this.citasEJB = citasEJB;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public List<Citas> getListcitas() {
        return listcitas;
    }

    public void setListcitas(List<Citas> listcitas) {
        this.listcitas = listcitas;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }
    
    @PostConstruct
    public void init() {
        listcitas = citasEJB.findAll();
        citas = new Citas();
    }
    
    public void registrar() {
        try {
            this.citasEJB.create(citas);
            this.citas = new Citas();
            this.msn = "Cita Agregada";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void editar() {
        try {
            this.citasEJB.edit(citas);
            this.citas = new Citas();
            this.msn = "Modificado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Citas eliminaAC) {
        try {
            this.citasEJB.remove(citas);
            this.msn = "Item eliminado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiarDatos() {
        this.citas = new Citas();
    }

    public void cargarDatos(Citas mostrarDatos) {
        this.citas=  mostrarDatos;
    }
}
