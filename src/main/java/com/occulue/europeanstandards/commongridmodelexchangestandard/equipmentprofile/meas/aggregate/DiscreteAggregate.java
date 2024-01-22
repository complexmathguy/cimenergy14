package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for Discrete as outlined for the CQRS pattern, all write responsibilities
 * related to Discrete are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscreteAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscreteAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscreteAggregate(CreateDiscreteCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscreteCommand");
    CreateDiscreteEvent event = new CreateDiscreteEvent(command.getDiscreteId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscreteCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscreteCommand");
    UpdateDiscreteEvent event =
        new UpdateDiscreteEvent(command.getDiscreteId(), command.getDiscretes());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscreteCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscreteCommand");
    apply(new DeleteDiscreteEvent(command.getDiscreteId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDiscretesToDiscreteCommand command) throws Exception {
    LOGGER.info("Handling command AssignDiscretesToDiscreteCommand");

    if (discretes.contains(command.getAddTo()))
      throw new ProcessingException(
          "Discretes already contains an entity with id " + command.getAddTo().getDiscreteId());

    apply(new AssignDiscretesToDiscreteEvent(command.getDiscreteId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDiscretesFromDiscreteCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDiscretesFromDiscreteCommand");

    if (!discretes.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Discretes does not contain an entity with id "
              + command.getRemoveFrom().getDiscreteId());

    apply(new RemoveDiscretesFromDiscreteEvent(command.getDiscreteId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscreteEvent event) {
    LOGGER.info("Event sourcing CreateDiscreteEvent");
    this.discreteId = event.getDiscreteId();
  }

  @EventSourcingHandler
  void on(UpdateDiscreteEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.discretes = event.getDiscretes();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDiscretesToDiscreteEvent event) {
    LOGGER.info("Event sourcing AssignDiscretesToDiscreteEvent");
    this.discretes.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDiscretesFromDiscreteEvent event) {
    LOGGER.info("Event sourcing RemoveDiscretesFromDiscreteEvent");
    this.discretes.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discreteId;

  private Set<Discrete> discretes = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DiscreteAggregate.class.getName());
}
