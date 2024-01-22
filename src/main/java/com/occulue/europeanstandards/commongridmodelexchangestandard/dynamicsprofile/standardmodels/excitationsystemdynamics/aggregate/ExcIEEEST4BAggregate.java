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
 * Aggregate handler for ExcIEEEST4B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST4B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST4BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST4BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST4BAggregate(CreateExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST4BCommand");
    CreateExcIEEEST4BEvent event = new CreateExcIEEEST4BEvent(command.getExcIEEEST4BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST4BCommand");
    UpdateExcIEEEST4BEvent event =
        new UpdateExcIEEEST4BEvent(
            command.getExcIEEEST4BId(),
            command.getKc(),
            command.getKg(),
            command.getKi(),
            command.getKim(),
            command.getKir(),
            command.getKp(),
            command.getKpm(),
            command.getKpr(),
            command.getTa(),
            command.getThetap(),
            command.getVbmax(),
            command.getVmmax(),
            command.getVmmin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST4BCommand");
    apply(new DeleteExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKcToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEST4BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEST4BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcIEEEST4BCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcIEEEST4BCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcIEEEST4BCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcIEEEST4BCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKimToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKimToExcIEEEST4BCommand");

    if (kim != null && kim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKimToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKimFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKimFromExcIEEEST4BCommand");

    if (kim == null) throw new ProcessingException("Kim already has nothing assigned.");

    apply(new UnAssignKimFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKirToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirToExcIEEEST4BCommand");

    if (kir != null && kir.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kir already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKirToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirFromExcIEEEST4BCommand");

    if (kir == null) throw new ProcessingException("Kir already has nothing assigned.");

    apply(new UnAssignKirFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcIEEEST4BCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcIEEEST4BCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKpmToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpmToExcIEEEST4BCommand");

    if (kpm != null && kpm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpmToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpmFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpmFromExcIEEEST4BCommand");

    if (kpm == null) throw new ProcessingException("Kpm already has nothing assigned.");

    apply(new UnAssignKpmFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignKprToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprToExcIEEEST4BCommand");

    if (kpr != null && kpr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKprToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprFromExcIEEEST4BCommand");

    if (kpr == null) throw new ProcessingException("Kpr already has nothing assigned.");

    apply(new UnAssignKprFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEST4BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEST4BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignThetapToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignThetapToExcIEEEST4BCommand");

    if (thetap != null && thetap.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Thetap already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(new AssignThetapToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThetapFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThetapFromExcIEEEST4BCommand");

    if (thetap == null) throw new ProcessingException("Thetap already has nothing assigned.");

    apply(new UnAssignThetapFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignVbmaxToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVbmaxToExcIEEEST4BCommand");

    if (vbmax != null && vbmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vbmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVbmaxToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVbmaxFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVbmaxFromExcIEEEST4BCommand");

    if (vbmax == null) throw new ProcessingException("Vbmax already has nothing assigned.");

    apply(new UnAssignVbmaxFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignVmmaxToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmmaxToExcIEEEST4BCommand");

    if (vmmax != null && vmmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmmaxToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmmaxFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmmaxFromExcIEEEST4BCommand");

    if (vmmax == null) throw new ProcessingException("Vmmax already has nothing assigned.");

    apply(new UnAssignVmmaxFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignVmminToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmminToExcIEEEST4BCommand");

    if (vmmin != null && vmmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmminToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmminFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmminFromExcIEEEST4BCommand");

    if (vmmin == null) throw new ProcessingException("Vmmin already has nothing assigned.");

    apply(new UnAssignVmminFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST4BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST4BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST4BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST4BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  @CommandHandler
  public void handle(AssignXlToExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignXlToExcIEEEST4BCommand");

    if (xl != null && xl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXlToExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlFromExcIEEEST4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXlFromExcIEEEST4BCommand");

    if (xl == null) throw new ProcessingException("Xl already has nothing assigned.");

    apply(new UnAssignXlFromExcIEEEST4BEvent(command.getExcIEEEST4BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST4BEvent");
    this.excIEEEST4BId = event.getExcIEEEST4BId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.kim = event.getKim();
    this.kir = event.getKir();
    this.kp = event.getKp();
    this.kpm = event.getKpm();
    this.kpr = event.getKpr();
    this.ta = event.getTa();
    this.thetap = event.getThetap();
    this.vbmax = event.getVbmax();
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
  void on(AssignKcToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEST4BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEST4BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcIEEEST4BEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcIEEEST4BEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcIEEEST4BEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcIEEEST4BEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKimToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKimToExcIEEEST4BEvent");
    this.kim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKimFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKimFromExcIEEEST4BEvent");
    this.kim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKirToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKirToExcIEEEST4BEvent");
    this.kir = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKirFromExcIEEEST4BEvent");
    this.kir = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcIEEEST4BEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcIEEEST4BEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpmToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKpmToExcIEEEST4BEvent");
    this.kpm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpmFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpmFromExcIEEEST4BEvent");
    this.kpm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignKprToExcIEEEST4BEvent");
    this.kpr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKprFromExcIEEEST4BEvent");
    this.kpr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEST4BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEST4BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThetapToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignThetapToExcIEEEST4BEvent");
    this.thetap = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThetapFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignThetapFromExcIEEEST4BEvent");
    this.thetap = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVbmaxToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignVbmaxToExcIEEEST4BEvent");
    this.vbmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVbmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVbmaxFromExcIEEEST4BEvent");
    this.vbmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmmaxToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignVmmaxToExcIEEEST4BEvent");
    this.vmmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmmaxFromExcIEEEST4BEvent");
    this.vmmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmminToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignVmminToExcIEEEST4BEvent");
    this.vmmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmminFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmminFromExcIEEEST4BEvent");
    this.vmmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST4BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST4BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST4BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST4BEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlToExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing AssignXlToExcIEEEST4BEvent");
    this.xl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlFromExcIEEEST4BEvent event) {
    LOGGER.info("Event sourcing UnAssignXlFromExcIEEEST4BEvent");
    this.xl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST4BId;

  private PU kc = null;
  private PU kg = null;
  private PU ki = null;
  private PU kim = null;
  private PU kir = null;
  private PU kp = null;
  private PU kpm = null;
  private PU kpr = null;
  private Seconds ta = null;
  private AngleDegrees thetap = null;
  private PU vbmax = null;
  private PU vmmax = null;
  private PU vmmin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xl = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST4BAggregate.class.getName());
}
