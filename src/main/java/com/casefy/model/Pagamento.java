package com.casefy.model;

import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity {
    @Column(length = 10)
    private String tipo;

    @NotNull
    private Double valor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pagamento_pix", joinColumns = @JoinColumn(name = "id_pagamento"), inverseJoinColumns = @JoinColumn(name = "id_pix"))
    private List<Pix> pix;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pagamento_boletoBancario", joinColumns = @JoinColumn(name = "id_pagamento"), inverseJoinColumns = @JoinColumn(name = "id_boletoBancario"))
    private List<BoletoBancario> boletoBancario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pagamento_cartaoCredito", joinColumns = @JoinColumn(name = "id_pagamento"), inverseJoinColumns = @JoinColumn(name = "id_cartaoCredito"))
    private List<CartaoCredito> cartaoCredito;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    StatusPagamento statusPagamento;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pix> getPix() {
        return pix;
    }

    public void setPix(List<Pix> pix) {
        this.pix = pix;
    }

    public List<BoletoBancario> getBoletoBancario() {
        return boletoBancario;
    }

    public void setBoletoBancario(List<BoletoBancario> boletoBancario) {
        this.boletoBancario = boletoBancario;
    }

    public List<CartaoCredito> getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(List<CartaoCredito> cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

}
