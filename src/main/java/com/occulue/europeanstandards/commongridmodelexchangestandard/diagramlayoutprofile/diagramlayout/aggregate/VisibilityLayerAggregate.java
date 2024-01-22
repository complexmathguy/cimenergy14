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
 * Aggregate handler for VisibilityLayer as outlined for the CQRS pattern, all write
 * responsibilities related to VisibilityLayer are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VisibilityLayerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VisibilityLayerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VisibilityLayerAggregate(CreateVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handling command CreateVisibilityLayerCommand");
    CreateVisibilityLayerEvent event =
        new CreateVisibilityLayerEvent(command.getVisibilityLayerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVisibilityLayerCommand command) throws Exception {
    LOGGER.info("handling command UpdateVisibilityLayerCommand");
    UpdateVisibilityLayerEvent event =
        new UpdateVisibilityLayerEvent(
            command.getVisibilityLayerId(),
            command.getDrawingOrder(),
            command.getVisibilityLayers());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVisibilityLayerCommand");
    apply(new DeleteVisibilityLayerEvent(command.getVisibilityLayerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDrawingOrderToVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handling command AssignDrawingOrderToVisibilityLayerCommand");

    if (drawingOrder != null
        && drawingOrder.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "DrawingOrder already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignDrawingOrderToVisibilityLayerEvent(
            command.getVisibilityLayerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDrawingOrderFromVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDrawingOrderFromVisibilityLayerCommand");

    if (drawingOrder == null)
      throw new ProcessingException("DrawingOrder already has nothing assigned.");

    apply(new UnAssignDrawingOrderFromVisibilityLayerEvent(command.getVisibilityLayerId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignVisibilityLayersToVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVisibilityLayersToVisibilityLayerCommand");

    if (visibilityLayers.contains(command.getAddTo()))
      throw new ProcessingException(
          "VisibilityLayers already contains an entity with id "
              + command.getAddTo().getVisibilityLayerId());

    apply(
        new AssignVisibilityLayersToVisibilityLayerEvent(
            command.getVisibilityLayerId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveVisibilityLayersFromVisibilityLayerCommand command) throws Exception {
    LOGGER.info("Handling command RemoveVisibilityLayersFromVisibilityLayerCommand");

    if (!visibilityLayers.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "VisibilityLayers does not contain an entity with id "
              + command.getRemoveFrom().getVisibilityLayerId());

    apply(
        new RemoveVisibilityLayersFromVisibilityLayerEvent(
            command.getVisibilityLayerId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing CreateVisibilityLayerEvent");
    this.visibilityLayerId = event.getVisibilityLayerId();
  }

  @EventSourcingHandler
  void on(UpdateVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.drawingOrder = event.getDrawingOrder();
    this.visibilityLayers = event.getVisibilityLayers();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDrawingOrderToVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing AssignDrawingOrderToVisibilityLayerEvent");
    this.drawingOrder = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDrawingOrderFromVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing UnAssignDrawingOrderFromVisibilityLayerEvent");
    this.drawingOrder = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignVisibilityLayersToVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing AssignVisibilityLayersToVisibilityLayerEvent");
    this.visibilityLayers.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveVisibilityLayersFromVisibilityLayerEvent event) {
    LOGGER.info("Event sourcing RemoveVisibilityLayersFromVisibilityLayerEvent");
    this.visibilityLayers.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID visibilityLayerId;

  private IntegerProxy drawingOrder = null;
  private Set<VisibilityLayer> visibilityLayers = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(VisibilityLayerAggregate.class.getName());
}
