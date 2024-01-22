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
 * Aggregate handler for PssIEEE3B as outlined for the CQRS pattern, all write responsibilities
 * related to PssIEEE3B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssIEEE3BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssIEEE3BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssIEEE3BAggregate(CreatePssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssIEEE3BCommand");
    CreatePssIEEE3BEvent event =
        new CreatePssIEEE3BEvent(
            command.getPssIEEE3BId(), command.getInputSignal1Type(), command.getInputSignal2Type());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssIEEE3BCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssIEEE3BCommand");
    UpdatePssIEEE3BEvent event =
        new UpdatePssIEEE3BEvent(
            command.getPssIEEE3BId(),
            command.getA1(),
            command.getA2(),
            command.getA3(),
            command.getA4(),
            command.getA5(),
            command.getA6(),
            command.getA7(),
            command.getA8(),
            command.getInputSignal1Type(),
            command.getInputSignal2Type(),
            command.getKs1(),
            command.getKs2(),
            command.getT1(),
            command.getT2(),
            command.getTw1(),
            command.getTw2(),
            command.getTw3(),
            command.getVstmax(),
            command.getVstmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssIEEE3BCommand");
    apply(new DeletePssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignA1ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA1ToPssIEEE3BCommand");

    if (a1 != null && a1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA1ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA1FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA1FromPssIEEE3BCommand");

    if (a1 == null) throw new ProcessingException("A1 already has nothing assigned.");

    apply(new UnAssignA1FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA2ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA2ToPssIEEE3BCommand");

    if (a2 != null && a2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA2ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA2FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA2FromPssIEEE3BCommand");

    if (a2 == null) throw new ProcessingException("A2 already has nothing assigned.");

    apply(new UnAssignA2FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA3ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA3ToPssIEEE3BCommand");

    if (a3 != null && a3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA3ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA3FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA3FromPssIEEE3BCommand");

    if (a3 == null) throw new ProcessingException("A3 already has nothing assigned.");

    apply(new UnAssignA3FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA4ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA4ToPssIEEE3BCommand");

    if (a4 != null && a4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA4ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA4FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA4FromPssIEEE3BCommand");

    if (a4 == null) throw new ProcessingException("A4 already has nothing assigned.");

    apply(new UnAssignA4FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA5ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA5ToPssIEEE3BCommand");

    if (a5 != null && a5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA5ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA5FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA5FromPssIEEE3BCommand");

    if (a5 == null) throw new ProcessingException("A5 already has nothing assigned.");

    apply(new UnAssignA5FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA6ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA6ToPssIEEE3BCommand");

    if (a6 != null && a6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA6ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA6FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA6FromPssIEEE3BCommand");

    if (a6 == null) throw new ProcessingException("A6 already has nothing assigned.");

    apply(new UnAssignA6FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA7ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA7ToPssIEEE3BCommand");

    if (a7 != null && a7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A7 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA7ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA7FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA7FromPssIEEE3BCommand");

    if (a7 == null) throw new ProcessingException("A7 already has nothing assigned.");

    apply(new UnAssignA7FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignA8ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignA8ToPssIEEE3BCommand");

    if (a8 != null && a8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A8 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA8ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA8FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA8FromPssIEEE3BCommand");

    if (a8 == null) throw new ProcessingException("A8 already has nothing assigned.");

    apply(new UnAssignA8FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignKs1ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToPssIEEE3BCommand");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromPssIEEE3BCommand");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignKs2ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs2ToPssIEEE3BCommand");

    if (ks2 != null && ks2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs2ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs2FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs2FromPssIEEE3BCommand");

    if (ks2 == null) throw new ProcessingException("Ks2 already has nothing assigned.");

    apply(new UnAssignKs2FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssIEEE3BCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssIEEE3BCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssIEEE3BCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssIEEE3BCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignTw1ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw1ToPssIEEE3BCommand");

    if (tw1 != null && tw1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw1ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw1FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw1FromPssIEEE3BCommand");

    if (tw1 == null) throw new ProcessingException("Tw1 already has nothing assigned.");

    apply(new UnAssignTw1FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignTw2ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw2ToPssIEEE3BCommand");

    if (tw2 != null && tw2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw2ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw2FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw2FromPssIEEE3BCommand");

    if (tw2 == null) throw new ProcessingException("Tw2 already has nothing assigned.");

    apply(new UnAssignTw2FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignTw3ToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw3ToPssIEEE3BCommand");

    if (tw3 != null && tw3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw3ToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw3FromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw3FromPssIEEE3BCommand");

    if (tw3 == null) throw new ProcessingException("Tw3 already has nothing assigned.");

    apply(new UnAssignTw3FromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignVstmaxToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstmaxToPssIEEE3BCommand");

    if (vstmax != null && vstmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstmaxToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstmaxFromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstmaxFromPssIEEE3BCommand");

    if (vstmax == null) throw new ProcessingException("Vstmax already has nothing assigned.");

    apply(new UnAssignVstmaxFromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  @CommandHandler
  public void handle(AssignVstminToPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstminToPssIEEE3BCommand");

    if (vstmin != null && vstmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstminToPssIEEE3BEvent(command.getPssIEEE3BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstminFromPssIEEE3BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstminFromPssIEEE3BCommand");

    if (vstmin == null) throw new ProcessingException("Vstmin already has nothing assigned.");

    apply(new UnAssignVstminFromPssIEEE3BEvent(command.getPssIEEE3BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssIEEE3BEvent event) {
    LOGGER.info("Event sourcing CreatePssIEEE3BEvent");
    this.pssIEEE3BId = event.getPssIEEE3BId();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
  }

  @EventSourcingHandler
  void on(UpdatePssIEEE3BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a1 = event.getA1();
    this.a2 = event.getA2();
    this.a3 = event.getA3();
    this.a4 = event.getA4();
    this.a5 = event.getA5();
    this.a6 = event.getA6();
    this.a7 = event.getA7();
    this.a8 = event.getA8();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
    this.ks1 = event.getKs1();
    this.ks2 = event.getKs2();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.tw1 = event.getTw1();
    this.tw2 = event.getTw2();
    this.tw3 = event.getTw3();
    this.vstmax = event.getVstmax();
    this.vstmin = event.getVstmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignA1ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA1ToPssIEEE3BEvent");
    this.a1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA1FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA1FromPssIEEE3BEvent");
    this.a1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA2ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA2ToPssIEEE3BEvent");
    this.a2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA2FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA2FromPssIEEE3BEvent");
    this.a2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA3ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA3ToPssIEEE3BEvent");
    this.a3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA3FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA3FromPssIEEE3BEvent");
    this.a3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA4ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA4ToPssIEEE3BEvent");
    this.a4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA4FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA4FromPssIEEE3BEvent");
    this.a4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA5ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA5ToPssIEEE3BEvent");
    this.a5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA5FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA5FromPssIEEE3BEvent");
    this.a5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA6ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA6ToPssIEEE3BEvent");
    this.a6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA6FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA6FromPssIEEE3BEvent");
    this.a6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA7ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA7ToPssIEEE3BEvent");
    this.a7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA7FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA7FromPssIEEE3BEvent");
    this.a7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA8ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignA8ToPssIEEE3BEvent");
    this.a8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA8FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignA8FromPssIEEE3BEvent");
    this.a8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignKs1ToPssIEEE3BEvent");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs1FromPssIEEE3BEvent");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs2ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignKs2ToPssIEEE3BEvent");
    this.ks2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs2FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs2FromPssIEEE3BEvent");
    this.ks2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssIEEE3BEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssIEEE3BEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssIEEE3BEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssIEEE3BEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw1ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignTw1ToPssIEEE3BEvent");
    this.tw1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw1FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw1FromPssIEEE3BEvent");
    this.tw1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw2ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignTw2ToPssIEEE3BEvent");
    this.tw2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw2FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw2FromPssIEEE3BEvent");
    this.tw2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw3ToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignTw3ToPssIEEE3BEvent");
    this.tw3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw3FromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw3FromPssIEEE3BEvent");
    this.tw3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstmaxToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignVstmaxToPssIEEE3BEvent");
    this.vstmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstmaxFromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstmaxFromPssIEEE3BEvent");
    this.vstmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstminToPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing AssignVstminToPssIEEE3BEvent");
    this.vstmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstminFromPssIEEE3BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstminFromPssIEEE3BEvent");
    this.vstmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssIEEE3BId;

  private InputSignalKind inputSignal1Type;
  private InputSignalKind inputSignal2Type;
  private PU a1 = null;
  private PU a2 = null;
  private PU a3 = null;
  private PU a4 = null;
  private PU a5 = null;
  private PU a6 = null;
  private PU a7 = null;
  private PU a8 = null;
  private PU ks1 = null;
  private PU ks2 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds tw1 = null;
  private Seconds tw2 = null;
  private Seconds tw3 = null;
  private PU vstmax = null;
  private PU vstmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssIEEE3BAggregate.class.getName());
}
