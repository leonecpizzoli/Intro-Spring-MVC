package br.com.hard.mvc.domain;

public enum TipoSexo {
	FEMININO('F'), MASCULINO('M');

	private char descricao;

	private TipoSexo(char descricao) {
		this.descricao = descricao;
	}

	public char getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
