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
 * Aggregate handler for PFVArType1IEEEVArController as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArType1IEEEVArController are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArType1IEEEVArControllerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArType1IEEEVArControllerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArType1IEEEVArControllerAggregate(CreatePFVArType1IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArType1IEEEVArControllerCommand");
    CreatePFVArType1IEEEVArControllerEvent event =
        new CreatePFVArType1IEEEVArControllerEvent(command.getPFVArType1IEEEVArControllerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArType1IEEEVArControllerCommand");
    UpdatePFVArType1IEEEVArControllerEvent event =
        new UpdatePFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(),
            command.getTvarc(),
            command.getVvar(),
            command.getVvarcbw(),
            command.getVvarref(),
            command.getVvtmax(),
            command.getVvtmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArType1IEEEVArControllerCommand");
    apply(new DeletePFVArType1IEEEVArControllerEvent(command.getPFVArType1IEEEVArControllerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTvarcToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvarcToPFVArType1IEEEVArControllerCommand");

    if (tvarc != null && tvarc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tvarc already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTvarcToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvarcFromPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvarcFromPFVArType1IEEEVArControllerCommand");

    if (tvarc == null) throw new ProcessingException("Tvarc already has nothing assigned.");

    apply(
        new UnAssignTvarcFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvarToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvarToPFVArType1IEEEVArControllerCommand");

    if (vvar != null && vvar.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvar already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvarToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvarFromPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVvarFromPFVArType1IEEEVArControllerCommand");

    if (vvar == null) throw new ProcessingException("Vvar already has nothing assigned.");

    apply(
        new UnAssignVvarFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvarcbwToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvarcbwToPFVArType1IEEEVArControllerCommand");

    if (vvarcbw != null
        && vvarcbw.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vvarcbw already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVvarcbwToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand");

    if (vvarcbw == null) throw new ProcessingException("Vvarcbw already has nothing assigned.");

    apply(
        new UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvarrefToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvarrefToPFVArType1IEEEVArControllerCommand");

    if (vvarref != null && vvarref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvarref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvarrefToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand");

    if (vvarref == null) throw new ProcessingException("Vvarref already has nothing assigned.");

    apply(
        new UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvtmaxToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvtmaxToPFVArType1IEEEVArControllerCommand");

    if (vvtmax != null && vvtmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvtmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvtmaxToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand");

    if (vvtmax == null) throw new ProcessingException("Vvtmax already has nothing assigned.");

    apply(
        new UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  @CommandHandler
  public void handle(AssignVvtminToPFVArType1IEEEVArControllerCommand command) throws Exception {
    LOGGER.info("Handling command AssignVvtminToPFVArType1IEEEVArControllerCommand");

    if (vvtmin != null && vvtmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vvtmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVvtminToPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVvtminFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVvtminFromPFVArType1IEEEVArControllerCommand");

    if (vvtmin == null) throw new ProcessingException("Vvtmin already has nothing assigned.");

    apply(
        new UnAssignVvtminFromPFVArType1IEEEVArControllerEvent(
            command.getPFVArType1IEEEVArControllerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing CreatePFVArType1IEEEVArControllerEvent");
    this.pFVArType1IEEEVArControllerId = event.getPFVArType1IEEEVArControllerId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.tvarc = event.getTvarc();
    this.vvar = event.getVvar();
    this.vvarcbw = event.getVvarcbw();
    this.vvarref = event.getVvarref();
    this.vvtmax = event.getVvtmax();
    this.vvtmin = event.getVvtmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTvarcToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignTvarcToPFVArType1IEEEVArControllerEvent");
    this.tvarc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvarcFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignTvarcFromPFVArType1IEEEVArControllerEvent");
    this.tvarc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvarToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvarToPFVArType1IEEEVArControllerEvent");
    this.vvar = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvarFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvarFromPFVArType1IEEEVArControllerEvent");
    this.vvar = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvarcbwToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvarcbwToPFVArType1IEEEVArControllerEvent");
    this.vvarcbw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent");
    this.vvarcbw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvarrefToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvarrefToPFVArType1IEEEVArControllerEvent");
    this.vvarref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent");
    this.vvarref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvtmaxToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvtmaxToPFVArType1IEEEVArControllerEvent");
    this.vvtmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent");
    this.vvtmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVvtminToPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing AssignVvtminToPFVArType1IEEEVArControllerEvent");
    this.vvtmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVvtminFromPFVArType1IEEEVArControllerEvent event) {
    LOGGER.info("Event sourcing UnAssignVvtminFromPFVArType1IEEEVArControllerEvent");
    this.vvtmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArType1IEEEVArControllerId;

  private Seconds tvarc = null;
  private PU vvar = null;
  private Simple_Float vvarcbw = null;
  private PU vvarref = null;
  private PU vvtmax = null;
  private PU vvtmin = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEVArControllerAggregate.class.getName());
}
