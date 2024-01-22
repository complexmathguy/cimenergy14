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
 * Aggregate handler for WindContPitchAngleIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContPitchAngleIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContPitchAngleIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContPitchAngleIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContPitchAngleIECAggregate(CreateWindContPitchAngleIECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindContPitchAngleIECCommand");
    CreateWindContPitchAngleIECEvent event =
        new CreateWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContPitchAngleIECCommand");
    UpdateWindContPitchAngleIECEvent event =
        new UpdateWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(),
            command.getDthetamax(),
            command.getDthetamin(),
            command.getKic(),
            command.getKiomega(),
            command.getKpc(),
            command.getKpomega(),
            command.getKpx(),
            command.getThetamax(),
            command.getThetamin(),
            command.getTtheta());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContPitchAngleIECCommand");
    apply(new DeleteWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDthetamaxToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDthetamaxToWindContPitchAngleIECCommand");

    if (dthetamax != null
        && dthetamax.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Dthetamax already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignDthetamaxToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDthetamaxFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDthetamaxFromWindContPitchAngleIECCommand");

    if (dthetamax == null) throw new ProcessingException("Dthetamax already has nothing assigned.");

    apply(
        new UnAssignDthetamaxFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignDthetaminToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDthetaminToWindContPitchAngleIECCommand");

    if (dthetamin != null
        && dthetamin.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Dthetamin already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignDthetaminToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDthetaminFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDthetaminFromWindContPitchAngleIECCommand");

    if (dthetamin == null) throw new ProcessingException("Dthetamin already has nothing assigned.");

    apply(
        new UnAssignDthetaminFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignKicToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKicToWindContPitchAngleIECCommand");

    if (kic != null && kic.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kic already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKicToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKicFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKicFromWindContPitchAngleIECCommand");

    if (kic == null) throw new ProcessingException("Kic already has nothing assigned.");

    apply(new UnAssignKicFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignKiomegaToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiomegaToWindContPitchAngleIECCommand");

    if (kiomega != null && kiomega.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kiomega already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKiomegaToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiomegaFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiomegaFromWindContPitchAngleIECCommand");

    if (kiomega == null) throw new ProcessingException("Kiomega already has nothing assigned.");

    apply(new UnAssignKiomegaFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignKpcToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpcToWindContPitchAngleIECCommand");

    if (kpc != null && kpc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpcToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpcFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpcFromWindContPitchAngleIECCommand");

    if (kpc == null) throw new ProcessingException("Kpc already has nothing assigned.");

    apply(new UnAssignKpcFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignKpomegaToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpomegaToWindContPitchAngleIECCommand");

    if (kpomega != null && kpomega.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpomega already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpomegaToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpomegaFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpomegaFromWindContPitchAngleIECCommand");

    if (kpomega == null) throw new ProcessingException("Kpomega already has nothing assigned.");

    apply(new UnAssignKpomegaFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignKpxToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpxToWindContPitchAngleIECCommand");

    if (kpx != null && kpx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpx already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpxToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpxFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpxFromWindContPitchAngleIECCommand");

    if (kpx == null) throw new ProcessingException("Kpx already has nothing assigned.");

    apply(new UnAssignKpxFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignThetamaxToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignThetamaxToWindContPitchAngleIECCommand");

    if (thetamax != null
        && thetamax.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetamax already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignThetamaxToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetamaxFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetamaxFromWindContPitchAngleIECCommand");

    if (thetamax == null) throw new ProcessingException("Thetamax already has nothing assigned.");

    apply(new UnAssignThetamaxFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignThetaminToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignThetaminToWindContPitchAngleIECCommand");

    if (thetamin != null
        && thetamin.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetamin already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignThetaminToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetaminFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetaminFromWindContPitchAngleIECCommand");

    if (thetamin == null) throw new ProcessingException("Thetamin already has nothing assigned.");

    apply(new UnAssignThetaminFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  @CommandHandler
  public void handle(AssignTthetaToWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTthetaToWindContPitchAngleIECCommand");

    if (ttheta != null && ttheta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ttheta already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTthetaToWindContPitchAngleIECEvent(
            command.getWindContPitchAngleIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTthetaFromWindContPitchAngleIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTthetaFromWindContPitchAngleIECCommand");

    if (ttheta == null) throw new ProcessingException("Ttheta already has nothing assigned.");

    apply(new UnAssignTthetaFromWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContPitchAngleIECEvent");
    this.windContPitchAngleIECId = event.getWindContPitchAngleIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dthetamax = event.getDthetamax();
    this.dthetamin = event.getDthetamin();
    this.kic = event.getKic();
    this.kiomega = event.getKiomega();
    this.kpc = event.getKpc();
    this.kpomega = event.getKpomega();
    this.kpx = event.getKpx();
    this.thetamax = event.getThetamax();
    this.thetamin = event.getThetamin();
    this.ttheta = event.getTtheta();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDthetamaxToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignDthetamaxToWindContPitchAngleIECEvent");
    this.dthetamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDthetamaxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDthetamaxFromWindContPitchAngleIECEvent");
    this.dthetamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDthetaminToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignDthetaminToWindContPitchAngleIECEvent");
    this.dthetamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDthetaminFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDthetaminFromWindContPitchAngleIECEvent");
    this.dthetamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKicToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignKicToWindContPitchAngleIECEvent");
    this.kic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKicFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKicFromWindContPitchAngleIECEvent");
    this.kic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiomegaToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignKiomegaToWindContPitchAngleIECEvent");
    this.kiomega = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiomegaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKiomegaFromWindContPitchAngleIECEvent");
    this.kiomega = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpcToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignKpcToWindContPitchAngleIECEvent");
    this.kpc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpcFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpcFromWindContPitchAngleIECEvent");
    this.kpc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpomegaToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignKpomegaToWindContPitchAngleIECEvent");
    this.kpomega = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpomegaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpomegaFromWindContPitchAngleIECEvent");
    this.kpomega = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpxToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignKpxToWindContPitchAngleIECEvent");
    this.kpx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpxFromWindContPitchAngleIECEvent");
    this.kpx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetamaxToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignThetamaxToWindContPitchAngleIECEvent");
    this.thetamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetamaxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignThetamaxFromWindContPitchAngleIECEvent");
    this.thetamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetaminToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignThetaminToWindContPitchAngleIECEvent");
    this.thetamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetaminFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignThetaminFromWindContPitchAngleIECEvent");
    this.thetamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTthetaToWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing AssignTthetaToWindContPitchAngleIECEvent");
    this.ttheta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTthetaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTthetaFromWindContPitchAngleIECEvent");
    this.ttheta = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContPitchAngleIECId;

  private Simple_Float dthetamax = null;
  private Simple_Float dthetamin = null;
  private PU kic = null;
  private PU kiomega = null;
  private PU kpc = null;
  private PU kpomega = null;
  private PU kpx = null;
  private AngleDegrees thetamax = null;
  private AngleDegrees thetamin = null;
  private Seconds ttheta = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPitchAngleIECAggregate.class.getName());
}
