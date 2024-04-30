package br.edu.gean.converter;

import br.edu.gean.converter.models.Color;
import br.edu.gean.converter.models.Converter;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int selectedOption;
        Scanner input = new Scanner(System.in);
        Converter converter = new Converter();

        try{
        String menu = MessageFormat.format("""
            +--------------------------------------------------+
            |            MENU - Conversor de Moedas            | 
            +--------------------------------------------------+
            | {0}Escolha uma das opções abaixo:{1}                   |
            |                                                  |
            | {0}1){1} Dólar (USD) {0}>>{1} Peso Argentino (ARS)           |
            | {0}2){1} Peso Argentino (ARS){0} >>{1} Dólar (USD)           | 
            | {0}3){1} Dólar (USD) {0}>>{1} Real Brasileiro (BRL)          |
            | {0}4){1} Real Brasileiro (BRL) {0}>>{1} Dólar (USD)          |
            | {0}5){1} Dólar (USD){0} >>{1} Peso Colombiano (COP)          |
            | {0}6){1} Peso Colombiano (COP) {0}>>{1} Dólar (USD)          |
            | {0}7){1} Sair..                                        |
            +--------------------------------------------------+
            """, Color.cyan,Color.reset);

        String selectionText = Color.yellow + "\n[ Digite o valor a ser convertido ]\n" + Color.reset;

        do {
            System.out.println(menu);
            selectedOption = input.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.println(selectionText);
                    converter.convertCurrency("USD","ARS", input.nextDouble());
                    break;
                case 2:
                    System.out.println(selectionText);
                    converter.convertCurrency("ARS","USD", input.nextDouble());
                    break;
                case 3:
                    System.out.println(selectionText);
                    converter.convertCurrency("USD","BRL", input.nextDouble());
                    break;
                case 4:
                    System.out.println(selectionText);
                    converter.convertCurrency("BRL","USD", input.nextDouble());
                    break;
                case 5:
                    System.out.println(selectionText);
                    converter.convertCurrency("USD","COP", input.nextDouble());
                    break;
                case 6:
                    System.out.println(selectionText);
                    converter.convertCurrency("COP","USD", input.nextDouble());
                    break;
                case 7:
                    System.out.println("Programa Finalizado.");
                    break;
                default:
                    System.out.println(Color.red + "Selecione uma opção válida." + Color.reset);
                    break;
            }
        } while (selectedOption != 7);

        input.close();
        }catch (InputMismatchException e){
            throw new RuntimeException("Erro: O valor a ser convertido não é um número válido. " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Erro inesperado: " + e.getMessage());
        }
        System.exit(0);
    }

}
