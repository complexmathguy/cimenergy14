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
 * Aggregate handler for ExcIEEEAC5A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC5A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC5AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC5AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC5AAggregate(CreateExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC5ACommand");
    CreateExcIEEEAC5AEvent event = new CreateExcIEEEAC5AEvent(command.getExcIEEEAC5AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC5ACommand");
    UpdateExcIEEEAC5AEvent event =
        new UpdateExcIEEEAC5AEvent(
            command.getExcIEEEAC5AId(),
            command.getEfd1(),
            command.getEfd2(),
            command.getKa(),
            command.getKe(),
            command.getKf(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTa(),
            command.getTe(),
            command.getTf1(),
            command.getTf2(),
            command.getTf3(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC5ACommand");
    apply(new DeleteExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcIEEEAC5ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcIEEEAC5ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcIEEEAC5ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcIEEEAC5ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC5ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC5ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC5ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC5ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEAC5ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEAC5ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcIEEEAC5ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcIEEEAC5ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcIEEEAC5ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcIEEEAC5ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC5ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC5ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC5ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC5ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcIEEEAC5ACommand");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcIEEEAC5ACommand");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf2ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToExcIEEEAC5ACommand");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromExcIEEEAC5ACommand");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignTf3ToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTf3ToExcIEEEAC5ACommand");

    if (tf3 != null && tf3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf3ToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf3FromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf3FromExcIEEEAC5ACommand");

    if (tf3 == null) throw new ProcessingException("Tf3 already has nothing assigned.");

    apply(new UnAssignTf3FromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC5ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC5ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC5ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC5ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC5ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC5AEvent");
    this.excIEEEAC5AId = event.getExcIEEEAC5AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.ka = event.getKa();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.ta = event.getTa();
    this.te = event.getTe();
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.tf3 = event.getTf3();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcIEEEAC5AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcIEEEAC5AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcIEEEAC5AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcIEEEAC5AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC5AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC5AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC5AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC5AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEAC5AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEAC5AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcIEEEAC5AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcIEEEAC5AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcIEEEAC5AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcIEEEAC5AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC5AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC5AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC5AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC5AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf1ToExcIEEEAC5AEvent");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcIEEEAC5AEvent");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf2ToExcIEEEAC5AEvent");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf2FromExcIEEEAC5AEvent");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf3ToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignTf3ToExcIEEEAC5AEvent");
    this.tf3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf3FromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignTf3FromExcIEEEAC5AEvent");
    this.tf3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC5AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC5AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC5AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC5AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC5AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC5AId;

  private PU efd1 = null;
  private PU efd2 = null;
  private PU ka = null;
  private PU ke = null;
  private PU kf = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds ta = null;
  private Seconds te = null;
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private Seconds tf3 = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC5AAggregate.class.getName());
}
