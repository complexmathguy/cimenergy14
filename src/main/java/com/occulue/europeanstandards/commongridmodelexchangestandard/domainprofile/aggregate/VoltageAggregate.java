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
 * Aggregate handler for Voltage as outlined for the CQRS pattern, all write responsibilities
 * related to Voltage are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageAggregate(CreateVoltageCommand command) throws Exception {
    LOGGER.info("Handling command CreateVoltageCommand");
    CreateVoltageEvent event =
        new CreateVoltageEvent(command.getVoltageId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageCommand");
    UpdateVoltageEvent event =
        new UpdateVoltageEvent(
            command.getVoltageId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageCommand");
    apply(new DeleteVoltageEvent(command.getVoltageId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToVoltageCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToVoltageCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToVoltageEvent(command.getVoltageId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromVoltageCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromVoltageCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromVoltageEvent(command.getVoltageId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageEvent event) {
    LOGGER.info("Event sourcing CreateVoltageEvent");
    this.voltageId = event.getVoltageId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateVoltageEvent event) {
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
  void on(AssignValueToVoltageEvent event) {
    LOGGER.info("Event sourcing AssignValueToVoltageEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromVoltageEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromVoltageEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private BaseVoltage nominalVoltage = null;
  private ACDCConverter maxUdc = null;
  private ACDCConverter minUdc = null;
  private ACDCConverter ratedUdc = null;
  private ACDCConverter valveU0 = null;
  private VoltageLevel highVoltageLimit = null;
  private VoltageLevel lowVoltageLimit = null;
  private PetersenCoil nominalU = null;
  private PowerTransformer beforeShCircuitHighestOperatingVoltage = null;
  private PowerTransformer highSideMinOperatingU = null;
  private PowerTransformerEnd ratedU = null;
  private SeriesCompensator varistorVoltageThreshold = null;
  private ShuntCompensator nomU = null;
  private StaticVarCompensator voltageSetPoint = null;
  private TapChanger neutralU = null;
  private SvVoltage v = null;

  private static final Logger LOGGER = Logger.getLogger(VoltageAggregate.class.getName());
}
