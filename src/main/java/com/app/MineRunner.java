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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MineRunner extends JPanel implements ActionListener{
    //Size of blocks (pixels)
    private int blockDimensions = 15;

    private final int numRows = 31;
    private final int numColumns = 31;
    private final int maxBlocks = numRows*numColumns;


    private int[][] grid; //Game board
    private Coord[] snake;
    private Coord head;
    private int tail; //Last dot of snake, removes every tick and decrements to new tail
    private int score;
    private boolean playing;

    private Image[] img;
    private JLabel infoPanel;
    private Timer timer;
    private final static int speed = 70; //gamespeed

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private boolean eaten = false;


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

    public MineRunner(JLabel infoPanel) throws InterruptedException{
      this.infoPanel = infoPanel;
      img = new Image[3];
      for (int i = 0; i < 3; i++) {
          img[i] = (new ImageIcon("src/main/resources/imageFiles/" + i + ".png")).getImage();
      }
      timer = new Timer(speed,this);
      addKeyListener(new MineRunnerAdapter());
      setFocusable(true);
      newGame();
    }

    private void newGame() throws InterruptedException{
      playing = true;
      score = 0;
      grid = new int[numRows][numColumns];
      snake = new Coord[maxBlocks];//Init Snake decay array
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
      timer.start();
      spawnMine();
    }

    @Override
    public void paintComponent(Graphics g) {
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
        if(!eaten){
          decrTail();
        }else{
          spawnMine();
          score++;
          infoPanel.setText("Score:" + Integer.toString(score));
          eaten = false;
        }
        moveHead();
        repaint();
      }else{
        timer.stop();
      }
}

    public void moveHead(){
      if(right){
        head.column_Coord++;
        if(head.column_Coord<numColumns){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            if(grid[head.row_Coord][head.column_Coord]==2) eaten=true;
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(left){
        head.column_Coord--;
        if(head.column_Coord>=0){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            if(grid[head.row_Coord][head.column_Coord]==2) eaten=true;
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(up){
        head.row_Coord--;
        if(head.row_Coord>=0){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            if(grid[head.row_Coord][head.column_Coord]==2) eaten=true;
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(down){
        head.row_Coord++;
        if(head.row_Coord<numRows){
          if(grid[head.row_Coord][head.column_Coord]!=1){
            if(grid[head.row_Coord][head.column_Coord]==2) eaten=true;
            grid[head.row_Coord][head.column_Coord] = 1;
          }else playing = false;
        }else playing = false;
      }
      if(tail+score<maxBlocks){
        snake[tail+score]=head;
      }else{
        snake[tail+score-maxBlocks] = head;
      }
    }

    public void decrTail(){
        if(playing){
          int row = snake[tail].row_Coord;
          int column = snake[tail].column_Coord;
          grid[row][column] = 0;
          if(score!=0){
            if(tail<maxBlocks){
              tail++;
            }else{
              System.out.println("tail set to 0");
              tail = 0;
            }
          }
        }
    }
    public void spawnMine(){
      int n1, n2;
      Random random = new Random();
      n1 = random.nextInt(numRows);
      n2 = random.nextInt(numColumns);
      while(grid[n1][n2]==1){
        n1 = random.nextInt(numRows);
        n2 = random.nextInt(numColumns);
      }
      grid[n1][n2] = 2;
    }

    public class MineRunnerAdapter extends KeyAdapter{
      @Override
      public void keyPressed(KeyEvent event) {
        if(!playing){
            try {
                newGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(MineRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
