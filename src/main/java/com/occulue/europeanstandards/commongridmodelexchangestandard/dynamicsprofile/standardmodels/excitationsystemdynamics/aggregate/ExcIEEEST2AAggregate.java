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
 * Aggregate handler for ExcIEEEST2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST2AAggregate(CreateExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST2ACommand");
    CreateExcIEEEST2AEvent event = new CreateExcIEEEST2AEvent(command.getExcIEEEST2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST2ACommand");
    UpdateExcIEEEST2AEvent event =
        new UpdateExcIEEEST2AEvent(
            command.getExcIEEEST2AId(),
            command.getEfdmax(),
            command.getKa(),
            command.getKc(),
            command.getKe(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getTa(),
            command.getTe(),
            command.getTf(),
            command.getUelin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST2ACommand");
    apply(new DeleteExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcIEEEST2ACommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcIEEEST2ACommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEST2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEST2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEST2ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEST2ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEST2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEST2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEST2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEST2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcIEEEST2ACommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcIEEEST2ACommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcIEEEST2ACommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcIEEEST2ACommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEST2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEST2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEST2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEST2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEST2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEST2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignUelinToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignUelinToExcIEEEST2ACommand");

    if (uelin != null && uelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelinToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelinFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelinFromExcIEEEST2ACommand");

    if (uelin == null) throw new ProcessingException("Uelin already has nothing assigned.");

    apply(new UnAssignUelinFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST2AEvent(command.getExcIEEEST2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST2AEvent");
    this.excIEEEST2AId = event.getExcIEEEST2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.ta = event.getTa();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.uelin = event.getUelin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcIEEEST2AEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcIEEEST2AEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEST2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEST2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEST2AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEST2AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEST2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEST2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEST2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEST2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcIEEEST2AEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcIEEEST2AEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcIEEEST2AEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcIEEEST2AEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEST2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEST2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEST2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEST2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEST2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEST2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelinToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignUelinToExcIEEEST2AEvent");
    this.uelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelinFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignUelinFromExcIEEEST2AEvent");
    this.uelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST2AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST2AId;

  private PU efdmax = null;
  private PU ka = null;
  private PU kc = null;
  private PU ke = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private Seconds ta = null;
  private Seconds te = null;
  private Seconds tf = null;
  private BooleanProxy uelin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST2AAggregate.class.getName());
}
