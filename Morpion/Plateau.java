public class Plateau{
	private Case plateau[][]=new Case [3][3]; //création de l'attribut plateau du type Case

	public Plateau(){ //remplissage de ce plateau
		for(int i=0; i<3; i++){
			for(int u=0; u<3; u++){
				plateau[i][u]=new Case();
			}
		}
	}

	public Case getXY(int i, int j){ //getteur de la case[i][j]
		return(plateau[i][j]);
	}

	public boolean plein(){ //méthode permettant de vérifier si le plateau est plein ou non
		boolean plein=true;
		for (int i=0; i<3; i++){
			for (int u=0; u<3; u++){
				int joueurCase = plateau[i][u].getJoueur();
				if (joueurCase==0){
					plein=false;
				}
			}
		}
		return(plein);
	}

	public int gagne(){ // méthode pour savoir s'il y a un gagnant ou non
		int gagnant = 0;
		int i=0;
		boolean victoireTrouve=false;

		while (i<3 && !victoireTrouve){ 
			if(!(plateau[i][0].equals(0)) && !(plateau[i][1].equals(0)) && !(plateau[i][2].equals(0)) && !victoireTrouve){  //test de toutes les lignes
				if(plateau[i][1].equals(plateau[i][0])){ //si toute la ligne numéro i est remplie, on vérifie que c'est bien du même symbole
					if(plateau[i][2].equals(plateau[i][0])){
						victoireTrouve=true;
						gagnant=plateau[i][0].getJoueur();
					}
				}
			}	
			if(!(plateau[0][i].equals(0)) && !(plateau[1][i].equals(0)) && !(plateau[2][i].equals(0)) && !victoireTrouve){ //test de toutes les colonnes
				if(plateau[1][i].equals(plateau[0][i])){ //si toute la colonne numéro i est remplie, on vérifie que c'est bien du même symbole
					if(plateau[2][i].equals(plateau[0][i])){
						victoireTrouve=true;
						gagnant=plateau[0][i].getJoueur();	
					}
				}
			}
			i=i+1;
		
		}
		
		if(!plateau[0][0].equals(0) && !plateau[1][1].equals(0) && !plateau[2][2].equals(0)){  //test de la première diagonale (en haut a gauche à en bas a droite)
			if(plateau[1][1].equals(plateau[0][0])){ //si toute la diagonale est remplie, on vérifie qu'elle est bien du même symbole sur chaque case
				if(plateau[2][2].equals(plateau[0][0])){
					gagnant=plateau[0][0].getJoueur();
				}
			}
		}

		if(!plateau[2][0].equals(0) && !plateau[1][1].equals(0) && !plateau[0][2].equals(0)){  //test de la deuxième diagonale (en bas a gauche a en haut a droite)
			if(plateau[1][1].equals(plateau[2][0])){ //si toute la diagonale est remplie, on vérifie qu'elle est bien du même symbole sur chaque case
				if(plateau[0][2].equals(plateau[2][0])){
					gagnant=plateau[2][0].getJoueur();
				}
			}
		}

		return(gagnant);
	}
	
	public String toString(){ // méthode toString pour mettre en forme le plateau
		String grille="___ ___ ___"+"\n";
		String symbole=" ";	
		for(int i=0; i<3; i++){
			for(int u=0; u<3; u++){
				if (plateau[i][u].getJoueur()==0){ //si il n'y a pas de joueur qui occupe la case alors on ne met rien dedans
					symbole=" ";	
				}
				else if(plateau[i][u].getJoueur()==1){ //si la case est occupée par le joueur n°1 alors on met un rond
					symbole="O";
				}
				else{  // sinon si la case est occupée par le joueur n°2 alors on met une croix
					symbole="X";
				}
				grille=grille +" " +symbole + " |";
			}
			grille = grille + "\n" +"___ ___ ___"+"\n";
		}
		return(grille);
	}


}