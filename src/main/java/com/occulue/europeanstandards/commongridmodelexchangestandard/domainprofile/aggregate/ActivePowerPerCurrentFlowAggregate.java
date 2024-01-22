package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for ActivePowerPerCurrentFlow as outlined for the CQRS pattern, all write
 * responsibilities related to ActivePowerPerCurrentFlow are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ActivePowerPerCurrentFlowAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ActivePowerPerCurrentFlowAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ActivePowerPerCurrentFlowAggregate(CreateActivePowerPerCurrentFlowCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateActivePowerPerCurrentFlowCommand");
    CreateActivePowerPerCurrentFlowEvent event =
        new CreateActivePowerPerCurrentFlowEvent(command.getActivePowerPerCurrentFlowId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateActivePowerPerCurrentFlowCommand command) throws Exception {
    LOGGER.info("handling command UpdateActivePowerPerCurrentFlowCommand");
    UpdateActivePowerPerCurrentFlowEvent event =
        new UpdateActivePowerPerCurrentFlowEvent(command.getActivePowerPerCurrentFlowId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteActivePowerPerCurrentFlowCommand command) throws Exception {
    LOGGER.info("Handling command DeleteActivePowerPerCurrentFlowCommand");
    apply(new DeleteActivePowerPerCurrentFlowEvent(command.getActivePowerPerCurrentFlowId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateActivePowerPerCurrentFlowEvent event) {
    LOGGER.info("Event sourcing CreateActivePowerPerCurrentFlowEvent");
    this.activePowerPerCurrentFlowId = event.getActivePowerPerCurrentFlowId();
  }

  @EventSourcingHandler
  void on(UpdateActivePowerPerCurrentFlowEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID activePowerPerCurrentFlowId;

  private ACDCConverter switchingLoss = null;

  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerPerCurrentFlowAggregate.class.getName());
}
