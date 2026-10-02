package br.edu.cs.poo.ac.seguro.mediators;

/**
 * Valida CPF e CNPJ pelo cálculo dos dois dígitos verificadores.
 * Só métodos estáticos, usados pelos mediators de pessoa e de empresa.
 *
 * Os dois algoritmos são irmãos: multiplica-se cada dígito por um "peso",
 * soma-se tudo, e o resto da divisão por 11 define o dígito verificador.
 * O 2º dígito é calculado igual ao 1º, só que incluindo o 1º dígito na conta.
 */
public class ValidadorCpfCnpj {

	// Pesos oficiais do CNPJ. O 1º dígito usa 12 números; o 2º usa 13.
	private static final int[] PESOS_CNPJ_DV1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	private static final int[] PESOS_CNPJ_DV2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

	private ValidadorCpfCnpj() {}

	/**
	 * CPF válido = 11 dígitos numéricos, não todos iguais, e com os dígitos
	 * verificadores (posições 10 e 11) batendo com o cálculo.
	 */
	public static boolean ehCpfValido(String cpf) {
		if (!formatoBasicoOk(cpf, 11)) {
			return false;
		}
		// 1º dígito: pesos 10,9,8...2 sobre os 9 primeiros dígitos
		int dv1 = calcularDigito(cpf.substring(0, 9), 10);
		// 2º dígito: pesos 11,10,9...2 sobre os 9 primeiros + o 1º dígito
		int dv2 = calcularDigito(cpf.substring(0, 9) + dv1, 11);
		return cpf.charAt(9) - '0' == dv1 && cpf.charAt(10) - '0' == dv2;
	}

	/**
	 * CNPJ válido = 14 dígitos numéricos, não todos iguais, e com os dígitos
	 * verificadores (posições 13 e 14) batendo com o cálculo.
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
	 * Verificações comuns: não nulo, tamanho certo, só números e não ser uma
	 * sequência repetida (ex.: "11111111111" passa na conta, mas é inválido).
	 */
	private static boolean formatoBasicoOk(String valor, int tamanho) {
		if (StringUtils.ehNuloOuBranco(valor)
				|| valor.length() != tamanho
				|| !StringUtils.temSomenteNumeros(valor)) {
			return false;
		}
		// Se todos os caracteres forem iguais ao primeiro, é inválido.
		return !valor.chars().allMatch(c -> c == valor.charAt(0));
	}

	/** Versão do CPF: pesos decrescentes a partir de pesoInicial (10 ou 11). */
	private static int calcularDigito(String base, int pesoInicial) {
		int soma = 0;
		for (int i = 0; i < base.length(); i++) {
			soma += (base.charAt(i) - '0') * (pesoInicial - i);
		}
		return digitoDoResto(soma);
	}

	/** Versão do CNPJ: usa um vetor de pesos pronto. */
	private static int calcularDigito(String base, int[] pesos) {
		int soma = 0;
		for (int i = 0; i < base.length(); i++) {
			soma += (base.charAt(i) - '0') * pesos[i];
		}
		return digitoDoResto(soma);
	}

	/** Regra comum: resto < 2 vira 0; senão o dígito é 11 - resto. */
	private static int digitoDoResto(int soma) {
		int resto = soma % 11;
		return resto < 2 ? 0 : 11 - resto;
	}
}
