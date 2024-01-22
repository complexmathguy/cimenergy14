package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.aggregate;

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
 * Aggregate handler for ApparentPowerLimit as outlined for the CQRS pattern, all write
 * responsibilities related to ApparentPowerLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ApparentPowerLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ApparentPowerLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ApparentPowerLimitAggregate(CreateApparentPowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateApparentPowerLimitCommand");
    CreateApparentPowerLimitEvent event =
        new CreateApparentPowerLimitEvent(command.getApparentPowerLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateApparentPowerLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateApparentPowerLimitCommand");
    UpdateApparentPowerLimitEvent event =
        new UpdateApparentPowerLimitEvent(command.getApparentPowerLimitId(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteApparentPowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteApparentPowerLimitCommand");
    apply(new DeleteApparentPowerLimitEvent(command.getApparentPowerLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToApparentPowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToApparentPowerLimitCommand");

    if (value != null && value.getApparentPowerId() == command.getAssignment().getApparentPowerId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getApparentPowerId());

    apply(
        new AssignValueToApparentPowerLimitEvent(
            command.getApparentPowerLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromApparentPowerLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromApparentPowerLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromApparentPowerLimitEvent(command.getApparentPowerLimitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateApparentPowerLimitEvent event) {
    LOGGER.info("Event sourcing CreateApparentPowerLimitEvent");
    this.apparentPowerLimitId = event.getApparentPowerLimitId();
  }

  @EventSourcingHandler
  void on(UpdateApparentPowerLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToApparentPowerLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToApparentPowerLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromApparentPowerLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromApparentPowerLimitEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID apparentPowerLimitId;

  private ApparentPower value = null;

  private static final Logger LOGGER =
      Logger.getLogger(ApparentPowerLimitAggregate.class.getName());
}
