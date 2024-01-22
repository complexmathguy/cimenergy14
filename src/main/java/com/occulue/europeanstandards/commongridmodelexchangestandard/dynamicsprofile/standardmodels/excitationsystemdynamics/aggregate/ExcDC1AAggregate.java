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
 * Aggregate handler for ExcDC1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcDC1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcDC1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcDC1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcDC1AAggregate(CreateExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcDC1ACommand");
    CreateExcDC1AEvent event = new CreateExcDC1AEvent(command.getExcDC1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcDC1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcDC1ACommand");
    UpdateExcDC1AEvent event =
        new UpdateExcDC1AEvent(
            command.getExcDC1AId(),
            command.getEdfmax(),
            command.getEfd1(),
            command.getEfd2(),
            command.getEfdmin(),
            command.getExclim(),
            command.getKa(),
            command.getKe(),
            command.getKf(),
            command.getKs(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTe(),
            command.getTf(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcDC1ACommand");
    apply(new DeleteExcDC1AEvent(command.getExcDC1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEdfmaxToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEdfmaxToExcDC1ACommand");

    if (edfmax != null && edfmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Edfmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEdfmaxToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEdfmaxFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEdfmaxFromExcDC1ACommand");

    if (edfmax == null) throw new ProcessingException("Edfmax already has nothing assigned.");

    apply(new UnAssignEdfmaxFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignEfd1ToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcDC1ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcDC1ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcDC1ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcDC1ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcDC1ACommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcDC1ACommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcDC1ACommand");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcDC1ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcDC1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcDC1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcDC1ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcDC1ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcDC1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcDC1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcDC1ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcDC1ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcDC1ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcDC1ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcDC1ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcDC1ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcDC1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcDC1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcDC1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcDC1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcDC1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcDC1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcDC1ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcDC1ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcDC1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcDC1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcDC1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcDC1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcDC1AEvent(command.getExcDC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcDC1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcDC1AEvent(command.getExcDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcDC1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcDC1AEvent(command.getExcDC1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcDC1AEvent event) {
    LOGGER.info("Event sourcing CreateExcDC1AEvent");
    this.excDC1AId = event.getExcDC1AId();
  }

  @EventSourcingHandler
  void on(UpdateExcDC1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.edfmax = event.getEdfmax();
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.efdmin = event.getEfdmin();
    this.exclim = event.getExclim();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ks = event.getKs();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEdfmaxToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEdfmaxToExcDC1AEvent");
    this.edfmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEdfmaxFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEdfmaxFromExcDC1AEvent");
    this.edfmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcDC1AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcDC1AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcDC1AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcDC1AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcDC1AEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcDC1AEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcDC1AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcDC1AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcDC1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcDC1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcDC1AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcDC1AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcDC1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcDC1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcDC1AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcDC1AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcDC1AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcDC1AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcDC1AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcDC1AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcDC1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcDC1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcDC1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcDC1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcDC1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcDC1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcDC1AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcDC1AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcDC1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcDC1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcDC1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcDC1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcDC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcDC1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcDC1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excDC1AId;

  private PU edfmax = null;
  private PU efd1 = null;
  private PU efd2 = null;
  private PU efdmin = null;
  private BooleanProxy exclim = null;
  private PU ka = null;
  private PU ke = null;
  private PU kf = null;
  private PU ks = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcDC1AAggregate.class.getName());
}
