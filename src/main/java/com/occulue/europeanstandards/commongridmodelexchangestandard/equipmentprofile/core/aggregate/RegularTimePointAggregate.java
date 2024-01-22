package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.aggregate;

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
 * Aggregate handler for RegularTimePoint as outlined for the CQRS pattern, all write
 * responsibilities related to RegularTimePoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RegularTimePointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RegularTimePointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RegularTimePointAggregate(CreateRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command CreateRegularTimePointCommand");
    CreateRegularTimePointEvent event =
        new CreateRegularTimePointEvent(command.getRegularTimePointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRegularTimePointCommand command) throws Exception {
    LOGGER.info("handling command UpdateRegularTimePointCommand");
    UpdateRegularTimePointEvent event =
        new UpdateRegularTimePointEvent(
            command.getRegularTimePointId(),
            command.getSequenceNumber(),
            command.getValue1(),
            command.getValue2(),
            command.getTimePoints());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRegularTimePointCommand");
    apply(new DeleteRegularTimePointEvent(command.getRegularTimePointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignSequenceNumberToRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignSequenceNumberToRegularTimePointCommand");

    if (sequenceNumber != null
        && sequenceNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "SequenceNumber already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignSequenceNumberToRegularTimePointEvent(
            command.getRegularTimePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSequenceNumberFromRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSequenceNumberFromRegularTimePointCommand");

    if (sequenceNumber == null)
      throw new ProcessingException("SequenceNumber already has nothing assigned.");

    apply(new UnAssignSequenceNumberFromRegularTimePointEvent(command.getRegularTimePointId()));
  }

  @CommandHandler
  public void handle(AssignValue1ToRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignValue1ToRegularTimePointCommand");

    if (value1 != null && value1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Value1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignValue1ToRegularTimePointEvent(
            command.getRegularTimePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValue1FromRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValue1FromRegularTimePointCommand");

    if (value1 == null) throw new ProcessingException("Value1 already has nothing assigned.");

    apply(new UnAssignValue1FromRegularTimePointEvent(command.getRegularTimePointId()));
  }

  @CommandHandler
  public void handle(AssignValue2ToRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignValue2ToRegularTimePointCommand");

    if (value2 != null && value2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Value2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignValue2ToRegularTimePointEvent(
            command.getRegularTimePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValue2FromRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValue2FromRegularTimePointCommand");

    if (value2 == null) throw new ProcessingException("Value2 already has nothing assigned.");

    apply(new UnAssignValue2FromRegularTimePointEvent(command.getRegularTimePointId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignTimePointsToRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignTimePointsToRegularTimePointCommand");

    if (timePoints.contains(command.getAddTo()))
      throw new ProcessingException(
          "TimePoints already contains an entity with id "
              + command.getAddTo().getRegularTimePointId());

    apply(
        new AssignTimePointsToRegularTimePointEvent(
            command.getRegularTimePointId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTimePointsFromRegularTimePointCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTimePointsFromRegularTimePointCommand");

    if (!timePoints.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TimePoints does not contain an entity with id "
              + command.getRemoveFrom().getRegularTimePointId());

    apply(
        new RemoveTimePointsFromRegularTimePointEvent(
            command.getRegularTimePointId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRegularTimePointEvent event) {
    LOGGER.info("Event sourcing CreateRegularTimePointEvent");
    this.regularTimePointId = event.getRegularTimePointId();
  }

  @EventSourcingHandler
  void on(UpdateRegularTimePointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.sequenceNumber = event.getSequenceNumber();
    this.value1 = event.getValue1();
    this.value2 = event.getValue2();
    this.timePoints = event.getTimePoints();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignSequenceNumberToRegularTimePointEvent event) {
    LOGGER.info("Event sourcing AssignSequenceNumberToRegularTimePointEvent");
    this.sequenceNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSequenceNumberFromRegularTimePointEvent event) {
    LOGGER.info("Event sourcing UnAssignSequenceNumberFromRegularTimePointEvent");
    this.sequenceNumber = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValue1ToRegularTimePointEvent event) {
    LOGGER.info("Event sourcing AssignValue1ToRegularTimePointEvent");
    this.value1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValue1FromRegularTimePointEvent event) {
    LOGGER.info("Event sourcing UnAssignValue1FromRegularTimePointEvent");
    this.value1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValue2ToRegularTimePointEvent event) {
    LOGGER.info("Event sourcing AssignValue2ToRegularTimePointEvent");
    this.value2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValue2FromRegularTimePointEvent event) {
    LOGGER.info("Event sourcing UnAssignValue2FromRegularTimePointEvent");
    this.value2 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignTimePointsToRegularTimePointEvent event) {
    LOGGER.info("Event sourcing AssignTimePointsToRegularTimePointEvent");
    this.timePoints.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTimePointsFromRegularTimePointEvent event) {
    LOGGER.info("Event sourcing RemoveTimePointsFromRegularTimePointEvent");
    this.timePoints.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID regularTimePointId;

  private IntegerProxy sequenceNumber = null;
  private Simple_Float value1 = null;
  private Simple_Float value2 = null;
  private Set<RegularTimePoint> timePoints = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(RegularTimePointAggregate.class.getName());
}
