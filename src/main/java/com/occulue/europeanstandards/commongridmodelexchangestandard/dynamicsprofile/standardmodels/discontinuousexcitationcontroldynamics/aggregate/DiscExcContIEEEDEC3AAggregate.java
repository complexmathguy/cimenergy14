package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.aggregate;

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
 * Aggregate handler for DiscExcContIEEEDEC3A as outlined for the CQRS pattern, all write
 * responsibilities related to DiscExcContIEEEDEC3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscExcContIEEEDEC3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscExcContIEEEDEC3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscExcContIEEEDEC3AAggregate(CreateDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscExcContIEEEDEC3ACommand");
    CreateDiscExcContIEEEDEC3AEvent event =
        new CreateDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscExcContIEEEDEC3ACommand");
    UpdateDiscExcContIEEEDEC3AEvent event =
        new UpdateDiscExcContIEEEDEC3AEvent(
            command.getDiscExcContIEEEDEC3AId(), command.getTdr(), command.getVtmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscExcContIEEEDEC3ACommand");
    apply(new DeleteDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTdrToDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTdrToDiscExcContIEEEDEC3ACommand");

    if (tdr != null && tdr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdr already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTdrToDiscExcContIEEEDEC3AEvent(
            command.getDiscExcContIEEEDEC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdrFromDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdrFromDiscExcContIEEEDEC3ACommand");

    if (tdr == null) throw new ProcessingException("Tdr already has nothing assigned.");

    apply(new UnAssignTdrFromDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId()));
  }

  @CommandHandler
  public void handle(AssignVtminToDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtminToDiscExcContIEEEDEC3ACommand");

    if (vtmin != null && vtmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVtminToDiscExcContIEEEDEC3AEvent(
            command.getDiscExcContIEEEDEC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtminFromDiscExcContIEEEDEC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtminFromDiscExcContIEEEDEC3ACommand");

    if (vtmin == null) throw new ProcessingException("Vtmin already has nothing assigned.");

    apply(new UnAssignVtminFromDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing CreateDiscExcContIEEEDEC3AEvent");
    this.discExcContIEEEDEC3AId = event.getDiscExcContIEEEDEC3AId();
  }

  @EventSourcingHandler
  void on(UpdateDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.tdr = event.getTdr();
    this.vtmin = event.getVtmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTdrToDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing AssignTdrToDiscExcContIEEEDEC3AEvent");
    this.tdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdrFromDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTdrFromDiscExcContIEEEDEC3AEvent");
    this.tdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtminToDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing AssignVtminToDiscExcContIEEEDEC3AEvent");
    this.vtmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtminFromDiscExcContIEEEDEC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtminFromDiscExcContIEEEDEC3AEvent");
    this.vtmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discExcContIEEEDEC3AId;

  private Seconds tdr = null;
  private PU vtmin = null;

  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC3AAggregate.class.getName());
}
