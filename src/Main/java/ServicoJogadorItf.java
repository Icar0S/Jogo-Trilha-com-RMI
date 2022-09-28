package src.Main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoJogadorItf extends Remote {

    public void atualizaChat(String msg) throws RemoteException;
    public void atualizaTurno(int n) throws RemoteException;

}

