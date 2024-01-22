package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.aggregate;

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
 * Aggregate handler for Line as outlined for the CQRS pattern, all write responsibilities related
 * to Line are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LineAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LineAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LineAggregate(CreateLineCommand command) throws Exception {
    LOGGER.info("Handling command CreateLineCommand");
    CreateLineEvent event = new CreateLineEvent(command.getLineId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLineCommand command) throws Exception {
    LOGGER.info("handling command UpdateLineCommand");
    UpdateLineEvent event = new UpdateLineEvent(command.getLineId(), command.getLines());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLineCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLineCommand");
    apply(new DeleteLineEvent(command.getLineId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignLinesToLineCommand command) throws Exception {
    LOGGER.info("Handling command AssignLinesToLineCommand");

    if (lines.contains(command.getAddTo()))
      throw new ProcessingException(
          "Lines already contains an entity with id " + command.getAddTo().getLineId());

    apply(new AssignLinesToLineEvent(command.getLineId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLinesFromLineCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLinesFromLineCommand");

    if (!lines.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Lines does not contain an entity with id " + command.getRemoveFrom().getLineId());

    apply(new RemoveLinesFromLineEvent(command.getLineId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLineEvent event) {
    LOGGER.info("Event sourcing CreateLineEvent");
    this.lineId = event.getLineId();
  }

  @EventSourcingHandler
  void on(UpdateLineEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.lines = event.getLines();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignLinesToLineEvent event) {
    LOGGER.info("Event sourcing AssignLinesToLineEvent");
    this.lines.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLinesFromLineEvent event) {
    LOGGER.info("Event sourcing RemoveLinesFromLineEvent");
    this.lines.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID lineId;

  private Set<Line> lines = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(LineAggregate.class.getName());
}
