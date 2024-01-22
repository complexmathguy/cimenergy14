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
 * Aggregate handler for ExcST4B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST4B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST4BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST4BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST4BAggregate(CreateExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST4BCommand");
    CreateExcST4BEvent event = new CreateExcST4BEvent(command.getExcST4BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST4BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST4BCommand");
    UpdateExcST4BEvent event =
        new UpdateExcST4BEvent(
            command.getExcST4BId(),
            command.getKc(),
            command.getKg(),
            command.getKi(),
            command.getKim(),
            command.getKir(),
            command.getKp(),
            command.getKpm(),
            command.getKpr(),
            command.getLvgate(),
            command.getTa(),
            command.getThetap(),
            command.getUel(),
            command.getVbmax(),
            command.getVgmax(),
            command.getVmmax(),
            command.getVmmin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST4BCommand");
    apply(new DeleteExcST4BEvent(command.getExcST4BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKcToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcST4BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcST4BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcST4BCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcST4BCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcST4BCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcST4BCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKimToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKimToExcST4BCommand");

    if (kim != null && kim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKimToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKimFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKimFromExcST4BCommand");

    if (kim == null) throw new ProcessingException("Kim already has nothing assigned.");

    apply(new UnAssignKimFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKirToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirToExcST4BCommand");

    if (kir != null && kir.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kir already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKirToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirFromExcST4BCommand");

    if (kir == null) throw new ProcessingException("Kir already has nothing assigned.");

    apply(new UnAssignKirFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcST4BCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcST4BCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKpmToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpmToExcST4BCommand");

    if (kpm != null && kpm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpmToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpmFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpmFromExcST4BCommand");

    if (kpm == null) throw new ProcessingException("Kpm already has nothing assigned.");

    apply(new UnAssignKpmFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignKprToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprToExcST4BCommand");

    if (kpr != null && kpr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKprToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprFromExcST4BCommand");

    if (kpr == null) throw new ProcessingException("Kpr already has nothing assigned.");

    apply(new UnAssignKprFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignLvgateToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignLvgateToExcST4BCommand");

    if (lvgate != null && lvgate.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Lvgate already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignLvgateToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLvgateFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLvgateFromExcST4BCommand");

    if (lvgate == null) throw new ProcessingException("Lvgate already has nothing assigned.");

    apply(new UnAssignLvgateFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcST4BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcST4BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignThetapToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignThetapToExcST4BCommand");

    if (thetap != null && thetap.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetap already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(new AssignThetapToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetapFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetapFromExcST4BCommand");

    if (thetap == null) throw new ProcessingException("Thetap already has nothing assigned.");

    apply(new UnAssignThetapFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignUelToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignUelToExcST4BCommand");

    if (uel != null && uel.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uel already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelFromExcST4BCommand");

    if (uel == null) throw new ProcessingException("Uel already has nothing assigned.");

    apply(new UnAssignUelFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVbmaxToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVbmaxToExcST4BCommand");

    if (vbmax != null && vbmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vbmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVbmaxToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVbmaxFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVbmaxFromExcST4BCommand");

    if (vbmax == null) throw new ProcessingException("Vbmax already has nothing assigned.");

    apply(new UnAssignVbmaxFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVgmaxToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVgmaxToExcST4BCommand");

    if (vgmax != null && vgmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vgmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVgmaxToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVgmaxFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVgmaxFromExcST4BCommand");

    if (vgmax == null) throw new ProcessingException("Vgmax already has nothing assigned.");

    apply(new UnAssignVgmaxFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVmmaxToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmmaxToExcST4BCommand");

    if (vmmax != null && vmmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmmaxToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmmaxFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmmaxFromExcST4BCommand");

    if (vmmax == null) throw new ProcessingException("Vmmax already has nothing assigned.");

    apply(new UnAssignVmmaxFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVmminToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmminToExcST4BCommand");

    if (vmmin != null && vmmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmminToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmminFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmminFromExcST4BCommand");

    if (vmmin == null) throw new ProcessingException("Vmmin already has nothing assigned.");

    apply(new UnAssignVmminFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST4BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST4BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST4BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST4BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST4BEvent(command.getExcST4BId()));
  }

  @CommandHandler
  public void handle(AssignXlToExcST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignXlToExcST4BCommand");

    if (xl != null && xl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXlToExcST4BEvent(command.getExcST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlFromExcST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXlFromExcST4BCommand");

    if (xl == null) throw new ProcessingException("Xl already has nothing assigned.");

    apply(new UnAssignXlFromExcST4BEvent(command.getExcST4BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST4BEvent event) {
    LOGGER.info("Event sourcing CreateExcST4BEvent");
    this.excST4BId = event.getExcST4BId();
  }

  @EventSourcingHandler
  void on(UpdateExcST4BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.kim = event.getKim();
    this.kir = event.getKir();
    this.kp = event.getKp();
    this.kpm = event.getKpm();
    this.kpr = event.getKpr();
    this.lvgate = event.getLvgate();
    this.ta = event.getTa();
    this.thetap = event.getThetap();
    this.uel = event.getUel();
    this.vbmax = event.getVbmax();
    this.vgmax = event.getVgmax();
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
  void on(AssignKcToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcST4BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcST4BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcST4BEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcST4BEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcST4BEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcST4BEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKimToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKimToExcST4BEvent");
    this.kim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKimFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKimFromExcST4BEvent");
    this.kim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKirToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKirToExcST4BEvent");
    this.kir = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKirFromExcST4BEvent");
    this.kir = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcST4BEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcST4BEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpmToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKpmToExcST4BEvent");
    this.kpm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpmFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpmFromExcST4BEvent");
    this.kpm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignKprToExcST4BEvent");
    this.kpr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKprFromExcST4BEvent");
    this.kpr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLvgateToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignLvgateToExcST4BEvent");
    this.lvgate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLvgateFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignLvgateFromExcST4BEvent");
    this.lvgate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcST4BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcST4BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetapToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignThetapToExcST4BEvent");
    this.thetap = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetapFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignThetapFromExcST4BEvent");
    this.thetap = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignUelToExcST4BEvent");
    this.uel = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignUelFromExcST4BEvent");
    this.uel = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVbmaxToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVbmaxToExcST4BEvent");
    this.vbmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVbmaxFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVbmaxFromExcST4BEvent");
    this.vbmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVgmaxToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVgmaxToExcST4BEvent");
    this.vgmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVgmaxFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVgmaxFromExcST4BEvent");
    this.vgmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmmaxToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVmmaxToExcST4BEvent");
    this.vmmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmmaxFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmmaxFromExcST4BEvent");
    this.vmmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmminToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVmminToExcST4BEvent");
    this.vmmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmminFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmminFromExcST4BEvent");
    this.vmmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST4BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST4BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST4BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST4BEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlToExcST4BEvent event) {
    LOGGER.info("Event sourcing AssignXlToExcST4BEvent");
    this.xl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlFromExcST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignXlFromExcST4BEvent");
    this.xl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST4BId;

  private PU kc = null;
  private PU kg = null;
  private PU ki = null;
  private PU kim = null;
  private PU kir = null;
  private PU kp = null;
  private PU kpm = null;
  private PU kpr = null;
  private BooleanProxy lvgate = null;
  private Seconds ta = null;
  private AngleDegrees thetap = null;
  private BooleanProxy uel = null;
  private PU vbmax = null;
  private PU vgmax = null;
  private PU vmmax = null;
  private PU vmmin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xl = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST4BAggregate.class.getName());
}
