package PA5_Invaders.src.test.java;

import PA5_Invaders.src.main.java.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.animation.AnimationTimer;

public class App extends Application
{
   private Group root = new Group();
   private Scene scene = new Scene(root, Constants.WIDTH, Constants.HEIGHT, Constants.BACKGROUND_COLOR);
   private Canvas canvas = new Canvas(Constants.WIDTH, Constants.HEIGHT);
   private GraphicsContext gc = canvas.getGraphicsContext2D();
   
   private KeyHandler keyHandler = new KeyHandler();
   private Timer timer = new Timer();
   
   private ArrayList<Invader> invaders = new ArrayList<>();
   private ArrayList<Bullet> gun = new ArrayList<>();
   private Player player = new Player(Constants.WIDTH/2-Constants.PLAYER_WIDTH/2,
      Constants.HEIGHT-Constants.PLAYER_HEIGHT);
   
   @Override
   public void start( Stage stage )
   {
      System.out.println( Constants.MATRIX_DIRECTORY );
      timer.start();
      
      scene.setOnKeyPressed( keyHandler );
      root.getChildren().add( canvas );
      stage.setScene( scene );
      stage.show();
   }
   
   private void addFormation()
   {
      int formationType = (int)(3*Math.random()) + 1;
      if( formationType == 1 )
      {
         addSquids();
      }else if( formationType == 2 )
      {
         addCrabs();
      }else if( formationType == 3 )
      {
         addOctopus();
      }
   }
   
   private void renderCanvas()
   {
      gc.setFill( Constants.BACKGROUND_COLOR );
      gc.fillRect( 0, 0, Constants.WIDTH, Constants.HEIGHT );
      
      drawPlayer();
           
      for( Invader vader : invaders )
      {         
         if( vader.alive() )
            drawInvader( vader );
      }
      
      for( Bullet bullet : gun )
      {
         if( bullet.live() )
         {
            gc.setFill( Constants.BULLET_COLOR );
            gc.fillRect( bullet.getPosition().getX(), bullet.getPosition().getY()-Constants.BULLET_HEIGHT,
               Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);
         }
      }
   }
   
   private void checkKills()
   {
      for( Invader vader : invaders )
         for( Bullet bullet : gun )   
            if( vader.getPosition().collision( bullet.getPosition() ) && vader.alive() && bullet.live() )
            {
              
               vader.hit();
               bullet.hit();
            }
   }
   
   private void addSquids()
   {
      int numSquids = (int)(Constants.MAX_SQUIDS*Math.random());
      if( numSquids < Constants.MIN_SQUIDS )
         numSquids = Constants.MIN_SQUIDS;
         
      int dx = (Constants.WIDTH - Constants.ALIEN_WIDTH)/numSquids;
      int x = 0;
      for( int i = 0; i < numSquids; i++ )
      {
         invaders.add( new Squid(x, 0) );
         x += dx;
      }
   }
      
   private void addCrabs()
   {
      int numCrabs = (int)(Constants.MAX_CRABS*Math.random());
      if( numCrabs < Constants.MIN_CRABS )
         numCrabs = Constants.MIN_CRABS;
         
      int dx = (Constants.WIDTH - Constants.ALIEN_WIDTH)/numCrabs;
      int x = 0;
      for( int i = 0; i < numCrabs; i++ )
      {
         invaders.add( new Crab(x, 0) );
         x += dx;
      }
   }
   
   private void addOctopus()
   {
      int numOctopus = (int)(Constants.MAX_OCTOPUS*Math.random());
      if( numOctopus < Constants.MIN_OCTOPUS )
         numOctopus = Constants.MIN_OCTOPUS;
         
      int dx = (Constants.WIDTH - Constants.ALIEN_WIDTH)/numOctopus;
      int x = 0;
      for( int i = 0; i < numOctopus; i++ )
      {
         Octopus invader = new Octopus(x, 0);
         invaders.add( invader );
         invader.setXLlim( x );
         invader.setXUlim( x+dx );
         x += dx;
      }
   }
   
   private void drawPlayer( )
   {
      gc.setFill( Constants.PLAYER_COLOR );
      boolean[][] body = player.getBody();
      double x = player.getPosition().getX();
      double y = player.getPosition().getY();
      helperDrawer( body, x, y );
   }
   
   private void drawInvader( Invader vader )
   {
      gc.setFill( vader.getColor() );
      boolean[][] body = vader.getBody();
      double x = vader.getPosition().getX();
      double y = vader.getPosition().getY();
      helperDrawer( body, x, y );
   }   
   
   private void helperDrawer( boolean[][] body, double x, double y )
   {
      double savedX = x;
      for( boolean[] row : body )
      {
         for( boolean b : row )
         {
            if( b )
            {
               gc.fillRect(x, y, Constants.SCALE, Constants.SCALE);
            }
            x += Constants.SCALE;
         }
         x = savedX;
         y += Constants.SCALE;
      }
   }
   
   private void shoot()
   {
      double y = Constants.HEIGHT - Constants.PLAYER_HEIGHT;
      double x = player.getPosition().getX() + Constants.PLAYER_WIDTH/2 + Constants.SCALE;
      gun.add( new Bullet(x, y) );
   }
   
   class Timer extends AnimationTimer
   {
      long last = Constants.TIME_INTERVAL;
      long lastt = Constants.TIME_INTERVAL;
      
      @Override
      public void handle( long now )
      {
         checkKills();
         renderCanvas();
         player.move( Constants.PLAYER_DIRECTION*Constants.PLAYER_SPEED );
         for( Bullet bullet : gun )
            bullet.move();  
         if( now - last > Constants.PERIOD*Constants.TIME_INTERVAL )
         {  
            invaders.removeIf( x -> !x.alive() );     //remove dead invaders
            gun.removeIf( x -> !x.live() );           //remove dead bullets
            for( Invader vader : invaders )          
               vader.move();         
            
            last = now;
         }
         
         if( now - lastt > Constants.FORMATION_PERIOD*Constants.TIME_INTERVAL )
         {
            addFormation();
            lastt = now;
         }
      }
   }
   
   class KeyHandler implements EventHandler<KeyEvent>
   {
      @Override
      public void handle( KeyEvent e )
      {
         if( e.getCode() == KeyCode.SPACE )
         {
            shoot();
         }
         if( e.getCode() == KeyCode.LEFT )
         {
            Constants.PLAYER_DIRECTION = -1;
         }
         if ( e.getCode() == KeyCode.RIGHT )
         {
            Constants.PLAYER_DIRECTION = 1;
         }
      }
   }
}