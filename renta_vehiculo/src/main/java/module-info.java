module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo to javafx.fxml;
    exports co.edu.uniquindio.poo.viewController;
    exports co.edu.uniquindio.poo;
    opens co.edu.uniquindio.poo.viewController to javafx.fxml;
}
