package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc.aggregate;

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
 * Aggregate handler for DCTopologicalNode as outlined for the CQRS pattern, all write
 * responsibilities related to DCTopologicalNode are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCTopologicalNodeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCTopologicalNodeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCTopologicalNodeAggregate(CreateDCTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCTopologicalNodeCommand");
    CreateDCTopologicalNodeEvent event =
        new CreateDCTopologicalNodeEvent(command.getDCTopologicalNodeId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCTopologicalNodeCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCTopologicalNodeCommand");
    UpdateDCTopologicalNodeEvent event =
        new UpdateDCTopologicalNodeEvent(
            command.getDCTopologicalNodeId(), command.getDCTopologicalNode());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCTopologicalNodeCommand");
    apply(new DeleteDCTopologicalNodeEvent(command.getDCTopologicalNodeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCTopologicalNodeToDCTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCTopologicalNodeToDCTopologicalNodeCommand");

    if (dCTopologicalNode.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCTopologicalNode already contains an entity with id "
              + command.getAddTo().getDCTopologicalNodeId());

    apply(
        new AssignDCTopologicalNodeToDCTopologicalNodeEvent(
            command.getDCTopologicalNodeId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCTopologicalNodeFromDCTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCTopologicalNodeFromDCTopologicalNodeCommand");

    if (!dCTopologicalNode.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCTopologicalNode does not contain an entity with id "
              + command.getRemoveFrom().getDCTopologicalNodeId());

    apply(
        new RemoveDCTopologicalNodeFromDCTopologicalNodeEvent(
            command.getDCTopologicalNodeId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing CreateDCTopologicalNodeEvent");
    this.dCTopologicalNodeId = event.getDCTopologicalNodeId();
  }

  @EventSourcingHandler
  void on(UpdateDCTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCTopologicalNode = event.getDCTopologicalNode();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCTopologicalNodeToDCTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignDCTopologicalNodeToDCTopologicalNodeEvent");
    this.dCTopologicalNode.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCTopologicalNodeFromDCTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing RemoveDCTopologicalNodeFromDCTopologicalNodeEvent");
    this.dCTopologicalNode.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCTopologicalNodeId;

  private Set<DCTopologicalNode> dCTopologicalNode = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCTopologicalNodeAggregate.class.getName());
}
