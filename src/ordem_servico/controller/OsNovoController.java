/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_servico.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import ordem_servico.model.Cliente;
import ordem_servico.model.Os;
import ordem_servico.model.OsHardware;
import ordem_servico.model.OsResponsavel;
import ordem_servico.model.OsSoftware;
import ordem_servico.view.OsNovoView;

/**
 *
 * @author matheus
 */
public class OsNovoController {
    private OsNovoView osNovoView;
    private Os os;
    private Cliente cliente;
    
    public OsNovoController(OsNovoView v){
        osNovoView = v;
        os = new Os();
        osNovoView.setVisible(true);
        osNovoView.setLocationRelativeTo(null);
        osNovoView.getPanelHardware().setVisible(false);
        osNovoView.getPanelSoftware().setVisible(true);
    }
    
    public void carregarInformacoes(Integer idCliente){
        cliente = new Cliente(idCliente);
        osNovoView.getLbId().setText(idCliente.toString());
        osNovoView.getLbNomeCliente().setText(cliente.getNome());
    }
    
    private boolean cadastrarOs(){
        try{
            os = new Os();
            OsResponsavel osResponsavel = new OsResponsavel();
            SimpleDateFormat dt = new SimpleDateFormat( "dd/MM/yyyy" );
            os.setDataAbertura(dt.format(new Date()));   
            os.setIdCliente(cliente.getId());
            os.setPrazo(osNovoView.getTxtPrazo().getText());
            os.setServico(osNovoView.getTxtServico().getText());
            os.setTitulo(osNovoView.getTxtTitulo().getText());
            os.setTotal(Float.parseFloat(osNovoView.getTxtTotal().getText()));
            os.setIdUsuario(Integer.parseInt(System.getProperty("idUsuario")));
            
            if(osNovoView.getListTipo().getSelectedItem().toString().equals("Hardware")){
                os.setIdTipo(1);
                os.insertOs();
                OsHardware osH = new OsHardware();
                osH.setId(os.getId());
                osH.setMaoObra(Float.parseFloat(osNovoView.getTxtMaoObra().getText()));
                osH.setReclamacao(osNovoView.getTxtReclamacao().getText());
                if (osH.insertOsHardware()){
                    osResponsavel.setData(dt.format(new Date()));
                    osResponsavel.setIdOs(os.getId());
                    osResponsavel.setIdUsuario(Integer.parseInt(System.getProperty("idUsuario")));
                    osResponsavel.insertOsResponsavel();
                    return true;
                }
            }else{
                os.setIdTipo(2);
                os.insertOs();
                OsSoftware osS = new OsSoftware();
                osS.setId(os.getId());
                osS.setGitLink(osNovoView.getTxtGit().getText());
                if (osS.insertOsSoftware()){
                    osResponsavel.setData(dt.format(new Date()));
                    osResponsavel.setIdOs(os.getId());
                    osResponsavel.setIdUsuario(Integer.parseInt(System.getProperty("idUsuario")));
                    osResponsavel.insertOsResponsavel();
                    return true;
                }
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar OS, verifique se os campos estão corretamente formatados. Para nerds: "+ e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro geral ao cadastrar. Para nerds: "+ e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    public void btnCadastrarClick(){
        if(cadastrarOs()){
            JOptionPane.showMessageDialog(null, "OS cadastrada com sucesso.", "Feito", JOptionPane.INFORMATION_MESSAGE);
            osNovoView.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a Ordem de Serviço. Tente novamente mais tarde", "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void listChange(){
        String txt = osNovoView.getListTipo().getSelectedItem().toString();
        if(txt.equals("Hardware")){
            osNovoView.getPanelHardware().setVisible(true);
            osNovoView.getPanelSoftware().setVisible(false);
        }
        if(txt.equals("Software")){
            osNovoView.getPanelHardware().setVisible(false);
            osNovoView.getPanelSoftware().setVisible(true);
        }
    }
}
