/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;

import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            while(true){
                
                // classe de leitura
                Scanner sc = new Scanner(System.in);
                String msg = sc.nextLine();
                
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
    
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
                
                
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                
                byte[] buf1 = new byte[20];
                is.read(buf1); // Operação bloqueante (aguardando chegada de dados)
                
                System.out.println("[OK] ]");
                
                
                
                String msg1 = new String(buf1); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: "+ msg1);
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}