package br.cwi.crescer.aula4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sun.util.calendar.LocalGregorianCalendar.Date;

@Entity
@Table(name = "AMIGOS")
public class Amigos implements Serializable{
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGOS")
    @SequenceGenerator(name = "SEQ_AMIGOS", sequenceName = "SEQ_AMIGOS", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_AMIGOS")
    private Long idAmigos;
    
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private Usuario usuario;
    
    @Basic(optional = false)
    @Column(name = "USUARIO_AMIGO")
    private Usuario usuario_amigo;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATA_AMIZADE")
    private Date data_amizade;

    public Long getIdAmigos() {
        return idAmigos;
    }

    public void setIdAmigos(Long idAmigos) {
        this.idAmigos = idAmigos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario_amigo() {
        return usuario_amigo;
    }

    public void setUsuario_amigo(Usuario usuario_amigo) {
        this.usuario_amigo = usuario_amigo;
    }

    public Date getData_amizade() {
        return data_amizade;
    }

    public void setData_amizade(Date data_amizade) {
        this.data_amizade = data_amizade;
    }
    
    
}
