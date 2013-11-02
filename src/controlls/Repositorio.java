package controlls;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Contato;

@ManagedBean
@SessionScoped
/*
 * para o id permanecer em ordem correta 1 segudo do outro deve ser usado @ViewEscoped
 * é necessario a serialização do bean
 * */
public class Repositorio {

	public Repositorio() {
		
	}
	List<Contato> contatos = new ArrayList<Contato>();
	

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String insere(Contato c) {
		contatos.add(c);
		return "lista";
	}

}
