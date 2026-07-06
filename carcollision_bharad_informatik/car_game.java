import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class car_game extends JPanel implements KeyListener{
  private Car car;
  private glassfarbe glassfarbe;
  //private Obstacles obstacles;
  private int carx = 200;
  private int cary = 400;
  private int backgroundY = 0;
  private ArrayList<Rectangle> obstacles;
  private Timer timer;
  private boolean gameOver = false;
  public car_game(){
    car = new Car("Blue");
    glassfarbe = new glassfarbe("Black");
    obstacles = new ArrayList<>();
    setFocusable(true);
    addKeyListener(this);
    generateObstacles();
    timer = new Timer(20, e ->{
      if(!gameOver){
        moveBackground();
        moveObstacles();
        checkCollisions();
        repaint();
      }
      });
    timer.start();
    }
  private void moveBackground() {
    backgroundY += 5;
    if(backgroundY >= getHeight()){
      backgroundY = 0;
      }
  }
  private void generateObstacles(){
    for (int i = 0;i < 5 ;i++ ) {
      int x = (int) (Math.random()*(getWidth() -50));
      int y = -(int) (Math.random()*300) -50;
      obstacles.add(new Rectangle(x,y,50,50));
      } // end of for
    }
  private void moveObstacles(){
    for (Rectangle obstacle : obstacles) {
      obstacle.y += 5;
      if (obstacle.y > getHeight()) {
        obstacle.y = -50;
        obstacle.x = (int) (Math.random() * (getWidth()-50));
      } // end of if
    } // end of for
    }
  private void checkCollisions(){
    Rectangle carRect = new Rectangle(carx,cary,60,30);
    for (Rectangle obstacle : obstacles ) {
      if (carRect.intersects(obstacle)) {
        gameOver = true;
        timer.stop();
      } // end of if
    } // end of for
    }
  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, backgroundY,getWidth(),getHeight());
    g.fillRect(0, backgroundY -getHeight(),getWidth(), getHeight());
    g.setColor(Color.decode(car.get_color().equals("Blue") ? "#0000FF":"#FF0000"));
    g.fillRect(carx,cary,100,30);
    g.fillRect(carx+50,cary-20,50, 30);
    g.fillRect(carx+47, cary-25,47, 35);
    g.fillRect(carx+45, cary-30,40, 35);
    g.setColor(Color.decode(glassfarbe.get_glassfarbe().equals("Black")? "#000000" : "#FFFFFF"));
    g.fillRect(carx+50,cary-17,47,20);
    g.setColor(Color.BLACK);
    g.fillOval(carx,cary+25,15,15);
    g.fillOval(carx+30,cary+25,15,15);
    g.fillOval(carx+80,cary+25,15,15);
    g.fillOval(carx+15,cary+25,15,15);
    g.setColor(Color.WHITE);
    g.drawString("Geschwindigkeit: "+ car.get_speed()+" km/h", 10,20);
    g.drawString("Gang: " +car.get_gear(),10,40);
    g.drawString("-----------------------------------",10,60);
      for (Rectangle obstacle : obstacles ) {
      g.setColor(Color.BLACK);
      g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    } // end of for
    if (gameOver) {
      g.setColor(Color.RED);
      g.drawString("Game Over!", getWidth() / 2 - 40, getHeight() / 2);
    } // end of if
    }
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_UP) {
      car.accelerate();
    } else if (key == KeyEvent.VK_DOWN) {
      car.brake();
    } // end of if
    if  (key == KeyEvent.VK_W){
      car.shift_up();
      }else if (key == KeyEvent.VK_S) {
      car.shift_down();        
      }
    if (key == KeyEvent.VK_LEFT) {
      carx -= car.get_speed() / 10;
    } // end of if
    if (key == KeyEvent.VK_RIGHT) {
      carx += car.get_speed() / 10;
    } // end of if
    repaint();    
  }
  @Override
  public void keyReleased(KeyEvent e){
  }                               
  @Override
  public void keyTyped(KeyEvent e){
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame("Car Game");
    car_game game = new car_game();
    frame.add(game);
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}