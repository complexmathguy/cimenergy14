package com.occulue.europeanstandards.extension.aggregate;

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
 * Aggregate handler for BoundaryExtensions as outlined for the CQRS pattern, all write
 * responsibilities related to BoundaryExtensions are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BoundaryExtensionsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BoundaryExtensionsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BoundaryExtensionsAggregate(CreateBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command CreateBoundaryExtensionsCommand");
    CreateBoundaryExtensionsEvent event =
        new CreateBoundaryExtensionsEvent(command.getBoundaryExtensionsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("handling command UpdateBoundaryExtensionsCommand");
    UpdateBoundaryExtensionsEvent event =
        new UpdateBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(),
            command.getBoundaryPoint(),
            command.getFromEndIsoCode(),
            command.getFromEndName(),
            command.getFromEndNameTso(),
            command.getToEndIsoCode(),
            command.getToEndName(),
            command.getToEndNameTso());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBoundaryExtensionsCommand");
    apply(new DeleteBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBoundaryPointToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignBoundaryPointToBoundaryExtensionsCommand");

    if (boundaryPoint != null
        && boundaryPoint.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "BoundaryPoint already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignBoundaryPointToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBoundaryPointFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBoundaryPointFromBoundaryExtensionsCommand");

    if (boundaryPoint == null)
      throw new ProcessingException("BoundaryPoint already has nothing assigned.");

    apply(new UnAssignBoundaryPointFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignFromEndIsoCodeToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndIsoCodeToBoundaryExtensionsCommand");

    if (fromEndIsoCode != null
        && fromEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndIsoCodeToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand");

    if (fromEndIsoCode == null)
      throw new ProcessingException("FromEndIsoCode already has nothing assigned.");

    apply(new UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameToBoundaryExtensionsCommand");

    if (fromEndName != null
        && fromEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameFromBoundaryExtensionsCommand");

    if (fromEndName == null)
      throw new ProcessingException("FromEndName already has nothing assigned.");

    apply(new UnAssignFromEndNameFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignFromEndNameTsoToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignFromEndNameTsoToBoundaryExtensionsCommand");

    if (fromEndNameTso != null
        && fromEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "FromEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignFromEndNameTsoToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFromEndNameTsoFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFromEndNameTsoFromBoundaryExtensionsCommand");

    if (fromEndNameTso == null)
      throw new ProcessingException("FromEndNameTso already has nothing assigned.");

    apply(new UnAssignFromEndNameTsoFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignToEndIsoCodeToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndIsoCodeToBoundaryExtensionsCommand");

    if (toEndIsoCode != null
        && toEndIsoCode.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndIsoCode already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndIsoCodeToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndIsoCodeFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndIsoCodeFromBoundaryExtensionsCommand");

    if (toEndIsoCode == null)
      throw new ProcessingException("ToEndIsoCode already has nothing assigned.");

    apply(new UnAssignToEndIsoCodeFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameToBoundaryExtensionsCommand");

    if (toEndName != null
        && toEndName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameFromBoundaryExtensionsCommand");

    if (toEndName == null) throw new ProcessingException("ToEndName already has nothing assigned.");

    apply(new UnAssignToEndNameFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  @CommandHandler
  public void handle(AssignToEndNameTsoToBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignToEndNameTsoToBoundaryExtensionsCommand");

    if (toEndNameTso != null
        && toEndNameTso.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ToEndNameTso already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignToEndNameTsoToBoundaryExtensionsEvent(
            command.getBoundaryExtensionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToEndNameTsoFromBoundaryExtensionsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToEndNameTsoFromBoundaryExtensionsCommand");

    if (toEndNameTso == null)
      throw new ProcessingException("ToEndNameTso already has nothing assigned.");

    apply(new UnAssignToEndNameTsoFromBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing CreateBoundaryExtensionsEvent");
    this.boundaryExtensionsId = event.getBoundaryExtensionsId();
  }

  @EventSourcingHandler
  void on(UpdateBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.boundaryPoint = event.getBoundaryPoint();
    this.fromEndIsoCode = event.getFromEndIsoCode();
    this.fromEndName = event.getFromEndName();
    this.fromEndNameTso = event.getFromEndNameTso();
    this.toEndIsoCode = event.getToEndIsoCode();
    this.toEndName = event.getToEndName();
    this.toEndNameTso = event.getToEndNameTso();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBoundaryPointToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignBoundaryPointToBoundaryExtensionsEvent");
    this.boundaryPoint = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBoundaryPointFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignBoundaryPointFromBoundaryExtensionsEvent");
    this.boundaryPoint = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndIsoCodeToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignFromEndIsoCodeToBoundaryExtensionsEvent");
    this.fromEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent");
    this.fromEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameToBoundaryExtensionsEvent");
    this.fromEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameFromBoundaryExtensionsEvent");
    this.fromEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFromEndNameTsoToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignFromEndNameTsoToBoundaryExtensionsEvent");
    this.fromEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFromEndNameTsoFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignFromEndNameTsoFromBoundaryExtensionsEvent");
    this.fromEndNameTso = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndIsoCodeToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignToEndIsoCodeToBoundaryExtensionsEvent");
    this.toEndIsoCode = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndIsoCodeFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndIsoCodeFromBoundaryExtensionsEvent");
    this.toEndIsoCode = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameToBoundaryExtensionsEvent");
    this.toEndName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameFromBoundaryExtensionsEvent");
    this.toEndName = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToEndNameTsoToBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing AssignToEndNameTsoToBoundaryExtensionsEvent");
    this.toEndNameTso = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToEndNameTsoFromBoundaryExtensionsEvent event) {
    LOGGER.info("Event sourcing UnAssignToEndNameTsoFromBoundaryExtensionsEvent");
    this.toEndNameTso = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID boundaryExtensionsId;

  private BooleanProxy boundaryPoint = null;
  private StringProxy fromEndIsoCode = null;
  private StringProxy fromEndName = null;
  private StringProxy fromEndNameTso = null;
  private StringProxy toEndIsoCode = null;
  private StringProxy toEndName = null;
  private StringProxy toEndNameTso = null;

  private static final Logger LOGGER =
      Logger.getLogger(BoundaryExtensionsAggregate.class.getName());
}
