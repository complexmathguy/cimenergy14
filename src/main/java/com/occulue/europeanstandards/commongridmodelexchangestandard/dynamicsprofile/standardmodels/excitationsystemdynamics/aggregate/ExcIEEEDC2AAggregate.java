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
 * Aggregate handler for ExcIEEEDC2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEDC2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEDC2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEDC2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEDC2AAggregate(CreateExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEDC2ACommand");
    CreateExcIEEEDC2AEvent event = new CreateExcIEEEDC2AEvent(command.getExcIEEEDC2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEDC2ACommand");
    UpdateExcIEEEDC2AEvent event =
        new UpdateExcIEEEDC2AEvent(
            command.getExcIEEEDC2AId(),
            command.getEfd1(),
            command.getEfd2(),
            command.getExclim(),
            command.getKa(),
            command.getKe(),
            command.getKf(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTe(),
            command.getTf(),
            command.getUelin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEDC2ACommand");
    apply(new DeleteExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcIEEEDC2ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcIEEEDC2ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcIEEEDC2ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcIEEEDC2ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcIEEEDC2ACommand");

    if (exclim != null && exclim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignExclimToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcIEEEDC2ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEDC2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEDC2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEDC2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEDC2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEDC2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEDC2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcIEEEDC2ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcIEEEDC2ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcIEEEDC2ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcIEEEDC2ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEDC2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEDC2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEDC2ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEDC2ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEDC2ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEDC2ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEDC2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEDC2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEDC2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEDC2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignUelinToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignUelinToExcIEEEDC2ACommand");

    if (uelin != null && uelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelinToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelinFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelinFromExcIEEEDC2ACommand");

    if (uelin == null) throw new ProcessingException("Uelin already has nothing assigned.");

    apply(new UnAssignUelinFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEDC2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEDC2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEDC2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEDC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEDC2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEDC2AEvent");
    this.excIEEEDC2AId = event.getExcIEEEDC2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.exclim = event.getExclim();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.uelin = event.getUelin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcIEEEDC2AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcIEEEDC2AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcIEEEDC2AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcIEEEDC2AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcIEEEDC2AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcIEEEDC2AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEDC2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEDC2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEDC2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEDC2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEDC2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEDC2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcIEEEDC2AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcIEEEDC2AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcIEEEDC2AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcIEEEDC2AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEDC2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEDC2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEDC2AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEDC2AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEDC2AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEDC2AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEDC2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEDC2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEDC2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEDC2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelinToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignUelinToExcIEEEDC2AEvent");
    this.uelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelinFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignUelinFromExcIEEEDC2AEvent");
    this.uelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEDC2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEDC2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEDC2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEDC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEDC2AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEDC2AId;

  private PU efd1 = null;
  private PU efd2 = null;
  private PU exclim = null;
  private PU ka = null;
  private PU ke = null;
  private PU kf = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds tf = null;
  private BooleanProxy uelin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC2AAggregate.class.getName());
}
