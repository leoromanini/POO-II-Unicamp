package ordem_servico.controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Cliente;
import ordem_servico.view.ClienteView;

public class ClienteController {

    private Cliente cliente;
    private ClienteView clienteView;

    public ClienteController(ClienteView v) {
        clienteView = v;
        clienteView.setVisible(true);
    }

    private void setTableModel() {
        JTable clienteTable = clienteView.getClienteTable();
        DefaultTableModel modeloTable = (DefaultTableModel) clienteTable.getModel();
        modeloTable.addColumn("ID");
        modeloTable.addColumn("Nome");
        modeloTable.addColumn("Nascimento");
        modeloTable.addColumn("Endereço");
        //ArrayList<Cliente> listClientes = buscarTodosClientes();
        //for (Cliente c : listClientes) {
        //    modeloTable.addRow(new Object[]{c.getId(), c.getNome(), c.getNascimento(), c.getEndereco()});
        //}
        clienteTable.setModel(modeloTable);
    }

    private boolean validarCampos() {
        // Verifica se não há campos nulos
        if (cliente.getNome() != null && cliente.getNascimento() != null && cliente.getCpf() != null && cliente.getTelefone() != null
                && cliente.getCelular() != null && cliente.getEndereco() != null) {
            // Verifica se valores estão dentro dos intervalos
            if (cliente.getNascimento().matches("[0-3][0-9]/[0-1][0-9]/[0-9]{4}") && cliente.getCpf().length() >= 14 && cliente.getTelefone().length() >= 11
                    && cliente.getCelular().length() >= 11 && cliente.getEndereco().length() >= 15) {
                return true;
            }
        }
        return false;
    }

    public String cadastrarCliente(String nome, String nascimento, String cpf, String telefone, String celular, String endereco) {
        cliente = new Cliente();
        cliente.setCelular(celular);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setNascimento(nascimento);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        if (validarCampos()) {
            if (cliente.insertCliente()) {
                return "ok";
            } else {
                return "Houve um problema ao inserir Cliente";
            }
        } else {
            return "Campos inválidos";
        }
    }

    public String excluirCliente(Integer id, String nome) {
        if (id > 0) {
            cliente = new Cliente(id);
            if (cliente.getNome().equals(nome)) {
                if (cliente.deleteCliente()) {
                    return "ok";
                } else {
                    return "Houve um problema ao excluir Cliente";
                }
            } else {
                return "Nome do cliente não corresponde ao cliente selecionado";
            }
        } else {
            return "Codigo do cliente é inválido";
        }
    }

    public String atualizarCliente(Integer id, String nome, String nascimento, String cpf, String telefone, String celular, String endereco) {
        if (id > 0) {
            cliente = new Cliente(id);
            cliente.setCelular(celular);
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setNascimento(nascimento);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            if (validarCampos()) {
                if (cliente.updateCliente()) {
                    return "ok";
                } else {
                    return "Houve um problema ao atualizar Cliente";
                }
            } else {
                return "Campos inválidos";
            }
        } else {
            return "Codigo do Cliente é inválido";
        }
    }

    public Cliente buscarCliente(Integer id) {
        if (id > 0) {
            cliente = new Cliente(id);
        } else {
            cliente = new Cliente();
        }
        return cliente;
    }

    public ArrayList<Cliente> buscarTodosClientes() {
        cliente = new Cliente();
        ArrayList<Cliente> listClientes;
        listClientes = cliente.selectAll();
        return listClientes;
    }

    public ArrayList<Cliente> buscarClientesByNome(String nome) {
        cliente = new Cliente();
        DefaultTableModel modeloTable = (DefaultTableModel) clienteView.getClienteTable().getModel();
        for (Cliente c : cliente.selectByNome(nome)) {
           modeloTable.addRow(new Object[]{c.getId(), c.getNome(), c.getNascimento(), c.getEndereco()});
        }
    }
}
