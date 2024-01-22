package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.aggregate;

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
 * Aggregate handler for VAdjIEEE as outlined for the CQRS pattern, all write responsibilities
 * related to VAdjIEEE are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VAdjIEEEAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VAdjIEEEAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VAdjIEEEAggregate(CreateVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command CreateVAdjIEEECommand");
    CreateVAdjIEEEEvent event = new CreateVAdjIEEEEvent(command.getVAdjIEEEId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVAdjIEEECommand command) throws Exception {
    LOGGER.info("handling command UpdateVAdjIEEECommand");
    UpdateVAdjIEEEEvent event =
        new UpdateVAdjIEEEEvent(
            command.getVAdjIEEEId(),
            command.getAdjslew(),
            command.getTaoff(),
            command.getTaon(),
            command.getVadjf(),
            command.getVadjmax(),
            command.getVadjmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command DeleteVAdjIEEECommand");
    apply(new DeleteVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAdjslewToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignAdjslewToVAdjIEEECommand");

    if (adjslew != null
        && adjslew.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Adjslew already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAdjslewToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAdjslewFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAdjslewFromVAdjIEEECommand");

    if (adjslew == null) throw new ProcessingException("Adjslew already has nothing assigned.");

    apply(new UnAssignAdjslewFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  @CommandHandler
  public void handle(AssignTaoffToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignTaoffToVAdjIEEECommand");

    if (taoff != null && taoff.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Taoff already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaoffToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaoffFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaoffFromVAdjIEEECommand");

    if (taoff == null) throw new ProcessingException("Taoff already has nothing assigned.");

    apply(new UnAssignTaoffFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  @CommandHandler
  public void handle(AssignTaonToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignTaonToVAdjIEEECommand");

    if (taon != null && taon.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Taon already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaonToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaonFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaonFromVAdjIEEECommand");

    if (taon == null) throw new ProcessingException("Taon already has nothing assigned.");

    apply(new UnAssignTaonFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  @CommandHandler
  public void handle(AssignVadjfToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignVadjfToVAdjIEEECommand");

    if (vadjf != null && vadjf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vadjf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVadjfToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVadjfFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVadjfFromVAdjIEEECommand");

    if (vadjf == null) throw new ProcessingException("Vadjf already has nothing assigned.");

    apply(new UnAssignVadjfFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  @CommandHandler
  public void handle(AssignVadjmaxToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignVadjmaxToVAdjIEEECommand");

    if (vadjmax != null && vadjmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vadjmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVadjmaxToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVadjmaxFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVadjmaxFromVAdjIEEECommand");

    if (vadjmax == null) throw new ProcessingException("Vadjmax already has nothing assigned.");

    apply(new UnAssignVadjmaxFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  @CommandHandler
  public void handle(AssignVadjminToVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignVadjminToVAdjIEEECommand");

    if (vadjmin != null && vadjmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vadjmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVadjminToVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVadjminFromVAdjIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVadjminFromVAdjIEEECommand");

    if (vadjmin == null) throw new ProcessingException("Vadjmin already has nothing assigned.");

    apply(new UnAssignVadjminFromVAdjIEEEEvent(command.getVAdjIEEEId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing CreateVAdjIEEEEvent");
    this.vAdjIEEEId = event.getVAdjIEEEId();
  }

  @EventSourcingHandler
  void on(UpdateVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.adjslew = event.getAdjslew();
    this.taoff = event.getTaoff();
    this.taon = event.getTaon();
    this.vadjf = event.getVadjf();
    this.vadjmax = event.getVadjmax();
    this.vadjmin = event.getVadjmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAdjslewToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignAdjslewToVAdjIEEEEvent");
    this.adjslew = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAdjslewFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignAdjslewFromVAdjIEEEEvent");
    this.adjslew = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaoffToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignTaoffToVAdjIEEEEvent");
    this.taoff = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaoffFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignTaoffFromVAdjIEEEEvent");
    this.taoff = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaonToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignTaonToVAdjIEEEEvent");
    this.taon = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaonFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignTaonFromVAdjIEEEEvent");
    this.taon = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVadjfToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignVadjfToVAdjIEEEEvent");
    this.vadjf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVadjfFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignVadjfFromVAdjIEEEEvent");
    this.vadjf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVadjmaxToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignVadjmaxToVAdjIEEEEvent");
    this.vadjmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVadjmaxFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignVadjmaxFromVAdjIEEEEvent");
    this.vadjmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVadjminToVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing AssignVadjminToVAdjIEEEEvent");
    this.vadjmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVadjminFromVAdjIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignVadjminFromVAdjIEEEEvent");
    this.vadjmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID vAdjIEEEId;

  private Simple_Float adjslew = null;
  private Seconds taoff = null;
  private Seconds taon = null;
  private Simple_Float vadjf = null;
  private PU vadjmax = null;
  private PU vadjmin = null;

  private static final Logger LOGGER = Logger.getLogger(VAdjIEEEAggregate.class.getName());
}
