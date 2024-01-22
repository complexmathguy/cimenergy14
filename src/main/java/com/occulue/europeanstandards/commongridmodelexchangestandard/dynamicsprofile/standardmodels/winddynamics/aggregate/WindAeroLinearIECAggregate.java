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
 * Aggregate handler for WindAeroLinearIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindAeroLinearIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindAeroLinearIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindAeroLinearIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindAeroLinearIECAggregate(CreateWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindAeroLinearIECCommand");
    CreateWindAeroLinearIECEvent event =
        new CreateWindAeroLinearIECEvent(command.getWindAeroLinearIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindAeroLinearIECCommand");
    UpdateWindAeroLinearIECEvent event =
        new UpdateWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(),
            command.getDpomega(),
            command.getDptheta(),
            command.getOmegazero(),
            command.getPavail(),
            command.getThetazero());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindAeroLinearIECCommand");
    apply(new DeleteWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDpomegaToWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpomegaToWindAeroLinearIECCommand");

    if (dpomega != null && dpomega.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpomega already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDpomegaToWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpomegaFromWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpomegaFromWindAeroLinearIECCommand");

    if (dpomega == null) throw new ProcessingException("Dpomega already has nothing assigned.");

    apply(new UnAssignDpomegaFromWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  @CommandHandler
  public void handle(AssignDpthetaToWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpthetaToWindAeroLinearIECCommand");

    if (dptheta != null && dptheta.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dptheta already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDpthetaToWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpthetaFromWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpthetaFromWindAeroLinearIECCommand");

    if (dptheta == null) throw new ProcessingException("Dptheta already has nothing assigned.");

    apply(new UnAssignDpthetaFromWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  @CommandHandler
  public void handle(AssignOmegazeroToWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmegazeroToWindAeroLinearIECCommand");

    if (omegazero != null && omegazero.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Omegazero already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignOmegazeroToWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmegazeroFromWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmegazeroFromWindAeroLinearIECCommand");

    if (omegazero == null) throw new ProcessingException("Omegazero already has nothing assigned.");

    apply(new UnAssignOmegazeroFromWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  @CommandHandler
  public void handle(AssignPavailToWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPavailToWindAeroLinearIECCommand");

    if (pavail != null && pavail.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pavail already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPavailToWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPavailFromWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPavailFromWindAeroLinearIECCommand");

    if (pavail == null) throw new ProcessingException("Pavail already has nothing assigned.");

    apply(new UnAssignPavailFromWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  @CommandHandler
  public void handle(AssignThetazeroToWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignThetazeroToWindAeroLinearIECCommand");

    if (thetazero != null
        && thetazero.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetazero already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignThetazeroToWindAeroLinearIECEvent(
            command.getWindAeroLinearIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetazeroFromWindAeroLinearIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetazeroFromWindAeroLinearIECCommand");

    if (thetazero == null) throw new ProcessingException("Thetazero already has nothing assigned.");

    apply(new UnAssignThetazeroFromWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing CreateWindAeroLinearIECEvent");
    this.windAeroLinearIECId = event.getWindAeroLinearIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dpomega = event.getDpomega();
    this.dptheta = event.getDptheta();
    this.omegazero = event.getOmegazero();
    this.pavail = event.getPavail();
    this.thetazero = event.getThetazero();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDpomegaToWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing AssignDpomegaToWindAeroLinearIECEvent");
    this.dpomega = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpomegaFromWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDpomegaFromWindAeroLinearIECEvent");
    this.dpomega = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDpthetaToWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing AssignDpthetaToWindAeroLinearIECEvent");
    this.dptheta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpthetaFromWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDpthetaFromWindAeroLinearIECEvent");
    this.dptheta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmegazeroToWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing AssignOmegazeroToWindAeroLinearIECEvent");
    this.omegazero = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmegazeroFromWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing UnAssignOmegazeroFromWindAeroLinearIECEvent");
    this.omegazero = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPavailToWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing AssignPavailToWindAeroLinearIECEvent");
    this.pavail = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPavailFromWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing UnAssignPavailFromWindAeroLinearIECEvent");
    this.pavail = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetazeroToWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing AssignThetazeroToWindAeroLinearIECEvent");
    this.thetazero = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetazeroFromWindAeroLinearIECEvent event) {
    LOGGER.info("Event sourcing UnAssignThetazeroFromWindAeroLinearIECEvent");
    this.thetazero = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windAeroLinearIECId;

  private PU dpomega = null;
  private PU dptheta = null;
  private PU omegazero = null;
  private PU pavail = null;
  private AngleDegrees thetazero = null;

  private static final Logger LOGGER = Logger.getLogger(WindAeroLinearIECAggregate.class.getName());
}
