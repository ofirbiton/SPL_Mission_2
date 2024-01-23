//Naim Moshe 315852269 & Ofir Biton 208582494
public class Location {
    private final int x;
    private final int y;
    public Location (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location location) {
        this.x = location.x;
        this.y = location.y;
    }

    public String toString(){
        return "(" + x +", " + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}