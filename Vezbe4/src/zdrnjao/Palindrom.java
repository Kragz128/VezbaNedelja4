package zdrnjao;
import java.util.Scanner;
//Da li je unesena tekst palindrom. Koristi StringBuilder i njegovu metodu reverse().

public class Palindrom {
	public static boolean isPalindrom(String recenica) {
		StringBuilder sb = new StringBuilder(recenica);
		String obrnutaRecenica = sb.reverse().toString();
		recenica = recenica.toLowerCase();
		obrnutaRecenica = obrnutaRecenica.toLowerCase();
		return recenica.equals(obrnutaRecenica);
	}
public String obrniRecenicu(String recenica) {
		StringBuilder sb = new StringBuilder(recenica);
		return sb.reverse().toString();
	}
public String uklanjanjeSpace(String recenica) {
	return recenica.replaceAll("\\s+", "");
	
}

	public static void main(String[] args) {
		
		String recenica = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesite recenicu: ");
		recenica = scanner.nextLine(); 
		String obrnutarecenica = new Palindrom().obrniRecenicu(recenica);
		System.out.println("Obrnuta recenica je: " + obrnutarecenica);
		System.out.println("Da li je recenica palindrom? " + isPalindrom(recenica));
		System.out.println("Da li je obrnuta recenica palindrom? " + isPalindrom(obrnutarecenica));	
		
	}

}
