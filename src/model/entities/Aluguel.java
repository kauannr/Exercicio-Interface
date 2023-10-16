package model.entities;

import java.time.LocalDateTime;

public class Aluguel {
    private LocalDateTime retirada;
    private LocalDateTime entrega;
    private Veiculo veiculo;
    private Fatura fatura;

    public Aluguel(LocalDateTime retirada, LocalDateTime entrega, Veiculo veiculo) {
        this.retirada = retirada;
        this.entrega = entrega;
        this.veiculo = veiculo;
    }

    public LocalDateTime getRetirada() {
        return retirada;
    }

    public void setRetirada(LocalDateTime retirada) {
        this.retirada = retirada;
    }

    public LocalDateTime getEntrega() {
        return entrega;
    }

    public void setEntrega(LocalDateTime entrega) {
        this.entrega = entrega;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
