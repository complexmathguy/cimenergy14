package com.occulue.europeanstandards.extension.aggregate;

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
 * Aggregate handler for ENTSOEIdentifiedObject as outlined for the CQRS pattern, all write
 * responsibilities related to ENTSOEIdentifiedObject are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ENTSOEIdentifiedObjectAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ENTSOEIdentifiedObjectAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ENTSOEIdentifiedObjectAggregate(CreateENTSOEIdentifiedObjectCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateENTSOEIdentifiedObjectCommand");
    CreateENTSOEIdentifiedObjectEvent event =
        new CreateENTSOEIdentifiedObjectEvent(command.getENTSOEIdentifiedObjectId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateENTSOEIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("handling command UpdateENTSOEIdentifiedObjectCommand");
    UpdateENTSOEIdentifiedObjectEvent event =
        new UpdateENTSOEIdentifiedObjectEvent(
            command.getENTSOEIdentifiedObjectId(),
            command.getEnergyIdentCodeEic(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteENTSOEIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command DeleteENTSOEIdentifiedObjectCommand");
    apply(new DeleteENTSOEIdentifiedObjectEvent(command.getENTSOEIdentifiedObjectId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand");

    if (energyIdentCodeEic != null
        && energyIdentCodeEic.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EnergyIdentCodeEic already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectEvent(
            command.getENTSOEIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand");

    if (energyIdentCodeEic == null)
      throw new ProcessingException("EnergyIdentCodeEic already has nothing assigned.");

    apply(
        new UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectEvent(
            command.getENTSOEIdentifiedObjectId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToENTSOEIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToENTSOEIdentifiedObjectCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToENTSOEIdentifiedObjectEvent(
            command.getENTSOEIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromENTSOEIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromENTSOEIdentifiedObjectCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromENTSOEIdentifiedObjectEvent(
            command.getENTSOEIdentifiedObjectId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing CreateENTSOEIdentifiedObjectEvent");
    this.eNTSOEIdentifiedObjectId = event.getENTSOEIdentifiedObjectId();
  }

  @EventSourcingHandler
  void on(UpdateENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
    this.shortName = event.getShortName();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectEvent");
    this.energyIdentCodeEic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectEvent");
    this.energyIdentCodeEic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToENTSOEIdentifiedObjectEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromENTSOEIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromENTSOEIdentifiedObjectEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID eNTSOEIdentifiedObjectId;

  private StringProxy energyIdentCodeEic = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEIdentifiedObjectAggregate.class.getName());
}
