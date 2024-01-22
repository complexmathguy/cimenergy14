package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for DCLine as outlined for the CQRS pattern, all write responsibilities related
 * to DCLine are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCLineAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCLineAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCLineAggregate(CreateDCLineCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCLineCommand");
    CreateDCLineEvent event = new CreateDCLineEvent(command.getDCLineId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCLineCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCLineCommand");
    UpdateDCLineEvent event = new UpdateDCLineEvent(command.getDCLineId(), command.getDCLines());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCLineCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCLineCommand");
    apply(new DeleteDCLineEvent(command.getDCLineId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCLinesToDCLineCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCLinesToDCLineCommand");

    if (dCLines.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCLines already contains an entity with id " + command.getAddTo().getDCLineId());

    apply(new AssignDCLinesToDCLineEvent(command.getDCLineId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCLinesFromDCLineCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCLinesFromDCLineCommand");

    if (!dCLines.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCLines does not contain an entity with id " + command.getRemoveFrom().getDCLineId());

    apply(new RemoveDCLinesFromDCLineEvent(command.getDCLineId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCLineEvent event) {
    LOGGER.info("Event sourcing CreateDCLineEvent");
    this.dCLineId = event.getDCLineId();
  }

  @EventSourcingHandler
  void on(UpdateDCLineEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCLines = event.getDCLines();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCLinesToDCLineEvent event) {
    LOGGER.info("Event sourcing AssignDCLinesToDCLineEvent");
    this.dCLines.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCLinesFromDCLineEvent event) {
    LOGGER.info("Event sourcing RemoveDCLinesFromDCLineEvent");
    this.dCLines.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCLineId;

  private Set<DCLine> dCLines = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCLineAggregate.class.getName());
}
