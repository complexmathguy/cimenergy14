package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc.aggregate;

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
 * Aggregate handler for DCTopologicalIsland as outlined for the CQRS pattern, all write
 * responsibilities related to DCTopologicalIsland are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCTopologicalIslandAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCTopologicalIslandAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCTopologicalIslandAggregate(CreateDCTopologicalIslandCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCTopologicalIslandCommand");
    CreateDCTopologicalIslandEvent event =
        new CreateDCTopologicalIslandEvent(command.getDCTopologicalIslandId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCTopologicalIslandCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCTopologicalIslandCommand");
    UpdateDCTopologicalIslandEvent event =
        new UpdateDCTopologicalIslandEvent(
            command.getDCTopologicalIslandId(), command.getDCTopologicalIsland());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCTopologicalIslandCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCTopologicalIslandCommand");
    apply(new DeleteDCTopologicalIslandEvent(command.getDCTopologicalIslandId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDCTopologicalIslandToDCTopologicalIslandCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDCTopologicalIslandToDCTopologicalIslandCommand");

    if (dCTopologicalIsland != null
        && dCTopologicalIsland.getDCTopologicalIslandId()
            == command.getAssignment().getDCTopologicalIslandId())
      throw new ProcessingException(
          "DCTopologicalIsland already assigned with id "
              + command.getAssignment().getDCTopologicalIslandId());

    apply(
        new AssignDCTopologicalIslandToDCTopologicalIslandEvent(
            command.getDCTopologicalIslandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand");

    if (dCTopologicalIsland == null)
      throw new ProcessingException("DCTopologicalIsland already has nothing assigned.");

    apply(
        new UnAssignDCTopologicalIslandFromDCTopologicalIslandEvent(
            command.getDCTopologicalIslandId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing CreateDCTopologicalIslandEvent");
    this.dCTopologicalIslandId = event.getDCTopologicalIslandId();
  }

  @EventSourcingHandler
  void on(UpdateDCTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCTopologicalIsland = event.getDCTopologicalIsland();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDCTopologicalIslandToDCTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing AssignDCTopologicalIslandToDCTopologicalIslandEvent");
    this.dCTopologicalIsland = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDCTopologicalIslandFromDCTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing UnAssignDCTopologicalIslandFromDCTopologicalIslandEvent");
    this.dCTopologicalIsland = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCTopologicalIslandId;

  private DCTopologicalIsland dCTopologicalIsland = null;

  private static final Logger LOGGER =
      Logger.getLogger(DCTopologicalIslandAggregate.class.getName());
}
