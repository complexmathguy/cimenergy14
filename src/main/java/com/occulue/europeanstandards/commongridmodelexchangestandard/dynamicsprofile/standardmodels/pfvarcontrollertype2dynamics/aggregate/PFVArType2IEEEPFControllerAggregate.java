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
 * Aggregate handler for PFVArType2IEEEPFController as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArType2IEEEPFController are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArType2IEEEPFControllerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArType2IEEEPFControllerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArType2IEEEPFControllerAggregate(CreatePFVArType2IEEEPFControllerCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArType2IEEEPFControllerCommand");
    CreatePFVArType2IEEEPFControllerEvent event =
        new CreatePFVArType2IEEEPFControllerEvent(command.getPFVArType2IEEEPFControllerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArType2IEEEPFControllerCommand");
    UpdatePFVArType2IEEEPFControllerEvent event =
        new UpdatePFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(),
            command.getExlon(),
            command.getKi(),
            command.getKp(),
            command.getPfref(),
            command.getVclmt(),
            command.getVref(),
            command.getVs());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArType2IEEEPFControllerCommand");
    apply(new DeletePFVArType2IEEEPFControllerEvent(command.getPFVArType2IEEEPFControllerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignExlonToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignExlonToPFVArType2IEEEPFControllerCommand");

    if (exlon != null && exlon.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exlon already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignExlonToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExlonFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExlonFromPFVArType2IEEEPFControllerCommand");

    if (exlon == null) throw new ProcessingException("Exlon already has nothing assigned.");

    apply(
        new UnAssignExlonFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignKiToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToPFVArType2IEEEPFControllerCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKiToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromPFVArType2IEEEPFControllerCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(
        new UnAssignKiFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignKpToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToPFVArType2IEEEPFControllerCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKpToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromPFVArType2IEEEPFControllerCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(
        new UnAssignKpFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignPfrefToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignPfrefToPFVArType2IEEEPFControllerCommand");

    if (pfref != null && pfref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pfref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPfrefToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPfrefFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPfrefFromPFVArType2IEEEPFControllerCommand");

    if (pfref == null) throw new ProcessingException("Pfref already has nothing assigned.");

    apply(
        new UnAssignPfrefFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVclmtToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVclmtToPFVArType2IEEEPFControllerCommand");

    if (vclmt != null && vclmt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vclmt already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVclmtToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVclmtFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVclmtFromPFVArType2IEEEPFControllerCommand");

    if (vclmt == null) throw new ProcessingException("Vclmt already has nothing assigned.");

    apply(
        new UnAssignVclmtFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVrefToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrefToPFVArType2IEEEPFControllerCommand");

    if (vref != null && vref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVrefToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrefFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrefFromPFVArType2IEEEPFControllerCommand");

    if (vref == null) throw new ProcessingException("Vref already has nothing assigned.");

    apply(
        new UnAssignVrefFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVsToPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsToPFVArType2IEEEPFControllerCommand");

    if (vs != null && vs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVsToPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsFromPFVArType2IEEEPFControllerCommand");

    if (vs == null) throw new ProcessingException("Vs already has nothing assigned.");

    apply(
        new UnAssignVsFromPFVArType2IEEEPFControllerEvent(
            command.getPFVArType2IEEEPFControllerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing CreatePFVArType2IEEEPFControllerEvent");
    this.pFVArType2IEEEPFControllerId = event.getPFVArType2IEEEPFControllerId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.exlon = event.getExlon();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.pfref = event.getPfref();
    this.vclmt = event.getVclmt();
    this.vref = event.getVref();
    this.vs = event.getVs();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignExlonToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignExlonToPFVArType2IEEEPFControllerEvent");
    this.exlon = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExlonFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignExlonFromPFVArType2IEEEPFControllerEvent");
    this.exlon = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignKiToPFVArType2IEEEPFControllerEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromPFVArType2IEEEPFControllerEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignKpToPFVArType2IEEEPFControllerEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromPFVArType2IEEEPFControllerEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPfrefToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignPfrefToPFVArType2IEEEPFControllerEvent");
    this.pfref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPfrefFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignPfrefFromPFVArType2IEEEPFControllerEvent");
    this.pfref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVclmtToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVclmtToPFVArType2IEEEPFControllerEvent");
    this.vclmt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVclmtFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVclmtFromPFVArType2IEEEPFControllerEvent");
    this.vclmt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrefToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVrefToPFVArType2IEEEPFControllerEvent");
    this.vref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrefFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVrefFromPFVArType2IEEEPFControllerEvent");
    this.vref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsToPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVsToPFVArType2IEEEPFControllerEvent");
    this.vs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsFromPFVArType2IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVsFromPFVArType2IEEEPFControllerEvent");
    this.vs = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArType2IEEEPFControllerId;

  private BooleanProxy exlon = null;
  private PU ki = null;
  private PU kp = null;
  private PU pfref = null;
  private PU vclmt = null;
  private PU vref = null;
  private Simple_Float vs = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEPFControllerAggregate.class.getName());
}
