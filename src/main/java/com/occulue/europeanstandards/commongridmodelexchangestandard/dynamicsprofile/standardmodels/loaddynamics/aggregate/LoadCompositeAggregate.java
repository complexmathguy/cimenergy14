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
 * Aggregate handler for LoadComposite as outlined for the CQRS pattern, all write responsibilities
 * related to LoadComposite are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadCompositeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadCompositeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadCompositeAggregate(CreateLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadCompositeCommand");
    CreateLoadCompositeEvent event = new CreateLoadCompositeEvent(command.getLoadCompositeId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadCompositeCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadCompositeCommand");
    UpdateLoadCompositeEvent event =
        new UpdateLoadCompositeEvent(
            command.getLoadCompositeId(),
            command.getEpfd(),
            command.getEpfs(),
            command.getEpvd(),
            command.getEpvs(),
            command.getEqfd(),
            command.getEqfs(),
            command.getEqvd(),
            command.getEqvs(),
            command.getH(),
            command.getLfrac(),
            command.getPfrac());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadCompositeCommand");
    apply(new DeleteLoadCompositeEvent(command.getLoadCompositeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEpfdToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpfdToLoadCompositeCommand");

    if (epfd != null && epfd.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Epfd already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEpfdToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpfdFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpfdFromLoadCompositeCommand");

    if (epfd == null) throw new ProcessingException("Epfd already has nothing assigned.");

    apply(new UnAssignEpfdFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEpfsToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpfsToLoadCompositeCommand");

    if (epfs != null && epfs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Epfs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEpfsToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpfsFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpfsFromLoadCompositeCommand");

    if (epfs == null) throw new ProcessingException("Epfs already has nothing assigned.");

    apply(new UnAssignEpfsFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEpvdToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpvdToLoadCompositeCommand");

    if (epvd != null && epvd.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Epvd already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEpvdToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpvdFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpvdFromLoadCompositeCommand");

    if (epvd == null) throw new ProcessingException("Epvd already has nothing assigned.");

    apply(new UnAssignEpvdFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEpvsToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpvsToLoadCompositeCommand");

    if (epvs != null && epvs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Epvs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEpvsToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpvsFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpvsFromLoadCompositeCommand");

    if (epvs == null) throw new ProcessingException("Epvs already has nothing assigned.");

    apply(new UnAssignEpvsFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEqfdToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEqfdToLoadCompositeCommand");

    if (eqfd != null && eqfd.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eqfd already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEqfdToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEqfdFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEqfdFromLoadCompositeCommand");

    if (eqfd == null) throw new ProcessingException("Eqfd already has nothing assigned.");

    apply(new UnAssignEqfdFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEqfsToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEqfsToLoadCompositeCommand");

    if (eqfs != null && eqfs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eqfs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEqfsToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEqfsFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEqfsFromLoadCompositeCommand");

    if (eqfs == null) throw new ProcessingException("Eqfs already has nothing assigned.");

    apply(new UnAssignEqfsFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEqvdToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEqvdToLoadCompositeCommand");

    if (eqvd != null && eqvd.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eqvd already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEqvdToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEqvdFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEqvdFromLoadCompositeCommand");

    if (eqvd == null) throw new ProcessingException("Eqvd already has nothing assigned.");

    apply(new UnAssignEqvdFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignEqvsToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignEqvsToLoadCompositeCommand");

    if (eqvs != null && eqvs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eqvs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEqvsToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEqvsFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEqvsFromLoadCompositeCommand");

    if (eqvs == null) throw new ProcessingException("Eqvs already has nothing assigned.");

    apply(new UnAssignEqvsFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignHToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignHToLoadCompositeCommand");

    if (h != null && h.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "H already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignHToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHFromLoadCompositeCommand");

    if (h == null) throw new ProcessingException("H already has nothing assigned.");

    apply(new UnAssignHFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignLfracToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignLfracToLoadCompositeCommand");

    if (lfrac != null && lfrac.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Lfrac already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignLfracToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLfracFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLfracFromLoadCompositeCommand");

    if (lfrac == null) throw new ProcessingException("Lfrac already has nothing assigned.");

    apply(new UnAssignLfracFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  @CommandHandler
  public void handle(AssignPfracToLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handling command AssignPfracToLoadCompositeCommand");

    if (pfrac != null && pfrac.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Pfrac already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPfracToLoadCompositeEvent(command.getLoadCompositeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPfracFromLoadCompositeCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPfracFromLoadCompositeCommand");

    if (pfrac == null) throw new ProcessingException("Pfrac already has nothing assigned.");

    apply(new UnAssignPfracFromLoadCompositeEvent(command.getLoadCompositeId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadCompositeEvent event) {
    LOGGER.info("Event sourcing CreateLoadCompositeEvent");
    this.loadCompositeId = event.getLoadCompositeId();
  }

  @EventSourcingHandler
  void on(UpdateLoadCompositeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.epfd = event.getEpfd();
    this.epfs = event.getEpfs();
    this.epvd = event.getEpvd();
    this.epvs = event.getEpvs();
    this.eqfd = event.getEqfd();
    this.eqfs = event.getEqfs();
    this.eqvd = event.getEqvd();
    this.eqvs = event.getEqvs();
    this.h = event.getH();
    this.lfrac = event.getLfrac();
    this.pfrac = event.getPfrac();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEpfdToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEpfdToLoadCompositeEvent");
    this.epfd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpfdFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEpfdFromLoadCompositeEvent");
    this.epfd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpfsToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEpfsToLoadCompositeEvent");
    this.epfs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpfsFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEpfsFromLoadCompositeEvent");
    this.epfs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpvdToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEpvdToLoadCompositeEvent");
    this.epvd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpvdFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEpvdFromLoadCompositeEvent");
    this.epvd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpvsToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEpvsToLoadCompositeEvent");
    this.epvs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpvsFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEpvsFromLoadCompositeEvent");
    this.epvs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEqfdToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEqfdToLoadCompositeEvent");
    this.eqfd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEqfdFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEqfdFromLoadCompositeEvent");
    this.eqfd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEqfsToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEqfsToLoadCompositeEvent");
    this.eqfs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEqfsFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEqfsFromLoadCompositeEvent");
    this.eqfs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEqvdToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEqvdToLoadCompositeEvent");
    this.eqvd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEqvdFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEqvdFromLoadCompositeEvent");
    this.eqvd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEqvsToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignEqvsToLoadCompositeEvent");
    this.eqvs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEqvsFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignEqvsFromLoadCompositeEvent");
    this.eqvs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignHToLoadCompositeEvent");
    this.h = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignHFromLoadCompositeEvent");
    this.h = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLfracToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignLfracToLoadCompositeEvent");
    this.lfrac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLfracFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignLfracFromLoadCompositeEvent");
    this.lfrac = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPfracToLoadCompositeEvent event) {
    LOGGER.info("Event sourcing AssignPfracToLoadCompositeEvent");
    this.pfrac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPfracFromLoadCompositeEvent event) {
    LOGGER.info("Event sourcing UnAssignPfracFromLoadCompositeEvent");
    this.pfrac = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadCompositeId;

  private Simple_Float epfd = null;
  private Simple_Float epfs = null;
  private Simple_Float epvd = null;
  private Simple_Float epvs = null;
  private Simple_Float eqfd = null;
  private Simple_Float eqfs = null;
  private Simple_Float eqvd = null;
  private Simple_Float eqvs = null;
  private Seconds h = null;
  private Simple_Float lfrac = null;
  private Simple_Float pfrac = null;

  private static final Logger LOGGER = Logger.getLogger(LoadCompositeAggregate.class.getName());
}
