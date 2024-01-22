package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for MeasurementValueQuality as outlined for the CQRS pattern, all write
 * responsibilities related to MeasurementValueQuality are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MeasurementValueQualityAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MeasurementValueQualityAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MeasurementValueQualityAggregate(CreateMeasurementValueQualityCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateMeasurementValueQualityCommand");
    CreateMeasurementValueQualityEvent event =
        new CreateMeasurementValueQualityEvent(command.getMeasurementValueQualityId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMeasurementValueQualityCommand command) throws Exception {
    LOGGER.info("handling command UpdateMeasurementValueQualityCommand");
    UpdateMeasurementValueQualityEvent event =
        new UpdateMeasurementValueQualityEvent(
            command.getMeasurementValueQualityId(), command.getMeasurementValueQuality());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMeasurementValueQualityCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMeasurementValueQualityCommand");
    apply(new DeleteMeasurementValueQualityEvent(command.getMeasurementValueQualityId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMeasurementValueQualityToMeasurementValueQualityCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMeasurementValueQualityToMeasurementValueQualityCommand");

    if (measurementValueQuality != null
        && measurementValueQuality.getMeasurementValueQualityId()
            == command.getAssignment().getMeasurementValueQualityId())
      throw new ProcessingException(
          "MeasurementValueQuality already assigned with id "
              + command.getAssignment().getMeasurementValueQualityId());

    apply(
        new AssignMeasurementValueQualityToMeasurementValueQualityEvent(
            command.getMeasurementValueQualityId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand");

    if (measurementValueQuality == null)
      throw new ProcessingException("MeasurementValueQuality already has nothing assigned.");

    apply(
        new UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent(
            command.getMeasurementValueQualityId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMeasurementValueQualityEvent event) {
    LOGGER.info("Event sourcing CreateMeasurementValueQualityEvent");
    this.measurementValueQualityId = event.getMeasurementValueQualityId();
  }

  @EventSourcingHandler
  void on(UpdateMeasurementValueQualityEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.measurementValueQuality = event.getMeasurementValueQuality();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMeasurementValueQualityToMeasurementValueQualityEvent event) {
    LOGGER.info("Event sourcing AssignMeasurementValueQualityToMeasurementValueQualityEvent");
    this.measurementValueQuality = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent event) {
    LOGGER.info("Event sourcing UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent");
    this.measurementValueQuality = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID measurementValueQualityId;

  private MeasurementValueQuality measurementValueQuality = null;

  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueQualityAggregate.class.getName());
}
