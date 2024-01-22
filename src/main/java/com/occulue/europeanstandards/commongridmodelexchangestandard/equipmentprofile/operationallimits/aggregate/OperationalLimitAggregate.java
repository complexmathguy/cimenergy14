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
 * Aggregate handler for OperationalLimit as outlined for the CQRS pattern, all write
 * responsibilities related to OperationalLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OperationalLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OperationalLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OperationalLimitAggregate(CreateOperationalLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateOperationalLimitCommand");
    CreateOperationalLimitEvent event =
        new CreateOperationalLimitEvent(command.getOperationalLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOperationalLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateOperationalLimitCommand");
    UpdateOperationalLimitEvent event =
        new UpdateOperationalLimitEvent(
            command.getOperationalLimitId(),
            command.getOperationalLimit(),
            command.getOperationalLimitValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOperationalLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteOperationalLimitCommand");
    apply(new DeleteOperationalLimitEvent(command.getOperationalLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignOperationalLimitToOperationalLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignOperationalLimitToOperationalLimitCommand");

    if (operationalLimit.contains(command.getAddTo()))
      throw new ProcessingException(
          "OperationalLimit already contains an entity with id "
              + command.getAddTo().getOperationalLimitId());

    apply(
        new AssignOperationalLimitToOperationalLimitEvent(
            command.getOperationalLimitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveOperationalLimitFromOperationalLimitCommand command) throws Exception {
    LOGGER.info("Handling command RemoveOperationalLimitFromOperationalLimitCommand");

    if (!operationalLimit.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "OperationalLimit does not contain an entity with id "
              + command.getRemoveFrom().getOperationalLimitId());

    apply(
        new RemoveOperationalLimitFromOperationalLimitEvent(
            command.getOperationalLimitId(), command.getRemoveFrom()));
  }

  @CommandHandler
  public void handle(AssignOperationalLimitValueToOperationalLimitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignOperationalLimitValueToOperationalLimitCommand");

    if (operationalLimitValue.contains(command.getAddTo()))
      throw new ProcessingException(
          "OperationalLimitValue already contains an entity with id "
              + command.getAddTo().getOperationalLimitId());

    apply(
        new AssignOperationalLimitValueToOperationalLimitEvent(
            command.getOperationalLimitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveOperationalLimitValueFromOperationalLimitCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveOperationalLimitValueFromOperationalLimitCommand");

    if (!operationalLimitValue.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "OperationalLimitValue does not contain an entity with id "
              + command.getRemoveFrom().getOperationalLimitId());

    apply(
        new RemoveOperationalLimitValueFromOperationalLimitEvent(
            command.getOperationalLimitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOperationalLimitEvent event) {
    LOGGER.info("Event sourcing CreateOperationalLimitEvent");
    this.operationalLimitId = event.getOperationalLimitId();
  }

  @EventSourcingHandler
  void on(UpdateOperationalLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.operationalLimit = event.getOperationalLimit();
    this.operationalLimitValue = event.getOperationalLimitValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignOperationalLimitToOperationalLimitEvent event) {
    LOGGER.info("Event sourcing AssignOperationalLimitToOperationalLimitEvent");
    this.operationalLimit.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveOperationalLimitFromOperationalLimitEvent event) {
    LOGGER.info("Event sourcing RemoveOperationalLimitFromOperationalLimitEvent");
    this.operationalLimit.remove(event.getRemoveFrom());
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignOperationalLimitValueToOperationalLimitEvent event) {
    LOGGER.info("Event sourcing AssignOperationalLimitValueToOperationalLimitEvent");
    this.operationalLimitValue.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveOperationalLimitValueFromOperationalLimitEvent event) {
    LOGGER.info("Event sourcing RemoveOperationalLimitValueFromOperationalLimitEvent");
    this.operationalLimitValue.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID operationalLimitId;

  private Set<OperationalLimit> operationalLimit = new HashSet<>();
  private Set<OperationalLimit> operationalLimitValue = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(OperationalLimitAggregate.class.getName());
}
