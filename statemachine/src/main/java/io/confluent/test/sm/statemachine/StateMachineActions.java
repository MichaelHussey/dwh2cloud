package io.confluent.test.sm.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * This class implements whatever actions need to occur when we get to each state
 * 
 * @author mic.hussey
 *
 */
@WithStateMachine
public class StateMachineActions {

  @OnTransition(target = "STATE1")
  void toState1() {
  }

  @OnTransition(target = "STATE2")
  void toState2() {
  }
}
