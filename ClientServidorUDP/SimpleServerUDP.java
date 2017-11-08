import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class SimpleServerUDP {
	public static void main(String args[]){
		
	System.out.println("Servidor em execução!");	
	SimpleDateFormat seila = new SimpleDateFormat("HH: mm: ss");
	Date hora = Calendar.getInstance().getTime();
	String DataForm = seila.format(hora);
	
		DatagramSocket servidor = null;
		
	try{
		servidor = new DatagramSocket(5000);
		byte[] receiveData = new byte[1024];

		int id = 0;
		while(true){
			id++;
			
			//System.out.println("Esperando mensagem " + id + "...");	
			DatagramPacket request = new DatagramPacket(receiveData, receiveData.length);
			servidor.receive(request);
			String sentence = new String(request.getData(), 0, request.getLength());
			if(!sentence.equals("reqnum") && (!sentence.equals("uptime"))){
			System.out.println("Cliente: " + request.getAddress().getHostAddress() + " - Porta: " + request.getPort());
				System.out.println("Mensagem: " + sentence);
			}else{
				if(sentence.equals("reqnum")){
			System.out.println("Requisições: " +id);
				}
			}
			if(sentence.equals("uptime")){
				System.out.println("Servidor iniciado às: " + DataForm  + "\n");
				
//				SimpleDateFormat qq = new SimpleDateFormat("HH: mm: ss");
//				Date horaFim = Calendar.getInstance().getTime();
//				String  Dta = qq.format(horaFim);
//				System.out.println(Dta);	
			}
		}
		}catch(SocketException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace(); 
		}finally{
			if(servidor != null){
				servidor.close();
			}
		}
	}
}
