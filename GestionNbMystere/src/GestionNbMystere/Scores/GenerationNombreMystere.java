package GestionNbMystere.Scores;

import java.util.Random;

public class GenerationNombreMystere {
	private static int nombre = -1;
	private static boolean win = false;
	private static int score = 0;
	
	public static int getNombre() {
		return nombre;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void setNombre() {
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis());
		nombre = rd.nextInt(101);
	}
	
	public static void reset() {
		nombre = -1;
		win = false;
		score = 0;
	}
	
	public static String tropGrand() {
		return "<li class='alert alert-danger'> Le nombre mystère est plus grand </li>";
	}
	
	public static String tropPetit() {
		return "<li class='alert alert-danger'>Le nombre mystère est plus petit</li>";
	}
	
	public static String bonNombre() {
		return "<li class='alert alert-success'>Bravo, vous avez trouvé le nombre mystère</li>";
	}
}
