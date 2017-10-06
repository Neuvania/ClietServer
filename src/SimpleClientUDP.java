import java.io.*;
import java.net.*;

public class SimpleClientUDP {
	public static void main(String args[]){
		
		DatagramSocket cliente = null;
		
		try{
			cliente = new DatagramSocket();
			String mensagem = "uptime";
			byte[] sendArray = mensagem.getBytes();
			String ipServidor = "127.0.0.1";
			InetAddress IpServidor = InetAddress.getByName(ipServidor);
			int porta = 5000;
			DatagramPacket sendPacket = new DatagramPacket(sendArray, sendArray.length, IpServidor, porta);
			cliente.send(sendPacket);
			System.out.println("Pacote Enviado!");
			
		}catch(SocketException e){
			e.printStackTrace();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(cliente != null){
				cliente.close();
			}
		}
	}
}
