package controlls;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import models.Contato;

@ManagedBean
public class ContatosBean {
	
	private Contato contato;
	
	@ManagedProperty(value="#{repositorio}")
	private Repositorio repositorio;
	private Contato contato2;

	public ContatosBean() {
		this.contato = new Contato();
		this.contato2 = new Contato();
	}
	public String insere() {

		repositorio.getContatos().add(this.contato);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
				(FacesMessage.SEVERITY_INFO, "CONTATO INSERIDO COM SUCESSO!!!!", null));
		return "/app/lista?faces-redirect=true";
	}
	
	public String editar(){
		
		System.out.println("O ID A SER EDITADO É: " + contato2.getId());
		
		for(int i=0;i<repositorio.contatos.size();i++){
			int comp1 = repositorio.contatos.get(i).getId();
			int comp2 = contato2.getId();
			if(comp2 == comp1){
				System.out.println("O ID DA POSICAO I É" + repositorio.contatos.get(i).getId());
				
				repositorio.contatos.get(i).setNome(contato2.getNome());
				repositorio.contatos.get(i).setEmail(contato2.getEmail());
				repositorio.contatos.get(i).setTelefone(contato2.getTelefone());
				
				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.setKeepMessages(true);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
						(FacesMessage.SEVERITY_INFO, "CONTADO EDITADO COM SUCESSO!!!!", null));
			}
		}	
		return "/app/lista?faces-redirect=true";
	}
	public String deletar2(){
		System.out.println("O ID A SER EXLCUIDO É" + contato2.getId());
		
		int comp1 = contato2.getId();
		
		for(int i=0;i<repositorio.contatos.size();i++){
			if(comp1 == (repositorio.contatos.get(i).getId())){
				System.out.println("O ID DA POSICAO I É" + repositorio.contatos.get(i).getId());
				repositorio.contatos.remove(i);
				
				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.setKeepMessages(true);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
						(FacesMessage.SEVERITY_INFO, "CONTADO APAGADO COM SUCESSO!!!!", null));
				return "/app/lista?faces-redirect=true";
			}
		}	
		
		return "/app/lista?faces-redirect=true";
	}
	
	public Contato getContato2() {
		return contato2;
	}
	public void setContato2(Contato contato2) {
		this.contato2 = contato2;
	}
		public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public Repositorio getRepositorio(){
		return repositorio;
	}
	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}
	
}
