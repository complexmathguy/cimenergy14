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
 * Aggregate handler for IdentifiedObject as outlined for the CQRS pattern, all write
 * responsibilities related to IdentifiedObject are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class IdentifiedObjectAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public IdentifiedObjectAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public IdentifiedObjectAggregate(CreateIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command CreateIdentifiedObjectCommand");
    CreateIdentifiedObjectEvent event =
        new CreateIdentifiedObjectEvent(command.getIdentifiedObjectId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("handling command UpdateIdentifiedObjectCommand");
    UpdateIdentifiedObjectEvent event =
        new UpdateIdentifiedObjectEvent(
            command.getIdentifiedObjectId(),
            command.getDescription(),
            command.getEnergyIdentCodeEic(),
            command.getMRID(),
            command.getName(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command DeleteIdentifiedObjectCommand");
    apply(new DeleteIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDescriptionToIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignDescriptionToIdentifiedObjectCommand");

    if (description != null
        && description.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "Description already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignDescriptionToIdentifiedObjectEvent(
            command.getIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDescriptionFromIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDescriptionFromIdentifiedObjectCommand");

    if (description == null)
      throw new ProcessingException("Description already has nothing assigned.");

    apply(new UnAssignDescriptionFromIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  @CommandHandler
  public void handle(AssignEnergyIdentCodeEicToIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnergyIdentCodeEicToIdentifiedObjectCommand");

    if (energyIdentCodeEic != null
        && energyIdentCodeEic.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EnergyIdentCodeEic already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignEnergyIdentCodeEicToIdentifiedObjectEvent(
            command.getIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand");

    if (energyIdentCodeEic == null)
      throw new ProcessingException("EnergyIdentCodeEic already has nothing assigned.");

    apply(new UnAssignEnergyIdentCodeEicFromIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  @CommandHandler
  public void handle(AssignMRIDToIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignMRIDToIdentifiedObjectCommand");

    if (mRID != null && mRID.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "MRID already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignMRIDToIdentifiedObjectEvent(
            command.getIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMRIDFromIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMRIDFromIdentifiedObjectCommand");

    if (mRID == null) throw new ProcessingException("MRID already has nothing assigned.");

    apply(new UnAssignMRIDFromIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  @CommandHandler
  public void handle(AssignNameToIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignNameToIdentifiedObjectCommand");

    if (name != null && name.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "Name already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNameToIdentifiedObjectEvent(
            command.getIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNameFromIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNameFromIdentifiedObjectCommand");

    if (name == null) throw new ProcessingException("Name already has nothing assigned.");

    apply(new UnAssignNameFromIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToIdentifiedObjectCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToIdentifiedObjectEvent(
            command.getIdentifiedObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromIdentifiedObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromIdentifiedObjectCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(new UnAssignShortNameFromIdentifiedObjectEvent(command.getIdentifiedObjectId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing CreateIdentifiedObjectEvent");
    this.identifiedObjectId = event.getIdentifiedObjectId();
  }

  @EventSourcingHandler
  void on(UpdateIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.description = event.getDescription();
    this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
    this.mRID = event.getMRID();
    this.name = event.getName();
    this.shortName = event.getShortName();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDescriptionToIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignDescriptionToIdentifiedObjectEvent");
    this.description = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDescriptionFromIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignDescriptionFromIdentifiedObjectEvent");
    this.description = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEnergyIdentCodeEicToIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignEnergyIdentCodeEicToIdentifiedObjectEvent");
    this.energyIdentCodeEic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEnergyIdentCodeEicFromIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignEnergyIdentCodeEicFromIdentifiedObjectEvent");
    this.energyIdentCodeEic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMRIDToIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignMRIDToIdentifiedObjectEvent");
    this.mRID = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMRIDFromIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignMRIDFromIdentifiedObjectEvent");
    this.mRID = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNameToIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignNameToIdentifiedObjectEvent");
    this.name = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNameFromIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignNameFromIdentifiedObjectEvent");
    this.name = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToIdentifiedObjectEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromIdentifiedObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromIdentifiedObjectEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID identifiedObjectId;

  private StringProxy description = null;
  private StringProxy energyIdentCodeEic = null;
  private StringProxy mRID = null;
  private StringProxy name = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER = Logger.getLogger(IdentifiedObjectAggregate.class.getName());
}
