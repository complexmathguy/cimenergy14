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
 * Aggregate handler for Measurement as outlined for the CQRS pattern, all write responsibilities
 * related to Measurement are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MeasurementAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MeasurementAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MeasurementAggregate(CreateMeasurementCommand command) throws Exception {
    LOGGER.info("Handling command CreateMeasurementCommand");
    CreateMeasurementEvent event =
        new CreateMeasurementEvent(
            command.getMeasurementId(),
            command.getPhases(),
            command.getUnitMultiplier(),
            command.getUnitSymbol());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMeasurementCommand command) throws Exception {
    LOGGER.info("handling command UpdateMeasurementCommand");
    UpdateMeasurementEvent event =
        new UpdateMeasurementEvent(
            command.getMeasurementId(),
            command.getMeasurementType(),
            command.getPhases(),
            command.getUnitMultiplier(),
            command.getUnitSymbol(),
            command.getMeasurements());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMeasurementCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMeasurementCommand");
    apply(new DeleteMeasurementEvent(command.getMeasurementId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMeasurementTypeToMeasurementCommand command) throws Exception {
    LOGGER.info("Handling command AssignMeasurementTypeToMeasurementCommand");

    if (measurementType != null
        && measurementType.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "MeasurementType already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignMeasurementTypeToMeasurementEvent(
            command.getMeasurementId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMeasurementTypeFromMeasurementCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMeasurementTypeFromMeasurementCommand");

    if (measurementType == null)
      throw new ProcessingException("MeasurementType already has nothing assigned.");

    apply(new UnAssignMeasurementTypeFromMeasurementEvent(command.getMeasurementId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignMeasurementsToMeasurementCommand command) throws Exception {
    LOGGER.info("Handling command AssignMeasurementsToMeasurementCommand");

    if (measurements.contains(command.getAddTo()))
      throw new ProcessingException(
          "Measurements already contains an entity with id "
              + command.getAddTo().getMeasurementId());

    apply(new AssignMeasurementsToMeasurementEvent(command.getMeasurementId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveMeasurementsFromMeasurementCommand command) throws Exception {
    LOGGER.info("Handling command RemoveMeasurementsFromMeasurementCommand");

    if (!measurements.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Measurements does not contain an entity with id "
              + command.getRemoveFrom().getMeasurementId());

    apply(
        new RemoveMeasurementsFromMeasurementEvent(
            command.getMeasurementId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMeasurementEvent event) {
    LOGGER.info("Event sourcing CreateMeasurementEvent");
    this.measurementId = event.getMeasurementId();
    this.phases = event.getPhases();
    this.unitMultiplier = event.getUnitMultiplier();
    this.unitSymbol = event.getUnitSymbol();
  }

  @EventSourcingHandler
  void on(UpdateMeasurementEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.measurementType = event.getMeasurementType();
    this.phases = event.getPhases();
    this.unitMultiplier = event.getUnitMultiplier();
    this.unitSymbol = event.getUnitSymbol();
    this.measurements = event.getMeasurements();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMeasurementTypeToMeasurementEvent event) {
    LOGGER.info("Event sourcing AssignMeasurementTypeToMeasurementEvent");
    this.measurementType = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMeasurementTypeFromMeasurementEvent event) {
    LOGGER.info("Event sourcing UnAssignMeasurementTypeFromMeasurementEvent");
    this.measurementType = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignMeasurementsToMeasurementEvent event) {
    LOGGER.info("Event sourcing AssignMeasurementsToMeasurementEvent");
    this.measurements.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveMeasurementsFromMeasurementEvent event) {
    LOGGER.info("Event sourcing RemoveMeasurementsFromMeasurementEvent");
    this.measurements.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID measurementId;

  private PhaseCode phases;
  private UnitMultiplier unitMultiplier;
  private UnitSymbol unitSymbol;
  private StringProxy measurementType = null;
  private Set<Measurement> measurements = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(MeasurementAggregate.class.getName());
}
