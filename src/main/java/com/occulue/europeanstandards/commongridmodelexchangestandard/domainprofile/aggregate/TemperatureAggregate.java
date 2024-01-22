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
 * Aggregate handler for Temperature as outlined for the CQRS pattern, all write responsibilities
 * related to Temperature are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TemperatureAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TemperatureAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TemperatureAggregate(CreateTemperatureCommand command) throws Exception {
    LOGGER.info("Handling command CreateTemperatureCommand");
    CreateTemperatureEvent event =
        new CreateTemperatureEvent(
            command.getTemperatureId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTemperatureCommand command) throws Exception {
    LOGGER.info("handling command UpdateTemperatureCommand");
    UpdateTemperatureEvent event =
        new UpdateTemperatureEvent(
            command.getTemperatureId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTemperatureCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTemperatureCommand");
    apply(new DeleteTemperatureEvent(command.getTemperatureId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToTemperatureCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToTemperatureCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToTemperatureEvent(command.getTemperatureId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromTemperatureCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromTemperatureCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromTemperatureEvent(command.getTemperatureId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTemperatureEvent event) {
    LOGGER.info("Event sourcing CreateTemperatureEvent");
    this.temperatureId = event.getTemperatureId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateTemperatureEvent event) {
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
  void on(AssignValueToTemperatureEvent event) {
    LOGGER.info("Event sourcing AssignValueToTemperatureEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromTemperatureEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromTemperatureEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID temperatureId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACLineSegment shortCircuitEndTemperature = null;
  private GovGAST2 tc = null;
  private GovGAST2 tr = null;
  private GovGAST3 dtc = null;
  private GovGAST3 tfen = null;
  private GovGAST3 tt = null;

  private static final Logger LOGGER = Logger.getLogger(TemperatureAggregate.class.getName());
}
