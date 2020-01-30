package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import martian_stuff.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	TabPane tab = new TabPane();
	Pane manager = new Pane();
	MartianManager mManager = new MartianManager();
	
	Tab tab1 = new Tab();		
	ToggleGroup colorChoiceTogGrp = new ToggleGroup();
	RadioButton rbGreen = new RadioButton("Green");
	RadioButton rbRed = new RadioButton("Red");
	CheckBox[] martianFeatures = new CheckBox[2];
	Button btnAdd = new Button("Add");
	TextField txfAddID = new TextField();
	TextArea txaConsole = new TextArea();
	Slider martianVolume = new Slider();
	Button btnReadFile = new Button("Read File");
	Button btnWriteFile = new Button("Write File");
	
	TextField txfRemID = new TextField();
	ComboBox<String> cmbMartians = new ComboBox<>();
	Button btnRemove = new Button("Remove");
	Button btnRemoveAll = new Button("Remove All");
	
	Tab tab2 = new Tab();
	TextField txfDestination = new TextField();
	Button btnTeleport = new Button("Teleport");
	Button btnDisplayMartians = new Button("Display Martians");
	TextArea txaConsole1 = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane manager = buildGui();
			Scene scene = new Scene(manager, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Martian Manager");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Pane buildGui() {
		Pane manager = buildTabs();
		
		return manager;
	}
	
	private Pane buildTabs() {
		BorderPane brdPane = new BorderPane();
		tab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
		tab1.setText("Add/Remove");
		tab1.setContent(buildTab1Content());
		
		tab2.setText("Martians");
		tab2.setContent(buildTab2Content());
		
		tab.getTabs().addAll(tab1, tab2);
		
		brdPane.setCenter(tab);
		return brdPane;
	}
	
	private Pane buildTab1Content() {
		VBox addRemove = new VBox();
		addRemove.setSpacing(5);
		
		GridPane add = buildAddPane();
		addRemove.getChildren().add(add);
		
		
		GridPane remove = buildRemovePane();
		addRemove.getChildren().add(remove);
		
		addRemove.getChildren().add(txaConsole);
		txaConsole.setText("Enter a 3 digit I.D.");
		return addRemove;
	}
	
	private GridPane buildAddPane() {
		GridPane add = new GridPane();
		add.setHgap(10);
		add.setVgap(10);
		
		Label lblAdd = new Label("Add");
		lblAdd.setFont(Font.font(null, FontWeight.BOLD, 16));
		add.add(lblAdd, 0, 0);
		
		HBox addControls = buildAddControls();
		add.add(addControls, 0, 1);
		
		return add;
	}
	
	private HBox buildAddControls() {	
		HBox addControls = new HBox();
		
		VBox features = new VBox();		
		HBox colorChoice = buildColorChoice();
		features.getChildren().add(colorChoice);
		HBox otherInfo = buildOtherInfo();
		features.getChildren().add(otherInfo);
		addControls.getChildren().add(features);
		btnAdd.setOnAction( new AddMartianEventHandler());
		features.getChildren().add(btnAdd);
		
		VBox idVol = new VBox();
		HBox id = buildId();
		idVol.getChildren().add(id);
		HBox volume = buildVolume();
		idVol.getChildren().add(volume);
		addControls.getChildren().add(idVol);

		return addControls;
	}		
		
	public HBox buildColorChoice() {
		HBox colorChoice = new HBox();
		
		rbGreen.setToggleGroup(colorChoiceTogGrp);
		rbGreen.setSelected(true);
		colorChoice.getChildren().add(rbGreen);

		rbRed.setToggleGroup(colorChoiceTogGrp);
		colorChoice.getChildren().add(rbRed);
		return colorChoice;
	}
	
	public HBox buildOtherInfo() {				
		HBox otherInfo = new HBox();

		martianFeatures[0] = new CheckBox("ESP");
		martianFeatures[1] = new CheckBox("Vegetarian");
		otherInfo.getChildren().add(martianFeatures[0]);
		otherInfo.getChildren().add(martianFeatures[1]);
		
		return otherInfo;
	}
		
	public HBox buildId() {
		HBox id = new HBox();
		
		Label lblID = new Label("I.D.   ");
		id.getChildren().add(lblID);
		id.getChildren().add(txfAddID);						
		return id;
	}
				
	public HBox buildVolume() {
		HBox volume = new HBox();
		
		Label lblVol = new Label("Volume");
		martianVolume.setMin(0);
		martianVolume.setMax(10);
		martianVolume.setValue(5);
		martianVolume.setMajorTickUnit(2);
		martianVolume.setMinorTickCount(1);
		martianVolume.setShowTickLabels(true);
		martianVolume.setShowTickMarks(true);
		volume.getChildren().add(lblVol);	
		volume.getChildren().add(martianVolume);
		return volume;
	}
	
	public class AddMartianEventHandler implements EventHandler<ActionEvent>{
		int id, vol;
		boolean hasESP, isVeg;
		@Override
		public void handle(ActionEvent arg0) {
			try {
				if (idChecker(txfAddID.getText())) {
					id = Integer.parseInt(txfAddID.getText());
					if(mManager.getMartianWithId(id) != null) {
						txaConsole.setText("That Martian already exists!");
						return;
					}
					txfAddID.setText("");
					vol = (int)martianVolume.getValue();
					martianVolume.setValue(5);
					hasESP = martianFeatures[0].isSelected();
					martianFeatures[0].setSelected(false);
					isVeg = martianFeatures[1].isSelected();
					martianFeatures[1].setSelected(false);
					
					RadioButton col = (RadioButton)colorChoiceTogGrp.getSelectedToggle();
					String color = col.getText();
					
					switch(color) {
					
					case "Green":
						GreenMartian gm = new GreenMartian(id, vol, hasESP, isVeg);
						mManager.addMartian(gm);
						txaConsole.setText("Green Martian " + id + " has been created.\n" + gm.toString());
						cmbMartians.getItems().add(id + "-Green");
						break;
						
					case "Red": 
						RedMartian rm = new RedMartian(id, vol, hasESP, isVeg);
						mManager.addMartian(rm);
						txaConsole.setText("Red Martian " + id + " Has been created.\n" + rm.toString());
						cmbMartians.getItems().add(id + "-Red");
						break;
					}
				}
				else
					return;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}				
	}
	
	private boolean idChecker(String id) throws Exception {	
		int i = 0;
		
		try {
			if(id.length() == 3) {
				i = Integer.parseInt(id);
				return true;
			}	
			else {
				txaConsole.setText("Please enter a 3 digit number");
				return false;
			}	
		}
		catch(Exception e) {
			txaConsole.setText("Please enter a 3 digit number");
			return false;
		}
	}
	
	private GridPane buildRemovePane() {
		GridPane remove = new GridPane();
		remove.setHgap(10);
		remove.setVgap(10);
		
		Label lblAdd = new Label("Remove");
		lblAdd.setFont(Font.font(null, FontWeight.BOLD, 16));
		remove.add(lblAdd, 0, 0);
		
		HBox removeControls = buildRemoveControls();
		remove.add(removeControls, 0, 1);
		
		return remove;
	}
	
	private HBox buildRemoveControls() {
		HBox removeControls = new HBox();

		VBox idCombo = new VBox();
		HBox remID = buildRemID();
		idCombo.getChildren().add(remID);

		cmbMartians.setOnAction(new ComboMartiansEventHandler());
		cmbMartians.setValue("Pick a Martian");
		idCombo.getChildren().add(cmbMartians);
		removeControls.getChildren().add(idCombo);

		VBox removeButtons = buildRemoveButtons();
		removeControls.getChildren().add(removeButtons);	
		
		return removeControls;
	}
	
	public HBox buildRemID() {
		HBox remID = new HBox();
		
		Label lblID = new Label("I.D.");
		remID.getChildren().add(lblID);
		remID.getChildren().add(txfRemID);
		return remID;
	}
	
	public VBox buildRemoveButtons() {
		VBox remButtons = new VBox();
		btnRemove.setOnAction(new RemoveEventHandler());
		remButtons.getChildren().add(btnRemove);
		btnRemoveAll.setOnAction(new RemoveAllEventHandler());
		remButtons.getChildren().add(btnRemoveAll);
		return remButtons;
	}
	
	public class ComboMartiansEventHandler implements EventHandler<ActionEvent>{
		String s, subS;
		int id;
		
		@Override
		public void handle(ActionEvent arg0) {
			if(cmbMartians.getValue().contentEquals("Pick a Martian")) {
				return;
			}
			else {
				s = cmbMartians.getValue();
				subS = s.substring(0,3);
				id = Integer.parseInt(s.substring(0,3));

				txfRemID.setText(subS);
				txaConsole.setText(mManager.getMartianWithId(id).toString() + "\n" + mManager.getMartianWithId(id).speak());	
				return;
			}
		}
		
	}
	
	public class RemoveEventHandler implements EventHandler<ActionEvent>{
		int id, index;
		String combo = "";
		
		@Override
		public void handle(ActionEvent arg0) {
			try {
				if (idChecker(txfRemID.getText())) {
					id = Integer.parseInt(txfRemID.getText());
					if(mManager.getMartianWithId(id) == null) {
						txaConsole.setText("That Martian does not exist!");
						return;
					}
					if(mManager.getMartianWithId(id) instanceof GreenMartian) {
						combo = id + "-Green";
					}
					else if(mManager.getMartianWithId(id) instanceof RedMartian) {
						combo = id + "-Red";
					}
					txfRemID.setText("");
					txaConsole.setText(mManager.getMartianWithId(id).toString() + "\nMartian Removed");
					mManager.removeMartian(id);			
					index = cmbMartians.getItems().indexOf(combo);
					cmbMartians.getItems().remove(index);
					cmbMartians.setValue("Pick a Martian");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}	
		}		
	}
	
	public class RemoveAllEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			cmbMartians.getItems().clear();
			cmbMartians.setValue("Pick a Martian");
			mManager.obliterateMartians();
			txaConsole.setText("All Martians Removed");
		}
		
	}
	
	private GridPane buildTab2Content() {
		GridPane martians = new GridPane();

		martians.setHgap(10);
		martians.setVgap(10);
		
		Label lblMartians = new Label("Martians");
		lblMartians.setFont(Font.font(null, FontWeight.BOLD, 16));
		martians.add(lblMartians, 0, 0);
		
		HBox teleport = buildTeleport();
		martians.add(teleport, 0, 1);
		
		HBox display = new HBox();
		btnDisplayMartians.setOnAction(new DisplayMartiansEventHandler());
		display.getChildren().add(btnDisplayMartians);
		martians.add(display, 0, 2);
		
		txaConsole1.setText("Enter a Destination");
		martians.add(txaConsole1,  0,3);
		
		return martians;
	}
	
	public HBox buildTeleport() {
		HBox teleport = new HBox();
		teleport.getChildren().add(txfDestination);
		btnTeleport.setOnAction(new TeleportEventHandler());
		teleport.getChildren().add(btnTeleport);
		return teleport;
	}
	
	public class TeleportEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			if(txfDestination.getText().isEmpty()) {
				txaConsole1.setText("Make sure you enter a destination!");
				return;
			}
			else {
				txaConsole1.setText(mManager.groupTeleport(txfDestination.getText()));
			}			
		}		
	}
	
	public class DisplayMartiansEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			StringBuilder result = new StringBuilder();
			for(Martian m: mManager.sortedMartians()) {
				result.append(m.toString() + "\n");
			}
			
			txaConsole1.setText(result.toString());
		}
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
