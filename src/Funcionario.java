import java.time.LocalDate;
import java.util.Scanner;

public class Funcionario extends Usuario {
    private String cargo;
    private String cargaHoraria;
    private double salario;
    private String dataContratacao;

    public Funcionario(int id, String cpf, String nome, String email, String senha, String telefone, String endereco,
            LocalDate dataNascimento, String cargo, String cargaHoraria, double salario, String dataContratacao) {
        super(id, cpf, nome, email, senha, telefone, endereco, dataNascimento);
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public void realizarServicoMenu(Scanner sc) {

        int opcao;
        do {
            System.out.println("");
            System.out.println("---- Menu de Serviços ---- ");
            System.out.println("Escolha das opções a seguir:  ");
            System.out.println("1. Realizar Banho");
            System.out.println("2. Realizar Tosa");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (opcao != 1 && opcao != 2);

        processarServico(opcao, sc);
    }

    public void processarServico(int opcao, Scanner sc) {

        boolean cuidadosEspeciais = false;
        boolean ehSilvestre = false;
        String resposta = "n";
        String resSilvestre = "n";
        String autorizacaoIbama = "n";
        System.out.println("---- Dados do Animal ----");
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Informe o nome do pet: ");
        String nomePet = sc.nextLine();
        System.out.println("Informe a especie: ");
        String especie = sc.nextLine();
        System.out.println("Informe a raça: ");
        String raca = sc.nextLine();
        System.out.println("Informe o sexo: ");
        String sexo = sc.nextLine();
        System.out.println("Informe a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o tamanho (em cm): ");
        double tamanho = sc.nextDouble();
        sc.nextLine();
        System.out.println("Informe o peso (em kg): ");
        double peso = sc.nextDouble();
        sc.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Informe a alimentação: ");
        String alimentacao = sc.nextLine();
        System.out.println("Informe o temperamento: ");
        String temperamento = sc.nextLine();

        // cuidados especiais
        do {
            System.out.println("Cuidados especiais? (s/n) ");
            resposta = sc.nextLine();

        } while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));

        if (resposta.equalsIgnoreCase("s")) {
            cuidadosEspeciais = true;
        }

        // silvestre
        do {
            System.out.println("É um animal silvestre? (s/n)");
            resSilvestre = sc.nextLine();

        } while (!resSilvestre.equalsIgnoreCase("s") && !resSilvestre.equalsIgnoreCase("n"));

        if (resSilvestre.equalsIgnoreCase("s")) {
            ehSilvestre = true;
        }
        System.out.println("Informe a origem do animal: ");
        String origem = sc.nextLine();

        // autorização do Ibama
        do {
            System.out.println("Informe se tem autorização do Ibama (s/n)");
            autorizacaoIbama = sc.nextLine();
        } while (!autorizacaoIbama.equalsIgnoreCase("s") && !autorizacaoIbama.equalsIgnoreCase("n"));
        if (autorizacaoIbama.equalsIgnoreCase("s")) {
            System.out.println("Informe o número da autorização do Ibama: ");
            autorizacaoIbama = sc.nextLine();
        } else {
            autorizacaoIbama = "n";

        }

        System.out.println("Tipo de pelagem (Curta ou Longa):");
        String tipoPelagem = sc.nextLine();

        Animal animal = new Animal(id, nomePet, especie, raca, sexo, idade, tamanho, peso, alimentacao, temperamento,
                cuidadosEspeciais, ehSilvestre, origem, autorizacaoIbama);

        System.out.println("Processando serviço...");// implementar logica

        if (opcao == 1) {
            realizarBanho(animal, tipoPelagem);
        } else {
            realizarTosa(animal, tipoPelagem);
        }

    }

    public void realizarTosa(Animal animal, String tipoPelagem) {
        double altura = animal.getTamanho();
        double preco = calcularValoresServicos(tipoPelagem, altura, false);
        String porte = altura <= 30 ? "Pequeno" : (altura <= 50 ? "Médio" : "Grande");

        System.out.println("Tosa realizado com sucesso!");
        System.out.println("Nome do pet:" + animal.getNome());
        System.out.println("Porte: " + porte + " com " + altura + " cm de altura");
        System.out.println("Pelagem:" + tipoPelagem);
        System.out.printf("Valor total: R$ %.2f\n", preco);

    }

    public void realizarBanho(Animal animal, String tipoPelagem) {
        double altura = animal.getTamanho();
        double preco = calcularValoresServicos(tipoPelagem, altura, true);
        String porte = altura <= 30 ? "Pequeno" : (altura <= 50 ? "Médio" : "Grande");

        System.out.println("Banho realizado com sucesso!");
        System.out.println("Nome do pet:" + animal.getNome());
        System.out.println("Porte: " + porte + " com " + altura + " cm de altura");
        System.out.println("Pelagem:" + tipoPelagem);
        System.out.printf("Valor total: R$ %.2f\n", preco);
    }

    public double calcularValoresServicos(String tipoPelagem, double altura, boolean isBanho) {
        double preco = 0;

        if (altura <= 30) {

            preco = tipoPelagem.equalsIgnoreCase("Longa") ? (isBanho ? 70.0 : 60.0) : (isBanho ? 50.0 : 45.0);
        } else if (altura <= 50) {
            preco = tipoPelagem.equalsIgnoreCase("Longa") ? (isBanho ? 85.0 : 75.0) : (isBanho ? 65.0 : 65.0);
        } else {
            preco = tipoPelagem.equalsIgnoreCase("Longa") ? (isBanho ? 100.0 : 90.0) : (isBanho ? 80.0 : 80.0);
        }

        return preco;
    }

    public void alterarSalario(double novoSalario) {
        this.salario = novoSalario;
        System.out.println("Salario alterado para: R$: " + novoSalario);
    }

    public void alterarcargaHoraria(String novaCargaHoraia) {
        this.cargaHoraria = novaCargaHoraia;
        System.out.println("Carga horária alterada para: " + novaCargaHoraia);
    }

    public void alterarCargo(String novoCargo) {
        this.cargo = novoCargo;
        System.out.println("Cargo alterado para: " + novoCargo);
    }
    @Override
    public String toString(){
        return super.toString() + "\nCargo: "+ cargo + "\nCarga Horaria: " + cargaHoraria + "\nSalario: R$" + String.format("%.2f", salario) + "\nData de contratação: " + dataContratacao;
    }
}
