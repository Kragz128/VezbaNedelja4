package zdrnjao;
import java.util.Scanner;

public class Stringovi {

	public static void main(String[] args) {
//Uneti recenicu koja sadrzi vise reci odvojenih prazninama i odrediti broj reci u recenici.
		
		int brojReci = 0;
		String recenica = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesite recenicu: ");
		
		recenica = scanner.nextLine();
		
		for (int i = 0; i < recenica.length(); i++) {
			if (recenica.charAt(i) == ' ') {
				brojReci++;
			}
		}
		System.out.println("Broj reci u recenici je: " + (brojReci + 1));
	}
}
