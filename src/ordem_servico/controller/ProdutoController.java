package ordem_servico.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Produto;
import ordem_servico.view.ProdutoView;

public class ProdutoController {
    private ProdutoView produtoView;
    private Produto produto;
    
    public ProdutoController(){
        produtoView = new ProdutoView();
        produtoView.setVisible(true);
    }
    
    public ProdutoController(ProdutoView v){
        produtoView = v;
        produto = new Produto();
        produtoView.getPanelDetalhes().setVisible(false);
        produtoView.getPanelNovo().setVisible(false);
        produtoView.setLocationRelativeTo(null);
        listarProdutos();
    }
    
    private boolean alterarProduto(){
        try{
            produto.setNome(produtoView.getTxtDetalhesNome().getText());
            produto.setPrecoSugerido(Float.parseFloat(produtoView.getTxtDetalhesPreco().getText()));
            produto.setQtd(Integer.parseInt(produtoView.getTxtDetalhesQuantidade().getText()));
            return produto.updateProduto();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto, formatos dos campos inválidos. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro geral ao alterar produto, formatos dos campos inválidos. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean cadastrarProduto(){
        try{
            produto.setNome(produtoView.getTxtNovoNome().getText());
            produto.setPrecoSugerido(Float.parseFloat(produtoView.getTxtNovoPreco().getText()));
            produto.setQtd(Integer.parseInt(produtoView.getTxtNovoQuantidade().getText()));
            return produto.insertProduto();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto, formatos dos campos inválidos. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro geral ao alterar produto. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean excluirProduto(){
        if(produto.getId() > 0){
            return produto.deleteProduto();
        }else{
            return false;
        }
    }
    
    private void listarProdutos(){
        try{
            ArrayList<Produto> list = produto.selectAll();
            DefaultTableModel model = (DefaultTableModel) produtoView.getTableProduto().getModel();
            model.setRowCount(0);
            for(Produto p : list){
                model.addRow(new Object[]{p.getId(),p.getNome(),p.getQtd(),p.getPrecoSugerido()});
            }
            produtoView.getTableProduto().setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao realizar busca de produtos. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro geral ao listar produtos. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    private void detalharProduto(Integer id){
        try{
            produto = new Produto(id);
            produtoView.getTxtDetalhesNome().setText(produto.getNome());
            produtoView.getTxtDetalhesPreco().setText(produto.getPrecoSugerido().toString());
            produtoView.getTxtDetalhesQuantidade().setText(produto.getQtd().toString());
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao detalhar produto. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro geral ao detalhar produto. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos(){
        produtoView.getTxtDetalhesNome().setText("");
        produtoView.getTxtDetalhesPreco().setText("");
        produtoView.getTxtDetalhesQuantidade().setText("");
        produtoView.getTxtNovoNome().setText("");
        produtoView.getTxtNovoPreco().setText("");
        produtoView.getTxtNovoQuantidade().setText("");
    }
    
    public void tableProdutoClick(java.awt.event.MouseEvent evt){
        if (evt.getClickCount() == 2) {
                Integer row = produtoView.getTableProduto().rowAtPoint(evt.getPoint());
                Integer id = (Integer) produtoView.getTableProduto().getValueAt(row, 0);
                limparCampos();
                detalharProduto(id);
                produtoView.getPanelDetalhes().setVisible(true);
                produtoView.getPanelNovo().setVisible(false);
        }
    }
    
    public void btnAlterarClick(){
        if(alterarProduto()){
            JOptionPane.showMessageDialog(null, "Produto alterado", "Feito!", JOptionPane.INFORMATION_MESSAGE);
            produtoView.getPanelDetalhes().setVisible(false);
            listarProdutos();
        }
    }
    
    public void btnExcluirClick(){
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse registro?")==0 && excluirProduto()){
            JOptionPane.showMessageDialog(null, "Produto Excluido", "Feito!", JOptionPane.INFORMATION_MESSAGE);
            produtoView.getPanelDetalhes().setVisible(false);
            listarProdutos();
        }
    }
    
    public void btnCadastrarClick(){
        if(cadastrarProduto()){
            JOptionPane.showMessageDialog(null, "Produto cadastrado", "Feito!", JOptionPane.INFORMATION_MESSAGE);
            produtoView.getPanelNovo().setVisible(false);
            limparCampos();
            listarProdutos();
        }
    }
    
    public void btnNovoClick(){
        limparCampos();
        produtoView.getPanelNovo().setVisible(true);
        produtoView.getPanelDetalhes().setVisible(false);
    }
    
    
}
