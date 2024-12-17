package michal.projects;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public final class DefaultState 
{
    /**
     * if user clicked on shape it sets the shape to active and all other shapes on scene to disabled
     */
    @SuppressWarnings("exports")
    public static void onMouseClicked(MouseEvent e)
    {
        Node object = e.getPickResult().getIntersectedNode();
        Node canva;

        if(object instanceof PaintPane)
            canva = object;
        else if(object.getParent() instanceof PaintPane)
            canva = object.getParent();
        else
            throw new IndexOutOfBoundsException("object is not PaintPane");
        
        for (Node node : ((PaintPane)canva).getChildrenUnmodifiable()) 
            if(node instanceof IMyShape)
                ((IMyShape)node).setDisabled();
        
        if(object instanceof IMyShape )
            ((IMyShape)object).setActive();    
    }
}
