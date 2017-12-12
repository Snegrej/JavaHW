package com.app;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener{
    //Size of blocks (pixels)
    private int blockDimensions = 15;

    private int numRows = 31;
    private int numColumns = 31;


    private int[][] grid; //Game board
    private Coord[] snake;
    private Coord head;
    private int tail; //Last dot of snake, removes every tick and decrements to new tail
    private int score;
    private boolean playing;

    private Image[] img;
    private JLabel infoPanel;
    private Timer timer;
    private static int speed = 60; //gamespeed

    private boolean up = false;
    private boolean down = false;
    private boolean left = true;
    private boolean right = false;


    class Coord{
      public int row_Coord;
      public int column_Coord;
      public Coord(){
        row_Coord = 0;
        column_Coord = 0;
      }
      public Coord(int row, int column){
        row_Coord = row;
        column_Coord = column;
      }
    }

    public Snake(JLabel infoPanel) throws InterruptedException{
      System.out.println("Snake call");
      this.infoPanel = infoPanel;
      img = new Image[3];
      for (int i = 0; i < 3; i++) {
          img[i] = (new ImageIcon("src/main/resources/imageFiles/" + i + ".png")).getImage();
      }
      addKeyListener(new SnakeAdapter());
      setFocusable(true);
      newGame();
    }

    private void newGame() throws InterruptedException{
      System.out.println("newGame call");
      playing = true;
      score = 0;
      grid = new int[numRows][numColumns];
      snake = new Coord[numRows*numColumns];//Init Snake decay array
      tail = 0;
      for (int x = 0; x < numRows; x++) {
          for (int y = 0; y < numColumns; y++) {
              grid[x][y] = 0;
          }
      }
      grid[numRows/2][numColumns/2] = 1; //Create Snake Start in the middle
      snake[tail] = new Coord(numRows/2,numColumns/2); //Create Snake decay array
      head = snake[0];
      infoPanel.setText("Score:" + Integer.toString(score));
      timer = new Timer(speed,this);
      timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
      System.out.println("paintComponent call");
      int block;
      for (int row = 0; row < numRows; row++) {
          for (int column = 0; column < numColumns; column++) {
              block = grid[row][column];
              g.drawImage(img[block], (column * blockDimensions),
                  (row * blockDimensions), this);
          }
      }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (playing == true) {
        decrTail();
        moveHead();
        repaint();
      }
    // Repaint or 'render' our screen
}

    public void moveHead(){
        System.out.println("head call");
      if(right){
        head.column_Coord++;
        if(head.column_Coord<numColumns){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
        System.out.println(head.row_Coord + " , " + head.column_Coord);
      }
      if(left){
        head.column_Coord--;
        if(head.column_Coord>0){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(up){
        head.row_Coord--;
        if(head.row_Coord>0){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(down){
        head.row_Coord++;
        if(head.row_Coord<numRows){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      System.out.println("");
      if(tail+1<numRows*numColumns) snake[tail+1]=head;
    }

    public void decrTail(){
        System.out.println("decrTail call");
        if(playing){
          int row = snake[tail].row_Coord;
          int column = snake[tail].column_Coord;
          grid[row][column] = 0;
          if(score!=0){
            if(tail<numRows*numColumns)tail++;
          }
        }
    }
    public void checkGameState(){
    }

    public class SnakeAdapter extends KeyAdapter{
      @Override
      public void keyPressed(KeyEvent event) {
          switch (event.getKeyCode()) {
              case KeyEvent.VK_LEFT:
                  left = true;
                  up = false;
                  down = false;
                  right = false;
                  break;
              case KeyEvent.VK_DOWN:
                  down = true;
                  up = false;
                  left = false;
                  right = false;
                  break;
              case KeyEvent.VK_RIGHT:
                  right = true;
                  up = false;
                  down = false;
                  left = false;
                  break;
              case KeyEvent.VK_UP:
                  up = true;
                  down = false;
                  left = false;
                  right = false;
                  break;
              default:
                  break;
            }
        }
    }
}
