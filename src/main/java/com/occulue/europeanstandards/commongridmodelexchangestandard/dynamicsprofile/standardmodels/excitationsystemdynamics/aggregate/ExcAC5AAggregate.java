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
 * Aggregate handler for ExcAC5A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC5A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC5AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC5AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC5AAggregate(CreateExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC5ACommand");
    CreateExcAC5AEvent event = new CreateExcAC5AEvent(command.getExcAC5AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC5ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC5ACommand");
    UpdateExcAC5AEvent event =
        new UpdateExcAC5AEvent(
            command.getExcAC5AId(),
            command.getA(),
            command.getEfd1(),
            command.getEfd2(),
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
            command.getTf1(),
            command.getTf2(),
            command.getTf3(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC5ACommand");
    apply(new DeleteExcAC5AEvent(command.getExcAC5AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignAToExcAC5ACommand");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromExcAC5ACommand");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignEfd1ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcAC5ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcAC5ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcAC5ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcAC5ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC5ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC5ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC5ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC5ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAC5ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAC5ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC5ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC5ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcAC5ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcAC5ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcAC5ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcAC5ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC5ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC5ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC5ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC5ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC5ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC5ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC5ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC5ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcAC5ACommand");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcAC5ACommand");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf2ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToExcAC5ACommand");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromExcAC5ACommand");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf3ToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf3ToExcAC5ACommand");

    if (tf3 != null && tf3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf3ToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf3FromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf3FromExcAC5ACommand");

    if (tf3 == null) throw new ProcessingException("Tf3 already has nothing assigned.");

    apply(new UnAssignTf3FromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC5ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC5ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC5AEvent(command.getExcAC5AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC5ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC5AEvent(command.getExcAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC5ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC5AEvent(command.getExcAC5AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC5AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC5AEvent");
    this.excAC5AId = event.getExcAC5AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC5AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a = event.getA();
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
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
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.tf3 = event.getTf3();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignAToExcAC5AEvent");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignAFromExcAC5AEvent");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcAC5AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcAC5AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcAC5AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcAC5AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC5AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC5AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC5AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC5AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcAC5AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAC5AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC5AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC5AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcAC5AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcAC5AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcAC5AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcAC5AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC5AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC5AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC5AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC5AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC5AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC5AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC5AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC5AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf1ToExcAC5AEvent");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcAC5AEvent");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf2ToExcAC5AEvent");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf2FromExcAC5AEvent");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf3ToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf3ToExcAC5AEvent");
    this.tf3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf3FromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf3FromExcAC5AEvent");
    this.tf3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC5AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC5AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC5AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC5AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC5AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC5AId;

  private Simple_Float a = null;
  private PU efd1 = null;
  private PU efd2 = null;
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
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private Seconds tf3 = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC5AAggregate.class.getName());
}
