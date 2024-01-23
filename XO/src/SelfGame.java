//Naim Moshe 315852269 & Ofir Biton 208582494
public class SelfGame extends Game{
    public SelfGame() {
        this.player1 = new SelfPlayer(Content.X,this);
        this.player2 = new SelfPlayer(Content.O, this);
        setCurrentPlayer(Content.X);
    }
}
