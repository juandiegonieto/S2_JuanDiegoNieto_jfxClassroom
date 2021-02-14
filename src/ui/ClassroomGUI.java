package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.FillRule;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Classroom;
import model.UserAccount;
import ui.Main;

public class ClassroomGUI {
	
	@FXML
    private BorderPane mainPane;
	@FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private VBox createAccountScene;
	@FXML
    private TextField txtSingInUserName;
    @FXML
    private PasswordField txtSingInPassword;
    @FXML
    private TextField txtPhotoUbic;
    @FXML
    private CheckBox cbxMale;
    @FXML
    private CheckBox cbxFemale;
    @FXML
    private CheckBox cbxOther;
    @FXML
    private CheckBox cboxSofware;
    @FXML
    private CheckBox cboxTelematic;
    @FXML
    private CheckBox cboxIndustrial;
    @FXML
    private DatePicker dpkBirthday;
    @FXML
    private ChoiceBox<String> chbxBrowser;
    @FXML
    private Label labMesg;
    @FXML
    private TableView<UserAccount> tvAccountsList;
    @FXML
    private TableColumn<UserAccount, String> tcUsername;
    @FXML
    private TableColumn<UserAccount, String> tcGender;
    @FXML
    private TableColumn<UserAccount, String> tcCareer;
    @FXML
    private TableColumn<UserAccount, String> tcBirthday;
    @FXML
    private TableColumn<UserAccount, String> tcBrowser;
    @FXML
    private Label txtUser;
    @FXML
    private ImageView ivProfilePhoto;
    @FXML
    private Button btnBrowse;

    
    private Classroom classroom;
    
    public ClassroomGUI(Classroom c) {
		classroom = c;
	}
    
	public void intialize() {
		
	}
	
	public void intializeTableView() {
		ObservableList<UserAccount> observableList;
		observableList = FXCollections.observableArrayList(classroom.getUserList());
		tvAccountsList.setItems(observableList);
		tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("name"));
		tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Gender"));
		tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Career"));
		tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Birthday"));
		tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("Browser"));
	}
	
	public void intializeChoiceBox() {
		ObservableList<String> favBrowser = FXCollections.observableArrayList("Google",
	    		"Firefox", "Opera", "Edge");
		chbxBrowser.setItems(favBrowser);
	}
	@FXML
    public void logInAccount(ActionEvent event) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountList.fxml"));
		fxmlLoader.setController(this);
		List<UserAccount> users;
		users = classroom.getUserList();
		for(int i = 0; i< users.size(); i++) {
			if(users.get(i).getName().equals(txtUsername) && users.get(i).getPassword().equals(txtPassword)) {
				Parent goToAccountList = fxmlLoader.load();
				mainPane.getChildren().clear();
				mainPane.setTop(goToAccountList);
				intializeTableView();
			}
		}
    }

    @FXML
    public void singUpScene(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SingIn.fxml"));
    	
    	fxmlLoader.setController(this);
    	Parent createAccountScene = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setTop(createAccountScene);
    }
    
    @FXML 
    public void handleMaleBox() {
    	if(cbxMale.isSelected()) {
    		cbxFemale.setSelected(false);
    		cbxOther.setSelected(false);
    	}
    }
    @FXML 
    public void handleFEmaleBox() {
    	if(cbxFemale.isSelected()) {
    		cbxMale.setSelected(false);
    		cbxOther.setSelected(false);
    	}
    }
    @FXML 
    public void handleOtherBox() {
    	if(cbxOther.isSelected()) {
    		cbxFemale.setSelected(false);
    		cbxMale.setSelected(false);
    	}
    }
    @FXML
    public boolean addAccount(ActionEvent event) {
    	
    	boolean added = false;
    	String cbxGender = null;
    	if (cbxMale.isSelected()) {
    		cbxGender.equals("Male");
    	} else if (cbxFemale.isSelected()) {
    		cbxGender.equals("Female");
    	} else if (cbxOther.isSelected()) {
    		cbxGender.equals("Other");
    	}
    	String cbxCareer = null;
    	if (cboxSofware.isSelected()) {
    		cbxCareer.equals("Software Engineer");
    	} else if (cboxTelematic.isSelected()) {
    		cbxCareer.equals("Telematic Engineer");
    	} else if (cboxIndustrial.isSelected()) {
    		cbxCareer.equals("Industrial Engineer");
    	}
    	String birthday = dpkBirthday.getValue().getDayOfMonth()+"/"+dpkBirthday.getValue().getMonthValue()
    			+"/"+dpkBirthday.getValue().getYear();
    	if(txtSingInUserName.getText()!=null && txtSingInPassword.getText()!= null &&cbxGender!=null && cbxCareer!=null && dpkBirthday!=null
    			&& chbxBrowser!=null) {
    		classroom.addUserAccount(txtSingInUserName.getText(),txtSingInPassword.getText(), cbxGender, cbxCareer, birthday, chbxBrowser.getValue());
    		added = true;
    		labMesg.setText("The contact was added succesfully!");
    	} else {
    		labMesg.setText("Something is wrong, check you information to continue!");
    	}
     	
     	
    	txtUsername.setText("");
    	cbxGender = null;
    	cbxCareer = null;
    	dpkBirthday = null;
    	chbxBrowser = null;
    	return added;
    }

    @FXML
    public void initializePhoto(URL url, ResourceBundle rb) {
        btnBrowse.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Browse Image");

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
			File imgFile = fileChooser.showOpenDialog(null);

            if (imgFile != null) {
                Image image = new Image("file:" + imgFile.getAbsolutePath());
                ivProfilePhoto.setImage(image);
            }
        });
    }

    @FXML
    public void singInScene(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Classroom.fxml"));
    	
    	fxmlLoader.setController(this);
    	Parent singInScene = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setTop(singInScene);
    }
    @FXML
    public void logOutFromAccountList(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Classroom.fxml"));
    	fxmlLoader.setController(this);
    	Parent singInSceneFromAccountList = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setTop(singInSceneFromAccountList);
    }
}
