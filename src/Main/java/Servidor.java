package src.Main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements ServicoServidorItf{

    private int qtdJogadores;
    private ServicoJogadorItf jogador1;
    private ServicoJogadorItf jogador2;

    public Servidor() throws RemoteException {
        super();
        System.out.println("----- Servidor -----");
        //Inicializa variáveis usada para comunicação entre os clientes
        qtdJogadores = 0;

    }

    @Override
    public void enviaMensagem(String msg, int idJogador) throws RemoteException {
        if(idJogador == 1){
            jogador1.atualizaChat(msg);
        }else{
            jogador2.atualizaChat(msg);
        }
    }

    @Override
    public void enviaJogada(int n, int idJogador) throws RemoteException {
        if(idJogador == 1){
            jogador1.atualizaTurno(n);
        }else{
            jogador2.atualizaTurno(n);
        }
    }

    @Override
    public int informaIdJogador() throws RemoteException {

        if(qtdJogadores < 2){
            qtdJogadores++;
            System.out.println("Jogador #" + qtdJogadores + " se conectou");

            if(qtdJogadores == 2){
                //Não aceita mais conexões
                System.out.println("Os 2 jogadores já se conectaram.");
                /* Após os dois jogadores se conectarem, o primeiro jogador a se conectar
                  recebe uma mensagem "/i" que permite o início do jogo*/
                enviaMensagem("/i", 1);
                //qtdJogadores = 0;
            }

            return qtdJogadores;
        }else{
            System.out.println("ERRO: Reinicie o servidor");
            return -1;
        }

    }

    @Override
    public void informaLocalizacao(String localizacao, int idJogador) throws RemoteException {
        try {
            //Armazena nos atributos locais onde está cada jogador
            if(idJogador == 1){
                jogador1 = (ServicoJogadorItf) Naming.lookup(localizacao);
            }else if(idJogador == 2){
                jogador2 = (ServicoJogadorItf) Naming.lookup(localizacao);
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws RemoteException{
        Servidor servidor = new Servidor();
        String localizacao = "//localhost/servicoServidor";
        try {
            /*
                - Antes de executar o servidor execute o rmiregistry dentro do
                diretório de classes: tsoroyematatu\target\classes

                1) Abrir terminal e navegar até o Path:
                        cd (Diretório do projeto)/tsoroyematatu/target/classes

                2) Digitar comando dentro do diretório para executar o RMIRegistry
                        rmiregistry

            */

            Naming.rebind(localizacao, servidor);
            System.out.println("Aguardando Clientes!");
        } catch (RemoteException ex) {
            mostrarErro(ex, servidor, localizacao);
        } catch (MalformedURLException ex) {
            System.out.println("Erro de url mal formado:" + ex.getMessage());
        }
    }

    public static void mostrarErro(RemoteException r, Servidor s, String l){
        try {
            //TESTES DE DESENVOLVIMENTO - IGNORE
            LocateRegistry.createRegistry(1099);
            Naming.rebind(l, s);
            System.out.println("Aguardando Clientes!");
        } catch (RemoteException | MalformedURLException ex) {
            System.out.print("Confira se a execução o rmiregistry está dentro do ");
            System.out.println("diretório de classes: tsoroyematatu\\target\\classes");
            System.out.println("ERRO: Reinicie o servidor");
        }
    }

}
