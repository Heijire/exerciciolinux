package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class DistroController {
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	public void exibeDistro() {
		String sistema = os();
		if(sistema.contains("Linux")) {
			try {
				Process proc = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("PRETTY_NAME=") ) {
						String[] nome = linha.split("PRETTY_NAME=");
						System.out.println("Nome e Versao da distribuicao: " + nome[1]);
					}
				linha = buffer.readLine();				
				}
			} catch (IOException e) {
				e.printStackTrace();
				}
			} else {
			System.out.println("Esse SO nao roda o programa desejado");
		}
	}
}
