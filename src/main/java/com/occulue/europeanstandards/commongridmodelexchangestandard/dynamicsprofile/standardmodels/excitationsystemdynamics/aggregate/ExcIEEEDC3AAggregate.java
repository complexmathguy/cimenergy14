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
 * Aggregate handler for ExcIEEEDC3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEDC3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEDC3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEDC3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEDC3AAggregate(CreateExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEDC3ACommand");
    CreateExcIEEEDC3AEvent event = new CreateExcIEEEDC3AEvent(command.getExcIEEEDC3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEDC3ACommand");
    UpdateExcIEEEDC3AEvent event =
        new UpdateExcIEEEDC3AEvent(
            command.getExcIEEEDC3AId(),
            command.getEfd1(),
            command.getEfd2(),
            command.getExclim(),
            command.getKe(),
            command.getKv(),
            command.getSeefd1(),
            command.getSeefd2(),
            command.getTe(),
            command.getTrh(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEDC3ACommand");
    apply(new DeleteExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToExcIEEEDC3ACommand");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromExcIEEEDC3ACommand");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToExcIEEEDC3ACommand");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromExcIEEEDC3ACommand");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignExclimToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignExclimToExcIEEEDC3ACommand");

    if (exclim != null && exclim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Exclim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignExclimToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExclimFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignExclimFromExcIEEEDC3ACommand");

    if (exclim == null) throw new ProcessingException("Exclim already has nothing assigned.");

    apply(new UnAssignExclimFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEDC3ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEDC3ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignKvToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKvToExcIEEEDC3ACommand");

    if (kv != null && kv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKvToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvFromExcIEEEDC3ACommand");

    if (kv == null) throw new ProcessingException("Kv already has nothing assigned.");

    apply(new UnAssignKvFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd1ToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd1ToExcIEEEDC3ACommand");

    if (seefd1 != null && seefd1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd1ToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd1FromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd1FromExcIEEEDC3ACommand");

    if (seefd1 == null) throw new ProcessingException("Seefd1 already has nothing assigned.");

    apply(new UnAssignSeefd1FromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeefd2ToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeefd2ToExcIEEEDC3ACommand");

    if (seefd2 != null && seefd2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seefd2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeefd2ToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeefd2FromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeefd2FromExcIEEEDC3ACommand");

    if (seefd2 == null) throw new ProcessingException("Seefd2 already has nothing assigned.");

    apply(new UnAssignSeefd2FromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEDC3ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEDC3ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignTrhToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTrhToExcIEEEDC3ACommand");

    if (trh != null && trh.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Trh already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrhToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrhFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrhFromExcIEEEDC3ACommand");

    if (trh == null) throw new ProcessingException("Trh already has nothing assigned.");

    apply(new UnAssignTrhFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEDC3ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEDC3ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEDC3ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEDC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEDC3ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEDC3AEvent");
    this.excIEEEDC3AId = event.getExcIEEEDC3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.exclim = event.getExclim();
    this.ke = event.getKe();
    this.kv = event.getKv();
    this.seefd1 = event.getSeefd1();
    this.seefd2 = event.getSeefd2();
    this.te = event.getTe();
    this.trh = event.getTrh();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfd1ToExcIEEEDC3AEvent");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromExcIEEEDC3AEvent");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfd2ToExcIEEEDC3AEvent");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromExcIEEEDC3AEvent");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignExclimToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignExclimToExcIEEEDC3AEvent");
    this.exclim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExclimFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignExclimFromExcIEEEDC3AEvent");
    this.exclim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEDC3AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEDC3AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignKvToExcIEEEDC3AEvent");
    this.kv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKvFromExcIEEEDC3AEvent");
    this.kv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd1ToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd1ToExcIEEEDC3AEvent");
    this.seefd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd1FromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd1FromExcIEEEDC3AEvent");
    this.seefd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeefd2ToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeefd2ToExcIEEEDC3AEvent");
    this.seefd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeefd2FromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeefd2FromExcIEEEDC3AEvent");
    this.seefd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEDC3AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEDC3AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrhToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignTrhToExcIEEEDC3AEvent");
    this.trh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrhFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTrhFromExcIEEEDC3AEvent");
    this.trh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEDC3AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEDC3AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEDC3AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEDC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEDC3AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEDC3AId;

  private PU efd1 = null;
  private PU efd2 = null;
  private BooleanProxy exclim = null;
  private PU ke = null;
  private PU kv = null;
  private Simple_Float seefd1 = null;
  private Simple_Float seefd2 = null;
  private Seconds te = null;
  private Seconds trh = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC3AAggregate.class.getName());
}
