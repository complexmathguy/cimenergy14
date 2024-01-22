package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.aggregate;

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
 * Aggregate handler for EquivalentNetwork as outlined for the CQRS pattern, all write
 * responsibilities related to EquivalentNetwork are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquivalentNetworkAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquivalentNetworkAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquivalentNetworkAggregate(CreateEquivalentNetworkCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquivalentNetworkCommand");
    CreateEquivalentNetworkEvent event =
        new CreateEquivalentNetworkEvent(command.getEquivalentNetworkId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquivalentNetworkCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquivalentNetworkCommand");
    UpdateEquivalentNetworkEvent event =
        new UpdateEquivalentNetworkEvent(command.getEquivalentNetworkId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquivalentNetworkCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquivalentNetworkCommand");
    apply(new DeleteEquivalentNetworkEvent(command.getEquivalentNetworkId()));
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
  void on(CreateEquivalentNetworkEvent event) {
    LOGGER.info("Event sourcing CreateEquivalentNetworkEvent");
    this.equivalentNetworkId = event.getEquivalentNetworkId();
  }

  @EventSourcingHandler
  void on(UpdateEquivalentNetworkEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equivalentNetworkId;

  private static final Logger LOGGER = Logger.getLogger(EquivalentNetworkAggregate.class.getName());
}
