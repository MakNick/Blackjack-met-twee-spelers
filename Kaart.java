package WeekOpdrachtBlackjackSpeler;

public class Kaart {
	String kleur;
	String waarde;
	int rekenWaarde;
	@Override
	public String toString() {
		return kleur + " " + waarde;
	}	
}