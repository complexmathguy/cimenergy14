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
 * Aggregate handler for GovSteamCC as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamCC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamCCAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamCCAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamCCAggregate(CreateGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamCCCommand");
    CreateGovSteamCCEvent event = new CreateGovSteamCCEvent(command.getGovSteamCCId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamCCCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamCCCommand");
    UpdateGovSteamCCEvent event =
        new UpdateGovSteamCCEvent(
            command.getGovSteamCCId(),
            command.getDhp(),
            command.getDlp(),
            command.getFhp(),
            command.getFlp(),
            command.getMwbase(),
            command.getPmaxhp(),
            command.getPmaxlp(),
            command.getRhp(),
            command.getRlp(),
            command.getT1hp(),
            command.getT1lp(),
            command.getT3hp(),
            command.getT3lp(),
            command.getT4hp(),
            command.getT4lp(),
            command.getT5hp(),
            command.getT5lp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamCCCommand");
    apply(new DeleteGovSteamCCEvent(command.getGovSteamCCId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDhpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignDhpToGovSteamCCCommand");

    if (dhp != null && dhp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dhp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDhpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDhpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDhpFromGovSteamCCCommand");

    if (dhp == null) throw new ProcessingException("Dhp already has nothing assigned.");

    apply(new UnAssignDhpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignDlpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignDlpToGovSteamCCCommand");

    if (dlp != null && dlp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dlp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDlpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDlpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDlpFromGovSteamCCCommand");

    if (dlp == null) throw new ProcessingException("Dlp already has nothing assigned.");

    apply(new UnAssignDlpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignFhpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignFhpToGovSteamCCCommand");

    if (fhp != null && fhp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fhp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFhpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFhpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFhpFromGovSteamCCCommand");

    if (fhp == null) throw new ProcessingException("Fhp already has nothing assigned.");

    apply(new UnAssignFhpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignFlpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignFlpToGovSteamCCCommand");

    if (flp != null && flp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Flp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFlpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlpFromGovSteamCCCommand");

    if (flp == null) throw new ProcessingException("Flp already has nothing assigned.");

    apply(new UnAssignFlpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamCCCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamCCCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignPmaxhpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxhpToGovSteamCCCommand");

    if (pmaxhp != null && pmaxhp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmaxhp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxhpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxhpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxhpFromGovSteamCCCommand");

    if (pmaxhp == null) throw new ProcessingException("Pmaxhp already has nothing assigned.");

    apply(new UnAssignPmaxhpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignPmaxlpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxlpToGovSteamCCCommand");

    if (pmaxlp != null && pmaxlp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmaxlp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxlpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxlpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxlpFromGovSteamCCCommand");

    if (pmaxlp == null) throw new ProcessingException("Pmaxlp already has nothing assigned.");

    apply(new UnAssignPmaxlpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignRhpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignRhpToGovSteamCCCommand");

    if (rhp != null && rhp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rhp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRhpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRhpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRhpFromGovSteamCCCommand");

    if (rhp == null) throw new ProcessingException("Rhp already has nothing assigned.");

    apply(new UnAssignRhpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignRlpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignRlpToGovSteamCCCommand");

    if (rlp != null && rlp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rlp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRlpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRlpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRlpFromGovSteamCCCommand");

    if (rlp == null) throw new ProcessingException("Rlp already has nothing assigned.");

    apply(new UnAssignRlpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT1hpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1hpToGovSteamCCCommand");

    if (t1hp != null && t1hp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1hp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1hpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1hpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1hpFromGovSteamCCCommand");

    if (t1hp == null) throw new ProcessingException("T1hp already has nothing assigned.");

    apply(new UnAssignT1hpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT1lpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1lpToGovSteamCCCommand");

    if (t1lp != null && t1lp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1lp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1lpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1lpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1lpFromGovSteamCCCommand");

    if (t1lp == null) throw new ProcessingException("T1lp already has nothing assigned.");

    apply(new UnAssignT1lpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT3hpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3hpToGovSteamCCCommand");

    if (t3hp != null && t3hp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3hp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3hpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3hpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3hpFromGovSteamCCCommand");

    if (t3hp == null) throw new ProcessingException("T3hp already has nothing assigned.");

    apply(new UnAssignT3hpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT3lpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3lpToGovSteamCCCommand");

    if (t3lp != null && t3lp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3lp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3lpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3lpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3lpFromGovSteamCCCommand");

    if (t3lp == null) throw new ProcessingException("T3lp already has nothing assigned.");

    apply(new UnAssignT3lpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT4hpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4hpToGovSteamCCCommand");

    if (t4hp != null && t4hp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4hp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4hpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4hpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4hpFromGovSteamCCCommand");

    if (t4hp == null) throw new ProcessingException("T4hp already has nothing assigned.");

    apply(new UnAssignT4hpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT4lpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4lpToGovSteamCCCommand");

    if (t4lp != null && t4lp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4lp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4lpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4lpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4lpFromGovSteamCCCommand");

    if (t4lp == null) throw new ProcessingException("T4lp already has nothing assigned.");

    apply(new UnAssignT4lpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT5hpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5hpToGovSteamCCCommand");

    if (t5hp != null && t5hp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5hp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5hpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5hpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5hpFromGovSteamCCCommand");

    if (t5hp == null) throw new ProcessingException("T5hp already has nothing assigned.");

    apply(new UnAssignT5hpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  @CommandHandler
  public void handle(AssignT5lpToGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5lpToGovSteamCCCommand");

    if (t5lp != null && t5lp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5lp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5lpToGovSteamCCEvent(command.getGovSteamCCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5lpFromGovSteamCCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5lpFromGovSteamCCCommand");

    if (t5lp == null) throw new ProcessingException("T5lp already has nothing assigned.");

    apply(new UnAssignT5lpFromGovSteamCCEvent(command.getGovSteamCCId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamCCEvent event) {
    LOGGER.info("Event sourcing CreateGovSteamCCEvent");
    this.govSteamCCId = event.getGovSteamCCId();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamCCEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dhp = event.getDhp();
    this.dlp = event.getDlp();
    this.fhp = event.getFhp();
    this.flp = event.getFlp();
    this.mwbase = event.getMwbase();
    this.pmaxhp = event.getPmaxhp();
    this.pmaxlp = event.getPmaxlp();
    this.rhp = event.getRhp();
    this.rlp = event.getRlp();
    this.t1hp = event.getT1hp();
    this.t1lp = event.getT1lp();
    this.t3hp = event.getT3hp();
    this.t3lp = event.getT3lp();
    this.t4hp = event.getT4hp();
    this.t4lp = event.getT4lp();
    this.t5hp = event.getT5hp();
    this.t5lp = event.getT5lp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDhpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignDhpToGovSteamCCEvent");
    this.dhp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDhpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignDhpFromGovSteamCCEvent");
    this.dhp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDlpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignDlpToGovSteamCCEvent");
    this.dlp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDlpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignDlpFromGovSteamCCEvent");
    this.dlp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFhpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignFhpToGovSteamCCEvent");
    this.fhp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFhpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignFhpFromGovSteamCCEvent");
    this.fhp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignFlpToGovSteamCCEvent");
    this.flp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignFlpFromGovSteamCCEvent");
    this.flp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamCCEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamCCEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxhpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignPmaxhpToGovSteamCCEvent");
    this.pmaxhp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxhpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxhpFromGovSteamCCEvent");
    this.pmaxhp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxlpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignPmaxlpToGovSteamCCEvent");
    this.pmaxlp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxlpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxlpFromGovSteamCCEvent");
    this.pmaxlp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRhpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignRhpToGovSteamCCEvent");
    this.rhp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRhpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignRhpFromGovSteamCCEvent");
    this.rhp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRlpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignRlpToGovSteamCCEvent");
    this.rlp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRlpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignRlpFromGovSteamCCEvent");
    this.rlp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1hpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT1hpToGovSteamCCEvent");
    this.t1hp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1hpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT1hpFromGovSteamCCEvent");
    this.t1hp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1lpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT1lpToGovSteamCCEvent");
    this.t1lp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1lpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT1lpFromGovSteamCCEvent");
    this.t1lp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3hpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT3hpToGovSteamCCEvent");
    this.t3hp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3hpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT3hpFromGovSteamCCEvent");
    this.t3hp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3lpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT3lpToGovSteamCCEvent");
    this.t3lp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3lpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT3lpFromGovSteamCCEvent");
    this.t3lp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4hpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT4hpToGovSteamCCEvent");
    this.t4hp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4hpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT4hpFromGovSteamCCEvent");
    this.t4hp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4lpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT4lpToGovSteamCCEvent");
    this.t4lp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4lpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT4lpFromGovSteamCCEvent");
    this.t4lp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5hpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT5hpToGovSteamCCEvent");
    this.t5hp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5hpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT5hpFromGovSteamCCEvent");
    this.t5hp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5lpToGovSteamCCEvent event) {
    LOGGER.info("Event sourcing AssignT5lpToGovSteamCCEvent");
    this.t5lp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5lpFromGovSteamCCEvent event) {
    LOGGER.info("Event sourcing UnAssignT5lpFromGovSteamCCEvent");
    this.t5lp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamCCId;

  private PU dhp = null;
  private PU dlp = null;
  private PU fhp = null;
  private PU flp = null;
  private ActivePower mwbase = null;
  private PU pmaxhp = null;
  private PU pmaxlp = null;
  private PU rhp = null;
  private PU rlp = null;
  private Seconds t1hp = null;
  private Seconds t1lp = null;
  private Seconds t3hp = null;
  private Seconds t3lp = null;
  private Seconds t4hp = null;
  private Seconds t4lp = null;
  private Seconds t5hp = null;
  private Seconds t5lp = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamCCAggregate.class.getName());
}
