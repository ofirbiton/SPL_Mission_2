//Naim Moshe 315852269 & Ofir Biton 208582494
public class UserGame extends Game{
    public UserGame() {
        this.player1 = new UserPlayer(Content.X, this);
        this.player2 = new SelfPlayer(Content.O,this);
        setCurrentPlayer(Content.X);
    }
}
