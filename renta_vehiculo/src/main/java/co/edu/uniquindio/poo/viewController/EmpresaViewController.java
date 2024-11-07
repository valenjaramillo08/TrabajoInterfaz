package co.edu.uniquindio.poo.viewController;

// Importación de las clases necesarias para el funcionamiento de la aplicación
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.EmpresaController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmpresaViewController {
    // Controlador que maneja la lógica de la vista de la empresa
    EmpresaController empresaController;

    // Listas observables para almacenar vehículos, clientes y reservas
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    ObservableList<Reserva> listReservas = FXCollections.observableArrayList();

    // Variables para almacenar el cliente, vehículo y reserva seleccionados
    Cliente selectedCliente;
    Vehiculo selectedVehiculo;
    Reserva selectedReserva;

    // Referencia a la aplicación principal
    private App app;

    // Recursos y ubicación para la inicialización de la vista
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // Elementos de la interfaz gráfica (FXML)
    @FXML
    private TableView<Reserva> id_tabla; // Tabla que muestra las reservas

    @FXML
    private DatePicker fecha_inicio; // Selector de fecha de inicio

    @FXML
    private DatePicker fecha_final; // Selector de fecha final

    @FXML
    private ChoiceBox<Vehiculo> combo_vehiculo; // Selector de vehículos

    @FXML
    private TableColumn<Reserva, String> id_columna_cliente; // Columna para el ID del cliente

    @FXML
    private TableColumn<Reserva, String> columna_final; // Columna para la fecha final

    @FXML
    private TableColumn<Reserva, String> colummna_inicio; // Columna para la fecha de inicio

    @FXML
    private TableColumn<Reserva, String> id_columna_vehiculo; // Columna para el ID del vehículo

    @FXML
    private Button boton_reserva; // Botón para crear una reserva

    @FXML
    private TableColumn<Reserva, String> columna_costo; // Columna para el costo de la reserva

    @FXML
    private ChoiceBox<Cliente> combo_cliente; // Selector de clientes

    // Método que se ejecuta al hacer clic en el botón de crear reserva
    @FXML
    void onCrearReserva() {
        crearReserva(); // Llama al método para crear una reserva, este es el boton
    }

    // Método inicial que se ejecuta al cargar la vista
    @FXML
    void initialize() {
        // Se inicializa el controlador de la empresa y la vista
        empresaController = new EmpresaController(app.empresa);
        initView(); // Llama al método para inicializar la vista
    }

    // Método para inicializar la vista
    private void initView() {
        // Traer los datos del cliente, vehículo y reserva a la tabla
        initDataBinding(); // Inicializa el enlace de datos
        // Obtiene las listas de reservas, clientes y vehículos
        obtenerReservas();
        obtenerClientes();
        obtenerVehiculos();

        // Limpiar la tabla de reservas
        id_tabla.getItems().clear();

        // Agregar los elementos a la tabla y a los selectores
        id_tabla.setItems(listReservas);
        combo_cliente.setItems(listClientes);
        combo_vehiculo.setItems(listVehiculos);

        // Añadir un listener para manejar la selección de elementos en la tabla
        listenerSelection();
    }

    // Método para enlazar los datos de las columnas de la tabla
    private void initDataBinding() {
        // Asocia las columnas de la tabla con las propiedades de las reservas
        id_columna_cliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getCedula()));
        id_columna_vehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getMarca()));
        colummna_inicio.setCellValueFactory(cellData -> new SimpleStringProperty(fechaString(cellData.getValue().getFechaInicio())));
        columna_final.setCellValueFactory(cellData -> new SimpleStringProperty(fechaString(cellData.getValue().getFechaFinal())));
        columna_costo.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getValorReserva())));
    }

    // Método para obtener las reservas de la empresa
    private void obtenerReservas() {
        // Agrega todas las reservas a la lista observable
        listReservas.addAll(empresaController.getReservas());
    }

    // Método para obtener los clientes de la empresa
    private void obtenerClientes() {
        // Agrega todos los clientes a la lista observable
        listClientes.addAll(empresaController.getClientes());
    }

    // Método para obtener los vehículos de la empresa
    private void obtenerVehiculos() {
        // Agrega todos los vehículos a la lista observable
        listVehiculos.addAll(empresaController.getVehiculos());
    }

    // Método para convertir una fecha a una cadena en formato "dd/MM/yyyy"
    private String fechaString(LocalDate fecha) {
        String formatoPersonalizado = "dd/MM/yyyy"; // Formato de la fecha
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formatoPersonalizado); // Formateador de fecha
        String fechaFormateada = fecha.format(formatoFecha); // Formatea la fecha
        return fechaFormateada; // Devuelve la fecha formateada
    }

    // Método para manejar la selección de una reserva en la tabla
    private void listenerSelection() {
        // Agrega un listener para detectar cambios en la selección
        id_tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReserva = newSelection; // Actualiza la reserva seleccionada
            mostrarInformacionReserva(selectedReserva); // Muestra información de la reserva seleccionada
        });
    }

    // Método para mostrar la información de la reserva en la interfaz
    private void mostrarInformacionReserva(Reserva reserva) {
        if (reserva != null) { // Verifica si hay una reserva seleccionada
            id_columna_cliente.setText(reserva.getCliente().getCedula());
            id_columna_vehiculo.setText(reserva.getVehiculo().getMarca());
            colummna_inicio.setText(fechaString(reserva.getFechaInicio()));
            columna_final.setText(fechaString(reserva.getFechaFinal()));
            columna_costo.setText(Double.toString(reserva.getValorReserva()));
        }
    }

    // Método para construir una nueva reserva a partir de los datos ingresados
    private Reserva buildReserva() {
        // Crea una nueva reserva utilizando los datos de la interfaz
        Reserva reserva = new Reserva(combo_cliente.getValue(), combo_vehiculo.getValue(), fecha_inicio.getValue(), fecha_final.getValue());
        return reserva; // Devuelve la nueva reserva
    }

    // Método para crear una nueva reserva
    private void crearReserva() {
        Reserva reserva = buildReserva(); // Construye la reserva
        if (empresaController.crearReserva(reserva)) { // Crea la reserva en el controlador
            listReservas.add(reserva); // Agrega la nueva reserva a la lista
            limpiarCamposReserva(); // Limpia los campos de entrada
        }
    }

    // Método para limpiar los campos de entrada de la reserva
    private void limpiarCamposReserva() {
        fecha_inicio.getEditor().clear(); // Limpia el campo de fecha de inicio
        fecha_final.getEditor().clear(); // Limpia el campo de fecha final
        combo_cliente.setValue(null); // Desmarca el cliente seleccionado
        combo_vehiculo.setValue(null); // Desmarca el vehículo seleccionado
    }

    // Método para establecer la aplicación principal
    public void setApp(App app) {
        this.app = app; // Asigna la referencia de la aplicación
    }
}