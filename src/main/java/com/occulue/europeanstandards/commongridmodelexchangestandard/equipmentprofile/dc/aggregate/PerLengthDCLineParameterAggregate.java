package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for PerLengthDCLineParameter as outlined for the CQRS pattern, all write
 * responsibilities related to PerLengthDCLineParameter are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PerLengthDCLineParameterAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PerLengthDCLineParameterAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PerLengthDCLineParameterAggregate(CreatePerLengthDCLineParameterCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePerLengthDCLineParameterCommand");
    CreatePerLengthDCLineParameterEvent event =
        new CreatePerLengthDCLineParameterEvent(command.getPerLengthDCLineParameterId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePerLengthDCLineParameterCommand command) throws Exception {
    LOGGER.info("handling command UpdatePerLengthDCLineParameterCommand");
    UpdatePerLengthDCLineParameterEvent event =
        new UpdatePerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId(),
            command.getCapacitance(),
            command.getInductance(),
            command.getResistance());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePerLengthDCLineParameterCommand command) throws Exception {
    LOGGER.info("Handling command DeletePerLengthDCLineParameterCommand");
    apply(new DeletePerLengthDCLineParameterEvent(command.getPerLengthDCLineParameterId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCapacitanceToPerLengthDCLineParameterCommand command) throws Exception {
    LOGGER.info("Handling command AssignCapacitanceToPerLengthDCLineParameterCommand");

    if (capacitance != null
        && capacitance.getCapacitancePerLengthId()
            == command.getAssignment().getCapacitancePerLengthId())
      throw new ProcessingException(
          "Capacitance already assigned with id "
              + command.getAssignment().getCapacitancePerLengthId());

    apply(
        new AssignCapacitanceToPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCapacitanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignCapacitanceFromPerLengthDCLineParameterCommand");

    if (capacitance == null)
      throw new ProcessingException("Capacitance already has nothing assigned.");

    apply(
        new UnAssignCapacitanceFromPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId()));
  }

  @CommandHandler
  public void handle(AssignInductanceToPerLengthDCLineParameterCommand command) throws Exception {
    LOGGER.info("Handling command AssignInductanceToPerLengthDCLineParameterCommand");

    if (inductance != null
        && inductance.getInductancePerLengthId()
            == command.getAssignment().getInductancePerLengthId())
      throw new ProcessingException(
          "Inductance already assigned with id "
              + command.getAssignment().getInductancePerLengthId());

    apply(
        new AssignInductanceToPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInductanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignInductanceFromPerLengthDCLineParameterCommand");

    if (inductance == null)
      throw new ProcessingException("Inductance already has nothing assigned.");

    apply(
        new UnAssignInductanceFromPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId()));
  }

  @CommandHandler
  public void handle(AssignResistanceToPerLengthDCLineParameterCommand command) throws Exception {
    LOGGER.info("Handling command AssignResistanceToPerLengthDCLineParameterCommand");

    if (resistance != null
        && resistance.getResistancePerLengthId()
            == command.getAssignment().getResistancePerLengthId())
      throw new ProcessingException(
          "Resistance already assigned with id "
              + command.getAssignment().getResistancePerLengthId());

    apply(
        new AssignResistanceToPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignResistanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignResistanceFromPerLengthDCLineParameterCommand");

    if (resistance == null)
      throw new ProcessingException("Resistance already has nothing assigned.");

    apply(
        new UnAssignResistanceFromPerLengthDCLineParameterEvent(
            command.getPerLengthDCLineParameterId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing CreatePerLengthDCLineParameterEvent");
    this.perLengthDCLineParameterId = event.getPerLengthDCLineParameterId();
  }

  @EventSourcingHandler
  void on(UpdatePerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.capacitance = event.getCapacitance();
    this.inductance = event.getInductance();
    this.resistance = event.getResistance();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCapacitanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing AssignCapacitanceToPerLengthDCLineParameterEvent");
    this.capacitance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCapacitanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing UnAssignCapacitanceFromPerLengthDCLineParameterEvent");
    this.capacitance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInductanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing AssignInductanceToPerLengthDCLineParameterEvent");
    this.inductance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInductanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing UnAssignInductanceFromPerLengthDCLineParameterEvent");
    this.inductance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignResistanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing AssignResistanceToPerLengthDCLineParameterEvent");
    this.resistance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignResistanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("Event sourcing UnAssignResistanceFromPerLengthDCLineParameterEvent");
    this.resistance = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID perLengthDCLineParameterId;

  private CapacitancePerLength capacitance = null;
  private InductancePerLength inductance = null;
  private ResistancePerLength resistance = null;

  private static final Logger LOGGER =
      Logger.getLogger(PerLengthDCLineParameterAggregate.class.getName());
}
