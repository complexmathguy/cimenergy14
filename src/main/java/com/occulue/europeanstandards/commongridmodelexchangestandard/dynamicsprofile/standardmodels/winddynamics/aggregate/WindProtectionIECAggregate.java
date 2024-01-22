package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindProtectionIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindProtectionIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindProtectionIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindProtectionIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindProtectionIECAggregate(CreateWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindProtectionIECCommand");
    CreateWindProtectionIECEvent event =
        new CreateWindProtectionIECEvent(command.getWindProtectionIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindProtectionIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindProtectionIECCommand");
    UpdateWindProtectionIECEvent event =
        new UpdateWindProtectionIECEvent(
            command.getWindProtectionIECId(),
            command.getFover(),
            command.getFunder(),
            command.getTfover(),
            command.getTfunder(),
            command.getTuover(),
            command.getTuunder(),
            command.getUover(),
            command.getUunder());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindProtectionIECCommand");
    apply(new DeleteWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignFoverToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignFoverToWindProtectionIECCommand");

    if (fover != null && fover.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fover already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignFoverToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFoverFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFoverFromWindProtectionIECCommand");

    if (fover == null) throw new ProcessingException("Fover already has nothing assigned.");

    apply(new UnAssignFoverFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignFunderToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignFunderToWindProtectionIECCommand");

    if (funder != null && funder.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Funder already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignFunderToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFunderFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFunderFromWindProtectionIECCommand");

    if (funder == null) throw new ProcessingException("Funder already has nothing assigned.");

    apply(new UnAssignFunderFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignTfoverToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfoverToWindProtectionIECCommand");

    if (tfover != null && tfover.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfover already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTfoverToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfoverFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfoverFromWindProtectionIECCommand");

    if (tfover == null) throw new ProcessingException("Tfover already has nothing assigned.");

    apply(new UnAssignTfoverFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignTfunderToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfunderToWindProtectionIECCommand");

    if (tfunder != null && tfunder.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfunder already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTfunderToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfunderFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfunderFromWindProtectionIECCommand");

    if (tfunder == null) throw new ProcessingException("Tfunder already has nothing assigned.");

    apply(new UnAssignTfunderFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignTuoverToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTuoverToWindProtectionIECCommand");

    if (tuover != null && tuover.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuover already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTuoverToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuoverFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuoverFromWindProtectionIECCommand");

    if (tuover == null) throw new ProcessingException("Tuover already has nothing assigned.");

    apply(new UnAssignTuoverFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignTuunderToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTuunderToWindProtectionIECCommand");

    if (tuunder != null && tuunder.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuunder already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTuunderToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuunderFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuunderFromWindProtectionIECCommand");

    if (tuunder == null) throw new ProcessingException("Tuunder already has nothing assigned.");

    apply(new UnAssignTuunderFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignUoverToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUoverToWindProtectionIECCommand");

    if (uover != null && uover.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uover already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignUoverToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoverFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoverFromWindProtectionIECCommand");

    if (uover == null) throw new ProcessingException("Uover already has nothing assigned.");

    apply(new UnAssignUoverFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  @CommandHandler
  public void handle(AssignUunderToWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUunderToWindProtectionIECCommand");

    if (uunder != null && uunder.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uunder already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignUunderToWindProtectionIECEvent(
            command.getWindProtectionIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUunderFromWindProtectionIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUunderFromWindProtectionIECCommand");

    if (uunder == null) throw new ProcessingException("Uunder already has nothing assigned.");

    apply(new UnAssignUunderFromWindProtectionIECEvent(command.getWindProtectionIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing CreateWindProtectionIECEvent");
    this.windProtectionIECId = event.getWindProtectionIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.fover = event.getFover();
    this.funder = event.getFunder();
    this.tfover = event.getTfover();
    this.tfunder = event.getTfunder();
    this.tuover = event.getTuover();
    this.tuunder = event.getTuunder();
    this.uover = event.getUover();
    this.uunder = event.getUunder();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignFoverToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignFoverToWindProtectionIECEvent");
    this.fover = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFoverFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignFoverFromWindProtectionIECEvent");
    this.fover = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFunderToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignFunderToWindProtectionIECEvent");
    this.funder = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFunderFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignFunderFromWindProtectionIECEvent");
    this.funder = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfoverToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignTfoverToWindProtectionIECEvent");
    this.tfover = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfoverFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTfoverFromWindProtectionIECEvent");
    this.tfover = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfunderToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignTfunderToWindProtectionIECEvent");
    this.tfunder = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfunderFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTfunderFromWindProtectionIECEvent");
    this.tfunder = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuoverToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignTuoverToWindProtectionIECEvent");
    this.tuover = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuoverFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTuoverFromWindProtectionIECEvent");
    this.tuover = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuunderToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignTuunderToWindProtectionIECEvent");
    this.tuunder = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuunderFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTuunderFromWindProtectionIECEvent");
    this.tuunder = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoverToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignUoverToWindProtectionIECEvent");
    this.uover = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoverFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUoverFromWindProtectionIECEvent");
    this.uover = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUunderToWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing AssignUunderToWindProtectionIECEvent");
    this.uunder = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUunderFromWindProtectionIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUunderFromWindProtectionIECEvent");
    this.uunder = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windProtectionIECId;

  private PU fover = null;
  private PU funder = null;
  private Seconds tfover = null;
  private Seconds tfunder = null;
  private Seconds tuover = null;
  private Seconds tuunder = null;
  private PU uover = null;
  private PU uunder = null;

  private static final Logger LOGGER = Logger.getLogger(WindProtectionIECAggregate.class.getName());
}
