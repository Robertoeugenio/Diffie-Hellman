import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

/*  Roberto Eugenio dos Santos */

public class AlgoritmoRabin {

	public boolean Primo(long numeroEntrada, int interacao) {
		
		if (numeroEntrada == 0 || numeroEntrada == 1) //if para verifica��o do numero se � primo ou n�o 
			return false;

		if (numeroEntrada == 2)
			return true;
		
		/** se entrar n�o � primo */
		if (numeroEntrada % 2 == 0)
			return false;

		
		long s = numeroEntrada - 1;
		while (s % 2 == 0)
			s /= 2;

		Random rand = new Random(); 
		for (int i = 0; i < interacao; i++) {
			long r = Math.abs(rand.nextLong());
			long a = r % (numeroEntrada - 1) + 1, temp = s;
			long mod = modPow(a, temp, numeroEntrada);
			while (temp != numeroEntrada - 1 && mod != 1 && mod != numeroEntrada - 1) {
				mod = mulMod(mod, mod, numeroEntrada);
				temp *= 2;
			}
			if (mod != numeroEntrada - 1 && temp % 2 == 0)
				return false;
		}
		return true;
	}

	/** calculo da fun��o para a eque��o (a ^ b) % c **/
	public long modPow(long a, long b, long c) {
		long res = 1;
		for (int i = 0; i < b; i++) {
			res *= a;
			res %= c;
		}
		return res % c;
	}

	/** calculo da fun��o (a * b) % c **/
	public long mulMod(long a, long b, long mod) {
		return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entre com numero para efetuar o teste\n");
		AlgoritmoRabin mr = new AlgoritmoRabin();

		System.out.println("Digite o N�mero \n");
		long num = scan.nextLong();

		System.out.println("\n Entre coma  quantidade de intera��es");
		int k = scan.nextInt();
		/** check if prime **/
		boolean prime = mr.Primo(num, k);
		if (prime)
			System.out.println("\n" + num + "  � um numero primo");
		else
			System.out.println("\n" + num + " is composite");

	}
}