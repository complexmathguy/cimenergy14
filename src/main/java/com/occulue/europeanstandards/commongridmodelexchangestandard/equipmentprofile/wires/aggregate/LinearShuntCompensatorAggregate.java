package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for LinearShuntCompensator as outlined for the CQRS pattern, all write
 * responsibilities related to LinearShuntCompensator are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LinearShuntCompensatorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LinearShuntCompensatorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LinearShuntCompensatorAggregate(CreateLinearShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateLinearShuntCompensatorCommand");
    CreateLinearShuntCompensatorEvent event =
        new CreateLinearShuntCompensatorEvent(command.getLinearShuntCompensatorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("handling command UpdateLinearShuntCompensatorCommand");
    UpdateLinearShuntCompensatorEvent event =
        new UpdateLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId(),
            command.getB0PerSection(),
            command.getBPerSection(),
            command.getG0PerSection(),
            command.getGPerSection());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLinearShuntCompensatorCommand");
    apply(new DeleteLinearShuntCompensatorEvent(command.getLinearShuntCompensatorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignB0PerSectionToLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignB0PerSectionToLinearShuntCompensatorCommand");

    if (b0PerSection != null
        && b0PerSection.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B0PerSection already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignB0PerSectionToLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0PerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignB0PerSectionFromLinearShuntCompensatorCommand");

    if (b0PerSection == null)
      throw new ProcessingException("B0PerSection already has nothing assigned.");

    apply(
        new UnAssignB0PerSectionFromLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignBPerSectionToLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignBPerSectionToLinearShuntCompensatorCommand");

    if (bPerSection != null
        && bPerSection.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "BPerSection already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignBPerSectionToLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBPerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBPerSectionFromLinearShuntCompensatorCommand");

    if (bPerSection == null)
      throw new ProcessingException("BPerSection already has nothing assigned.");

    apply(
        new UnAssignBPerSectionFromLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignG0PerSectionToLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignG0PerSectionToLinearShuntCompensatorCommand");

    if (g0PerSection != null
        && g0PerSection.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G0PerSection already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignG0PerSectionToLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0PerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignG0PerSectionFromLinearShuntCompensatorCommand");

    if (g0PerSection == null)
      throw new ProcessingException("G0PerSection already has nothing assigned.");

    apply(
        new UnAssignG0PerSectionFromLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignGPerSectionToLinearShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignGPerSectionToLinearShuntCompensatorCommand");

    if (gPerSection != null
        && gPerSection.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "GPerSection already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignGPerSectionToLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGPerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignGPerSectionFromLinearShuntCompensatorCommand");

    if (gPerSection == null)
      throw new ProcessingException("GPerSection already has nothing assigned.");

    apply(
        new UnAssignGPerSectionFromLinearShuntCompensatorEvent(
            command.getLinearShuntCompensatorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing CreateLinearShuntCompensatorEvent");
    this.linearShuntCompensatorId = event.getLinearShuntCompensatorId();
  }

  @EventSourcingHandler
  void on(UpdateLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b0PerSection = event.getB0PerSection();
    this.bPerSection = event.getBPerSection();
    this.g0PerSection = event.getG0PerSection();
    this.gPerSection = event.getGPerSection();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignB0PerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignB0PerSectionToLinearShuntCompensatorEvent");
    this.b0PerSection = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0PerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignB0PerSectionFromLinearShuntCompensatorEvent");
    this.b0PerSection = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBPerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignBPerSectionToLinearShuntCompensatorEvent");
    this.bPerSection = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBPerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignBPerSectionFromLinearShuntCompensatorEvent");
    this.bPerSection = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0PerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignG0PerSectionToLinearShuntCompensatorEvent");
    this.g0PerSection = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0PerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignG0PerSectionFromLinearShuntCompensatorEvent");
    this.g0PerSection = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGPerSectionToLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignGPerSectionToLinearShuntCompensatorEvent");
    this.gPerSection = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGPerSectionFromLinearShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignGPerSectionFromLinearShuntCompensatorEvent");
    this.gPerSection = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID linearShuntCompensatorId;

  private Susceptance b0PerSection = null;
  private Susceptance bPerSection = null;
  private Conductance g0PerSection = null;
  private Conductance gPerSection = null;

  private static final Logger LOGGER =
      Logger.getLogger(LinearShuntCompensatorAggregate.class.getName());
}
