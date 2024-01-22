package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.aggregate;

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
 * Aggregate handler for LoadMotor as outlined for the CQRS pattern, all write responsibilities
 * related to LoadMotor are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadMotorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadMotorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadMotorAggregate(CreateLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadMotorCommand");
    CreateLoadMotorEvent event = new CreateLoadMotorEvent(command.getLoadMotorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadMotorCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadMotorCommand");
    UpdateLoadMotorEvent event =
        new UpdateLoadMotorEvent(
            command.getLoadMotorId(),
            command.getD(),
            command.getH(),
            command.getLfac(),
            command.getLp(),
            command.getLpp(),
            command.getLs(),
            command.getPfrac(),
            command.getRa(),
            command.getTbkr(),
            command.getTpo(),
            command.getTppo(),
            command.getTv(),
            command.getVt(),
            command.getLoadMotor());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadMotorCommand");
    apply(new DeleteLoadMotorEvent(command.getLoadMotorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignDToLoadMotorCommand");

    if (d != null && d.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "D already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignDToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDFromLoadMotorCommand");

    if (d == null) throw new ProcessingException("D already has nothing assigned.");

    apply(new UnAssignDFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignHToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignHToLoadMotorCommand");

    if (h != null && h.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "H already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignHToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHFromLoadMotorCommand");

    if (h == null) throw new ProcessingException("H already has nothing assigned.");

    apply(new UnAssignHFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignLfacToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLfacToLoadMotorCommand");

    if (lfac != null && lfac.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Lfac already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignLfacToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLfacFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLfacFromLoadMotorCommand");

    if (lfac == null) throw new ProcessingException("Lfac already has nothing assigned.");

    apply(new UnAssignLfacFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignLpToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLpToLoadMotorCommand");

    if (lp != null && lp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLpToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLpFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLpFromLoadMotorCommand");

    if (lp == null) throw new ProcessingException("Lp already has nothing assigned.");

    apply(new UnAssignLpFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignLppToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLppToLoadMotorCommand");

    if (lpp != null && lpp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lpp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLppToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLppFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLppFromLoadMotorCommand");

    if (lpp == null) throw new ProcessingException("Lpp already has nothing assigned.");

    apply(new UnAssignLppFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignLsToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLsToLoadMotorCommand");

    if (ls != null && ls.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ls already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLsToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLsFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLsFromLoadMotorCommand");

    if (ls == null) throw new ProcessingException("Ls already has nothing assigned.");

    apply(new UnAssignLsFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignPfracToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignPfracToLoadMotorCommand");

    if (pfrac != null && pfrac.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Pfrac already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignPfracToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPfracFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPfracFromLoadMotorCommand");

    if (pfrac == null) throw new ProcessingException("Pfrac already has nothing assigned.");

    apply(new UnAssignPfracFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignRaToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignRaToLoadMotorCommand");

    if (ra != null && ra.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ra already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRaToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRaFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRaFromLoadMotorCommand");

    if (ra == null) throw new ProcessingException("Ra already has nothing assigned.");

    apply(new UnAssignRaFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignTbkrToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbkrToLoadMotorCommand");

    if (tbkr != null && tbkr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tbkr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbkrToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbkrFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbkrFromLoadMotorCommand");

    if (tbkr == null) throw new ProcessingException("Tbkr already has nothing assigned.");

    apply(new UnAssignTbkrFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignTpoToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpoToLoadMotorCommand");

    if (tpo != null && tpo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpo already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpoToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpoFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpoFromLoadMotorCommand");

    if (tpo == null) throw new ProcessingException("Tpo already has nothing assigned.");

    apply(new UnAssignTpoFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignTppoToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignTppoToLoadMotorCommand");

    if (tppo != null && tppo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tppo already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTppoToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTppoFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTppoFromLoadMotorCommand");

    if (tppo == null) throw new ProcessingException("Tppo already has nothing assigned.");

    apply(new UnAssignTppoFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignTvToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvToLoadMotorCommand");

    if (tv != null && tv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tv already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvFromLoadMotorCommand");

    if (tv == null) throw new ProcessingException("Tv already has nothing assigned.");

    apply(new UnAssignTvFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignVtToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignVtToLoadMotorCommand");

    if (vt != null && vt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVtToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtFromLoadMotorCommand");

    if (vt == null) throw new ProcessingException("Vt already has nothing assigned.");

    apply(new UnAssignVtFromLoadMotorEvent(command.getLoadMotorId()));
  }

  @CommandHandler
  public void handle(AssignLoadMotorToLoadMotorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLoadMotorToLoadMotorCommand");

    if (loadMotor != null && loadMotor.getLoadMotorId() == command.getAssignment().getLoadMotorId())
      throw new ProcessingException(
          "LoadMotor already assigned with id " + command.getAssignment().getLoadMotorId());

    apply(new AssignLoadMotorToLoadMotorEvent(command.getLoadMotorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLoadMotorFromLoadMotorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLoadMotorFromLoadMotorCommand");

    if (loadMotor == null) throw new ProcessingException("LoadMotor already has nothing assigned.");

    apply(new UnAssignLoadMotorFromLoadMotorEvent(command.getLoadMotorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadMotorEvent event) {
    LOGGER.info("Event sourcing CreateLoadMotorEvent");
    this.loadMotorId = event.getLoadMotorId();
  }

  @EventSourcingHandler
  void on(UpdateLoadMotorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.d = event.getD();
    this.h = event.getH();
    this.lfac = event.getLfac();
    this.lp = event.getLp();
    this.lpp = event.getLpp();
    this.ls = event.getLs();
    this.pfrac = event.getPfrac();
    this.ra = event.getRa();
    this.tbkr = event.getTbkr();
    this.tpo = event.getTpo();
    this.tppo = event.getTppo();
    this.tv = event.getTv();
    this.vt = event.getVt();
    this.loadMotor = event.getLoadMotor();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignDToLoadMotorEvent");
    this.d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignDFromLoadMotorEvent");
    this.d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignHToLoadMotorEvent");
    this.h = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignHFromLoadMotorEvent");
    this.h = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLfacToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignLfacToLoadMotorEvent");
    this.lfac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLfacFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignLfacFromLoadMotorEvent");
    this.lfac = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLpToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignLpToLoadMotorEvent");
    this.lp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLpFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignLpFromLoadMotorEvent");
    this.lp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLppToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignLppToLoadMotorEvent");
    this.lpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLppFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignLppFromLoadMotorEvent");
    this.lpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLsToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignLsToLoadMotorEvent");
    this.ls = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLsFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignLsFromLoadMotorEvent");
    this.ls = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPfracToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignPfracToLoadMotorEvent");
    this.pfrac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPfracFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignPfracFromLoadMotorEvent");
    this.pfrac = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRaToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignRaToLoadMotorEvent");
    this.ra = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRaFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignRaFromLoadMotorEvent");
    this.ra = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbkrToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignTbkrToLoadMotorEvent");
    this.tbkr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbkrFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignTbkrFromLoadMotorEvent");
    this.tbkr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpoToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignTpoToLoadMotorEvent");
    this.tpo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpoFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignTpoFromLoadMotorEvent");
    this.tpo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTppoToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignTppoToLoadMotorEvent");
    this.tppo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTppoFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignTppoFromLoadMotorEvent");
    this.tppo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignTvToLoadMotorEvent");
    this.tv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignTvFromLoadMotorEvent");
    this.tv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignVtToLoadMotorEvent");
    this.vt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignVtFromLoadMotorEvent");
    this.vt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLoadMotorToLoadMotorEvent event) {
    LOGGER.info("Event sourcing AssignLoadMotorToLoadMotorEvent");
    this.loadMotor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLoadMotorFromLoadMotorEvent event) {
    LOGGER.info("Event sourcing UnAssignLoadMotorFromLoadMotorEvent");
    this.loadMotor = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadMotorId;

  private Simple_Float d = null;
  private Seconds h = null;
  private Simple_Float lfac = null;
  private PU lp = null;
  private PU lpp = null;
  private PU ls = null;
  private Simple_Float pfrac = null;
  private PU ra = null;
  private Seconds tbkr = null;
  private Seconds tpo = null;
  private Seconds tppo = null;
  private Seconds tv = null;
  private PU vt = null;
  private LoadMotor loadMotor = null;

  private static final Logger LOGGER = Logger.getLogger(LoadMotorAggregate.class.getName());
}
