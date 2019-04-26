import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;
 
//Classe MillerRabin
public class RabinKarp{
    //Função para checar se é primo ou não
    public boolean ehPrimo(long n, int interacao){
        if (n == 0 || n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
 
        long s = n - 1;
        while (s % 2 == 0)
            s /= 2;
 
        Random rand = new Random();
        for (int i = 0; i < interacao; i++){
            long r = Math.abs(rand.nextLong());            
            long a = r % (n - 1) + 1, temp = s;
            long mod = modPow(a, temp, n);
            while (temp!=n-1 && mod!=1 && mod!=n-1){
                mod = mulMod(mod, mod, n);
                temp *= 2;
            }
            if (mod!=n-1 && temp%2==0)
                return false;
        }
        return true;        
    }
    //Função para calcular (a^b)%c
    public long modPow(long a, long b, long c){
        long res = 1;
        for (int i = 0; i < b; i++){
            res *= a;
            res %= c; 
        }
        return res % c;
    }
    //Função para calcular (a*b)%c
    public long mulMod(long a, long b, long mod){
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Miller Rabin Primality Algorithm Test\n");
        //Cria um objeto da classe MillerRabin
        RabinKarp mr = new RabinKarp();
        //Entra o número para teste
        System.out.print("Entre um número: ");
        long num = scan.nextLong();
        //Entra o número de interações para teste
        System.out.print("\nEntre com o número de interações: ");
        int k = scan.nextInt();
        //Checa se é primo
        boolean prime = mr.ehPrimo(num, k);
        if (prime)
            System.out.println("\n"+ num +" é primo");
        else
            System.out.println("\n"+ num +" é composite");
    }
}