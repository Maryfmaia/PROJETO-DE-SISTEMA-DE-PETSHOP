package com.br.petshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Veterinario extends Funcionario {
    private final String crmv;
    private String especialidade;
    private final List<Consulta> consultas;

    public Veterinario(int id, String cpf, String nome, String email, String senha,
                       String telefone, String endereco, LocalDate dataNascimento,
                       String cargo, String cargaHoraria, double salario,
                       String dataContratacao, String crmv, String especialidade) {
        super(id, cpf, nome, email, senha, telefone, endereco, dataNascimento,
              cargo, cargaHoraria, salario, dataContratacao);
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    public void gerarFichaMedica(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta nula");
        }
        System.out.printf("Ficha médica gerada para o animal ID %d - Diagnóstico: %s%n",
                          consulta.getAnimalId(), consulta.getDiagnostico());
    }

    public void adicionarConsulta(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta nula");
        }
        consultas.add(consulta);
    }

    public String getCrmv() {
        return crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("Especialidade inválida");
        }
        this.especialidade = especialidade;
    }
}
