package Menu.MainMenu;

import Main.Main;

import java.awt.*;

public class LoadData implements MenuItem {
    public void execute(){
        Main.writeToFile();
    }
}
