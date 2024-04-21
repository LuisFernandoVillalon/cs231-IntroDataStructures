package PA5_Invaders.src.test.java;

import javafx.scene.paint.*;

public class Constants
{
   public static String MATRIX_DIRECTORY = "PA5_Invaders/src/main/java/InvaderMatrices";
   public static long TIME_INTERVAL = 16000000;
   public static int PERIOD = 5;
   public static int FORMATION_PERIOD = 40*PERIOD;
   public static int SCALE = 3;
   public static int WIDTH = 600;
   public static int HEIGHT = 400;
   
   public static int PLAYER_ROWS = 9;
   public static int PLAYER_COLS = 13;
   public static int PLAYER_WIDTH = SCALE*PLAYER_ROWS;
   public static int PLAYER_HEIGHT = SCALE*PLAYER_COLS;
   public static int PLAYER_SPEED = 3;
   public static int PLAYER_DIRECTION = 0;
   
   public static int ALIEN_ROWS = 8;
   public static int ALIEN_COLS = 12;
   public static int ALIEN_WIDTH = SCALE*ALIEN_ROWS;
   public static int ALIEN_HEIGHT = SCALE*ALIEN_COLS;
   public static int ALIEN_SPEED = 1;
   public static int SQUID_SPEED = 2;
   public static int CRAB_SPEED = 5;
   public static int OCTOPUS_SPEED = 20;
   public static int MAX_SQUIDS = 12;
   public static int MIN_SQUIDS = 6;
   public static int MAX_CRABS = 8;
   public static int MIN_CRABS = 4;
   public static int MAX_OCTOPUS = 6;
   public static int MIN_OCTOPUS = 2;
   
   public static int BULLET_SPEED = 4;
   public static int BULLET_WIDTH = 5;
   public static int BULLET_HEIGHT = 10;
   
   public static Color PLAYER_COLOR = Color.LAVENDER;
   public static Color BULLET_COLOR = Color.WHITE;
   public static Color SQUID_COLOR = Color.GREEN;
   public static Color CRAB_COLOR = Color.BLUE;
   public static Color OCTOPUS_COLOR = Color.RED;
   public static Color BACKGROUND_COLOR = Color.BLACK;
}