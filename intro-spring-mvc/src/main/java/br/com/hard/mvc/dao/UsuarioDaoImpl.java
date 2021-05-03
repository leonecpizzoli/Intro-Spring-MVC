package br.com.hard.mvc.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.hard.mvc.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> usuarios;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
	private List<Usuario> createUserList() {
		if(usuarios == null){
			usuarios = new LinkedList<>();
			usuarios.add(new Usuario(System.currentTimeMillis()+1L,"Ana","da Silva"));
			usuarios.add(new Usuario(System.currentTimeMillis()+2L,"Luiz","dos Santos"));
			usuarios.add(new Usuario(System.currentTimeMillis()+3L,"Mariana","Mello"));
			usuarios.add(new Usuario(System.currentTimeMillis()+4L,"Caren","Pereira"));
			usuarios.add(new Usuario(System.currentTimeMillis()+5L,"Sonia","Fagundes"));
			usuarios.add(new Usuario(System.currentTimeMillis()+6L,"Norberto","de Souza"));
		}
		return usuarios;
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		usuarios.add(usuario);		
	}

	@Override
	public void editar(Usuario usuario) {
		usuarios.stream().filter((user) -> user.getId().equals(usuario.getId()))
		.forEach((user) -> {
			user.setNome(usuario.getNome());
			user.setSobrenome(usuario.getSobrenome());
		});
		
	}

	@Override
	public void excluir(Long id) {
		usuarios.removeIf((user) -> user.getId().equals(id));
	}

	@Override
	public Usuario getId(Long id) {
		return usuarios.stream()
				.filter((user) -> user.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		return usuarios;
	}

}
