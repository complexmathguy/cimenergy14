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
 * Aggregate handler for NonConformLoad as outlined for the CQRS pattern, all write responsibilities
 * related to NonConformLoad are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class NonConformLoadAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public NonConformLoadAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public NonConformLoadAggregate(CreateNonConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command CreateNonConformLoadCommand");
    CreateNonConformLoadEvent event = new CreateNonConformLoadEvent(command.getNonConformLoadId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateNonConformLoadCommand command) throws Exception {
    LOGGER.info("handling command UpdateNonConformLoadCommand");
    UpdateNonConformLoadEvent event =
        new UpdateNonConformLoadEvent(command.getNonConformLoadId(), command.getEnergyConsumers());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteNonConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command DeleteNonConformLoadCommand");
    apply(new DeleteNonConformLoadEvent(command.getNonConformLoadId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignEnergyConsumersToNonConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnergyConsumersToNonConformLoadCommand");

    if (energyConsumers.contains(command.getAddTo()))
      throw new ProcessingException(
          "EnergyConsumers already contains an entity with id "
              + command.getAddTo().getNonConformLoadId());

    apply(
        new AssignEnergyConsumersToNonConformLoadEvent(
            command.getNonConformLoadId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEnergyConsumersFromNonConformLoadCommand command) throws Exception {
    LOGGER.info("Handling command RemoveEnergyConsumersFromNonConformLoadCommand");

    if (!energyConsumers.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EnergyConsumers does not contain an entity with id "
              + command.getRemoveFrom().getNonConformLoadId());

    apply(
        new RemoveEnergyConsumersFromNonConformLoadEvent(
            command.getNonConformLoadId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateNonConformLoadEvent event) {
    LOGGER.info("Event sourcing CreateNonConformLoadEvent");
    this.nonConformLoadId = event.getNonConformLoadId();
  }

  @EventSourcingHandler
  void on(UpdateNonConformLoadEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.energyConsumers = event.getEnergyConsumers();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignEnergyConsumersToNonConformLoadEvent event) {
    LOGGER.info("Event sourcing AssignEnergyConsumersToNonConformLoadEvent");
    this.energyConsumers.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEnergyConsumersFromNonConformLoadEvent event) {
    LOGGER.info("Event sourcing RemoveEnergyConsumersFromNonConformLoadEvent");
    this.energyConsumers.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID nonConformLoadId;

  private Set<NonConformLoad> energyConsumers = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(NonConformLoadAggregate.class.getName());
}
