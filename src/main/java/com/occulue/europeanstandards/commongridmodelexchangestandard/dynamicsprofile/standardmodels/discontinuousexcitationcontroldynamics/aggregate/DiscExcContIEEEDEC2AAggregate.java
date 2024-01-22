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
 * Aggregate handler for DiscExcContIEEEDEC2A as outlined for the CQRS pattern, all write
 * responsibilities related to DiscExcContIEEEDEC2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscExcContIEEEDEC2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscExcContIEEEDEC2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscExcContIEEEDEC2AAggregate(CreateDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscExcContIEEEDEC2ACommand");
    CreateDiscExcContIEEEDEC2AEvent event =
        new CreateDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscExcContIEEEDEC2ACommand");
    UpdateDiscExcContIEEEDEC2AEvent event =
        new UpdateDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(),
            command.getTd1(),
            command.getTd2(),
            command.getVdmax(),
            command.getVdmin(),
            command.getVk());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscExcContIEEEDEC2ACommand");
    apply(new DeleteDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTd1ToDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTd1ToDiscExcContIEEEDEC2ACommand");

    if (td1 != null && td1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTd1ToDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTd1FromDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTd1FromDiscExcContIEEEDEC2ACommand");

    if (td1 == null) throw new ProcessingException("Td1 already has nothing assigned.");

    apply(new UnAssignTd1FromDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  @CommandHandler
  public void handle(AssignTd2ToDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTd2ToDiscExcContIEEEDEC2ACommand");

    if (td2 != null && td2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTd2ToDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTd2FromDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTd2FromDiscExcContIEEEDEC2ACommand");

    if (td2 == null) throw new ProcessingException("Td2 already has nothing assigned.");

    apply(new UnAssignTd2FromDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  @CommandHandler
  public void handle(AssignVdmaxToDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVdmaxToDiscExcContIEEEDEC2ACommand");

    if (vdmax != null && vdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vdmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVdmaxToDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand");

    if (vdmax == null) throw new ProcessingException("Vdmax already has nothing assigned.");

    apply(new UnAssignVdmaxFromDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  @CommandHandler
  public void handle(AssignVdminToDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVdminToDiscExcContIEEEDEC2ACommand");

    if (vdmin != null && vdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vdmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVdminToDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVdminFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVdminFromDiscExcContIEEEDEC2ACommand");

    if (vdmin == null) throw new ProcessingException("Vdmin already has nothing assigned.");

    apply(new UnAssignVdminFromDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  @CommandHandler
  public void handle(AssignVkToDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVkToDiscExcContIEEEDEC2ACommand");

    if (vk != null && vk.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vk already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVkToDiscExcContIEEEDEC2AEvent(
            command.getDiscExcContIEEEDEC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVkFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVkFromDiscExcContIEEEDEC2ACommand");

    if (vk == null) throw new ProcessingException("Vk already has nothing assigned.");

    apply(new UnAssignVkFromDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing CreateDiscExcContIEEEDEC2AEvent");
    this.discExcContIEEEDEC2AId = event.getDiscExcContIEEEDEC2AId();
  }

  @EventSourcingHandler
  void on(UpdateDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.td1 = event.getTd1();
    this.td2 = event.getTd2();
    this.vdmax = event.getVdmax();
    this.vdmin = event.getVdmin();
    this.vk = event.getVk();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTd1ToDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing AssignTd1ToDiscExcContIEEEDEC2AEvent");
    this.td1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTd1FromDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTd1FromDiscExcContIEEEDEC2AEvent");
    this.td1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTd2ToDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing AssignTd2ToDiscExcContIEEEDEC2AEvent");
    this.td2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTd2FromDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTd2FromDiscExcContIEEEDEC2AEvent");
    this.td2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVdmaxToDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing AssignVdmaxToDiscExcContIEEEDEC2AEvent");
    this.vdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVdmaxFromDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVdmaxFromDiscExcContIEEEDEC2AEvent");
    this.vdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVdminToDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing AssignVdminToDiscExcContIEEEDEC2AEvent");
    this.vdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVdminFromDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVdminFromDiscExcContIEEEDEC2AEvent");
    this.vdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVkToDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing AssignVkToDiscExcContIEEEDEC2AEvent");
    this.vk = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVkFromDiscExcContIEEEDEC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVkFromDiscExcContIEEEDEC2AEvent");
    this.vk = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discExcContIEEEDEC2AId;

  private Seconds td1 = null;
  private Seconds td2 = null;
  private PU vdmax = null;
  private PU vdmin = null;
  private PU vk = null;

  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC2AAggregate.class.getName());
}
