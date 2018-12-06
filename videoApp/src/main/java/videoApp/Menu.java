package videoApp;

import java.util.Scanner;

public class Menu {

	public static int showMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean bSaisie;
		bSaisie = false;
		
		do {
			System.out.println("1. Visualiser la liste des vidéos");
			System.out.println("2. Ajouter une vidéo");
			System.out.println("3. Lire une vidéo");
			System.out.println("4. Quitter.");
			System.out.print("Saisir un chiffre : ");
			
			String saisie = scanner.nextLine();
			
			if (saisie.matches("[1-4]")) {
				int choix = Integer.parseInt(saisie);
				return choix;
			} else if (saisie.matches("[1-4]")) {
				int choix = Integer.parseInt(saisie);
				return choix;
			}
			
		} while (!bSaisie);
		return 0;	
	}
}

