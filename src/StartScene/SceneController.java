package application;

import java.io.File;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class SceneController implements Runnable{
	@FXML
	private Stage stage;
	private Scene scene;
	public void switchToSettingScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SettingScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToStartScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchInputScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("InputNameScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void Exit(ActionEvent event) throws Exception{
		System.exit(0);
	}
	@FXML
	TextField playerName;
	String Name;
	public void switchIntroduce(ActionEvent event) throws IOException {
		Name=playerName.getText().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("Introduce.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	@FXML
	Button Skip;
	@FXML
	Label intro;
	int count=0;
	public void Skip(ActionEvent event) throws Exception{
		
		if(count==0) {
			Thread.sleep(500);
			intro.setText("1948�~�Ĥ@���H���Ԫ��z�o�A�j�q����ŧ���H��C");
			intro.setFont(Font.font("DFKai-SB",16));
			count++;
		}
		else if(count==1) {
			Thread.sleep(500);
			intro.setText("1948�~�Ĥ@���H���Ԫ��z�o�A�j�q����ŧ���H��C\n"+Name+"�b�Ԫ����M���������A�ظ@�;�M�����G��");
			count++;
		}
		else if(count==2) {
			Thread.sleep(500);
			intro.setText("1948�~�Ĥ@���H���Ԫ��z�o�A�j�q����ŧ���H��C\n"+Name+"�b�Ԫ����M���������A�ظ@�;�M�����G��\n�Ԫ���A"+Name+"�Q�I���Ǻ��t��|���|���R�f���i");
			count++;
		}
		else if(count==3) {
			Thread.sleep(500);
			intro.setText("1948�~�Ĥ@���H���Ԫ��z�o�A�j�q����ŧ���H��C\n"+Name+"�b�Ԫ����M���������A�ظ@�;�M�����G��\n�Ԫ���A"+Name+"�Q�I���Ǻ��t��|���|���R�f���i\n�M�ӥL�o�F�ԫᥢ�Яg�A���O�o�����ۤv�٦��������O��");
			count++;
		}
			
		else if(count==4) {
			Thread.sleep(500);
			intro.setText("1948�~�Ĥ@���H���Ԫ��z�o�A�j�q����ŧ���H��C\n"+Name+"�b�Ԫ����M���������A�ظ@�;�M�����G��\n�Ԫ���A"+Name+"�Q�I���Ǻ��t��|���|���R�f���i\n�M�ӥL�o�o�F�ԫᥢ�Яg�A���O�o�ۤv�O���٦��M�����������O��\n�M�ӴN�b�o�@�ѡA�|���i���L...");
			count++;
		}
		else if(count==5) {
			
		}
		}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
