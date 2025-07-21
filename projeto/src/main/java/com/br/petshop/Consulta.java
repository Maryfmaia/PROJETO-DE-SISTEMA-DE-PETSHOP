package com.br.petshop;


import java.time.LocalDate;

public class Consulta {
    private final int id;
    private final int animalId;
    private final int veterinarioId;
    private final LocalDate dataConsulta;
    private String diagnostico;
    private String tratamento;

    public Consulta(int id, int animalId, int veterinarioId, LocalDate dataConsulta,
                    String diagnostico, String tratamento) {
        if (dataConsulta == null || diagnostico == null || tratamento == null) {
            throw new IllegalArgumentException("Dados da consulta inválidos");
        }
        this.id = id;
        this.animalId = animalId;
        this.veterinarioId = veterinarioId;
        this.dataConsulta = dataConsulta;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getVeterinarioId() {
        return veterinarioId;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        if (diagnostico == null || diagnostico.isBlank()) {
            throw new IllegalArgumentException("Diagnóstico inválido");
        }
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        if (tratamento == null || tratamento.isBlank()) {
            throw new IllegalArgumentException("Tratamento inválido");
        }
        this.tratamento = tratamento;
    }

    @Override
    public String toString() {
        return String.format("Consulta ID %d - Animal ID %d - Veterinário ID %d - Data: %s - Diagnóstico: %s - Tratamento: %s",
                id, animalId, veterinarioId, dataConsulta, diagnostico, tratamento);
    }
}

