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
 * Aggregate handler for GovGAST as outlined for the CQRS pattern, all write responsibilities
 * related to GovGAST are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGASTAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGASTAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGASTAggregate(CreateGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovGASTCommand");
    CreateGovGASTEvent event = new CreateGovGASTEvent(command.getGovGASTId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGASTCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovGASTCommand");
    UpdateGovGASTEvent event =
        new UpdateGovGASTEvent(
            command.getGovGASTId(),
            command.getAt(),
            command.getDturb(),
            command.getKt(),
            command.getMwbase(),
            command.getR(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getVmax(),
            command.getVmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovGASTCommand");
    apply(new DeleteGovGASTEvent(command.getGovGASTId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignAtToGovGASTCommand");

    if (at != null && at.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "At already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtFromGovGASTCommand");

    if (at == null) throw new ProcessingException("At already has nothing assigned.");

    apply(new UnAssignAtFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovGASTCommand");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovGASTCommand");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignKtToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignKtToGovGASTCommand");

    if (kt != null && kt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKtToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKtFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKtFromGovGASTCommand");

    if (kt == null) throw new ProcessingException("Kt already has nothing assigned.");

    apply(new UnAssignKtFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovGASTCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovGASTCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignRToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToGovGASTCommand");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovGASTCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovGASTCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovGASTCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovGASTCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovGASTCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovGASTCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovGASTCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovGASTCommand");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovGASTCommand");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovGASTEvent(command.getGovGASTId()));
  }

  @CommandHandler
  public void handle(AssignVminToGovGASTCommand command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovGASTCommand");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovGASTEvent(command.getGovGASTId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovGASTCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovGASTCommand");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovGASTEvent(command.getGovGASTId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGASTEvent event) {
    LOGGER.info("Event sourcing CreateGovGASTEvent");
    this.govGASTId = event.getGovGASTId();
  }

  @EventSourcingHandler
  void on(UpdateGovGASTEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.at = event.getAt();
    this.dturb = event.getDturb();
    this.kt = event.getKt();
    this.mwbase = event.getMwbase();
    this.r = event.getR();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAtToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignAtToGovGASTEvent");
    this.at = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignAtFromGovGASTEvent");
    this.at = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignDturbToGovGASTEvent");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovGASTEvent");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKtToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignKtToGovGASTEvent");
    this.kt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKtFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignKtFromGovGASTEvent");
    this.kt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovGASTEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovGASTEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignRToGovGASTEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromGovGASTEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignT1ToGovGASTEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovGASTEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignT2ToGovGASTEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovGASTEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignT3ToGovGASTEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovGASTEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignVmaxToGovGASTEvent");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovGASTEvent");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovGASTEvent event) {
    LOGGER.info("Event sourcing AssignVminToGovGASTEvent");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovGASTEvent event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovGASTEvent");
    this.vmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGASTId;

  private PU at = null;
  private PU dturb = null;
  private PU kt = null;
  private ActivePower mwbase = null;
  private PU r = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private PU vmax = null;
  private PU vmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovGASTAggregate.class.getName());
}
