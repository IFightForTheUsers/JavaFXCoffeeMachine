package application;

import java.io.UnsupportedEncodingException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class OrderIn{

	public static void baristaScreen(String str, String size, String temp, String drink, String numOfShots, boolean decaf, String customer, StringBuilder hash) {
		Stage barista = new Stage();
		barista.setTitle("Order In");
		
		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		
		layout.setStyle("-fx-padding: 20;" + "-fx-border-style: dashed inside;"
		        + "-fx-border-width: 10;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: chartreuse;");
		
		System.out.println("\n--------------------------\n"
				+ "ORDER DETAILS FOR BARISTA:\n" + 
				"~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"Size: " + size.toUpperCase() + "\n" +
				"Temp: " + temp.toUpperCase() + "\n" +
				"Drink: " + drink.toUpperCase() + "\n" +
				"Shots: " + numOfShots + "\n" +
				"Customer: " + customer.toUpperCase() + "\n" +
				"HashCode: \n" + hash + "\n" +
				"Callout: " + hash.substring(hash.length()-5).toUpperCase() + "\n" +
				"--------------------------"
				);
		
		Label orderIn = new Label("ORDER IN!");
		orderIn.setFont(Font.font("Consolas", 30));
		Label sizeLabel = new Label("\n" + size);
		sizeLabel.setFont(Font.font("Consolas", 16));
		Label tempLabel = new Label(temp.toUpperCase());
		tempLabel.setFont(Font.font("Consolas", 16));
		Label drinkLabel = new Label(drink.toUpperCase());
		drinkLabel.setFont(Font.font("Consolas", 16));
		Label shotsLabel = new Label(numOfShots + " SHOTS");
		shotsLabel.setFont(Font.font("Consolas", 16));
		if (numOfShots.equals(""))
			shotsLabel.setText("");
		if (decaf)
			shotsLabel.setText(shotsLabel.getText() + " (DECAF)");
		Label customerLabel = new Label("\n" + customer.toUpperCase());
		customerLabel.setFont(Font.font("Consolas", 16));
		Label hashLabel = new Label("\nHash Callout:");
		hashLabel.setFont(Font.font("Consolas", 16));
		Label calloutLabel = new Label(hash.substring(hash.length()-5).toUpperCase());
		calloutLabel.setFont(Font.font("Consolas", 30));
		
		layout.getChildren().addAll(orderIn, sizeLabel, tempLabel, drinkLabel, shotsLabel, customerLabel, hashLabel, calloutLabel);
		
		Scene scene = new Scene(layout, 300, 415);
		barista.setScene(scene);
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		barista.setX(primScreenBounds.getWidth() * 0.7);
		barista.setY(primScreenBounds.getHeight() * 0.2);
		barista.show();
	}

	public static void customerReceipt(String str, String size, String temp, String drink, String numOfShots, boolean decaf, String customer, StringBuilder hash) {
		
		Stage customerReceipt = new Stage();
		customerReceipt.setTitle("Order In");
		
		VBox layout = new VBox();
		
		
		layout.setStyle("-fx-padding: 20;" + "-fx-border-style: dashed inside;"
		        + "-fx-border-width: 10;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: purple;");
		
		Label customerLabel = new Label("Thanks, " + customer);
		customerLabel.setFont(Font.font("Consolas", 30));
		customerLabel.setWrapText(true);
		Label sizeLabel = new Label("\nSize: " + size);
		sizeLabel.setFont(Font.font("Consolas", 16));
		Label tempLabel = new Label("Temp: " + temp);
		tempLabel.setFont(Font.font("Consolas", 16));
		Label drinkLabel = new Label("Drink: " + drink);
		drinkLabel.setFont(Font.font("Consolas", 16));
		Label shotsLabel = new Label("Shots: " + numOfShots);
		shotsLabel.setFont(Font.font("Consolas", 16));
		if (decaf)
			shotsLabel.setText(shotsLabel.getText() + " (Decaf)");
		Label calloutLabel = new Label("\n\nBarista will callout: \n");
		//calloutLabel.setWrapText(true);
		calloutLabel.setFont(Font.font("Consolas", 18));
		Label hashLabel = new Label(hash.substring(hash.length()-5).toUpperCase());
		hashLabel.setFont(Font.font("Consolas", 30));
		
		Label enjoy = new Label("\nEnjoy!");
		enjoy.setFont(Font.font("Consolas", 25));
		
		layout.getChildren().addAll(customerLabel, sizeLabel, tempLabel, drinkLabel, shotsLabel, calloutLabel, hashLabel, enjoy);
		
		Scene scene = new Scene(layout, 300, 415);
		customerReceipt.setScene(scene);
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		customerReceipt.setX(primScreenBounds.getWidth() * 0.5);
		customerReceipt.setY(primScreenBounds.getHeight() * 0.2);
		customerReceipt.show();
	}
	
}
