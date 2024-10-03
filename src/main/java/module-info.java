module org.example.tictactoejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.tictactoejavafx to javafx.fxml;
    exports org.example.tictactoejavafx;
}