package src.Main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoServidorItf extends Remote {

    public int informaIdJogador() throws RemoteException;
    public void enviaJogada(int n, int idJogador) throws RemoteException;
    public void enviaMensagem(String msg, int idJogador) throws RemoteException;
    public void informaLocalizacao(String localizacao, int idJogador) throws RemoteException;

}