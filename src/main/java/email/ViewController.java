package email;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;


public class ViewController implements Initializable{

	
		//model
		Email email;
	    @FXML
	    private TextField asuntoText;

	    @FXML
	    private Button cerrarButton;

	    @FXML
	    private CheckBox checkSSL;

	    @FXML
	    private TextField contrasenaText;

	    @FXML
	    private TextField emailDestinatarioText;

	    @FXML
	    private TextField emailRemitenteText;

	    @FXML
	    private Button enviarButton;

	    @FXML
	    private TextArea mensajeText;

	    @FXML
	    private TextField nombreText;

	    @FXML
	    private TextField puertoText;

	    @FXML
	    private Button vaciarButton;
	    
	    @FXML
	    private GridPane view;
	    
	    public ViewController() throws Exception  {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/View.fxml"));
			loader.setController(this);
			loader.load();
	    }
	    
	    public GridPane getView() {
	    	return view;
	    }

	    @FXML
	    void OnCerrarAction(ActionEvent event) {

	    	Platform.exit();
	    }

	    @FXML
	    void OnEnviarAction(ActionEvent event) {

	    	
			try {
				email=new SimpleEmail();

				email.setHostName(nombreText.getText());
				email.setSmtpPort(Integer.parseInt(puertoText.getText()));
				email.setAuthentication(emailRemitenteText.getText(), contrasenaText.getText());
				email.setSSLOnConnect(checkSSL.isSelected());
				email.setFrom(emailRemitenteText.getText());
				email.setSubject(asuntoText.getText());
				email.setMsg(mensajeText.getText());
				email.addTo(emailDestinatarioText.getText());

				Hilotask hilo=new Hilotask(email);

				hilo.setOnSucceeded(e->{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Email enviado");
					alert.setHeaderText("Email enviado");
					alert.setContentText("Email enviado");
					alert.showAndWait();});
				hilo.setOnFailed(e->{Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Error");
					alert.setContentText("hubo un error");
					alert.showAndWait();});

				new Thread(hilo).start();

			} catch (Exception e) {

				e.printStackTrace();
			}
	    }

	    @FXML
	    void OnVaciarButton(ActionEvent event) {

	    	emailRemitenteText.clear();
	    	checkSSL.setSelected(false);
	    	
	    }

		public void initialize(URL location, ResourceBundle resources) {
			nombreText.setText("smtp.gmail.com");
			puertoText.setText("465");
			emailRemitenteText.setText("dad.iesdpm@gmail.com");
			contrasenaText.setText("chucknorri$21");
			checkSSL.setSelected(true);
			emailDestinatarioText.setText("grupoacompana007@gmail.com");
			asuntoText.setText("Hola");
			mensajeText.setText("Hola");
			email= new SimpleEmail();

			
		}

	}
	

