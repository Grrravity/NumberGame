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
		System.out.println("Bien trouv� ! c'est bien " +number+ " !!");
		// score++;
		System.out.println("/// " +playerName+ " marque " +scoreBase+ " point. ///");
		sendToBuffer(false, "\r\n" +playerName+ " marque " +scoreBase+ " point(s).");
		guessResult = 1;
	}
	else if (attempt > 0 && number > guess)
	{
		System.out.println("Mon nombre est plus grand que �a voyons !");
	}
	else 
	{
		System.out.println("Holaaaa tout doux ! Mon nombre est plus petit !");
	}
	
	return guessResult;
	
}

public void guessLoosing(int number, int scoreBase, int gameScore) {
		System.out.println("Ahhhh c'est dommage... Tu n'as plus d'�ssais ! j'ai gagn� !");
		System.out.println("La r�ponse �tait pourtant simple... c'�tait �videment " +number+ "!!" );
		sendToBuffer(false, "\r\nG-E Number Game +" +scoreBase);
		System.out.println("~ G-E Number Game est � " +gameScore+ " point(s) !~");
		sendToBuffer(false, "\r\n   --- G-E Number Game est a  " +gameScore+ " point(s) ---");

}

public String finalScore (String name, int score, int game) {
	
	String fscore = new String();
	System.out.println("Merci d'avoir jou� " +name+ ", " +score+ " point(s) pour toi contre " +game+ " point(s) pour moi.");
	if (score > game)
	{
		fscore = "Tu as gagn� mon grand, tu m'a vaincu !";
	sendToBuffer(true, "\r\n" +name+ " a gagn� !   --- " +score+ " � "+game+ " ---");
	}
	else if (score < game)
	{
		fscore = "J'ai gagn� petite sous-merde, � plus !";
		sendToBuffer(true, "\r\nG-E Number Game a gagn� !   (--- " +score+ " � " +game+" ---");
	}
	else
	{
		fscore = "C'est une �galit�... moi qui pensais t'�craser !";
		sendToBuffer(true, "\r\nC'est une �galit�e.   --- " +score+ " � "+game+ " ---");
	}
	return fscore;
}
}
