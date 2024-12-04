package utils;

import java.util.Random;

public class GeradorCPFUtils {

    public static String gerarCPF() {
        Random random = new Random();

        // Gerar os 9 primeiros dígitos do CPF
        int[] cpf = new int[11];
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        // Calcular o primeiro dígito verificador
        cpf[9] = calcularDigito(cpf, 9);

        // Calcular o segundo dígito verificador
        cpf[10] = calcularDigito(cpf, 10);

        // Formatar o CPF
        StringBuilder cpfFormatado = new StringBuilder();
        for (int i = 0; i < cpf.length; i++) {
            cpfFormatado.append(cpf[i]);
            if (i == 2 || i == 5) {
                cpfFormatado.append(".");
            } else if (i == 8) {
                cpfFormatado.append("-");
            }
        }

        return cpfFormatado.toString();
    }

    private static int calcularDigito(int[] cpf, int posicao) {
        int soma = 0;
        int peso = posicao == 9 ? 10 : 11;

        for (int i = 0; i < posicao; i++) {
            soma += cpf[i] * peso--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
