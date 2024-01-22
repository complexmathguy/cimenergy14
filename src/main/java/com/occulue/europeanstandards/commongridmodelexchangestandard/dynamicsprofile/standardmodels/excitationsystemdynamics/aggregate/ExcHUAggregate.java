package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcHU as outlined for the CQRS pattern, all write responsibilities related
 * to ExcHU are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcHUAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcHUAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcHUAggregate(CreateExcHUCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcHUCommand");
    CreateExcHUEvent event = new CreateExcHUEvent(command.getExcHUId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcHUCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcHUCommand");
    UpdateExcHUEvent event =
        new UpdateExcHUEvent(
            command.getExcHUId(),
            command.getAe(),
            command.getAi(),
            command.getAtr(),
            command.getEmax(),
            command.getEmin(),
            command.getImax(),
            command.getImin(),
            command.getKe(),
            command.getKi(),
            command.getTe(),
            command.getTi(),
            command.getTr());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcHUCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcHUCommand");
    apply(new DeleteExcHUEvent(command.getExcHUId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAeToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignAeToExcHUCommand");

    if (ae != null && ae.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ae already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAeToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAeFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAeFromExcHUCommand");

    if (ae == null) throw new ProcessingException("Ae already has nothing assigned.");

    apply(new UnAssignAeFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignAiToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignAiToExcHUCommand");

    if (ai != null && ai.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ai already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAiToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAiFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAiFromExcHUCommand");

    if (ai == null) throw new ProcessingException("Ai already has nothing assigned.");

    apply(new UnAssignAiFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignAtrToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignAtrToExcHUCommand");

    if (atr != null && atr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Atr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtrToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtrFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtrFromExcHUCommand");

    if (atr == null) throw new ProcessingException("Atr already has nothing assigned.");

    apply(new UnAssignAtrFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignEmaxToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignEmaxToExcHUCommand");

    if (emax != null && emax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEmaxToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEmaxFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEmaxFromExcHUCommand");

    if (emax == null) throw new ProcessingException("Emax already has nothing assigned.");

    apply(new UnAssignEmaxFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignEminToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignEminToExcHUCommand");

    if (emin != null && emin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEminToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEminFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEminFromExcHUCommand");

    if (emin == null) throw new ProcessingException("Emin already has nothing assigned.");

    apply(new UnAssignEminFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignImaxToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignImaxToExcHUCommand");

    if (imax != null && imax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Imax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignImaxToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignImaxFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignImaxFromExcHUCommand");

    if (imax == null) throw new ProcessingException("Imax already has nothing assigned.");

    apply(new UnAssignImaxFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignIminToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignIminToExcHUCommand");

    if (imin != null && imin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Imin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIminToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIminFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIminFromExcHUCommand");

    if (imin == null) throw new ProcessingException("Imin already has nothing assigned.");

    apply(new UnAssignIminFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcHUCommand");

    if (ke != null && ke.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKeToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcHUCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcHUCommand");

    if (ki != null && ki.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKiToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcHUCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcHUCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcHUCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignTiToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTiToExcHUCommand");

    if (ti != null && ti.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiFromExcHUCommand");

    if (ti == null) throw new ProcessingException("Ti already has nothing assigned.");

    apply(new UnAssignTiFromExcHUEvent(command.getExcHUId()));
  }

  @CommandHandler
  public void handle(AssignTrToExcHUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTrToExcHUCommand");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToExcHUEvent(command.getExcHUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromExcHUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromExcHUCommand");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromExcHUEvent(command.getExcHUId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcHUEvent event) {
    LOGGER.info("Event sourcing CreateExcHUEvent");
    this.excHUId = event.getExcHUId();
  }

  @EventSourcingHandler
  void on(UpdateExcHUEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ae = event.getAe();
    this.ai = event.getAi();
    this.atr = event.getAtr();
    this.emax = event.getEmax();
    this.emin = event.getEmin();
    this.imax = event.getImax();
    this.imin = event.getImin();
    this.ke = event.getKe();
    this.ki = event.getKi();
    this.te = event.getTe();
    this.ti = event.getTi();
    this.tr = event.getTr();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAeToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignAeToExcHUEvent");
    this.ae = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAeFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignAeFromExcHUEvent");
    this.ae = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAiToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignAiToExcHUEvent");
    this.ai = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAiFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignAiFromExcHUEvent");
    this.ai = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAtrToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignAtrToExcHUEvent");
    this.atr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtrFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignAtrFromExcHUEvent");
    this.atr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEmaxToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignEmaxToExcHUEvent");
    this.emax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEmaxFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignEmaxFromExcHUEvent");
    this.emax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEminToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignEminToExcHUEvent");
    this.emin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEminFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignEminFromExcHUEvent");
    this.emin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignImaxToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignImaxToExcHUEvent");
    this.imax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignImaxFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignImaxFromExcHUEvent");
    this.imax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIminToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignIminToExcHUEvent");
    this.imin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIminFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignIminFromExcHUEvent");
    this.imin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcHUEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcHUEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcHUEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcHUEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcHUEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcHUEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignTiToExcHUEvent");
    this.ti = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignTiFromExcHUEvent");
    this.ti = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToExcHUEvent event) {
    LOGGER.info("Event sourcing AssignTrToExcHUEvent");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromExcHUEvent event) {
    LOGGER.info("Event sourcing UnAssignTrFromExcHUEvent");
    this.tr = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excHUId;

  private PU ae = null;
  private PU ai = null;
  private PU atr = null;
  private PU emax = null;
  private PU emin = null;
  private PU imax = null;
  private PU imin = null;
  private Simple_Float ke = null;
  private Simple_Float ki = null;
  private Seconds te = null;
  private Seconds ti = null;
  private Seconds tr = null;

  private static final Logger LOGGER = Logger.getLogger(ExcHUAggregate.class.getName());
}
