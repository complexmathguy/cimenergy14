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
 * Aggregate handler for ExcIEEEDC4B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEDC4B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEDC4BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEDC4BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEDC4BAggregate(CreateExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEDC4BCommand");
    CreateExcIEEEDC4BEvent event = new CreateExcIEEEDC4BEvent(command.getExcIEEEDC4BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEDC4BCommand");
    UpdateExcIEEEDC4BEvent event =
        new UpdateExcIEEEDC4BEvent(
            command.getExcIEEEDC4BId(),
            command.getEfd1(),
            command.getEfd2(),
            command.getKa(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getOelin(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTa(),
            command.getTd(),
            command.getTe(),
            command.getTf(),
            command.getUelin(),
            command.getVemin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEDC4BCommand");
    apply(new DeleteExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcIEEEDC4BCommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcIEEEDC4BCommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcIEEEDC4BCommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcIEEEDC4BCommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEDC4BCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEDC4BCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEDC4BCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEDC4BCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEDC4BCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEDC4BCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEDC4BCommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEDC4BCommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcIEEEDC4BCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcIEEEDC4BCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcIEEEDC4BCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcIEEEDC4BCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignOelinToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignOelinToExcIEEEDC4BCommand");

    if (oelin != null && oelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Oelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignOelinToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOelinFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOelinFromExcIEEEDC4BCommand");

    if (oelin == null) throw new ProcessingException("Oelin already has nothing assigned.");

    apply(new UnAssignOelinFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcIEEEDC4BCommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcIEEEDC4BCommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcIEEEDC4BCommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcIEEEDC4BCommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEDC4BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEDC4BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignTdToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToExcIEEEDC4BCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromExcIEEEDC4BCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEDC4BCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEDC4BCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEDC4BCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEDC4BCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignUelinToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignUelinToExcIEEEDC4BCommand");

    if (uelin != null && uelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelinToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelinFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelinFromExcIEEEDC4BCommand");

    if (uelin == null) throw new ProcessingException("Uelin already has nothing assigned.");

    apply(new UnAssignUelinFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcIEEEDC4BCommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcIEEEDC4BCommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEDC4BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEDC4BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEDC4BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEDC4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEDC4BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEDC4BEvent");
    this.excIEEEDC4BId = event.getExcIEEEDC4BId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.ka = event.getKa();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.oelin = event.getOelin();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.ta = event.getTa();
    this.td = event.getTd();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.uelin = event.getUelin();
    this.vemin = event.getVemin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcIEEEDC4BEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcIEEEDC4BEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcIEEEDC4BEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcIEEEDC4BEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEDC4BEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEDC4BEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEDC4BEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEDC4BEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEDC4BEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEDC4BEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEDC4BEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEDC4BEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcIEEEDC4BEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcIEEEDC4BEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcIEEEDC4BEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcIEEEDC4BEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOelinToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignOelinToExcIEEEDC4BEvent");
    this.oelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOelinFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignOelinFromExcIEEEDC4BEvent");
    this.oelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcIEEEDC4BEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcIEEEDC4BEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcIEEEDC4BEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcIEEEDC4BEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEDC4BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEDC4BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignTdToExcIEEEDC4BEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromExcIEEEDC4BEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEDC4BEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEDC4BEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEDC4BEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEDC4BEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelinToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignUelinToExcIEEEDC4BEvent");
    this.uelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelinFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignUelinFromExcIEEEDC4BEvent");
    this.uelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcIEEEDC4BEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcIEEEDC4BEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEDC4BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEDC4BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEDC4BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEDC4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEDC4BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEDC4BId;

  private PU efd1 = null;
  private PU efd2 = null;
  private PU ka = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private BooleanProxy oelin = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds ta = null;
  private Seconds td = null;
  private Seconds te = null;
  private Seconds tf = null;
  private BooleanProxy uelin = null;
  private PU vemin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BAggregate.class.getName());
}
