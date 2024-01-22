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
 * Aggregate handler for ExcPIC as outlined for the CQRS pattern, all write responsibilities related
 * to ExcPIC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcPICAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcPICAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcPICAggregate(CreateExcPICCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcPICCommand");
    CreateExcPICEvent event = new CreateExcPICEvent(command.getExcPICId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcPICCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcPICCommand");
    UpdateExcPICEvent event =
        new UpdateExcPICEvent(
            command.getExcPICId(),
            command.getE1(),
            command.getE2(),
            command.getEfdmax(),
            command.getEfdmin(),
            command.getKa(),
            command.getKc(),
            command.getKe(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getSe1(),
            command.getSe2(),
            command.getTa1(),
            command.getTa2(),
            command.getTa3(),
            command.getTa4(),
            command.getTe(),
            command.getTf1(),
            command.getTf2(),
            command.getVr1(),
            command.getVr2(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcPICCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcPICCommand");
    apply(new DeleteExcPICEvent(command.getExcPICId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcPICCommand");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcPICCommand");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcPICCommand");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcPICCommand");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignEfdmaxToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcPICCommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcPICCommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcPICCommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcPICCommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcPICCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcPICCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcPICCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcPICCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcPICCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcPICCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcPICCommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcPICCommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcPICCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcPICCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcPICCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcPICCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignSe1ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignSe1ToExcPICCommand");

    if (se1 != null && se1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Se1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSe1ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe1FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe1FromExcPICCommand");

    if (se1 == null) throw new ProcessingException("Se1 already has nothing assigned.");

    apply(new UnAssignSe1FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignSe2ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignSe2ToExcPICCommand");

    if (se2 != null && se2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Se2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSe2ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe2FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe2FromExcPICCommand");

    if (se2 == null) throw new ProcessingException("Se2 already has nothing assigned.");

    apply(new UnAssignSe2FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTa1ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTa1ToExcPICCommand");

    if (ta1 != null && ta1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTa1ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTa1FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTa1FromExcPICCommand");

    if (ta1 == null) throw new ProcessingException("Ta1 already has nothing assigned.");

    apply(new UnAssignTa1FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTa2ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTa2ToExcPICCommand");

    if (ta2 != null && ta2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTa2ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTa2FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTa2FromExcPICCommand");

    if (ta2 == null) throw new ProcessingException("Ta2 already has nothing assigned.");

    apply(new UnAssignTa2FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTa3ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTa3ToExcPICCommand");

    if (ta3 != null && ta3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTa3ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTa3FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTa3FromExcPICCommand");

    if (ta3 == null) throw new ProcessingException("Ta3 already has nothing assigned.");

    apply(new UnAssignTa3FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTa4ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTa4ToExcPICCommand");

    if (ta4 != null && ta4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTa4ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTa4FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTa4FromExcPICCommand");

    if (ta4 == null) throw new ProcessingException("Ta4 already has nothing assigned.");

    apply(new UnAssignTa4FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcPICCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcPICCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcPICCommand");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcPICCommand");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignTf2ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToExcPICCommand");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromExcPICCommand");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignVr1ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignVr1ToExcPICCommand");

    if (vr1 != null && vr1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vr1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVr1ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVr1FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVr1FromExcPICCommand");

    if (vr1 == null) throw new ProcessingException("Vr1 already has nothing assigned.");

    apply(new UnAssignVr1FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignVr2ToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignVr2ToExcPICCommand");

    if (vr2 != null && vr2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vr2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVr2ToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVr2FromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVr2FromExcPICCommand");

    if (vr2 == null) throw new ProcessingException("Vr2 already has nothing assigned.");

    apply(new UnAssignVr2FromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcPICCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcPICCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcPICEvent(command.getExcPICId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcPICCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcPICCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcPICEvent(command.getExcPICId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcPICCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcPICCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcPICEvent(command.getExcPICId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcPICEvent event) {
    LOGGER.info("Event sourcing CreateExcPICEvent");
    this.excPICId = event.getExcPICId();
  }

  @EventSourcingHandler
  void on(UpdateExcPICEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.e1 = event.getE1();
    this.e2 = event.getE2();
    this.efdmax = event.getEfdmax();
    this.efdmin = event.getEfdmin();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.se1 = event.getSe1();
    this.se2 = event.getSe2();
    this.ta1 = event.getTa1();
    this.ta2 = event.getTa2();
    this.ta3 = event.getTa3();
    this.ta4 = event.getTa4();
    this.te = event.getTe();
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.vr1 = event.getVr1();
    this.vr2 = event.getVr2();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignE1ToExcPICEvent");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcPICEvent");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignE2ToExcPICEvent");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcPICEvent");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcPICEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcPICEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcPICEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcPICEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcPICEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcPICEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcPICEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcPICEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcPICEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcPICEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcPICEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcPICEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcPICEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcPICEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcPICEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcPICEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe1ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignSe1ToExcPICEvent");
    this.se1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe1FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignSe1FromExcPICEvent");
    this.se1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe2ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignSe2ToExcPICEvent");
    this.se2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe2FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignSe2FromExcPICEvent");
    this.se2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTa1ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTa1ToExcPICEvent");
    this.ta1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTa1FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTa1FromExcPICEvent");
    this.ta1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTa2ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTa2ToExcPICEvent");
    this.ta2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTa2FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTa2FromExcPICEvent");
    this.ta2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTa3ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTa3ToExcPICEvent");
    this.ta3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTa3FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTa3FromExcPICEvent");
    this.ta3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTa4ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTa4ToExcPICEvent");
    this.ta4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTa4FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTa4FromExcPICEvent");
    this.ta4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcPICEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcPICEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTf1ToExcPICEvent");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcPICEvent");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignTf2ToExcPICEvent");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignTf2FromExcPICEvent");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVr1ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignVr1ToExcPICEvent");
    this.vr1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVr1FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignVr1FromExcPICEvent");
    this.vr1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVr2ToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignVr2ToExcPICEvent");
    this.vr2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVr2FromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignVr2FromExcPICEvent");
    this.vr2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcPICEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcPICEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcPICEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcPICEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcPICEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcPICEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excPICId;

  private PU e1 = null;
  private PU e2 = null;
  private PU efdmax = null;
  private PU efdmin = null;
  private PU ka = null;
  private PU kc = null;
  private PU ke = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private PU se1 = null;
  private PU se2 = null;
  private Seconds ta1 = null;
  private Seconds ta2 = null;
  private Seconds ta3 = null;
  private Seconds ta4 = null;
  private Seconds te = null;
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private PU vr1 = null;
  private PU vr2 = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcPICAggregate.class.getName());
}
