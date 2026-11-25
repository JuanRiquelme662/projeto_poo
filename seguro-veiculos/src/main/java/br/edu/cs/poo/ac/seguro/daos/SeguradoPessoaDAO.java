package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;

/*
 * As classes Segurado e SeguradoPessoa devem implementar Serializable.
 */
public class SeguradoPessoaDAO extends DAOGenerico {

	@Override
	public Class getClasseEntidade() {
		return SeguradoPessoa.class;
	}

	@Override
	public SeguradoPessoa buscar(String cpf) {
		return (SeguradoPessoa) super.buscar(cpf);
	}
}
