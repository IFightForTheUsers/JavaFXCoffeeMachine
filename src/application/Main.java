package application;
	
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		primaryStage.setTitle("JavaFX Coffee Machine");
		
		//System.out.println(Font.getFontNames());
		
		Label labelForSize = new Label("What size?");
		labelForSize.setPadding(new Insets(10));
		labelForSize.setFont(Font.font(30));
		
		final ToggleGroup sizes = new ToggleGroup();
		
		HBox buttonsForSize = new HBox();
		buttonsForSize.setPadding(new Insets(0, 20, 10, 20));
		
		RadioButton eight = new RadioButton("8oz");
		eight.setToggleGroup(sizes);
		eight.setPadding(new Insets(0, 10, 0, 10));
		RadioButton twelve = new RadioButton("12oz");
		twelve.setSelected(true);
		twelve.setToggleGroup(sizes);
		twelve.setPadding(new Insets(0, 10, 0, 10));
		RadioButton sixteen = new RadioButton("16oz");
		sixteen.setToggleGroup(sizes);
		sixteen.setPadding(new Insets(0, 10, 0, 10));
		RadioButton twenty = new RadioButton("20oz");
		twenty.setToggleGroup(sizes);
		twenty.setPadding(new Insets(0, 10, 0, 10));
		RadioButton thirtytwo = new RadioButton("32oz");
		thirtytwo.setToggleGroup(sizes);
		thirtytwo.setPadding(new Insets(0, 10, 0, 10));
		
		buttonsForSize.getChildren().addAll(eight, twelve, sixteen, twenty);
		
		Label labelForDrinks = new Label("What kind of drink?");
		labelForDrinks.setPadding(new Insets(10));
		labelForDrinks.setFont(Font.font(30));
		
		final ToggleGroup drinks = new ToggleGroup();
		
