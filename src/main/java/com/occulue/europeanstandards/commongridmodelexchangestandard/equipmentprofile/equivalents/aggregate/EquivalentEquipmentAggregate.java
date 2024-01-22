package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.aggregate;

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
 * Aggregate handler for EquivalentEquipment as outlined for the CQRS pattern, all write
 * responsibilities related to EquivalentEquipment are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquivalentEquipmentAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquivalentEquipmentAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquivalentEquipmentAggregate(CreateEquivalentEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquivalentEquipmentCommand");
    CreateEquivalentEquipmentEvent event =
        new CreateEquivalentEquipmentEvent(command.getEquivalentEquipmentId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquivalentEquipmentCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquivalentEquipmentCommand");
    UpdateEquivalentEquipmentEvent event =
        new UpdateEquivalentEquipmentEvent(
            command.getEquivalentEquipmentId(), command.getEquivalentEquipments());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquivalentEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquivalentEquipmentCommand");
    apply(new DeleteEquivalentEquipmentEvent(command.getEquivalentEquipmentId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignEquivalentEquipmentsToEquivalentEquipmentCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEquivalentEquipmentsToEquivalentEquipmentCommand");

    if (equivalentEquipments.contains(command.getAddTo()))
      throw new ProcessingException(
          "EquivalentEquipments already contains an entity with id "
              + command.getAddTo().getEquivalentEquipmentId());

    apply(
        new AssignEquivalentEquipmentsToEquivalentEquipmentEvent(
            command.getEquivalentEquipmentId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveEquivalentEquipmentsFromEquivalentEquipmentCommand");

    if (!equivalentEquipments.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EquivalentEquipments does not contain an entity with id "
              + command.getRemoveFrom().getEquivalentEquipmentId());

    apply(
        new RemoveEquivalentEquipmentsFromEquivalentEquipmentEvent(
            command.getEquivalentEquipmentId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquivalentEquipmentEvent event) {
    LOGGER.info("Event sourcing CreateEquivalentEquipmentEvent");
    this.equivalentEquipmentId = event.getEquivalentEquipmentId();
  }

  @EventSourcingHandler
  void on(UpdateEquivalentEquipmentEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.equivalentEquipments = event.getEquivalentEquipments();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignEquivalentEquipmentsToEquivalentEquipmentEvent event) {
    LOGGER.info("Event sourcing AssignEquivalentEquipmentsToEquivalentEquipmentEvent");
    this.equivalentEquipments.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEquivalentEquipmentsFromEquivalentEquipmentEvent event) {
    LOGGER.info("Event sourcing RemoveEquivalentEquipmentsFromEquivalentEquipmentEvent");
    this.equivalentEquipments.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equivalentEquipmentId;

  private Set<EquivalentEquipment> equivalentEquipments = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(EquivalentEquipmentAggregate.class.getName());
}
