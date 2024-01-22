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
 * Aggregate handler for ExcAVR2 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR2Aggregate(CreateExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR2Command");
    CreateExcAVR2Event event = new CreateExcAVR2Event(command.getExcAVR2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR2Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR2Command");
    UpdateExcAVR2Event event =
        new UpdateExcAVR2Event(
            command.getExcAVR2Id(),
            command.getE1(),
            command.getE2(),
            command.getKa(),
            command.getKf(),
            command.getSe1(),
            command.getSe2(),
            command.getTa(),
            command.getTb(),
            command.getTe(),
            command.getTf1(),
            command.getTf2(),
            command.getVrmn(),
            command.getVrmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR2Command");
    apply(new DeleteExcAVR2Event(command.getExcAVR2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcAVR2Command");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcAVR2Command");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcAVR2Command");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcAVR2Command");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAVR2Command");

    if (ka != null && ka.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKaToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAVR2Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAVR2Command");

    if (kf != null && kf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKfToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAVR2Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignSe1ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignSe1ToExcAVR2Command");

    if (se1 != null && se1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe1ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe1FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe1FromExcAVR2Command");

    if (se1 == null) throw new ProcessingException("Se1 already has nothing assigned.");

    apply(new UnAssignSe1FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignSe2ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignSe2ToExcAVR2Command");

    if (se2 != null && se2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Se2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSe2ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe2FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe2FromExcAVR2Command");

    if (se2 == null) throw new ProcessingException("Se2 already has nothing assigned.");

    apply(new UnAssignSe2FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAVR2Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAVR2Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAVR2Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAVR2Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAVR2Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAVR2Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcAVR2Command");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcAVR2Command");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignTf2ToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToExcAVR2Command");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromExcAVR2Command");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignVrmnToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmnToExcAVR2Command");

    if (vrmn != null && vrmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmnToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmnFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmnFromExcAVR2Command");

    if (vrmn == null) throw new ProcessingException("Vrmn already has nothing assigned.");

    apply(new UnAssignVrmnFromExcAVR2Event(command.getExcAVR2Id()));
  }

  @CommandHandler
  public void handle(AssignVrmxToExcAVR2Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmxToExcAVR2Command");

    if (vrmx != null && vrmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmxToExcAVR2Event(command.getExcAVR2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmxFromExcAVR2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmxFromExcAVR2Command");

    if (vrmx == null) throw new ProcessingException("Vrmx already has nothing assigned.");

    apply(new UnAssignVrmxFromExcAVR2Event(command.getExcAVR2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR2Event event) {
    LOGGER.info("Event sourcing CreateExcAVR2Event");
    this.excAVR2Id = event.getExcAVR2Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR2Event event) {
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
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.vrmn = event.getVrmn();
    this.vrmx = event.getVrmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignE1ToExcAVR2Event");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcAVR2Event");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignE2ToExcAVR2Event");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcAVR2Event");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignKaToExcAVR2Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAVR2Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignKfToExcAVR2Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAVR2Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe1ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignSe1ToExcAVR2Event");
    this.se1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe1FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignSe1FromExcAVR2Event");
    this.se1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe2ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignSe2ToExcAVR2Event");
    this.se2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe2FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignSe2FromExcAVR2Event");
    this.se2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignTaToExcAVR2Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAVR2Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignTbToExcAVR2Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAVR2Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignTeToExcAVR2Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAVR2Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignTf1ToExcAVR2Event");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcAVR2Event");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignTf2ToExcAVR2Event");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignTf2FromExcAVR2Event");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmnToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignVrmnToExcAVR2Event");
    this.vrmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmnFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignVrmnFromExcAVR2Event");
    this.vrmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmxToExcAVR2Event event) {
    LOGGER.info("Event sourcing AssignVrmxToExcAVR2Event");
    this.vrmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmxFromExcAVR2Event event) {
    LOGGER.info("Event sourcing UnAssignVrmxFromExcAVR2Event");
    this.vrmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR2Id;

  private PU e1 = null;
  private PU e2 = null;
  private Simple_Float ka = null;
  private Simple_Float kf = null;
  private Simple_Float se1 = null;
  private Simple_Float se2 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds te = null;
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private PU vrmn = null;
  private PU vrmx = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR2Aggregate.class.getName());
}
