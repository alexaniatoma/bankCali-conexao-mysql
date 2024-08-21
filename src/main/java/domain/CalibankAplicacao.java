package domain;

import domain.cliente.DadosCadastroCliente;
import domain.conta.ContaService;

import java.util.Scanner;

public class CalibankAplicacao {

    private static ContaService service = new ContaService();
    private static Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        var opcao = exibirMenu();
        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1: listarContas();
                    break;

                    case 2: abriConta();
                    break;

                    case 3: encerrarConta();
                    break;

                    case 4: consultarSaldo();
                    break;

                    case 5: realizarSaque();
                    break;

                    case 6: realizarDeposito();
                    break;

                    case 7: realizarTransferencia();
                    break;
                }

            }catch (RegraDeNegocioException e) {
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
            }
            opcao = exibirMenu();

        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int exibirMenu() {
        System.out.println("""
                Bem vindo ao CaliBank - Digite a opção desejada: 
                1- Listar contas abertas
                2- Abertura de conta
                3- Encerramento da conta
                4- Consultar saldo em uma conta
                5- Realizar saque em um conta
                6- Realizar depósito em uma conta
                7- Realizar transferencia
                8- Sair
                """);
        return entrada.nextInt();
    }

    private static void listarContas() {
        System.out.println("Contas cadastradas: ");
        var contas = service.listaContasAbertas();
        contas.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial ");
        entrada.next();
    }

    private static void abriConta() {
        System.out.print("Digite o número da conta: ");
        var numeroDaConta = entrada.nextInt();

        System.out.print("Digite o nome do cliente: ");
        var nomeCliente = entrada.next();

        System.out.print("Digite o número do cpf do cliente: ");
        var cpfCliente = entrada.next();

        System.out.print("Digite o email do cliente: ");
        var emailCliente = entrada.next();

        service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nomeCliente, cpfCliente, emailCliente)));

        System.out.println("Conta aberta com sucesso!");
        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
        entrada.next();
    }

    private static void encerrarConta() {
        System.out.print("Digite o número da conta: ");
        var numeroDaConta = entrada.nextInt();

        service.encerrarLogica(numeroDaConta);

        System.out.println("Conta encerrada com sucesso!");
        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
        entrada.next();
    }

    private static void consultarSaldo() {
        System.out.print("Digite o número da conta:");
        var numeroDaConta = entrada.nextInt();
        var saldo = service.consultarSaldo(numeroDaConta);
        System.out.println("Saldo da conta: " + saldo);

        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
        entrada.next();
    }

    private static void realizarSaque() {
        System.out.print("Digite o número da conta: ");
        var numeroDaConta = entrada.nextInt();

        System.out.print("Digite o valor do saque: ");
        var valor = entrada.nextBigDecimal();

        service.realizarSaque(numeroDaConta, valor);
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
        entrada.next();
    }

    private static void realizarDeposito() {
        System.out.print("Digite o número da conta: ");
        var numeroDaConta = entrada.nextInt();

        System.out.print("Digite o valor do depósito:");
        var valor = entrada.nextBigDecimal();

        service.realizarDeposito(numeroDaConta, valor);
        System.out.println("Depósito realizado com sucesso");
        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
        entrada.next();
    }

    private static void realizarTransferencia() {
        System.out.print("Digite o número da conta de origem: ");
        var numeroDaContaOrigem = entrada.nextInt();

        System.out.print("Digite o número da conta de destino: ");
        var numeroDaContaDestino = entrada.nextInt();

        System.out.print("Digite o valor a ser transferido: ");
        var valor = entrada.nextBigDecimal();

        service.realizarTransferencia(numeroDaContaOrigem, numeroDaContaDestino, valor);

        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Pressione qualquer tecla para voltar ao Menu Inicial");
    }
}
