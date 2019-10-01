package io.confluent.test.sm.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;

import io.confluent.test.sm.statemachine.StateMachineImpl.Events;
import io.confluent.test.sm.statemachine.StateMachineImpl.States;

@EnableBinding(ListenerDefinition.class)
public class ListenerImpl {

  Logger logger = LoggerFactory.getLogger(ListenerImpl.class);
  @Autowired
    protected StatemachineApplication theApplication;

    /*
	@StreamListener(ListenerDefinition.INPUT)
	public void processRawMessage(String key, Message<?> message) throws Exception {
		System.out.println("Received message in processRawMessage(): "+message);
		String payload = null;
		if (message.getPayload() instanceof byte[])
		{
		  byte[] payloadBytes = (byte[]) message.getPayload();
		  payload = new String(payloadBytes);
		}
		System.out.println("Payload: "+payload);
		System.out.println("");
		
		// do something with the statemachine.
		
	}*/

	@StreamListener(ListenerDefinition.INPUT)
	public void processDeserialised(String key, String jsonPayload) throws Exception {
	  logger.debug("Received message in processDeserialised(): "+jsonPayload);
		
        StateMachine<States, Events> stateMachine = theApplication.getStateMachine(key);
        
        if (jsonPayload.contains("end"))
        {
          stateMachine.sendEvent(StateMachineImpl.Events.EVENT2);
        }
        else
        {
          stateMachine.sendEvent(StateMachineImpl.Events.EVENT1);
        }
        logger.debug("StateMachine "+key+": "+stateMachine.toString());
	}
}
