public class Vector {
    private int x;
    private int y;
    private double size;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = size();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    private double size() {
        return SimpleMath.Sqrt(SimpleMath.IterativePower(x,2) + SimpleMath.IterativePower(y, 2));
    }


    public boolean compareVectors(Vector vector) {
        if (this.getSize() > vector.getSize()){
            return true;
        }
        return false;
    }

    public static Vector createSummedVector(Vector v1, Vector v2){
        return new Vector(v1.getX() + v2.getX(), v1.getY() + v2.getY());
    }

    public void shift(Vector v){
        this.setX(v.getX());
        this.setY(v.getY());
    }
}
