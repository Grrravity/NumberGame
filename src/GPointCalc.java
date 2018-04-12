import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GPointCalc {
	private BufferedWriter bw;	
		
public GPointCalc() {

}
public void sendToBuffer(int end,String line) {
	try{
        String path="C:\\Users\\julie\\Desktop\\OC\\NumberGame\\src\\scoresheet.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        
        if (end == 0) {
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

public String finalScore (String name, int score, int game)
{
	
	String fscore = new String();
	GPointCalc buffsend = new GPointCalc();
	System.out.println("Merci d'avoir jou� " +name+ ", " +score+ " point(s) pour toi contre " +game+ " point(s) pour moi.");
	if (score > game)
	{
		fscore = "Tu as gagn� mon grand, tu m'a vaincu !";
		buffsend.sendToBuffer(1, name+ " a gagn� !\r\n");
	}
	else if (score < game)
	{
		fscore = "J'ai gagn� petite sous-merde, � plus !";
		buffsend.sendToBuffer(1, "G-E Number Game a gagn� !\r\n");
	}
	else
	{
		fscore = "C'est une �galit�... moi qui pensais t'�craser !";
		buffsend.sendToBuffer(1, "C'est une �galit�e.\r\n");
	}
	return fscore;
}
}
