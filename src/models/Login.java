package models;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import controlls.Repositorio;

@ManagedBean
public class Login implements Serializable{
	private static final long serialVersionUID = 9108781020220176401L;
	private String nome;
	private String password;
	
	public Login(){
		HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (s != null){
			s.invalidate();
		}
	}
	
	public String loginBean(){

		HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(nome.equals("marcio") && password.equals("123")){
			if(s == null){
				s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			}
			s.setAttribute("nome", nome);
			return "/index?faces-redirect=true";
		}else{
			if(s != null){
				s.invalidate();
			}
		}
		return "/login";
	}
	
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
