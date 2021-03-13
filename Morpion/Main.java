import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Plateau grille = new Plateau();
		int testGagne=grille.gagne();
		boolean testGrillePleine = grille.plein();
		Scanner sc = new Scanner(System.in);
		int tourJoueur=1;
		while(testGagne==0 && !testGrillePleine){ // tant qu'il n'y a pas de gagnant ou d'egalité, on joue
			
			boolean tour;
			testGagne=grille.gagne();
			testGrillePleine = grille.plein();
			if (testGagne!=0 || testGrillePleine){ //si on trouve un gagnant ou égalité, on interdit le prochaine joueur de jouer
				tour=true;
			}
			else{ //sinon on laisse jouer le prochain joueur
				tour=false;
				
			}
			while(!tour){ //tant que le tour n'est pas fini, on laisse le joueur x jouer
				System.out.println("C'est au tour du joueur num "+tourJoueur);
				System.out.println("Entrez un chiffre entre 0 et 2 pour la valeur de X :");
				String nombreX = sc.next();
				while(!(nombreX.equals("0")) && !(nombreX.equals("1")) && !(nombreX.equals("2"))){ // tant que la saisie est incorrecte, on redemande de saisir la valeur de X
					System.out.println("Erreur : Saisie incorrecte, veuillez reessayer.");
					System.out.println("Entrez un chiffre entre 0 et 2 pour la valeur de X :");
					nombreX = sc.next();
				}
				Integer nbX = new Integer(nombreX);
				int x=nbX.intValue();


				System.out.println("Entrez un chiffre entre 0 et 2 pour la valeur de Y :");
				String nombreY = sc.next();
				while(!(nombreY.equals("0")) && !(nombreY.equals("1")) && !(nombreY.equals("2"))){ // tant que la saisie est incorrecte, on redemande de saisir la valeur de Y
					System.out.println("Erreur : Saisie incorrecte, veuillez reessayer.");
					System.out.println("Entrez un chiffre entre 0 et 2 pour la valeur de Y :");
					nombreY = sc.next();
				}
				Integer nbY = new Integer(nombreY);
				int y=nbY.intValue();
				
				if(grille.getXY(y,x).getJoueur()==0){ //on insère le symbole si la case est vide
					tour=true;
					grille.getXY(y,x).setJoueur(tourJoueur);
					System.out.println(grille);
					if (tourJoueur==1){ //on alterne entre les deux joueurs
						tourJoueur=2;
					}
					else{
						tourJoueur=1;
					}
					
				}
				else{ // sinon on montre qu'il y a une erreur car la case est prise
					System.out.println("Erreur : la case souhaitee est deja prise, resaisissez vos coordonnées.");
				}

			}
			
			
		}
		if(testGagne==0){ // cas pour vérifier l'égalité
			System.out.println("Il n'y a pas de gagnant, Egalite !");
		}
		else if(testGagne==1){ //cas pour vérifier si le joueur 1 a gagné
			System.out.println("Le gagnant est le joueur numero 1 ! (ronds)");
		}
		else if(testGagne==2){ //cas pour vérifier si le joueur 2 a gagné
			System.out.println("Le gagnant est le joueur numero 2 ! (croix)");
		}





	}
}