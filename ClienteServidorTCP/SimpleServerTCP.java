import java.io.*;
import java.net.*;

public class SimpleServerTCP {
	public static void main(String argv[]){
		ServerSocket listenSocket;

		String msgRequisicao;
		String msgResposta;

		try{
			listenSocket = new ServerSocket(2048);
			System.out.println("Esperando conexões");
			while(true){

				Socket conexao = listenSocket.accept();
				DataInputStream inFromClient = new DataInputStream(conexao.getInputStream());
				DataOutputStream outToClient = new DataOutputStream(conexao.getOutputStream());
				msgRequisicao = inFromClient.readUTF();
				
				System.out.println("O cliente " + conexao.getInetAddress().getHostName() + "enviou a mensagem: " + msgRequisicao);
				msgResposta = msgRequisicao.toUpperCase() + '\n';
				outToClient.writeUTF(msgResposta);
			conexao.close();	
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}