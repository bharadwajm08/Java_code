public class Car{
  private String color;
  private int speed;
  private int gear;
  public Car(String color){
    this.color = color;
    this.speed = 0;
    this.gear = 1;
    }
  public String get_color(){
    return color;
    }
  public void set_color(String color){
    this.color = color;
    }
  public int get_speed(){
    return speed;
    }
  public int get_gear(){
    return gear;
    }
  public void accelerate(){
    if (speed < 200) {
      speed += 10 * gear;
    } // end of if
  }
  public void brake(){
    if (speed > 0) {
      speed -= 10;
    } else {
      speed = 0;
    } // end of if-else
    }
  public void shift_up(){
    if (gear < 5) {
      gear++;
    } // end of if
  }
  public void shift_down() {
    if (gear > 1) {
      gear--;
    } // end of if
  }
}