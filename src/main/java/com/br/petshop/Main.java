package com.br.petshop;

import java.util.Scanner;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Funcionario f = new Funcionario(1, "123456564", "Carlos", "carlos@gmail.com", "1234561", "99999999",
            "rua dos bobos",
            LocalDate.of(1990, 1, 1), "Veterinário", "40 horas", 3000.00, "2023-01-01");
          
            f.realizarServicoMenu(sc);

        

        sc.close();
    }
   }