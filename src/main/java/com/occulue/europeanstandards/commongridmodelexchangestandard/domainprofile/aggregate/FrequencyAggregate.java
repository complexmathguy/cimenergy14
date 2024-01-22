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
 * Aggregate handler for Frequency as outlined for the CQRS pattern, all write responsibilities
 * related to Frequency are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class FrequencyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public FrequencyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public FrequencyAggregate(CreateFrequencyCommand command) throws Exception {
    LOGGER.info("Handling command CreateFrequencyCommand");
    CreateFrequencyEvent event =
        new CreateFrequencyEvent(
            command.getFrequencyId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateFrequencyCommand command) throws Exception {
    LOGGER.info("handling command UpdateFrequencyCommand");
    UpdateFrequencyEvent event =
        new UpdateFrequencyEvent(
            command.getFrequencyId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteFrequencyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteFrequencyCommand");
    apply(new DeleteFrequencyEvent(command.getFrequencyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToFrequencyCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToFrequencyCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToFrequencyEvent(command.getFrequencyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromFrequencyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromFrequencyCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromFrequencyEvent(command.getFrequencyId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateFrequencyEvent event) {
    LOGGER.info("Event sourcing CreateFrequencyEvent");
    this.frequencyId = event.getFrequencyId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateFrequencyEvent event) {
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
  void on(AssignValueToFrequencyEvent event) {
    LOGGER.info("Event sourcing AssignValueToFrequencyEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromFrequencyEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromFrequencyEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID frequencyId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private AsynchronousMachine nominalFrequency = null;
  private GovCT2 flim1 = null;
  private GovCT2 flim10 = null;
  private GovCT2 flim2 = null;
  private GovCT2 flim3 = null;
  private GovCT2 flim4 = null;
  private GovCT2 flim5 = null;
  private GovCT2 flim6 = null;
  private GovCT2 flim7 = null;
  private GovCT2 flim8 = null;
  private GovCT2 flim9 = null;
  private GovGAST1 db1 = null;
  private GovGAST1 eps = null;
  private GovHydroPelton db2 = null;

  private static final Logger LOGGER = Logger.getLogger(FrequencyAggregate.class.getName());
}
