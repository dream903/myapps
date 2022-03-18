package chat;

import java.io.File;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JMSChat extends Application {
	
	
private MessageProducer messageProducer;
private Session session;
private String codeUser;

	public static void main(String[] args) {
		Application.launch(JMSChat.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JMS chat");
		BorderPane borderPane = new BorderPane();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
//		hbox.setBackground(new Background(new BackgroundFill(Color.BLUEn, CornerRadii.EMPTY, Insets.EMPTY)));
		Label labelCode = new Label("code:");
		TextField textFieldCode = new TextField("C1");
		textFieldCode.setPromptText("code");

		Label labelHost = new Label("Host:");
		TextField textFieldHost = new TextField("localhost");

		textFieldHost.setPromptText("localhost");

		Label labelPort = new Label("Port:");
		TextField textFieldPort = new TextField("61616");

		textFieldHost.setPromptText("Port");
		Button buttonConnecter = new Button("Connecter");

		hbox.getChildren().add(labelCode);
		hbox.getChildren().add(textFieldCode);

		hbox.getChildren().add(labelHost);
		hbox.getChildren().add(textFieldHost);

		hbox.getChildren().add(labelPort);
		hbox.getChildren().add(textFieldPort);
		hbox.getChildren().add(buttonConnecter);

		borderPane.setTop(hbox);

			VBox vBox=new VBox();
		
		GridPane gridPane=new GridPane();
		HBox hbox2=new HBox();
		vBox.getChildren().add(gridPane);
		vBox.getChildren().add(hbox2);
		
		borderPane.setCenter(vBox);
		
		Label labelTo=new Label("To:");
		TextField textFieldTo=new TextField("C1");
		Label labelMessage=new Label("Message");
		TextArea textAreaMessage=new TextArea();
		Button buttonEnvoyer=new Button("Envoyer");
		Label labelImage=new Label("Image");
		File f=new File("Image");
		ObservableList<String> observableListImages=FXCollections.observableArrayList(f.list());
		
		ComboBox<String> comboBoxImages=new ComboBox<String>(observableListImages);
		comboBoxImages.getSelectionModel().select(0);
		Button buttonEnvoyerImage=new Button("Envoyer Image");
		
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(10);gridPane.setHgap(10);
		textAreaMessage.setPrefRowCount(1);
		gridPane.add(labelTo, 0, 0);gridPane.add(textFieldTo, 1, 0);
		gridPane.add(labelMessage,0,1);		gridPane.add(textAreaMessage, 1, 1);
		gridPane.add(buttonEnvoyer, 2, 1);
		gridPane.add(labelImage, 0, 2);
		gridPane.add(comboBoxImages, 1,2);
		gridPane.add(buttonEnvoyerImage, 3, 2);
		
		ObservableList<String> observableListMessages=FXCollections.observableArrayList();

		ListView<String> listViewMessages=new ListView<>(observableListMessages);
		File f2=new File("image/"+comboBoxImages.getSelectionModel().getSelectedItem());
		Image image=new Image(f2.toURI().toString());
		ImageView imageView =new ImageView(image);
		imageView.setFitWidth(320);imageView.setFitHeight(240);
		hbox2.getChildren().add(listViewMessages);
		hbox2.getChildren().add(imageView);
		
		
				Scene scene = new Scene(borderPane, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		comboBoxImages.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			File f3=new File("image/"+newValue);
			Image image=new Image(f3.toURI().toString());
			 imageView.setImage(image)	;		
			}
			
		});
	buttonEnvoyer.setOnAction(e->{
		try {
			TextMessage textMessage=session.createTextMessage();
			textMessage.setText(textAreaMessage.getText());
			textMessage.setStringProperty("code", textFieldTo.getText());
			messageProducer.send(textMessage);
			
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	buttonConnecter.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			try {
				String codeUser = textFieldCode.getText();
				String host = textFieldHost.getText();
				int port = Integer.parseInt(textFieldPort.getText());
				ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://" + host+":" + port);
				Connection connection=connectionFactory.createConnection();
				connection.start();
				session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
				Destination destination=session.createTopic("ilh.chat");
				MessageConsumer messageconsumer=session.createConsumer(destination,"code='"+codeUser+"'");
				 messageProducer=session.createProducer(destination);
				messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//				,"code='"+codeUser+"'"
			    messageconsumer.setMessageListener(message->
			    { try {
			    	if(message instanceof TextMessage) {
			   
			    	TextMessage textMessage=(TextMessage) message;
			    	observableListMessages.add(textMessage.getText());
					System.out.println(textMessage.getText());
					}
			    	else if (message instanceof StreamMessage) {
			    		
			    		
			    	}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    	});
			    }
		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});


	
	}
	

}
