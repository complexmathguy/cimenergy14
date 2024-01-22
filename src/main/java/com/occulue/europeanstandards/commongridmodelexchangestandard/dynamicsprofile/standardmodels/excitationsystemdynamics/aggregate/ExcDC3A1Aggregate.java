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
 * Aggregate handler for ExcDC3A1 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcDC3A1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcDC3A1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcDC3A1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcDC3A1Aggregate(CreateExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command CreateExcDC3A1Command");
    CreateExcDC3A1Event event = new CreateExcDC3A1Event(command.getExcDC3A1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcDC3A1Command command) throws Exception {
    LOGGER.info("handling command UpdateExcDC3A1Command");
    UpdateExcDC3A1Event event =
        new UpdateExcDC3A1Event(
            command.getExcDC3A1Id(),
            command.getExclim(),
            command.getKa(),
            command.getKe(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getTa(),
            command.getTe(),
            command.getTf(),
            command.getVb1max(),
            command.getVblim(),
            command.getVbmax(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcDC3A1Command");
    apply(new DeleteExcDC3A1Event(command.getExcDC3A1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignExclimToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcDC3A1Command");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcDC3A1Command");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignKaToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcDC3A1Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcDC3A1Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignKeToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcDC3A1Command");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcDC3A1Command");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignKfToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcDC3A1Command");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcDC3A1Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignKiToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignKiToExcDC3A1Command");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromExcDC3A1Command");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignKpToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcDC3A1Command");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcDC3A1Command");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignTaToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcDC3A1Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcDC3A1Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignTeToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcDC3A1Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcDC3A1Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignTfToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcDC3A1Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcDC3A1Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignVb1maxToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignVb1maxToExcDC3A1Command");

    if (vb1max != null && vb1max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vb1max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVb1maxToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVb1maxFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVb1maxFromExcDC3A1Command");

    if (vb1max == null) throw new ProcessingException("Vb1max already has nothing assigned.");

    apply(new UnAssignVb1maxFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignVblimToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignVblimToExcDC3A1Command");

    if (vblim != null && vblim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vblim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVblimToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVblimFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVblimFromExcDC3A1Command");

    if (vblim == null) throw new ProcessingException("Vblim already has nothing assigned.");

    apply(new UnAssignVblimFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignVbmaxToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignVbmaxToExcDC3A1Command");

    if (vbmax != null && vbmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vbmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVbmaxToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVbmaxFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVbmaxFromExcDC3A1Command");

    if (vbmax == null) throw new ProcessingException("Vbmax already has nothing assigned.");

    apply(new UnAssignVbmaxFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcDC3A1Command");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcDC3A1Command");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcDC3A1Command command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcDC3A1Command");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcDC3A1Event(command.getExcDC3A1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcDC3A1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcDC3A1Command");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcDC3A1Event(command.getExcDC3A1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcDC3A1Event event) {
    LOGGER.info("Event sourcing CreateExcDC3A1Event");
    this.excDC3A1Id = event.getExcDC3A1Id();
  }

  @EventSourcingHandler
  void on(UpdateExcDC3A1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.exclim = event.getExclim();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.ta = event.getTa();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vb1max = event.getVb1max();
    this.vblim = event.getVblim();
    this.vbmax = event.getVbmax();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignExclimToExcDC3A1Event");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcDC3A1Event");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignKaToExcDC3A1Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcDC3A1Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignKeToExcDC3A1Event");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcDC3A1Event");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignKfToExcDC3A1Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcDC3A1Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignKiToExcDC3A1Event");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignKiFromExcDC3A1Event");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignKpToExcDC3A1Event");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcDC3A1Event");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignTaToExcDC3A1Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcDC3A1Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignTeToExcDC3A1Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcDC3A1Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignTfToExcDC3A1Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcDC3A1Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVb1maxToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignVb1maxToExcDC3A1Event");
    this.vb1max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVb1maxFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignVb1maxFromExcDC3A1Event");
    this.vb1max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVblimToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignVblimToExcDC3A1Event");
    this.vblim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVblimFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignVblimFromExcDC3A1Event");
    this.vblim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVbmaxToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignVbmaxToExcDC3A1Event");
    this.vbmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVbmaxFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignVbmaxFromExcDC3A1Event");
    this.vbmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcDC3A1Event");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcDC3A1Event");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcDC3A1Event event) {
    LOGGER.info("Event sourcing AssignVrminToExcDC3A1Event");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcDC3A1Event event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcDC3A1Event");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excDC3A1Id;

  private BooleanProxy exclim = null;
  private PU ka = null;
  private PU ke = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private Seconds ta = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vb1max = null;
  private BooleanProxy vblim = null;
  private PU vbmax = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcDC3A1Aggregate.class.getName());
}
