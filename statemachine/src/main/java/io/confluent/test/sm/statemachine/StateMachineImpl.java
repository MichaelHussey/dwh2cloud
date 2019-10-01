package io.confluent.test.sm.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

/**
 * This class defines the valid states and events used in our state machine
 * @author mic.hussey
 *
 */
public class StateMachineImpl {

  static enum States {
    STARTED, INPROGRESS, ENDED
}

static enum Events {
    EVENT1, EVENT2
}

protected static final class StateMachineListener extends StateMachineListenerAdapter<States, Events> { 
  Logger logger = LoggerFactory.getLogger(StateMachineListener.class);
 @Override 
  public void stateChanged(State<States, Events> from, State<States, Events> to) {
    logger.debug("State changed to " + to.getId()); 
  }
}
/**
public static StateMachine<States, Events> buildMachine() throws Exception {
  Builder<States, Events> builder = StateMachineBuilder.builder();

  builder.configureStates()
      .withStates()
          .initial(States.STARTED)
          .states(EnumSet.allOf(States.class));

  builder.configureTransitions()
      .withExternal()
          .source(States.STARTED).target(States.INPROGRESS)
          .event(Events.EVENT1)
          .and()
      .withExternal()
          .source(States.INPROGRESS).target(States.ENDED)
          .event(Events.EVENT2);

  return builder.build();
}*/
}
