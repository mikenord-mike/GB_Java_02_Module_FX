module ru.gb.mikenord.gb_java_02_module_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.mikenord.gb_java_02_module_fx to javafx.fxml;
    exports ru.gb.mikenord.gb_java_02_module_fx;
}