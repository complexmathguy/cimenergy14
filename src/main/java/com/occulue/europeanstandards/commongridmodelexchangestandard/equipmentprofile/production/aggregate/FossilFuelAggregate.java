package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.aggregate;

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
 * Aggregate handler for FossilFuel as outlined for the CQRS pattern, all write responsibilities
 * related to FossilFuel are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class FossilFuelAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public FossilFuelAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public FossilFuelAggregate(CreateFossilFuelCommand command) throws Exception {
    LOGGER.info("Handling command CreateFossilFuelCommand");
    CreateFossilFuelEvent event =
        new CreateFossilFuelEvent(command.getFossilFuelId(), command.getFossilFuelType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateFossilFuelCommand command) throws Exception {
    LOGGER.info("handling command UpdateFossilFuelCommand");
    UpdateFossilFuelEvent event =
        new UpdateFossilFuelEvent(
            command.getFossilFuelId(), command.getFossilFuelType(), command.getFossilFuels());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteFossilFuelCommand command) throws Exception {
    LOGGER.info("Handling command DeleteFossilFuelCommand");
    apply(new DeleteFossilFuelEvent(command.getFossilFuelId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignFossilFuelsToFossilFuelCommand command) throws Exception {
    LOGGER.info("Handling command AssignFossilFuelsToFossilFuelCommand");

    if (fossilFuels.contains(command.getAddTo()))
      throw new ProcessingException(
          "FossilFuels already contains an entity with id " + command.getAddTo().getFossilFuelId());

    apply(new AssignFossilFuelsToFossilFuelEvent(command.getFossilFuelId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveFossilFuelsFromFossilFuelCommand command) throws Exception {
    LOGGER.info("Handling command RemoveFossilFuelsFromFossilFuelCommand");

    if (!fossilFuels.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "FossilFuels does not contain an entity with id "
              + command.getRemoveFrom().getFossilFuelId());

    apply(
        new RemoveFossilFuelsFromFossilFuelEvent(
            command.getFossilFuelId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateFossilFuelEvent event) {
    LOGGER.info("Event sourcing CreateFossilFuelEvent");
    this.fossilFuelId = event.getFossilFuelId();
    this.fossilFuelType = event.getFossilFuelType();
  }

  @EventSourcingHandler
  void on(UpdateFossilFuelEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.fossilFuelType = event.getFossilFuelType();
    this.fossilFuels = event.getFossilFuels();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignFossilFuelsToFossilFuelEvent event) {
    LOGGER.info("Event sourcing AssignFossilFuelsToFossilFuelEvent");
    this.fossilFuels.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveFossilFuelsFromFossilFuelEvent event) {
    LOGGER.info("Event sourcing RemoveFossilFuelsFromFossilFuelEvent");
    this.fossilFuels.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID fossilFuelId;

  private FuelType fossilFuelType;
  private Set<FossilFuel> fossilFuels = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(FossilFuelAggregate.class.getName());
}
