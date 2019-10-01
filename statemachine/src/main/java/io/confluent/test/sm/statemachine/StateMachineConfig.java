package io.confluent.test.sm.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import io.confluent.test.sm.statemachine.StateMachineImpl.Events;
import io.confluent.test.sm.statemachine.StateMachineImpl.States;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

  Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);

  @Override
  public void configure(StateMachineStateConfigurer<States, Events> states)
      throws Exception {
    states
    .withStates()
    .initial(States.STARTED)
    .state(States.INPROGRESS)
    .end(States.ENDED);
  }

  @Override
  public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
      throws Exception {
    transitions
    .withExternal()
    .source(States.STARTED).target(States.INPROGRESS)
    .event(Events.EVENT1)
    .and()
    .withExternal()
    .source(States.INPROGRESS).target(States.ENDED)
    .event(Events.EVENT2);
  }
  
  @Override 
  public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception { 
    config
     .withConfiguration()
     .autoStartup(true)
     .listener(new StateMachineImpl.StateMachineListener()); 
  } 

}
