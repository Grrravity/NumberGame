import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GPointCalc {
	private int scorejoueur = 0, scoregame = 0;
	private String gamername = "Inconnu";
	private BufferedWriter bw;
		
public GPointCalc() {
	try{
        String content = "G-E Number Game score sheet";
        String path="G:\\Utilisateur\\Grrravity\\Bureau\\Grrravity Business\\Eclipse\\NumberGame\\src\\scoresheet.txt";
        File file = new File(path);
        if (!file.exists())
        {
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        }
        catch(Exception e){
            System.out.println(e);
        }
}
public String finalScore (String gamername, int scorejoueur, int scoregame)
{
	String fscore = new String();
	System.out.println("Merci d'avoir joué " +gamername+ ", " +scorejoueur+ " point(s) pour toi contre " +scoregame+ " point(s) pour moi.");
	try{
	if (scorejoueur > scoregame)
	{
		fscore = "Tu as gagné mon grand, tu m'a vaincu !";
		bw.write(gamername+ " a gagné !\r\n");
	}
	else if (scorejoueur < scoregame)
	{
		fscore = "J'ai gagné petite sous-merde, à plus !";
		bw.write("G-E Number Game a gagné !\r\n");
	}
	else
	{
		fscore = "C'est une égalité... moi qui pensais t'écraser !";
		bw.write("C'est une égalitée.\r\n");
	}
	bw.close();
	}
    catch(Exception e){
        System.out.println(e);
    }
	return fscore;
}

}
