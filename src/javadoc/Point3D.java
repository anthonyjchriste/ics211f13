
/**
 * This class represents a point in 3D cartesian space (x, y, z).
 */ 
public class Point3D extends Point {
    /**
     * The z-coordinate.
     */
    private double z;
    
    /**
     * Constructs a point where each coordinate is set to 0.0.
     */
    public Point3D() {
        super(0.0, 0.0);
        this.z = 0.0;
    }
    
    /**
     * Constructs a point with the specified x, y, z coordinates.
     */
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    
    /**
     * Returns the z-coordninate.
     * @return The z-coordninate.
     */
    public double getZ() {
        return this.z;
    }
    
    /**
     * Calculates the distance between this Point3D and another Point3D.
     * 
     * The distance is calculated using the distance formula sqrt((x1 - x2)^2 + (y1 - y2)^2 + (z1 - z2)^2).
     * @param other The other point to get the distance from this.
     * @return The distance between this point and the other point.
     */
    public double distance(Point3D other) {
        double xs = Math.pow(this.x - other.getX(), 2);
        double ys = Math.pow(this.y - other.getY(), 2);
        double zs = Math.pow(this.z - other.getZ(), 2);
        return Math.sqrt(xs + ys + zs);
    }
    
    /**
     * Returns a String representation of this point.
     * The String format is the following: (x,y,z).
     * @return The String representation of this point.
     */
    @Override
    public String toString() {
        return String.format("(%f,%f,%f)", this.x, this.y, this.z);
    }
}
