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
 * Aggregate handler for ExcDC3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcDC3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcDC3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcDC3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcDC3AAggregate(CreateExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcDC3ACommand");
    CreateExcDC3AEvent event = new CreateExcDC3AEvent(command.getExcDC3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcDC3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcDC3ACommand");
    UpdateExcDC3AEvent event =
        new UpdateExcDC3AEvent(
            command.getExcDC3AId(),
            command.getEdfmax(),
            command.getEfd1(),
            command.getEfd2(),
            command.getEfdlim(),
            command.getEfdmin(),
            command.getExclim(),
            command.getKe(),
            command.getKr(),
            command.getKs(),
            command.getKv(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTe(),
            command.getTrh(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcDC3ACommand");
    apply(new DeleteExcDC3AEvent(command.getExcDC3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEdfmaxToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEdfmaxToExcDC3ACommand");

    if (edfmax != null && edfmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Edfmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEdfmaxToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEdfmaxFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEdfmaxFromExcDC3ACommand");

    if (edfmax == null) throw new ProcessingException("Edfmax already has nothing assigned.");

    apply(new UnAssignEdfmaxFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignEfd1ToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcDC3ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcDC3ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcDC3ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcDC3ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignEfdlimToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdlimToExcDC3ACommand");

    if (efdlim != null && efdlim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Efdlim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignEfdlimToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdlimFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdlimFromExcDC3ACommand");

    if (efdlim == null) throw new ProcessingException("Efdlim already has nothing assigned.");

    apply(new UnAssignEfdlimFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcDC3ACommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcDC3ACommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcDC3ACommand");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcDC3ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcDC3ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcDC3ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKrToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKrToExcDC3ACommand");

    if (kr != null && kr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKrToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrFromExcDC3ACommand");

    if (kr == null) throw new ProcessingException("Kr already has nothing assigned.");

    apply(new UnAssignKrFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcDC3ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcDC3ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKvToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKvToExcDC3ACommand");

    if (kv != null && kv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKvToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvFromExcDC3ACommand");

    if (kv == null) throw new ProcessingException("Kv already has nothing assigned.");

    apply(new UnAssignKvFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcDC3ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcDC3ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcDC3ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcDC3ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcDC3ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcDC3ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignTrhToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTrhToExcDC3ACommand");

    if (trh != null && trh.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Trh already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrhToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrhFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrhFromExcDC3ACommand");

    if (trh == null) throw new ProcessingException("Trh already has nothing assigned.");

    apply(new UnAssignTrhFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcDC3ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcDC3ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcDC3AEvent(command.getExcDC3AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcDC3ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcDC3AEvent(command.getExcDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcDC3ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcDC3AEvent(command.getExcDC3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcDC3AEvent event) {
    LOGGER.info("Event sourcing CreateExcDC3AEvent");
    this.excDC3AId = event.getExcDC3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcDC3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.edfmax = event.getEdfmax();
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.efdlim = event.getEfdlim();
    this.efdmin = event.getEfdmin();
    this.exclim = event.getExclim();
    this.ke = event.getKe();
    this.kr = event.getKr();
    this.ks = event.getKs();
    this.kv = event.getKv();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.te = event.getTe();
    this.trh = event.getTrh();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEdfmaxToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEdfmaxToExcDC3AEvent");
    this.edfmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEdfmaxFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEdfmaxFromExcDC3AEvent");
    this.edfmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcDC3AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcDC3AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcDC3AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcDC3AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdlimToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfdlimToExcDC3AEvent");
    this.efdlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdlimFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdlimFromExcDC3AEvent");
    this.efdlim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcDC3AEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcDC3AEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcDC3AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcDC3AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcDC3AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcDC3AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKrToExcDC3AEvent");
    this.kr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKrFromExcDC3AEvent");
    this.kr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcDC3AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcDC3AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKvToExcDC3AEvent");
    this.kv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKvFromExcDC3AEvent");
    this.kv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcDC3AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcDC3AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcDC3AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcDC3AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcDC3AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcDC3AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrhToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignTrhToExcDC3AEvent");
    this.trh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrhFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTrhFromExcDC3AEvent");
    this.trh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcDC3AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcDC3AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcDC3AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcDC3AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcDC3AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excDC3AId;

  private PU edfmax = null;
  private PU efd1 = null;
  private PU efd2 = null;
  private BooleanProxy efdlim = null;
  private PU efdmin = null;
  private BooleanProxy exclim = null;
  private PU ke = null;
  private PU kr = null;
  private PU ks = null;
  private PU kv = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds te = null;
  private Seconds trh = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcDC3AAggregate.class.getName());
}
