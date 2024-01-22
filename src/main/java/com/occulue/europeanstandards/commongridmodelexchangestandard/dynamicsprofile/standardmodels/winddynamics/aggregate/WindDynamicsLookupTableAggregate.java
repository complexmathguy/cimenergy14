package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindDynamicsLookupTable as outlined for the CQRS pattern, all write
 * responsibilities related to WindDynamicsLookupTable are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindDynamicsLookupTableAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindDynamicsLookupTableAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindDynamicsLookupTableAggregate(CreateWindDynamicsLookupTableCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindDynamicsLookupTableCommand");
    CreateWindDynamicsLookupTableEvent event =
        new CreateWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getLookupTableFunctionType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindDynamicsLookupTableCommand");
    UpdateWindDynamicsLookupTableEvent event =
        new UpdateWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(),
            command.getInput(),
            command.getLookupTableFunctionType(),
            command.getOutput(),
            command.getSequence(),
            command.getWindDynamicsLookupTable());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindDynamicsLookupTableCommand");
    apply(new DeleteWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignInputToWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handling command AssignInputToWindDynamicsLookupTableCommand");

    if (input != null && input.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Input already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignInputToWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInputFromWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInputFromWindDynamicsLookupTableCommand");

    if (input == null) throw new ProcessingException("Input already has nothing assigned.");

    apply(
        new UnAssignInputFromWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId()));
  }

  @CommandHandler
  public void handle(AssignOutputToWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handling command AssignOutputToWindDynamicsLookupTableCommand");

    if (output != null && output.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Output already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignOutputToWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOutputFromWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOutputFromWindDynamicsLookupTableCommand");

    if (output == null) throw new ProcessingException("Output already has nothing assigned.");

    apply(
        new UnAssignOutputFromWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId()));
  }

  @CommandHandler
  public void handle(AssignSequenceToWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handling command AssignSequenceToWindDynamicsLookupTableCommand");

    if (sequence != null
        && sequence.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Sequence already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignSequenceToWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSequenceFromWindDynamicsLookupTableCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSequenceFromWindDynamicsLookupTableCommand");

    if (sequence == null) throw new ProcessingException("Sequence already has nothing assigned.");

    apply(
        new UnAssignSequenceFromWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand");

    if (windDynamicsLookupTable.contains(command.getAddTo()))
      throw new ProcessingException(
          "WindDynamicsLookupTable already contains an entity with id "
              + command.getAddTo().getWindDynamicsLookupTableId());

    apply(
        new AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand");

    if (!windDynamicsLookupTable.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "WindDynamicsLookupTable does not contain an entity with id "
              + command.getRemoveFrom().getWindDynamicsLookupTableId());

    apply(
        new RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent(
            command.getWindDynamicsLookupTableId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing CreateWindDynamicsLookupTableEvent");
    this.windDynamicsLookupTableId = event.getWindDynamicsLookupTableId();
    this.lookupTableFunctionType = event.getLookupTableFunctionType();
  }

  @EventSourcingHandler
  void on(UpdateWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.input = event.getInput();
    this.lookupTableFunctionType = event.getLookupTableFunctionType();
    this.output = event.getOutput();
    this.sequence = event.getSequence();
    this.windDynamicsLookupTable = event.getWindDynamicsLookupTable();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignInputToWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing AssignInputToWindDynamicsLookupTableEvent");
    this.input = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInputFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing UnAssignInputFromWindDynamicsLookupTableEvent");
    this.input = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOutputToWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing AssignOutputToWindDynamicsLookupTableEvent");
    this.output = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOutputFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing UnAssignOutputFromWindDynamicsLookupTableEvent");
    this.output = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSequenceToWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing AssignSequenceToWindDynamicsLookupTableEvent");
    this.sequence = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSequenceFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing UnAssignSequenceFromWindDynamicsLookupTableEvent");
    this.sequence = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent");
    this.windDynamicsLookupTable.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("Event sourcing RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent");
    this.windDynamicsLookupTable.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windDynamicsLookupTableId;

  private WindLookupTableFunctionKind lookupTableFunctionType;
  private Simple_Float input = null;
  private Simple_Float output = null;
  private IntegerProxy sequence = null;
  private Set<WindDynamicsLookupTable> windDynamicsLookupTable = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(WindDynamicsLookupTableAggregate.class.getName());
}
