package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.aggregate;

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
 * Aggregate handler for DiagramObjectStyle as outlined for the CQRS pattern, all write
 * responsibilities related to DiagramObjectStyle are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiagramObjectStyleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiagramObjectStyleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiagramObjectStyleAggregate(CreateDiagramObjectStyleCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiagramObjectStyleCommand");
    CreateDiagramObjectStyleEvent event =
        new CreateDiagramObjectStyleEvent(command.getDiagramObjectStyleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiagramObjectStyleCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiagramObjectStyleCommand");
    UpdateDiagramObjectStyleEvent event =
        new UpdateDiagramObjectStyleEvent(command.getDiagramObjectStyleId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiagramObjectStyleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiagramObjectStyleCommand");
    apply(new DeleteDiagramObjectStyleEvent(command.getDiagramObjectStyleId()));
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
  void on(CreateDiagramObjectStyleEvent event) {
    LOGGER.info("Event sourcing CreateDiagramObjectStyleEvent");
    this.diagramObjectStyleId = event.getDiagramObjectStyleId();
  }

  @EventSourcingHandler
  void on(UpdateDiagramObjectStyleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID diagramObjectStyleId;

  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectStyleAggregate.class.getName());
}
