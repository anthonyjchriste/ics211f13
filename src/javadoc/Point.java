
/**
 * This class represents a 2D point on the cartesian cooridate plane.
 */
public class Point {
    /**
     * The x-coordinate.
     */
    protected double x;
    
    /**
     * The y-coordinate.
     */
    protected double y;
    
    /**
     * Constructs a point where each value is initialized to 0.0.
     */
    public Point() {
        this(0.0, 0.0);
    }
    
    /**
     * Constructs a point with the given x, y coordinates.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x-coordinate of this point.
     * @return The x-xoordinate of this point.
     */
    public double getX() {
        return this.x;
    }
    
    /**
     * Returns the y-coordinate of this point.
     * @return The y-xoordinate of this point.
     */
    public double getY() {
        return this.y;
    }
    
    /**
     * Calculates the distance between this point and another point.
     * 
     * The distance is calculated using the distance formula sqrt((x1 - x2)^2 + (y1 - y2)^2).
     * @param other The other point to get the distance from this.
     * @return The distance between this point and the other point.
     */
    public double distance(Point other) {
        double left = Math.pow(this.x - other.getX(), 2);
        double right = Math.pow(this.y - other.getY(), 2);
        return Math.sqrt(left + right);
    }
    
    /**
     * Returns a String representation of this point.
     * The String format is the following: (x,y).
     * @return The String representation of this point.
     */
    @Override
    public String toString() {
        return String.format("(%f,%f)", this.x, this.y);
    }
}
