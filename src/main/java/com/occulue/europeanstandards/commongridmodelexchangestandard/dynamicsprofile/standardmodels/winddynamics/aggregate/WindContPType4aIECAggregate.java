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
 * Aggregate handler for WindContPType4aIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContPType4aIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContPType4aIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContPType4aIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContPType4aIECAggregate(CreateWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContPType4aIECCommand");
    CreateWindContPType4aIECEvent event =
        new CreateWindContPType4aIECEvent(command.getWindContPType4aIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContPType4aIECCommand");
    UpdateWindContPType4aIECEvent event =
        new UpdateWindContPType4aIECEvent(
            command.getWindContPType4aIECId(),
            command.getDpmax(),
            command.getTpord(),
            command.getTufilt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContPType4aIECCommand");
    apply(new DeleteWindContPType4aIECEvent(command.getWindContPType4aIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDpmaxToWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpmaxToWindContPType4aIECCommand");

    if (dpmax != null && dpmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDpmaxToWindContPType4aIECEvent(
            command.getWindContPType4aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpmaxFromWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpmaxFromWindContPType4aIECCommand");

    if (dpmax == null) throw new ProcessingException("Dpmax already has nothing assigned.");

    apply(new UnAssignDpmaxFromWindContPType4aIECEvent(command.getWindContPType4aIECId()));
  }

  @CommandHandler
  public void handle(AssignTpordToWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpordToWindContPType4aIECCommand");

    if (tpord != null && tpord.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpord already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpordToWindContPType4aIECEvent(
            command.getWindContPType4aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpordFromWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpordFromWindContPType4aIECCommand");

    if (tpord == null) throw new ProcessingException("Tpord already has nothing assigned.");

    apply(new UnAssignTpordFromWindContPType4aIECEvent(command.getWindContPType4aIECId()));
  }

  @CommandHandler
  public void handle(AssignTufiltToWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTufiltToWindContPType4aIECCommand");

    if (tufilt != null && tufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTufiltToWindContPType4aIECEvent(
            command.getWindContPType4aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTufiltFromWindContPType4aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTufiltFromWindContPType4aIECCommand");

    if (tufilt == null) throw new ProcessingException("Tufilt already has nothing assigned.");

    apply(new UnAssignTufiltFromWindContPType4aIECEvent(command.getWindContPType4aIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContPType4aIECEvent");
    this.windContPType4aIECId = event.getWindContPType4aIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dpmax = event.getDpmax();
    this.tpord = event.getTpord();
    this.tufilt = event.getTufilt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDpmaxToWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing AssignDpmaxToWindContPType4aIECEvent");
    this.dpmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpmaxFromWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDpmaxFromWindContPType4aIECEvent");
    this.dpmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpordToWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing AssignTpordToWindContPType4aIECEvent");
    this.tpord = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpordFromWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpordFromWindContPType4aIECEvent");
    this.tpord = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTufiltToWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing AssignTufiltToWindContPType4aIECEvent");
    this.tufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTufiltFromWindContPType4aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTufiltFromWindContPType4aIECEvent");
    this.tufilt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContPType4aIECId;

  private PU dpmax = null;
  private Seconds tpord = null;
  private Seconds tufilt = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4aIECAggregate.class.getName());
}
