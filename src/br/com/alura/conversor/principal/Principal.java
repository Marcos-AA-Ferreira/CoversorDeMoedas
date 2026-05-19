package br.com.alura.conversor.principal;

import br.com.alura.conversor.modelos.buscaTabelaDeConversao;
import br.com.alura.conversor.modelos.opcoesDeConversao;
import br.com.alura.conversor.modelos.OpcoesDeMoedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

    //*****************Variáveis*****************
        String moeda01 = "";
        String moeda02 = "";
        double valorBase;
        double valorParaConversao = 0;
        int opcaoParaSerConvertido = 0;
        int opcaoParaConverter = 0;
        String menu01 = """
                
                *******************************************************
                Qual moeda você deseja realizar a conversão:
                  1- ARS: Peso Argentino
                  2- BRL: Real Brasileiro
                  3- COP: Peso Colombiano
                  4- EUR: Euro
                  5- USD: Dólar Americano
                  6- Sair do Sistema
                  
                Digite a opção desejada: 
                """;
        String menu02 = """
              
              Para qual moeda você deseja converter:
                  1- ARS: Peso Argentino
                  2- BRL: Real Brasileiro
                  3- COP: Peso Colombiano
                  4- EUR: Euro
                  5- USD: Dólar Americano
                  6- Sair do Sistema
                  
                Digite a opção desejada: 
                """;

        Scanner leitura = new Scanner(System.in);

        System.out.println("Seja Bem-vindo(a) ao Conversor de Moedas");

        // Menu inicial com a escolha da moeda
        while (true) {
            System.out.println(menu01);
            opcaoParaSerConvertido = leitura.nextInt();

            switch (opcaoParaSerConvertido) {
                case 1:
                    moeda01 = "ARS";
                    break;
                case 2:
                    moeda01 = "BRL";
                    break;
                case 3:
                    moeda01 = "COP";
                    break;
                case 4:
                    moeda01 = "EUR";
                    break;
                case 5:
                    moeda01 = "USD";
                    break;
                case 6:
                    System.out.println("\nObrigado por usar nosso sistema\nAté a próxima");
                    return;
                default:
                    System.out.println("\nOpção inválida\nEncolha uma opção Válida");
                    System.out.println(menu01);
                    opcaoParaSerConvertido = leitura.nextInt();
                    break;
            }

            // Pede o valor para converter ao usuário
            System.out.println("\nDigite o valor você deseja converter?");
            valorBase = leitura.nextDouble();

            // Busca o valor para conversão através da API
            buscaTabelaDeConversao buscaTabelaDeConversao = new buscaTabelaDeConversao();
            opcoesDeConversao opcoesDisponiveis = buscaTabelaDeConversao.buscaOpcoes(moeda01);

            // Transforma os dados do record para um objeto cujos dados possam ser acessados pelo código na OpcoesDeMoedas
            OpcoesDeMoedas tabela = new OpcoesDeMoedas(opcoesDisponiveis);

            // Inicia o menu para escolha da conversão do valor obtido
            System.out.println(menu02);
            opcaoParaConverter = leitura.nextInt();

            switch (opcaoParaConverter) {
                case 1:
                    moeda02 = "ARS";
                    valorParaConversao = tabela.getValorARS();
                    break;
                case 2:
                    moeda02 = "BRL";
                    valorParaConversao = tabela.getValorBRL();
                    break;
                case 3:
                    moeda02 = "COP";
                    valorParaConversao = tabela.getValorCOP();
                    break;
                case 4:
                    moeda02 = "EUR";
                    valorParaConversao = tabela.getValorEUR();
                    break;
                case 5:
                    moeda02 = "USD";
                    valorParaConversao = tabela.getValorUSD();
                    break;
                case 6:
                    System.out.println("\nObrigado por usar nosso sistema\nAté a próxima");
                    return;
                default:
                    System.out.println("\nOpção inválida\nEncolha uma opção Válida");
                    System.out.println(menu02);
                    opcaoParaConverter = leitura.nextInt();
                    break;
            }

            // Realiza a conversão com base nos dados fornecidos e exibe no console
            tabela.conversao(valorBase, valorParaConversao, moeda01, moeda02);
        }
    }
}