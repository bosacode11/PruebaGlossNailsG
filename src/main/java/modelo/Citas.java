package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agendamiento")
public class Citas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idagendamiento;

    @Column(name = "manicurista")
    private String manicurista;
    @Column(name = "Tservicio")
    private String TServicio;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "hora")
    private String hora;

    public int getIdagendamiento() {
        return idagendamiento;
    }

    public void setIdagendamiento(int idagendamiento) {
        this.idagendamiento = idagendamiento;
    }

    public String getManicurista() {
        return manicurista;
    }

    public void setManicurista(String manicurista) {
        this.manicurista = manicurista;
    }

    public String getTServicio() {
        return TServicio;
    }

    public void setTServicio(String TServicio) {
        this.TServicio = TServicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idagendamiento;
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
        final Citas other = (Citas) obj;
        if (this.idagendamiento != other.idagendamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Citas{" + "idagendamiento=" + idagendamiento + '}';
    } 
}