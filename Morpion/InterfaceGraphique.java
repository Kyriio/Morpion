import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;
class InterfaceGraphique{
	public static void main(String[] args){
		Plateau grille = new Plateau(); // création de plusieurs attributs servants au jeu de base (sans graphique)
		int testGagne=grille.gagne();
		boolean testGrillePleine = grille.plein();
		int tourJoueur=1;

		Souris souris; //création de plusieurs attributs servant au jeu avec version graphique
		Fenetre f = new Fenetre ( "Mon tic tac toe :)", 600,700);
		Point point1;
		Point point2;
		Rectangle traitGrille;

        souris = f.getSouris(); //permet l'utilisation de la souris
        


		point1=new Point(190, 0); //création de la grille du jeu sur la fenêtre graphique
		point2=new Point(210, 600);
        traitGrille=new Rectangle(Couleur.NOIR, point1, point2, true);
        f.ajouter(traitGrille);

        point1=new Point(390, 0);
		point2=new Point(410, 600);
        traitGrille=new Rectangle(Couleur.NOIR, point1, point2, true);
        f.ajouter(traitGrille);

        point1=new Point(0, 190);
        point2=new Point(600, 210);
        traitGrille=new Rectangle(Couleur.NOIR, point1, point2, true);
        f.ajouter(traitGrille);


        point1=new Point(0, 390);
        point2=new Point(600, 410);
        traitGrille=new Rectangle(Couleur.NOIR, point1, point2, true);
        f.ajouter(traitGrille);
       
        

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
				try{Thread.sleep(1);}catch(Exception e){} //permet de ralentir la boucle afin que le clic soit bien détecté
				
				int posx = souris.getPosition().getX(); // récupération des coordonnées x et y de la souris sur la fenêtre
				int posy = souris.getPosition().getY();

				if(posx>=0 && posx<=200){ // succesion de if pour bien recentrer le cercle dans les cases
					posx=100;
				}
				else if(posx>200 && posx <=400){
					posx=300;
				}
				else{
					posx=500;
				}

				if(posy<=200){
					posy=100;
				}
				else if(posy>200 && posy <=400){
					posy=300;
				}
				else if(posy>400){
					posy=500;
				}

				if(souris.getClicGauche()){ // si le clic est détecté, on fait plusieurs actions
					int x=(int)posx/200; //x et y servent a remplir le tableau de l'attribut grille pour détecter quelle case est remplie ou non
					int y=(int)posy/200;
					if(grille.getXY(y,x).getJoueur()==0){ //on insère le symbole si la case est vide
						tour=true;
						grille.getXY(y,x).setJoueur(tourJoueur);


						if(tourJoueur==1){ //on alterne entre les deux joueurs
								point1=new Point(posx, posy); // création des cercles rouges pour le joueur 1
								Cercle rond = new Cercle(Couleur.ROUGE, point1, 50, true);
								f.ajouter(rond);
								f.rafraichir();
								tourJoueur=2;
								
						}
						else{
							point1=new Point(posx, posy); //création des cercles bleus pour le joueur 2
							Cercle rond = new Cercle(Couleur.BLEU, point1, 50, true);
							f.ajouter(rond);
							f.rafraichir();
							tourJoueur=1;
						}
					}
				}
			}

		}

		point1=new Point(300,650); //point pour les coordonnées du texte final

		if(testGagne==0){ // cas pour vérifier l'égalité
			Texte t=new Texte(Couleur.NOIR, "Pas de gagnant, Egalite !!", new Font("Calibri", Font.TYPE1_FONT, 40), point1); //création du texte d'égalité
			f.ajouter(t);
		}
		else if(testGagne==1){ //cas pour vérifier que le joueur 1 a gagné
			Texte t=new Texte(Couleur.ROUGE, "Le Joueur 1 est le gagnant !!", new Font("Calibri", Font.TYPE1_FONT, 40), point1); //création du texte gagnant joueur 1
			f.ajouter(t);
		}
		else if(testGagne==2){ //cas pour vérifier que le joueur 2 a gagné
			Texte t=new Texte(Couleur.BLEU, "Le joueur 2 est le gagnant !!", new Font("Calibri", Font.TYPE1_FONT, 40), point1); //création du texte gagnant joueur 2
			f.ajouter(t);
		}
		f.rafraichir();

	}
	
}