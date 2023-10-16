package model.services;

public class BrasilTaxaService implements TaxaService {

    public Double taxa(Double valor) {
        if (valor < 100d) {
            return 0.2d * valor;
        } else {
            return 0.15d * valor;
        }
    }

}
