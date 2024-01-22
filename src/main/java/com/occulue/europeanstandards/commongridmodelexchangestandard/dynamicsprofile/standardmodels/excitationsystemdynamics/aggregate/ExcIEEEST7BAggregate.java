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
 * Aggregate handler for ExcIEEEST7B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST7B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST7BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST7BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST7BAggregate(CreateExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST7BCommand");
    CreateExcIEEEST7BEvent event =
        new CreateExcIEEEST7BEvent(
            command.getExcIEEEST7BId(), command.getOelin(), command.getUelin());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST7BCommand");
    UpdateExcIEEEST7BEvent event =
        new UpdateExcIEEEST7BEvent(
            command.getExcIEEEST7BId(),
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
            command.getUelin(),
            command.getVmax(),
            command.getVmin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST7BCommand");
    apply(new DeleteExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKhToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcIEEEST7BCommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcIEEEST7BCommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignKiaToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiaToExcIEEEST7BCommand");

    if (kia != null && kia.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kia already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiaToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiaFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiaFromExcIEEEST7BCommand");

    if (kia == null) throw new ProcessingException("Kia already has nothing assigned.");

    apply(new UnAssignKiaFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignKlToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlToExcIEEEST7BCommand");

    if (kl != null && kl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlFromExcIEEEST7BCommand");

    if (kl == null) throw new ProcessingException("Kl already has nothing assigned.");

    apply(new UnAssignKlFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignKpaToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpaToExcIEEEST7BCommand");

    if (kpa != null && kpa.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpa already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpaToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpaFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpaFromExcIEEEST7BCommand");

    if (kpa == null) throw new ProcessingException("Kpa already has nothing assigned.");

    apply(new UnAssignKpaFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEST7BCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEST7BCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEST7BCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEST7BCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEST7BCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEST7BCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignTgToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToExcIEEEST7BCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromExcIEEEST7BCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignTiaToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTiaToExcIEEEST7BCommand");

    if (tia != null && tia.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tia already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiaToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiaFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiaFromExcIEEEST7BCommand");

    if (tia == null) throw new ProcessingException("Tia already has nothing assigned.");

    apply(new UnAssignTiaFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignVmaxToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToExcIEEEST7BCommand");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromExcIEEEST7BCommand");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignVminToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVminToExcIEEEST7BCommand");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromExcIEEEST7BCommand");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST7BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST7BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST7BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST7BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST7BEvent(command.getExcIEEEST7BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST7BEvent");
    this.excIEEEST7BId = event.getExcIEEEST7BId();
    this.oelin = event.getOelin();
    this.uelin = event.getUelin();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST7BEvent event) {
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
  void on(AssignKhToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcIEEEST7BEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcIEEEST7BEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiaToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignKiaToExcIEEEST7BEvent");
    this.kia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiaFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiaFromExcIEEEST7BEvent");
    this.kia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignKlToExcIEEEST7BEvent");
    this.kl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlFromExcIEEEST7BEvent");
    this.kl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpaToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignKpaToExcIEEEST7BEvent");
    this.kpa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpaFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpaFromExcIEEEST7BEvent");
    this.kpa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEST7BEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEST7BEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEST7BEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEST7BEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEST7BEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEST7BEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignTgToExcIEEEST7BEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromExcIEEEST7BEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiaToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignTiaToExcIEEEST7BEvent");
    this.tia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiaFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTiaFromExcIEEEST7BEvent");
    this.tia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignVmaxToExcIEEEST7BEvent");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromExcIEEEST7BEvent");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignVminToExcIEEEST7BEvent");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVminFromExcIEEEST7BEvent");
    this.vmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST7BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST7BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST7BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST7BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST7BId;

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
  private PU vmax = null;
  private PU vmin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST7BAggregate.class.getName());
}
