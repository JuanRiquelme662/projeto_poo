package br.edu.cs.poo.ac.seguro.mediators;

/**
 * Valida CPF e CNPJ pelo c\u00e1lculo dos dois d\u00edgitos verificadores.
 * Só métodos est\u00e1ticos, usados pelos mediators de pessoa e de empresa.
 *
 * Os dois algoritmos s\u00e3o irm\u00e3os: multiplica-se cada d\u00edgito por
 * um
 * "peso",
 * soma-se tudo, e o resto da divis\u00e3o por 11 define o d\u00edgito
 * verificador.
 * O 2º d\u00edgito é calculado igual ao 1º, só que incluindo o 1º d\u00edgito
 * na conta.
 */
public class ValidadorCpfCnpj {

	// Pesos oficiais do CNPJ. O 1º d\u00edgito usa 12 n\u00fameros; o 2º usa 13.
	private static final int[] PESOS_CNPJ_DV1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] PESOS_CNPJ_DV2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	private ValidadorCpfCnpj() {
	}

	/**
	 * CPF v\u00e1lido = 11 d\u00edgitos numéricos, n\u00e3o todos iguais, e com os
	 * d\u00edgitos
	 * verificadores (posi\u00e7ões 10 e 11) batendo com o c\u00e1lculo.
	 */
	public static boolean ehCpfValido(String cpf) {
		if (!formatoBasicoOk(cpf, 11)) {
			return false;
		}
		// 1º d\u00edgito: pesos 10,9,8...2 sobre os 9 primeiros d\u00edgitos
		int dv1 = calcularDigito(cpf.substring(0, 9), 10);
		// 2º d\u00edgito: pesos 11,10,9...2 sobre os 9 primeiros + o 1º d\u00edgito
		int dv2 = calcularDigito(cpf.substring(0, 9) + dv1, 11);
		return cpf.charAt(9) - '0' == dv1 && cpf.charAt(10) - '0' == dv2;
	}

	/**
	 * CNPJ v\u00e1lido = 14 d\u00edgitos numéricos, n\u00e3o todos iguais, e com os
	 * d\u00edgitos
	 * verificadores (posi\u00e7ões 13 e 14) batendo com o c\u00e1lculo.
	 */
	public static boolean ehCnpjValido(String cnpj) {
		if (!formatoBasicoOk(cnpj, 14)) {
			return false;
		}
		int dv1 = calcularDigito(cnpj.substring(0, 12), PESOS_CNPJ_DV1);
		int dv2 = calcularDigito(cnpj.substring(0, 12) + dv1, PESOS_CNPJ_DV2);
		return cnpj.charAt(12) - '0' == dv1 && cnpj.charAt(13) - '0' == dv2;
	}

	/**
	 * Verifica\u00e7ões comuns: n\u00e3o nulo, tamanho certo, só n\u00fameros e
	 * n\u00e3o
	 * ser uma
	 * sequência repetida (ex.: "11111111111" passa na conta, mas é inv\u00e1lido).
	 */
	private static boolean formatoBasicoOk(String valor, int tamanho) {
		if (StringUtils.ehNuloOuBranco(valor)
				|| valor.length() != tamanho
				|| !StringUtils.temSomenteNumeros(valor)) {
			return false;
		}
		// Se todos os caracteres forem iguais ao primeiro, é inv\u00e1lido.
		return !valor.chars().allMatch(c -> c == valor.charAt(0));
	}

	/**
	 * Vers\u00e3o do CPF: pesos decrescentes a partir de pesoInicial (10 ou 11).
	 */
	private static int calcularDigito(String base, int pesoInicial) {
		int soma = 0;
		for (int i = 0; i < base.length(); i++) {
			soma += (base.charAt(i) - '0') * (pesoInicial - i);
		}
		return digitoDoResto(soma);
	}

	/** Vers\u00e3o do CNPJ: usa um vetor de pesos pronto. */
	private static int calcularDigito(String base, int[] pesos) {
		int soma = 0;
		for (int i = 0; i < base.length(); i++) {
			soma += (base.charAt(i) - '0') * pesos[i];
		}
		return digitoDoResto(soma);
	}

	/** Regra comum: resto < 2 vira 0; sen\u00e3o o d\u00edgito é 11 - resto. */
	private static int digitoDoResto(int soma) {
		int resto = soma % 11;
		return resto < 2 ? 0 : 11 - resto;
	}
}
