package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.aggregate;

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
 * Aggregate handler for PFVArType2Common1 as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArType2Common1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArType2Common1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArType2Common1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArType2Common1Aggregate(CreatePFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command CreatePFVArType2Common1Command");
    CreatePFVArType2Common1Event event =
        new CreatePFVArType2Common1Event(command.getPFVArType2Common1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArType2Common1Command command) throws Exception {
    LOGGER.info("handling command UpdatePFVArType2Common1Command");
    UpdatePFVArType2Common1Event event =
        new UpdatePFVArType2Common1Event(
            command.getPFVArType2Common1Id(),
            command.getJ(),
            command.getKi(),
            command.getKp(),
            command.getMax(),
            command.getRef());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command DeletePFVArType2Common1Command");
    apply(new DeletePFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignJToPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command AssignJToPFVArType2Common1Command");

    if (j != null && j.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "J already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignJToPFVArType2Common1Event(
            command.getPFVArType2Common1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignJFromPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignJFromPFVArType2Common1Command");

    if (j == null) throw new ProcessingException("J already has nothing assigned.");

    apply(new UnAssignJFromPFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  @CommandHandler
  public void handle(AssignKiToPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command AssignKiToPFVArType2Common1Command");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKiToPFVArType2Common1Event(
            command.getPFVArType2Common1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromPFVArType2Common1Command");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromPFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  @CommandHandler
  public void handle(AssignKpToPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command AssignKpToPFVArType2Common1Command");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpToPFVArType2Common1Event(
            command.getPFVArType2Common1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromPFVArType2Common1Command");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromPFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  @CommandHandler
  public void handle(AssignMaxToPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command AssignMaxToPFVArType2Common1Command");

    if (max != null && max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Max already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignMaxToPFVArType2Common1Event(
            command.getPFVArType2Common1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxFromPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxFromPFVArType2Common1Command");

    if (max == null) throw new ProcessingException("Max already has nothing assigned.");

    apply(new UnAssignMaxFromPFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  @CommandHandler
  public void handle(AssignRefToPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handling command AssignRefToPFVArType2Common1Command");

    if (ref != null && ref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRefToPFVArType2Common1Event(
            command.getPFVArType2Common1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRefFromPFVArType2Common1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRefFromPFVArType2Common1Command");

    if (ref == null) throw new ProcessingException("Ref already has nothing assigned.");

    apply(new UnAssignRefFromPFVArType2Common1Event(command.getPFVArType2Common1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArType2Common1Event event) {
    LOGGER.info("Event sourcing CreatePFVArType2Common1Event");
    this.pFVArType2Common1Id = event.getPFVArType2Common1Id();
  }

  @EventSourcingHandler
  void on(UpdatePFVArType2Common1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.j = event.getJ();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.max = event.getMax();
    this.ref = event.getRef();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignJToPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing AssignJToPFVArType2Common1Event");
    this.j = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignJFromPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing UnAssignJFromPFVArType2Common1Event");
    this.j = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing AssignKiToPFVArType2Common1Event");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing UnAssignKiFromPFVArType2Common1Event");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing AssignKpToPFVArType2Common1Event");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing UnAssignKpFromPFVArType2Common1Event");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxToPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing AssignMaxToPFVArType2Common1Event");
    this.max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxFromPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing UnAssignMaxFromPFVArType2Common1Event");
    this.max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRefToPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing AssignRefToPFVArType2Common1Event");
    this.ref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRefFromPFVArType2Common1Event event) {
    LOGGER.info("Event sourcing UnAssignRefFromPFVArType2Common1Event");
    this.ref = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArType2Common1Id;

  private BooleanProxy j = null;
  private PU ki = null;
  private PU kp = null;
  private PU max = null;
  private PU ref = null;

  private static final Logger LOGGER = Logger.getLogger(PFVArType2Common1Aggregate.class.getName());
}
