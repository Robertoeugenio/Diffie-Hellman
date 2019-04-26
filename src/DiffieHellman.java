import java.io.*;
import java.math.BigInteger;

public class DiffieHellman {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // fazer leitura

		System.out.println("Sara, por favor digite um numero primo Exemplo 13): "); // entrada da sara
		BigInteger numeroASara = new BigInteger(br.readLine()); // entrada caso seja numero grande

		while (numeroASara.isProbablePrime(1) == false) { // verifica��o pra saber se � primo ou n�o
			System.out.println("Este numero " + numeroASara + " n�o � primo : ");
			System.out.println("Sara, por favor digite um numero primo Exemplo, 13): ");
			numeroASara = new BigInteger(br.readLine()); // entrada numero da sara
		}

		System.out.println("Sara , digite outro numero  menor que: " + numeroASara);
		BigInteger numeroBSara = new BigInteger(br.readLine()); // fazendo leitura com novo dado
		while (numeroBSara.compareTo(numeroASara) >= 0) { // fazendo compara�ao
			System.out.println("O  numero " + numeroBSara + " n�o �  menor que " + numeroASara);
			System.out.print("Sara, digite outro numero  menor que: " + numeroASara);
			numeroBSara = new BigInteger(br.readLine()); // fazendo leitura
		}

		System.out.println("Sara, digite um numero secreto, menor que " + numeroASara);
		BigInteger numeroSecretoXSara = new BigInteger(br.readLine());
		while (numeroSecretoXSara.compareTo(numeroASara) >= 0) { // fazendo compara��o
			System.out.println("O  numero " + numeroSecretoXSara + " n�o �  menor que " + numeroASara);
			System.out.println("Sara, digite un numero secreto, menor que " + numeroASara);
			numeroSecretoXSara = new BigInteger(br.readLine());
		}

		// numeroA ^ numeroSecretoX mod numeroB
		BigInteger R1 = numeroBSara.modPow(numeroSecretoXSara, numeroASara);

		System.out.println("R1=" + R1);

		System.out.println("Roberto, digite un numero secreto menor que " + numeroASara);
		BigInteger numeroSecretoRoberto = new BigInteger(br.readLine());
		while (numeroSecretoRoberto.compareTo(numeroASara) >= 0) {
			System.out.println("O numero " + numeroSecretoRoberto + " n�o � menor que " + numeroASara);
			System.out.println("Roberto, digite um  numero secreto menor que " + numeroASara);
			numeroSecretoRoberto = new BigInteger(br.readLine());
		}
		// numeroA^numeroSecretoRoberto mod numeroB
		BigInteger R2 = numeroBSara.modPow(numeroSecretoRoberto, numeroASara);

		// numeroASara^numeroSecretoXSara mod R2
		System.out.println("R2=" + R2);
		BigInteger k1 = R2.modPow(numeroSecretoXSara, numeroASara);

		System.out.println("A chave calculada para Sara � : " + k1);
		BigInteger k2 = R1.modPow(numeroSecretoRoberto, numeroASara);

		System.out.println("A chave calculada para Roberto � : " + k2);
		if (k1.compareTo(k2) == 0) {
			System.out.println("Ambas chaves calculadas s�o iguais, todo a funcionado est� correto");
		} else {
			System.out.println("Aten��o ! Aten��o ! Ocorreu erro grave por favor Digite valores diferentes ");
		}
	}
}
