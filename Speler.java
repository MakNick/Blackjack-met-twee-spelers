package WeekOpdrachtBlackjackSpeler;

import java.util.ArrayList;

public class Speler {
	String naam;
	ArrayList<Kaart> kaartenInHand = new ArrayList<Kaart>();
	int startWaarde;
	int getrokkenWaarde;
	int totaleWaarde;
	boolean doorgaanSpeler = true;
	boolean passen = false;
	
	
	void voegKaartInHand(Kaart kaart){
		kaartenInHand.add(kaart);
		getrokkenWaarde = kaart.rekenWaarde;
		totaleWaarde = startWaarde + getrokkenWaarde;
		System.out.println(naam + " krijgt de volgende kaart: " + kaart);
		System.out.println(naam + " heeft de volgende kaarten in de hand: " + kaartenInHand);
		System.out.println("De totale waarde is: " + totaleWaarde + "\n");
		startWaarde = totaleWaarde;
	}
	
	void krijgBeginKaarten(Kaart kaart){
		kaartenInHand.add(kaart);
	}
	
	void printStatus() {
		startWaarde = (kaartenInHand.get(0).rekenWaarde + kaartenInHand.get(1).rekenWaarde);
		System.out.println(naam + " krijgt de kaarten: " + kaartenInHand);//+ kaart + " / " + kaart);
		System.out.println("De totale waarde is: " + startWaarde);

	}
}
