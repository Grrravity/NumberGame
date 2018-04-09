package cours;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;
public class cours {

	public static void main(String[] args) {
		try{
            String content = "G-E Number Game score sheet";
            String path="G:\\Utilisateur\\Grrravity\\Bureau\\Grrravity Business\\Eclipse\\cours\\src\\scoresheet.txt";
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
		Random rand = new Random();
		int guess, attempt, attemptscore, score = 0, scoregm = 0;
		char loop = 'O';
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenue dans le G-E Numbe"
				+ "r Game !\n-----------------------------------");
		System.out.println("Vous devez trouver le nombre auquel je pense...\nPour commencer, Quel est votre nom ? ---");
		name = sc.nextLine();
        bw.write(" ---- G-E Number Game score sheet ---- \r\n");
		do {
			int number = rand.nextInt(34) + 1;
			System.out.println("J'ai choisi un nombre entre 1 et 35, vous devez le deviner.\n"
					+ "En combien de coup pensez-vous y arriver\n"
					+ "/// moins vous demandez de tentatives, plus vous gagnez de point !///");
			attempt = sc.nextInt();
			attemptscore = attempt;
			sc.nextLine();
			for (int attempt1 = attempt; attempt1 > 0; attempt--)
			{
				if (attempt > 0)
				{
					System.out.println("Vous avez donc " +attempt+ " essai(s) restant avant de perdre");
					System.out.println("Quel est votre réponse ?");
					guess = sc.nextInt();
					sc.nextLine();
						if (guess == number)
						{
							System.out.println("Bien trouvé ! c'est bien " +number+ " !!");
							if (attemptscore >= 10)
							{
								score++;
								System.out.println("///" +name+ " marque 1 point. ///");
								bw.write( name+ " + 1");
							}
							else if (attemptscore > 5)
							{
								score += 5;
								System.out.println("///" +name+ " marque 5 points ! ///");
								bw.write( name+ " + 5");
							}
							else
							{
								score += 10;
								System.out.println("///" +name+ " marque 10 points ! ///");
								bw.write( name+ " + 10");
							}
							System.out.println("~" +name+ " est à " +score+ " point(s) !~");
							bw.write("   --- " +name+ " est a  " +score+ " point(s) ---\r\n");
							attempt = 0;
						}
						else if (guess < number)
						{
							System.out.println("Mon nombre est plus grand que ça voyons !");
						}
						else 
						{
							System.out.println("Holaaaa tout doux ! Mon nombre est plus petit !");
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
						bw.write( "G-E Number Game + 1");
					}
					else if (attemptscore > 5)
					{
						scoregm += 5;
						System.out.println("/// G-E Number Game marque 5 points ! ///");
						bw.write( "G-E Number Game + 5");
					}
					else
					{
						scoregm += 10;
						System.out.println("/// G-E Number Game marque 10 points ! ///");
						bw.write( "G-E Number Game + 10");
					}
					System.out.println("~ G-E Number Game est à " +scoregm+ " point(s) !~");
					bw.write("   --- G-E Number Game est a  " +scoregm+ " point(s) ---\r\n");
					
					attempt = 0;
					}
			}	
		do {
			System.out.println("Voulez-vous continuer ? O/N");
			loop = sc.nextLine().charAt(0);
		}while (loop != 'O' && loop != 'N');
	}while (loop == 'O');
		System.out.println("Merci d'avoir joué " +name+ ", " +score+ " point(s) pour toi contre " +scoregm+ " point(s) pour moi.");
		if (score > scoregm)
		{
			System.out.println("Tu as gagné mon grand, tu m'a vaincu !");
			bw.write(name+ "a gagné !\r\n");
		}
		else if (score < scoregm)
		{
			System.out.println("J'ai gagné petite sous-merde, à plus !");
			bw.write("G-E Number Game a gagné !\r\n");
		}
		else
		{
			System.out.println("C'est une égalité... moi qui pensais t'écraser !");
			bw.write("C'est une égalitée.\r\n");
		}
		bw.close();
        }
        catch(Exception e){
            System.out.println(e);
	}
	}
}