//		HBox buttonsForDrinks = new HBox();
//		
//		RadioButton drip = new RadioButton("Drip Coffee");
//		drip.setToggleGroup(drinks);
//		drip.setPadding(new Insets(0, 10, 0, 10));
//		RadioButton latte = new RadioButton("Latte");
//		latte.setToggleGroup(drinks);
//		latte.setPadding(new Insets(0, 10, 0, 10));
//		RadioButton mocha = new RadioButton("Mocha");
//		mocha.setToggleGroup(drinks);
//		mocha.setPadding(new Insets(0, 10, 0, 10));
//		RadioButton caramelMacchiato = new RadioButton("Caramel Macchiato");
//		caramelMacchiato.setSelected(true);
//		caramelMacchiato.setToggleGroup(drinks);
//		caramelMacchiato.setPadding(new Insets(0, 10, 0, 10));
//		
//		buttonsForDrinks.getChildren().addAll(drip, latte, mocha, caramelMacchiato);
		
		GridPane buttonsForDrinks = new GridPane();
		buttonsForDrinks.setPadding(new Insets(0, 20, 10, 20));
		
		RadioButton drip = new RadioButton("Drip Coffee");
		drip.setToggleGroup(drinks);
		drip.setPadding(new Insets(5, 20, 5, 20));
		RadioButton latte = new RadioButton("Latte");
		latte.setToggleGroup(drinks);
		latte.setPadding(new Insets(5, 20, 5, 20));
		RadioButton mocha = new RadioButton("Mocha");
		mocha.setToggleGroup(drinks);
		mocha.setPadding(new Insets(5, 20, 5, 20));
		RadioButton caramelMacchiato = new RadioButton("Caramel Macchiato");
		caramelMacchiato.setSelected(true);
		caramelMacchiato.setToggleGroup(drinks);
		caramelMacchiato.setPadding(new Insets(5, 20, 5, 20));
		RadioButton cappuccino = new RadioButton("Cappuccino");
		cappuccino.setToggleGroup(drinks);
		cappuccino.setPadding(new Insets(5, 20, 5, 20));
		RadioButton coldBrew = new RadioButton("Cold Brew");
		coldBrew.setToggleGroup(drinks);
		coldBrew.setPadding(new Insets(5, 20, 5, 20));
		
		
		buttonsForDrinks.getChildren().addAll(drip, latte, mocha, caramelMacchiato, cappuccino, coldBrew);
		
		GridPane.setConstraints(drip, 0, 0);
		GridPane.setConstraints(latte, 1, 0);
		GridPane.setConstraints(mocha, 0, 1);
		GridPane.setConstraints(caramelMacchiato, 1, 1);
		GridPane.setConstraints(cappuccino, 0, 2);
		GridPane.setConstraints(coldBrew, 1, 2);
		
		Label labelForTemp = new Label("Iced or Hot?");
		labelForTemp.setPadding(new Insets(10));
		labelForTemp.setFont(Font.font(30));
		
		final ToggleGroup icedOrHot = new ToggleGroup();
		
		HBox buttonsForTemp = new HBox();
		buttonsForTemp.setPadding(new Insets(0, 20, 10, 20));
		
		RadioButton iced = new RadioButton("Iced");
		iced.setToggleGroup(icedOrHot);
		iced.setPadding(new Insets(0, 50, 0, 50));
		iced.setSelected(true);
		RadioButton hot = new RadioButton("Hot");
		hot.setToggleGroup(icedOrHot);
		hot.setPadding(new Insets(0, 50, 0, 50));
		
		buttonsForTemp.getChildren().addAll(iced, hot);
		
		Label labelForShots = new Label("# of shots: ");
		labelForShots.setFont(Font.font(30));
		
		TextField shotsInput = new TextField("2");
		shotsInput.setPadding(new Insets(10));
		shotsInput.setPrefWidth(40);
		shotsInput.setId("shots");
		
		CheckBox decafBox = new CheckBox("Decaf");
		decafBox.setPadding(new Insets(7, 10, 13, 40));
		
		HBox shots = new HBox();
		shots.setPadding(new Insets(20, 20, 10, 10));
		
		shots.getChildren().addAll(labelForShots, shotsInput, decafBox);
		
		Label labelForName = new Label("Name for the order:");
		labelForName.setFont(Font.font(30));
		
		TextField nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setPrefWidth(300);
		nameInput.setMaxWidth(300);
		nameInput.setPadding(new Insets(10));
		nameInput.setId("name");
		
		VBox name = new VBox();
		name.setAlignment(Pos.CENTER);
		name.setPadding(new Insets(20, 20, 0, 10));
		name.getChildren().addAll(labelForName, nameInput);
		
		StackPane sbmt = new StackPane();
		sbmt.setPadding(new Insets(10, 0, 0, 0));
		Button submit = new Button("Submit Order");
		submit.setPadding(new Insets(10));
		
		sbmt.getChildren().add(submit);
		
		submit.setOnAction(e -> {
			
			boolean decaf = false;
			
			if (decafBox.isSelected())
				decaf = true;
			
			String size = ((Labeled)sizes.getSelectedToggle()).getText();
			String temp = ((Labeled)icedOrHot.getSelectedToggle()).getText();
			String drink = ((Labeled)drinks.getSelectedToggle()).getText();
			String numOfShots = shotsInput.getText();
			String customer = nameInput.getText();
			
			String str = "\n" + size + " " + temp + " " + drink + 
					   " with " + numOfShots + " shots " + "for " + customer;
			
			System.out.println(str);
			
			StringBuilder hash = null;
			
			try {
				hash = getHash(str);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
			OrderIn.baristaScreen(str, size, temp, drink, numOfShots, decaf, customer, hash);
			OrderIn.customerReceipt(str, size, temp, drink, numOfShots, decaf, customer, hash);
		});
		
		root.getChildren().addAll(labelForSize, buttonsForSize, 
									labelForDrinks, buttonsForDrinks, 
										labelForTemp, buttonsForTemp,
											shots, name, sbmt);
		
		root.setPadding(new Insets(10, 20, 10, 20));
		
		eight.setOnAction(e -> {
			cappuccino.setDisable(false);
		});
		
		twelve.setOnAction(e -> {
			cappuccino.setDisable(false);
		});
		
		sixteen.setOnAction(e -> {
			if(cappuccino.isSelected())
				latte.setSelected(true);
			cappuccino.setDisable(true);
		});
		
		twenty.setOnAction(e -> {
			if(cappuccino.isSelected())
				latte.setSelected(true);
			cappuccino.setDisable(true);
		});
		
		drip.setOnAction(e -> {
			if (iced.isSelected())
				hot.setSelected(true);
			sixteen.setDisable(false);
			twenty.setDisable(false);
			iced.setDisable(true);
			hot.setDisable(false);
			decafBox.setDisable(false);
			if (!shotsInput.getText().equals("")) {
				shotsInput.setText("");
				shotsInput.setDisable(true);
			}
		});
		
		latte.setOnAction(e -> {
			if (shotsInput.isDisabled()) {
				shotsInput.setDisable(false);
				shotsInput.setText("2");
			}
			sixteen.setDisable(false);
			twenty.setDisable(false);
			iced.setDisable(false);
			hot.setDisable(false);
			decafBox.setDisable(false);
		});
		
		mocha.setOnAction(e -> {
			if (shotsInput.isDisabled()) {
				shotsInput.setDisable(false);
				shotsInput.setText("2");
			}
			sixteen.setDisable(false);
			twenty.setDisable(false);
			iced.setDisable(false);
			hot.setDisable(false);
			decafBox.setDisable(false);
		});
		
		caramelMacchiato.setOnAction(e -> {
			if (shotsInput.isDisabled()) {
				shotsInput.setDisable(false);
				shotsInput.setText("2");
			}
			sixteen.setDisable(false);
			twenty.setDisable(false);
			iced.setDisable(false);
			hot.setDisable(false);
			decafBox.setDisable(false);
		});
		
		cappuccino.setOnAction(e -> {
//			System.out.println(e.getSource());
			if (shotsInput.isDisabled()) {
				shotsInput.setDisable(false);
				shotsInput.setText("2");
			}
			if (iced.isSelected())
				hot.setSelected(true);
//			if (sixteen.isSelected())
//				twelve.setSelected(true);
//			else if (twenty.isSelected())
//				twelve.setSelected(true);
			sixteen.setDisable(true);
			twenty.setDisable(true);
			iced.setDisable(true);
			decafBox.setDisable(false);
		});
		
		coldBrew.setOnAction(e -> {
			if (hot.isSelected())
				iced.setSelected(true);
			sixteen.setDisable(false);
			twenty.setDisable(false);
			iced.setDisable(false);
			hot.setDisable(true);
			if (decafBox.isSelected())
				decafBox.setSelected(false);
			decafBox.setDisable(true);
			if (!shotsInput.getText().equals("")) {
				shotsInput.setText("");
				shotsInput.setDisable(true);
			}
		});
		
		Scene scene = new Scene(root,520,660);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX(primScreenBounds.getWidth() * 0.155);
		primaryStage.setY(primScreenBounds.getHeight() * 0.08);
		
		primaryStage.show();

	}
	
	private StringBuilder getHash(String str) throws UnsupportedEncodingException {
		
		StringBuilder hashed = null;
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
			
			hashed = new StringBuilder();
	        for (byte b : digest) {
	        	hashed.append(String.format("%02x", b));
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashed;
		
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
