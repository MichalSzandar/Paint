package michal.projects;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public final class Utils {
    
    @SuppressWarnings("exports")
    public static Color invertColor(Paint color)
    {
        if(color instanceof Color)
            return new Color(((Color)color).getRed()/2.0, ((Color)color).getGreen()/2.0, 1.0, 1.0 );
        else
            throw new IndexOutOfBoundsException();
    }

    public static double distance(Point a, Point b)
    {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    @SuppressWarnings("exports")
    public static Color colorFromHashCode(int argbColor)
    {
        int alpha = (argbColor >> 24) & 0xFF;
        int red = (argbColor >> 16) & 0xFF;
        int green = (argbColor >> 8) & 0xFF;
        int blue = argbColor & 0xFF;
        
        // Creating JavaFX Color object
        return Color.rgb(red, green, blue, alpha / 255.0);
    }

    @SuppressWarnings("exports")
    public static String colorToHex(Color color) {
        int r = (int) Math.round(color.getRed() * 255);
        int g = (int) Math.round(color.getGreen() * 255);
        int b = (int) Math.round(color.getBlue() * 255);
        int a = (int) Math.round(color.getOpacity() * 255);
        return String.format("#%02X%02X%02X%02X", r, g, b, a);
    }

    // Converts a hexadecimal color string back to a JavaFX Color.
    @SuppressWarnings("exports")
    public static Color hexToColor(String hex) {
        return Color.web(hex);
    }
}
