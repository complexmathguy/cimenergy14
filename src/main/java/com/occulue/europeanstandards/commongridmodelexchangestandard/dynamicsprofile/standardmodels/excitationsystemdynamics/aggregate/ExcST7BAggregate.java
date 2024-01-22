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
 * Aggregate handler for ExcST7B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST7B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST7BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST7BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST7BAggregate(CreateExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST7BCommand");
    CreateExcST7BEvent event =
        new CreateExcST7BEvent(command.getExcST7BId(), command.getOelin(), command.getUelin());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST7BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST7BCommand");
    UpdateExcST7BEvent event =
        new UpdateExcST7BEvent(
            command.getExcST7BId(),
            command.getKh(),
            command.getKia(),
            command.getKl(),
            command.getKpa(),
            command.getOelin(),
            command.getTb(),
            command.getTc(),
            command.getTf(),
            command.getTg(),
            command.getTia(),
            command.getTs(),
            command.getUelin(),
            command.getVmax(),
            command.getVmin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST7BCommand");
    apply(new DeleteExcST7BEvent(command.getExcST7BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKhToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcST7BCommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcST7BCommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignKiaToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiaToExcST7BCommand");

    if (kia != null && kia.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kia already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiaToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiaFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiaFromExcST7BCommand");

    if (kia == null) throw new ProcessingException("Kia already has nothing assigned.");

    apply(new UnAssignKiaFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignKlToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlToExcST7BCommand");

    if (kl != null && kl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlFromExcST7BCommand");

    if (kl == null) throw new ProcessingException("Kl already has nothing assigned.");

    apply(new UnAssignKlFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignKpaToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpaToExcST7BCommand");

    if (kpa != null && kpa.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpa already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpaToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpaFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpaFromExcST7BCommand");

    if (kpa == null) throw new ProcessingException("Kpa already has nothing assigned.");

    apply(new UnAssignKpaFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcST7BCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcST7BCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcST7BCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcST7BCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcST7BCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcST7BCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTgToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToExcST7BCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromExcST7BCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTiaToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTiaToExcST7BCommand");

    if (tia != null && tia.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tia already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiaToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiaFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiaFromExcST7BCommand");

    if (tia == null) throw new ProcessingException("Tia already has nothing assigned.");

    apply(new UnAssignTiaFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignTsToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTsToExcST7BCommand");

    if (ts != null && ts.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsFromExcST7BCommand");

    if (ts == null) throw new ProcessingException("Ts already has nothing assigned.");

    apply(new UnAssignTsFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignVmaxToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToExcST7BCommand");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromExcST7BCommand");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignVminToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVminToExcST7BCommand");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromExcST7BCommand");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST7BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST7BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST7BEvent(command.getExcST7BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST7BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST7BEvent(command.getExcST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST7BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST7BEvent(command.getExcST7BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST7BEvent event) {
    LOGGER.info("Event sourcing CreateExcST7BEvent");
    this.excST7BId = event.getExcST7BId();
    this.oelin = event.getOelin();
    this.uelin = event.getUelin();
  }

  @EventSourcingHandler
  void on(UpdateExcST7BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kh = event.getKh();
    this.kia = event.getKia();
    this.kl = event.getKl();
    this.kpa = event.getKpa();
    this.oelin = event.getOelin();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.tf = event.getTf();
    this.tg = event.getTg();
    this.tia = event.getTia();
    this.ts = event.getTs();
    this.uelin = event.getUelin();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcST7BEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcST7BEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiaToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignKiaToExcST7BEvent");
    this.kia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiaFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiaFromExcST7BEvent");
    this.kia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignKlToExcST7BEvent");
    this.kl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlFromExcST7BEvent");
    this.kl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpaToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignKpaToExcST7BEvent");
    this.kpa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpaFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpaFromExcST7BEvent");
    this.kpa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcST7BEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcST7BEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcST7BEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcST7BEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcST7BEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcST7BEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTgToExcST7BEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromExcST7BEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiaToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTiaToExcST7BEvent");
    this.tia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiaFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTiaFromExcST7BEvent");
    this.tia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignTsToExcST7BEvent");
    this.ts = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTsFromExcST7BEvent");
    this.ts = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignVmaxToExcST7BEvent");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromExcST7BEvent");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignVminToExcST7BEvent");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVminFromExcST7BEvent");
    this.vmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST7BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST7BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST7BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST7BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST7BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST7BId;

  private ExcST7BOELselectorKind oelin;
  private ExcST7BUELselectorKind uelin;
  private PU kh = null;
  private PU kia = null;
  private PU kl = null;
  private PU kpa = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds tf = null;
  private Seconds tg = null;
  private Seconds tia = null;
  private Seconds ts = null;
  private PU vmax = null;
  private PU vmin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST7BAggregate.class.getName());
}
