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
 * Aggregate handler for GovGAST4 as outlined for the CQRS pattern, all write responsibilities
 * related to GovGAST4 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGAST4Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGAST4Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGAST4Aggregate(CreateGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command CreateGovGAST4Command");
    CreateGovGAST4Event event = new CreateGovGAST4Event(command.getGovGAST4Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGAST4Command command) throws Exception {
    LOGGER.info("handling command UpdateGovGAST4Command");
    UpdateGovGAST4Event event =
        new UpdateGovGAST4Event(
            command.getGovGAST4Id(),
            command.getBp(),
            command.getKtm(),
            command.getMnef(),
            command.getMxef(),
            command.getRymn(),
            command.getRymx(),
            command.getTa(),
            command.getTc(),
            command.getTcm(),
            command.getTm(),
            command.getTv());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovGAST4Command");
    apply(new DeleteGovGAST4Event(command.getGovGAST4Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBpToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignBpToGovGAST4Command");

    if (bp != null && bp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBpToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBpFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBpFromGovGAST4Command");

    if (bp == null) throw new ProcessingException("Bp already has nothing assigned.");

    apply(new UnAssignBpFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignKtmToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignKtmToGovGAST4Command");

    if (ktm != null && ktm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ktm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKtmToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKtmFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKtmFromGovGAST4Command");

    if (ktm == null) throw new ProcessingException("Ktm already has nothing assigned.");

    apply(new UnAssignKtmFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignMnefToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignMnefToGovGAST4Command");

    if (mnef != null && mnef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mnef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMnefToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMnefFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMnefFromGovGAST4Command");

    if (mnef == null) throw new ProcessingException("Mnef already has nothing assigned.");

    apply(new UnAssignMnefFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignMxefToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignMxefToGovGAST4Command");

    if (mxef != null && mxef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mxef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMxefToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMxefFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMxefFromGovGAST4Command");

    if (mxef == null) throw new ProcessingException("Mxef already has nothing assigned.");

    apply(new UnAssignMxefFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignRymnToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignRymnToGovGAST4Command");

    if (rymn != null && rymn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rymn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRymnToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRymnFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRymnFromGovGAST4Command");

    if (rymn == null) throw new ProcessingException("Rymn already has nothing assigned.");

    apply(new UnAssignRymnFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignRymxToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignRymxToGovGAST4Command");

    if (rymx != null && rymx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rymx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRymxToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRymxFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRymxFromGovGAST4Command");

    if (rymx == null) throw new ProcessingException("Rymx already has nothing assigned.");

    apply(new UnAssignRymxFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovGAST4Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovGAST4Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovGAST4Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovGAST4Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignTcmToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignTcmToGovGAST4Command");

    if (tcm != null && tcm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tcm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcmToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcmFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcmFromGovGAST4Command");

    if (tcm == null) throw new ProcessingException("Tcm already has nothing assigned.");

    apply(new UnAssignTcmFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignTmToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignTmToGovGAST4Command");

    if (tm != null && tm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmFromGovGAST4Command");

    if (tm == null) throw new ProcessingException("Tm already has nothing assigned.");

    apply(new UnAssignTmFromGovGAST4Event(command.getGovGAST4Id()));
  }

  @CommandHandler
  public void handle(AssignTvToGovGAST4Command command) throws Exception {
    LOGGER.info("Handling command AssignTvToGovGAST4Command");

    if (tv != null && tv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tv already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvToGovGAST4Event(command.getGovGAST4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvFromGovGAST4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvFromGovGAST4Command");

    if (tv == null) throw new ProcessingException("Tv already has nothing assigned.");

    apply(new UnAssignTvFromGovGAST4Event(command.getGovGAST4Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGAST4Event event) {
    LOGGER.info("Event sourcing CreateGovGAST4Event");
    this.govGAST4Id = event.getGovGAST4Id();
  }

  @EventSourcingHandler
  void on(UpdateGovGAST4Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.bp = event.getBp();
    this.ktm = event.getKtm();
    this.mnef = event.getMnef();
    this.mxef = event.getMxef();
    this.rymn = event.getRymn();
    this.rymx = event.getRymx();
    this.ta = event.getTa();
    this.tc = event.getTc();
    this.tcm = event.getTcm();
    this.tm = event.getTm();
    this.tv = event.getTv();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBpToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignBpToGovGAST4Event");
    this.bp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBpFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignBpFromGovGAST4Event");
    this.bp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKtmToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignKtmToGovGAST4Event");
    this.ktm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKtmFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignKtmFromGovGAST4Event");
    this.ktm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMnefToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignMnefToGovGAST4Event");
    this.mnef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMnefFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignMnefFromGovGAST4Event");
    this.mnef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMxefToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignMxefToGovGAST4Event");
    this.mxef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMxefFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignMxefFromGovGAST4Event");
    this.mxef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRymnToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignRymnToGovGAST4Event");
    this.rymn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRymnFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignRymnFromGovGAST4Event");
    this.rymn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRymxToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignRymxToGovGAST4Event");
    this.rymx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRymxFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignRymxFromGovGAST4Event");
    this.rymx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignTaToGovGAST4Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovGAST4Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignTcToGovGAST4Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovGAST4Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcmToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignTcmToGovGAST4Event");
    this.tcm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcmFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignTcmFromGovGAST4Event");
    this.tcm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignTmToGovGAST4Event");
    this.tm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignTmFromGovGAST4Event");
    this.tm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvToGovGAST4Event event) {
    LOGGER.info("Event sourcing AssignTvToGovGAST4Event");
    this.tv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvFromGovGAST4Event event) {
    LOGGER.info("Event sourcing UnAssignTvFromGovGAST4Event");
    this.tv = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGAST4Id;

  private PU bp = null;
  private PU ktm = null;
  private PU mnef = null;
  private PU mxef = null;
  private PU rymn = null;
  private PU rymx = null;
  private Seconds ta = null;
  private Seconds tc = null;
  private Seconds tcm = null;
  private Seconds tm = null;
  private Seconds tv = null;

  private static final Logger LOGGER = Logger.getLogger(GovGAST4Aggregate.class.getName());
}
