package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for PerCent as outlined for the CQRS pattern, all write responsibilities
 * related to PerCent are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PerCentAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PerCentAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PerCentAggregate(CreatePerCentCommand command) throws Exception {
    LOGGER.info("Handling command CreatePerCentCommand");
    CreatePerCentEvent event =
        new CreatePerCentEvent(command.getPerCentId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePerCentCommand command) throws Exception {
    LOGGER.info("handling command UpdatePerCentCommand");
    UpdatePerCentEvent event =
        new UpdatePerCentEvent(
            command.getPerCentId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePerCentCommand command) throws Exception {
    LOGGER.info("Handling command DeletePerCentCommand");
    apply(new DeletePerCentEvent(command.getPerCentId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToPerCentCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToPerCentCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToPerCentEvent(command.getPerCentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromPerCentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromPerCentCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromPerCentEvent(command.getPerCentId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePerCentEvent event) {
    LOGGER.info("Event sourcing CreatePerCentEvent");
    this.perCentId = event.getPerCentId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdatePerCentEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToPerCentEvent event) {
    LOGGER.info("Event sourcing AssignValueToPerCentEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromPerCentEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromPerCentEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID perCentId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private MeasurementValue sensorAccuracy = null;
  private GeneratingUnit governorSCD = null;
  private GeneratingUnit totalEfficiency = null;
  private AsynchronousMachine efficiency = null;
  private EnergyConsumer pfixedPct = null;
  private EnergyConsumer qfixedPct = null;
  private PhaseTapChangerNonLinear voltageStepIncrement = null;
  private RatioTapChanger stepVoltageIncrement = null;
  private SynchronousMachine qPercent = null;
  private SynchronousMachine voltageRegulationRange = null;
  private TapChangerTablePoint b = null;
  private TapChangerTablePoint g = null;
  private TapChangerTablePoint r = null;
  private TapChangerTablePoint x = null;

  private static final Logger LOGGER = Logger.getLogger(PerCentAggregate.class.getName());
}
