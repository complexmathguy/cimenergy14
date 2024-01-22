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
 * Aggregate handler for SubGeographicalRegion as outlined for the CQRS pattern, all write
 * responsibilities related to SubGeographicalRegion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SubGeographicalRegionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SubGeographicalRegionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SubGeographicalRegionAggregate(CreateSubGeographicalRegionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSubGeographicalRegionCommand");
    CreateSubGeographicalRegionEvent event =
        new CreateSubGeographicalRegionEvent(command.getSubGeographicalRegionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSubGeographicalRegionCommand command) throws Exception {
    LOGGER.info("handling command UpdateSubGeographicalRegionCommand");
    UpdateSubGeographicalRegionEvent event =
        new UpdateSubGeographicalRegionEvent(
            command.getSubGeographicalRegionId(), command.getRegions());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSubGeographicalRegionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSubGeographicalRegionCommand");
    apply(new DeleteSubGeographicalRegionEvent(command.getSubGeographicalRegionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRegionsToSubGeographicalRegionCommand command) throws Exception {
    LOGGER.info("Handling command AssignRegionsToSubGeographicalRegionCommand");

    if (regions.contains(command.getAddTo()))
      throw new ProcessingException(
          "Regions already contains an entity with id "
              + command.getAddTo().getSubGeographicalRegionId());

    apply(
        new AssignRegionsToSubGeographicalRegionEvent(
            command.getSubGeographicalRegionId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRegionsFromSubGeographicalRegionCommand command) throws Exception {
    LOGGER.info("Handling command RemoveRegionsFromSubGeographicalRegionCommand");

    if (!regions.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Regions does not contain an entity with id "
              + command.getRemoveFrom().getSubGeographicalRegionId());

    apply(
        new RemoveRegionsFromSubGeographicalRegionEvent(
            command.getSubGeographicalRegionId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSubGeographicalRegionEvent event) {
    LOGGER.info("Event sourcing CreateSubGeographicalRegionEvent");
    this.subGeographicalRegionId = event.getSubGeographicalRegionId();
  }

  @EventSourcingHandler
  void on(UpdateSubGeographicalRegionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.regions = event.getRegions();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRegionsToSubGeographicalRegionEvent event) {
    LOGGER.info("Event sourcing AssignRegionsToSubGeographicalRegionEvent");
    this.regions.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRegionsFromSubGeographicalRegionEvent event) {
    LOGGER.info("Event sourcing RemoveRegionsFromSubGeographicalRegionEvent");
    this.regions.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID subGeographicalRegionId;

  private Set<SubGeographicalRegion> regions = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(SubGeographicalRegionAggregate.class.getName());
}
