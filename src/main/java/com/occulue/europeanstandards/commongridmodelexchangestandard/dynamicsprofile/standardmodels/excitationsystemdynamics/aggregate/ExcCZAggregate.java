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
 * Aggregate handler for ExcCZ as outlined for the CQRS pattern, all write responsibilities related
 * to ExcCZ are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcCZAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcCZAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcCZAggregate(CreateExcCZCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcCZCommand");
    CreateExcCZEvent event = new CreateExcCZEvent(command.getExcCZId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcCZCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcCZCommand");
    UpdateExcCZEvent event =
        new UpdateExcCZEvent(
            command.getExcCZId(),
            command.getEfdmax(),
            command.getEfdmin(),
            command.getKa(),
            command.getKe(),
            command.getKp(),
            command.getTa(),
            command.getTc(),
            command.getTe(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcCZCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcCZCommand");
    apply(new DeleteExcCZEvent(command.getExcCZId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcCZCommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcCZCommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcCZCommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcCZCommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcCZCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcCZCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcCZCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcCZCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcCZCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcCZCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcCZCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcCZCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcCZCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcCZCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcCZCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcCZCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcCZCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcCZCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcCZEvent(command.getExcCZId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcCZCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcCZCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcCZEvent(command.getExcCZId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcCZCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcCZCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcCZEvent(command.getExcCZId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcCZEvent event) {
    LOGGER.info("Event sourcing CreateExcCZEvent");
    this.excCZId = event.getExcCZId();
  }

  @EventSourcingHandler
  void on(UpdateExcCZEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.efdmin = event.getEfdmin();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kp = event.getKp();
    this.ta = event.getTa();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcCZEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcCZEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcCZEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcCZEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcCZEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcCZEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcCZEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcCZEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcCZEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcCZEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcCZEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcCZEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcCZEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcCZEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcCZEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcCZEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcCZEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcCZEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcCZEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcCZEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcCZEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcCZEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excCZId;

  private PU efdmax = null;
  private PU efdmin = null;
  private PU ka = null;
  private PU ke = null;
  private PU kp = null;
  private Seconds ta = null;
  private Seconds tc = null;
  private Seconds te = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcCZAggregate.class.getName());
}
