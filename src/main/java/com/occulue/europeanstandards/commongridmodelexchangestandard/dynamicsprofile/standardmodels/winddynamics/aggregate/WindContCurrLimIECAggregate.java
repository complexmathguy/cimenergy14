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
 * Aggregate handler for WindContCurrLimIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContCurrLimIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContCurrLimIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContCurrLimIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContCurrLimIECAggregate(CreateWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContCurrLimIECCommand");
    CreateWindContCurrLimIECEvent event =
        new CreateWindContCurrLimIECEvent(command.getWindContCurrLimIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContCurrLimIECCommand");
    UpdateWindContCurrLimIECEvent event =
        new UpdateWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(),
            command.getImax(),
            command.getImaxdip(),
            command.getMdfslim(),
            command.getMqpri(),
            command.getTufilt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContCurrLimIECCommand");
    apply(new DeleteWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignImaxToWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignImaxToWindContCurrLimIECCommand");

    if (imax != null && imax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Imax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignImaxToWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignImaxFromWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignImaxFromWindContCurrLimIECCommand");

    if (imax == null) throw new ProcessingException("Imax already has nothing assigned.");

    apply(new UnAssignImaxFromWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  @CommandHandler
  public void handle(AssignImaxdipToWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignImaxdipToWindContCurrLimIECCommand");

    if (imaxdip != null && imaxdip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Imaxdip already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignImaxdipToWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignImaxdipFromWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignImaxdipFromWindContCurrLimIECCommand");

    if (imaxdip == null) throw new ProcessingException("Imaxdip already has nothing assigned.");

    apply(new UnAssignImaxdipFromWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  @CommandHandler
  public void handle(AssignMdfslimToWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMdfslimToWindContCurrLimIECCommand");

    if (mdfslim != null
        && mdfslim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mdfslim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMdfslimToWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMdfslimFromWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMdfslimFromWindContCurrLimIECCommand");

    if (mdfslim == null) throw new ProcessingException("Mdfslim already has nothing assigned.");

    apply(new UnAssignMdfslimFromWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  @CommandHandler
  public void handle(AssignMqpriToWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMqpriToWindContCurrLimIECCommand");

    if (mqpri != null && mqpri.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mqpri already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMqpriToWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMqpriFromWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMqpriFromWindContCurrLimIECCommand");

    if (mqpri == null) throw new ProcessingException("Mqpri already has nothing assigned.");

    apply(new UnAssignMqpriFromWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  @CommandHandler
  public void handle(AssignTufiltToWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTufiltToWindContCurrLimIECCommand");

    if (tufilt != null && tufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTufiltToWindContCurrLimIECEvent(
            command.getWindContCurrLimIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTufiltFromWindContCurrLimIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTufiltFromWindContCurrLimIECCommand");

    if (tufilt == null) throw new ProcessingException("Tufilt already has nothing assigned.");

    apply(new UnAssignTufiltFromWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContCurrLimIECEvent");
    this.windContCurrLimIECId = event.getWindContCurrLimIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.imax = event.getImax();
    this.imaxdip = event.getImaxdip();
    this.mdfslim = event.getMdfslim();
    this.mqpri = event.getMqpri();
    this.tufilt = event.getTufilt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignImaxToWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing AssignImaxToWindContCurrLimIECEvent");
    this.imax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignImaxFromWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing UnAssignImaxFromWindContCurrLimIECEvent");
    this.imax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignImaxdipToWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing AssignImaxdipToWindContCurrLimIECEvent");
    this.imaxdip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignImaxdipFromWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing UnAssignImaxdipFromWindContCurrLimIECEvent");
    this.imaxdip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMdfslimToWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing AssignMdfslimToWindContCurrLimIECEvent");
    this.mdfslim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMdfslimFromWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing UnAssignMdfslimFromWindContCurrLimIECEvent");
    this.mdfslim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMqpriToWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing AssignMqpriToWindContCurrLimIECEvent");
    this.mqpri = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMqpriFromWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing UnAssignMqpriFromWindContCurrLimIECEvent");
    this.mqpri = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTufiltToWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing AssignTufiltToWindContCurrLimIECEvent");
    this.tufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTufiltFromWindContCurrLimIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTufiltFromWindContCurrLimIECEvent");
    this.tufilt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContCurrLimIECId;

  private PU imax = null;
  private PU imaxdip = null;
  private BooleanProxy mdfslim = null;
  private BooleanProxy mqpri = null;
  private Seconds tufilt = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindContCurrLimIECAggregate.class.getName());
}
