import java.util.Scanner;
import java.util.Random;
public class NumberGame {

	public static void main(String[] args) {

        Random rand = new Random();
		int guess, attempt;
		char loop = 'O';
		String name;
		Scanner sc = new Scanner(System.in);
		GPointCalc useCalc = new GPointCalc();
		
		//discard scoresheet.txt content
		useCalc.clearScoresheet();
		
		//Game starting
		System.out.println("Bienvenue dans le G-E Number Game !\n-----------------------------------"
			+ "\nVous devez trouver le nombre auquel je pense...\nPour commencer, Quel est votre nom ? ---");
		useCalc.sendToBuffer(false, " ---- G-E Number Game score sheet ---- \r\n");
		name = sc.nextLine();
		
		//creating players (game + user)
		Player player = new Player(name, 0, 0);
		Player game = new Player("G-E Number Game", 0, 0);
		
		//initialize new round
		do {
			int number = rand.nextInt(34) + 1;
			System.out.println("J'ai choisi un nombre entre 1 et 35, vous devez le deviner.\n"
					+ "En combien de coup pensez-vous y arriver\n"
					+ "/// moins vous demandez de tentatives, plus vous gagnez de point !///");
			attempt = sc.nextInt();
			game.setScoreBasis(attempt);
			player.setScoreBasis(attempt);
			sc.nextLine();
			
			//main loop for number guessed
			for (int attempt1 = attempt; attempt1 > 0; attempt--)
			{
				if (attempt > 0)
				{
					System.out.println("Vous avez donc " +attempt+ " essai(s) restant avant de perdre");
					System.out.println("Quel est votre réponse ?");
					guess = sc.nextInt();
					sc.nextLine();
					
					//loop when attempt is over 0, provides + / - tip and winning sentences
					if (useCalc.guessNumberResult(guess, number, attempt, player.getScoreBase(),player.getPlayerScore(),player.getPlayerName()) == 1) {
						player.addPlayerScore();
						attempt1 = 0;
					}
				}
				//manage the case when player loose the round
				else 
					{
					useCalc.guessLoosing(number, game.getScoreBase(), game.getPlayerScore());
					game.addPlayerScore();
					attempt1 = 0;
					}
			}
		do {
			System.out.println("Voulez-vous continuer ? O/N");
			loop = sc.nextLine().charAt(0);
		}while (loop != 'O' && loop != 'N');
		}while (loop == 'O');
		
		//giving final score + the result of the game
		System.out.println(useCalc.finalScore(player.getPlayerName(), player.getPlayerScore(), game.getPlayerScore()));
        sc.close();
	}
}