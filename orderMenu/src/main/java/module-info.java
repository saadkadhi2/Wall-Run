module sample.ordermenu {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.ordermenu to javafx.fxml;
    exports sample.ordermenu;
}