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
 * Aggregate handler for ExcAVR1 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR1Aggregate(CreateExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR1Command");
    CreateExcAVR1Event event = new CreateExcAVR1Event(command.getExcAVR1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR1Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR1Command");
    UpdateExcAVR1Event event =
        new UpdateExcAVR1Event(
            command.getExcAVR1Id(),
            command.getE1(),
            command.getE2(),
            command.getKa(),
            command.getKf(),
            command.getSe1(),
            command.getSe2(),
            command.getTa(),
            command.getTb(),
            command.getTe(),
            command.getTf(),
            command.getVrmn(),
            command.getVrmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR1Command");
    apply(new DeleteExcAVR1Event(command.getExcAVR1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcAVR1Command");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcAVR1Command");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcAVR1Command");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcAVR1Command");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAVR1Command");

    if (ka != null && ka.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKaToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAVR1Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAVR1Command");

    if (kf != null && kf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKfToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAVR1Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignSe1ToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignSe1ToExcAVR1Command");

    if (se1 != null && se1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe1ToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe1FromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe1FromExcAVR1Command");

    if (se1 == null) throw new ProcessingException("Se1 already has nothing assigned.");

    apply(new UnAssignSe1FromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignSe2ToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignSe2ToExcAVR1Command");

    if (se2 != null && se2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe2ToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe2FromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe2FromExcAVR1Command");

    if (se2 == null) throw new ProcessingException("Se2 already has nothing assigned.");

    apply(new UnAssignSe2FromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAVR1Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAVR1Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAVR1Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAVR1Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAVR1Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAVR1Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignTfToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcAVR1Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcAVR1Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignVrmnToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmnToExcAVR1Command");

    if (vrmn != null && vrmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmnToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmnFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmnFromExcAVR1Command");

    if (vrmn == null) throw new ProcessingException("Vrmn already has nothing assigned.");

    apply(new UnAssignVrmnFromExcAVR1Event(command.getExcAVR1Id()));
  }

  @CommandHandler
  public void handle(AssignVrmxToExcAVR1Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmxToExcAVR1Command");

    if (vrmx != null && vrmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmxToExcAVR1Event(command.getExcAVR1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmxFromExcAVR1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmxFromExcAVR1Command");

    if (vrmx == null) throw new ProcessingException("Vrmx already has nothing assigned.");

    apply(new UnAssignVrmxFromExcAVR1Event(command.getExcAVR1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR1Event event) {
    LOGGER.info("Event sourcing CreateExcAVR1Event");
    this.excAVR1Id = event.getExcAVR1Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.e1 = event.getE1();
    this.e2 = event.getE2();
    this.ka = event.getKa();
    this.kf = event.getKf();
    this.se1 = event.getSe1();
    this.se2 = event.getSe2();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vrmn = event.getVrmn();
    this.vrmx = event.getVrmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignE1ToExcAVR1Event");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcAVR1Event");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignE2ToExcAVR1Event");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcAVR1Event");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignKaToExcAVR1Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAVR1Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignKfToExcAVR1Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAVR1Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe1ToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignSe1ToExcAVR1Event");
    this.se1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe1FromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignSe1FromExcAVR1Event");
    this.se1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe2ToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignSe2ToExcAVR1Event");
    this.se2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe2FromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignSe2FromExcAVR1Event");
    this.se2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignTaToExcAVR1Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAVR1Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignTbToExcAVR1Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAVR1Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignTeToExcAVR1Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAVR1Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignTfToExcAVR1Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcAVR1Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmnToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignVrmnToExcAVR1Event");
    this.vrmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmnFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignVrmnFromExcAVR1Event");
    this.vrmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmxToExcAVR1Event event) {
    LOGGER.info("Event sourcing AssignVrmxToExcAVR1Event");
    this.vrmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmxFromExcAVR1Event event) {
    LOGGER.info("Event sourcing UnAssignVrmxFromExcAVR1Event");
    this.vrmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR1Id;

  private PU e1 = null;
  private PU e2 = null;
  private Simple_Float ka = null;
  private Simple_Float kf = null;
  private Simple_Float se1 = null;
  private Simple_Float se2 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vrmn = null;
  private PU vrmx = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR1Aggregate.class.getName());
}
