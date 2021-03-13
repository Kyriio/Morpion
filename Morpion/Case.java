public class Case {
	private int joueur; //déclaration de l'attribut joueur

	public Case(){ //initialisation de la case en valeur par défaut
		joueur=0;
	}

	public Case(int joueur){ //constructeur de la case
		this.joueur=joueur;
	}

	public int getJoueur(){ //getteur du joueur de la case
		return joueur;
	}

	public void setJoueur(int joueur){ //setteur du joueur de la case
		this.joueur=joueur;
	}

	public String toString(){ //méthode toString
		return ("La valeur de la case " + joueur);
	}

	public boolean equals(Object obj){ //méthode equals
		if (this==obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Case other = (Case) obj;
		return((joueur==other.joueur));

	}




}