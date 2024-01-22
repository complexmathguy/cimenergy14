package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for Command as outlined for the CQRS pattern, all write responsibilities
 * related to Command are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CommandAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CommandAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CommandAggregate(CreateCommandCommand command) throws Exception {
    LOGGER.info("Handling command CreateCommandCommand");
    CreateCommandEvent event = new CreateCommandEvent(command.getCommandId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCommandCommand command) throws Exception {
    LOGGER.info("handling command UpdateCommandCommand");
    UpdateCommandEvent event =
        new UpdateCommandEvent(
            command.getCommandId(),
            command.getNormalValue(),
            command.getValue(),
            command.getCommands(),
            command.getCommand());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCommandCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCommandCommand");
    apply(new DeleteCommandEvent(command.getCommandId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNormalValueToCommandCommand command) throws Exception {
    LOGGER.info("Handling command AssignNormalValueToCommandCommand");

    if (normalValue != null
        && normalValue.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "NormalValue already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignNormalValueToCommandEvent(command.getCommandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNormalValueFromCommandCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNormalValueFromCommandCommand");

    if (normalValue == null)
      throw new ProcessingException("NormalValue already has nothing assigned.");

    apply(new UnAssignNormalValueFromCommandEvent(command.getCommandId()));
  }

  @CommandHandler
  public void handle(AssignValueToCommandCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToCommandCommand");

    if (value != null && value.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignValueToCommandEvent(command.getCommandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromCommandCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromCommandCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromCommandEvent(command.getCommandId()));
  }

  @CommandHandler
  public void handle(AssignCommandToCommandCommand command) throws Exception {
    LOGGER.info("Handling command AssignCommandToCommandCommand");

    if (command != null && command.getCommandId() == command.getAssignment().getCommandId())
      throw new ProcessingException(
          "Command already assigned with id " + command.getAssignment().getCommandId());

    apply(new AssignCommandToCommandEvent(command.getCommandId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCommandFromCommandCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCommandFromCommandCommand");

    if (command == null) throw new ProcessingException("Command already has nothing assigned.");

    apply(new UnAssignCommandFromCommandEvent(command.getCommandId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignCommandsToCommandCommand command) throws Exception {
    LOGGER.info("Handling command AssignCommandsToCommandCommand");

    if (commands.contains(command.getAddTo()))
      throw new ProcessingException(
          "Commands already contains an entity with id " + command.getAddTo().getCommandId());

    apply(new AssignCommandsToCommandEvent(command.getCommandId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveCommandsFromCommandCommand command) throws Exception {
    LOGGER.info("Handling command RemoveCommandsFromCommandCommand");

    if (!commands.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Commands does not contain an entity with id " + command.getRemoveFrom().getCommandId());

    apply(new RemoveCommandsFromCommandEvent(command.getCommandId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCommandEvent event) {
    LOGGER.info("Event sourcing CreateCommandEvent");
    this.commandId = event.getCommandId();
  }

  @EventSourcingHandler
  void on(UpdateCommandEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.normalValue = event.getNormalValue();
    this.value = event.getValue();
    this.commands = event.getCommands();
    this.command = event.getCommand();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNormalValueToCommandEvent event) {
    LOGGER.info("Event sourcing AssignNormalValueToCommandEvent");
    this.normalValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNormalValueFromCommandEvent event) {
    LOGGER.info("Event sourcing UnAssignNormalValueFromCommandEvent");
    this.normalValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValueToCommandEvent event) {
    LOGGER.info("Event sourcing AssignValueToCommandEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromCommandEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromCommandEvent");
    this.value = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCommandToCommandEvent event) {
    LOGGER.info("Event sourcing AssignCommandToCommandEvent");
    this.command = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCommandFromCommandEvent event) {
    LOGGER.info("Event sourcing UnAssignCommandFromCommandEvent");
    this.command = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignCommandsToCommandEvent event) {
    LOGGER.info("Event sourcing AssignCommandsToCommandEvent");
    this.commands.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveCommandsFromCommandEvent event) {
    LOGGER.info("Event sourcing RemoveCommandsFromCommandEvent");
    this.commands.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID commandId;

  private IntegerProxy normalValue = null;
  private IntegerProxy value = null;
  private Set<Command> commands = new HashSet<>();
  private Command command = null;

  private static final Logger LOGGER = Logger.getLogger(CommandAggregate.class.getName());
}
