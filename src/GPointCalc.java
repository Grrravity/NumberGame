import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GPointCalc {
private BufferedWriter bw;	
		
public GPointCalc() {

}
 // write into buffer. If boolean is true, then it write and close the buffer
public void sendToBuffer(boolean end,String line) {
	try{
		String path="C:\\Users\\julie\\Desktop\\OC\\NumberGame\\src\\scoresheet.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        
        if (end = false) {
        bw.write (line);
        }
        else {
        	bw.write(line);
        	bw.close();
		}
        
	}
    catch(Exception e){
        System.out.println(e);
    }
}

 // 
public int guessNumberResult(int guess, int number, int attempt, int scoreBase, int playerScore, String playerName) {
	int guessResult = 0;
	if (attempt > 0 && number == guess)
	{
		System.out.println("Bien trouvé ! c'est bien " +number+ " !!");
		// score++;
		System.out.println("/// " +playerName+ " marque " +scoreBase+ " point. ///");
		sendToBuffer(false, playerName+ "marque " +scoreBase+ "point(s).");
		guessResult = 1;
	}
	else if (attempt > 0 && number > guess)
	{
		System.out.println("Mon nombre est plus grand que ça voyons !");
	}
	else 
	{
		System.out.println("Holaaaa tout doux ! Mon nombre est plus petit !");
	}
	
	return guessResult;
	
}

public String finalScore (String name, int score, int game) {
	
	String fscore = new String();
	System.out.println("Merci d'avoir joué " +name+ ", " +score+ " point(s) pour toi contre " +game+ " point(s) pour moi.");
	if (score > game)
	{
		fscore = "Tu as gagné mon grand, tu m'a vaincu !";
		sendToBuffer(true, name+ " a gagné !\r\n");
	}
	else if (score < game)
	{
		fscore = "J'ai gagné petite sous-merde, à plus !";
		sendToBuffer(true, "G-E Number Game a gagné !\r\n");
	}
	else
	{
		fscore = "C'est une égalité... moi qui pensais t'écraser !";
		sendToBuffer(true, "C'est une égalitée.\r\n");
	}
	return fscore;
}
}
