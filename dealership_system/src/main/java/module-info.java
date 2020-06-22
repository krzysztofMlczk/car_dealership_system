module Databazy{
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires transitive java.sql;

    exports pl.databazy;
    exports pl.databazy.data;
    opens pl.databazy to javafx.fxml; 
}