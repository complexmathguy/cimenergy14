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
 * Aggregate handler for Pss1A as outlined for the CQRS pattern, all write responsibilities related
 * to Pss1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Pss1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Pss1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Pss1AAggregate(CreatePss1ACommand command) throws Exception {
    LOGGER.info("Handling command CreatePss1ACommand");
    CreatePss1AEvent event =
        new CreatePss1AEvent(command.getPss1AId(), command.getInputSignalType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePss1ACommand command) throws Exception {
    LOGGER.info("handling command UpdatePss1ACommand");
    UpdatePss1AEvent event =
        new UpdatePss1AEvent(
            command.getPss1AId(),
            command.getA1(),
            command.getA2(),
            command.getA3(),
            command.getA4(),
            command.getA5(),
            command.getA6(),
            command.getA7(),
            command.getA8(),
            command.getInputSignalType(),
            command.getKd(),
            command.getKs(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getTdelay(),
            command.getVcl(),
            command.getVcu(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePss1ACommand command) throws Exception {
    LOGGER.info("Handling command DeletePss1ACommand");
    apply(new DeletePss1AEvent(command.getPss1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignA1ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA1ToPss1ACommand");

    if (a1 != null && a1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA1ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA1FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA1FromPss1ACommand");

    if (a1 == null) throw new ProcessingException("A1 already has nothing assigned.");

    apply(new UnAssignA1FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA2ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA2ToPss1ACommand");

    if (a2 != null && a2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA2ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA2FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA2FromPss1ACommand");

    if (a2 == null) throw new ProcessingException("A2 already has nothing assigned.");

    apply(new UnAssignA2FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA3ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA3ToPss1ACommand");

    if (a3 != null && a3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA3ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA3FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA3FromPss1ACommand");

    if (a3 == null) throw new ProcessingException("A3 already has nothing assigned.");

    apply(new UnAssignA3FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA4ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA4ToPss1ACommand");

    if (a4 != null && a4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA4ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA4FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA4FromPss1ACommand");

    if (a4 == null) throw new ProcessingException("A4 already has nothing assigned.");

    apply(new UnAssignA4FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA5ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA5ToPss1ACommand");

    if (a5 != null && a5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA5ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA5FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA5FromPss1ACommand");

    if (a5 == null) throw new ProcessingException("A5 already has nothing assigned.");

    apply(new UnAssignA5FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA6ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA6ToPss1ACommand");

    if (a6 != null && a6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA6ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA6FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA6FromPss1ACommand");

    if (a6 == null) throw new ProcessingException("A6 already has nothing assigned.");

    apply(new UnAssignA6FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA7ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA7ToPss1ACommand");

    if (a7 != null && a7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A7 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA7ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA7FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA7FromPss1ACommand");

    if (a7 == null) throw new ProcessingException("A7 already has nothing assigned.");

    apply(new UnAssignA7FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignA8ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignA8ToPss1ACommand");

    if (a8 != null && a8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A8 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA8ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA8FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignA8FromPss1ACommand");

    if (a8 == null) throw new ProcessingException("A8 already has nothing assigned.");

    apply(new UnAssignA8FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignKdToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToPss1ACommand");

    if (kd != null && kd.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignKdToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromPss1ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignKsToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToPss1ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromPss1ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPss1ACommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPss1ACommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPss1ACommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPss1ACommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPss1ACommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPss1ACommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPss1ACommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPss1ACommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT5ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPss1ACommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPss1ACommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPss1ACommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPss1ACommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignTdelayToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTdelayToPss1ACommand");

    if (tdelay != null && tdelay.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdelay already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdelayToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdelayFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdelayFromPss1ACommand");

    if (tdelay == null) throw new ProcessingException("Tdelay already has nothing assigned.");

    apply(new UnAssignTdelayFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignVclToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVclToPss1ACommand");

    if (vcl != null && vcl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVclToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVclFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVclFromPss1ACommand");

    if (vcl == null) throw new ProcessingException("Vcl already has nothing assigned.");

    apply(new UnAssignVclFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignVcuToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVcuToPss1ACommand");

    if (vcu != null && vcu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVcuToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcuFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcuFromPss1ACommand");

    if (vcu == null) throw new ProcessingException("Vcu already has nothing assigned.");

    apply(new UnAssignVcuFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToPss1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromPss1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromPss1AEvent(command.getPss1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToPss1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToPss1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToPss1AEvent(command.getPss1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromPss1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromPss1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromPss1AEvent(command.getPss1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePss1AEvent event) {
    LOGGER.info("Event sourcing CreatePss1AEvent");
    this.pss1AId = event.getPss1AId();
    this.inputSignalType = event.getInputSignalType();
  }

  @EventSourcingHandler
  void on(UpdatePss1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a1 = event.getA1();
    this.a2 = event.getA2();
    this.a3 = event.getA3();
    this.a4 = event.getA4();
    this.a5 = event.getA5();
    this.a6 = event.getA6();
    this.a7 = event.getA7();
    this.a8 = event.getA8();
    this.inputSignalType = event.getInputSignalType();
    this.kd = event.getKd();
    this.ks = event.getKs();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.tdelay = event.getTdelay();
    this.vcl = event.getVcl();
    this.vcu = event.getVcu();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignA1ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA1ToPss1AEvent");
    this.a1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA1FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA1FromPss1AEvent");
    this.a1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA2ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA2ToPss1AEvent");
    this.a2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA2FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA2FromPss1AEvent");
    this.a2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA3ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA3ToPss1AEvent");
    this.a3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA3FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA3FromPss1AEvent");
    this.a3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA4ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA4ToPss1AEvent");
    this.a4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA4FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA4FromPss1AEvent");
    this.a4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA5ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA5ToPss1AEvent");
    this.a5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA5FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA5FromPss1AEvent");
    this.a5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA6ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA6ToPss1AEvent");
    this.a6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA6FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA6FromPss1AEvent");
    this.a6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA7ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA7ToPss1AEvent");
    this.a7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA7FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA7FromPss1AEvent");
    this.a7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA8ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignA8ToPss1AEvent");
    this.a8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA8FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignA8FromPss1AEvent");
    this.a8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignKdToPss1AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromPss1AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignKsToPss1AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromPss1AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPss1AEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPss1AEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPss1AEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPss1AEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPss1AEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPss1AEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPss1AEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPss1AEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT5ToPss1AEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromPss1AEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPss1AEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPss1AEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdelayToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignTdelayToPss1AEvent");
    this.tdelay = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdelayFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTdelayFromPss1AEvent");
    this.tdelay = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVclToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignVclToPss1AEvent");
    this.vcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVclFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVclFromPss1AEvent");
    this.vcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcuToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignVcuToPss1AEvent");
    this.vcu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcuFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVcuFromPss1AEvent");
    this.vcu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToPss1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromPss1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToPss1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToPss1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromPss1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromPss1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pss1AId;

  private InputSignalKind inputSignalType;
  private PU a1 = null;
  private PU a2 = null;
  private PU a3 = null;
  private PU a4 = null;
  private PU a5 = null;
  private PU a6 = null;
  private PU a7 = null;
  private PU a8 = null;
  private BooleanProxy kd = null;
  private PU ks = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds tdelay = null;
  private PU vcl = null;
  private PU vcu = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(Pss1AAggregate.class.getName());
}
