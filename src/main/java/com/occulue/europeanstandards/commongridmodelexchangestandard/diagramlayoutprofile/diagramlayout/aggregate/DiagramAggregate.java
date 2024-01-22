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
 * Aggregate handler for Diagram as outlined for the CQRS pattern, all write responsibilities
 * related to Diagram are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiagramAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiagramAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiagramAggregate(CreateDiagramCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiagramCommand");
    CreateDiagramEvent event =
        new CreateDiagramEvent(command.getDiagramId(), command.getOrientation());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiagramCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiagramCommand");
    UpdateDiagramEvent event =
        new UpdateDiagramEvent(
            command.getDiagramId(),
            command.getOrientation(),
            command.getX1InitialView(),
            command.getX2InitialView(),
            command.getY1InitialView(),
            command.getY2InitialView(),
            command.getDiagram());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiagramCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiagramCommand");
    apply(new DeleteDiagramEvent(command.getDiagramId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignX1InitialViewToDiagramCommand command) throws Exception {
    LOGGER.info("Handling command AssignX1InitialViewToDiagramCommand");

    if (x1InitialView != null
        && x1InitialView.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "X1InitialView already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignX1InitialViewToDiagramEvent(command.getDiagramId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX1InitialViewFromDiagramCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX1InitialViewFromDiagramCommand");

    if (x1InitialView == null)
      throw new ProcessingException("X1InitialView already has nothing assigned.");

    apply(new UnAssignX1InitialViewFromDiagramEvent(command.getDiagramId()));
  }

  @CommandHandler
  public void handle(AssignX2InitialViewToDiagramCommand command) throws Exception {
    LOGGER.info("Handling command AssignX2InitialViewToDiagramCommand");

    if (x2InitialView != null
        && x2InitialView.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "X2InitialView already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignX2InitialViewToDiagramEvent(command.getDiagramId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX2InitialViewFromDiagramCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX2InitialViewFromDiagramCommand");

    if (x2InitialView == null)
      throw new ProcessingException("X2InitialView already has nothing assigned.");

    apply(new UnAssignX2InitialViewFromDiagramEvent(command.getDiagramId()));
  }

  @CommandHandler
  public void handle(AssignY1InitialViewToDiagramCommand command) throws Exception {
    LOGGER.info("Handling command AssignY1InitialViewToDiagramCommand");

    if (y1InitialView != null
        && y1InitialView.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Y1InitialView already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignY1InitialViewToDiagramEvent(command.getDiagramId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignY1InitialViewFromDiagramCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignY1InitialViewFromDiagramCommand");

    if (y1InitialView == null)
      throw new ProcessingException("Y1InitialView already has nothing assigned.");

    apply(new UnAssignY1InitialViewFromDiagramEvent(command.getDiagramId()));
  }

  @CommandHandler
  public void handle(AssignY2InitialViewToDiagramCommand command) throws Exception {
    LOGGER.info("Handling command AssignY2InitialViewToDiagramCommand");

    if (y2InitialView != null
        && y2InitialView.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Y2InitialView already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignY2InitialViewToDiagramEvent(command.getDiagramId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignY2InitialViewFromDiagramCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignY2InitialViewFromDiagramCommand");

    if (y2InitialView == null)
      throw new ProcessingException("Y2InitialView already has nothing assigned.");

    apply(new UnAssignY2InitialViewFromDiagramEvent(command.getDiagramId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignDiagramToDiagramCommand command) throws Exception {
    LOGGER.info("Handling command AssignDiagramToDiagramCommand");

    if (diagram.contains(command.getAddTo()))
      throw new ProcessingException(
          "Diagram already contains an entity with id " + command.getAddTo().getDiagramId());

    apply(new AssignDiagramToDiagramEvent(command.getDiagramId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDiagramFromDiagramCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDiagramFromDiagramCommand");

    if (!diagram.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Diagram does not contain an entity with id " + command.getRemoveFrom().getDiagramId());

    apply(new RemoveDiagramFromDiagramEvent(command.getDiagramId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiagramEvent event) {
    LOGGER.info("Event sourcing CreateDiagramEvent");
    this.diagramId = event.getDiagramId();
    this.orientation = event.getOrientation();
  }

  @EventSourcingHandler
  void on(UpdateDiagramEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.orientation = event.getOrientation();
    this.x1InitialView = event.getX1InitialView();
    this.x2InitialView = event.getX2InitialView();
    this.y1InitialView = event.getY1InitialView();
    this.y2InitialView = event.getY2InitialView();
    this.diagram = event.getDiagram();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignX1InitialViewToDiagramEvent event) {
    LOGGER.info("Event sourcing AssignX1InitialViewToDiagramEvent");
    this.x1InitialView = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX1InitialViewFromDiagramEvent event) {
    LOGGER.info("Event sourcing UnAssignX1InitialViewFromDiagramEvent");
    this.x1InitialView = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX2InitialViewToDiagramEvent event) {
    LOGGER.info("Event sourcing AssignX2InitialViewToDiagramEvent");
    this.x2InitialView = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX2InitialViewFromDiagramEvent event) {
    LOGGER.info("Event sourcing UnAssignX2InitialViewFromDiagramEvent");
    this.x2InitialView = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignY1InitialViewToDiagramEvent event) {
    LOGGER.info("Event sourcing AssignY1InitialViewToDiagramEvent");
    this.y1InitialView = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignY1InitialViewFromDiagramEvent event) {
    LOGGER.info("Event sourcing UnAssignY1InitialViewFromDiagramEvent");
    this.y1InitialView = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignY2InitialViewToDiagramEvent event) {
    LOGGER.info("Event sourcing AssignY2InitialViewToDiagramEvent");
    this.y2InitialView = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignY2InitialViewFromDiagramEvent event) {
    LOGGER.info("Event sourcing UnAssignY2InitialViewFromDiagramEvent");
    this.y2InitialView = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignDiagramToDiagramEvent event) {
    LOGGER.info("Event sourcing AssignDiagramToDiagramEvent");
    this.diagram.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDiagramFromDiagramEvent event) {
    LOGGER.info("Event sourcing RemoveDiagramFromDiagramEvent");
    this.diagram.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID diagramId;

  private OrientationKind orientation;
  private Simple_Float x1InitialView = null;
  private Simple_Float x2InitialView = null;
  private Simple_Float y1InitialView = null;
  private Simple_Float y2InitialView = null;
  private Set<Diagram> diagram = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DiagramAggregate.class.getName());
}
