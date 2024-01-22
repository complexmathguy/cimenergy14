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
 * Aggregate handler for PssSH as outlined for the CQRS pattern, all write responsibilities related
 * to PssSH are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssSHAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssSHAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssSHAggregate(CreatePssSHCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssSHCommand");
    CreatePssSHEvent event = new CreatePssSHEvent(command.getPssSHId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssSHCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssSHCommand");
    UpdatePssSHEvent event =
        new UpdatePssSHEvent(
            command.getPssSHId(),
            command.getK(),
            command.getK0(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getK4(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getTd(),
            command.getVsmax(),
            command.getVsmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssSHCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssSHCommand");
    apply(new DeletePssSHEvent(command.getPssSHId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignKToPssSHCommand");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromPssSHCommand");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignK0ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignK0ToPssSHCommand");

    if (k0 != null && k0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK0ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK0FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK0FromPssSHCommand");

    if (k0 == null) throw new ProcessingException("K0 already has nothing assigned.");

    apply(new UnAssignK0FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignK1ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToPssSHCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromPssSHCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignK2ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToPssSHCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromPssSHCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignK3ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignK3ToPssSHCommand");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromPssSHCommand");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignK4ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignK4ToPssSHCommand");

    if (k4 != null && k4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK4ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromPssSHCommand");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssSHCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssSHCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssSHCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssSHCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssSHCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssSHCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssSHCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssSHCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignTdToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToPssSHCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromPssSHCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignVsmaxToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsmaxToPssSHCommand");

    if (vsmax != null && vsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmaxToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmaxFromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmaxFromPssSHCommand");

    if (vsmax == null) throw new ProcessingException("Vsmax already has nothing assigned.");

    apply(new UnAssignVsmaxFromPssSHEvent(command.getPssSHId()));
  }

  @CommandHandler
  public void handle(AssignVsminToPssSHCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsminToPssSHCommand");

    if (vsmin != null && vsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsminToPssSHEvent(command.getPssSHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsminFromPssSHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsminFromPssSHCommand");

    if (vsmin == null) throw new ProcessingException("Vsmin already has nothing assigned.");

    apply(new UnAssignVsminFromPssSHEvent(command.getPssSHId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssSHEvent event) {
    LOGGER.info("Event sourcing CreatePssSHEvent");
    this.pssSHId = event.getPssSHId();
  }

  @EventSourcingHandler
  void on(UpdatePssSHEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k = event.getK();
    this.k0 = event.getK0();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.k4 = event.getK4();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.td = event.getTd();
    this.vsmax = event.getVsmax();
    this.vsmin = event.getVsmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignKToPssSHEvent");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignKFromPssSHEvent");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK0ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignK0ToPssSHEvent");
    this.k0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK0FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignK0FromPssSHEvent");
    this.k0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignK1ToPssSHEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromPssSHEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignK2ToPssSHEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromPssSHEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignK3ToPssSHEvent");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignK3FromPssSHEvent");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignK4ToPssSHEvent");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignK4FromPssSHEvent");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssSHEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssSHEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssSHEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssSHEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPssSHEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssSHEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPssSHEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssSHEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignTdToPssSHEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromPssSHEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmaxToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignVsmaxToPssSHEvent");
    this.vsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmaxFromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignVsmaxFromPssSHEvent");
    this.vsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsminToPssSHEvent event) {
    LOGGER.info("Event sourcing AssignVsminToPssSHEvent");
    this.vsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsminFromPssSHEvent event) {
    LOGGER.info("Event sourcing UnAssignVsminFromPssSHEvent");
    this.vsmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssSHId;

  private PU k = null;
  private PU k0 = null;
  private PU k1 = null;
  private PU k2 = null;
  private PU k3 = null;
  private PU k4 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds td = null;
  private PU vsmax = null;
  private PU vsmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssSHAggregate.class.getName());
}
