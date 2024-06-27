/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.negocio;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Hermyson
 */
@ManagedBean
public class Login {
    private String login;
    private String senha;
    
    public String autenticar(){
        
        return "menuGeral.xhtml";
        
    }

    public String getLogin() {
        return login;
    }
      
}
