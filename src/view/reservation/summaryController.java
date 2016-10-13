package view.reservation;

import javafx.fxml.FXMLLoader;

public class summaryController {

	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("summaryReservation.fxml"));     

	//Parent root = (Parent)fxmlLoader.load();          
	reservationController controller = fxmlLoader.<reservationController>getController();
	
	
}
