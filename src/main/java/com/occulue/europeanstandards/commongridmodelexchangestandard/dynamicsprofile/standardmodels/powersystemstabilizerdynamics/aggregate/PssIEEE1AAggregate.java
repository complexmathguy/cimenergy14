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
 * Aggregate handler for PssIEEE1A as outlined for the CQRS pattern, all write responsibilities
 * related to PssIEEE1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssIEEE1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssIEEE1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssIEEE1AAggregate(CreatePssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command CreatePssIEEE1ACommand");
    CreatePssIEEE1AEvent event =
        new CreatePssIEEE1AEvent(command.getPssIEEE1AId(), command.getInputSignalType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssIEEE1ACommand command) throws Exception {
    LOGGER.info("handling command UpdatePssIEEE1ACommand");
    UpdatePssIEEE1AEvent event =
        new UpdatePssIEEE1AEvent(
            command.getPssIEEE1AId(),
            command.getA1(),
            command.getA2(),
            command.getInputSignalType(),
            command.getKs(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command DeletePssIEEE1ACommand");
    apply(new DeletePssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignA1ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA1ToPssIEEE1ACommand");

    if (a1 != null && a1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA1ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA1FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA1FromPssIEEE1ACommand");

    if (a1 == null) throw new ProcessingException("A1 already has nothing assigned.");

    apply(new UnAssignA1FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignA2ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA2ToPssIEEE1ACommand");

    if (a2 != null && a2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA2ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA2FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA2FromPssIEEE1ACommand");

    if (a2 == null) throw new ProcessingException("A2 already has nothing assigned.");

    apply(new UnAssignA2FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignKsToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToPssIEEE1ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromPssIEEE1ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssIEEE1ACommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssIEEE1ACommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssIEEE1ACommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssIEEE1ACommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssIEEE1ACommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssIEEE1ACommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssIEEE1ACommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssIEEE1ACommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT5ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPssIEEE1ACommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPssIEEE1ACommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPssIEEE1ACommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPssIEEE1ACommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToPssIEEE1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromPssIEEE1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToPssIEEE1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToPssIEEE1AEvent(command.getPssIEEE1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromPssIEEE1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromPssIEEE1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromPssIEEE1AEvent(command.getPssIEEE1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssIEEE1AEvent event) {
    LOGGER.info("Event sourcing CreatePssIEEE1AEvent");
    this.pssIEEE1AId = event.getPssIEEE1AId();
    this.inputSignalType = event.getInputSignalType();
  }

  @EventSourcingHandler
  void on(UpdatePssIEEE1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a1 = event.getA1();
    this.a2 = event.getA2();
    this.inputSignalType = event.getInputSignalType();
    this.ks = event.getKs();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignA1ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignA1ToPssIEEE1AEvent");
    this.a1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA1FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA1FromPssIEEE1AEvent");
    this.a1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA2ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignA2ToPssIEEE1AEvent");
    this.a2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA2FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA2FromPssIEEE1AEvent");
    this.a2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignKsToPssIEEE1AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromPssIEEE1AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssIEEE1AEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssIEEE1AEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssIEEE1AEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssIEEE1AEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPssIEEE1AEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssIEEE1AEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPssIEEE1AEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssIEEE1AEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT5ToPssIEEE1AEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromPssIEEE1AEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPssIEEE1AEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPssIEEE1AEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToPssIEEE1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromPssIEEE1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToPssIEEE1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromPssIEEE1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromPssIEEE1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssIEEE1AId;

  private InputSignalKind inputSignalType;
  private PU a1 = null;
  private PU a2 = null;
  private PU ks = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssIEEE1AAggregate.class.getName());
}
