
public class Point {
    protected double x;
    
    protected double y;
    
    public Point() {
        this(0.0, 0.0);
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double distance(Point other) {
        double left = Math.pow(this.x - other.getX(), 2);
        double right = Math.pow(this.y - other.getY(), 2);
        return Math.sqrt(left + right);
    }
    
    @Override
    public String toString() {
        return String.format("(%f,%f)", this.x, this.y);
    }
}
