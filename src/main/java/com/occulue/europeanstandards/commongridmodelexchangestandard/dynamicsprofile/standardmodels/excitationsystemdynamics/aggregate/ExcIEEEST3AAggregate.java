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
 * Aggregate handler for ExcIEEEST3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST3AAggregate(CreateExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST3ACommand");
    CreateExcIEEEST3AEvent event = new CreateExcIEEEST3AEvent(command.getExcIEEEST3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST3ACommand");
    UpdateExcIEEEST3AEvent event =
        new UpdateExcIEEEST3AEvent(
            command.getExcIEEEST3AId(),
            command.getKa(),
            command.getKc(),
            command.getKg(),
            command.getKi(),
            command.getKm(),
            command.getKp(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getThetap(),
            command.getTm(),
            command.getVbmax(),
            command.getVgmax(),
            command.getVimax(),
            command.getVimin(),
            command.getVmmax(),
            command.getVmmin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST3ACommand");
    apply(new DeleteExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEST3ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEST3ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEST3ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEST3ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcIEEEST3ACommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcIEEEST3ACommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcIEEEST3ACommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcIEEEST3ACommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignKmToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKmToExcIEEEST3ACommand");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromExcIEEEST3ACommand");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcIEEEST3ACommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcIEEEST3ACommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEST3ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEST3ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEST3ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEST3ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEST3ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEST3ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignThetapToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignThetapToExcIEEEST3ACommand");

    if (thetap != null && thetap.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetap already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(new AssignThetapToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetapFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetapFromExcIEEEST3ACommand");

    if (thetap == null) throw new ProcessingException("Thetap already has nothing assigned.");

    apply(new UnAssignThetapFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignTmToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTmToExcIEEEST3ACommand");

    if (tm != null && tm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmFromExcIEEEST3ACommand");

    if (tm == null) throw new ProcessingException("Tm already has nothing assigned.");

    apply(new UnAssignTmFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVbmaxToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVbmaxToExcIEEEST3ACommand");

    if (vbmax != null && vbmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vbmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVbmaxToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVbmaxFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVbmaxFromExcIEEEST3ACommand");

    if (vbmax == null) throw new ProcessingException("Vbmax already has nothing assigned.");

    apply(new UnAssignVbmaxFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVgmaxToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVgmaxToExcIEEEST3ACommand");

    if (vgmax != null && vgmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vgmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVgmaxToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVgmaxFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVgmaxFromExcIEEEST3ACommand");

    if (vgmax == null) throw new ProcessingException("Vgmax already has nothing assigned.");

    apply(new UnAssignVgmaxFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcIEEEST3ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcIEEEST3ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcIEEEST3ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcIEEEST3ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVmmaxToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVmmaxToExcIEEEST3ACommand");

    if (vmmax != null && vmmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmmaxToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmmaxFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmmaxFromExcIEEEST3ACommand");

    if (vmmax == null) throw new ProcessingException("Vmmax already has nothing assigned.");

    apply(new UnAssignVmmaxFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVmminToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVmminToExcIEEEST3ACommand");

    if (vmmin != null && vmmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmminToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmminFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmminFromExcIEEEST3ACommand");

    if (vmmin == null) throw new ProcessingException("Vmmin already has nothing assigned.");

    apply(new UnAssignVmminFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST3ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST3ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST3ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST3ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  @CommandHandler
  public void handle(AssignXlToExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignXlToExcIEEEST3ACommand");

    if (xl != null && xl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXlToExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlFromExcIEEEST3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXlFromExcIEEEST3ACommand");

    if (xl == null) throw new ProcessingException("Xl already has nothing assigned.");

    apply(new UnAssignXlFromExcIEEEST3AEvent(command.getExcIEEEST3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST3AEvent");
    this.excIEEEST3AId = event.getExcIEEEST3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.km = event.getKm();
    this.kp = event.getKp();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.thetap = event.getThetap();
    this.tm = event.getTm();
    this.vbmax = event.getVbmax();
    this.vgmax = event.getVgmax();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vmmax = event.getVmmax();
    this.vmmin = event.getVmmin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xl = event.getXl();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEST3AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEST3AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEST3AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEST3AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcIEEEST3AEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcIEEEST3AEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcIEEEST3AEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcIEEEST3AEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKmToExcIEEEST3AEvent");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKmFromExcIEEEST3AEvent");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcIEEEST3AEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcIEEEST3AEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEST3AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEST3AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEST3AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEST3AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEST3AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEST3AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetapToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignThetapToExcIEEEST3AEvent");
    this.thetap = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetapFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignThetapFromExcIEEEST3AEvent");
    this.thetap = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignTmToExcIEEEST3AEvent");
    this.tm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTmFromExcIEEEST3AEvent");
    this.tm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVbmaxToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVbmaxToExcIEEEST3AEvent");
    this.vbmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVbmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVbmaxFromExcIEEEST3AEvent");
    this.vbmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVgmaxToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVgmaxToExcIEEEST3AEvent");
    this.vgmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVgmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVgmaxFromExcIEEEST3AEvent");
    this.vgmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcIEEEST3AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcIEEEST3AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcIEEEST3AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcIEEEST3AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmmaxToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVmmaxToExcIEEEST3AEvent");
    this.vmmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVmmaxFromExcIEEEST3AEvent");
    this.vmmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmminToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVmminToExcIEEEST3AEvent");
    this.vmmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmminFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVmminFromExcIEEEST3AEvent");
    this.vmmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST3AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST3AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST3AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST3AEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlToExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing AssignXlToExcIEEEST3AEvent");
    this.xl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlFromExcIEEEST3AEvent event) {
    LOGGER.info("Event sourcing UnAssignXlFromExcIEEEST3AEvent");
    this.xl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST3AId;

  private PU ka = null;
  private PU kc = null;
  private PU kg = null;
  private PU ki = null;
  private PU km = null;
  private PU kp = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private AngleDegrees thetap = null;
  private Seconds tm = null;
  private PU vbmax = null;
  private PU vgmax = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vmmax = null;
  private PU vmmin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xl = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST3AAggregate.class.getName());
}
