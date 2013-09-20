
public class Point3D extends Point {
    private double z;
    
    public Point3D() {
        super(0.0, 0.0);
        this.z = 0.0;
    }
    
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public double distance(Point3D other) {
        double xs = Math.pow(this.x - other.getX(), 2);
        double ys = Math.pow(this.y - other.getY(), 2);
        double zs = Math.pow(this.z - other.getZ(), 2);
        return Math.sqrt(xs + ys + zs);
    }
    
    @Override
    public String toString() {
        return String.format("(%f,%f,%f)", this.x, this.y, this.z);
    }
}
