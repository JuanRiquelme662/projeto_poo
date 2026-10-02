package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.mediators.StringUtils;

public class ValidadorCpfCnpj {

	private static boolean ehNumeroValido(String numero){
		char caractere = numero.charAt(0);
		boolean temDigitosDiferentes = false;
		for(int i = 1; i < numero.length(); i++){
			char caractereComparativo = numero.charAt(i);
			if(caractereComparativo != caractere){
				temDigitosDiferentes = true;
				break;
			}
		}
		return temDigitosDiferentes;
	}

	public static boolean ehCnpjValido(String cnpj) {
		//faz as checagens de nulo, vazio, somente numeros e tamanho
		if(StringUtils.ehNuloOuBranco(cnpj) || !StringUtils.temSomenteNumeros(cnpj) || cnpj.length() != 14 || !ehNumeroValido(cnpj)){
			return false;
		}else{
			return true;
		}
	}
	public static boolean ehCpfValido(String cpf) {
		//faz as checagens de nulo, vazio, somente numeros e tamanho so que do cpf
		if(StringUtils.ehNuloOuBranco(cpf) || !StringUtils.temSomenteNumeros(cpf) || cpf.length() != 11 || !ehNumeroValido(cpf)){
			return false;
		}else{
			return true;
		}
	}
}
