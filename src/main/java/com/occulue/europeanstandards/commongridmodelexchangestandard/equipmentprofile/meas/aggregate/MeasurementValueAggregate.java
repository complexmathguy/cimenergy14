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
 * Aggregate handler for MeasurementValue as outlined for the CQRS pattern, all write
 * responsibilities related to MeasurementValue are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MeasurementValueAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MeasurementValueAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MeasurementValueAggregate(CreateMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command CreateMeasurementValueCommand");
    CreateMeasurementValueEvent event =
        new CreateMeasurementValueEvent(command.getMeasurementValueId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMeasurementValueCommand command) throws Exception {
    LOGGER.info("handling command UpdateMeasurementValueCommand");
    UpdateMeasurementValueEvent event =
        new UpdateMeasurementValueEvent(
            command.getMeasurementValueId(),
            command.getSensorAccuracy(),
            command.getTimeStamp(),
            command.getMeasurementValues());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMeasurementValueCommand");
    apply(new DeleteMeasurementValueEvent(command.getMeasurementValueId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignSensorAccuracyToMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignSensorAccuracyToMeasurementValueCommand");

    if (sensorAccuracy != null
        && sensorAccuracy.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "SensorAccuracy already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignSensorAccuracyToMeasurementValueEvent(
            command.getMeasurementValueId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSensorAccuracyFromMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSensorAccuracyFromMeasurementValueCommand");

    if (sensorAccuracy == null)
      throw new ProcessingException("SensorAccuracy already has nothing assigned.");

    apply(new UnAssignSensorAccuracyFromMeasurementValueEvent(command.getMeasurementValueId()));
  }

  @CommandHandler
  public void handle(AssignTimeStampToMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignTimeStampToMeasurementValueCommand");

    if (timeStamp != null && timeStamp.getDateTimeId() == command.getAssignment().getDateTimeId())
      throw new ProcessingException(
          "TimeStamp already assigned with id " + command.getAssignment().getDateTimeId());

    apply(
        new AssignTimeStampToMeasurementValueEvent(
            command.getMeasurementValueId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTimeStampFromMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTimeStampFromMeasurementValueCommand");

    if (timeStamp == null) throw new ProcessingException("TimeStamp already has nothing assigned.");

    apply(new UnAssignTimeStampFromMeasurementValueEvent(command.getMeasurementValueId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignMeasurementValuesToMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignMeasurementValuesToMeasurementValueCommand");

    if (measurementValues.contains(command.getAddTo()))
      throw new ProcessingException(
          "MeasurementValues already contains an entity with id "
              + command.getAddTo().getMeasurementValueId());

    apply(
        new AssignMeasurementValuesToMeasurementValueEvent(
            command.getMeasurementValueId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveMeasurementValuesFromMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command RemoveMeasurementValuesFromMeasurementValueCommand");

    if (!measurementValues.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "MeasurementValues does not contain an entity with id "
              + command.getRemoveFrom().getMeasurementValueId());

    apply(
        new RemoveMeasurementValuesFromMeasurementValueEvent(
            command.getMeasurementValueId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMeasurementValueEvent event) {
    LOGGER.info("Event sourcing CreateMeasurementValueEvent");
    this.measurementValueId = event.getMeasurementValueId();
  }

  @EventSourcingHandler
  void on(UpdateMeasurementValueEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.sensorAccuracy = event.getSensorAccuracy();
    this.timeStamp = event.getTimeStamp();
    this.measurementValues = event.getMeasurementValues();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignSensorAccuracyToMeasurementValueEvent event) {
    LOGGER.info("Event sourcing AssignSensorAccuracyToMeasurementValueEvent");
    this.sensorAccuracy = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSensorAccuracyFromMeasurementValueEvent event) {
    LOGGER.info("Event sourcing UnAssignSensorAccuracyFromMeasurementValueEvent");
    this.sensorAccuracy = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTimeStampToMeasurementValueEvent event) {
    LOGGER.info("Event sourcing AssignTimeStampToMeasurementValueEvent");
    this.timeStamp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTimeStampFromMeasurementValueEvent event) {
    LOGGER.info("Event sourcing UnAssignTimeStampFromMeasurementValueEvent");
    this.timeStamp = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignMeasurementValuesToMeasurementValueEvent event) {
    LOGGER.info("Event sourcing AssignMeasurementValuesToMeasurementValueEvent");
    this.measurementValues.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveMeasurementValuesFromMeasurementValueEvent event) {
    LOGGER.info("Event sourcing RemoveMeasurementValuesFromMeasurementValueEvent");
    this.measurementValues.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID measurementValueId;

  private PerCent sensorAccuracy = null;
  private DateTime timeStamp = null;
  private Set<MeasurementValue> measurementValues = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(MeasurementValueAggregate.class.getName());
}
