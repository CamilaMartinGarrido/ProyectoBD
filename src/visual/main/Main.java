package visual.main;

import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.MODENA) // Opcional si no necesitas el tema predeterminado de JavaFX, aún se recomienda
                .themes(MaterialFXStylesheets.forAssemble(true)) // Añade el tema predeterminado de MaterialFX. El argumento booleano es para incluir controles heredados
                .setDeploy(true) // Si se deben desplegar los activos de cada tema en un directorio temporal en el disco
                .setResolveAssets(true) // Si se debe intentar resolver las declaraciones @import y las URL de recursos
                .build() // Ensambla todos los temas añadidos en un solo CSSFragment (una clase muy poderosa, consulta su documentación)
                .setGlobal(); // Finalmente, establece la hoja de estilos producida como la hoja de estilos global del User-Agent

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/login.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
