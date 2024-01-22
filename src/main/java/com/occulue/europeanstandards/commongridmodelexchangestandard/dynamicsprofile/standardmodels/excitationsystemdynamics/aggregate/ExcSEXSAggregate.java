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
 * Aggregate handler for ExcSEXS as outlined for the CQRS pattern, all write responsibilities
 * related to ExcSEXS are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcSEXSAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcSEXSAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcSEXSAggregate(CreateExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcSEXSCommand");
    CreateExcSEXSEvent event = new CreateExcSEXSEvent(command.getExcSEXSId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcSEXSCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcSEXSCommand");
    UpdateExcSEXSEvent event =
        new UpdateExcSEXSEvent(
            command.getExcSEXSId(),
            command.getEfdmax(),
            command.getEfdmin(),
            command.getEmax(),
            command.getEmin(),
            command.getK(),
            command.getKc(),
            command.getTatb(),
            command.getTb(),
            command.getTc(),
            command.getTe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcSEXSCommand");
    apply(new DeleteExcSEXSEvent(command.getExcSEXSId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcSEXSCommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcSEXSCommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcSEXSCommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcSEXSCommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignEmaxToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignEmaxToExcSEXSCommand");

    if (emax != null && emax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEmaxToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEmaxFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEmaxFromExcSEXSCommand");

    if (emax == null) throw new ProcessingException("Emax already has nothing assigned.");

    apply(new UnAssignEmaxFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignEminToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignEminToExcSEXSCommand");

    if (emin != null && emin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEminToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEminFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEminFromExcSEXSCommand");

    if (emin == null) throw new ProcessingException("Emin already has nothing assigned.");

    apply(new UnAssignEminFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignKToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKToExcSEXSCommand");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromExcSEXSCommand");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcSEXSCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcSEXSCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignTatbToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTatbToExcSEXSCommand");

    if (tatb != null && tatb.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Tatb already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignTatbToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTatbFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTatbFromExcSEXSCommand");

    if (tatb == null) throw new ProcessingException("Tatb already has nothing assigned.");

    apply(new UnAssignTatbFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcSEXSCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcSEXSCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcSEXSCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcSEXSCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcSEXSEvent(command.getExcSEXSId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcSEXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcSEXSCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcSEXSEvent(command.getExcSEXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcSEXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcSEXSCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcSEXSEvent(command.getExcSEXSId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcSEXSEvent event) {
    LOGGER.info("Event sourcing CreateExcSEXSEvent");
    this.excSEXSId = event.getExcSEXSId();
  }

  @EventSourcingHandler
  void on(UpdateExcSEXSEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.efdmin = event.getEfdmin();
    this.emax = event.getEmax();
    this.emin = event.getEmin();
    this.k = event.getK();
    this.kc = event.getKc();
    this.tatb = event.getTatb();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.te = event.getTe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcSEXSEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcSEXSEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcSEXSEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcSEXSEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEmaxToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignEmaxToExcSEXSEvent");
    this.emax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEmaxFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignEmaxFromExcSEXSEvent");
    this.emax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEminToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignEminToExcSEXSEvent");
    this.emin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEminFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignEminFromExcSEXSEvent");
    this.emin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignKToExcSEXSEvent");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKFromExcSEXSEvent");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcSEXSEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcSEXSEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTatbToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignTatbToExcSEXSEvent");
    this.tatb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTatbFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTatbFromExcSEXSEvent");
    this.tatb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcSEXSEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcSEXSEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcSEXSEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcSEXSEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcSEXSEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcSEXSEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcSEXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcSEXSEvent");
    this.te = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excSEXSId;

  private PU efdmax = null;
  private PU efdmin = null;
  private PU emax = null;
  private PU emin = null;
  private PU k = null;
  private PU kc = null;
  private Simple_Float tatb = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;

  private static final Logger LOGGER = Logger.getLogger(ExcSEXSAggregate.class.getName());
}
