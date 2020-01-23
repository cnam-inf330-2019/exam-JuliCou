package net.cnam.inf330;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Position)) {
            return false;
        }
        Position p = (Position) o;
        return (p.x == this.x) && (p.y == this.y);
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
