package view;

import Player.Player;
import SubScene.FatherRoomSubScene;
import SubScene.LetterSubScene;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static java.lang.Math.abs;

public class FatherRoom {
    private Scene gameScene;
    private Stage fatherroomStage;
    private Stage livingStage;
    boolean fatherisactive=true;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView openWardrobe = new ImageView(new Image(getClass().getResourceAsStream(("WARDROBE.png"))));
    boolean openwar;
    Player player1=new Player(imageView);
    double playerX,playerY,warX,warY;
   

    private boolean removeFatherRoom=true;

    FatherRoomSubScene boxSubScene;

    public FatherRoom() {
    	openwar = true;
    	 warX = 0;
    	 warY = 0;
    	
    	openWardrobe.setLayoutX(warX);
    	openWardrobe.setLayoutY(warY);
    	root.getChildren().add(openWardrobe);
    	openWardrobe.setVisible(false);
    	
        gameScene = new Scene(root, GameView.GAME_WIDTH, GameView.GAME_HEIGHT);
        fatherroomStage = new Stage();
        fatherroomStage.setScene(gameScene);
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S){
                	fatherisactive = true;
                    System.out.println("check");
                    System.out.println(playerX+", "+playerY);
                    if(playerX>=warX && playerX<=warX+70 && playerY<=warY+200 &&openwar) {
                    	System.out.println("open the wardrobe");
                    	openwar = false;
                    	//wardrobe.moveSubscene();
                    	openWardrobe.setVisible(true);
                    }else {
                    	openwar = true;
                    	openWardrobe.setVisible(false);
                    }
                    if(playerX>600&&playerY<50){
                        System.out.println("try to lock");
                        boxSubScene.moveSubScene();
                    }
                    fatherisactive=false;
                }
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { fatherisactive=false;
                
                }
            }});
        root.getChildren().add(player1);
        player1.setTranslateX(GameView.GAME_WIDTH-Player.PLAYER_WIDTH);//�_�l��m
        player1.setTranslateY(GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT);//�_�l��m
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();
                if(playerX==GameView.GAME_WIDTH-Player.PLAYER_WIDTH&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.direction.equals(GameView.Direction.right)&&removeFatherRoom){
                    double playerX=16*Player.PACE_SIZE,playerY=16*Player.PACE_SIZE;
                    System.out.println("go to LivingRoom");
                    GameView gameView=new GameView(playerX,playerY,true);
                    gameView.createNewGame(fatherroomStage);
                    removeFatherRoom=false;
                }
                
                player1.updateFatherRoom(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();
        createFatherRoomSubScene();
    }
    public void createfatherroom(Stage menuStage,Player player,Pane pane){
        pane.getChildren().remove(player);
        player.setTranslateX(playerX);player.setTranslateY(playerY);
        this.livingStage=menuStage;
        this.livingStage.close();
        fatherroomStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("fatherroom.png",GameView.GAME_WIDTH,GameView.GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    private void createFatherRoomSubScene(){
        boxSubScene=new FatherRoomSubScene(fatherroomStage);
        root.getChildren().add(boxSubScene);
    }



}