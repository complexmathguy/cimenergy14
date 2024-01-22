package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for RaiseLowerCommand as outlined for the CQRS pattern, all write
 * responsibilities related to RaiseLowerCommand are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RaiseLowerCommandAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RaiseLowerCommandAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RaiseLowerCommandAggregate(CreateRaiseLowerCommandCommand command) throws Exception {
    LOGGER.info("Handling command CreateRaiseLowerCommandCommand");
    CreateRaiseLowerCommandEvent event =
        new CreateRaiseLowerCommandEvent(command.getRaiseLowerCommandId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRaiseLowerCommandCommand command) throws Exception {
    LOGGER.info("handling command UpdateRaiseLowerCommandCommand");
    UpdateRaiseLowerCommandEvent event =
        new UpdateRaiseLowerCommandEvent(
            command.getRaiseLowerCommandId(), command.getRaiseLowerCommands());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRaiseLowerCommandCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRaiseLowerCommandCommand");
    apply(new DeleteRaiseLowerCommandEvent(command.getRaiseLowerCommandId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRaiseLowerCommandsToRaiseLowerCommandCommand command) throws Exception {
    LOGGER.info("Handling command AssignRaiseLowerCommandsToRaiseLowerCommandCommand");

    if (raiseLowerCommands.contains(command.getAddTo()))
      throw new ProcessingException(
          "RaiseLowerCommands already contains an entity with id "
              + command.getAddTo().getRaiseLowerCommandId());

    apply(
        new AssignRaiseLowerCommandsToRaiseLowerCommandEvent(
            command.getRaiseLowerCommandId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveRaiseLowerCommandsFromRaiseLowerCommandCommand");

    if (!raiseLowerCommands.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "RaiseLowerCommands does not contain an entity with id "
              + command.getRemoveFrom().getRaiseLowerCommandId());

    apply(
        new RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent(
            command.getRaiseLowerCommandId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRaiseLowerCommandEvent event) {
    LOGGER.info("Event sourcing CreateRaiseLowerCommandEvent");
    this.raiseLowerCommandId = event.getRaiseLowerCommandId();
  }

  @EventSourcingHandler
  void on(UpdateRaiseLowerCommandEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.raiseLowerCommands = event.getRaiseLowerCommands();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRaiseLowerCommandsToRaiseLowerCommandEvent event) {
    LOGGER.info("Event sourcing AssignRaiseLowerCommandsToRaiseLowerCommandEvent");
    this.raiseLowerCommands.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent event) {
    LOGGER.info("Event sourcing RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent");
    this.raiseLowerCommands.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID raiseLowerCommandId;

  private Set<RaiseLowerCommand> raiseLowerCommands = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(RaiseLowerCommandAggregate.class.getName());
}
