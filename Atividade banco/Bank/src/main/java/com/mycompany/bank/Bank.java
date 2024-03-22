package com.mycompany.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static ArrayList<Conta> contas = new ArrayList<Conta>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    exibirSaldo();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    transferir();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n**Bank_Estulas**");
        System.out.println("1. Abertura de Conta");
        System.out.println("2. Consulta de Saldo");
        System.out.println("3. Saque");
        System.out.println("4. Depósito");
        System.out.println("5. Transferência");
        System.out.println("6. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void criarConta() {
        System.out.println("\n**Abertura de Conta**");
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.next();
        System.out.print("CPF do titular: ");
        String cpfTitular = scanner.next();
        System.out.print("Data de nascimento do titular (dd/mm/aaaa): ");
        String dataNascimentoTitular = scanner.next();
        System.out.print("Número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Agência da conta: ");
        String agenciaConta = scanner.next();
        System.out.print("Banco da conta: ");
        int bancoConta = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Pessoa titular = new Pessoa(nomeTitular, cpfTitular, dataNascimentoTitular);
        Conta conta = new Conta(numeroConta, bancoConta, titular, agenciaConta);
        conta.depositar(saldoInicial);
        contas.add(conta);

        System.out.println("Conta aberta com sucesso!");
    }

    private static void exibirSaldo() {
        System.out.println("\n**Consulta de Saldo**");
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();

        Conta contaEncontrada = buscarConta(numeroConta);

        if (contaEncontrada != null) {
            System.out.println("Titular: " + contaEncontrada.getTitular().getNome());
            System.out.println("Saldo: R$" + String.format("%.2f", contaEncontrada.getSaldo()));
            System.out.println("Número da conta: " + contaEncontrada.getNumero());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void sacar() {
        System.out.println("\n**Saque**");
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();

        Conta contaEncontrada = buscarConta(numeroConta);

        if (contaEncontrada != null) {
            if (contaEncontrada.sacar(valor)) {
                System.out.println("Saque efetuado com sucesso!");
            } else {
                System.out.println("Saque não efetuado!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void depositar() {
        System.out.println("\n**Depósito**");
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();

    Conta contaEncontrada = buscarConta(numeroConta);

    if (contaEncontrada != null) {
        if (contaEncontrada.depositar(valor)) {
            System.out.println("Depósito efetuado com sucesso!");
        } else {
            System.out.println("Depósito não efetuado!");
        }
    } else {
        System.out.println("Conta não encontrada!");
        }
    }

    private static void transferir() {
        System.out.println("\n**Transferência**");
        System.out.print("Digite o número da conta origem: ");
        String numeroContaOrigem = scanner.next();
        System.out.print("Digite o número da conta destino: ");
        String numeroContaDestino = scanner.next();
        System.out.print("Valor da transferência: ");
        double valor = scanner.nextDouble();

        Conta contaOrigem = buscarConta(numeroContaOrigem);
        Conta contaDestino = buscarConta(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
                if (contaOrigem.transferir(valor, contaDestino)) {
                    System.out.println("Transferência efetuada com sucesso!");
                } else {
                    System.out.println("Transferência não efetuada!");
                }
        } else {
            System.out.println("Conta(s) não encontrada(s)!");
            }
        }

    private static Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
            return conta;
          }
        }
        return null;
        }
    }
