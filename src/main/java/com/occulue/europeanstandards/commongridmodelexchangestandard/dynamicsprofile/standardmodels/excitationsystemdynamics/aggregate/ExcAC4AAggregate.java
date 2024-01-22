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
 * Aggregate handler for ExcAC4A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC4A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC4AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC4AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC4AAggregate(CreateExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC4ACommand");
    CreateExcAC4AEvent event = new CreateExcAC4AEvent(command.getExcAC4AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC4ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC4ACommand");
    UpdateExcAC4AEvent event =
        new UpdateExcAC4AEvent(
            command.getExcAC4AId(),
            command.getKa(),
            command.getKc(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getVimax(),
            command.getVimin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC4ACommand");
    apply(new DeleteExcAC4AEvent(command.getExcAC4AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC4ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC4ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC4ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC4ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC4ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC4ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC4ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC4ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC4ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC4ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcAC4ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcAC4ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcAC4ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcAC4ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC4ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC4ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC4AEvent(command.getExcAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC4ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC4AEvent(command.getExcAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC4ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC4AEvent(command.getExcAC4AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC4AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC4AEvent");
    this.excAC4AId = event.getExcAC4AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC4AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC4AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC4AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC4AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC4AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC4AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC4AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC4AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC4AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC4AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC4AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcAC4AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcAC4AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcAC4AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcAC4AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC4AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC4AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC4AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC4AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC4AId;

  private PU ka = null;
  private PU kc = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC4AAggregate.class.getName());
}
