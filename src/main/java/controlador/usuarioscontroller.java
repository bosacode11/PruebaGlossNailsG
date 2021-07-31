package controlador;

import ejb.UsuarioRegFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.UsuarioReg;

//@Named
//@ViewScoped
@ManagedBean
@SessionScoped
public class usuarioscontroller implements Serializable {

    @EJB
    private UsuarioRegFacadeLocal usuariosEJB;
    private UsuarioReg usuarioreg;
    private List<UsuarioReg> listaUsuarios;
    private String msn;

    public UsuarioReg getUsuarioreg() {
        return usuarioreg;
    }

    public void setUsuarioreg(UsuarioReg usuarioreg) {
        this.usuarioreg = usuarioreg;
    }

    public List<UsuarioReg> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioReg> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void init() {
        listaUsuarios = usuariosEJB.findAll();
        usuarioreg = new UsuarioReg();
    }

    public void guardar() {
        try {
            this.usuariosEJB.create(usuarioreg);
            this.usuarioreg = new UsuarioReg();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.usuariosEJB.edit(usuarioreg);
            this.usuarioreg = new UsuarioReg();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(UsuarioReg eliminaUsuario) {
        try {
            this.usuariosEJB.remove(eliminaUsuario);
            this.msn = "Registro eliminado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiarDatos() {
        this.usuarioreg = new UsuarioReg();
    }

    public void cargarDatos(UsuarioReg cargaUsuario) {
        this.usuarioreg = cargaUsuario;
    }

}
