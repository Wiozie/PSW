public class RGBController {

    public void initColor(RGB color, int R_value, int G_value, int B_value) {
        color.setR_value(R_value);
        color.setG_value(G_value);
        color.setB_value(B_value);
    }

    public void displayColor(RGB color) {
        System.out.println("[" + color.getR_value() + ", " + color.getG_value() + ", " + color.getB_value() + "]");
    }

    public String mixColors(RGB color1, RGB color2) {
        int mixedR = (color1.getR_value() + color2.getR_value()) / 2;
        int mixedG = (color1.getG_value() + color2.getG_value()) / 2;
        int mixedB = (color1.getB_value() + color2.getB_value()) / 2;
        RGB mixedColor = new RGB(mixedR, mixedG, mixedB);
        return "[" + mixedColor.getR_value() + ", " + mixedColor.getG_value() + ", " + mixedColor.getB_value() + "]";
    }
}
