package com.br.petshop;

import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.List;

public class Cliente extends Usuario { 
    private final List<Animal> animais; 
    private final List<Consulta> consultas;

    public Cliente(int id, String cpf, String nome, String email, 
    String senha, String telefone, String endereco, LocalDate dataNascimento) { 
        super(id, cpf, nome, email, senha, telefone, endereco, dataNascimento); 
        this.animais = new ArrayList<>(); 
        this.consultas = new ArrayList<>(); 
    }

    public void cadastrarAnimal(Animal animal) { 
        if (animal == null) { 
            throw new IllegalArgumentException("Animal não pode ser nulo"); } 
            animais.add(animal); 
        }

        public void editarAnimal(Animal animalAtualizado) { 
            for (int i = 0; i < animais.size(); i++) { 
                if (animais.get(i).getId() == animalAtualizado.getId()) { 
                    animais.set(i, animalAtualizado); return; 
                } 
            } 
            throw new IllegalArgumentException("Animal não encontrado: " + animalAtualizado.getId()); 
        }

        public void removerAnimal(int animalId) { 
            animais.removeIf(a -> a.getId() == animalId); 
        }

        public List<Animal> listarAnimais() { 
            return new ArrayList<>(animais); 
        }

        public void realizarPagamento(double valor) { 
            System.out.printf("Pagamento de R$ %.2f registrado para o cliente %s.%n", valor, getNome()); 
        }

        public void adicionarConsultaHistorico(Consulta consulta) { 
            if (consulta == null) { 
                throw new IllegalArgumentException("Consulta não pode ser nula"); 
            } 
            consultas.add(consulta); 
        }

        public List<Consulta> visualizarHistoricoConsultas() { 
            return new ArrayList<>(consultas); 
        }

        public List<Consulta> buscarConsultaPorAnimal(int animalId) { 
            List<Consulta> resultado = new ArrayList<>(); 
            for (Consulta c : consultas) { 
                if (c.getAnimalId() == animalId) { 
                    resultado.add(c); 
                } 
            } 
            return resultado; 
        } 
    }
