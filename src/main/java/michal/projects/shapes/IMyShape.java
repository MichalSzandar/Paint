package michal.projects.shapes;
import java.util.ArrayList;

import michal.projects.Point;

public interface IMyShape {
   /**
     * @brief Sets the first parameter of the shape.
     * @param point The point to set as the first parameter.
     */
    public void moveShape(Point point);

    /**
     * @brief Sets the second parameter of the shape.
     * @param point The point to set as the second parameter.
     */
    public void setSecondParameter(Point point);

    /**
     * @brief Sets parameters of the shape using a list of points.
     * @param points The list of points to set as parameters.
     */
    public void setParameters(ArrayList<Point> points);

    /**
     * @brief Retrieves the parameters of the shape.
     * @return An ArrayList of points representing the parameters.
     */
    public ArrayList<Point> getVertices();

    /**
     * @brief Makes the shape editable.
     */
    public void setActive();

    /**
     * @brief makes the shape uneditable
     */
    public void setDisabled();

    /**
     * @brief Retrieves the type of the shape.
     * @return A string representing type of the shape.
     */
    public String getType();

    public boolean isActive();
}
