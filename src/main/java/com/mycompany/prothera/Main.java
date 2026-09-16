package com.mycompany.prothera;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import java.text.NumberFormat;

/**
 *
 * @author Enzo
 */
public class Main {
    public static void main(String[] args) {
        
//        3.1 - Inserindo Funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        
        String[][] dados = {
            {"Maria", "2000-10-18", "2009.44", "Operador"},
            {"João", "1990-05-12", "2284.38", "Operador"},
            {"Caio", "1961-05-02", "9836.14", "Coordenador"},
            {"Miguel", "1988-10-14", "19119.88", "Diretor"},
            {"Alice", "1995-01-05", "2234.68", "Recepcionista"},
            {"Heitor", "1999-11-19", "1582.72", "Operador"},
            {"Arthur", "1993-03-31", "4071.84", "Contador"},
            {"Laura", "1994-07-08", "3017.45", "Gerente"},
            {"Heloísa", "2003-05-24", "1606.85", "Eletricista"},
            {"Helena", "1996-09-02", "2799.93", "Gerente"}
        };
        
        for(String[] dado : dados) {
            String nome = dado[0];
            LocalDate dataNascimento = LocalDate.parse(dado[1]);
            BigDecimal salario = new BigDecimal(dado[2]);
            String funcao = dado[3];
            
            funcionarios.add(
                    new Funcionario(nome, dataNascimento, salario, funcao)
            );
        }
        
//        3.2 Removendo João da Lista
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        
//        3.3 Impressão dos Funcionários e suas informações
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        NumberFormat formatSalario = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        formatSalario.setMinimumFractionDigits(2);
        formatSalario.setMaximumFractionDigits(2);
        
        for(Funcionario funcionario : funcionarios) {
            System.out.println(
                "Nome: " + funcionario.getNome()
                + ", Data de Nascimento: " + funcionario.getDataNascimento().format(formatData)
                + ", Salário: " + formatSalario.format(funcionario.getSalario())
                + ", Função: " + funcionario.getFuncao()
            );
        }
        
//        3.4 Aumento do salário em 10%
        for(Funcionario funcionario : funcionarios) {
            BigDecimal newSalario = funcionario.getSalario().multiply(new BigDecimal("1.10")).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(newSalario);
        }
        
//        3.5 Agrupando Funcionários por função
        Map<String, List<Funcionario>> funcionariosFuncao = new HashMap<>();
        
        for(Funcionario funcionario : funcionarios) {
            funcionariosFuncao.computeIfAbsent(funcionario.getFuncao(), key -> new ArrayList<>()).add(funcionario);
        }
        
//        3.6 Imprimindo os Funcionários separados por função
        for(Map.Entry<String, List<Funcionario>> entry : funcionariosFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            
            for(Funcionario funcionario : entry.getValue()) {
                System.out.println(" - " + funcionario.getNome());
            }
        }
        
//        3.8 Aniversáriantes de Outubro e Dezembro
        System.out.println("Os funcionários que fazem aniversário no mês de Outubro ou Dezembro são:");
        
        for(Funcionario funcionario : funcionarios) {
            int mes = funcionario.getDataNascimento().getMonthValue();
            
            if(mes == 10 || mes == 12) {
                System.out.println(funcionario.getNome());
            }
        }
        
//        3.9 Funcionário mais velho
        Funcionario funcionarioMaisVelho = funcionarios.get(0);
        
        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
                funcionarioMaisVelho = funcionario;
            }
        }
        
        int idade = Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears();
        
        System.out.println("O funcionário mais velho é o " + funcionarioMaisVelho.getNome() + " com " + idade + " anos.");
        
//        3.10 Lista de Funcionários em ordem alfabética
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        
        System.out.println("Lista de Funcionários em ordem alfabética:");
        
        for(Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
        
//        3.11 Total dos salários dos Funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        
        for(Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        
        System.out.println("O valor de todos os salários somados é de: R$ " + formatSalario.format(totalSalarios));
        
//        3.12 Salários Mínimos por Funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        
        for(Funcionario funcionario : funcionarios) {
            BigDecimal quantSalariosMin = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            
            System.out.println(funcionario.getNome() + " recebe " + quantSalariosMin + " salários mínimos.");
        }
    }
}
