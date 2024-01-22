package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.aggregate;

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
 * Aggregate handler for ControlAreaGeneratingUnit as outlined for the CQRS pattern, all write
 * responsibilities related to ControlAreaGeneratingUnit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ControlAreaGeneratingUnitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ControlAreaGeneratingUnitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ControlAreaGeneratingUnitAggregate(CreateControlAreaGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateControlAreaGeneratingUnitCommand");
    CreateControlAreaGeneratingUnitEvent event =
        new CreateControlAreaGeneratingUnitEvent(command.getControlAreaGeneratingUnitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateControlAreaGeneratingUnitCommand command) throws Exception {
    LOGGER.info("handling command UpdateControlAreaGeneratingUnitCommand");
    UpdateControlAreaGeneratingUnitEvent event =
        new UpdateControlAreaGeneratingUnitEvent(
            command.getControlAreaGeneratingUnitId(), command.getControlAreaGeneratingUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteControlAreaGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteControlAreaGeneratingUnitCommand");
    apply(new DeleteControlAreaGeneratingUnitEvent(command.getControlAreaGeneratingUnitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitCommand");

    if (controlAreaGeneratingUnit.contains(command.getAddTo()))
      throw new ProcessingException(
          "ControlAreaGeneratingUnit already contains an entity with id "
              + command.getAddTo().getControlAreaGeneratingUnitId());

    apply(
        new AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitEvent(
            command.getControlAreaGeneratingUnitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitCommand");

    if (!controlAreaGeneratingUnit.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "ControlAreaGeneratingUnit does not contain an entity with id "
              + command.getRemoveFrom().getControlAreaGeneratingUnitId());

    apply(
        new RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitEvent(
            command.getControlAreaGeneratingUnitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateControlAreaGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing CreateControlAreaGeneratingUnitEvent");
    this.controlAreaGeneratingUnitId = event.getControlAreaGeneratingUnitId();
  }

  @EventSourcingHandler
  void on(UpdateControlAreaGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.controlAreaGeneratingUnit = event.getControlAreaGeneratingUnit();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitEvent");
    this.controlAreaGeneratingUnit.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitEvent");
    this.controlAreaGeneratingUnit.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID controlAreaGeneratingUnitId;

  private Set<ControlAreaGeneratingUnit> controlAreaGeneratingUnit = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(ControlAreaGeneratingUnitAggregate.class.getName());
}
