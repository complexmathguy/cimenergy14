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
 * Aggregate handler for AngleRadians as outlined for the CQRS pattern, all write responsibilities
 * related to AngleRadians are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AngleRadiansAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AngleRadiansAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AngleRadiansAggregate(CreateAngleRadiansCommand command) throws Exception {
    LOGGER.info("Handling command CreateAngleRadiansCommand");
    CreateAngleRadiansEvent event =
        new CreateAngleRadiansEvent(
            command.getAngleRadiansId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAngleRadiansCommand command) throws Exception {
    LOGGER.info("handling command UpdateAngleRadiansCommand");
    UpdateAngleRadiansEvent event =
        new UpdateAngleRadiansEvent(
            command.getAngleRadiansId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAngleRadiansCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAngleRadiansCommand");
    apply(new DeleteAngleRadiansEvent(command.getAngleRadiansId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAngleRadiansCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAngleRadiansCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToAngleRadiansEvent(command.getAngleRadiansId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAngleRadiansCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAngleRadiansCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAngleRadiansEvent(command.getAngleRadiansId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAngleRadiansEvent event) {
    LOGGER.info("Event sourcing CreateAngleRadiansEvent");
    this.angleRadiansId = event.getAngleRadiansId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateAngleRadiansEvent event) {
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
  void on(AssignValueToAngleRadiansEvent event) {
    LOGGER.info("Event sourcing AssignValueToAngleRadiansEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAngleRadiansEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAngleRadiansEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID angleRadiansId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;

  private static final Logger LOGGER = Logger.getLogger(AngleRadiansAggregate.class.getName());
}
