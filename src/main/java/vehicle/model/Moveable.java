package vehicle.model;

public interface Moveable extends Controllable {

  void moveForward();

  void turnRight();

  void parking();

  void moveReverse();
}
