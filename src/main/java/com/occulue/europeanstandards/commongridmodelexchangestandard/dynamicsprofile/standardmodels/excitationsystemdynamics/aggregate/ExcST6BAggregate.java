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
 * Aggregate handler for ExcST6B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST6B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST6BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST6BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST6BAggregate(CreateExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST6BCommand");
    CreateExcST6BEvent event = new CreateExcST6BEvent(command.getExcST6BId(), command.getOelin());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST6BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST6BCommand");
    UpdateExcST6BEvent event =
        new UpdateExcST6BEvent(
            command.getExcST6BId(),
            command.getIlr(),
            command.getK1(),
            command.getKcl(),
            command.getKff(),
            command.getKg(),
            command.getKia(),
            command.getKlr(),
            command.getKm(),
            command.getKpa(),
            command.getKvd(),
            command.getOelin(),
            command.getTg(),
            command.getTs(),
            command.getTvd(),
            command.getVamax(),
            command.getVamin(),
            command.getVilim(),
            command.getVimax(),
            command.getVimin(),
            command.getVmult(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST6BCommand");
    apply(new DeleteExcST6BEvent(command.getExcST6BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIlrToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignIlrToExcST6BCommand");

    if (ilr != null && ilr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ilr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIlrToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIlrFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIlrFromExcST6BCommand");

    if (ilr == null) throw new ProcessingException("Ilr already has nothing assigned.");

    apply(new UnAssignIlrFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignK1ToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToExcST6BCommand");

    if (k1 != null && k1.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignK1ToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromExcST6BCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKclToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKclToExcST6BCommand");

    if (kcl != null && kcl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kcl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKclToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKclFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKclFromExcST6BCommand");

    if (kcl == null) throw new ProcessingException("Kcl already has nothing assigned.");

    apply(new UnAssignKclFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKffToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKffToExcST6BCommand");

    if (kff != null && kff.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kff already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKffToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKffFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKffFromExcST6BCommand");

    if (kff == null) throw new ProcessingException("Kff already has nothing assigned.");

    apply(new UnAssignKffFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcST6BCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcST6BCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKiaToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiaToExcST6BCommand");

    if (kia != null && kia.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kia already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiaToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiaFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiaFromExcST6BCommand");

    if (kia == null) throw new ProcessingException("Kia already has nothing assigned.");

    apply(new UnAssignKiaFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKlrToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlrToExcST6BCommand");

    if (klr != null && klr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlrToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlrFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlrFromExcST6BCommand");

    if (klr == null) throw new ProcessingException("Klr already has nothing assigned.");

    apply(new UnAssignKlrFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKmToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKmToExcST6BCommand");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromExcST6BCommand");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKpaToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpaToExcST6BCommand");

    if (kpa != null && kpa.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpa already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpaToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpaFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpaFromExcST6BCommand");

    if (kpa == null) throw new ProcessingException("Kpa already has nothing assigned.");

    apply(new UnAssignKpaFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignKvdToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKvdToExcST6BCommand");

    if (kvd != null && kvd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kvd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKvdToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvdFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvdFromExcST6BCommand");

    if (kvd == null) throw new ProcessingException("Kvd already has nothing assigned.");

    apply(new UnAssignKvdFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignTgToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToExcST6BCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromExcST6BCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignTsToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTsToExcST6BCommand");

    if (ts != null && ts.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsFromExcST6BCommand");

    if (ts == null) throw new ProcessingException("Ts already has nothing assigned.");

    apply(new UnAssignTsFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignTvdToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvdToExcST6BCommand");

    if (tvd != null && tvd.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tvd already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvdToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvdFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvdFromExcST6BCommand");

    if (tvd == null) throw new ProcessingException("Tvd already has nothing assigned.");

    apply(new UnAssignTvdFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcST6BCommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcST6BCommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcST6BCommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcST6BCommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVilimToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVilimToExcST6BCommand");

    if (vilim != null && vilim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vilim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVilimToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVilimFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVilimFromExcST6BCommand");

    if (vilim == null) throw new ProcessingException("Vilim already has nothing assigned.");

    apply(new UnAssignVilimFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcST6BCommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcST6BCommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcST6BCommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcST6BCommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVmultToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmultToExcST6BCommand");

    if (vmult != null && vmult.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vmult already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVmultToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmultFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmultFromExcST6BCommand");

    if (vmult == null) throw new ProcessingException("Vmult already has nothing assigned.");

    apply(new UnAssignVmultFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST6BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST6BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST6BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST6BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST6BEvent(command.getExcST6BId()));
  }

  @CommandHandler
  public void handle(AssignXcToExcST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignXcToExcST6BCommand");

    if (xc != null && xc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXcToExcST6BEvent(command.getExcST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXcFromExcST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXcFromExcST6BCommand");

    if (xc == null) throw new ProcessingException("Xc already has nothing assigned.");

    apply(new UnAssignXcFromExcST6BEvent(command.getExcST6BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST6BEvent event) {
    LOGGER.info("Event sourcing CreateExcST6BEvent");
    this.excST6BId = event.getExcST6BId();
    this.oelin = event.getOelin();
  }

  @EventSourcingHandler
  void on(UpdateExcST6BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ilr = event.getIlr();
    this.k1 = event.getK1();
    this.kcl = event.getKcl();
    this.kff = event.getKff();
    this.kg = event.getKg();
    this.kia = event.getKia();
    this.klr = event.getKlr();
    this.km = event.getKm();
    this.kpa = event.getKpa();
    this.kvd = event.getKvd();
    this.oelin = event.getOelin();
    this.tg = event.getTg();
    this.ts = event.getTs();
    this.tvd = event.getTvd();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.vilim = event.getVilim();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vmult = event.getVmult();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xc = event.getXc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIlrToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignIlrToExcST6BEvent");
    this.ilr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIlrFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignIlrFromExcST6BEvent");
    this.ilr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignK1ToExcST6BEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromExcST6BEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKclToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKclToExcST6BEvent");
    this.kcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKclFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKclFromExcST6BEvent");
    this.kcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKffToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKffToExcST6BEvent");
    this.kff = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKffFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKffFromExcST6BEvent");
    this.kff = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcST6BEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcST6BEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiaToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKiaToExcST6BEvent");
    this.kia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiaFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiaFromExcST6BEvent");
    this.kia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlrToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKlrToExcST6BEvent");
    this.klr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlrFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlrFromExcST6BEvent");
    this.klr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKmToExcST6BEvent");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKmFromExcST6BEvent");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpaToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKpaToExcST6BEvent");
    this.kpa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpaFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpaFromExcST6BEvent");
    this.kpa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvdToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignKvdToExcST6BEvent");
    this.kvd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvdFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKvdFromExcST6BEvent");
    this.kvd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignTgToExcST6BEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromExcST6BEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignTsToExcST6BEvent");
    this.ts = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignTsFromExcST6BEvent");
    this.ts = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvdToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignTvdToExcST6BEvent");
    this.tvd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvdFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignTvdFromExcST6BEvent");
    this.tvd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcST6BEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcST6BEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcST6BEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcST6BEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVilimToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVilimToExcST6BEvent");
    this.vilim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVilimFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVilimFromExcST6BEvent");
    this.vilim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcST6BEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcST6BEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcST6BEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcST6BEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmultToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVmultToExcST6BEvent");
    this.vmult = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmultFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmultFromExcST6BEvent");
    this.vmult = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST6BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST6BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST6BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST6BEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXcToExcST6BEvent event) {
    LOGGER.info("Event sourcing AssignXcToExcST6BEvent");
    this.xc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXcFromExcST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignXcFromExcST6BEvent");
    this.xc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST6BId;

  private ExcST6BOELselectorKind oelin;
  private PU ilr = null;
  private BooleanProxy k1 = null;
  private PU kcl = null;
  private PU kff = null;
  private PU kg = null;
  private PU kia = null;
  private PU klr = null;
  private PU km = null;
  private PU kpa = null;
  private PU kvd = null;
  private Seconds tg = null;
  private Seconds ts = null;
  private Seconds tvd = null;
  private PU vamax = null;
  private PU vamin = null;
  private BooleanProxy vilim = null;
  private PU vimax = null;
  private PU vimin = null;
  private BooleanProxy vmult = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xc = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST6BAggregate.class.getName());
}
