package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.aggregate;

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
 * Aggregate handler for ConformLoad as outlined for the CQRS pattern, all write responsibilities
 * related to ConformLoad are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ConformLoadAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ConformLoadAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ConformLoadAggregate(CreateConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command CreateConformLoadCommand");
    CreateConformLoadEvent event = new CreateConformLoadEvent(command.getConformLoadId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateConformLoadCommand command) throws Exception {
    LOGGER.info("handling command UpdateConformLoadCommand");
    UpdateConformLoadEvent event =
        new UpdateConformLoadEvent(command.getConformLoadId(), command.getEnergyConsumers());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command DeleteConformLoadCommand");
    apply(new DeleteConformLoadEvent(command.getConformLoadId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignEnergyConsumersToConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnergyConsumersToConformLoadCommand");

    if (energyConsumers.contains(command.getAddTo()))
      throw new ProcessingException(
          "EnergyConsumers already contains an entity with id "
              + command.getAddTo().getConformLoadId());

    apply(
        new AssignEnergyConsumersToConformLoadEvent(
            command.getConformLoadId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEnergyConsumersFromConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command RemoveEnergyConsumersFromConformLoadCommand");

    if (!energyConsumers.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EnergyConsumers does not contain an entity with id "
              + command.getRemoveFrom().getConformLoadId());

    apply(
        new RemoveEnergyConsumersFromConformLoadEvent(
            command.getConformLoadId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateConformLoadEvent event) {
    LOGGER.info("Event sourcing CreateConformLoadEvent");
    this.conformLoadId = event.getConformLoadId();
  }

  @EventSourcingHandler
  void on(UpdateConformLoadEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.energyConsumers = event.getEnergyConsumers();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignEnergyConsumersToConformLoadEvent event) {
    LOGGER.info("Event sourcing AssignEnergyConsumersToConformLoadEvent");
    this.energyConsumers.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEnergyConsumersFromConformLoadEvent event) {
    LOGGER.info("Event sourcing RemoveEnergyConsumersFromConformLoadEvent");
    this.energyConsumers.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID conformLoadId;

  private Set<ConformLoad> energyConsumers = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(ConformLoadAggregate.class.getName());
}
