package View;

import ElementsUtil.DisplayElements;
import ElementsUtil.GameElements;
import ElementsUtil.Utils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TitleView {

    public Scene titleScene;

    public Group root;

    public ImageView titleImage;

    public Button playButton;
    public Button settingsButton;
    public Button creditButton;

    public TitleView(Stage primaryStage) throws FileNotFoundException {
        this.root = new Group();
        this.titleScene = new Scene(root, Utils.WIDTH, Utils.HEIGHT, Color.BLACK);

        DisplayElements.EightiesAnim(PhysBrick.DEBUG, primaryStage, this.root, Color.MAGENTA);

        this.titleImage = MakeTitle();

        this.playButton = MakePlayButton(this.root);
        this.settingsButton = SettingsView.MakeSettingsButton(this.root);
        this.creditButton = CreditsView.MakeCreditButton(this.root);

        GameElements.MakeAddLightningButtonMouseEvent(this.titleScene, this.root);
    }

    //creates title image
    public ImageView MakeTitle() throws FileNotFoundException {
        FileInputStream title_input = new FileInputStream("src/resources/image/title.jpg");
        Image image = new Image(title_input);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX((Utils.WIDTH / 2) - 380);
        imageView.setLayoutY(Utils.HEIGHT - 1200);
        imageView.setOpacity(0.8);
        this.root.getChildren().add(imageView);
        return imageView;
    }

    // creates plat button
    public static Button MakePlayButton(Group root) throws FileNotFoundException {
        final Button btn = new Button();
        FileInputStream play_input = new FileInputStream("src/resources/image/play.jpg");
        Image play_img = new Image(play_input);
        ImageView btngraphic = new ImageView(play_img);
        double btnScale = 0.5;

        btn.setLayoutX((Utils.WIDTH / 4.75));
        btn.setLayoutY((Utils.HEIGHT - 550));
        btn.setGraphic(btngraphic);
        btn.setScaleX(btnScale);
        btn.setScaleY(btnScale);
        btn.setOpacity(0.8);
        btn.setPadding(Insets.EMPTY);

        root.getChildren().add(btn);
        return btn;
    }
}