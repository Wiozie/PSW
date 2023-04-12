public class Main {
    public static void main(String[] args) {
        RGB blue = new RGB(0, 0, 0);
        System.out.println("B value: " + blue.getB_value());
        blue.setB_value(255);
        System.out.println("B value after setting: " + blue.getB_value());
        RGB green = new RGB(0,0,0);
        RGBController controller = new RGBController();
        controller.initColor(green,0,255, 0);
        controller.displayColor(green);
        System.out.println("Mixed colour: " + controller.mixColors(green,blue));
    }
}
