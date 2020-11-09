
import com.saicoop.modelo.ejb.faSe.general.UsuariosFacade;
import com.saicoop.modelo.ejb.util.JpaUtil;
import javax.persistence.EntityManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilmer
 */
public class TestCon {
    public static void main(String[] args) {
        UsuariosFacade us=new UsuariosFacade();
        System.out.println("Usuarios:"+us.buscaUsuario(999));        
    }
 
    
      
}
