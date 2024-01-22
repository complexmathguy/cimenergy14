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
 * Aggregate handler for DCNode as outlined for the CQRS pattern, all write responsibilities related
 * to DCNode are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCNodeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCNodeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCNodeAggregate(CreateDCNodeCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCNodeCommand");
    CreateDCNodeEvent event = new CreateDCNodeEvent(command.getDCNodeId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCNodeCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCNodeCommand");
    UpdateDCNodeEvent event = new UpdateDCNodeEvent(command.getDCNodeId(), command.getDCNodes());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCNodeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCNodeCommand");
    apply(new DeleteDCNodeEvent(command.getDCNodeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCNodesToDCNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCNodesToDCNodeCommand");

    if (dCNodes.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCNodes already contains an entity with id " + command.getAddTo().getDCNodeId());

    apply(new AssignDCNodesToDCNodeEvent(command.getDCNodeId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCNodesFromDCNodeCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCNodesFromDCNodeCommand");

    if (!dCNodes.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCNodes does not contain an entity with id " + command.getRemoveFrom().getDCNodeId());

    apply(new RemoveDCNodesFromDCNodeEvent(command.getDCNodeId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCNodeEvent event) {
    LOGGER.info("Event sourcing CreateDCNodeEvent");
    this.dCNodeId = event.getDCNodeId();
  }

  @EventSourcingHandler
  void on(UpdateDCNodeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCNodes = event.getDCNodes();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCNodesToDCNodeEvent event) {
    LOGGER.info("Event sourcing AssignDCNodesToDCNodeEvent");
    this.dCNodes.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCNodesFromDCNodeEvent event) {
    LOGGER.info("Event sourcing RemoveDCNodesFromDCNodeEvent");
    this.dCNodes.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCNodeId;

  private Set<DCNode> dCNodes = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCNodeAggregate.class.getName());
}
