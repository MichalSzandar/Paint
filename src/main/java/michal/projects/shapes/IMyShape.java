package michal.projects.shapes;

import java.util.ArrayList;

import michal.projects.Point;

public interface IMyShape {
   /**
     * @brief Sets the first parameter of the shape.
     * @param point The point to set as the first parameter.
     */
    void moveShape(Point point);

   /**
    * @brief Sets the second parameter of the shape.
    * @param point The point to set as the second parameter.
    */
   void setSecondParameter(Point point);

   /**
    * @brief Sets parameters of the shape using a list of points.
    * @param points The list of points to set as parameters.
    */
   void setParameters(ArrayList<Point> points);

   /**
    * @brief Retrieves the parameters of the shape.
    * @return An ArrayList of points representing the parameters.
    */
   ArrayList<Point> getVertices();

   /**
    * @brief Makes the shape editable.
    */
   void setActive();

   /**
    * @brief makes the shape uneditable
    */
   void setDisabled();

   /**
    * @brief Retrieves the type of the shape.
    * @return A string representing type of the shape.
    */
   String getType();

   /**
    * checks if shape is active.
    * @return true if active, false otherwise
    */
   boolean isActive();
}
