import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GPointCalc {

private BufferedWriter bw;	
		
public GPointCalc() {

}

public void clearScoresheet () {
	try{
		String path="G:\\Utilisateur\\Grrravity\\Bureau\\Grrravity Business\\Eclipse\\NumberGame\\src\\scoresheet.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter("G:\\Utilisateur\\Grrravity\\Bureau\\Grrravity Business\\Eclipse\\NumberGame\\src\\scoresheet.txt");
        pw.close();
        
	}
    catch(Exception e){
        System.out.println(e);
    }
}

 // write into buffer. If boolean is true, then it write and close the buffer
public void sendToBuffer(boolean end,String line) {
	try{
		String path="G:\\Utilisateur\\Grrravity\\Bureau\\Grrravity Business\\Eclipse\\NumberGame\\src\\scoresheet.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(),true));
        
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

 // while attempt is still ok, send winning text or the indicators of + or -
public int guessNumberResult(int guess, int number, int attempt, int scoreBase, int playerScore, String playerName) {
	int guessResult = 0;
	if (attempt > 0 && number == guess)
	{
		System.out.println("Bien trouvé ! c'est bien " +number+ " !!");
		// score++;
		System.out.println("/// " +playerName+ " marque " +scoreBase+ " point. ///");
		sendToBuffer(false, "\r\n" +playerName+ " marque " +scoreBase+ " point(s).");
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

public void guessLoosing(int number, int scoreBase, int gameScore) {
		System.out.println("Ahhhh c'est dommage... Tu n'as plus d'éssais ! j'ai gagné !");
		System.out.println("La réponse était pourtant simple... c'était évidement " +number+ "!!" );
		sendToBuffer(false, "\r\nG-E Number Game +" +scoreBase);
		System.out.println("~ G-E Number Game est à " +gameScore+ " point(s) !~");
		sendToBuffer(false, "\r\n   --- G-E Number Game est a  " +gameScore+ " point(s) ---");

}

public String finalScore (String name, int score, int game) {
	
	String fscore = new String();
	System.out.println("Merci d'avoir joué " +name+ ", " +score+ " point(s) pour toi contre " +game+ " point(s) pour moi.");
	if (score > game)
	{
		fscore = "Tu as gagné mon grand, tu m'a vaincu !";
	sendToBuffer(true, "\r\n" +name+ " a gagné !   --- " +score+ " à "+game+ " ---");
	}
	else if (score < game)
	{
		fscore = "J'ai gagné petite sous-merde, à plus !";
		sendToBuffer(true, "\r\nG-E Number Game a gagné !   (--- " +score+ " à " +game+" ---");
	}
	else
	{
		fscore = "C'est une égalité... moi qui pensais t'écraser !";
		sendToBuffer(true, "\r\nC'est une égalitée.   --- " +score+ " à "+game+ " ---");
	}
	return fscore;
}
}
