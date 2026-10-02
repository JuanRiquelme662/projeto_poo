package br.edu.cs.poo.ac.seguro.mediators;

public class StringUtils {
	private StringUtils() {}
	public static boolean ehNuloOuBranco(String str) {
		// checa se a string ta vazia ou nula
		if (str == null || str.trim().isEmpty()) {
			return true;
		}else{
			return false;	
		}
	}
    public static boolean temSomenteNumeros(String input) {
		//verifica se ele e nulo ou vazio
		if (input == null || input.isEmpty()) {
			return false;
		} else {
			int i = 0;
			char caractere = input.charAt(i);
			//trocar o while por um for para deixar o codigo mais claro
			while (i < input.length() && Character.isDigit(caractere) ){
				caractere = input.charAt(i);
				i++;
			}
			if(Character.isDigit(caractere) == false){
				return false;
			}else{
				return true;
			}
		}
	}
}
