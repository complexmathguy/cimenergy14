package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.aggregate;

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
 * Aggregate handler for EnergySource as outlined for the CQRS pattern, all write responsibilities
 * related to EnergySource are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EnergySourceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EnergySourceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EnergySourceAggregate(CreateEnergySourceCommand command) throws Exception {
    LOGGER.info("Handling command CreateEnergySourceCommand");
    CreateEnergySourceEvent event = new CreateEnergySourceEvent(command.getEnergySourceId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEnergySourceCommand command) throws Exception {
    LOGGER.info("handling command UpdateEnergySourceCommand");
    UpdateEnergySourceEvent event =
        new UpdateEnergySourceEvent(command.getEnergySourceId(), command.getEnergySource());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEnergySourceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEnergySourceCommand");
    apply(new DeleteEnergySourceEvent(command.getEnergySourceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignEnergySourceToEnergySourceCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnergySourceToEnergySourceCommand");

    if (energySource.contains(command.getAddTo()))
      throw new ProcessingException(
          "EnergySource already contains an entity with id "
              + command.getAddTo().getEnergySourceId());

    apply(
        new AssignEnergySourceToEnergySourceEvent(command.getEnergySourceId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEnergySourceFromEnergySourceCommand command) throws Exception {
    LOGGER.info("Handling command RemoveEnergySourceFromEnergySourceCommand");

    if (!energySource.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EnergySource does not contain an entity with id "
              + command.getRemoveFrom().getEnergySourceId());

    apply(
        new RemoveEnergySourceFromEnergySourceEvent(
            command.getEnergySourceId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEnergySourceEvent event) {
    LOGGER.info("Event sourcing CreateEnergySourceEvent");
    this.energySourceId = event.getEnergySourceId();
  }

  @EventSourcingHandler
  void on(UpdateEnergySourceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.energySource = event.getEnergySource();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignEnergySourceToEnergySourceEvent event) {
    LOGGER.info("Event sourcing AssignEnergySourceToEnergySourceEvent");
    this.energySource.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEnergySourceFromEnergySourceEvent event) {
    LOGGER.info("Event sourcing RemoveEnergySourceFromEnergySourceEvent");
    this.energySource.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID energySourceId;

  private Set<EnergySource> energySource = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(EnergySourceAggregate.class.getName());
}
