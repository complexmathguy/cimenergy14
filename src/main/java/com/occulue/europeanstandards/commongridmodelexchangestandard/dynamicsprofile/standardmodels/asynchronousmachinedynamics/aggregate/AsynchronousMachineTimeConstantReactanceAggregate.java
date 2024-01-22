package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.aggregate;

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
 * Aggregate handler for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern,
 * all write responsibilities related to AsynchronousMachineTimeConstantReactance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AsynchronousMachineTimeConstantReactanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AsynchronousMachineTimeConstantReactanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AsynchronousMachineTimeConstantReactanceAggregate(
      CreateAsynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateAsynchronousMachineTimeConstantReactanceCommand");
    CreateAsynchronousMachineTimeConstantReactanceEvent event =
        new CreateAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("handling command UpdateAsynchronousMachineTimeConstantReactanceCommand");
    UpdateAsynchronousMachineTimeConstantReactanceEvent event =
        new UpdateAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(),
            command.getTpo(),
            command.getTppo(),
            command.getXp(),
            command.getXpp(),
            command.getXs());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command DeleteAsynchronousMachineTimeConstantReactanceCommand");
    apply(
        new DeleteAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTpoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTpoToAsynchronousMachineTimeConstantReactanceCommand");

    if (tpo != null && tpo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpoToAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand");

    if (tpo == null) throw new ProcessingException("Tpo already has nothing assigned.");

    apply(
        new UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTppoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTppoToAsynchronousMachineTimeConstantReactanceCommand");

    if (tppo != null && tppo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tppo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTppoToAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand");

    if (tppo == null) throw new ProcessingException("Tppo already has nothing assigned.");

    apply(
        new UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXpToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXpToAsynchronousMachineTimeConstantReactanceCommand");

    if (xp != null && xp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXpToAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand");

    if (xp == null) throw new ProcessingException("Xp already has nothing assigned.");

    apply(
        new UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXppToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXppToAsynchronousMachineTimeConstantReactanceCommand");

    if (xpp != null && xpp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xpp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXppToAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand");

    if (xpp == null) throw new ProcessingException("Xpp already has nothing assigned.");

    apply(
        new UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXsToAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXsToAsynchronousMachineTimeConstantReactanceCommand");

    if (xs != null && xs.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xs already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXsToAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand");

    if (xs == null) throw new ProcessingException("Xs already has nothing assigned.");

    apply(
        new UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent(
            command.getAsynchronousMachineTimeConstantReactanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing CreateAsynchronousMachineTimeConstantReactanceEvent");
    this.asynchronousMachineTimeConstantReactanceId =
        event.getAsynchronousMachineTimeConstantReactanceId();
  }

  @EventSourcingHandler
  void on(UpdateAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.tpo = event.getTpo();
    this.tppo = event.getTppo();
    this.xp = event.getXp();
    this.xpp = event.getXpp();
    this.xs = event.getXs();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTpoToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTpoToAsynchronousMachineTimeConstantReactanceEvent");
    this.tpo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent");
    this.tpo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTppoToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTppoToAsynchronousMachineTimeConstantReactanceEvent");
    this.tppo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent");
    this.tppo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXpToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXpToAsynchronousMachineTimeConstantReactanceEvent");
    this.xp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent");
    this.xp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXppToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXppToAsynchronousMachineTimeConstantReactanceEvent");
    this.xpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent");
    this.xpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXsToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXsToAsynchronousMachineTimeConstantReactanceEvent");
    this.xs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent");
    this.xs = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID asynchronousMachineTimeConstantReactanceId;

  private Seconds tpo = null;
  private Seconds tppo = null;
  private PU xp = null;
  private PU xpp = null;
  private PU xs = null;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineTimeConstantReactanceAggregate.class.getName());
}
