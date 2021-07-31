package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactenos")
public class Contactenos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontactenos;

    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Celular")
    private String Celular;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "Mensaje")
    private String Mensaje;

    public int getContactenos() {
        return idcontactenos;
    }

    public void setContactenos(int contactenos) {
        this.idcontactenos = contactenos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idcontactenos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contactenos other = (Contactenos) obj;
        if (this.idcontactenos != other.idcontactenos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contactenos{" + "idcontactenos=" + idcontactenos + '}';
    }

}
