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
 * Aggregate handler for ApparentPower as outlined for the CQRS pattern, all write responsibilities
 * related to ApparentPower are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ApparentPowerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ApparentPowerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ApparentPowerAggregate(CreateApparentPowerCommand command) throws Exception {
    LOGGER.info("Handling command CreateApparentPowerCommand");
    CreateApparentPowerEvent event =
        new CreateApparentPowerEvent(
            command.getApparentPowerId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateApparentPowerCommand command) throws Exception {
    LOGGER.info("handling command UpdateApparentPowerCommand");
    UpdateApparentPowerEvent event =
        new UpdateApparentPowerEvent(
            command.getApparentPowerId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteApparentPowerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteApparentPowerCommand");
    apply(new DeleteApparentPowerEvent(command.getApparentPowerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToApparentPowerCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToApparentPowerCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToApparentPowerEvent(command.getApparentPowerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromApparentPowerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromApparentPowerCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromApparentPowerEvent(command.getApparentPowerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateApparentPowerEvent event) {
    LOGGER.info("Event sourcing CreateApparentPowerEvent");
    this.apparentPowerId = event.getApparentPowerId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateApparentPowerEvent event) {
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
  void on(AssignValueToApparentPowerEvent event) {
    LOGGER.info("Event sourcing AssignValueToApparentPowerEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromApparentPowerEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromApparentPowerEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID apparentPowerId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACDCConverter baseS = null;
  private PowerTransformerEnd ratedS = null;
  private ExcSK sbase = null;

  private static final Logger LOGGER = Logger.getLogger(ApparentPowerAggregate.class.getName());
}
