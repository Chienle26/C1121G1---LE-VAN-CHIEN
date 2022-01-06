package ss6_inheritance.exercise.point2d_point3d_class;

public class Point3D extends Point2D {
    private float z;
    float[] arr3D = {getX(), getY(), z};

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return arr3D;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        this.z = z;
    }

    public String toString() {
        return "(" + getX() + "," + getY() + "," + this.z + ")";
    }
}
