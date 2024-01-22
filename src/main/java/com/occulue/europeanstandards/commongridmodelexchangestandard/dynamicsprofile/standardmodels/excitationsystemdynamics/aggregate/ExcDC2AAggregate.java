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
 * Aggregate handler for ExcDC2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcDC2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcDC2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcDC2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcDC2AAggregate(CreateExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcDC2ACommand");
    CreateExcDC2AEvent event = new CreateExcDC2AEvent(command.getExcDC2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcDC2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcDC2ACommand");
    UpdateExcDC2AEvent event =
        new UpdateExcDC2AEvent(
            command.getExcDC2AId(),
            command.getEfd1(),
            command.getEfd2(),
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
            command.getTf1(),
            command.getVrmax(),
            command.getVrmin(),
            command.getVtlim());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcDC2ACommand");
    apply(new DeleteExcDC2AEvent(command.getExcDC2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcDC2ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcDC2ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcDC2ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcDC2ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcDC2ACommand");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcDC2ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcDC2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcDC2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcDC2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcDC2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcDC2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcDC2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcDC2ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcDC2ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcDC2ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcDC2ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcDC2ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcDC2ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcDC2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcDC2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcDC2ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcDC2ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcDC2ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcDC2ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcDC2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcDC2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcDC2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcDC2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcDC2ACommand");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcDC2ACommand");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcDC2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcDC2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcDC2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcDC2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcDC2AEvent(command.getExcDC2AId()));
  }

  @CommandHandler
  public void handle(AssignVtlimToExcDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtlimToExcDC2ACommand");

    if (vtlim != null && vtlim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vtlim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVtlimToExcDC2AEvent(command.getExcDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtlimFromExcDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtlimFromExcDC2ACommand");

    if (vtlim == null) throw new ProcessingException("Vtlim already has nothing assigned.");

    apply(new UnAssignVtlimFromExcDC2AEvent(command.getExcDC2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcDC2AEvent event) {
    LOGGER.info("Event sourcing CreateExcDC2AEvent");
    this.excDC2AId = event.getExcDC2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcDC2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
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
    this.tf1 = event.getTf1();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.vtlim = event.getVtlim();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcDC2AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcDC2AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcDC2AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcDC2AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcDC2AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcDC2AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcDC2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcDC2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcDC2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcDC2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcDC2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcDC2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcDC2AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcDC2AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcDC2AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcDC2AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcDC2AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcDC2AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcDC2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcDC2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcDC2AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcDC2AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcDC2AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcDC2AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcDC2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcDC2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcDC2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcDC2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTf1ToExcDC2AEvent");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcDC2AEvent");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcDC2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcDC2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcDC2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcDC2AEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtlimToExcDC2AEvent event) {
    LOGGER.info("Event sourcing AssignVtlimToExcDC2AEvent");
    this.vtlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtlimFromExcDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtlimFromExcDC2AEvent");
    this.vtlim = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excDC2AId;

  private PU efd1 = null;
  private PU efd2 = null;
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
  private Seconds tf1 = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private BooleanProxy vtlim = null;

  private static final Logger LOGGER = Logger.getLogger(ExcDC2AAggregate.class.getName());
}
