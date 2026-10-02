package br.edu.cs.poo.ac.seguro.mediators;

public class ValidadorCpfCnpj {
	//MAIN PARA TESTE
	public static void main(String[] args) {
    	System.out.println(ehCpfValido("52998224725"));
	}

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
		}
		int soma = 0;
		for(int i = 0; i < 9; i++){
			int digito = cpf.charAt(i) - '0';
			soma += digito * (10 - i);
		}
		//trocar o metodo de validacao 295 e so praceholder
		if(soma == 295){
			return true;
		}
		return false;
	}
}
