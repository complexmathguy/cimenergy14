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
 * Aggregate handler for ExcAVR4 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR4 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR4Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR4Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR4Aggregate(CreateExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR4Command");
    CreateExcAVR4Event event = new CreateExcAVR4Event(command.getExcAVR4Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR4Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR4Command");
    UpdateExcAVR4Event event =
        new UpdateExcAVR4Event(
            command.getExcAVR4Id(),
            command.getImul(),
            command.getKa(),
            command.getKe(),
            command.getKif(),
            command.getT1(),
            command.getT1if(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getTif(),
            command.getVfmn(),
            command.getVfmx(),
            command.getVrmn(),
            command.getVrmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR4Command");
    apply(new DeleteExcAVR4Event(command.getExcAVR4Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignImulToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignImulToExcAVR4Command");

    if (imul != null && imul.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Imul already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignImulToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignImulFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignImulFromExcAVR4Command");

    if (imul == null) throw new ProcessingException("Imul already has nothing assigned.");

    apply(new UnAssignImulFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAVR4Command");

    if (ka != null && ka.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKaToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAVR4Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAVR4Command");

    if (ke != null && ke.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKeToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAVR4Command");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignKifToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignKifToExcAVR4Command");

    if (kif != null && kif.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kif already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKifToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKifFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKifFromExcAVR4Command");

    if (kif == null) throw new ProcessingException("Kif already has nothing assigned.");

    apply(new UnAssignKifFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcAVR4Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcAVR4Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignT1ifToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ifToExcAVR4Command");

    if (t1if != null && t1if.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1if already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ifToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1ifFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1ifFromExcAVR4Command");

    if (t1if == null) throw new ProcessingException("T1if already has nothing assigned.");

    apply(new UnAssignT1ifFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcAVR4Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcAVR4Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcAVR4Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcAVR4Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToExcAVR4Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromExcAVR4Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignTifToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignTifToExcAVR4Command");

    if (tif != null && tif.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tif already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTifToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTifFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTifFromExcAVR4Command");

    if (tif == null) throw new ProcessingException("Tif already has nothing assigned.");

    apply(new UnAssignTifFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignVfmnToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignVfmnToExcAVR4Command");

    if (vfmn != null && vfmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfmnToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfmnFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfmnFromExcAVR4Command");

    if (vfmn == null) throw new ProcessingException("Vfmn already has nothing assigned.");

    apply(new UnAssignVfmnFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignVfmxToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignVfmxToExcAVR4Command");

    if (vfmx != null && vfmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfmxToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfmxFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfmxFromExcAVR4Command");

    if (vfmx == null) throw new ProcessingException("Vfmx already has nothing assigned.");

    apply(new UnAssignVfmxFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignVrmnToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmnToExcAVR4Command");

    if (vrmn != null && vrmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmnToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmnFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmnFromExcAVR4Command");

    if (vrmn == null) throw new ProcessingException("Vrmn already has nothing assigned.");

    apply(new UnAssignVrmnFromExcAVR4Event(command.getExcAVR4Id()));
  }

  @CommandHandler
  public void handle(AssignVrmxToExcAVR4Command command) throws Exception {
    LOGGER.info("Handling command AssignVrmxToExcAVR4Command");

    if (vrmx != null && vrmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmxToExcAVR4Event(command.getExcAVR4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmxFromExcAVR4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmxFromExcAVR4Command");

    if (vrmx == null) throw new ProcessingException("Vrmx already has nothing assigned.");

    apply(new UnAssignVrmxFromExcAVR4Event(command.getExcAVR4Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR4Event event) {
    LOGGER.info("Event sourcing CreateExcAVR4Event");
    this.excAVR4Id = event.getExcAVR4Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR4Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.imul = event.getImul();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kif = event.getKif();
    this.t1 = event.getT1();
    this.t1if = event.getT1if();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.tif = event.getTif();
    this.vfmn = event.getVfmn();
    this.vfmx = event.getVfmx();
    this.vrmn = event.getVrmn();
    this.vrmx = event.getVrmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignImulToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignImulToExcAVR4Event");
    this.imul = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignImulFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignImulFromExcAVR4Event");
    this.imul = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignKaToExcAVR4Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAVR4Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignKeToExcAVR4Event");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAVR4Event");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKifToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignKifToExcAVR4Event");
    this.kif = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKifFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignKifFromExcAVR4Event");
    this.kif = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignT1ToExcAVR4Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcAVR4Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ifToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignT1ifToExcAVR4Event");
    this.t1if = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1ifFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignT1ifFromExcAVR4Event");
    this.t1if = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignT2ToExcAVR4Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcAVR4Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignT3ToExcAVR4Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcAVR4Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignT4ToExcAVR4Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromExcAVR4Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTifToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignTifToExcAVR4Event");
    this.tif = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTifFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignTifFromExcAVR4Event");
    this.tif = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfmnToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignVfmnToExcAVR4Event");
    this.vfmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfmnFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignVfmnFromExcAVR4Event");
    this.vfmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfmxToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignVfmxToExcAVR4Event");
    this.vfmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfmxFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignVfmxFromExcAVR4Event");
    this.vfmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmnToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignVrmnToExcAVR4Event");
    this.vrmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmnFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignVrmnFromExcAVR4Event");
    this.vrmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmxToExcAVR4Event event) {
    LOGGER.info("Event sourcing AssignVrmxToExcAVR4Event");
    this.vrmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmxFromExcAVR4Event event) {
    LOGGER.info("Event sourcing UnAssignVrmxFromExcAVR4Event");
    this.vrmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR4Id;

  private BooleanProxy imul = null;
  private Simple_Float ka = null;
  private Simple_Float ke = null;
  private Simple_Float kif = null;
  private Seconds t1 = null;
  private Seconds t1if = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds tif = null;
  private PU vfmn = null;
  private PU vfmx = null;
  private PU vrmn = null;
  private PU vrmx = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR4Aggregate.class.getName());
}
