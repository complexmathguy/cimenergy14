package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.aggregate;

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
 * Aggregate handler for SolarGeneratingUnit as outlined for the CQRS pattern, all write
 * responsibilities related to SolarGeneratingUnit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SolarGeneratingUnitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SolarGeneratingUnitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SolarGeneratingUnitAggregate(CreateSolarGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command CreateSolarGeneratingUnitCommand");
    CreateSolarGeneratingUnitEvent event =
        new CreateSolarGeneratingUnitEvent(command.getSolarGeneratingUnitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSolarGeneratingUnitCommand command) throws Exception {
    LOGGER.info("handling command UpdateSolarGeneratingUnitCommand");
    UpdateSolarGeneratingUnitEvent event =
        new UpdateSolarGeneratingUnitEvent(command.getSolarGeneratingUnitId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSolarGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSolarGeneratingUnitCommand");
    apply(new DeleteSolarGeneratingUnitEvent(command.getSolarGeneratingUnitId()));
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
  void on(CreateSolarGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing CreateSolarGeneratingUnitEvent");
    this.solarGeneratingUnitId = event.getSolarGeneratingUnitId();
  }

  @EventSourcingHandler
  void on(UpdateSolarGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID solarGeneratingUnitId;

  private static final Logger LOGGER =
      Logger.getLogger(SolarGeneratingUnitAggregate.class.getName());
}
