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
 * Aggregate handler for Money as outlined for the CQRS pattern, all write responsibilities related
 * to Money are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MoneyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MoneyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MoneyAggregate(CreateMoneyCommand command) throws Exception {
    LOGGER.info("Handling command CreateMoneyCommand");
    CreateMoneyEvent event =
        new CreateMoneyEvent(command.getMoneyId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMoneyCommand command) throws Exception {
    LOGGER.info("handling command UpdateMoneyCommand");
    UpdateMoneyEvent event =
        new UpdateMoneyEvent(
            command.getMoneyId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMoneyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMoneyCommand");
    apply(new DeleteMoneyEvent(command.getMoneyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToMoneyCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToMoneyCommand");

    if (value != null && value.getDecimalProxyId() == command.getAssignment().getDecimalProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getDecimalProxyId());

    apply(new AssignValueToMoneyEvent(command.getMoneyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromMoneyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromMoneyCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromMoneyEvent(command.getMoneyId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMoneyEvent event) {
    LOGGER.info("Event sourcing CreateMoneyEvent");
    this.moneyId = event.getMoneyId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateMoneyEvent event) {
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
  void on(AssignValueToMoneyEvent event) {
    LOGGER.info("Event sourcing AssignValueToMoneyEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromMoneyEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromMoneyEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID moneyId;

  private UnitMultiplier multiplier;
  private CurrencyEnum unit;
  private DecimalProxy value = null;
  private GeneratingUnit startupCost = null;
  private GeneratingUnit variableCost = null;

  private static final Logger LOGGER = Logger.getLogger(MoneyAggregate.class.getName());
}
