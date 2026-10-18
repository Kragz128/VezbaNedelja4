package NestoRandom;
import java.util.Scanner; 
import java.util.ArrayList;

public class Student {
	
	private String ime;
	private String prezime;
	private String brojIndeksa;
	private String adresa;
	private float brojBodova;
	private boolean polozioIliNe;
	private static float prolazNaIspitu;
	
	public Student () {
		ime = "";
		prezime = "";
		brojIndeksa = "";
		adresa = "";
		brojBodova = 0;
		polozioIliNe = false;
	}
	public Student(String ime, String prezime, String brojIndeksa, String adresa, float brojBodova,
			boolean polozioIliNe) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojIndeksa = brojIndeksa;
		this.adresa = adresa;
		this.brojBodova = brojBodova;
		this.polozioIliNe = polozioIliNe;
	}
	
	public static void setProlazNaIspitu (float a) {
		 prolazNaIspitu = a;
	}
	public static float getPorlazNaIspitu() {
		return prolazNaIspitu;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public float getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(float brojBodova) {
		this.brojBodova = brojBodova;
	}
	public boolean isPolozioIliNe() {
		return polozioIliNe;
	}
	public void setPolozioIliNe(boolean polozioIliNe) {
		this.polozioIliNe = polozioIliNe;
	}
	
	public void azuriranje() {
		if (this.getBrojBodova() >= Student.prolazNaIspitu)
			this.setPolozioIliNe(true);
		else
			this.setPolozioIliNe(false);
	}
	
	public static ArrayList <Student> izdvojPolozioIliNe (ArrayList <Student> a, int b) {
		ArrayList <Student> r = new ArrayList <Student> () ;
		for (Student x : a) {
            if (b == 1 && x.isPolozioIliNe()) {
                r.add(x);
            } else if (b == 0 && !x.isPolozioIliNe()) {
                r.add(x);
            }
         }
		return r;
		
	}
	
	public static ArrayList <Student> izdvojUlice(ArrayList <Student> a, String nazivUlice) {
		ArrayList <Student> r = new ArrayList <Student> ();
		for (Student x:a)
			if (x.getAdresa().startsWith(nazivUlice))
				r.add(x);
		return r;
	}
	
	public void sviStudenti() {
		System.out.printf("%s %s %s %s %f" , brojIndeksa, ime , prezime , adresa , brojBodova);
		
	}
	
	
	
	public static void main(String[] args) {
		ArrayList <Student> nizStudenta = new ArrayList <Student> ();
		Scanner k = new Scanner (System.in);
		int N;
		System.out.println("Unesite prolaz na ispitu: ");
		Student.setProlazNaIspitu(k.nextFloat());
		
		System.out.println("Unesi broj studenata: ");
		N = k.nextInt();
		
		System.out.println("Unesi studente: ");
		for (int i = 0; i < N; i++) {
			System.out.println(i);
			
			System.out.println("Student #" + (i+1));
			
			System.out.print("Ime: ");
			String ime = k.nextLine().trim();
			
			System.out.print("Prezime: ");
			String prezime = k.nextLine().trim();
			
			System.out.print("Broj indeksa: ");
			String brojIndeksa = k.nextLine().trim();
			
			System.out.print("Adresa: ");
			String adresa = k.nextLine().trim();
			
			System.out.print("Broj bodova: ");
			float brojBodova = k.nextFloat();
			k.nextLine();
			Student s = new Student(ime,prezime,brojIndeksa,adresa,brojBodova,false);
			
			s.azuriranje();
			nizStudenta.add(s);
			System.out.println();
		}
		ArrayList <Student> polozili;
		polozili = Student.izdvojPolozioIliNe(nizStudenta, 1);
		System.out.println("Polozili ispit: ");
		for(Student x:polozili) {
			x.sviStudenti();
		}
		
		ArrayList <Student> istaUlica;
		istaUlica = Student.izdvojUlice(nizStudenta, "Studentska");
		System.out.println("Iz Studentske ulice: ");
		for(Student x:istaUlica) {
			x.sviStudenti();
		}
		k.close();
		for (Student x : nizStudenta) {
		    System.out.println(x.getIme() + " bodovi=" + x.getBrojBodova()
		            + " prolaz=" + Student.getPorlazNaIspitu()
		            + " polozio=" + x.isPolozioIliNe());
		}
	}

}
