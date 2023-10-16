package model.services;

import java.time.Duration;

import model.entities.Aluguel;
import model.entities.Fatura;

public class AluguelService {
    private Double precoHora;
    private Double precoDia;
    private TaxaService TaxaService;

    public AluguelService(Double precoHora, Double precoDia, TaxaService taxaService) {
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.TaxaService = taxaService;

    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public Double getPrecoDia() {
        return precoDia;
    }

    public void setPrecoDia(Double precoDia) {
        this.precoDia = precoDia;
    }

    public TaxaService getTaxaService() {
        return TaxaService;
    }

    public void setTaxaService(TaxaService taxaService) {
        this.TaxaService = taxaService;
    }

    public void calcularFatura(Aluguel aluguel) {
        double minutos = Duration.between(aluguel.getRetirada(), aluguel.getEntrega()).toMinutes();
        double horas = minutos / 60;

        double pagamentoBasico;
        if (horas < 12) {
            pagamentoBasico = precoHora * Math.ceil(horas);
        } else {
            pagamentoBasico = precoDia * Math.ceil((horas / 24));
        }

        double taxa = TaxaService.taxa(pagamentoBasico);
        aluguel.setFatura(new Fatura(pagamentoBasico, taxa));
    }

}
