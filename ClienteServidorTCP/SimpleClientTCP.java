import java.io.*;
import java.net.*;

public class SimpleClientTCP {
	public static void main(String argv[]){
		String requisicao;
		String resposta;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket cliente;
		try{
			cliente = new Socket("localhost", 6789);
			DataOutputStream outToServer = new DataOutputStream(cliente.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(cliente.getInputStream());
			System.out.println("Escreva a mensagem a ser enviada");
			requisicao = inFromUser.readLine();

			outToServer.writeUTF(requisicao + '\n');
			resposta = inFromServer.readUTF();
			System.out.println("FROM SERVER: " + resposta);		
			
		cliente.close();


		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
