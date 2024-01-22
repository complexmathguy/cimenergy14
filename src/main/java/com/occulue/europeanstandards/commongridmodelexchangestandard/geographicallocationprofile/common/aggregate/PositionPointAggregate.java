package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.aggregate;

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
 * Aggregate handler for PositionPoint as outlined for the CQRS pattern, all write responsibilities
 * related to PositionPoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PositionPointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PositionPointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PositionPointAggregate(CreatePositionPointCommand command) throws Exception {
    LOGGER.info("Handling command CreatePositionPointCommand");
    CreatePositionPointEvent event = new CreatePositionPointEvent(command.getPositionPointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePositionPointCommand command) throws Exception {
    LOGGER.info("handling command UpdatePositionPointCommand");
    UpdatePositionPointEvent event =
        new UpdatePositionPointEvent(
            command.getPositionPointId(),
            command.getSequenceNumber(),
            command.getXPosition(),
            command.getYPosition(),
            command.getZPosition(),
            command.getPositionPoints());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePositionPointCommand command) throws Exception {
    LOGGER.info("Handling command DeletePositionPointCommand");
    apply(new DeletePositionPointEvent(command.getPositionPointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignSequenceNumberToPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignSequenceNumberToPositionPointCommand");

    if (sequenceNumber != null
        && sequenceNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "SequenceNumber already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignSequenceNumberToPositionPointEvent(
            command.getPositionPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSequenceNumberFromPositionPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSequenceNumberFromPositionPointCommand");

    if (sequenceNumber == null)
      throw new ProcessingException("SequenceNumber already has nothing assigned.");

    apply(new UnAssignSequenceNumberFromPositionPointEvent(command.getPositionPointId()));
  }

  @CommandHandler
  public void handle(AssignXPositionToPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignXPositionToPositionPointCommand");

    if (xPosition != null
        && xPosition.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "XPosition already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignXPositionToPositionPointEvent(
            command.getPositionPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXPositionFromPositionPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXPositionFromPositionPointCommand");

    if (xPosition == null) throw new ProcessingException("XPosition already has nothing assigned.");

    apply(new UnAssignXPositionFromPositionPointEvent(command.getPositionPointId()));
  }

  @CommandHandler
  public void handle(AssignYPositionToPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignYPositionToPositionPointCommand");

    if (yPosition != null
        && yPosition.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "YPosition already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignYPositionToPositionPointEvent(
            command.getPositionPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYPositionFromPositionPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignYPositionFromPositionPointCommand");

    if (yPosition == null) throw new ProcessingException("YPosition already has nothing assigned.");

    apply(new UnAssignYPositionFromPositionPointEvent(command.getPositionPointId()));
  }

  @CommandHandler
  public void handle(AssignZPositionToPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignZPositionToPositionPointCommand");

    if (zPosition != null
        && zPosition.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ZPosition already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignZPositionToPositionPointEvent(
            command.getPositionPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZPositionFromPositionPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZPositionFromPositionPointCommand");

    if (zPosition == null) throw new ProcessingException("ZPosition already has nothing assigned.");

    apply(new UnAssignZPositionFromPositionPointEvent(command.getPositionPointId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignPositionPointsToPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositionPointsToPositionPointCommand");

    if (positionPoints.contains(command.getAddTo()))
      throw new ProcessingException(
          "PositionPoints already contains an entity with id "
              + command.getAddTo().getPositionPointId());

    apply(
        new AssignPositionPointsToPositionPointEvent(
            command.getPositionPointId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemovePositionPointsFromPositionPointCommand command) throws Exception {
    LOGGER.info("Handling command RemovePositionPointsFromPositionPointCommand");

    if (!positionPoints.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "PositionPoints does not contain an entity with id "
              + command.getRemoveFrom().getPositionPointId());

    apply(
        new RemovePositionPointsFromPositionPointEvent(
            command.getPositionPointId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePositionPointEvent event) {
    LOGGER.info("Event sourcing CreatePositionPointEvent");
    this.positionPointId = event.getPositionPointId();
  }

  @EventSourcingHandler
  void on(UpdatePositionPointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.sequenceNumber = event.getSequenceNumber();
    this.xPosition = event.getXPosition();
    this.yPosition = event.getYPosition();
    this.zPosition = event.getZPosition();
    this.positionPoints = event.getPositionPoints();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignSequenceNumberToPositionPointEvent event) {
    LOGGER.info("Event sourcing AssignSequenceNumberToPositionPointEvent");
    this.sequenceNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSequenceNumberFromPositionPointEvent event) {
    LOGGER.info("Event sourcing UnAssignSequenceNumberFromPositionPointEvent");
    this.sequenceNumber = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXPositionToPositionPointEvent event) {
    LOGGER.info("Event sourcing AssignXPositionToPositionPointEvent");
    this.xPosition = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXPositionFromPositionPointEvent event) {
    LOGGER.info("Event sourcing UnAssignXPositionFromPositionPointEvent");
    this.xPosition = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYPositionToPositionPointEvent event) {
    LOGGER.info("Event sourcing AssignYPositionToPositionPointEvent");
    this.yPosition = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYPositionFromPositionPointEvent event) {
    LOGGER.info("Event sourcing UnAssignYPositionFromPositionPointEvent");
    this.yPosition = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZPositionToPositionPointEvent event) {
    LOGGER.info("Event sourcing AssignZPositionToPositionPointEvent");
    this.zPosition = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZPositionFromPositionPointEvent event) {
    LOGGER.info("Event sourcing UnAssignZPositionFromPositionPointEvent");
    this.zPosition = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignPositionPointsToPositionPointEvent event) {
    LOGGER.info("Event sourcing AssignPositionPointsToPositionPointEvent");
    this.positionPoints.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemovePositionPointsFromPositionPointEvent event) {
    LOGGER.info("Event sourcing RemovePositionPointsFromPositionPointEvent");
    this.positionPoints.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID positionPointId;

  private IntegerProxy sequenceNumber = null;
  private StringProxy xPosition = null;
  private StringProxy yPosition = null;
  private StringProxy zPosition = null;
  private Set<PositionPoint> positionPoints = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(PositionPointAggregate.class.getName());
}
