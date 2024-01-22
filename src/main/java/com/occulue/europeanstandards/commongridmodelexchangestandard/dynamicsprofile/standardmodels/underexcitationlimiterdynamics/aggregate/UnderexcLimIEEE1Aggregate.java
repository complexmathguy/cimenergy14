package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcLimIEEE1 as outlined for the CQRS pattern, all write
 * responsibilities related to UnderexcLimIEEE1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcLimIEEE1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcLimIEEE1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcLimIEEE1Aggregate(CreateUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcLimIEEE1Command");
    CreateUnderexcLimIEEE1Event event =
        new CreateUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcLimIEEE1Command");
    UpdateUnderexcLimIEEE1Event event =
        new UpdateUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(),
            command.getKuc(),
            command.getKuf(),
            command.getKui(),
            command.getKul(),
            command.getKur(),
            command.getTu1(),
            command.getTu2(),
            command.getTu3(),
            command.getTu4(),
            command.getVucmax(),
            command.getVuimax(),
            command.getVuimin(),
            command.getVulmax(),
            command.getVulmin(),
            command.getVurmax());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcLimIEEE1Command");
    apply(new DeleteUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKucToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKucToUnderexcLimIEEE1Command");

    if (kuc != null && kuc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kuc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKucToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKucFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKucFromUnderexcLimIEEE1Command");

    if (kuc == null) throw new ProcessingException("Kuc already has nothing assigned.");

    apply(new UnAssignKucFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignKufToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKufToUnderexcLimIEEE1Command");

    if (kuf != null && kuf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kuf already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKufToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKufFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKufFromUnderexcLimIEEE1Command");

    if (kuf == null) throw new ProcessingException("Kuf already has nothing assigned.");

    apply(new UnAssignKufFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignKuiToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKuiToUnderexcLimIEEE1Command");

    if (kui != null && kui.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kui already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKuiToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKuiFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKuiFromUnderexcLimIEEE1Command");

    if (kui == null) throw new ProcessingException("Kui already has nothing assigned.");

    apply(new UnAssignKuiFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignKulToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKulToUnderexcLimIEEE1Command");

    if (kul != null && kul.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kul already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKulToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKulFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKulFromUnderexcLimIEEE1Command");

    if (kul == null) throw new ProcessingException("Kul already has nothing assigned.");

    apply(new UnAssignKulFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignKurToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKurToUnderexcLimIEEE1Command");

    if (kur != null && kur.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kur already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKurToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKurFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKurFromUnderexcLimIEEE1Command");

    if (kur == null) throw new ProcessingException("Kur already has nothing assigned.");

    apply(new UnAssignKurFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignTu1ToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignTu1ToUnderexcLimIEEE1Command");

    if (tu1 != null && tu1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu1ToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu1FromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu1FromUnderexcLimIEEE1Command");

    if (tu1 == null) throw new ProcessingException("Tu1 already has nothing assigned.");

    apply(new UnAssignTu1FromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignTu2ToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignTu2ToUnderexcLimIEEE1Command");

    if (tu2 != null && tu2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu2ToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu2FromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu2FromUnderexcLimIEEE1Command");

    if (tu2 == null) throw new ProcessingException("Tu2 already has nothing assigned.");

    apply(new UnAssignTu2FromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignTu3ToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignTu3ToUnderexcLimIEEE1Command");

    if (tu3 != null && tu3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu3ToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu3FromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu3FromUnderexcLimIEEE1Command");

    if (tu3 == null) throw new ProcessingException("Tu3 already has nothing assigned.");

    apply(new UnAssignTu3FromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignTu4ToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignTu4ToUnderexcLimIEEE1Command");

    if (tu4 != null && tu4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu4ToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu4FromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu4FromUnderexcLimIEEE1Command");

    if (tu4 == null) throw new ProcessingException("Tu4 already has nothing assigned.");

    apply(new UnAssignTu4FromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVucmaxToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVucmaxToUnderexcLimIEEE1Command");

    if (vucmax != null && vucmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vucmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVucmaxToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVucmaxFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVucmaxFromUnderexcLimIEEE1Command");

    if (vucmax == null) throw new ProcessingException("Vucmax already has nothing assigned.");

    apply(new UnAssignVucmaxFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVuimaxToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVuimaxToUnderexcLimIEEE1Command");

    if (vuimax != null && vuimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuimaxToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuimaxFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuimaxFromUnderexcLimIEEE1Command");

    if (vuimax == null) throw new ProcessingException("Vuimax already has nothing assigned.");

    apply(new UnAssignVuimaxFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVuiminToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVuiminToUnderexcLimIEEE1Command");

    if (vuimin != null && vuimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuiminToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuiminFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuiminFromUnderexcLimIEEE1Command");

    if (vuimin == null) throw new ProcessingException("Vuimin already has nothing assigned.");

    apply(new UnAssignVuiminFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVulmaxToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVulmaxToUnderexcLimIEEE1Command");

    if (vulmax != null && vulmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vulmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVulmaxToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVulmaxFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVulmaxFromUnderexcLimIEEE1Command");

    if (vulmax == null) throw new ProcessingException("Vulmax already has nothing assigned.");

    apply(new UnAssignVulmaxFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVulminToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVulminToUnderexcLimIEEE1Command");

    if (vulmin != null && vulmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vulmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVulminToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVulminFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVulminFromUnderexcLimIEEE1Command");

    if (vulmin == null) throw new ProcessingException("Vulmin already has nothing assigned.");

    apply(new UnAssignVulminFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignVurmaxToUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignVurmaxToUnderexcLimIEEE1Command");

    if (vurmax != null && vurmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vurmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVurmaxToUnderexcLimIEEE1Event(
            command.getUnderexcLimIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVurmaxFromUnderexcLimIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVurmaxFromUnderexcLimIEEE1Command");

    if (vurmax == null) throw new ProcessingException("Vurmax already has nothing assigned.");

    apply(new UnAssignVurmaxFromUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing CreateUnderexcLimIEEE1Event");
    this.underexcLimIEEE1Id = event.getUnderexcLimIEEE1Id();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kuc = event.getKuc();
    this.kuf = event.getKuf();
    this.kui = event.getKui();
    this.kul = event.getKul();
    this.kur = event.getKur();
    this.tu1 = event.getTu1();
    this.tu2 = event.getTu2();
    this.tu3 = event.getTu3();
    this.tu4 = event.getTu4();
    this.vucmax = event.getVucmax();
    this.vuimax = event.getVuimax();
    this.vuimin = event.getVuimin();
    this.vulmax = event.getVulmax();
    this.vulmin = event.getVulmin();
    this.vurmax = event.getVurmax();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKucToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKucToUnderexcLimIEEE1Event");
    this.kuc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKucFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKucFromUnderexcLimIEEE1Event");
    this.kuc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKufToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKufToUnderexcLimIEEE1Event");
    this.kuf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKufFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKufFromUnderexcLimIEEE1Event");
    this.kuf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKuiToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKuiToUnderexcLimIEEE1Event");
    this.kui = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKuiFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKuiFromUnderexcLimIEEE1Event");
    this.kui = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKulToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKulToUnderexcLimIEEE1Event");
    this.kul = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKulFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKulFromUnderexcLimIEEE1Event");
    this.kul = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKurToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKurToUnderexcLimIEEE1Event");
    this.kur = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKurFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKurFromUnderexcLimIEEE1Event");
    this.kur = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu1ToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignTu1ToUnderexcLimIEEE1Event");
    this.tu1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu1FromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignTu1FromUnderexcLimIEEE1Event");
    this.tu1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu2ToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignTu2ToUnderexcLimIEEE1Event");
    this.tu2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu2FromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignTu2FromUnderexcLimIEEE1Event");
    this.tu2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu3ToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignTu3ToUnderexcLimIEEE1Event");
    this.tu3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu3FromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignTu3FromUnderexcLimIEEE1Event");
    this.tu3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu4ToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignTu4ToUnderexcLimIEEE1Event");
    this.tu4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu4FromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignTu4FromUnderexcLimIEEE1Event");
    this.tu4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVucmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVucmaxToUnderexcLimIEEE1Event");
    this.vucmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVucmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVucmaxFromUnderexcLimIEEE1Event");
    this.vucmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuimaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVuimaxToUnderexcLimIEEE1Event");
    this.vuimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuimaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVuimaxFromUnderexcLimIEEE1Event");
    this.vuimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuiminToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVuiminToUnderexcLimIEEE1Event");
    this.vuimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuiminFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVuiminFromUnderexcLimIEEE1Event");
    this.vuimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVulmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVulmaxToUnderexcLimIEEE1Event");
    this.vulmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVulmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVulmaxFromUnderexcLimIEEE1Event");
    this.vulmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVulminToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVulminToUnderexcLimIEEE1Event");
    this.vulmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVulminFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVulminFromUnderexcLimIEEE1Event");
    this.vulmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVurmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing AssignVurmaxToUnderexcLimIEEE1Event");
    this.vurmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVurmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignVurmaxFromUnderexcLimIEEE1Event");
    this.vurmax = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcLimIEEE1Id;

  private PU kuc = null;
  private PU kuf = null;
  private PU kui = null;
  private PU kul = null;
  private PU kur = null;
  private Seconds tu1 = null;
  private Seconds tu2 = null;
  private Seconds tu3 = null;
  private Seconds tu4 = null;
  private PU vucmax = null;
  private PU vuimax = null;
  private PU vuimin = null;
  private PU vulmax = null;
  private PU vulmin = null;
  private PU vurmax = null;

  private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE1Aggregate.class.getName());
}
