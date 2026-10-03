package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoPessoaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;

public class SeguradoPessoaMediator {

	// Singleton: a \u00fanica instância fica guardada aqui.
	private static final SeguradoPessoaMediator instancia = new SeguradoPessoaMediator();

	private SeguradoMediator seguradoMediator = SeguradoMediator.getInstancia();
	private SeguradoPessoaDAO dao = new SeguradoPessoaDAO();

	private SeguradoPessoaMediator() {
	}

	public static SeguradoPessoaMediator getInstancia() {
		return instancia;
	}

	public String validarCpf(String cpf) {
		if (StringUtils.ehNuloOuBranco(cpf)) {
			return "CPF deve ser informado";
		}
		if (cpf.length() != 11) {
			return "CPF deve ter 11 caracteres";
		}
		// Chegando aqui o tamanho est\u00e1 certo; falta conferir se os numeros tao
		// certos.
		if (!ValidadorCpfCnpj.ehCpfValido(cpf)) {
			return "CPF com d\u00edgito inv\u00e1lido";
		}
		return null;
	}

	// Renda pode ser zero; só negativa é erro.
	public String validarRenda(double renda) {
		if (renda < 0) {
			return "Renda deve ser maior ou igual \u00e0 zero";
		}
		return null;
	}

	/**
	 * Valida TODOS os campos do segurado pessoa e devolve o primeiro erro
	 */
	public String validarSeguradoPessoa(SeguradoPessoa seg) {
		if (seg == null) {
			return "Segurado pessoa deve ser informado";
		}

		String msg = seguradoMediator.validarNome(seg.getNome());
		if (msg != null) {
			return msg;
		}
		msg = seguradoMediator.validarEndereco(seg.getEndereco());
		if (msg != null) {
			return msg;
		}

		if (seg.getDataNascimento() == null) {
			return "Data do nascimento deve ser informada";
		}
		msg = seguradoMediator.validarDataCriacao(seg.getDataNascimento());
		if (msg != null) {
			return msg;
		}

		// Campos espec\u00edficos de pessoa
		msg = validarCpf(seg.getCpf());
		if (msg != null) {
			return msg;
		}
		return validarRenda(seg.getRenda());
	}

	public String incluirSeguradoPessoa(SeguradoPessoa seg) {
		String msg = validarSeguradoPessoa(seg);
		if (msg != null) {
			return msg;
		}
		// dao.incluir devolve false quando o CPF j\u00e1 est\u00e1 cadastrado
		if (!dao.incluir(seg)) {
			return "CPF do segurado pessoa j\u00e1 existente";
		}
		return null;
	}

	public String alterarSeguradoPessoa(SeguradoPessoa seg) {
		String msg = validarSeguradoPessoa(seg);
		if (msg != null) {
			return msg;
		}
		// dao.alterar devolve false quando o CPF NÃO est\u00e1 cadastrado
		if (!dao.alterar(seg)) {
			return "CPF do segurado pessoa n\u00e3o existente";
		}
		return null;
	}

	public String excluirSeguradoPessoa(String cpf) {
		// NÃO validamos o CPF aqui de propósito: o teste test16 exclui o CPF
		// "07255432089" (d\u00edgito inv\u00e1lido) e espera a mensagem de "n\u00e3o
		// existente".
		// Para excluir basta o DAO dizer se existe ou n\u00e3o.
		if (!dao.excluir(cpf)) {
			return "CPF do segurado pessoa n\u00e3o existente";
		}
		return null;
	}

	// Busca é só repassar para o DAO. Devolve null se n\u00e3o achar.
	public SeguradoPessoa buscarSeguradoPessoa(String cpf) {
		return dao.buscar(cpf);
	}
}
