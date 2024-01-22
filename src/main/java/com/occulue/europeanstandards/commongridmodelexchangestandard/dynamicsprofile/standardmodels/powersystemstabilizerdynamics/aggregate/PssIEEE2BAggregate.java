package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for PssIEEE2B as outlined for the CQRS pattern, all write responsibilities
 * related to PssIEEE2B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssIEEE2BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssIEEE2BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssIEEE2BAggregate(CreatePssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssIEEE2BCommand");
    CreatePssIEEE2BEvent event =
        new CreatePssIEEE2BEvent(
            command.getPssIEEE2BId(), command.getInputSignal1Type(), command.getInputSignal2Type());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssIEEE2BCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssIEEE2BCommand");
    UpdatePssIEEE2BEvent event =
        new UpdatePssIEEE2BEvent(
            command.getPssIEEE2BId(),
            command.getInputSignal1Type(),
            command.getInputSignal2Type(),
            command.getKs1(),
            command.getKs2(),
            command.getKs3(),
            command.getM(),
            command.getN(),
            command.getT1(),
            command.getT10(),
            command.getT11(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT6(),
            command.getT7(),
            command.getT8(),
            command.getT9(),
            command.getTw1(),
            command.getTw2(),
            command.getTw3(),
            command.getTw4(),
            command.getVsi1max(),
            command.getVsi1min(),
            command.getVsi2max(),
            command.getVsi2min(),
            command.getVstmax(),
            command.getVstmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssIEEE2BCommand");
    apply(new DeletePssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKs1ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToPssIEEE2BCommand");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromPssIEEE2BCommand");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignKs2ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs2ToPssIEEE2BCommand");

    if (ks2 != null && ks2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs2ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs2FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs2FromPssIEEE2BCommand");

    if (ks2 == null) throw new ProcessingException("Ks2 already has nothing assigned.");

    apply(new UnAssignKs2FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignKs3ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs3ToPssIEEE2BCommand");

    if (ks3 != null && ks3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs3ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs3FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs3FromPssIEEE2BCommand");

    if (ks3 == null) throw new ProcessingException("Ks3 already has nothing assigned.");

    apply(new UnAssignKs3FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignMToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignMToPssIEEE2BCommand");

    if (m != null && m.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "M already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignMToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMFromPssIEEE2BCommand");

    if (m == null) throw new ProcessingException("M already has nothing assigned.");

    apply(new UnAssignMFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignNToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignNToPssIEEE2BCommand");

    if (n != null && n.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "N already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignNToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNFromPssIEEE2BCommand");

    if (n == null) throw new ProcessingException("N already has nothing assigned.");

    apply(new UnAssignNFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssIEEE2BCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssIEEE2BCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT10ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT10ToPssIEEE2BCommand");

    if (t10 != null && t10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT10ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT10FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT10FromPssIEEE2BCommand");

    if (t10 == null) throw new ProcessingException("T10 already has nothing assigned.");

    apply(new UnAssignT10FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT11ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT11ToPssIEEE2BCommand");

    if (t11 != null && t11.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T11 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT11ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT11FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT11FromPssIEEE2BCommand");

    if (t11 == null) throw new ProcessingException("T11 already has nothing assigned.");

    apply(new UnAssignT11FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssIEEE2BCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssIEEE2BCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssIEEE2BCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssIEEE2BCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssIEEE2BCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssIEEE2BCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPssIEEE2BCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPssIEEE2BCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT7ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT7ToPssIEEE2BCommand");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromPssIEEE2BCommand");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT8ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT8ToPssIEEE2BCommand");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromPssIEEE2BCommand");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignT9ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT9ToPssIEEE2BCommand");

    if (t9 != null && t9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT9ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT9FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT9FromPssIEEE2BCommand");

    if (t9 == null) throw new ProcessingException("T9 already has nothing assigned.");

    apply(new UnAssignT9FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignTw1ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw1ToPssIEEE2BCommand");

    if (tw1 != null && tw1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw1ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw1FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw1FromPssIEEE2BCommand");

    if (tw1 == null) throw new ProcessingException("Tw1 already has nothing assigned.");

    apply(new UnAssignTw1FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignTw2ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw2ToPssIEEE2BCommand");

    if (tw2 != null && tw2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw2ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw2FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw2FromPssIEEE2BCommand");

    if (tw2 == null) throw new ProcessingException("Tw2 already has nothing assigned.");

    apply(new UnAssignTw2FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignTw3ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw3ToPssIEEE2BCommand");

    if (tw3 != null && tw3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw3ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw3FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw3FromPssIEEE2BCommand");

    if (tw3 == null) throw new ProcessingException("Tw3 already has nothing assigned.");

    apply(new UnAssignTw3FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignTw4ToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw4ToPssIEEE2BCommand");

    if (tw4 != null && tw4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw4ToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw4FromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw4FromPssIEEE2BCommand");

    if (tw4 == null) throw new ProcessingException("Tw4 already has nothing assigned.");

    apply(new UnAssignTw4FromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi1maxToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi1maxToPssIEEE2BCommand");

    if (vsi1max != null && vsi1max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi1max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi1maxToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi1maxFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi1maxFromPssIEEE2BCommand");

    if (vsi1max == null) throw new ProcessingException("Vsi1max already has nothing assigned.");

    apply(new UnAssignVsi1maxFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi1minToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi1minToPssIEEE2BCommand");

    if (vsi1min != null && vsi1min.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi1min already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi1minToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi1minFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi1minFromPssIEEE2BCommand");

    if (vsi1min == null) throw new ProcessingException("Vsi1min already has nothing assigned.");

    apply(new UnAssignVsi1minFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi2maxToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi2maxToPssIEEE2BCommand");

    if (vsi2max != null && vsi2max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi2max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi2maxToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi2maxFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi2maxFromPssIEEE2BCommand");

    if (vsi2max == null) throw new ProcessingException("Vsi2max already has nothing assigned.");

    apply(new UnAssignVsi2maxFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi2minToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi2minToPssIEEE2BCommand");

    if (vsi2min != null && vsi2min.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi2min already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi2minToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi2minFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi2minFromPssIEEE2BCommand");

    if (vsi2min == null) throw new ProcessingException("Vsi2min already has nothing assigned.");

    apply(new UnAssignVsi2minFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVstmaxToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstmaxToPssIEEE2BCommand");

    if (vstmax != null && vstmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstmaxToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstmaxFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstmaxFromPssIEEE2BCommand");

    if (vstmax == null) throw new ProcessingException("Vstmax already has nothing assigned.");

    apply(new UnAssignVstmaxFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  @CommandHandler
  public void handle(AssignVstminToPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstminToPssIEEE2BCommand");

    if (vstmin != null && vstmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstminToPssIEEE2BEvent(command.getPssIEEE2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstminFromPssIEEE2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstminFromPssIEEE2BCommand");

    if (vstmin == null) throw new ProcessingException("Vstmin already has nothing assigned.");

    apply(new UnAssignVstminFromPssIEEE2BEvent(command.getPssIEEE2BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssIEEE2BEvent event) {
    LOGGER.info("Event sourcing CreatePssIEEE2BEvent");
    this.pssIEEE2BId = event.getPssIEEE2BId();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
  }

  @EventSourcingHandler
  void on(UpdatePssIEEE2BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
    this.ks1 = event.getKs1();
    this.ks2 = event.getKs2();
    this.ks3 = event.getKs3();
    this.m = event.getM();
    this.n = event.getN();
    this.t1 = event.getT1();
    this.t10 = event.getT10();
    this.t11 = event.getT11();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.t8 = event.getT8();
    this.t9 = event.getT9();
    this.tw1 = event.getTw1();
    this.tw2 = event.getTw2();
    this.tw3 = event.getTw3();
    this.tw4 = event.getTw4();
    this.vsi1max = event.getVsi1max();
    this.vsi1min = event.getVsi1min();
    this.vsi2max = event.getVsi2max();
    this.vsi2min = event.getVsi2min();
    this.vstmax = event.getVstmax();
    this.vstmin = event.getVstmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignKs1ToPssIEEE2BEvent");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs1FromPssIEEE2BEvent");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs2ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignKs2ToPssIEEE2BEvent");
    this.ks2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs2FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs2FromPssIEEE2BEvent");
    this.ks2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs3ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignKs3ToPssIEEE2BEvent");
    this.ks3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs3FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs3FromPssIEEE2BEvent");
    this.ks3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignMToPssIEEE2BEvent");
    this.m = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignMFromPssIEEE2BEvent");
    this.m = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignNToPssIEEE2BEvent");
    this.n = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignNFromPssIEEE2BEvent");
    this.n = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssIEEE2BEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssIEEE2BEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT10ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT10ToPssIEEE2BEvent");
    this.t10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT10FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT10FromPssIEEE2BEvent");
    this.t10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT11ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT11ToPssIEEE2BEvent");
    this.t11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT11FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT11FromPssIEEE2BEvent");
    this.t11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssIEEE2BEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssIEEE2BEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPssIEEE2BEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssIEEE2BEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPssIEEE2BEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssIEEE2BEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPssIEEE2BEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPssIEEE2BEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT7ToPssIEEE2BEvent");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT7FromPssIEEE2BEvent");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT8ToPssIEEE2BEvent");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT8FromPssIEEE2BEvent");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT9ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignT9ToPssIEEE2BEvent");
    this.t9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT9FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT9FromPssIEEE2BEvent");
    this.t9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw1ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignTw1ToPssIEEE2BEvent");
    this.tw1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw1FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw1FromPssIEEE2BEvent");
    this.tw1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw2ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignTw2ToPssIEEE2BEvent");
    this.tw2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw2FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw2FromPssIEEE2BEvent");
    this.tw2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw3ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignTw3ToPssIEEE2BEvent");
    this.tw3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw3FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw3FromPssIEEE2BEvent");
    this.tw3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw4ToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignTw4ToPssIEEE2BEvent");
    this.tw4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw4FromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw4FromPssIEEE2BEvent");
    this.tw4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi1maxToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi1maxToPssIEEE2BEvent");
    this.vsi1max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi1maxFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi1maxFromPssIEEE2BEvent");
    this.vsi1max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi1minToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi1minToPssIEEE2BEvent");
    this.vsi1min = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi1minFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi1minFromPssIEEE2BEvent");
    this.vsi1min = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi2maxToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi2maxToPssIEEE2BEvent");
    this.vsi2max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi2maxFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi2maxFromPssIEEE2BEvent");
    this.vsi2max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi2minToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi2minToPssIEEE2BEvent");
    this.vsi2min = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi2minFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi2minFromPssIEEE2BEvent");
    this.vsi2min = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstmaxToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVstmaxToPssIEEE2BEvent");
    this.vstmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstmaxFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstmaxFromPssIEEE2BEvent");
    this.vstmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstminToPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing AssignVstminToPssIEEE2BEvent");
    this.vstmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstminFromPssIEEE2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstminFromPssIEEE2BEvent");
    this.vstmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssIEEE2BId;

  private InputSignalKind inputSignal1Type;
  private InputSignalKind inputSignal2Type;
  private PU ks1 = null;
  private PU ks2 = null;
  private PU ks3 = null;
  private IntegerProxy m = null;
  private IntegerProxy n = null;
  private Seconds t1 = null;
  private Seconds t10 = null;
  private Seconds t11 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Seconds t8 = null;
  private Seconds t9 = null;
  private Seconds tw1 = null;
  private Seconds tw2 = null;
  private Seconds tw3 = null;
  private Seconds tw4 = null;
  private PU vsi1max = null;
  private PU vsi1min = null;
  private PU vsi2max = null;
  private PU vsi2min = null;
  private PU vstmax = null;
  private PU vstmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssIEEE2BAggregate.class.getName());
}
