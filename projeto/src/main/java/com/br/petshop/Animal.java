package com.br.petshop;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private String sexo;
    private int idade;
    private double tamanho;
    private double peso;
    private String alimentacao;
    private String temperamento;
    private boolean cuidadosEspeciais;
    private boolean ehSilvestre;
    private String origem;
    private String autorizacaoIbama;

    public Animal(int id, String nome, String especie, String raca, String sexo, int idade, double tamanho, double peso,
            String alimentacao, String temperamento, boolean cuidadosEspeciais, boolean ehSilvestre, String origem,
            String autorizacaoIbama) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.tamanho = tamanho;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.temperamento = temperamento;
        this.cuidadosEspeciais = cuidadosEspeciais;
        this.ehSilvestre = ehSilvestre;
        this.origem = origem;
        this.autorizacaoIbama = autorizacaoIbama;
    }

    public int getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void marcarComoSilvestre(String autorizacaoIbama){
        this.ehSilvestre = true;
        this.autorizacaoIbama = autorizacaoIbama;
        System.out.println("Animal marcado como silvestre com autorização: " + autorizacaoIbama);
    }

    public void imprimirDadosAnima(){
        System.out.println("----Dados do Anima----");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Raça: " + raca);
        System.out.println("Sexo: " + sexo);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Tamanho: " + tamanho + " cm");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Alimentação: " + alimentacao);
        System.out.println("Temperamento: " + temperamento);
        System.out.println("Cuidados Especiais: " + (cuidadosEspeciais ? "Sim" : "Não"));
        System.out.println("É Silvestre: " + (ehSilvestre ? "Sim" : "Não"));

        if(ehSilvestre) {
            System.out.println("Origem: " + origem);
            System.out.println("Autorização IBAMA: " + autorizacaoIbama);
        } else {
            System.out.println("Origem: Doméstico");
            System.out.println("Autorização IBAMA: Não aplicável");
        }
        System.out.println("-----------------------");

    }
    public double getTamanho() {
        return tamanho;
    }


}
