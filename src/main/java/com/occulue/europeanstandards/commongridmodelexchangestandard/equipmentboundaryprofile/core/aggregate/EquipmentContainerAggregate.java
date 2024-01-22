package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.aggregate;

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
 * Aggregate handler for EquipmentContainer as outlined for the CQRS pattern, all write
 * responsibilities related to EquipmentContainer are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquipmentContainerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquipmentContainerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquipmentContainerAggregate(CreateEquipmentContainerCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquipmentContainerCommand");
    CreateEquipmentContainerEvent event =
        new CreateEquipmentContainerEvent(command.getEquipmentContainerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquipmentContainerCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquipmentContainerCommand");
    UpdateEquipmentContainerEvent event =
        new UpdateEquipmentContainerEvent(command.getEquipmentContainerId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquipmentContainerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquipmentContainerCommand");
    apply(new DeleteEquipmentContainerEvent(command.getEquipmentContainerId()));
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
  void on(CreateEquipmentContainerEvent event) {
    LOGGER.info("Event sourcing CreateEquipmentContainerEvent");
    this.equipmentContainerId = event.getEquipmentContainerId();
  }

  @EventSourcingHandler
  void on(UpdateEquipmentContainerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equipmentContainerId;

  private static final Logger LOGGER =
      Logger.getLogger(EquipmentContainerAggregate.class.getName());
}
