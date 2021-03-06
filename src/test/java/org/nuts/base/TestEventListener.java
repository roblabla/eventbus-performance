package org.nuts.base;

import com.adamtaft.eb.EventHandler;
import com.google.common.eventbus.Subscribe;
import net.engio.mbassy.dispatch.HandlerInvocation;
import net.engio.mbassy.listener.Listener;
import net.engio.mbassy.listener.References;
import net.engio.mbassy.subscription.SubscriptionContext;
import org.bushe.swing.event.annotation.EventSubscriber;
import net.engio.mbassy.listener.Handler;

/**
* Created with IntelliJ IDEA.
* User: benni
* Date: 11/3/12
* Time: 5:25 PM
* To change this template use File | Settings | File Templates.
*/
@Listener(references = References.Strong)
public class TestEventListener {

    // every event of type TestEvent or any subtype will be delivered
    // to this listener
    @Handler()
    @Subscribe
    @EventHandler
    @EventSubscriber
    public void handleTestEvent(TestEvent event) {
        event.countHandled();
    }


    public static class HandleTestEvent extends HandlerInvocation<TestEventListener, TestEvent> {


        public HandleTestEvent(SubscriptionContext context) {
            super(context);
        }

        @Override
        public void invoke(TestEventListener listener, TestEvent message) {
            listener.handleTestEvent(message);
        }
    }

}
