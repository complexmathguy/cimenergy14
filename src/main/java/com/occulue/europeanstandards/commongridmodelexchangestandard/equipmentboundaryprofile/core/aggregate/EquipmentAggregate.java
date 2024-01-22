package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.aggregate;

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
 * Aggregate handler for Equipment as outlined for the CQRS pattern, all write responsibilities
 * related to Equipment are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquipmentAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquipmentAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquipmentAggregate(CreateEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquipmentCommand");
    CreateEquipmentEvent event = new CreateEquipmentEvent(command.getEquipmentId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquipmentCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquipmentCommand");
    UpdateEquipmentEvent event =
        new UpdateEquipmentEvent(command.getEquipmentId(), command.getEquipments());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquipmentCommand");
    apply(new DeleteEquipmentEvent(command.getEquipmentId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignEquipmentsToEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignEquipmentsToEquipmentCommand");

    if (equipments.contains(command.getAddTo()))
      throw new ProcessingException(
          "Equipments already contains an entity with id " + command.getAddTo().getEquipmentId());

    apply(new AssignEquipmentsToEquipmentEvent(command.getEquipmentId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEquipmentsFromEquipmentCommand command) throws Exception {
    LOGGER.info("Handling command RemoveEquipmentsFromEquipmentCommand");

    if (!equipments.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Equipments does not contain an entity with id "
              + command.getRemoveFrom().getEquipmentId());

    apply(
        new RemoveEquipmentsFromEquipmentEvent(command.getEquipmentId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquipmentEvent event) {
    LOGGER.info("Event sourcing CreateEquipmentEvent");
    this.equipmentId = event.getEquipmentId();
  }

  @EventSourcingHandler
  void on(UpdateEquipmentEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.equipments = event.getEquipments();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignEquipmentsToEquipmentEvent event) {
    LOGGER.info("Event sourcing AssignEquipmentsToEquipmentEvent");
    this.equipments.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEquipmentsFromEquipmentEvent event) {
    LOGGER.info("Event sourcing RemoveEquipmentsFromEquipmentEvent");
    this.equipments.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equipmentId;

  private Set<Equipment> equipments = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(EquipmentAggregate.class.getName());
}
