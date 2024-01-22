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
 * Aggregate handler for Bay as outlined for the CQRS pattern, all write responsibilities related to
 * Bay are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BayAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BayAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BayAggregate(CreateBayCommand command) throws Exception {
    LOGGER.info("Handling command CreateBayCommand");
    CreateBayEvent event = new CreateBayEvent(command.getBayId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBayCommand command) throws Exception {
    LOGGER.info("handling command UpdateBayCommand");
    UpdateBayEvent event = new UpdateBayEvent(command.getBayId(), command.getBays());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBayCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBayCommand");
    apply(new DeleteBayEvent(command.getBayId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignBaysToBayCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaysToBayCommand");

    if (bays.contains(command.getAddTo()))
      throw new ProcessingException(
          "Bays already contains an entity with id " + command.getAddTo().getBayId());

    apply(new AssignBaysToBayEvent(command.getBayId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveBaysFromBayCommand command) throws Exception {
    LOGGER.info("Handling command RemoveBaysFromBayCommand");

    if (!bays.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Bays does not contain an entity with id " + command.getRemoveFrom().getBayId());

    apply(new RemoveBaysFromBayEvent(command.getBayId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBayEvent event) {
    LOGGER.info("Event sourcing CreateBayEvent");
    this.bayId = event.getBayId();
  }

  @EventSourcingHandler
  void on(UpdateBayEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.bays = event.getBays();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignBaysToBayEvent event) {
    LOGGER.info("Event sourcing AssignBaysToBayEvent");
    this.bays.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveBaysFromBayEvent event) {
    LOGGER.info("Event sourcing RemoveBaysFromBayEvent");
    this.bays.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID bayId;

  private Set<Bay> bays = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(BayAggregate.class.getName());
}
