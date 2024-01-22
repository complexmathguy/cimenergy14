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
 * Aggregate handler for PFVArType2IEEEVArController as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArType2IEEEVArController are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArType2IEEEVArControllerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArType2IEEEVArControllerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArType2IEEEVArControllerAggregate(CreatePFVArType2IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArType2IEEEVArControllerCommand");
    CreatePFVArType2IEEEVArControllerEvent event =
        new CreatePFVArType2IEEEVArControllerEvent(command.getPFVArType2IEEEVArControllerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArType2IEEEVArControllerCommand");
    UpdatePFVArType2IEEEVArControllerEvent event =
        new UpdatePFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(),
            command.getExlon(),
            command.getKi(),
            command.getKp(),
            command.getQref(),
            command.getVclmt(),
            command.getVref(),
            command.getVs());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArType2IEEEVArControllerCommand");
    apply(new DeletePFVArType2IEEEVArControllerEvent(command.getPFVArType2IEEEVArControllerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignExlonToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignExlonToPFVArType2IEEEVArControllerCommand");

    if (exlon != null && exlon.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exlon already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignExlonToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExlonFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExlonFromPFVArType2IEEEVArControllerCommand");

    if (exlon == null) throw new ProcessingException("Exlon already has nothing assigned.");

    apply(
        new UnAssignExlonFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignKiToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToPFVArType2IEEEVArControllerCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKiToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromPFVArType2IEEEVArControllerCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(
        new UnAssignKiFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignKpToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToPFVArType2IEEEVArControllerCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromPFVArType2IEEEVArControllerCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(
        new UnAssignKpFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignQrefToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignQrefToPFVArType2IEEEVArControllerCommand");

    if (qref != null && qref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQrefToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQrefFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQrefFromPFVArType2IEEEVArControllerCommand");

    if (qref == null) throw new ProcessingException("Qref already has nothing assigned.");

    apply(
        new UnAssignQrefFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVclmtToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVclmtToPFVArType2IEEEVArControllerCommand");

    if (vclmt != null && vclmt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vclmt already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVclmtToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVclmtFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVclmtFromPFVArType2IEEEVArControllerCommand");

    if (vclmt == null) throw new ProcessingException("Vclmt already has nothing assigned.");

    apply(
        new UnAssignVclmtFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVrefToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrefToPFVArType2IEEEVArControllerCommand");

    if (vref != null && vref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVrefToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrefFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrefFromPFVArType2IEEEVArControllerCommand");

    if (vref == null) throw new ProcessingException("Vref already has nothing assigned.");

    apply(
        new UnAssignVrefFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVsToPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsToPFVArType2IEEEVArControllerCommand");

    if (vs != null && vs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVsToPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsFromPFVArType2IEEEVArControllerCommand");

    if (vs == null) throw new ProcessingException("Vs already has nothing assigned.");

    apply(
        new UnAssignVsFromPFVArType2IEEEVArControllerEvent(
            command.getPFVArType2IEEEVArControllerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing CreatePFVArType2IEEEVArControllerEvent");
    this.pFVArType2IEEEVArControllerId = event.getPFVArType2IEEEVArControllerId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.exlon = event.getExlon();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.qref = event.getQref();
    this.vclmt = event.getVclmt();
    this.vref = event.getVref();
    this.vs = event.getVs();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignExlonToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignExlonToPFVArType2IEEEVArControllerEvent");
    this.exlon = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExlonFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignExlonFromPFVArType2IEEEVArControllerEvent");
    this.exlon = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignKiToPFVArType2IEEEVArControllerEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromPFVArType2IEEEVArControllerEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignKpToPFVArType2IEEEVArControllerEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromPFVArType2IEEEVArControllerEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQrefToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignQrefToPFVArType2IEEEVArControllerEvent");
    this.qref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQrefFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignQrefFromPFVArType2IEEEVArControllerEvent");
    this.qref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVclmtToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVclmtToPFVArType2IEEEVArControllerEvent");
    this.vclmt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVclmtFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVclmtFromPFVArType2IEEEVArControllerEvent");
    this.vclmt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrefToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVrefToPFVArType2IEEEVArControllerEvent");
    this.vref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrefFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVrefFromPFVArType2IEEEVArControllerEvent");
    this.vref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsToPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVsToPFVArType2IEEEVArControllerEvent");
    this.vs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsFromPFVArType2IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVsFromPFVArType2IEEEVArControllerEvent");
    this.vs = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArType2IEEEVArControllerId;

  private BooleanProxy exlon = null;
  private PU ki = null;
  private PU kp = null;
  private PU qref = null;
  private PU vclmt = null;
  private PU vref = null;
  private Simple_Float vs = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEVArControllerAggregate.class.getName());
}
