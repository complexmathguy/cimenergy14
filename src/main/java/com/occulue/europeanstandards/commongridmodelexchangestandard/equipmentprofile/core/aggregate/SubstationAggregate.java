package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.aggregate;

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
 * Aggregate handler for Substation as outlined for the CQRS pattern, all write responsibilities
 * related to Substation are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SubstationAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SubstationAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SubstationAggregate(CreateSubstationCommand command) throws Exception {
    LOGGER.info("Handling command CreateSubstationCommand");
    CreateSubstationEvent event = new CreateSubstationEvent(command.getSubstationId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSubstationCommand command) throws Exception {
    LOGGER.info("handling command UpdateSubstationCommand");
    UpdateSubstationEvent event =
        new UpdateSubstationEvent(command.getSubstationId(), command.getSubstations());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSubstationCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSubstationCommand");
    apply(new DeleteSubstationEvent(command.getSubstationId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignSubstationsToSubstationCommand command) throws Exception {
    LOGGER.info("Handling command AssignSubstationsToSubstationCommand");

    if (substations.contains(command.getAddTo()))
      throw new ProcessingException(
          "Substations already contains an entity with id " + command.getAddTo().getSubstationId());

    apply(new AssignSubstationsToSubstationEvent(command.getSubstationId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveSubstationsFromSubstationCommand command) throws Exception {
    LOGGER.info("Handling command RemoveSubstationsFromSubstationCommand");

    if (!substations.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Substations does not contain an entity with id "
              + command.getRemoveFrom().getSubstationId());

    apply(
        new RemoveSubstationsFromSubstationEvent(
            command.getSubstationId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSubstationEvent event) {
    LOGGER.info("Event sourcing CreateSubstationEvent");
    this.substationId = event.getSubstationId();
  }

  @EventSourcingHandler
  void on(UpdateSubstationEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.substations = event.getSubstations();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignSubstationsToSubstationEvent event) {
    LOGGER.info("Event sourcing AssignSubstationsToSubstationEvent");
    this.substations.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveSubstationsFromSubstationEvent event) {
    LOGGER.info("Event sourcing RemoveSubstationsFromSubstationEvent");
    this.substations.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID substationId;

  private Set<Substation> substations = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(SubstationAggregate.class.getName());
}
