package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for RegulatingCondEq as outlined for the CQRS pattern, all write
 * responsibilities related to RegulatingCondEq are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RegulatingCondEqAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RegulatingCondEqAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RegulatingCondEqAggregate(CreateRegulatingCondEqCommand command) throws Exception {
    LOGGER.info("Handling command CreateRegulatingCondEqCommand");
    CreateRegulatingCondEqEvent event =
        new CreateRegulatingCondEqEvent(command.getRegulatingCondEqId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRegulatingCondEqCommand command) throws Exception {
    LOGGER.info("handling command UpdateRegulatingCondEqCommand");
    UpdateRegulatingCondEqEvent event =
        new UpdateRegulatingCondEqEvent(
            command.getRegulatingCondEqId(), command.getRegulatingCondEq());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRegulatingCondEqCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRegulatingCondEqCommand");
    apply(new DeleteRegulatingCondEqEvent(command.getRegulatingCondEqId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRegulatingCondEqToRegulatingCondEqCommand command) throws Exception {
    LOGGER.info("Handling command AssignRegulatingCondEqToRegulatingCondEqCommand");

    if (regulatingCondEq.contains(command.getAddTo()))
      throw new ProcessingException(
          "RegulatingCondEq already contains an entity with id "
              + command.getAddTo().getRegulatingCondEqId());

    apply(
        new AssignRegulatingCondEqToRegulatingCondEqEvent(
            command.getRegulatingCondEqId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRegulatingCondEqFromRegulatingCondEqCommand command) throws Exception {
    LOGGER.info("Handling command RemoveRegulatingCondEqFromRegulatingCondEqCommand");

    if (!regulatingCondEq.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "RegulatingCondEq does not contain an entity with id "
              + command.getRemoveFrom().getRegulatingCondEqId());

    apply(
        new RemoveRegulatingCondEqFromRegulatingCondEqEvent(
            command.getRegulatingCondEqId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRegulatingCondEqEvent event) {
    LOGGER.info("Event sourcing CreateRegulatingCondEqEvent");
    this.regulatingCondEqId = event.getRegulatingCondEqId();
  }

  @EventSourcingHandler
  void on(UpdateRegulatingCondEqEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.regulatingCondEq = event.getRegulatingCondEq();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRegulatingCondEqToRegulatingCondEqEvent event) {
    LOGGER.info("Event sourcing AssignRegulatingCondEqToRegulatingCondEqEvent");
    this.regulatingCondEq.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRegulatingCondEqFromRegulatingCondEqEvent event) {
    LOGGER.info("Event sourcing RemoveRegulatingCondEqFromRegulatingCondEqEvent");
    this.regulatingCondEq.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID regulatingCondEqId;

  private Set<RegulatingCondEq> regulatingCondEq = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(RegulatingCondEqAggregate.class.getName());
}
