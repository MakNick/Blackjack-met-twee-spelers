package WeekOpdrachtBlackjackSpeler;

import java.util.Scanner;

public class StartMenu {
		KaartGenerator kaartGenerator = new KaartGenerator();
		static boolean doorgaan = true;
		Kaart kaart = new Kaart();
		Speler speler1 = new Speler("Nick");
		Speler speler2 = new Speler("Henk");
		
		
		void starten() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welkom bij Blackjack!\n\nDit zijn de geschudde kaarten:");
			
			beginKaartenSpelers();
			
			while(doorgaan){
				System.out.println("Kies een optie:");
				toonMenu();
				String invoer = scanner.nextLine();
				verwerkenInvoer(invoer);	
			}
			scanner.close();
		}
		
		void toonMenu() {
			System.out.println("1. Speler 1 krijgt een kaart");
			System.out.println("2. Speler 1 past");
			System.out.println();
			System.out.println("3. Speler 2 krijgt een kaart");
			System.out.println("4. Speler 2 past");
			System.out.println();
			System.out.println("5. Afsluiten");
		}

		void verwerkenInvoer(String deInvoer) {
						
			switch(deInvoer) {
			case "1": 
				speler1.voegKaartInHand(kaartGenerator.geefKaart(kaart));
				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek + "\n");
				break;
			case "2": 
				kaartGenerator.pasKaart();
				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek+ "\n");
				break;
			case "3": 
				speler2.voegKaartInHand(kaartGenerator.geefKaart(kaart));
				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek+ "\n");
				break;
			case "4": 
				kaartGenerator.pasKaart();
				System.out.println("De volgende kaarten zitten nog in het dek: " + kaartGenerator.nieuwDek+ "\n");
				break;
			case "5": 
				doorgaan = false;
				System.out.println("Quit");
				break;
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