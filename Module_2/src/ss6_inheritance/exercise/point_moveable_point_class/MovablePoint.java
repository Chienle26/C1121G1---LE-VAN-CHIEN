package ss6_inheritance.exercise.point_moveable_point_class;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;
    float[] arrMovablePoint = {xSpeed, ySpeed};

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return arrMovablePoint;
    }

    public String toString() {
        return super.toString() + ", speed=" + "(" + getXSpeed() + "," + getYSpeed() + ")";
    }

    public float[] move() {
        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
        return getXY();
    }

}
