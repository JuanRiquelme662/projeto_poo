package br.edu.cs.poo.ac.seguro.mediators;

/**
 * Classe utilitária com métodos estáticos para tratar Strings.
*/
public class StringUtils {

	private StringUtils() {}

	/**
	 * Retorna true se a String for null, vazia ou só tiver espaços.
	 * Ex.: null -> true | "" -> true | "   " -> true | "ana" -> false
	 */
	public static boolean ehNuloOuBranco(String str) {
		// A ordem importa: se str for null, o "||" para na primeira condição
		// e nunca chama trim() (o que causaria NullPointerException).
		return str == null || str.trim().isEmpty();
	}

	/**
	 * Retorna true se TODOS os caracteres forem dígitos de 0 a 9.
	 * Decisão nossa (os testes não cobrem): null ou vazio -> false,
	 * porque "não há número nenhum" não deve contar como "só números".
	 *
	 * Usamos comparação com '0' e '9' em vez de Character.isDigit(), porque
	 * isDigit() também aceita dígitos de outros alfabetos (ex.: árabe).
	 */
	public static boolean temSomenteNumeros(String input) {
		if (input == null || input.isEmpty()) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}
