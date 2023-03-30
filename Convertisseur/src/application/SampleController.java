package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SampleController implements Initializable{
	
	 @FXML
	    private TextField txtL2;

	    @FXML
	    private TextField txtM1;

	    @FXML
	    private TextField txtL1;

	    @FXML
	    private TextField txtM2;

	    @FXML
	    private ComboBox<String> cmbT2;
	   
	    public ObservableList<String> listT2=FXCollections.observableArrayList("minute", "heure", "jours");
	   
	    @FXML
	    private ComboBox<String> cmbT1;

	    public ObservableList<String> listT1=FXCollections.observableArrayList("minute", "heure", "jours");
	    
	    @FXML
	    private TextField txtT2;

	    @FXML
	    private TextField txtT1;

	    @FXML
	    private ComboBox<String> cmbL2;
	    
	    public ObservableList<String> listL2=FXCollections.observableArrayList("metre", "centimetre", "kilometre");

	    @FXML
	    private Button btn2;

	    @FXML
	    private Button btn3;

	    @FXML
	    private ComboBox<String> cmbM1;

	    public ObservableList<String> listM1=FXCollections.observableArrayList("livres", "gramme", "kilogramme");

	    @FXML
	    private Button btn1;

	    @FXML
	    private ComboBox<String> cmbL1;

	    private ObservableList<String> listL1=FXCollections.observableArrayList("metre", "centimetre", "kilometre");
	    
	    private double longeur[]= {1.0,100.0,0.001};
	    
	    @FXML
	    private ComboBox<String> cmbM2;

	    public ObservableList<String> listM2=FXCollections.observableArrayList("livres", "gramme", "kilogramme");

	
	   @FXML void Quitter()
	   {
	   Alert alert=new Alert(AlertType.CONFIRMATION);
	     alert.setHeaderText("Confirmation");
	     alert.setTitle("Sortie");
	     alert.setContentText("Voudrais tu vraiment quitter");
	     Optional<ButtonType> result=alert.showAndWait();
	     if (result.get()==ButtonType.OK)
	     System.exit(0);
	     }
	 
	   void checkNum(TextField a) {
	   	try 
	   	{
	   	int b = Integer.parseInt(a.getText());
	   }
	   	catch(NumberFormatException e)
	   	{
	   		Alert alert=new Alert(AlertType.ERROR);
	   		alert.setHeaderText("Erreur");
	   		alert.setTitle("Attention");
	   		alert.setContentText("Entrée numérique seulement");
	   		alert.show();
	   		a.requestFocus();
	   	}
	   }
	   
	   @FXML
	   void CheckText(KeyEvent e)
	   {
	   	TextField txt=(TextField)e.getSource();
	   	//System.out.println(txt.getText());
	   	checkNum(txt);
	   }

	   @Override
	   public void initialize(URL location, ResourceBundle resources)
	   {
	   	cmbL1.setItems(listL1);	
	   	cmbL1.getSelectionModel().selectFirst();
	   	
	   	cmbL2.setItems(listL2);	
	   	cmbL2.getSelectionModel().selectFirst();
	   	
	   	cmbM1.setItems(listM1);	
	   	cmbM1.getSelectionModel().selectFirst();
	   	
	   	cmbM2.setItems(listM2);	
	   	cmbM2.getSelectionModel().selectFirst();
	   	
	   	cmbT1.setItems(listT1);	
	   	cmbT1.getSelectionModel().selectFirst();
	   	
	   	cmbT2.setItems(listT2);	
	   	cmbT2.getSelectionModel().selectFirst();
	   }
		
	   private double setTaux(ComboBox<String> a, double tbl[])
		{
		   int item=a.getSelectionModel().getSelectedIndex();
		   double val= tbl[item]; 
		   return val;
		}
	   private void convert(ComboBox<String> a, ComboBox<String> b, TextField c, TextField d, double tbl[])
	   {
		   
			   double from=setTaux(a, tbl);
			   double depart=0;
			   if(c.getText().length()==0)
				   depart=0;
			   else
				depart=Double.parseDouble(c.getText());
			   	double to=setTaux(b,tbl);
			   	double dest=(to/from)*depart;
			   d. setText(String. valueOf(dest));
			   
	   }
			
	   @FXML
	   void Convertir1() 
	   {
		   convert(cmbL1, cmbL2, txtL1, txtL2, longeur);
	   }
	
	   @FXML
	   void Convertir2() 
	   {
		   convert(cmbL2, cmbL1, txtL2, txtL1, longeur);
	   }
	   
	
}
	   

