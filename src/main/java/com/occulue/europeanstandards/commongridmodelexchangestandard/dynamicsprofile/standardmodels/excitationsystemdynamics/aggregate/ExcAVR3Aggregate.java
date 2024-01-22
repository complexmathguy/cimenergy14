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
 * Aggregate handler for ExcAVR3 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR3 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR3Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR3Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR3Aggregate(CreateExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR3Command");
    CreateExcAVR3Event event = new CreateExcAVR3Event(command.getExcAVR3Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR3Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR3Command");
    UpdateExcAVR3Event event =
        new UpdateExcAVR3Event(
            command.getExcAVR3Id(),
            command.getE1(),
            command.getE2(),
            command.getKa(),
            command.getSe1(),
            command.getSe2(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getTe(),
            command.getVrmn(),
            command.getVrmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR3Command");
    apply(new DeleteExcAVR3Event(command.getExcAVR3Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcAVR3Command");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcAVR3Command");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcAVR3Command");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcAVR3Command");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAVR3Command");

    if (ka != null && ka.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKaToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAVR3Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignSe1ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignSe1ToExcAVR3Command");

    if (se1 != null && se1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe1ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe1FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe1FromExcAVR3Command");

    if (se1 == null) throw new ProcessingException("Se1 already has nothing assigned.");

    apply(new UnAssignSe1FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignSe2ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignSe2ToExcAVR3Command");

    if (se2 != null && se2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe2ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe2FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe2FromExcAVR3Command");

    if (se2 == null) throw new ProcessingException("Se2 already has nothing assigned.");

    apply(new UnAssignSe2FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcAVR3Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcAVR3Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcAVR3Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcAVR3Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcAVR3Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcAVR3Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToExcAVR3Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromExcAVR3Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAVR3Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAVR3Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignVrmnToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmnToExcAVR3Command");

    if (vrmn != null && vrmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmnToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmnFromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmnFromExcAVR3Command");

    if (vrmn == null) throw new ProcessingException("Vrmn already has nothing assigned.");

    apply(new UnAssignVrmnFromExcAVR3Event(command.getExcAVR3Id()));
  }

  @CommandHandler
  public void handle(AssignVrmxToExcAVR3Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmxToExcAVR3Command");

    if (vrmx != null && vrmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmxToExcAVR3Event(command.getExcAVR3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmxFromExcAVR3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmxFromExcAVR3Command");

    if (vrmx == null) throw new ProcessingException("Vrmx already has nothing assigned.");

    apply(new UnAssignVrmxFromExcAVR3Event(command.getExcAVR3Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR3Event event) {
    LOGGER.info("Event sourcing CreateExcAVR3Event");
    this.excAVR3Id = event.getExcAVR3Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR3Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.e1 = event.getE1();
    this.e2 = event.getE2();
    this.ka = event.getKa();
    this.se1 = event.getSe1();
    this.se2 = event.getSe2();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.te = event.getTe();
    this.vrmn = event.getVrmn();
    this.vrmx = event.getVrmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignE1ToExcAVR3Event");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcAVR3Event");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignE2ToExcAVR3Event");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcAVR3Event");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignKaToExcAVR3Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAVR3Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe1ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignSe1ToExcAVR3Event");
    this.se1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe1FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignSe1FromExcAVR3Event");
    this.se1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe2ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignSe2ToExcAVR3Event");
    this.se2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe2FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignSe2FromExcAVR3Event");
    this.se2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignT1ToExcAVR3Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcAVR3Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignT2ToExcAVR3Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcAVR3Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignT3ToExcAVR3Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcAVR3Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignT4ToExcAVR3Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromExcAVR3Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignTeToExcAVR3Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAVR3Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmnToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignVrmnToExcAVR3Event");
    this.vrmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmnFromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignVrmnFromExcAVR3Event");
    this.vrmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmxToExcAVR3Event event) {
    LOGGER.info("Event sourcing AssignVrmxToExcAVR3Event");
    this.vrmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmxFromExcAVR3Event event) {
    LOGGER.info("Event sourcing UnAssignVrmxFromExcAVR3Event");
    this.vrmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR3Id;

  private PU e1 = null;
  private PU e2 = null;
  private Simple_Float ka = null;
  private Simple_Float se1 = null;
  private Simple_Float se2 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds te = null;
  private PU vrmn = null;
  private PU vrmx = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR3Aggregate.class.getName());
}
