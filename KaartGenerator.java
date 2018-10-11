package WeekOpdrachtBlackjackSpeler;

import java.util.ArrayList;
import java.util.Collections;

class KaartGenerator{
	String[] kleur = {"Harten", "Schoppen", "Klaver", "Ruiten"};
	String[] waarde = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Koning", "Aas"};
	int[] rekenWaarde = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	ArrayList<Kaart> nieuwDek = new ArrayList<Kaart>();
	int startWaarde;
	int getrokkenWaarde;
	
	void vulDek() {
		for(int indexKleur = 0; indexKleur < kleur.length; indexKleur++) {
			for (int indexWaarde = 0; indexWaarde < waarde.length; indexWaarde++){
				Kaart kaart = new Kaart();
				kaart.kleur = kleur[indexKleur];
				kaart.waarde = waarde[indexWaarde];
				kaart.rekenWaarde = rekenWaarde[indexWaarde];
				nieuwDek.add(kaart);
			}
		}
	}
	
	void schudDek() {
		Collections.shuffle(nieuwDek);
	}
	
	Kaart geefKaart(Kaart kaart) {
		kaart = nieuwDek.get(0);
		nieuwDek.remove(0);	
		return kaart;
	}	
	
	public void pasKaart() {
		System.out.println("Je past");
		nieuwDek.remove(0);	
	}
}
