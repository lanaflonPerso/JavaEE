package GestionNbMystere.Scores;

import java.util.ArrayList;
import java.util.List;

public class GestionScores {
	private List<Integer> coups = new ArrayList<Integer>();
	private List<Integer> mystere = new ArrayList<Integer>();
	private List<Integer> solve = new ArrayList<Integer>();
	
	public void addSolve(int entier) {
		this.solve.add(entier);
	}
	
	public List<Integer> getSolve() {
		return solve;
	}
	
	public List<Integer> getCoups(){
		return coups;
	}
	
	public List<Integer> getMystere(){
		return mystere;
	}
	
	public void addCoup(int entier) {
		coups.add(entier);
	}
	
	public void addMystere(int entier) {
		mystere.add(entier);
	}
}
