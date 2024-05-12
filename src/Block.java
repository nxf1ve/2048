import java.awt.*;

public class Block {
    public Block() {
        value = 0;
    }
    public Block(int number) {
        value = number;
    }
    private int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    private Color blockColor;
    public void setBlockColor() {
        int value = this.getValue();
        switch (value) {
            case 2:
                blockColor = new Color(238, 228, 218);
                break;
            case 4:
                blockColor = new Color(237, 224, 200);
                break;
            case 8:
                blockColor = new Color(242, 177, 121);
                break;
            case 16:
                blockColor = new Color(245, 149, 99);
                break;
            case 32:
                blockColor = new Color(246, 124, 95);
                break;
            case 64:
                blockColor = new Color(246, 94, 59);
                break;
            case 128:
                blockColor = new Color(237, 207, 114);
                break;
            case 256:
                blockColor = new Color(237, 204, 97);
                break;
            case 512:
                blockColor = new Color(237, 200, 80);
                break;
            case 1024:
                blockColor = new Color(237, 197, 63);
                break;
            default:
                blockColor = new Color(237, 194, 46);
                break;
        }
    }
    public Color getBlockColor() {
        this.setBlockColor();
        return blockColor;
    }

}
