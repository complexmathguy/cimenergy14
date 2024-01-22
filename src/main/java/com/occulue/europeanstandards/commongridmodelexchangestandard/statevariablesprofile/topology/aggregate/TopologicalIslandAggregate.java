package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.aggregate;

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
 * Aggregate handler for TopologicalIsland as outlined for the CQRS pattern, all write
 * responsibilities related to TopologicalIsland are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TopologicalIslandAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TopologicalIslandAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TopologicalIslandAggregate(CreateTopologicalIslandCommand command) throws Exception {
    LOGGER.info("Handling command CreateTopologicalIslandCommand");
    CreateTopologicalIslandEvent event =
        new CreateTopologicalIslandEvent(command.getTopologicalIslandId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTopologicalIslandCommand command) throws Exception {
    LOGGER.info("handling command UpdateTopologicalIslandCommand");
    UpdateTopologicalIslandEvent event =
        new UpdateTopologicalIslandEvent(
            command.getTopologicalIslandId(),
            command.getTopologicalIsland(),
            command.getAngleRefTopologicalIsland());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTopologicalIslandCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTopologicalIslandCommand");
    apply(new DeleteTopologicalIslandEvent(command.getTopologicalIslandId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTopologicalIslandToTopologicalIslandCommand command) throws Exception {
    LOGGER.info("Handling command AssignTopologicalIslandToTopologicalIslandCommand");

    if (topologicalIsland != null
        && topologicalIsland.getTopologicalIslandId()
            == command.getAssignment().getTopologicalIslandId())
      throw new ProcessingException(
          "TopologicalIsland already assigned with id "
              + command.getAssignment().getTopologicalIslandId());

    apply(
        new AssignTopologicalIslandToTopologicalIslandEvent(
            command.getTopologicalIslandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTopologicalIslandFromTopologicalIslandCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTopologicalIslandFromTopologicalIslandCommand");

    if (topologicalIsland == null)
      throw new ProcessingException("TopologicalIsland already has nothing assigned.");

    apply(
        new UnAssignTopologicalIslandFromTopologicalIslandEvent(command.getTopologicalIslandId()));
  }

  @CommandHandler
  public void handle(AssignAngleRefTopologicalIslandToTopologicalIslandCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignAngleRefTopologicalIslandToTopologicalIslandCommand");

    if (angleRefTopologicalIsland != null
        && angleRefTopologicalIsland.getTopologicalIslandId()
            == command.getAssignment().getTopologicalIslandId())
      throw new ProcessingException(
          "AngleRefTopologicalIsland already assigned with id "
              + command.getAssignment().getTopologicalIslandId());

    apply(
        new AssignAngleRefTopologicalIslandToTopologicalIslandEvent(
            command.getTopologicalIslandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand");

    if (angleRefTopologicalIsland == null)
      throw new ProcessingException("AngleRefTopologicalIsland already has nothing assigned.");

    apply(
        new UnAssignAngleRefTopologicalIslandFromTopologicalIslandEvent(
            command.getTopologicalIslandId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing CreateTopologicalIslandEvent");
    this.topologicalIslandId = event.getTopologicalIslandId();
  }

  @EventSourcingHandler
  void on(UpdateTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.topologicalIsland = event.getTopologicalIsland();
    this.angleRefTopologicalIsland = event.getAngleRefTopologicalIsland();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTopologicalIslandToTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing AssignTopologicalIslandToTopologicalIslandEvent");
    this.topologicalIsland = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTopologicalIslandFromTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing UnAssignTopologicalIslandFromTopologicalIslandEvent");
    this.topologicalIsland = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAngleRefTopologicalIslandToTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing AssignAngleRefTopologicalIslandToTopologicalIslandEvent");
    this.angleRefTopologicalIsland = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAngleRefTopologicalIslandFromTopologicalIslandEvent event) {
    LOGGER.info("Event sourcing UnAssignAngleRefTopologicalIslandFromTopologicalIslandEvent");
    this.angleRefTopologicalIsland = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID topologicalIslandId;

  private TopologicalIsland topologicalIsland = null;
  private TopologicalIsland angleRefTopologicalIsland = null;

  private static final Logger LOGGER = Logger.getLogger(TopologicalIslandAggregate.class.getName());
}
