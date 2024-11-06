package manjaro.mpb;

import javax.swing.*;

public enum MBCharacter {

    PIKACHU(Icons.PIKACHU),
    JIGGLYPUFF(Icons.JIGGLYPUFF);

    private final ImageIcon icon;

    MBCharacter(ImageIcon icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return icon.getDescription();
    }
    public ImageIcon getIcon() {
        return icon;
    }

}