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
 * Aggregate handler for HydroPump as outlined for the CQRS pattern, all write responsibilities
 * related to HydroPump are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class HydroPumpAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public HydroPumpAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public HydroPumpAggregate(CreateHydroPumpCommand command) throws Exception {
    LOGGER.info("Handling command CreateHydroPumpCommand");
    CreateHydroPumpEvent event = new CreateHydroPumpEvent(command.getHydroPumpId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateHydroPumpCommand command) throws Exception {
    LOGGER.info("handling command UpdateHydroPumpCommand");
    UpdateHydroPumpEvent event =
        new UpdateHydroPumpEvent(
            command.getHydroPumpId(), command.getHydroPump(), command.getHydroPumps());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteHydroPumpCommand command) throws Exception {
    LOGGER.info("Handling command DeleteHydroPumpCommand");
    apply(new DeleteHydroPumpEvent(command.getHydroPumpId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHydroPumpToHydroPumpCommand command) throws Exception {
    LOGGER.info("Handling command AssignHydroPumpToHydroPumpCommand");

    if (hydroPump != null && hydroPump.getHydroPumpId() == command.getAssignment().getHydroPumpId())
      throw new ProcessingException(
          "HydroPump already assigned with id " + command.getAssignment().getHydroPumpId());

    apply(new AssignHydroPumpToHydroPumpEvent(command.getHydroPumpId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHydroPumpFromHydroPumpCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHydroPumpFromHydroPumpCommand");

    if (hydroPump == null) throw new ProcessingException("HydroPump already has nothing assigned.");

    apply(new UnAssignHydroPumpFromHydroPumpEvent(command.getHydroPumpId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignHydroPumpsToHydroPumpCommand command) throws Exception {
    LOGGER.info("Handling command AssignHydroPumpsToHydroPumpCommand");

    if (hydroPumps.contains(command.getAddTo()))
      throw new ProcessingException(
          "HydroPumps already contains an entity with id " + command.getAddTo().getHydroPumpId());

    apply(new AssignHydroPumpsToHydroPumpEvent(command.getHydroPumpId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveHydroPumpsFromHydroPumpCommand command) throws Exception {
    LOGGER.info("Handling command RemoveHydroPumpsFromHydroPumpCommand");

    if (!hydroPumps.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "HydroPumps does not contain an entity with id "
              + command.getRemoveFrom().getHydroPumpId());

    apply(
        new RemoveHydroPumpsFromHydroPumpEvent(command.getHydroPumpId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateHydroPumpEvent event) {
    LOGGER.info("Event sourcing CreateHydroPumpEvent");
    this.hydroPumpId = event.getHydroPumpId();
  }

  @EventSourcingHandler
  void on(UpdateHydroPumpEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.hydroPump = event.getHydroPump();
    this.hydroPumps = event.getHydroPumps();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHydroPumpToHydroPumpEvent event) {
    LOGGER.info("Event sourcing AssignHydroPumpToHydroPumpEvent");
    this.hydroPump = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHydroPumpFromHydroPumpEvent event) {
    LOGGER.info("Event sourcing UnAssignHydroPumpFromHydroPumpEvent");
    this.hydroPump = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignHydroPumpsToHydroPumpEvent event) {
    LOGGER.info("Event sourcing AssignHydroPumpsToHydroPumpEvent");
    this.hydroPumps.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveHydroPumpsFromHydroPumpEvent event) {
    LOGGER.info("Event sourcing RemoveHydroPumpsFromHydroPumpEvent");
    this.hydroPumps.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID hydroPumpId;

  private HydroPump hydroPump = null;
  private Set<HydroPump> hydroPumps = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(HydroPumpAggregate.class.getName());
}
