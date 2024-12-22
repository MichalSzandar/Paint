package michal.projects.states;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import michal.projects.gui.PaintPane;
import michal.projects.shapes.IMyShape;

public class DefaultState extends PaneState
{
    public DefaultState(PaintPane pane){
        super(pane);
    }
    /**
     * if user clicked on shape it sets the shape to active and all other shapes on scene to disabled
     */
    @Override
    protected void onMouseClicked(MouseEvent e)
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

    @Override
    protected void onMousePressed(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseDragged(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseMoved(MouseEvent e) {
        return;
    }

    @Override
    protected void onMouseExited(MouseEvent e) {
        return;
    }
}
