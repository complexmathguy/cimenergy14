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
 * Aggregate handler for NonlinearShuntCompensatorPoint as outlined for the CQRS pattern, all write
 * responsibilities related to NonlinearShuntCompensatorPoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class NonlinearShuntCompensatorPointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public NonlinearShuntCompensatorPointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public NonlinearShuntCompensatorPointAggregate(
      CreateNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command CreateNonlinearShuntCompensatorPointCommand");
    CreateNonlinearShuntCompensatorPointEvent event =
        new CreateNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("handling command UpdateNonlinearShuntCompensatorPointCommand");
    UpdateNonlinearShuntCompensatorPointEvent event =
        new UpdateNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(),
            command.getB(),
            command.getB0(),
            command.getG(),
            command.getG0(),
            command.getSectionNumber(),
            command.getNonlinearShuntCompensatorPoints());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command DeleteNonlinearShuntCompensatorPointCommand");
    apply(
        new DeleteNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBToNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignBToNonlinearShuntCompensatorPointCommand");

    if (b != null && b.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignBToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromNonlinearShuntCompensatorPointCommand");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(
        new UnAssignBFromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  @CommandHandler
  public void handle(AssignB0ToNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignB0ToNonlinearShuntCompensatorPointCommand");

    if (b0 != null && b0.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B0 already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignB0ToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0FromNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignB0FromNonlinearShuntCompensatorPointCommand");

    if (b0 == null) throw new ProcessingException("B0 already has nothing assigned.");

    apply(
        new UnAssignB0FromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  @CommandHandler
  public void handle(AssignGToNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignGToNonlinearShuntCompensatorPointCommand");

    if (g != null && g.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignGToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGFromNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGFromNonlinearShuntCompensatorPointCommand");

    if (g == null) throw new ProcessingException("G already has nothing assigned.");

    apply(
        new UnAssignGFromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  @CommandHandler
  public void handle(AssignG0ToNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignG0ToNonlinearShuntCompensatorPointCommand");

    if (g0 != null && g0.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G0 already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignG0ToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0FromNonlinearShuntCompensatorPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignG0FromNonlinearShuntCompensatorPointCommand");

    if (g0 == null) throw new ProcessingException("G0 already has nothing assigned.");

    apply(
        new UnAssignG0FromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  @CommandHandler
  public void handle(AssignSectionNumberToNonlinearShuntCompensatorPointCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignSectionNumberToNonlinearShuntCompensatorPointCommand");

    if (sectionNumber != null
        && sectionNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "SectionNumber already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignSectionNumberToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand");

    if (sectionNumber == null)
      throw new ProcessingException("SectionNumber already has nothing assigned.");

    apply(
        new UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(
      AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand");

    if (nonlinearShuntCompensatorPoints.contains(command.getAddTo()))
      throw new ProcessingException(
          "NonlinearShuntCompensatorPoints already contains an entity with id "
              + command.getAddTo().getNonlinearShuntCompensatorPointId());

    apply(
        new AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(
      RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand");

    if (!nonlinearShuntCompensatorPoints.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "NonlinearShuntCompensatorPoints does not contain an entity with id "
              + command.getRemoveFrom().getNonlinearShuntCompensatorPointId());

    apply(
        new RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent(
            command.getNonlinearShuntCompensatorPointId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing CreateNonlinearShuntCompensatorPointEvent");
    this.nonlinearShuntCompensatorPointId = event.getNonlinearShuntCompensatorPointId();
  }

  @EventSourcingHandler
  void on(UpdateNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b = event.getB();
    this.b0 = event.getB0();
    this.g = event.getG();
    this.g0 = event.getG0();
    this.sectionNumber = event.getSectionNumber();
    this.nonlinearShuntCompensatorPoints = event.getNonlinearShuntCompensatorPoints();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing AssignBToNonlinearShuntCompensatorPointEvent");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing UnAssignBFromNonlinearShuntCompensatorPointEvent");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB0ToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing AssignB0ToNonlinearShuntCompensatorPointEvent");
    this.b0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0FromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing UnAssignB0FromNonlinearShuntCompensatorPointEvent");
    this.b0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing AssignGToNonlinearShuntCompensatorPointEvent");
    this.g = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing UnAssignGFromNonlinearShuntCompensatorPointEvent");
    this.g = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0ToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing AssignG0ToNonlinearShuntCompensatorPointEvent");
    this.g0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0FromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing UnAssignG0FromNonlinearShuntCompensatorPointEvent");
    this.g0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSectionNumberToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing AssignSectionNumberToNonlinearShuntCompensatorPointEvent");
    this.sectionNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("Event sourcing UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent");
    this.sectionNumber = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info(
        "Event sourcing AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent");
    this.nonlinearShuntCompensatorPoints.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info(
        "Event sourcing RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent");
    this.nonlinearShuntCompensatorPoints.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID nonlinearShuntCompensatorPointId;

  private Susceptance b = null;
  private Susceptance b0 = null;
  private Conductance g = null;
  private Conductance g0 = null;
  private IntegerProxy sectionNumber = null;
  private Set<NonlinearShuntCompensatorPoint> nonlinearShuntCompensatorPoints = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(NonlinearShuntCompensatorPointAggregate.class.getName());
}
