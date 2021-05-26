package Setting;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import SubScene.SettingSubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.GameView;
public class Setting extends Button {
    SettingSubScene settingSubScene;
    public Setting(){
        String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Setting/settingIcon.png')";
        int settingWidth=100,settingHeight=100;
        this.setPrefSize(settingWidth,settingHeight);
        this.setLayoutX(GameView.GAME_WIDTH+200-settingWidth);
        this.setLayoutY(0);
        this.setStyle(BUTTON_STYLE);
        this.setFocusTraversable(false);//無法被enter直接觸發,無法被自動選擇
        this.setVisible(true);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                settingSubScene.moveSubScene();
                System.out.println("setting");
            }
        });
        //this.setOnAction();

//        setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//            @Override
//
//            public void handle(MouseEvent event) {
//                setEffect(new DropShadow());
//
//            }
//        });
//        setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                setEffect(null);
//
//            }
//        });
    }
//
//    private void createSettingSubScene(){
//        settingSubScene=new SettingSubScene();                //will
//        this.getChildren().add(settingSubScene);
//    }


}
