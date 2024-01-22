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
 * Aggregate handler for ExcIEEEAC4A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC4A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC4AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC4AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC4AAggregate(CreateExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC4ACommand");
    CreateExcIEEEAC4AEvent event = new CreateExcIEEEAC4AEvent(command.getExcIEEEAC4AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC4ACommand");
    UpdateExcIEEEAC4AEvent event =
        new UpdateExcIEEEAC4AEvent(
            command.getExcIEEEAC4AId(),
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
  public void handle(DeleteExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC4ACommand");
    apply(new DeleteExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC4ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC4ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC4ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC4ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC4ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC4ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEAC4ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEAC4ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEAC4ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEAC4ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcIEEEAC4ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcIEEEAC4ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcIEEEAC4ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcIEEEAC4ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC4ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC4ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC4ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC4ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC4ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC4AEvent");
    this.excIEEEAC4AId = event.getExcIEEEAC4AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC4AEvent event) {
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
  void on(AssignKaToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC4AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC4AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC4AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC4AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC4AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC4AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEAC4AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEAC4AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEAC4AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEAC4AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcIEEEAC4AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcIEEEAC4AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcIEEEAC4AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcIEEEAC4AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC4AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC4AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC4AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC4AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC4AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC4AId;

  private PU ka = null;
  private PU kc = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC4AAggregate.class.getName());
}
