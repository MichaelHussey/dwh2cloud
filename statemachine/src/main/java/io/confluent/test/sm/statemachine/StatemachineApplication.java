package io.confluent.test.sm.statemachine;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import io.confluent.test.sm.statemachine.StateMachineImpl.Events;
import io.confluent.test.sm.statemachine.StateMachineImpl.States;

@SpringBootApplication
public class StatemachineApplication {

    Map<String, StateMachine<States, Events>> stateMachines = new Hashtable<>();
    
    @Autowired
    StateMachineFactory<States, Events> smfactory;

    public static void main(String[] args) {
		SpringApplication.run(StatemachineApplication.class, args);
	}

    public StateMachine<States, Events> getStateMachine(String key) throws Exception
    {
      StateMachine<States, Events> theMachine = stateMachines.get(key);
      if (theMachine == null)
      {
        theMachine = smfactory.getStateMachine();
        stateMachines.put(key, theMachine);
      }
      return theMachine;
    }
}
