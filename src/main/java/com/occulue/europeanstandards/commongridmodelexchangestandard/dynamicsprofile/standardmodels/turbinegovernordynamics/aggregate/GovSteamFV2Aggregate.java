package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.aggregate;

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
 * Aggregate handler for GovSteamFV2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamFV2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamFV2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamFV2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamFV2Aggregate(CreateGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamFV2Command");
    CreateGovSteamFV2Event event = new CreateGovSteamFV2Event(command.getGovSteamFV2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamFV2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamFV2Command");
    UpdateGovSteamFV2Event event =
        new UpdateGovSteamFV2Event(
            command.getGovSteamFV2Id(),
            command.getDt(),
            command.getK(),
            command.getMwbase(),
            command.getR(),
            command.getT1(),
            command.getT3(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTi(),
            command.getTt(),
            command.getVmax(),
            command.getVmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamFV2Command");
    apply(new DeleteGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDtToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignDtToGovSteamFV2Command");

    if (dt != null && dt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDtToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtFromGovSteamFV2Command");

    if (dt == null) throw new ProcessingException("Dt already has nothing assigned.");

    apply(new UnAssignDtFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignKToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovSteamFV2Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovSteamFV2Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamFV2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamFV2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignRToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignRToGovSteamFV2Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovSteamFV2Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteamFV2Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteamFV2Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteamFV2Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteamFV2Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovSteamFV2Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovSteamFV2Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignTbToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovSteamFV2Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovSteamFV2Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovSteamFV2Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovSteamFV2Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignTiToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignTiToGovSteamFV2Command");

    if (ti != null && ti.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiFromGovSteamFV2Command");

    if (ti == null) throw new ProcessingException("Ti already has nothing assigned.");

    apply(new UnAssignTiFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignTtToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovSteamFV2Command");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovSteamFV2Command");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovSteamFV2Command");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovSteamFV2Command");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  @CommandHandler
  public void handle(AssignVminToGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovSteamFV2Command");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovSteamFV2Event(command.getGovSteamFV2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovSteamFV2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovSteamFV2Command");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovSteamFV2Event(command.getGovSteamFV2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamFV2Event event) {
    LOGGER.info("Event sourcing CreateGovSteamFV2Event");
    this.govSteamFV2Id = event.getGovSteamFV2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamFV2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dt = event.getDt();
    this.k = event.getK();
    this.mwbase = event.getMwbase();
    this.r = event.getR();
    this.t1 = event.getT1();
    this.t3 = event.getT3();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.ti = event.getTi();
    this.tt = event.getTt();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDtToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignDtToGovSteamFV2Event");
    this.dt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignDtFromGovSteamFV2Event");
    this.dt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignKToGovSteamFV2Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovSteamFV2Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamFV2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamFV2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignRToGovSteamFV2Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignRFromGovSteamFV2Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteamFV2Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteamFV2Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteamFV2Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteamFV2Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignTaToGovSteamFV2Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovSteamFV2Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignTbToGovSteamFV2Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovSteamFV2Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignTcToGovSteamFV2Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovSteamFV2Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignTiToGovSteamFV2Event");
    this.ti = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignTiFromGovSteamFV2Event");
    this.ti = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignTtToGovSteamFV2Event");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovSteamFV2Event");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignVmaxToGovSteamFV2Event");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovSteamFV2Event");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovSteamFV2Event event) {
    LOGGER.info("Event sourcing AssignVminToGovSteamFV2Event");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovSteamFV2Event event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovSteamFV2Event");
    this.vmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamFV2Id;

  private PU dt = null;
  private PU k = null;
  private ActivePower mwbase = null;
  private PU r = null;
  private Seconds t1 = null;
  private Seconds t3 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds ti = null;
  private Seconds tt = null;
  private PU vmax = null;
  private PU vmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV2Aggregate.class.getName());
}
