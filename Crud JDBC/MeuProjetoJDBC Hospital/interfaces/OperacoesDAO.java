package interfaces;

import java.util.ArrayList;


public interface OperacoesDAO<T> {

    public abstract void inserir(String nome, int idade, String cpf, String especialidade);

    public abstract ArrayList<T> listar();

    public abstract void consultaPorNome(String nomeBusca);

    public abstract void atualizar(int id, String nome, int idade, String cpf, String campoExtra);

    public abstract int deletar(int ID);
    
} 
   
   

  

