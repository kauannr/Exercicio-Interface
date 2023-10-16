import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Aluguel;
import model.entities.Veiculo;
import model.services.AluguelService;
import model.services.BrasilTaxService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("ENTRE COM OS DADOS DA LOCAÇÃO: ");
        System.out.print("Modelo do carro: ");
        String carro = sc.nextLine();
        System.out.print("Data da retirada (dd/mm/yyyy HH/mm): ");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), formato);
        System.out.print("Data da entrega (dd/mm/yyyy HH/mm): ");
        LocalDateTime entrega = LocalDateTime.parse(sc.nextLine(), formato);

        Aluguel aluguel = new Aluguel(retirada, entrega, new Veiculo(carro));

        System.out.print("Entre com o preço por hora: ");
        Double precoHora = sc.nextDouble();
        sc.nextLine();
        System.out.print("Entre com o preço por dia: ");
        Double precoDia = sc.nextDouble();
        sc.nextLine();

        AluguelService aluguelService = new AluguelService(precoHora, precoDia, new BrasilTaxService());

        aluguelService.calcularFatura(aluguel);

        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + String.format("%2.f", aluguel.getFatura().getPagamentoBasico()));
        System.out.println("Imposto: " + String.format("%.2f", aluguel.getFatura().getTaxa()));
        System.out.println("Pagamento total: " + String.format("%.2f", aluguel.getFatura().pagamentoTotal()));

        sc.close();

    }
}
