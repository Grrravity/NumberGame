//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;
public class NumberGame {

	public static void main(String[] args) {

        Random rand = new Random();
		int guess, attempt, attemptscore, score = 0, scoregm = 0;
		char loop = 'O';
		String name;
		GPointCalc buffSend = new GPointCalc();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenue dans le G-E Number Game !\n-----------------------------------"
			+ "\nVous devez trouver le nombre auquel je pense...\nPour commencer, Quel est votre nom ? ---");
		buffSend.sendToBuffer(false, " ---- G-E Number Game score sheet ---- \r\n");
		name = sc.nextLine();
		
			//creating players (game + user)
		Player player = new Player(name, 0, 0);
		Player game = new Player("G-E Number Game", 0, 0);
		
		do {
			int number = rand.nextInt(34) + 1;
			System.out.println("J'ai choisi un nombre entre 1 et 35, vous devez le deviner.\n"
					+ "En combien de coup pensez-vous y arriver\n"
					+ "/// moins vous demandez de tentatives, plus vous gagnez de point !///");
			attempt = sc.nextInt();
			attemptscore = attempt;
			game.setScoreBasis(attempt);
			player.setScoreBasis(attempt);
			sc.nextLine();
			GPointCalc guessing = new GPointCalc();
			
			
			for (int attempt1 = attempt; attempt1 > 0; attempt--)
			{
				if (attempt > 0)
				{
					System.out.println("Vous avez donc " +attempt+ " essai(s) restant avant de perdre");
					System.out.println("Quel est votre réponse ?");
					guess = sc.nextInt();
					sc.nextLine();
					
					if (guessing.guessNumberResult(guess, number, attempt, player.getScoreBase(),player.getPlayerScore(),player.getPlayerName()) == 1) {
						player.addPlayerScore();
						attempt1 = 0;
					}
					
						
				}
				else 
					{
					System.out.println("Ahhhh c'est dommage... Tu n'as plus d'éssais ! j'ai gagné !");
					System.out.println("La réponse était pourtant simple... c'était évidement " +number+ "!!" );
					if (attemptscore >= 10)
					{
						scoregm++;
						System.out.println("/// G-E Number Game marque 1 point. ///");
						//bw.write( "G-E Number Game + 1");
					}
					else if (attemptscore > 5)
					{
						scoregm += 5;
						System.out.println("/// G-E Number Game marque 5 points ! ///");
						//bw.write( "G-E Number Game + 5");
					}
					else
					{
						scoregm += 10;
						System.out.println("/// G-E Number Game marque 10 points ! ///");
						//bw.write( "G-E Number Game + 10");
					}
					System.out.println("~ G-E Number Game est à " +scoregm+ " point(s) !~");
					//bw.write("   --- G-E Number Game est a  " +scoregm+ " point(s) ---\r\n");
				
					attempt1 = 0;
					}
			}
		do {
			System.out.println("Voulez-vous continuer ? O/N");
			loop = sc.nextLine().charAt(0);
		}while (loop != 'O' && loop != 'N');
	}while (loop == 'O');
		GPointCalc scorend = new GPointCalc();
		System.out.println(scorend.finalScore(player.getPlayerName(), player.getPlayerScore(), game.getPlayerScore()));
        sc.close();
	}
}