package org.arcball.internal;

import org.arcball.NavigationBehavior;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Abstract base class for all dragging interactions.
 * 
 * @author Jonathan Merritt (<a href="mailto:j.s.merritt@gmail.com">j.s.merritt@gmail.com</a>)
 */
public abstract class InteractionDrag extends InteractionBase {

    //---------------------------------------------------------------------------------------------------------- PUBLIC
    
    public InteractionDrag() {
        super();
        // it only makes sense for DRAG navigation behavior to be assigned; so assert() that
        navigationBehaviorProperty().addListener(new ChangeListener<NavigationBehavior>() {
            @Override public void changed(ObservableValue<? extends NavigationBehavior> ob, 
                    NavigationBehavior oldnb, NavigationBehavior newnb)
            {
                assert(newnb.getInput() == NavigationBehavior.Input.DRAG);
            }
        });        
    }
    
    @Override public void attachToHost(InteractionHost host) {
        super.attachToHost(host);
        dragHelper.attachToHost(host);
    }
    
    @Override public void detachFromHost(InteractionHost host) {
        super.detachFromHost(host);
        dragHelper.detachFromHost(host);
    }
    
    //------------------------------------------------------------------------------------------------------- PROTECTED
    
    protected abstract DragHandler getDragHandler();
    
    //--------------------------------------------------------------------------------------------------------- PRIVATE

    private final DragHelper dragHelper = new DragHelper(navigationBehaviorProperty(), getDragHandler());
    
}
