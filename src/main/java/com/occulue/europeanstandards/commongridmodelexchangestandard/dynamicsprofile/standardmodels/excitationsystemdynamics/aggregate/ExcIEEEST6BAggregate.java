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
 * Aggregate handler for ExcIEEEST6B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST6B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST6BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST6BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST6BAggregate(CreateExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST6BCommand");
    CreateExcIEEEST6BEvent event =
        new CreateExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getOelin());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST6BCommand");
    UpdateExcIEEEST6BEvent event =
        new UpdateExcIEEEST6BEvent(
            command.getExcIEEEST6BId(),
            command.getIlr(),
            command.getKci(),
            command.getKff(),
            command.getKg(),
            command.getKia(),
            command.getKlr(),
            command.getKm(),
            command.getKpa(),
            command.getOelin(),
            command.getTg(),
            command.getVamax(),
            command.getVamin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST6BCommand");
    apply(new DeleteExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIlrToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignIlrToExcIEEEST6BCommand");

    if (ilr != null && ilr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ilr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIlrToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIlrFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIlrFromExcIEEEST6BCommand");

    if (ilr == null) throw new ProcessingException("Ilr already has nothing assigned.");

    apply(new UnAssignIlrFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKciToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKciToExcIEEEST6BCommand");

    if (kci != null && kci.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kci already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKciToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKciFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKciFromExcIEEEST6BCommand");

    if (kci == null) throw new ProcessingException("Kci already has nothing assigned.");

    apply(new UnAssignKciFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKffToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKffToExcIEEEST6BCommand");

    if (kff != null && kff.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kff already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKffToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKffFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKffFromExcIEEEST6BCommand");

    if (kff == null) throw new ProcessingException("Kff already has nothing assigned.");

    apply(new UnAssignKffFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKgToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToExcIEEEST6BCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromExcIEEEST6BCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKiaToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiaToExcIEEEST6BCommand");

    if (kia != null && kia.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kia already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiaToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiaFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiaFromExcIEEEST6BCommand");

    if (kia == null) throw new ProcessingException("Kia already has nothing assigned.");

    apply(new UnAssignKiaFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKlrToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlrToExcIEEEST6BCommand");

    if (klr != null && klr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlrToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlrFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlrFromExcIEEEST6BCommand");

    if (klr == null) throw new ProcessingException("Klr already has nothing assigned.");

    apply(new UnAssignKlrFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKmToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKmToExcIEEEST6BCommand");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromExcIEEEST6BCommand");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignKpaToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpaToExcIEEEST6BCommand");

    if (kpa != null && kpa.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpa already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpaToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpaFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpaFromExcIEEEST6BCommand");

    if (kpa == null) throw new ProcessingException("Kpa already has nothing assigned.");

    apply(new UnAssignKpaFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignTgToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToExcIEEEST6BCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromExcIEEEST6BCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEST6BCommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEST6BCommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEST6BCommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEST6BCommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST6BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST6BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST6BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST6BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST6BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST6BEvent(command.getExcIEEEST6BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST6BEvent");
    this.excIEEEST6BId = event.getExcIEEEST6BId();
    this.oelin = event.getOelin();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ilr = event.getIlr();
    this.kci = event.getKci();
    this.kff = event.getKff();
    this.kg = event.getKg();
    this.kia = event.getKia();
    this.klr = event.getKlr();
    this.km = event.getKm();
    this.kpa = event.getKpa();
    this.oelin = event.getOelin();
    this.tg = event.getTg();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIlrToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignIlrToExcIEEEST6BEvent");
    this.ilr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIlrFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignIlrFromExcIEEEST6BEvent");
    this.ilr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKciToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKciToExcIEEEST6BEvent");
    this.kci = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKciFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKciFromExcIEEEST6BEvent");
    this.kci = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKffToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKffToExcIEEEST6BEvent");
    this.kff = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKffFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKffFromExcIEEEST6BEvent");
    this.kff = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKgToExcIEEEST6BEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromExcIEEEST6BEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiaToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKiaToExcIEEEST6BEvent");
    this.kia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiaFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiaFromExcIEEEST6BEvent");
    this.kia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlrToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKlrToExcIEEEST6BEvent");
    this.klr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlrFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlrFromExcIEEEST6BEvent");
    this.klr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKmToExcIEEEST6BEvent");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKmFromExcIEEEST6BEvent");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpaToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignKpaToExcIEEEST6BEvent");
    this.kpa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpaFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpaFromExcIEEEST6BEvent");
    this.kpa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignTgToExcIEEEST6BEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromExcIEEEST6BEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEST6BEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEST6BEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEST6BEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEST6BEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST6BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST6BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST6BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST6BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST6BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST6BId;

  private ExcST6BOELselectorKind oelin;
  private PU ilr = null;
  private PU kci = null;
  private PU kff = null;
  private PU kg = null;
  private PU kia = null;
  private PU klr = null;
  private PU km = null;
  private PU kpa = null;
  private Seconds tg = null;
  private PU vamax = null;
  private PU vamin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST6BAggregate.class.getName());
}
