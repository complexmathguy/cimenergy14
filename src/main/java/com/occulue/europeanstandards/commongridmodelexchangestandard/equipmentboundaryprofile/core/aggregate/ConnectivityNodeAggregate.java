package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.aggregate;

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
 * Aggregate handler for ConnectivityNode as outlined for the CQRS pattern, all write
 * responsibilities related to ConnectivityNode are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ConnectivityNodeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ConnectivityNodeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ConnectivityNodeAggregate(CreateConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command CreateConnectivityNodeCommand");
    CreateConnectivityNodeEvent event =
        new CreateConnectivityNodeEvent(command.getConnectivityNodeId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateConnectivityNodeCommand command) throws Exception {
    LOGGER.info("handling command UpdateConnectivityNodeCommand");
    UpdateConnectivityNodeEvent event =
        new UpdateConnectivityNodeEvent(
            command.getConnectivityNodeId(),
            command.getBoundaryPoint(),
            command.getFromEndIsoCode(),
            command.getFromEndName(),
            command.getFromEndNameTso(),
            command.getToEndIsoCode(),
            command.getToEndName(),
            command.getToEndNameTso(),
            command.getConnectivityNodes());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteConnectivityNodeCommand");
    apply(new DeleteConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBoundaryPointToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignBoundaryPointToConnectivityNodeCommand");

    if (boundaryPoint != null
        && boundaryPoint.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "BoundaryPoint already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignBoundaryPointToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBoundaryPointFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBoundaryPointFromConnectivityNodeCommand");

    if (boundaryPoint == null)
      throw new ProcessingException("BoundaryPoint already has nothing assigned.");

    apply(new UnAssignBoundaryPointFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndIsoCodeToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndIsoCodeToConnectivityNodeCommand");

    if (fromEndIsoCode != null
        && fromEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndIsoCodeToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndIsoCodeFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndIsoCodeFromConnectivityNodeCommand");

    if (fromEndIsoCode == null)
      throw new ProcessingException("FromEndIsoCode already has nothing assigned.");

    apply(new UnAssignFromEndIsoCodeFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameToConnectivityNodeCommand");

    if (fromEndName != null
        && fromEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameFromConnectivityNodeCommand");

    if (fromEndName == null)
      throw new ProcessingException("FromEndName already has nothing assigned.");

    apply(new UnAssignFromEndNameFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameTsoToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameTsoToConnectivityNodeCommand");

    if (fromEndNameTso != null
        && fromEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameTsoToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameTsoFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameTsoFromConnectivityNodeCommand");

    if (fromEndNameTso == null)
      throw new ProcessingException("FromEndNameTso already has nothing assigned.");

    apply(new UnAssignFromEndNameTsoFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndIsoCodeToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndIsoCodeToConnectivityNodeCommand");

    if (toEndIsoCode != null
        && toEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndIsoCodeToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndIsoCodeFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndIsoCodeFromConnectivityNodeCommand");

    if (toEndIsoCode == null)
      throw new ProcessingException("ToEndIsoCode already has nothing assigned.");

    apply(new UnAssignToEndIsoCodeFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameToConnectivityNodeCommand");

    if (toEndName != null
        && toEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameFromConnectivityNodeCommand");

    if (toEndName == null) throw new ProcessingException("ToEndName already has nothing assigned.");

    apply(new UnAssignToEndNameFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameTsoToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameTsoToConnectivityNodeCommand");

    if (toEndNameTso != null
        && toEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameTsoToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameTsoFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameTsoFromConnectivityNodeCommand");

    if (toEndNameTso == null)
      throw new ProcessingException("ToEndNameTso already has nothing assigned.");

    apply(new UnAssignToEndNameTsoFromConnectivityNodeEvent(command.getConnectivityNodeId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignConnectivityNodesToConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command AssignConnectivityNodesToConnectivityNodeCommand");

    if (connectivityNodes.contains(command.getAddTo()))
      throw new ProcessingException(
          "ConnectivityNodes already contains an entity with id "
              + command.getAddTo().getConnectivityNodeId());

    apply(
        new AssignConnectivityNodesToConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveConnectivityNodesFromConnectivityNodeCommand command) throws Exception {
    LOGGER.info("Handling command RemoveConnectivityNodesFromConnectivityNodeCommand");

    if (!connectivityNodes.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "ConnectivityNodes does not contain an entity with id "
              + command.getRemoveFrom().getConnectivityNodeId());

    apply(
        new RemoveConnectivityNodesFromConnectivityNodeEvent(
            command.getConnectivityNodeId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing CreateConnectivityNodeEvent");
    this.connectivityNodeId = event.getConnectivityNodeId();
  }

  @EventSourcingHandler
  void on(UpdateConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.boundaryPoint = event.getBoundaryPoint();
    this.fromEndIsoCode = event.getFromEndIsoCode();
    this.fromEndName = event.getFromEndName();
    this.fromEndNameTso = event.getFromEndNameTso();
    this.toEndIsoCode = event.getToEndIsoCode();
    this.toEndName = event.getToEndName();
    this.toEndNameTso = event.getToEndNameTso();
    this.connectivityNodes = event.getConnectivityNodes();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBoundaryPointToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignBoundaryPointToConnectivityNodeEvent");
    this.boundaryPoint = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBoundaryPointFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignBoundaryPointFromConnectivityNodeEvent");
    this.boundaryPoint = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndIsoCodeToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndIsoCodeToConnectivityNodeEvent");
    this.fromEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndIsoCodeFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndIsoCodeFromConnectivityNodeEvent");
    this.fromEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameToConnectivityNodeEvent");
    this.fromEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameFromConnectivityNodeEvent");
    this.fromEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameTsoToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameTsoToConnectivityNodeEvent");
    this.fromEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameTsoFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameTsoFromConnectivityNodeEvent");
    this.fromEndNameTso = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndIsoCodeToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndIsoCodeToConnectivityNodeEvent");
    this.toEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndIsoCodeFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndIsoCodeFromConnectivityNodeEvent");
    this.toEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameToConnectivityNodeEvent");
    this.toEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameFromConnectivityNodeEvent");
    this.toEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameTsoToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameTsoToConnectivityNodeEvent");
    this.toEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameTsoFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameTsoFromConnectivityNodeEvent");
    this.toEndNameTso = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignConnectivityNodesToConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing AssignConnectivityNodesToConnectivityNodeEvent");
    this.connectivityNodes.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveConnectivityNodesFromConnectivityNodeEvent event) {
    LOGGER.info("Event sourcing RemoveConnectivityNodesFromConnectivityNodeEvent");
    this.connectivityNodes.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID connectivityNodeId;

  private BooleanProxy boundaryPoint = null;
  private StringProxy fromEndIsoCode = null;
  private StringProxy fromEndName = null;
  private StringProxy fromEndNameTso = null;
  private StringProxy toEndIsoCode = null;
  private StringProxy toEndName = null;
  private StringProxy toEndNameTso = null;
  private Set<ConnectivityNode> connectivityNodes = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeAggregate.class.getName());
}
