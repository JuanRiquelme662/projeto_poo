package br.edu.cs.poo.ac.seguro.mediators;

/**
 * Classe utilit\u00e1ria com métodos est\u00e1ticos para tratar Strings.
*/
public class StringUtils {

	private StringUtils() {}

	/**
	 * Retorna true se a String for null, vazia ou só tiver espa\u00e7os.
	 * Ex.: null -> true | "" -> true | "   " -> true | "ana" -> false
	 */
	public static boolean ehNuloOuBranco(String str) {
		// A ordem importa: se str for null, o "||" para na primeira condi\u00e7\u00e3o
		// e nunca chama trim() (o que causaria NullPointerException).
		return str == null || str.trim().isEmpty();
	}

	/**
	 * Retorna true se TODOS os caracteres forem d\u00edgitos de 0 a 9.
	 * Decis\u00e3o nossa (os testes n\u00e3o cobrem): null ou vazio -> false,
	 * porque "n\u00e3o h\u00e1 n\u00famero nenhum" n\u00e3o deve contar como "só n\u00fameros".
	 *
	 * Usamos compara\u00e7\u00e3o com '0' e '9' em vez de Character.isDigit(), porque
	 * isDigit() também aceita d\u00edgitos de outros alfabetos (ex.: \u00e1rabe).
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
