public class Player {
	private int scorePlayer_ = 0, scoreBasis_ = 0;
	private String playerName_ = "Inconnu";

public Player(String pNom, int pScr, int sBase) {
	playerName_ = pNom;
	scorePlayer_ = pScr;
	scoreBasis_ = sBase;
}
	//return player's score
public int getPlayerScore() {
	return scorePlayer_;
}
	//return the point scored at the end of the round
public int getScoreBase() {
	return scoreBasis_;
}
	//return player name
public String getPlayerName() {
	return playerName_;
}
	// set player's score
public void setPlayerScore(int pScr) {
	scorePlayer_ = pScr;
}
	//set the score earn each round regarding the number of attempt
public void setScoreBasis(int base) {
	int basecalc = 0; 
	if (base >= 10)
		basecalc = 1;
	else if (base < 10 && base > 5)
		basecalc = 3;
	else
		basecalc = 5;
	scoreBasis_ = basecalc;
}
	//set player's name
public void setPlayerName(String pName) {
	playerName_ = pName;
}
	//add point(s) to player
public int addPlayerScore() {
	scorePlayer_ =+ scoreBasis_;
	return scorePlayer_;
}

}
