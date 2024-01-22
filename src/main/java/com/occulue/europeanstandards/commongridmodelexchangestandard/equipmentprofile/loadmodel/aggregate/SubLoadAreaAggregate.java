package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.aggregate;

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
 * Aggregate handler for SubLoadArea as outlined for the CQRS pattern, all write responsibilities
 * related to SubLoadArea are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SubLoadAreaAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SubLoadAreaAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SubLoadAreaAggregate(CreateSubLoadAreaCommand command) throws Exception {
    LOGGER.info("Handling command CreateSubLoadAreaCommand");
    CreateSubLoadAreaEvent event = new CreateSubLoadAreaEvent(command.getSubLoadAreaId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSubLoadAreaCommand command) throws Exception {
    LOGGER.info("handling command UpdateSubLoadAreaCommand");
    UpdateSubLoadAreaEvent event =
        new UpdateSubLoadAreaEvent(command.getSubLoadAreaId(), command.getSubLoadAreas());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSubLoadAreaCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSubLoadAreaCommand");
    apply(new DeleteSubLoadAreaEvent(command.getSubLoadAreaId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignSubLoadAreasToSubLoadAreaCommand command) throws Exception {
    LOGGER.info("Handling command AssignSubLoadAreasToSubLoadAreaCommand");

    if (subLoadAreas.contains(command.getAddTo()))
      throw new ProcessingException(
          "SubLoadAreas already contains an entity with id "
              + command.getAddTo().getSubLoadAreaId());

    apply(new AssignSubLoadAreasToSubLoadAreaEvent(command.getSubLoadAreaId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveSubLoadAreasFromSubLoadAreaCommand command) throws Exception {
    LOGGER.info("Handling command RemoveSubLoadAreasFromSubLoadAreaCommand");

    if (!subLoadAreas.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "SubLoadAreas does not contain an entity with id "
              + command.getRemoveFrom().getSubLoadAreaId());

    apply(
        new RemoveSubLoadAreasFromSubLoadAreaEvent(
            command.getSubLoadAreaId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSubLoadAreaEvent event) {
    LOGGER.info("Event sourcing CreateSubLoadAreaEvent");
    this.subLoadAreaId = event.getSubLoadAreaId();
  }

  @EventSourcingHandler
  void on(UpdateSubLoadAreaEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.subLoadAreas = event.getSubLoadAreas();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignSubLoadAreasToSubLoadAreaEvent event) {
    LOGGER.info("Event sourcing AssignSubLoadAreasToSubLoadAreaEvent");
    this.subLoadAreas.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveSubLoadAreasFromSubLoadAreaEvent event) {
    LOGGER.info("Event sourcing RemoveSubLoadAreasFromSubLoadAreaEvent");
    this.subLoadAreas.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID subLoadAreaId;

  private Set<SubLoadArea> subLoadAreas = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(SubLoadAreaAggregate.class.getName());
}
