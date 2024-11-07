package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.viewController.EmpresaViewController;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    public static Empresa empresa = new Empresa("Renta Autos");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Reservas");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestorClienteVehiculo.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            EmpresaViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    //servicios

    public void inicializarData(){
        Cliente cliente1 = new Cliente("valen", "123", "valen@");
        Cliente cliente2 = new Cliente("kate", "11122", "kat@");
        Cliente cliente3 = new Cliente("laura", "12223", "lau@uq");

        Moto moto1 = new Moto(123, "Honda", "2024", 2024, TipoCaja.AUTOMATICA);
        Moto moto2 = new Moto(665, "yamaha", "t7", 2022, TipoCaja.MANUAL);
        Auto auto1 = new Auto(2345, "Mazda", "2", 2020 , 5);
        Camioneta camioneta1 = new Camioneta(33456, "Foton", "qwerty", 2022, 4);
        empresa.crearCliente(cliente1);
        empresa.crearCliente(cliente2);
        empresa.crearVehiculo(moto1);
        empresa.crearVehiculo(moto2);
        empresa.crearVehiculo(auto1);
        empresa.crearVehiculo(camioneta1);
        empresa.crearCliente(cliente3);
        
    }
}
