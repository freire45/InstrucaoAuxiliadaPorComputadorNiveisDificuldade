package br.com.erickfreire.instrucaoauxiliadaporcomputador;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Programa em Java que ensina um aluno a multiplicar.
 * 
 * @author Erick Freire
 * @version 1 - Criado em 17-05-2021 as 14:24
 */

public class InstrucaoAuxiliadaPorComputadorNiveisDificuldade {
	public static double acertou = 0.0;
	public static double errou = 0.0;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		System.out.println("Programa que ajuda aprender multiplicação");
		System.out.println("Informe o nível de dificuldade: \n"
				         + "1 - Fácil\n"
				         + "2 - Médio\n"
				         + "3 - Difícil\n");
		opcao = entrada.nextInt();
		
		while(opcao < 1 || opcao > 3) {
			System.out.println("Opção Inválida - Informe o nível de dificuldade: \n"
					         + "1 - Fácil\n"
					         + "2 - Médio\n"
					         + "3 - Difícil\n");
			opcao = entrada.nextInt();
			
		}

		for (int i = 1; i <= 10; i++) {
			multiplicacao(opcao);
		}

		double resultado = ((acertou / 10) - (errou / 10)) * 100;

		if (resultado < 75.0) {
			System.out.println("\nPeça Ajuda ao seu professor, sua média foi de: " + resultado);
		} else {
			System.out.println("\nParabéns - Sua Média foi de: " + resultado);
		}

	}

	public static void multiplicacao(int o) {

		int numero1 = 0;
		int numero2 = 0;
		int multiplicacao = 0;
		int resposta;
		int correta;
		int incorreta;

		SecureRandom numeroAleatorio = new SecureRandom();
		Scanner entrada = new Scanner(System.in);
		
		if(o == 1) {
			numero1 = numeroAleatorio.nextInt(10);
			numero2 = numeroAleatorio.nextInt(10);
			multiplicacao = numero1 * numero2;
		} else {
			if (o == 2) {
				numero1 = numeroAleatorio.nextInt(100);
				numero2 = numeroAleatorio.nextInt(100);
				multiplicacao = numero1 * numero2;
			} else {
				if(o == 3) {
					numero1 = numeroAleatorio.nextInt(1000);
					numero2 = numeroAleatorio.nextInt(1000);
					multiplicacao = numero1 * numero2;
				}
			}
		}

		

		System.out.printf("%nQuanto é %d * %d ?%n", numero1, numero2);
		resposta = entrada.nextInt();

		if (resposta == multiplicacao) {
			correta = 1 + numeroAleatorio.nextInt(4);

			switch (correta) {
			case 1:
				System.out.println("Muito Bom!");
				break;
			case 2:
				System.out.println("Excelente!");
				break;
			case 3:
				System.out.println("Bom Trabalho!");
				break;
			case 4:
				System.out.println("Mantenha um bom trabalho!");
				break;
			default:
				System.out.println("Muito Bem!");
				break;
			}
			acertou++;
		} else {
			while (resposta != multiplicacao) {
				incorreta = 1 + numeroAleatorio.nextInt(4);

				switch (incorreta) {
				case 1:
					System.out.println("Não, por favor tente de novo");
					break;
				case 2:
					System.out.println("Errado. Tente mais uma vez.");
					break;
				case 3:
					System.out.println("Não desista!");
					break;
				case 4:
					System.out.println("Não. Continue tentando.");
					break;
				default:
					System.out.println("Errado!");
					break;
				}

				errou++;
				System.out.printf("%nResposta Incorreta! Tente de novo! Quanto é %d * %d ?%n", numero1, numero2);
				resposta = entrada.nextInt();
			}
			acertou++;
			System.out.println("Muito Bem!");
		}
	}

}
