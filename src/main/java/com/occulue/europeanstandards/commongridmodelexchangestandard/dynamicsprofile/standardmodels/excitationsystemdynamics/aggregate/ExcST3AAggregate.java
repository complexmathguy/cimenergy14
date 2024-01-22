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
 * Aggregate handler for ExcST3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST3AAggregate(CreateExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST3ACommand");
    CreateExcST3AEvent event = new CreateExcST3AEvent(command.getExcST3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST3ACommand");
    UpdateExcST3AEvent event =
        new UpdateExcST3AEvent(
            command.getExcST3AId(),
            command.getEfdmax(),
            command.getKc(),
            command.getKg(),
            command.getKi(),
            command.getKj(),
            command.getKm(),
            command.getKp(),
            command.getKs(),
            command.getKs1(),
            command.getTb(),
            command.getTc(),
            command.getThetap(),
            command.getTm(),
            command.getVbmax(),
            command.getVgmax(),
            command.getVimax(),
            command.getVimin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST3ACommand");
    apply(new DeleteExcST3AEvent(command.getExcST3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcST3ACommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcST3ACommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcST3ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcST3ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcST3ACommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcST3ACommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcST3ACommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcST3ACommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKjToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKjToExcST3ACommand");

    if (kj != null && kj.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kj already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKjToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKjFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKjFromExcST3ACommand");

    if (kj == null) throw new ProcessingException("Kj already has nothing assigned.");

    apply(new UnAssignKjFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKmToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKmToExcST3ACommand");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromExcST3ACommand");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcST3ACommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcST3ACommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcST3ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcST3ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignKs1ToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToExcST3ACommand");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromExcST3ACommand");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcST3ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcST3ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcST3ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcST3ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignThetapToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignThetapToExcST3ACommand");

    if (thetap != null && thetap.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetap already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(new AssignThetapToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetapFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetapFromExcST3ACommand");

    if (thetap == null) throw new ProcessingException("Thetap already has nothing assigned.");

    apply(new UnAssignThetapFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignTmToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTmToExcST3ACommand");

    if (tm != null && tm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmFromExcST3ACommand");

    if (tm == null) throw new ProcessingException("Tm already has nothing assigned.");

    apply(new UnAssignTmFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignVbmaxToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVbmaxToExcST3ACommand");

    if (vbmax != null && vbmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vbmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVbmaxToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVbmaxFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVbmaxFromExcST3ACommand");

    if (vbmax == null) throw new ProcessingException("Vbmax already has nothing assigned.");

    apply(new UnAssignVbmaxFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignVgmaxToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVgmaxToExcST3ACommand");

    if (vgmax != null && vgmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vgmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVgmaxToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVgmaxFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVgmaxFromExcST3ACommand");

    if (vgmax == null) throw new ProcessingException("Vgmax already has nothing assigned.");

    apply(new UnAssignVgmaxFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcST3ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcST3ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcST3ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcST3ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST3ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST3ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST3ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST3ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST3AEvent(command.getExcST3AId()));
  }

  @CommandHandler
  public void handle(AssignXlToExcST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignXlToExcST3ACommand");

    if (xl != null && xl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXlToExcST3AEvent(command.getExcST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlFromExcST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXlFromExcST3ACommand");

    if (xl == null) throw new ProcessingException("Xl already has nothing assigned.");

    apply(new UnAssignXlFromExcST3AEvent(command.getExcST3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST3AEvent event) {
    LOGGER.info("Event sourcing CreateExcST3AEvent");
    this.excST3AId = event.getExcST3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcST3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.kj = event.getKj();
    this.km = event.getKm();
    this.kp = event.getKp();
    this.ks = event.getKs();
    this.ks1 = event.getKs1();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.thetap = event.getThetap();
    this.tm = event.getTm();
    this.vbmax = event.getVbmax();
    this.vgmax = event.getVgmax();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xl = event.getXl();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcST3AEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcST3AEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcST3AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcST3AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcST3AEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcST3AEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcST3AEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcST3AEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKjToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKjToExcST3AEvent");
    this.kj = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKjFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKjFromExcST3AEvent");
    this.kj = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKmToExcST3AEvent");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKmFromExcST3AEvent");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcST3AEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcST3AEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcST3AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcST3AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignKs1ToExcST3AEvent");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKs1FromExcST3AEvent");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcST3AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcST3AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcST3AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcST3AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetapToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignThetapToExcST3AEvent");
    this.thetap = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetapFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignThetapFromExcST3AEvent");
    this.thetap = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignTmToExcST3AEvent");
    this.tm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTmFromExcST3AEvent");
    this.tm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVbmaxToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignVbmaxToExcST3AEvent");
    this.vbmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVbmaxFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVbmaxFromExcST3AEvent");
    this.vbmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVgmaxToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignVgmaxToExcST3AEvent");
    this.vgmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVgmaxFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVgmaxFromExcST3AEvent");
    this.vgmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcST3AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcST3AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcST3AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcST3AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST3AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST3AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST3AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST3AEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlToExcST3AEvent event) {
    LOGGER.info("Event sourcing AssignXlToExcST3AEvent");
    this.xl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlFromExcST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignXlFromExcST3AEvent");
    this.xl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST3AId;

  private PU efdmax = null;
  private PU kc = null;
  private PU kg = null;
  private PU ki = null;
  private PU kj = null;
  private PU km = null;
  private PU kp = null;
  private PU ks = null;
  private PU ks1 = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private AngleDegrees thetap = null;
  private Seconds tm = null;
  private PU vbmax = null;
  private PU vgmax = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xl = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST3AAggregate.class.getName());
}
