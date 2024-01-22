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
 * Aggregate handler for ExcSCRX as outlined for the CQRS pattern, all write responsibilities
 * related to ExcSCRX are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcSCRXAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcSCRXAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcSCRXAggregate(CreateExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcSCRXCommand");
    CreateExcSCRXEvent event = new CreateExcSCRXEvent(command.getExcSCRXId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcSCRXCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcSCRXCommand");
    UpdateExcSCRXEvent event =
        new UpdateExcSCRXEvent(
            command.getExcSCRXId(),
            command.getCswitch(),
            command.getEmax(),
            command.getEmin(),
            command.getK(),
            command.getRcrfd(),
            command.getTatb(),
            command.getTb(),
            command.getTe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcSCRXCommand");
    apply(new DeleteExcSCRXEvent(command.getExcSCRXId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCswitchToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignCswitchToExcSCRXCommand");

    if (cswitch != null
        && cswitch.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Cswitch already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignCswitchToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCswitchFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCswitchFromExcSCRXCommand");

    if (cswitch == null) throw new ProcessingException("Cswitch already has nothing assigned.");

    apply(new UnAssignCswitchFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignEmaxToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignEmaxToExcSCRXCommand");

    if (emax != null && emax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEmaxToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEmaxFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEmaxFromExcSCRXCommand");

    if (emax == null) throw new ProcessingException("Emax already has nothing assigned.");

    apply(new UnAssignEmaxFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignEminToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignEminToExcSCRXCommand");

    if (emin != null && emin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEminToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEminFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEminFromExcSCRXCommand");

    if (emin == null) throw new ProcessingException("Emin already has nothing assigned.");

    apply(new UnAssignEminFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignKToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignKToExcSCRXCommand");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromExcSCRXCommand");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignRcrfdToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignRcrfdToExcSCRXCommand");

    if (rcrfd != null && rcrfd.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rcrfd already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRcrfdToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcrfdFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcrfdFromExcSCRXCommand");

    if (rcrfd == null) throw new ProcessingException("Rcrfd already has nothing assigned.");

    apply(new UnAssignRcrfdFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignTatbToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignTatbToExcSCRXCommand");

    if (tatb != null && tatb.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Tatb already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignTatbToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTatbFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTatbFromExcSCRXCommand");

    if (tatb == null) throw new ProcessingException("Tatb already has nothing assigned.");

    apply(new UnAssignTatbFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcSCRXCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcSCRXCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcSCRXEvent(command.getExcSCRXId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcSCRXCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcSCRXCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcSCRXEvent(command.getExcSCRXId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcSCRXCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcSCRXCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcSCRXEvent(command.getExcSCRXId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcSCRXEvent event) {
    LOGGER.info("Event sourcing CreateExcSCRXEvent");
    this.excSCRXId = event.getExcSCRXId();
  }

  @EventSourcingHandler
  void on(UpdateExcSCRXEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.cswitch = event.getCswitch();
    this.emax = event.getEmax();
    this.emin = event.getEmin();
    this.k = event.getK();
    this.rcrfd = event.getRcrfd();
    this.tatb = event.getTatb();
    this.tb = event.getTb();
    this.te = event.getTe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCswitchToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignCswitchToExcSCRXEvent");
    this.cswitch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCswitchFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignCswitchFromExcSCRXEvent");
    this.cswitch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEmaxToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignEmaxToExcSCRXEvent");
    this.emax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEmaxFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignEmaxFromExcSCRXEvent");
    this.emax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEminToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignEminToExcSCRXEvent");
    this.emin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEminFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignEminFromExcSCRXEvent");
    this.emin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignKToExcSCRXEvent");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignKFromExcSCRXEvent");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRcrfdToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignRcrfdToExcSCRXEvent");
    this.rcrfd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcrfdFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignRcrfdFromExcSCRXEvent");
    this.rcrfd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTatbToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignTatbToExcSCRXEvent");
    this.tatb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTatbFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignTatbFromExcSCRXEvent");
    this.tatb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcSCRXEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcSCRXEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcSCRXEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcSCRXEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcSCRXEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcSCRXEvent");
    this.te = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excSCRXId;

  private BooleanProxy cswitch = null;
  private PU emax = null;
  private PU emin = null;
  private PU k = null;
  private Simple_Float rcrfd = null;
  private Simple_Float tatb = null;
  private Seconds tb = null;
  private Seconds te = null;

  private static final Logger LOGGER = Logger.getLogger(ExcSCRXAggregate.class.getName());
}
