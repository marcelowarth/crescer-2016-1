/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.aula4.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marcelo.moura
 */
@Entity
@Table(name = "PRODUTO")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByDatacadastro", query = "SELECT p FROM Produto p WHERE p.datacadastro = :datacadastro"),
    @NamedQuery(name = "Produto.findByPrecocusto", query = "SELECT p FROM Produto p WHERE p.precocusto = :precocusto"),
    @NamedQuery(name = "Produto.findByPrecovenda", query = "SELECT p FROM Produto p WHERE p.precovenda = :precovenda"),
    @NamedQuery(name = "Produto.findBySituacao", query = "SELECT p FROM Produto p WHERE p.situacao = :situacao")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private BigDecimal idproduto;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precocusto;
    @Column(name = "PRECOVENDA")
    private BigDecimal precovenda;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private Character situacao;
    @OneToMany(mappedBy = "idproduto")
    private Collection<Pedidoitem> pedidoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduto")
    private Collection<Produtomaterial> produtomaterialCollection;

    public Produto() {
    }

    public Produto(BigDecimal idproduto) {
        this.idproduto = idproduto;
    }

    public Produto(BigDecimal idproduto, String nome, Date datacadastro, BigDecimal precocusto, Character situacao) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.datacadastro = datacadastro;
        this.precocusto = precocusto;
        this.situacao = situacao;
    }

    public BigDecimal getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(BigDecimal idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public BigDecimal getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(BigDecimal precocusto) {
        this.precocusto = precocusto;
    }

    public BigDecimal getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(BigDecimal precovenda) {
        this.precovenda = precovenda;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
    }

    public Collection<Produtomaterial> getProdutomaterialCollection() {
        return produtomaterialCollection;
    }

    public void setProdutomaterialCollection(Collection<Produtomaterial> produtomaterialCollection) {
        this.produtomaterialCollection = produtomaterialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cwi.crescer.aula4.entity.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
