package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

public class SampleController implements Initializable{
	
	@FXML
		private AnchorPane TabPane; //initialize tout les different partie dans ma scene builder
	
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
	   
	    public ObservableList<String> listT2=FXCollections.observableArrayList("minute", "heure", "jours"); //donne les noms au combo box
	  
	    private double Temp[]= {1.0,0.0166667,0.00069444583333}; //donne les nombre de converteur pour utiliser pour convertir ces different unité

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
	    private Button btnoff1;
	    
	    @FXML
	    private Button btnoff2;
	    
	    @FXML
	    private Button btnoff3;
	    
	    @FXML
	    private Button btn3;

	    @FXML
	    private ComboBox<String> cmbM1;

	    public ObservableList<String> listM1=FXCollections.observableArrayList("livres", "gramme", "kilogramme");

	    private double Masse[]= {1.0,453.592,0.453592};
	    
	    @FXML
	    private Button btn1;

	    @FXML
	    private ComboBox<String> cmbL1;

	    private ObservableList<String> listL1=FXCollections.observableArrayList("metre", "centimetre", "kilometre");
	    
	    private double Longeur[]= {1.0,100.0,0.001};
	    
	    @FXML
	    private ComboBox<String> cmbM2;

	    public ObservableList<String> listM2=FXCollections.observableArrayList("livres", "gramme", "kilogramme");

/*
 * sa interdit que l'utilisateur puisse ecrire des lettre
 */
	   @FXML
	   void CheckText(KeyEvent e)
	   {
	   	
	   	TextField txt=(TextField)e.getSource() ; //dit au code de seulement faire cette code quand on ecrit dans les text field 
	   	txt.textProperty( ).addListener ( (observable, oldValue, newValue) ->
	   	{
	   	if(!newValue.matches("^-?[0-9](11.[0-9]+)?5")) //si c'est un lettre sa le remplace avec un nombre 
	   	{
	   	txt. setText (newValue. replaceAll("[^\\d*\\.\\-]",""));
	   	{
	    
{
	   	}
	   	}
	   
	   	}
	   	});
	   }
/*
 * dit au combobox de mettre comme option de le premiere unité
 */
	   @Override
	   public void initialize(URL location, ResourceBundle resources)
	   {
	   	cmbL1.setItems(listL1);	
	   	cmbL1.getSelectionModel().selectFirst(); //dit que le premiere unité et le premiere option dans le combobox
	   	
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
		   int item=a.getSelectionModel().getSelectedIndex(); //item devient le type de unité selectionné
		   double val= tbl[item]; //cree la proportion avec les nombre de converteur
		   return val;
		}
	   /*
	    * code pour convertir chaque unité
	    */
	   private void convert(ComboBox<String> a, ComboBox<String> b, TextField c, TextField d, double tbl[])
	   {
		   
			   double from=setTaux(a, tbl);
			   double depart=0;
			   if(c.getText().length()==0) //utilise set Taux pour utiliser le math pour convertir les unité
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
		   convert(cmbL1, cmbL2, txtL1, txtL2, Longeur); //cree un code pour les text field et combobox pour qu'il puisse parcourire cette code de convertir
	   }
	
	   @FXML
	   void Convertir2() 
	   {
		   convert(cmbL2, cmbL1, txtL2, txtL1, Longeur);
	   }
	   
	   @FXML
	   void Convertir3() 
	   {
		   convert(cmbM1, cmbM2, txtM1, txtM2, Masse);
	   }
	
	   @FXML
	   void Convertir4() 
	   {
		   convert(cmbM2, cmbM1, txtM2, txtM1, Masse);
	   }
	   @FXML
	   void Convertir5() 
	   {
		   convert(cmbT1, cmbT2, txtT1, txtT2, Temp);
	   }
	
	   @FXML
	   void Convertir6() 
	   {
		   convert(cmbT2, cmbT1, txtT2, txtT1, Temp);
	   }
	   /*
	    * code pour cree un boution de fermature pour que l'utlisateur puisse quiter l'application quand-t-il veut
	    */
	   @FXML void Quitter() //cree un alert quand tu appuie sur le bouton "ferme"
	   {
	   Alert alert=new Alert(AlertType.CONFIRMATION); //cree l'alerte
	     alert.setHeaderText("Confirmation");
	     alert.setTitle("Sortie");
	     alert.setContentText("Voudrais tu vraiment quitter"); //cree le window pour que tu puisse dire ok pour quitter
	     Optional<ButtonType> result=alert.showAndWait();
	     if (result.get()==ButtonType.OK)
	     System.exit(0);
	     }
	        
	
{
	  
	   
	}
	}

	   

