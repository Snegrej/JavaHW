package com.app;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Snake extends JPanel{
    //Size of blocks (pixels)
    private int blockDimensions = 15;

    private int numRows = 30;
    private int numColumns = 30;


    private int[][] grid; //Game board
    private Coord[] snake;
    private int tail; //Last dot of snake, removes every tick and decrements to new tail
    private int score;
    private boolean playing;

    private Image[] img;
    private JLabel infoPanel;

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

    public Snake(JLabel infoPanel){
      this.infoPanel = infoPanel;
      img = new Image[3];
      for (int i = 0; i < 3; i++) {
          img[i] = (new ImageIcon("src/main/resources/imgFiles/" + i + ".png")).getImage();
      }
      newGame();
    }

    private void newGame(){

//Create board
//set Head and tail
//wait for keypress

/*create new head at direction (check gamestate)
//if new block was red, pause tail
//else update tail
*/    playing = true;
      score = 0;
      grid = new int[numRows][numColumns];
      snake = new Coord[numRows*numColumns];//Init Snake decay array
      tail = 0;
      for (int x = 0; x < numRows; x++) {
          for (int y = 0; y < numColumns; y++) {
              grid[x][y] = 0;
          }
      }
      grid[numRows/2][numColumns/2] = 1; //Create Snake Start
      snake[0] = new Coord(numRows/2,numColumns/2); //Create Snake decay array
      infoPanel.setText("Score:" + Integer.toString(score));
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
    public void decrTail(){
      int row = snake[tail].row_Coord;
      int column = snake[tail].column_Coord;
      grid[row][column] = 0;
      if(tail!=0) tail--;
    }

    /*class MinesAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent click) {

            int x = click.getX();
            int y = click.getY();
            int cCol = x / blockDimensions;
            int cRow = y / blockDimensions;
            boolean rep = false;


            if (!playing) {
                newGame();
                repaint();
            }

        }
    }*/

}
