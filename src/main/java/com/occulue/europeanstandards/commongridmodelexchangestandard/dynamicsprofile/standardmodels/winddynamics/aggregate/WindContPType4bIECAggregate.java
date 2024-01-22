package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindContPType4bIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContPType4bIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContPType4bIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContPType4bIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContPType4bIECAggregate(CreateWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContPType4bIECCommand");
    CreateWindContPType4bIECEvent event =
        new CreateWindContPType4bIECEvent(command.getWindContPType4bIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContPType4bIECCommand");
    UpdateWindContPType4bIECEvent event =
        new UpdateWindContPType4bIECEvent(
            command.getWindContPType4bIECId(),
            command.getDpmax(),
            command.getTpaero(),
            command.getTpord(),
            command.getTufilt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContPType4bIECCommand");
    apply(new DeleteWindContPType4bIECEvent(command.getWindContPType4bIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDpmaxToWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpmaxToWindContPType4bIECCommand");

    if (dpmax != null && dpmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDpmaxToWindContPType4bIECEvent(
            command.getWindContPType4bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpmaxFromWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpmaxFromWindContPType4bIECCommand");

    if (dpmax == null) throw new ProcessingException("Dpmax already has nothing assigned.");

    apply(new UnAssignDpmaxFromWindContPType4bIECEvent(command.getWindContPType4bIECId()));
  }

  @CommandHandler
  public void handle(AssignTpaeroToWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpaeroToWindContPType4bIECCommand");

    if (tpaero != null && tpaero.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpaero already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpaeroToWindContPType4bIECEvent(
            command.getWindContPType4bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpaeroFromWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpaeroFromWindContPType4bIECCommand");

    if (tpaero == null) throw new ProcessingException("Tpaero already has nothing assigned.");

    apply(new UnAssignTpaeroFromWindContPType4bIECEvent(command.getWindContPType4bIECId()));
  }

  @CommandHandler
  public void handle(AssignTpordToWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpordToWindContPType4bIECCommand");

    if (tpord != null && tpord.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpord already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpordToWindContPType4bIECEvent(
            command.getWindContPType4bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpordFromWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpordFromWindContPType4bIECCommand");

    if (tpord == null) throw new ProcessingException("Tpord already has nothing assigned.");

    apply(new UnAssignTpordFromWindContPType4bIECEvent(command.getWindContPType4bIECId()));
  }

  @CommandHandler
  public void handle(AssignTufiltToWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTufiltToWindContPType4bIECCommand");

    if (tufilt != null && tufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTufiltToWindContPType4bIECEvent(
            command.getWindContPType4bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTufiltFromWindContPType4bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTufiltFromWindContPType4bIECCommand");

    if (tufilt == null) throw new ProcessingException("Tufilt already has nothing assigned.");

    apply(new UnAssignTufiltFromWindContPType4bIECEvent(command.getWindContPType4bIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContPType4bIECEvent");
    this.windContPType4bIECId = event.getWindContPType4bIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dpmax = event.getDpmax();
    this.tpaero = event.getTpaero();
    this.tpord = event.getTpord();
    this.tufilt = event.getTufilt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDpmaxToWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing AssignDpmaxToWindContPType4bIECEvent");
    this.dpmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpmaxFromWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDpmaxFromWindContPType4bIECEvent");
    this.dpmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpaeroToWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing AssignTpaeroToWindContPType4bIECEvent");
    this.tpaero = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpaeroFromWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpaeroFromWindContPType4bIECEvent");
    this.tpaero = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpordToWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing AssignTpordToWindContPType4bIECEvent");
    this.tpord = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpordFromWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpordFromWindContPType4bIECEvent");
    this.tpord = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTufiltToWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing AssignTufiltToWindContPType4bIECEvent");
    this.tufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTufiltFromWindContPType4bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTufiltFromWindContPType4bIECEvent");
    this.tufilt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContPType4bIECId;

  private PU dpmax = null;
  private Seconds tpaero = null;
  private Seconds tpord = null;
  private Seconds tufilt = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4bIECAggregate.class.getName());
}
