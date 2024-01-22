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
 * Aggregate handler for ExcIEEEDC1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEDC1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEDC1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEDC1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEDC1AAggregate(CreateExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEDC1ACommand");
    CreateExcIEEEDC1AEvent event = new CreateExcIEEEDC1AEvent(command.getExcIEEEDC1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEDC1ACommand");
    UpdateExcIEEEDC1AEvent event =
        new UpdateExcIEEEDC1AEvent(
            command.getExcIEEEDC1AId(),
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
  public void handle(DeleteExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEDC1ACommand");
    apply(new DeleteExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcIEEEDC1ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcIEEEDC1ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcIEEEDC1ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcIEEEDC1ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcIEEEDC1ACommand");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcIEEEDC1ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEDC1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEDC1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEDC1ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEDC1ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEDC1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEDC1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcIEEEDC1ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcIEEEDC1ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcIEEEDC1ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcIEEEDC1ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEDC1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEDC1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEDC1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEDC1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEDC1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEDC1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEDC1ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEDC1ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEDC1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEDC1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignUelinToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignUelinToExcIEEEDC1ACommand");

    if (uelin != null && uelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelinToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelinFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelinFromExcIEEEDC1ACommand");

    if (uelin == null) throw new ProcessingException("Uelin already has nothing assigned.");

    apply(new UnAssignUelinFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEDC1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEDC1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEDC1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEDC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEDC1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEDC1AEvent");
    this.excIEEEDC1AId = event.getExcIEEEDC1AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEDC1AEvent event) {
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
  void on(AssignEfd1ToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcIEEEDC1AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcIEEEDC1AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcIEEEDC1AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcIEEEDC1AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcIEEEDC1AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcIEEEDC1AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEDC1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEDC1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEDC1AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEDC1AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEDC1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEDC1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcIEEEDC1AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcIEEEDC1AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcIEEEDC1AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcIEEEDC1AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEDC1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEDC1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEDC1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEDC1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEDC1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEDC1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEDC1AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEDC1AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEDC1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEDC1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelinToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignUelinToExcIEEEDC1AEvent");
    this.uelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelinFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignUelinFromExcIEEEDC1AEvent");
    this.uelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEDC1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEDC1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEDC1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEDC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEDC1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEDC1AId;

  private PU efd1 = null;
  private PU efd2 = null;
  private BooleanProxy exclim = null;
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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC1AAggregate.class.getName());
}
