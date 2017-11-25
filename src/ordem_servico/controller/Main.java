package ordem_servico.controller;

import ordem_servico.model.Os;
import ordem_servico.model.OsSoftware;
import ordem_servico.view.OsView;
import ordem_servico.view.PrincipalView;

public class Main {
    public static void main(String[] args) {
        //new PrincipalView().setVisible(true);  
        //Os os = new Os();
        //os.setIdCliente(1);
        //os.setIdUsuario(1);
        //os.setPrazo("22/03/2017");
        //os.setIdTipo(2);
        //os.setTitulo("TITULO");
        //os.insertOs();
        //OsSoftware osS = new OsSoftware();
        //osS.setGitLink("www");
        //osS.insertOsSoftware();
        new OsController();
    } 
}
