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
 * Aggregate handler for Area as outlined for the CQRS pattern, all write responsibilities related
 * to Area are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AreaAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AreaAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AreaAggregate(CreateAreaCommand command) throws Exception {
    LOGGER.info("Handling command CreateAreaCommand");
    CreateAreaEvent event =
        new CreateAreaEvent(command.getAreaId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAreaCommand command) throws Exception {
    LOGGER.info("handling command UpdateAreaCommand");
    UpdateAreaEvent event =
        new UpdateAreaEvent(
            command.getAreaId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAreaCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAreaCommand");
    apply(new DeleteAreaEvent(command.getAreaId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAreaCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAreaCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToAreaEvent(command.getAreaId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAreaCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAreaCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAreaEvent(command.getAreaId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAreaEvent event) {
    LOGGER.info("Event sourcing CreateAreaEvent");
    this.areaId = event.getAreaId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateAreaEvent event) {
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
  void on(AssignValueToAreaEvent event) {
    LOGGER.info("Event sourcing AssignValueToAreaEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAreaEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAreaEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID areaId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private GovHydroFrancis av0 = null;
  private GovHydroFrancis av1 = null;

  private static final Logger LOGGER = Logger.getLogger(AreaAggregate.class.getName());
}
