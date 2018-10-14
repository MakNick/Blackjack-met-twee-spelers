package WeekOpdrachtBlackjackSpeler;

import java.util.Scanner;

public class StartMenu {
		KaartGenerator kaartGenerator = new KaartGenerator();
		static boolean doorgaan = true;
		Kaart kaart = new Kaart();
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
		int maxScore = 21;
		
		void naamInvoer() {
			System.out.println("Welkom bij Blackjack!\n\n");
			Scanner sc = new Scanner(System.in);
			System.out.println("Speler 1, voer je naam in: ");
			speler1.naam = sc.nextLine();
			System.out.println("Speler 2, voer je naam in: "); 
			speler2.naam = sc.nextLine();
		}
		
		void starten() {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nDit zijn de geschudde kaarten:");
			beginKaartenSpelers();
		
				while(doorgaan && (!speler1.passen && !speler2.passen)){
					while(speler1.doorgaanSpeler && !speler1.passen){
						toonMenuSpeler1();
						verwerkenInvoerSpeler1(scan.nextLine());
						checkScore();
					}
					while(speler2.doorgaanSpeler && !speler2.passen){
						toonMenuSpeler2();
						verwerkenInvoerSpeler2(scan.nextLine());
						checkScore();
					}	 
				}
				checkEindscore();

			}
		
		
		void toonMenuSpeler1() {
			System.out.println(speler1.naam + " heeft de volgende kaarten in de hand: " + speler1.kaartenInHand + 
								" met het totaal aantal punten van: " + speler1.startWaarde + "\n" + speler1.naam + ", kies een optie:");
			System.out.println("1. krijg een kaart");
			System.out.println("2. pas");
			System.out.println();
			System.out.println("3. Afsluiten");
		}
		
		void toonMenuSpeler2() {
			System.out.println(speler2.naam + " heeft de volgende kaarten in de hand: " + speler2.kaartenInHand + 
								" met het totaal aantal punten van: " + speler2.startWaarde + "\n" + speler2.naam + ", kies een optie:");
			System.out.println("1. krijg een kaart");
			System.out.println("2. pas");
			System.out.println();
			System.out.println("3. Afsluiten");
		}

		void verwerkenInvoerSpeler1(String deInvoer) {
						
			switch(deInvoer) {
			case "1": 
				speler1.voegKaartInHand(kaartGenerator.geefKaart(kaart));
//				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek + "\n");	
				speler1.doorgaanSpeler = false;
				speler2.doorgaanSpeler = true;
				if(speler1.startWaarde < maxScore && speler2.passen == true){
					speler1.doorgaanSpeler = true;
				}
				break;
			case "2":
				System.out.println("Je past, de totale eindscore is: " + speler1.startWaarde + "\n");
				speler1.passen = true;
				speler1.doorgaanSpeler = false;
				speler2.doorgaanSpeler = true;
				doorgaan = false;
				break;
			case "3": 
				doorgaan = false;
				speler1.passen = true;				
				speler2.passen = true;
				System.out.println("Einde spel");
				break;
			}

		}
		
		void verwerkenInvoerSpeler2(String deInvoer1) {
			
			switch(deInvoer1) {
			case "1": 
				speler2.voegKaartInHand(kaartGenerator.geefKaart(kaart));
//				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek + "\n");	
				speler2.doorgaanSpeler = false;
				speler1.doorgaanSpeler = true;
				if(speler2.startWaarde < maxScore && speler1.passen == true){
					speler2.doorgaanSpeler = true;
				}
				break;
			case "2": 
				System.out.println("Je past, de totale eindscore is: " + speler2.startWaarde + "\n");
				speler2.passen = true;
				speler1.doorgaanSpeler = true;
				speler2.doorgaanSpeler = false;
				doorgaan = false;
				break;
			case "3": 
				doorgaan = false;
				speler1.passen = true;
				speler2.passen = true;
				System.out.println("Einde spel");
				break;
			}

		}
		
		void checkEindscore() {
		if(speler1.startWaarde <= maxScore && speler2.startWaarde <= maxScore){
					if(speler1.startWaarde > speler2.startWaarde) {
						System.out.println(speler1.naam + " wint van " + speler2.naam + " met " + speler1.startWaarde + " punten!");
					} else if (speler1.startWaarde < speler2.startWaarde){
						System.out.println(speler2.naam + " wint van " + speler1.naam + " met " + speler2.startWaarde + " punten!");
					} else { 
						System.out.println("Gelijkspel!");
					}
				} else if(speler1.startWaarde > maxScore && speler2.startWaarde > maxScore){
					System.out.println("Helaas, beide verloren");
				} else if(speler1.startWaarde <= maxScore && speler2.startWaarde > maxScore){
					System.out.println(speler1.naam + " wint van " + speler2.naam + " met " + speler1.startWaarde + " punten!");
				} else if(speler1.startWaarde > maxScore && speler2.startWaarde <= maxScore){
					System.out.println(speler2.naam + " wint van " + speler1.naam + " met " + speler2.startWaarde + " punten!");
				}
		}
		
		void checkScore() {
			if(speler1.startWaarde > maxScore){
				System.out.println("Helaas, busted! " + speler2.naam + " heeft gewonnen!");
				doorgaan = false;
				speler1.passen = true;				
				speler2.passen = true;
			} else if (speler2.startWaarde > maxScore){
				System.out.println("Helaas, busted! " + speler1.naam + " heeft gewonnen!");
				doorgaan = false;
				speler1.passen = true;				
				speler2.passen = true;
			} else if(speler1.startWaarde == maxScore && speler2.startWaarde < maxScore) {
				System.out.println("Blackjack!");
//				doorgaan = false;
				speler1.passen = true;				
				speler2.passen = false;
			} else if (speler2.startWaarde == maxScore && speler1.startWaarde < maxScore) {
				System.out.println("Blackjack!");
//				doorgaan = false;
				speler1.passen = false;				
				speler2.passen = true;
			}
		}
		
		void beginKaartenSpelers() {
			kaartGenerator.vulDek();
			kaartGenerator.schudDek();
			System.out.println(kaartGenerator.nieuwDek + "\n");
			
			speler1.krijgBeginKaarten(kaartGenerator.geefKaart(kaart));
			speler1.krijgBeginKaarten(kaartGenerator.geefKaart(kaart));
			speler1.printStatus();
			System.out.println();
			speler2.krijgBeginKaarten(kaartGenerator.geefKaart(kaart));
			speler2.krijgBeginKaarten(kaartGenerator.geefKaart(kaart));
			speler2.printStatus();
			System.out.println();
		}
		
}