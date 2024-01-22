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
 * Aggregate handler for ExcST2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST2AAggregate(CreateExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST2ACommand");
    CreateExcST2AEvent event = new CreateExcST2AEvent(command.getExcST2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST2ACommand");
    UpdateExcST2AEvent event =
        new UpdateExcST2AEvent(
            command.getExcST2AId(),
            command.getEfdmax(),
            command.getKa(),
            command.getKc(),
            command.getKe(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTe(),
            command.getTf(),
            command.getUelin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST2ACommand");
    apply(new DeleteExcST2AEvent(command.getExcST2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcST2ACommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcST2ACommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcST2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcST2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcST2ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcST2ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcST2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcST2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcST2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcST2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKiToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcST2ACommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcST2ACommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcST2ACommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcST2ACommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcST2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcST2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcST2ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcST2ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcST2ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcST2ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcST2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcST2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcST2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcST2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignUelinToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignUelinToExcST2ACommand");

    if (uelin != null && uelin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Uelin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignUelinToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUelinFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUelinFromExcST2ACommand");

    if (uelin == null) throw new ProcessingException("Uelin already has nothing assigned.");

    apply(new UnAssignUelinFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST2AEvent(command.getExcST2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST2AEvent(command.getExcST2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST2AEvent(command.getExcST2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST2AEvent event) {
    LOGGER.info("Event sourcing CreateExcST2AEvent");
    this.excST2AId = event.getExcST2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcST2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
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
  void on(AssignEfdmaxToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcST2AEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcST2AEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcST2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcST2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcST2AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcST2AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcST2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcST2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcST2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcST2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKiToExcST2AEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcST2AEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcST2AEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcST2AEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcST2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcST2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcST2AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcST2AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcST2AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcST2AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcST2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcST2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcST2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcST2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUelinToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignUelinToExcST2AEvent");
    this.uelin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUelinFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignUelinFromExcST2AEvent");
    this.uelin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST2AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST2AId;

  private PU efdmax = null;
  private PU ka = null;
  private PU kc = null;
  private PU ke = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds tf = null;
  private BooleanProxy uelin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST2AAggregate.class.getName());
}
