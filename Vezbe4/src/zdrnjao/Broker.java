package zdrnjao;

import java.util.Scanner;

public class Broker {

    public static void brojTransakcija(String[] transakcije) {
        double vrednost = 0.0;

        for (int i = 0; i < transakcije.length; i++) {
            String t = transakcije[i];
            t = t.trim();
            char p = Character.toUpperCase(t.charAt(0));
            String numStr = t.substring(1).replace(',', '.').trim();
            
            double iznos = Double.parseDouble(numStr);

            if (p == 'S') {       
                vrednost -= iznos;
            } else if (p == 'B') { 
                vrednost += iznos;
            } else {
                System.out.println("Nevažeći prefiks (očekuje se B ili S): " + t);
            }
        }

        if (vrednost > 0.0) {
            System.out.printf("Broker je u PLUSU za %.2f%n", vrednost);
        } else if (vrednost < 0.0) {
            System.out.printf("Broker je u MINUSU za %.2f%n", Math.abs(vrednost));
        } else {
            System.out.println("Broker je NA NULI (ni plus ni minus).");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Unesite broj transakcija: ");
        String line = sc.nextLine().trim();
        int broj = 0;
        
        String[] transakcije = new String[broj];
        for (int i = 0; i < broj; i++) {
            System.out.print("Unesite transakciju " + (i + 1) + " (npr. B100 ili S50): ");
            transakcije[i] = sc.nextLine();
            if (transakcije[i] == null) transakcije[i] = "";
        }
        brojTransakcija(transakcije);
    }
}