package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.aggregate;

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
 * Aggregate handler for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern, all
 * write responsibilities related to SynchronousMachineEquivalentCircuit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineEquivalentCircuitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineEquivalentCircuitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineEquivalentCircuitAggregate(
      CreateSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineEquivalentCircuitCommand");
    CreateSynchronousMachineEquivalentCircuitEvent event =
        new CreateSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineEquivalentCircuitCommand");
    UpdateSynchronousMachineEquivalentCircuitEvent event =
        new UpdateSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(),
            command.getR1d(),
            command.getR1q(),
            command.getR2q(),
            command.getRfd(),
            command.getX1d(),
            command.getX1q(),
            command.getX2q(),
            command.getXad(),
            command.getXaq(),
            command.getXf1d(),
            command.getXfd());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineEquivalentCircuitCommand");
    apply(
        new DeleteSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignR1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignR1dToSynchronousMachineEquivalentCircuitCommand");

    if (r1d != null && r1d.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R1d already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignR1dToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand");

    if (r1d == null) throw new ProcessingException("R1d already has nothing assigned.");

    apply(
        new UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignR1qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignR1qToSynchronousMachineEquivalentCircuitCommand");

    if (r1q != null && r1q.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R1q already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignR1qToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand");

    if (r1q == null) throw new ProcessingException("R1q already has nothing assigned.");

    apply(
        new UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignR2qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignR2qToSynchronousMachineEquivalentCircuitCommand");

    if (r2q != null && r2q.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R2q already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignR2qToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand");

    if (r2q == null) throw new ProcessingException("R2q already has nothing assigned.");

    apply(
        new UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignRfdToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRfdToSynchronousMachineEquivalentCircuitCommand");

    if (rfd != null && rfd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rfd already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRfdToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand");

    if (rfd == null) throw new ProcessingException("Rfd already has nothing assigned.");

    apply(
        new UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignX1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignX1dToSynchronousMachineEquivalentCircuitCommand");

    if (x1d != null && x1d.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "X1d already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignX1dToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand");

    if (x1d == null) throw new ProcessingException("X1d already has nothing assigned.");

    apply(
        new UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignX1qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignX1qToSynchronousMachineEquivalentCircuitCommand");

    if (x1q != null && x1q.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "X1q already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignX1qToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand");

    if (x1q == null) throw new ProcessingException("X1q already has nothing assigned.");

    apply(
        new UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignX2qToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignX2qToSynchronousMachineEquivalentCircuitCommand");

    if (x2q != null && x2q.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "X2q already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignX2qToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand");

    if (x2q == null) throw new ProcessingException("X2q already has nothing assigned.");

    apply(
        new UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXadToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXadToSynchronousMachineEquivalentCircuitCommand");

    if (xad != null && xad.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xad already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXadToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXadFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXadFromSynchronousMachineEquivalentCircuitCommand");

    if (xad == null) throw new ProcessingException("Xad already has nothing assigned.");

    apply(
        new UnAssignXadFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXaqToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXaqToSynchronousMachineEquivalentCircuitCommand");

    if (xaq != null && xaq.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xaq already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXaqToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand");

    if (xaq == null) throw new ProcessingException("Xaq already has nothing assigned.");

    apply(
        new UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXf1dToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXf1dToSynchronousMachineEquivalentCircuitCommand");

    if (xf1d != null && xf1d.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xf1d already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXf1dToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand");

    if (xf1d == null) throw new ProcessingException("Xf1d already has nothing assigned.");

    apply(
        new UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXfdToSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXfdToSynchronousMachineEquivalentCircuitCommand");

    if (xfd != null && xfd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xfd already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXfdToSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand");

    if (xfd == null) throw new ProcessingException("Xfd already has nothing assigned.");

    apply(
        new UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent(
            command.getSynchronousMachineEquivalentCircuitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineEquivalentCircuitEvent");
    this.synchronousMachineEquivalentCircuitId = event.getSynchronousMachineEquivalentCircuitId();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.r1d = event.getR1d();
    this.r1q = event.getR1q();
    this.r2q = event.getR2q();
    this.rfd = event.getRfd();
    this.x1d = event.getX1d();
    this.x1q = event.getX1q();
    this.x2q = event.getX2q();
    this.xad = event.getXad();
    this.xaq = event.getXaq();
    this.xf1d = event.getXf1d();
    this.xfd = event.getXfd();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignR1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignR1dToSynchronousMachineEquivalentCircuitEvent");
    this.r1d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent");
    this.r1d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR1qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignR1qToSynchronousMachineEquivalentCircuitEvent");
    this.r1q = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent");
    this.r1q = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR2qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignR2qToSynchronousMachineEquivalentCircuitEvent");
    this.r2q = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent");
    this.r2q = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRfdToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignRfdToSynchronousMachineEquivalentCircuitEvent");
    this.rfd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent");
    this.rfd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignX1dToSynchronousMachineEquivalentCircuitEvent");
    this.x1d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent");
    this.x1d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX1qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignX1qToSynchronousMachineEquivalentCircuitEvent");
    this.x1q = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent");
    this.x1q = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX2qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignX2qToSynchronousMachineEquivalentCircuitEvent");
    this.x2q = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent");
    this.x2q = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXadToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXadToSynchronousMachineEquivalentCircuitEvent");
    this.xad = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXadFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXadFromSynchronousMachineEquivalentCircuitEvent");
    this.xad = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXaqToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXaqToSynchronousMachineEquivalentCircuitEvent");
    this.xaq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent");
    this.xaq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXf1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXf1dToSynchronousMachineEquivalentCircuitEvent");
    this.xf1d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent");
    this.xf1d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXfdToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXfdToSynchronousMachineEquivalentCircuitEvent");
    this.xfd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent");
    this.xfd = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineEquivalentCircuitId;

  private PU r1d = null;
  private PU r1q = null;
  private PU r2q = null;
  private PU rfd = null;
  private PU x1d = null;
  private PU x1q = null;
  private PU x2q = null;
  private PU xad = null;
  private PU xaq = null;
  private PU xf1d = null;
  private PU xfd = null;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEquivalentCircuitAggregate.class.getName());
}
