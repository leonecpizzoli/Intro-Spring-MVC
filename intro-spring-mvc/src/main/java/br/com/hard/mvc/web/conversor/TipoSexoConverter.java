package br.com.hard.mvc.web.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.hard.mvc.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String, TipoSexo>{

	@Override
	public TipoSexo convert(String valorTexto) {
		char tipoSexo = valorTexto.charAt(0);
		return tipoSexo == TipoSexo.FEMININO.getDescricao() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
	}
	

}
