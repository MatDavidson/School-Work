package prob1;

// Illustrates: RadioButtons, ToggleGroup, Nesting Panes
//
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ShapeGenerator extends Application {

	protected TextField txfValue1, txfValue2, txfValue3;
	protected TextArea txaMessage;
	protected ArrayList<GeometricObject> shapes = new ArrayList<>();
	protected ComboBox<String> cmbShape;
	protected Label lbl1, lbl2, lbl3;
	protected Button btnCreateShape, btnShowAll;
	protected ToggleGroup tGrpShapeChoice = new ToggleGroup();
	private Button btnReadShape;
	private Button btnClearAll;
	private Button btnWriteShape;
	private final String PATH = "src\\prob1";

	@Override
	public void start(Stage primaryStage) {
		Pane grdRootPane = buildGuiPane(primaryStage);
		Scene scene = new Scene(grdRootPane, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("HW 6 - Problem 1");
		primaryStage.show();
	}

	private Pane buildGuiPane(Stage stage) {

		Pane topRow = buildTopRow();
		Pane buttonRow = buildButtonRow(stage);
		Pane messageRow = buildMessageRow();

        // Main gui is a VBox, put the three rows in.
        VBox pane = new VBox();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setSpacing(10);
        pane.getChildren().addAll(topRow, buttonRow, messageRow );

        return pane;
	}

	private Pane buildTopRow() {

		// Put shape choice radio buttons in a VBox
		VBox vBoxShape = new VBox();
		vBoxShape.setSpacing(10);

		Label lblSelectShape = new Label("Select Shape");
		lblSelectShape.setFont(Font.font(null, FontWeight.BOLD, 16));
		vBoxShape.getChildren().add(lblSelectShape);

        ShapeChoiceEventHandler cmbShapeEventHandler = new ShapeChoiceEventHandler();

		RadioButton rbTriangle = new RadioButton("Triangle");
		rbTriangle.setToggleGroup(tGrpShapeChoice);
		rbTriangle.setSelected(true);
		rbTriangle.setOnAction(cmbShapeEventHandler);
		vBoxShape.getChildren().add(rbTriangle);

		RadioButton rbRectangle = new RadioButton("Rectangle");
		rbRectangle.setToggleGroup(tGrpShapeChoice);
		rbRectangle.setOnAction(cmbShapeEventHandler);
		vBoxShape.getChildren().add(rbRectangle);

		RadioButton rbCircle = new RadioButton("Circle");
		rbCircle.setToggleGroup(tGrpShapeChoice);
		rbCircle.setOnAction(cmbShapeEventHandler);
		vBoxShape.getChildren().add(rbCircle);

		// Put shape length entry fields in a GridPane
		GridPane gridShapeLengths = new GridPane();
		gridShapeLengths.setVgap(5);

		Label lblEnterValues = new Label("Enter Values");
		lblEnterValues.setFont(Font.font(null, FontWeight.BOLD, 16));
		gridShapeLengths.add(lblEnterValues, 0, 0);

		lbl1 = new Label("Side 1:");
		gridShapeLengths.add(lbl1, 0, 1);
		txfValue1 = new TextField();
		gridShapeLengths.add(txfValue1, 1, 1);
		lbl2 = new Label("Side 2:");
		gridShapeLengths.add(lbl2, 0, 2);
		txfValue2 = new TextField();
		gridShapeLengths.add(txfValue2, 1, 2);
		lbl3 = new Label("Side 3:");
		gridShapeLengths.add(lbl3, 0, 3);
		txfValue3 = new TextField();
		gridShapeLengths.add(txfValue3, 1, 3);

		// Build top row of gui as HBox
		// Put radio buttons VBox and entry field GridPane in an HBox
		HBox topRow = new HBox();
		topRow.setAlignment(Pos.TOP_LEFT);
		topRow.setSpacing(20);

		topRow.getChildren().addAll(vBoxShape, gridShapeLengths);

        return topRow;
	}

	private Pane buildButtonRow(Stage stage) {

		// First button row
		HBox hBoxButtons = new HBox();
		hBoxButtons.setSpacing(5.0);
		hBoxButtons.setAlignment(Pos.CENTER);

		btnCreateShape = new Button("Create Triangle");
		hBoxButtons.getChildren().add(btnCreateShape);
        CreateShapeEventHandler btnEventHandler = new CreateShapeEventHandler();
        btnCreateShape.setOnAction(btnEventHandler );

        btnShowAll = new Button("Show All");
		hBoxButtons.getChildren().add(btnShowAll);
        ShowAllEventHandler btnShowAllEventHandler = new ShowAllEventHandler();
        btnShowAll.setOnAction(btnShowAllEventHandler );

		btnClearAll = new Button("Clear All");
		hBoxButtons.getChildren().add(btnClearAll);
		btnClearAll.setOnAction( e -> { shapes.clear(); txaMessage.setText(""); } );

        // Second button row
        HBox hBoxButtons2 = new HBox();
		hBoxButtons2.setSpacing(5.0);

		hBoxButtons2.setAlignment(Pos.CENTER);
		btnReadShape = new Button("Read Shapes");
		btnReadShape.setOnAction( new ReadShapesEventHandler(stage));
		hBoxButtons2.getChildren().add(btnReadShape);

		btnWriteShape = new Button("Write Shapes");
		btnWriteShape.setOnAction( new WriteShapesEventHandler(stage));
		hBoxButtons2.getChildren().add(btnWriteShape);

		VBox buttonRow = new VBox();
		buttonRow.setSpacing(10);
		buttonRow.getChildren().addAll(hBoxButtons, hBoxButtons2);

        return buttonRow;
	}

	private Pane buildMessageRow() {

		// Put message area in HBox. This is third row of gui.
		HBox hBoxMessage = new HBox();
		hBoxMessage.setAlignment(Pos.CENTER);
        txaMessage = new TextArea();
        txaMessage.setEditable(false);
        txaMessage.setPrefColumnCount(30);
        txaMessage.setPrefRowCount(15);
        hBoxMessage.getChildren().add(txaMessage);

        return hBoxMessage;
	}

    private class CreateShapeEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			RadioButton rad = (RadioButton)tGrpShapeChoice.getSelectedToggle();

         	String strShape = rad.getText();

         	GeometricObject shape = null;

         	switch( strShape ) {
         	case "Triangle":
         		System.out.println("Creating a Triangle");
               	// Get triangle side lengths
            	double side1 = Double.parseDouble( txfValue1.getText() );
            	double side2 = Double.parseDouble( txfValue2.getText() );
            	double side3 = Double.parseDouble( txfValue3.getText() );
            	// Create triangle object
            	shape = new Triangle(side1, side2, side3);
         		break;
         	case "Rectangle":

         		System.out.println("Creating a Rectangle");
               	// Get rectangle width and height
            	double width = Double.parseDouble( txfValue1.getText() );
            	double height = Double.parseDouble( txfValue2.getText() );
            	// Create triangle object
            	shape = new Rectangle(width, height);
            	break;

         	case "Circle":
         		System.out.println("Creating a Circle");
               	// Get rectangle width and height
            	double radius = Double.parseDouble( txfValue1.getText() );
            	// Create triangle object
            	shape = new Circle(radius);
         		break;
         	}

        	// Add to collection
         	shapes.add(shape);

        	// Build message to display
        	StringBuilder message = new StringBuilder();
        	message.append("Shape:\n");
        	message.append( shape.toString() + "\n" );

        	String temp = String.format("   Area      = %4.1f\n", shape.getArea());
        	message.append(temp);
        	temp = String.format("   Perimeter = %4.1f\n", shape.getPerimeter());
        	message.append(temp);

        	// Put message in display area
            txaMessage.setText(message.toString());

            // Erase fields
            txfValue1.setText(null);
            txfValue2.setText(null);
            txfValue3.setText(null);

		}

    }

    private class ShowAllEventHandler implements EventHandler<ActionEvent> {

 		@Override
 		public void handle(ActionEvent event) {

         	StringBuilder message = new StringBuilder();
         	message.append("All Shapes:\n");

         	int i=1;
         	for( GeometricObject shape : shapes ) {
 				message.append((i++) + ". " + shape + "\n");
 			}

             txaMessage.setText(message.toString());

             // Erase fields
             txfValue1.setText(null);
             txfValue2.setText(null);
             txfValue3.setText(null);
 		}
     }

    private class ShapeChoiceEventHandler implements EventHandler<ActionEvent> {

 		@Override
 		public void handle(ActionEvent event) {
 			RadioButton rb = (RadioButton)event.getSource();

         	String shape = rb.getText();

         	switch( shape ) {
         	case "Triangle":
         		System.out.println("Triangle");
         		showTriangleEntry();
         		break;
         	case "Rectangle":

         		System.out.println("Rectangle");
         		showRectangleEntry();
         		break;

         	case "Circle":
         		System.out.println("Circle");
         		showCircleEntry();
         		break;
         	}
 		}
     }

    private class ReadShapesEventHandler implements EventHandler<ActionEvent> {
    	Stage stage;
    	public ReadShapesEventHandler(Stage stage) {
    		super();
    		this.stage = stage;
    	}
 		@Override
 		public void handle(ActionEvent event) {
 			File file = getInFile(stage);
 			if( file != null) {
 	            try {
 					readShapesFile(file);
 					txaMessage.setText("-->readShapesFile() called successfully\n\n");
 				}
 	            catch (FileNotFoundException e) {
 					txaMessage.setText("Error reading file");
 					e.printStackTrace();
 				}

 			}
 		}
     }

    private class WriteShapesEventHandler implements EventHandler<ActionEvent> {
    	Stage stage;
    	public WriteShapesEventHandler(Stage stage) {
    		super();
    		this.stage = stage;
    	}
 		@Override
 		public void handle(ActionEvent event) {
 			File file = getOutFile(stage);

 			if( file != null) {
	            try {
					writeShapesFile(file);
 					txaMessage.setText("-->writeShapesFile() called successfully\n\n");
				}
	            catch (FileNotFoundException e) {
 					txaMessage.setText("Error writing file");
					e.printStackTrace();
				}
 			}
 		}
     }

    private File getInFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File initPath = new File(PATH);
        fileChooser.setInitialDirectory(initPath);
        File file = fileChooser.showOpenDialog(stage);
        System.out.println(file);
		return file;

    }

    private File getOutFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File initPath = new File(PATH);
        fileChooser.setInitialDirectory(initPath);
        File file = fileChooser.showSaveDialog(stage);
        System.out.println(file);
		return file;

    }

    private void readShapesFile(File file) throws FileNotFoundException {
    	// This method should read shapes from "file" in the format
    	// shown in the problem statement, build the corresponding
    	// shape objects and add them to the shapes ArrayList
    	Scanner input = new Scanner(file);
    	
    	try {	
    		while(input.hasNext()) {
    			String s = input.next();
    			switch(s) {
    			case "t":  
    				double side1 = input.nextDouble();
    				double side2 = input.nextDouble();
    				double side3 = input.nextDouble();
    				Triangle t = new Triangle(side1, side2, side3);
    				shapes.add(t);
    				input.nextLine();
    				continue;
    				
    			case "r":
    				double width = input.nextDouble();
    				double height = input.nextDouble();
    				Rectangle r = new Rectangle(width, height);
    				shapes.add(r);
    				input.nextLine();
    				continue;
    				
    			case "c":
    				double radius = input.nextDouble();
    				Circle c = new Circle(radius);
    				shapes.add(c);
    				input.nextLine();
    				continue;
    			default:
    				input.nextLine();
    				continue;
    			}
    		}	
    		input.close();
    	}	
    	catch(Exception e) {
    		System.out.print("File not found.");
    	}
    }

    private void writeShapesFile(File file) throws FileNotFoundException {
    	// This method should write the shapes in the shapes ArrayList
    	// to the "file" that was input.
    	try {
    		PrintWriter writer = new PrintWriter(file);
    		for(GeometricObject s: shapes) {

    			if(s instanceof Triangle) {
    				writer.println("t " + ((Triangle)s).getSide1() + " " + ((Triangle)s).getSide2() + " " + ((Triangle)s).getSide3());
    			}
    			else if(s instanceof Rectangle) {
    				writer.println("r " + ((Rectangle)s).getWidth() + " " + ((Rectangle)s).getHeight());
    			}
    			else if(s instanceof Circle){
    				writer.println("c " + ((Circle)s).getRadius());
    			}
    			writer.close();
    		}	
    	}
    	catch(Exception e) {
    		System.out.print("File not found.");
    	}
    }

    private void showTriangleEntry() {
  		lbl1.setVisible(true);
  		lbl1.setText("Side 1:");
  		txfValue1.setVisible(true);

  		lbl2.setVisible(true);
  		lbl2.setText("Side 2:");
  		txfValue2.setVisible(true);

  		lbl3.setVisible(true);
  		lbl2.setText("Side 3:");
  		txfValue3.setVisible(true);

  		btnCreateShape.setText("Create Triangle");
     }

    private void showRectangleEntry() {
 		lbl1.setVisible(true);
 		lbl1.setText("Width:");
 		txfValue1.setVisible(true);

 		lbl2.setVisible(true);
 		lbl2.setText("Height:");
 		txfValue2.setVisible(true);

 		lbl3.setVisible(false);
 		txfValue3.setVisible(false);

 		btnCreateShape.setText("Create Rectangle");
    }

    private void showCircleEntry() {
 		lbl1.setVisible(true);
 		lbl1.setText("Radius:");
 		txfValue1.setVisible(true);

 		lbl2.setVisible(false);
 		txfValue2.setVisible(false);

 		lbl3.setVisible(false);
 		txfValue3.setVisible(false);

  		btnCreateShape.setText("Create Circle");
    }

	public static void main(String[] args) {
		launch(args);
	}
}
