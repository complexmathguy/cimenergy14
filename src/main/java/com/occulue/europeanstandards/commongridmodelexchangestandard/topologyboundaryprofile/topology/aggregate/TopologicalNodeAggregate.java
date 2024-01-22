package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.aggregate;

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
 * Aggregate handler for TopologicalNode as outlined for the CQRS pattern, all write
 * responsibilities related to TopologicalNode are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TopologicalNodeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TopologicalNodeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TopologicalNodeAggregate(CreateTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command CreateTopologicalNodeCommand");
    CreateTopologicalNodeEvent event =
        new CreateTopologicalNodeEvent(command.getTopologicalNodeId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTopologicalNodeCommand command) throws Exception {
    LOGGER.info("handling command UpdateTopologicalNodeCommand");
    UpdateTopologicalNodeEvent event =
        new UpdateTopologicalNodeEvent(
            command.getTopologicalNodeId(),
            command.getBoundaryPoint(),
            command.getFromEndIsoCode(),
            command.getFromEndName(),
            command.getFromEndNameTso(),
            command.getToEndIsoCode(),
            command.getToEndName(),
            command.getToEndNameTso(),
            command.getTopologicalNode());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTopologicalNodeCommand");
    apply(new DeleteTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBoundaryPointToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignBoundaryPointToTopologicalNodeCommand");

    if (boundaryPoint != null
        && boundaryPoint.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "BoundaryPoint already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignBoundaryPointToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBoundaryPointFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBoundaryPointFromTopologicalNodeCommand");

    if (boundaryPoint == null)
      throw new ProcessingException("BoundaryPoint already has nothing assigned.");

    apply(new UnAssignBoundaryPointFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndIsoCodeToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndIsoCodeToTopologicalNodeCommand");

    if (fromEndIsoCode != null
        && fromEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndIsoCodeToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndIsoCodeFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndIsoCodeFromTopologicalNodeCommand");

    if (fromEndIsoCode == null)
      throw new ProcessingException("FromEndIsoCode already has nothing assigned.");

    apply(new UnAssignFromEndIsoCodeFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameToTopologicalNodeCommand");

    if (fromEndName != null
        && fromEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameFromTopologicalNodeCommand");

    if (fromEndName == null)
      throw new ProcessingException("FromEndName already has nothing assigned.");

    apply(new UnAssignFromEndNameFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameTsoToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameTsoToTopologicalNodeCommand");

    if (fromEndNameTso != null
        && fromEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameTsoToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameTsoFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameTsoFromTopologicalNodeCommand");

    if (fromEndNameTso == null)
      throw new ProcessingException("FromEndNameTso already has nothing assigned.");

    apply(new UnAssignFromEndNameTsoFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndIsoCodeToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndIsoCodeToTopologicalNodeCommand");

    if (toEndIsoCode != null
        && toEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndIsoCodeToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndIsoCodeFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndIsoCodeFromTopologicalNodeCommand");

    if (toEndIsoCode == null)
      throw new ProcessingException("ToEndIsoCode already has nothing assigned.");

    apply(new UnAssignToEndIsoCodeFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameToTopologicalNodeCommand");

    if (toEndName != null
        && toEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameFromTopologicalNodeCommand");

    if (toEndName == null) throw new ProcessingException("ToEndName already has nothing assigned.");

    apply(new UnAssignToEndNameFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameTsoToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameTsoToTopologicalNodeCommand");

    if (toEndNameTso != null
        && toEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameTsoToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameTsoFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameTsoFromTopologicalNodeCommand");

    if (toEndNameTso == null)
      throw new ProcessingException("ToEndNameTso already has nothing assigned.");

    apply(new UnAssignToEndNameTsoFromTopologicalNodeEvent(command.getTopologicalNodeId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignTopologicalNodeToTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignTopologicalNodeToTopologicalNodeCommand");

    if (topologicalNode.contains(command.getAddTo()))
      throw new ProcessingException(
          "TopologicalNode already contains an entity with id "
              + command.getAddTo().getTopologicalNodeId());

    apply(
        new AssignTopologicalNodeToTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTopologicalNodeFromTopologicalNodeCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTopologicalNodeFromTopologicalNodeCommand");

    if (!topologicalNode.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TopologicalNode does not contain an entity with id "
              + command.getRemoveFrom().getTopologicalNodeId());

    apply(
        new RemoveTopologicalNodeFromTopologicalNodeEvent(
            command.getTopologicalNodeId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing CreateTopologicalNodeEvent");
    this.topologicalNodeId = event.getTopologicalNodeId();
  }

  @EventSourcingHandler
  void on(UpdateTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.boundaryPoint = event.getBoundaryPoint();
    this.fromEndIsoCode = event.getFromEndIsoCode();
    this.fromEndName = event.getFromEndName();
    this.fromEndNameTso = event.getFromEndNameTso();
    this.toEndIsoCode = event.getToEndIsoCode();
    this.toEndName = event.getToEndName();
    this.toEndNameTso = event.getToEndNameTso();
    this.topologicalNode = event.getTopologicalNode();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBoundaryPointToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignBoundaryPointToTopologicalNodeEvent");
    this.boundaryPoint = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBoundaryPointFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignBoundaryPointFromTopologicalNodeEvent");
    this.boundaryPoint = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndIsoCodeToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndIsoCodeToTopologicalNodeEvent");
    this.fromEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndIsoCodeFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndIsoCodeFromTopologicalNodeEvent");
    this.fromEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameToTopologicalNodeEvent");
    this.fromEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameFromTopologicalNodeEvent");
    this.fromEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameTsoToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameTsoToTopologicalNodeEvent");
    this.fromEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameTsoFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameTsoFromTopologicalNodeEvent");
    this.fromEndNameTso = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndIsoCodeToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndIsoCodeToTopologicalNodeEvent");
    this.toEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndIsoCodeFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndIsoCodeFromTopologicalNodeEvent");
    this.toEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameToTopologicalNodeEvent");
    this.toEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameFromTopologicalNodeEvent");
    this.toEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameTsoToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameTsoToTopologicalNodeEvent");
    this.toEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameTsoFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameTsoFromTopologicalNodeEvent");
    this.toEndNameTso = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignTopologicalNodeToTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing AssignTopologicalNodeToTopologicalNodeEvent");
    this.topologicalNode.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTopologicalNodeFromTopologicalNodeEvent event) {
    LOGGER.info("Event sourcing RemoveTopologicalNodeFromTopologicalNodeEvent");
    this.topologicalNode.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID topologicalNodeId;

  private BooleanProxy boundaryPoint = null;
  private StringProxy fromEndIsoCode = null;
  private StringProxy fromEndName = null;
  private StringProxy fromEndNameTso = null;
  private StringProxy toEndIsoCode = null;
  private StringProxy toEndName = null;
  private StringProxy toEndNameTso = null;
  private Set<TopologicalNode> topologicalNode = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(TopologicalNodeAggregate.class.getName());
}
