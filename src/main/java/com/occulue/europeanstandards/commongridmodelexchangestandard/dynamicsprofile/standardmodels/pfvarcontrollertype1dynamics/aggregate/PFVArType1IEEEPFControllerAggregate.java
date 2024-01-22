package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.aggregate;

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
 * Aggregate handler for PFVArType1IEEEPFController as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArType1IEEEPFController are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArType1IEEEPFControllerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArType1IEEEPFControllerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArType1IEEEPFControllerAggregate(CreatePFVArType1IEEEPFControllerCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArType1IEEEPFControllerCommand");
    CreatePFVArType1IEEEPFControllerEvent event =
        new CreatePFVArType1IEEEPFControllerEvent(command.getPFVArType1IEEEPFControllerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArType1IEEEPFControllerCommand");
    UpdatePFVArType1IEEEPFControllerEvent event =
        new UpdatePFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(),
            command.getOvex(),
            command.getTpfc(),
            command.getVitmin(),
            command.getVpf(),
            command.getVpfcbw(),
            command.getVpfref(),
            command.getVvtmax(),
            command.getVvtmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArType1IEEEPFControllerCommand");
    apply(new DeletePFVArType1IEEEPFControllerEvent(command.getPFVArType1IEEEPFControllerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignOvexToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignOvexToPFVArType1IEEEPFControllerCommand");

    if (ovex != null && ovex.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Ovex already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOvexToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOvexFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOvexFromPFVArType1IEEEPFControllerCommand");

    if (ovex == null) throw new ProcessingException("Ovex already has nothing assigned.");

    apply(
        new UnAssignOvexFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignTpfcToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpfcToPFVArType1IEEEPFControllerCommand");

    if (tpfc != null && tpfc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpfc already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpfcToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpfcFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpfcFromPFVArType1IEEEPFControllerCommand");

    if (tpfc == null) throw new ProcessingException("Tpfc already has nothing assigned.");

    apply(
        new UnAssignTpfcFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVitminToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVitminToPFVArType1IEEEPFControllerCommand");

    if (vitmin != null && vitmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vitmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVitminToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVitminFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVitminFromPFVArType1IEEEPFControllerCommand");

    if (vitmin == null) throw new ProcessingException("Vitmin already has nothing assigned.");

    apply(
        new UnAssignVitminFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVpfToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVpfToPFVArType1IEEEPFControllerCommand");

    if (vpf != null && vpf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpf already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVpfToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpfFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpfFromPFVArType1IEEEPFControllerCommand");

    if (vpf == null) throw new ProcessingException("Vpf already has nothing assigned.");

    apply(
        new UnAssignVpfFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVpfcbwToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVpfcbwToPFVArType1IEEEPFControllerCommand");

    if (vpfcbw != null && vpfcbw.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vpfcbw already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVpfcbwToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand");

    if (vpfcbw == null) throw new ProcessingException("Vpfcbw already has nothing assigned.");

    apply(
        new UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVpfrefToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVpfrefToPFVArType1IEEEPFControllerCommand");

    if (vpfref != null && vpfref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpfref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVpfrefToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand");

    if (vpfref == null) throw new ProcessingException("Vpfref already has nothing assigned.");

    apply(
        new UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvtmaxToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvtmaxToPFVArType1IEEEPFControllerCommand");

    if (vvtmax != null && vvtmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvtmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvtmaxToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand");

    if (vvtmax == null) throw new ProcessingException("Vvtmax already has nothing assigned.");

    apply(
        new UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvtminToPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvtminToPFVArType1IEEEPFControllerCommand");

    if (vvtmin != null && vvtmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvtmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvtminToPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvtminFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVvtminFromPFVArType1IEEEPFControllerCommand");

    if (vvtmin == null) throw new ProcessingException("Vvtmin already has nothing assigned.");

    apply(
        new UnAssignVvtminFromPFVArType1IEEEPFControllerEvent(
            command.getPFVArType1IEEEPFControllerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing CreatePFVArType1IEEEPFControllerEvent");
    this.pFVArType1IEEEPFControllerId = event.getPFVArType1IEEEPFControllerId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ovex = event.getOvex();
    this.tpfc = event.getTpfc();
    this.vitmin = event.getVitmin();
    this.vpf = event.getVpf();
    this.vpfcbw = event.getVpfcbw();
    this.vpfref = event.getVpfref();
    this.vvtmax = event.getVvtmax();
    this.vvtmin = event.getVvtmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignOvexToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignOvexToPFVArType1IEEEPFControllerEvent");
    this.ovex = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOvexFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignOvexFromPFVArType1IEEEPFControllerEvent");
    this.ovex = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpfcToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignTpfcToPFVArType1IEEEPFControllerEvent");
    this.tpfc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpfcFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignTpfcFromPFVArType1IEEEPFControllerEvent");
    this.tpfc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVitminToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVitminToPFVArType1IEEEPFControllerEvent");
    this.vitmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVitminFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVitminFromPFVArType1IEEEPFControllerEvent");
    this.vitmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpfToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVpfToPFVArType1IEEEPFControllerEvent");
    this.vpf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpfFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVpfFromPFVArType1IEEEPFControllerEvent");
    this.vpf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpfcbwToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVpfcbwToPFVArType1IEEEPFControllerEvent");
    this.vpfcbw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent");
    this.vpfcbw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpfrefToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVpfrefToPFVArType1IEEEPFControllerEvent");
    this.vpfref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent");
    this.vpfref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvtmaxToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvtmaxToPFVArType1IEEEPFControllerEvent");
    this.vvtmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent");
    this.vvtmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvtminToPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvtminToPFVArType1IEEEPFControllerEvent");
    this.vvtmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvtminFromPFVArType1IEEEPFControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvtminFromPFVArType1IEEEPFControllerEvent");
    this.vvtmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArType1IEEEPFControllerId;

  private BooleanProxy ovex = null;
  private Seconds tpfc = null;
  private PU vitmin = null;
  private PU vpf = null;
  private Simple_Float vpfcbw = null;
  private PU vpfref = null;
  private PU vvtmax = null;
  private PU vvtmin = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEPFControllerAggregate.class.getName());
}
